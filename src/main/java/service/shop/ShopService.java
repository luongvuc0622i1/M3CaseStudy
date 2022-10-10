package service.shop;

import connection.ConnectionCMS;
import model.Admin;
import model.Service;
import model.Shop;
import service.admin.AdminService;
import service.admin.IAdminService;
import service.service.IServiceService;
import service.service.ServiceService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopService implements IShopService {
    private static final String ADD_SHOP_SQL = "insert into shop(shop_code, shop_name, shop_email, shop_phone, shop_address, shop_account, shop_password,shop_image,shop_open,shop_close,service_id,shop_description,status) values (?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?)";
    private static final String SELECT_SHOP_BY_ID = "select * from shop where shop_id = ?";
    private static final String SELECT_ALL_SHOP = "select * from shop";
    private static final String DELETE_SHOP_SQL = "UPDATE shop SET status = 0 where shop_id =?";
    private static final String UPDATE_SHOP_SQL = "update shop set shop_code = ?, shop_name = ?, shop_email = ?, shop_phone = ?, shop_address = ?, shop_account = ?, shop_password = ? , shop_image=?, shop_open=?, shop_close=?, service_id=?,shop_description=?, status=? where shop_id = ?";
    private static final String SELECT_SHOP_BY_NAME = "update shop set shop_code = ?, shop_name = ?, shop_email = ?, shop_phone = ?, shop_address = ?, shop_account = ?, shop_password = ? , shop_image=?, shop_open=?, shop_close=?, service_id=?,shop_description=?, status=? where shop_name = ?";
    private static final String INSERT_SHOP_SQL = "insert into shop(shop_name, shop_email, shop_phone, shop_address, shop_account, shop_password, shop_image, shop_open, shop_close, service_id, shop_description, status) values (?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String BLOCK_SHOP_BY_ID = "CALL blockShopById(?);";
    private static final String UNBLOCK_SHOP_BY_ID = "CALL unblockShopById(?);";

    Connection connection = ConnectionCMS.getConnection();
    private IServiceService serviceService = new ServiceService();

    @Override
    public List<Shop> fillAll() {
        List<Shop> shops = new ArrayList<>();
        List<Service> services = serviceService.fillAll();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_SHOP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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
                for (Service s : services) {
                    if (s.getId() == service_id) {
                        service = s;
                    }
                }
                String description = rs.getString("shop_description");
                int status = rs.getInt("status");
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
        Shop shop = null;
        List<Service> services = serviceService.fillAll();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SHOP_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
//                int shop_id = rs.getInt("shop_id");
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
                for (Service s : services) {
                    if (s.getId() == service_id) {
                        service = s;
                    }
                }
                String description = rs.getString("shop_description");
                int status = rs.getInt("status");
                shop = new Shop(status, open, close, code, name, email, phone, address, account, password, image, description, service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shop;
    }


    @Override
    public void insert(Shop shop) {
        System.out.println(ADD_SHOP_SQL);
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_SHOP_SQL)) {
            preparedStatement.setString(1, shop.getCode());
            preparedStatement.setString(2, shop.getName());
            preparedStatement.setString(3, shop.getEmail());
            preparedStatement.setString(4, shop.getPhone());
            preparedStatement.setString(5, shop.getAddress());
            preparedStatement.setString(6, shop.getAccount());
            preparedStatement.setString(7, shop.getPassword());
            preparedStatement.setString(8, shop.getImage());
            preparedStatement.setTime(9, shop.getOpen());
            preparedStatement.setTime(10, shop.getClose());
            preparedStatement.setInt(11, shop.getServiceId());
            preparedStatement.setString(12, shop.getDescription());
            preparedStatement.setInt(13, shop.getStatus());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertDefaul(Shop shop) {
        System.out.println(INSERT_SHOP_SQL);
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SHOP_SQL)) {
            preparedStatement.setString(1, shop.getName());
            preparedStatement.setString(2, shop.getEmail());
            preparedStatement.setString(3, shop.getPhone());
            preparedStatement.setString(4, shop.getAddress());
            preparedStatement.setString(5, shop.getAccount());
            preparedStatement.setString(6, shop.getPassword());
            preparedStatement.setString(7, shop.getImage());
            preparedStatement.setTime(8, shop.getOpen());
            preparedStatement.setTime(9, shop.getClose());
            preparedStatement.setInt(10, shop.getServiceId());
            preparedStatement.setString(11, shop.getDescription());
            preparedStatement.setInt(12, shop.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SHOP_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean edit(int id, Shop shop) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SHOP_SQL)) {
//            statement.setInt(1, shop.getShop_id());
            preparedStatement.setString(1, shop.getCode());
            preparedStatement.setString(2, shop.getName());
            preparedStatement.setString(3, shop.getEmail());
            preparedStatement.setString(4, shop.getPhone());
            preparedStatement.setString(5, shop.getAddress());
            preparedStatement.setString(6, shop.getAccount());
            preparedStatement.setString(7, shop.getPassword());
            preparedStatement.setString(8, shop.getImage());
            preparedStatement.setTime(9, shop.getOpen());
            preparedStatement.setTime(10, shop.getClose());
            preparedStatement.setInt(11, shop.getServiceId());
            preparedStatement.setString(12, shop.getDescription());
            preparedStatement.setInt(13, shop.getStatus());
            preparedStatement.setInt(14, id);

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
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

    @Override
    public Shop selectShopByName(String name_shop) {
        Shop shop = null;
        List<Service> services = serviceService.fillAll();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SHOP_BY_NAME)) {
            preparedStatement.setString(1, name_shop);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
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
                for (Service s : services) {
                    if (s.getId() == service_id) {
                        service = s;
                    }
                }
                String description = rs.getString("shop_description");
                int status = rs.getInt("status");
                shop = new Shop(status, open, close, code, name, email, phone, address, account, password, image, description, service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shop;
    }

    public Shop blockShopById(int id) {
        Shop shop = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(BLOCK_SHOP_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return shop;
    }

    public Shop unblockShopById(int id) {
        Shop shop = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(UNBLOCK_SHOP_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return shop;
    }

}
