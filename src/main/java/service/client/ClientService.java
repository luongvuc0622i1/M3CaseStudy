package service.client;

import connection.ConnectionCMS;
import model.Admin;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements IClientService {
    private static final String FIND_ALL_CLIENT = "SELECT * FROM admin;";
    private Connection c = ConnectionCMS.getConnection();
    @Override
    public List<Client> fillAll() {
        List<Client> clients = new ArrayList<>();
        try {
            PreparedStatement ps= c.prepareStatement(FIND_ALL_CLIENT);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                int id= rs.getInt("admin_id");
                String name= rs.getString("admin_name");
                String account= rs.getString("admin_account");
                String password= rs.getString("admin_password");
                String image= rs.getString("admin_image");
//                Client client = new Client(id, name, account, password, image);
//                int id, String code, String name, String phone, String address, String email, String account, String password, int status
//                clients.add(client);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return clients;
    }

    @Override
    public Client findById(int id) {
        return null;
    }

    @Override
    public void insert(Client p) {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
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
