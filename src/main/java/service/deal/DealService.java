package service.deal;

import connection.ConnectionCMS;
import model.Deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DealService implements IDealService {
    private static final String FIND_ALL_DEAL = "SELECT deal_id,deal_code,deal_name,deal_percent,deal_startDate, deal_endDate, deal_description,deal_image, status FROM deal;";
    private static final String FIND_BY_ID = "SELECT * FROM DEAL WHERE deal_id=?";
    private static final String INSERT_DEAL = "INSERT INTO deal(deal_id,deal_code,deal_name,deal_percent,deal_startDate, deal_endDate, deal_description,deal_image, status) VALUE (?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_DEAL = "DELETE FROM deal WHERE deal_id=?";
    private static final String UPDATE_DEAL = "UPDATE DEAL SET deal_id=?,deal_code=?,deal_name=?,deal_percent=?,deal_startDate=?, deal_endDate=?, deal_description=?,deal_image=?, status=?";
    Connection connection= ConnectionCMS.getConnection();
    @Override
    public List<Deal> fillAll() {
        List<Deal> dealList= new ArrayList<>();
        try(PreparedStatement ptmt= connection.prepareStatement(FIND_ALL_DEAL)){
            System.out.println(ptmt);
            ResultSet rs= ptmt.executeQuery();
            while (rs.next()){
                int id= rs.getInt(1);
                String code= rs.getString(2);
                String name= rs.getString(3);
                double percent = rs.getDouble(4);
                Date startDate = rs.getDate(5);
                Date endDate = rs.getDate(6);
                String description= rs.getString(7);
                String image= rs.getString(8);
                int status = rs.getInt(9);
                dealList.add(new Deal(id, status, percent, code, name, description, image, startDate, endDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dealList;
    }

    @Override
    public Deal findById(int id) {
        Deal deal=null;
        try(PreparedStatement ptmt= connection.prepareStatement(FIND_BY_ID)){
            ptmt.setInt(1,id);
            System.out.println(ptmt);
            ResultSet rs= ptmt.executeQuery();
            while (rs.next()){
                String code= rs.getString(2);
                String name= rs.getString(3);
                String description= rs.getString(7);
                String image= rs.getString(8);
                deal= new Deal(id,code,name,description,image);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deal;
    }

    @Override
    public void insert(Deal p) {
        Deal deal=null;
        try(PreparedStatement ptmt= connection.prepareStatement(INSERT_DEAL)){
            ptmt.setString(1,p.getCode());
            ptmt.setString(2,p.getName());
            ptmt.setDouble(3,p.getPercent());
            ptmt.setDate(4, (java.sql.Date) p.getStartDate());
            ptmt.setDate(5, (java.sql.Date) p.getEndDate());
            ptmt.setString(6,p.getDescription());
            ptmt.setString(6,p.getImage());
            ptmt.setInt(7,p.getStatus());
            System.out.println(ptmt);
            ptmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean update;
        try(PreparedStatement ptmt= connection.prepareStatement(DELETE_DEAL)){
            System.out.println(ptmt);
            ptmt.setInt(1,id);
            update= ptmt.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return update;
    }

    @Override
    public boolean edit(int id, Deal p) throws SQLException {
        boolean update;
        try(PreparedStatement ptmt= connection.prepareStatement(UPDATE_DEAL)){
            System.out.println(ptmt);
            ptmt.setString(1,p.getCode());
            ptmt.setString(2,p.getName());
            ptmt.setDouble(3,p.getPercent());
            ptmt.setDate(4, (java.sql.Date) p.getStartDate());
            ptmt.setDate(5, (java.sql.Date) p.getEndDate());
            ptmt.setString(6,p.getDescription());
            ptmt.setString(6,p.getImage());
            ptmt.setInt(7,p.getStatus());
            update= ptmt.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return update;
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
