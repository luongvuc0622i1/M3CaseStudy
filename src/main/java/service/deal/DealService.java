package service.deal;

import connection.ConnectionCMS;
import model.Deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealService implements IDealService {
    private static final String FIND_ALL_DEAL = "SELECT deal_id,deal_code,deal_name,deal_description,deal_image FROM deal;";
    private Connection c = ConnectionCMS.getConnection();

    @Override
    public List<Deal> fillAll() {
        List<Deal> deals = new ArrayList<>();
        try(PreparedStatement ps= c.prepareStatement(FIND_ALL_DEAL)){
            System.out.println(ps);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                int id= rs.getInt(1);
                String code= rs.getString(2);
                String name= rs.getString(3);
                String description= rs.getString(4);
                String image= rs.getString(5);
                Deal deal = new Deal(id, code, name, description, image);
                deals.add(deal);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return deals;
    }

    @Override
    public Deal findById(int id) {
        return null;
    }

    @Override
    public void insert(Deal p) {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean edit(int id, Deal t) throws SQLException {
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
