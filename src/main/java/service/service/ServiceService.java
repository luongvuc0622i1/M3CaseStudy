package service.service;

import connection.ConnectionCMS;
import model.Client;
import model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceService implements IServiceService {
    private static final String FIND_ALL_SERVICE = "SELECT * FROM service;";
    private Connection c = ConnectionCMS.getConnection();
    @Override
    public List<Service> fillAll() {
        List<Service> services = new ArrayList<>();
        try {
            PreparedStatement ps= c.prepareStatement(FIND_ALL_SERVICE);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("client_id");
                int price = rs.getInt("client_code");
                String name = rs.getString("client_name");
                String description = rs.getString("client_phone");
                Service service = new Service(id, price, name, description);
                services.add(service);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return services;
    }

    @Override
    public Service findById(int id) {
        return null;
    }

    @Override
    public void insert(Service p) {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean edit(int id, Service t) throws SQLException {
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
