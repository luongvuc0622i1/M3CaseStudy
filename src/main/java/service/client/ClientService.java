package service.client;

import connection.ConnectionCMS;
import model.Admin;
import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements IClientService {
    private static final String FIND_ALL_CLIENT = "SELECT * FROM client;";
    private static final String DELETE_CLIENT_SQL="DELETE FROM client WHERE client_id=?";
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
                int status = resultSet.getInt("client_status");
                Client client = new Client(id, code, name, phone, address, email, account, password, status);
                clients.add(client);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return clients;
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
                int status = resultSet.getInt("client_status");
                client = new Client(id, code, name, phone, address, email, account, password, status);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return client;
    }
    
    @Override
    public void insert(Client p) {
        String query ="{CALL insert_client(?,?,?,?,?,?,?,?)}";
        try(Connection connection=ConnectionCMS.getConnection();
            CallableStatement callableStatement=connection.prepareCall(query);){
            callableStatement.setString(1,p.getCode());
            callableStatement.setString(2,p.getName());
            callableStatement.setString(3,p.getAccount());
            callableStatement.setString(4,p.getPassword());
            callableStatement.setString(5,p.getAddress());
            callableStatement.setString(6,p.getEmail());
            callableStatement.setString(7,p.getPhone());
            callableStatement.setInt(8,p.getStatus());
            callableStatement.executeUpdate();

        }catch (SQLException e){
            printSQLException(e);
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
}
