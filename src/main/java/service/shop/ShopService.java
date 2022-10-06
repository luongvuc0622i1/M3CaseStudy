package service.shop;

import connection.ConnectionCMS;
import model.Admin;
import model.Service;
import model.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopService implements IShopService {
    private static final String FIND_ALL_SHOP = "SELECT * FROM shop;";
    private Connection c = ConnectionCMS.getConnection();
    @Override
    public List<Shop> fillAll() {
        List<Shop> shops = new ArrayList<>();
        try {
            PreparedStatement ps= c.prepareStatement(FIND_ALL_SHOP);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("shop_id");
                String code = rs.getString("shop_code");
                String name = rs.getString("shop_name");
                String email = rs.getString("shop_email");
                String phone = rs.getString("shop_phone");
                String address = rs.getString("shop_address");
                String account = rs.getString("shop_account");
                String password = rs.getString("shop_password");
                String image = rs.getString("shop_image");
                Time open = rs.getTime("shop_open");
                Time close = rs.getTime("shop_close");
                int service_id = rs.getInt("service_id");
                Service service = null;
                String description = rs.getString("shop_description");
                int status = rs.getInt("status");
//                for (Service s : services) {
//                    if (s.getId() == service_id) {
//                        service = s;
//                    }
//                }
                Shop shop = new Shop(id, status, open, close, code, name, email, phone, address, account, password, image, description, service);
                shops.add(shop);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return shops;
    }

    @Override
    public Shop findById(int id) {
        return null;
    }

    @Override
    public void insert(Shop p) {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean edit(int id, Shop t) throws SQLException {
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
