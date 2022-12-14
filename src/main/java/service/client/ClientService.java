package service.client;

import connection.ConnectionCMS;
import model.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements IClientService {
    private static final String SELECT_CLIENT_BY_ID="SELECT client_account,client_password FROM client WHERE client_id=?;";
    private static final String EDIT_CLIENT_PASSWORD_SQL="UPDATE client set client_password=?; ";
    private static final String EDIT_CLIENT_SQL="UPDATE client set client_code=?,client_name=?,client_phone=?,client_address=?,client_email=?,client_account=?,client_password=?,client_status=?;";
    private static final String FIND_ALL_CLIENT = "SELECT * FROM client;";
    private static final String DELETE_CLIENT_SQL="DELETE FROM client WHERE client_id=?";
    private static final String INSERT_CLIENT_SQL = "INSERT INTO client (client_name, client_phone, client_address, client_email, client_account, client_password, status) VALUES (?,?,?,?,?,?,?);";
    private static final String BLOCK_CLIENT_BY_ID = "CALL blockClientById(?);";
    private static final String UNBLOCK_CLIENT_BY_ID = "CALL unblockClientById(?);";
    private Connection c = ConnectionCMS.getConnection();
    @Override
    public List<Client> fillAll() {
        List<Client> clients = new ArrayList<>();
        try {
            PreparedStatement ps= c.prepareStatement(FIND_ALL_CLIENT);
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("client_id");
                String code = resultSet.getString("client_code");
                String name = resultSet.getString("client_name");
                String phone = resultSet.getString("client_phone");
                String address = resultSet.getString("client_address");
                String email = resultSet.getString("client_email");
                String account = resultSet.getString("client_account");
                String password = resultSet.getString("client_password");
                int status = resultSet.getInt("status");
                Client client = new Client(id, code, name, phone, address, email, account, password, status);
                clients.add(client);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return clients;
    }
    public Client selectClient(int id){
        Client client=null;
        try(Connection connection=ConnectionCMS.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_CLIENT_BY_ID);){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String account=resultSet.getString("client_account");
                String password=resultSet.getString("client_password");
                client=new Client(account,password);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return client;
    }

    @Override
    public Client findById(int id) {
        Client client=null;
        String query="{CALL get_client_id}";
        try(Connection connection=ConnectionCMS.getConnection();
            CallableStatement callableStatement=connection.prepareCall(query);){
            callableStatement.setInt(1,id);
            ResultSet resultSet=callableStatement.executeQuery();
            while (resultSet.next()){
                String code = resultSet.getString("client_code");
                String name = resultSet.getString("client_name");
                String phone = resultSet.getString("client_phone");
                String address = resultSet.getString("client_address");
                String email = resultSet.getString("client_email");
                String account = resultSet.getString("client_account");
                String password = resultSet.getString("client_password");
                int status = resultSet.getInt("status");
                client = new Client(id, code, name, phone, address, email, account, password, status);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return client;
    }

    @Override
    public void insert(Client client) {
        try (PreparedStatement preparedStatement = c.prepareStatement(INSERT_CLIENT_SQL)) {
            c.setAutoCommit(false);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getPhone());
            preparedStatement.setString(3, client.getAddress());
            preparedStatement.setString(4, client.getEmail());
            preparedStatement.setString(5, client.getAccount());
            preparedStatement.setString(6, client.getPassword());
            preparedStatement.setInt(7, client.getStatus());
            preparedStatement.executeUpdate();
            c.commit();
        } catch (SQLException throwables) {
            try {
                c.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try(Connection connection=ConnectionCMS.getConnection();
            PreparedStatement statement=connection.prepareStatement(DELETE_CLIENT_SQL);){
            statement.setInt(1,id);
            rowDeleted=statement.executeUpdate()>0;
        }
        return rowDeleted;
    }

    @Override
    public boolean edit(int id, Client t) throws SQLException {
        return false;
    }
    public boolean EditPassword(Client client)throws SQLException{
        boolean rowEditPass;
        try(Connection connection=ConnectionCMS.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(EDIT_CLIENT_PASSWORD_SQL);){
            preparedStatement.setString(1,client.getPassword());
            rowEditPass=preparedStatement.executeUpdate()>0;
        }
        return rowEditPass;
    }
    public boolean EditClient(Client client) throws SQLException {
        boolean rowEdit;
        try(Connection connection=ConnectionCMS.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(EDIT_CLIENT_SQL);){
            preparedStatement.setString(1,client.getCode());
            preparedStatement.setString(2,client.getName());
            preparedStatement.setString(3,client.getPhone());
            preparedStatement.setString(4,client.getAddress());
            preparedStatement.setString(5,client.getEmail());
            preparedStatement.setString(6,client.getAccount());
            preparedStatement.setString(7,client.getPassword());
            preparedStatement.setInt(8,client.getStatus());
            preparedStatement.setInt(9,client.getId());
            rowEdit=preparedStatement.executeUpdate()>0;
        }
        return rowEdit;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public Client blockClientById(int id) {
        Client client = null;

        try (PreparedStatement preparedStatement = c.prepareStatement(BLOCK_CLIENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println(preparedStatement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return client;
    }

    public Client unblockClientById(int id) {
        Client client = null;

        try (PreparedStatement preparedStatement = c.prepareStatement(UNBLOCK_CLIENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println(preparedStatement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return client;
    }

    @Override
    public List<Client> fillAllForAdmin() {
        List<Client> clients = new ArrayList<>();
        try {
            c.setAutoCommit(false);
            PreparedStatement ps = c.prepareStatement(FIND_ALL_CLIENT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("client_id");
                String code = rs.getString("client_code");
                String name = rs.getString("client_name");
                String phone = rs.getString("client_phone");
                String address = rs.getString("client_address");
                String email = rs.getString("client_email");
                String account = rs.getString("client_account");
                String password = rs.getString("client_password");
                int status = rs.getInt("status");
                Client client = new Client(id, code, name, phone, address, email, account, password, status);
                clients.add(client);
            }
            c.commit();
        } catch (SQLException throwables) {
            try {
                c.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
        return clients;
    }


}