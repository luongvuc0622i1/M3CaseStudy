package service.food;

import connection.ConnectionCMS;
import model.Food;
import model.Tag;
import service.tag.TagService;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



    public class FoodService implements IFoodService {


        private static final String SELECT_FOOD_BY_ID_SHOP = "SELECT * FROM food WHERE shop_id=?";
        private static final String SELECT_FOOD_BY_ID_DEAL = "SELECT * FROM food WHERE deal_id=?";
        private static final String SELECT_FOOD_BY_ID_TAGS = "SELECT * FROM food WHERE tags_id=?";
        Connection connection = ConnectionCMS.getConnection();

        TagService tagService = new TagService();

        private static final String SELECT_ALL_FOOD = "SELECT * FROM food WHERE status = 1;";
        private static final String SELECT_FOOD_BY_ID = "SELECT * FROM food WHERE food_id=?";
        private static final String SELECT_FOOD_BY_NAME = "SELECT * FROM food WHERE food_name like ?";

        private static final String INSERT_FOOD = "INSERT INTO food (shop_id, tags_id, deal_id," +
                "food_name, food_price, food_description, food_image, food_cooktime, food_daycreate, food_lastupdate, food_status) VALUE (?,?,?,?,?,?,?,?,?,?,?);";

        private static final String DELETE_food = "DELETE FROM food WHERE food_id =? ;";
        private static final String UPDATE_food = "UPDATE food SET shop_id =?, tag_id =?, deal_id =?," +
                "food_name = ?, food_price =?, food_description =?, food_image =?, food_cooktime=?, food_daycreate=?, food_lastupdate=?, food_status=? WHERE food_id =?;";

        public static final String INSERT_NEW_FOOD_TAG = "INSERT INTO food_tag (food_id, tag_id) VALUE (?, ?);";

        @Override
        public List<Food> fillAll() {
            List<Food> foodList = new ArrayList<>();
            try (
                    PreparedStatement statement = connection.prepareStatement(SELECT_ALL_FOOD);) {
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("food_id");
                    int shop_id = resultSet.getInt("shop_id");
                    int tag_id = resultSet.getInt("tag_id");
                    int deal_id = resultSet.getInt("deal_id");
                    String name = resultSet.getString("food_name");
                    double price = resultSet.getDouble("food_price");
                    String description = resultSet.getString("food_description");
                    String image = resultSet.getString("food_image");
                    Time cookTime = resultSet.getTime("food_cooktime");
                    Date dayCreate = resultSet.getDate("food_daycreate");
                    Date lastUpdate = resultSet.getDate("food_lastupdate");
                    int status = resultSet.getInt("status");
                    List<Tag> tagList = tagService.findAllByFoodId(id);
                    foodList.add(new Food(shop_id, tag_id, deal_id, name, description, image, price, cookTime, (java.sql.Date) dayCreate, (java.sql.Date) lastUpdate, status, tagList));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return foodList;
        }

        @Override
        public Food findById(int id) {
            Food food = null;
            try (PreparedStatement statement = connection.prepareStatement(SELECT_FOOD_BY_ID);) {
                statement.setInt(1, id);
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int food_id = resultSet.getInt("food_id");
                    int shop_id = resultSet.getInt("shop_id");
                    int tag_id = resultSet.getInt("tag_id");
                    int deal_id = resultSet.getInt("deal_id");
                    String name = resultSet.getString("food_name");
                    double price = resultSet.getDouble("food_price");
                    String description = resultSet.getString("food_description");
                    String image = resultSet.getString("food_image");
                    Time cookTime = resultSet.getTime("food_cooktime");
                    Date dayCreate = resultSet.getDate("food_daycreate");
                    Date lastUpdate = resultSet.getDate("food_lastupdate");
                    int status = resultSet.getInt("status");
                    List<Tag> tagList = tagService.findAllByFoodId(id);

                    food = new Food(shop_id, tag_id, deal_id, name, description, image, price, cookTime, (java.sql.Date) dayCreate, (java.sql.Date) lastUpdate, status, tagList);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return food;
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


        @Override
        public List<Food> findAllFoodByIdTag(int id) {
            return null;
        }
    }

