package service.food;

import connection.ConnectionCMS;
<<<<<<< HEAD

import java.sql.Connection;

public class FoodService {
=======
import model.Food;
import service.tag.TagService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FoodService implements IFoodService{
>>>>>>> ed5347bd4fa90529c02b9a720896e0b9a5fe6f95

    private static final String SELECT_FOOD_BY_ID_SHOP = "SELECT * FROM food WHERE shop_id=?";
    private static final String SELECT_FOOD_BY_ID_DEAL = "SELECT * FROM food WHERE deal_id=?";
    private static final String SELECT_FOOD_BY_ID_TAGS = "SELECT * FROM food WHERE tags_id=?";
    Connection connection = ConnectionCMS.getConnection();
<<<<<<< HEAD

=======
    TagService tagService = new TagService();

    private static final String SELECT_ALL_FOOD = "SELECT * FROM food WHERE status = 1;";
    private static final String SELECT_FOOD_BY_ID = "SELECT * FROM food WHERE food_id=?";
    private static final String SELECT_FOOD_BY_NAME = "SELECT * FROM food WHERE food_name like ?";

    private static final String INSERT_FOOD ="INSERT INTO food (shop_id, tags_id, deal_id," +
            "food_name, food_price, food_description, food_image, food_cooktime, food_daycreate, food_lastupdate, food_status) VALUE (?,?,?,?,?,?,?,?,?,?,?);";

    private static final String DELETE_food = "DELETE FROM food WHERE food_id =? ;";
    private static final String UPDATE_food = "UPDATE food SET shop_id =?, tag_id =?, deal_id =?," +
            "food_name = ?, food_price =?, food_description =?, food_image =?, food_cooktime=?, food_daycreate=?, food_lastupdate=?, food_status=? WHERE food_id =?;";

    public static final String INSERT_NEW_FOOD_TAG = "INSERT INTO food_tag (food_id, tag_id) VALUE (?, ?);";

    @Override
    public List<Food> fillAll() {
        return null;
    }

    @Override
    public Food findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean edit(int id, Food t) throws SQLException {
        return false;
    }

    @Override
    public void insert(Food food) {

    }

    @Override
    public void save(Food f, int[] tag) {

    }

    @Override
    public List<Food> selectFoodByName(String name) {
        return null;
    }

    @Override
    public List<Food> findAllFoodByIdShop(int id) {
        return null;
    }

    @Override
    public List<Food> findAllFoodByIdDeal(int id) {
        return null;
    }
>>>>>>> ed5347bd4fa90529c02b9a720896e0b9a5fe6f95

    @Override
    public List<Food> findAllFoodByIdTag(int id) {
        return null;
    }
}
