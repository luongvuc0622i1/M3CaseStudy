package service.bill;

import connection.ConnectionCMS;
import model.Bill;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillService implements IBill{
    private static final String INSERT_BILL_SQL = "INSERT INTO bill (fool_code,bill_date,bill_totalCost,client_id,shop_id,status) VALUES (?, ?, ?,?,?);";

    private static final String FIND_ALL_BILL = "SELECT * FROM bill;";
    private Connection c = ConnectionCMS.getConnection();
    private static final String DELETE_BILL_SQL="DELETE FROM bill WHERE bill_id=?;";

    @Override
    public List<Bill> fillAll() {
        List<Bill> bills = new ArrayList<>();
        try {
            PreparedStatement ps= c.prepareStatement(FIND_ALL_BILL);
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next()){
                String code = resultSet.getString("bill_code");
                Date date = resultSet.getDate("bill_date");
                Double totalCost = resultSet.getDouble("bill_totalCost");
                int clientId = resultSet.getInt("client_id");
                int shopId = resultSet.getInt("shop_id");
                int status = resultSet.getInt("client_status");
                Bill bill = new Bill(code, date,totalCost,clientId,shopId, status);
                bills.add(bill);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bills;
    }

    @Override
    public Bill findById(int id) {
        return null;
    }

    @Override
    public void insert(Bill p) {
        System.out.println(INSERT_BILL_SQL);
        try(Connection c=ConnectionCMS.getConnection();
            PreparedStatement preparedStatement=c.prepareStatement(INSERT_BILL_SQL); ){
            preparedStatement.setString(1,p.getCode());
            preparedStatement.setDate(2, (java.sql.Date) p.getDate());
            preparedStatement.setDouble(3,p.getTotalCost());
            preparedStatement.setInt(4,p.getClient_id());
            preparedStatement.setInt(5,p.getShop_id());
            preparedStatement.setInt(6,p.getStatus());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean Deleted;
        try(Connection connection=ConnectionCMS.getConnection();
            PreparedStatement statement=connection.prepareStatement(DELETE_BILL_SQL);){
            statement.setInt(1,id);
            Deleted=statement.executeUpdate()>0;
        }
        return Deleted;
    }

    @Override
    public boolean edit(int id, Bill t) throws SQLException {
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
