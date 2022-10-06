package service.food;

import connection.ConnectionCMS;

import java.sql.Connection;

public class FoodService {

    private static final String SELECT_FOOD_BY_ID_SHOP = "SELECT * FROM food WHERE shop_id=?";
    private static final String SELECT_FOOD_BY_ID_DEAL = "SELECT * FROM food WHERE deal_id=?";
    private static final String SELECT_FOOD_BY_ID_TAGS = "SELECT * FROM food WHERE tags_id=?";
    Connection connection = ConnectionCMS.getConnection();


}
