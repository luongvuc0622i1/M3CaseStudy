package service.billDetail;

import connection.ConnectionCMS;
import model.Bill;
import model.BillDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillDetailService implements IBillDetail{
    BillDetail billDetail;
    private static final String INSERT_BILL_DATAIL_SQL = "INSERT INTO bill_detail (bill_id,fool_id,quantity,price,status) VALUES (?, ?, ?,?,?);";

    private static final String FIND_ALL_BILL_DETAIL = "SELECT * FROM bill_detail;";
    private Connection c = ConnectionCMS.getConnection();

    private static final String DELETE_BILL_DETAIL_SQL="DELETE FROM bill_detail WHERE bill_detail_id=?;";
    @Override
    public List<model.BillDetail> fillAll() {
        List<BillDetail> billDetailList = new ArrayList<>();
        try {
            PreparedStatement ps= c.prepareStatement(FIND_ALL_BILL_DETAIL);
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next()){
                int quantity = resultSet.getInt("quantity");
                Double price = resultSet.getDouble("price");
                int foodId = resultSet.getInt("id");
                int billId = resultSet.getInt("id");
                int status = resultSet.getInt("client_status");
                BillDetail billDetail =new BillDetail (billId,foodId,quantity,price, status);
                billDetailList.add(billDetail);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return billDetailList;
    }

    @Override
    public model.BillDetail findById(int id) {
        return null;
    }

    @Override
    public void insert(model.BillDetail p) {
        System.out.println(INSERT_BILL_DATAIL_SQL);
        try(Connection c=ConnectionCMS.getConnection();
            PreparedStatement preparedStatement=c.prepareStatement(INSERT_BILL_DATAIL_SQL); ){
            preparedStatement.setInt(1,p.getBill().getId());
            preparedStatement.setInt(2,p.getFood().getId());
            preparedStatement.setInt(3,p.getQuantity());
            preparedStatement.setDouble(4,p.getPrice());
            preparedStatement.setInt(5,p.getStatus());
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
            PreparedStatement statement=connection.prepareStatement(DELETE_BILL_DETAIL_SQL);){
            statement.setInt(1,id);
            Deleted=statement.executeUpdate()>0;
        }
        return Deleted;
    }

    @Override
    public boolean edit(int id, model.BillDetail t) throws SQLException {
        return false;
    }

    @Override
    public void add(model.BillDetail billDetail, int[] billDetails) {

        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            c=ConnectionCMS.getConnection();
            c.setAutoCommit(false);
            preparedStatement=c.prepareStatement(INSERT_BILL_DATAIL_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,billDetail.getBill().getId());
            preparedStatement.setInt(2,billDetail.getFood().getId());
            preparedStatement.setInt(3,billDetail.getQuantity());
            preparedStatement.setDouble(4,billDetail.getPrice());
            preparedStatement.setInt(5,billDetail.getStatus());
            int rowAffected=preparedStatement.executeUpdate();
            resultSet=preparedStatement.getGeneratedKeys();
            int billDetailId=0;
            int billDetailId_food_id=0;
            if(resultSet.next())
                billDetailId=resultSet.getInt(1);
            billDetailId_food_id=resultSet.getInt(2);
            if(rowAffected==1){
                String sqlPivot ="INSERT INTO bill_detail(bill_detail_id,bill_id,fool_id)"+"VALUE(?,?,?)";
                preparedStatement=c.prepareStatement(sqlPivot);
                for (int billDetails1: billDetails) {
                    preparedStatement.setInt(1,billDetailId);
                    preparedStatement.setInt(2,billDetailId_food_id);
                    preparedStatement.setInt(3,billDetails1);
                    preparedStatement.executeUpdate();
                }
                c.commit();;
            }else {
                c.rollback();
            }
        }catch (SQLException e){
            try{
                if(c!=null){
                    c.rollback();
                }
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
            System.out.println(e.getMessage());
        }finally {
            try{
                if(resultSet!=null) resultSet.close();
                if(preparedStatement!=null) preparedStatement.close();
                if(c!=null) c.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }

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

