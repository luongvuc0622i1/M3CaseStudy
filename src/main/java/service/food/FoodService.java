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
        private static final String SELECT_FOOD_BY_ID_TAG = "SELECT * FROM food WHERE tags_id=?";
        Connection connection = ConnectionCMS.getConnection();

        TagService tagService = new TagService();

        private static final String SELECT_ALL_FOOD = "SELECT * FROM food WHERE status = 1;";
        private static final String SELECT_FOOD_BY_ID = "SELECT * FROM food WHERE food_id=?";
        private static final String SELECT_FOOD_BY_NAME = "SELECT * FROM food WHERE food_name like ?";
        private static final String SELECT_FOOD_ID_BY_NAME = "SELECT food_id FROM food WHERE food_name like ?";

        private static final String INSERT_FOOD = "INSERT INTO food (shop_id, tags_id, deal_id," +
                "food_name, food_price, food_description, food_image, food_cooktime, food_daycreate, food_lastupdate, status) VALUE (?,?,?,?,?,?,?,?,?,?,?);";

        private static final String DELETE_FOOD = "DELETE FROM food WHERE food_id =? ;";
        private static final String UPDATE_FOOD = "UPDATE food SET shop_id =?, tags_id =?, deal_id =?," +
                "food_name = ?, food_price =?, food_description =?, food_image =?, food_cooktime=?, food_daycreate=?, food_lastupdate=?, status=? WHERE food_id =?;";

        public static final String INSERT_NEW_FOOD_TAG = "INSERT INTO food_tags (food_id, tags_id) VALUE (?, ?);";

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
                    int tag_id = resultSet.getInt("tags_id");
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
            try (PreparedStatement statement = connection.prepareStatement(SELECT_FOOD_BY_ID)) {
                statement.setInt(1, id);
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int food_id = resultSet.getInt("food_id");
                    int shop_id = resultSet.getInt("shop_id");
                    int tag_id = resultSet.getInt("tags_id");
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
            boolean rowDeleted;
            try(
                    PreparedStatement statement = connection.prepareStatement(DELETE_FOOD);){
                statement.setInt(1,id);
                rowDeleted = statement.executeUpdate()>0;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return rowDeleted;
        }

        @Override
        public boolean edit(int id, Food food) throws SQLException {
            boolean rowUpdated;
            try (
                    PreparedStatement statement = connection.prepareStatement(UPDATE_FOOD);) {
                statement.setInt(1, food.getShop_id());
                statement.setInt(2, food.getTag_id());
                statement.setInt(3, food.getDeal_id());
                statement.setString(4, food.getName());
                statement.setDouble(5, food.getPrice());
                statement.setString(6, food.getDescription());
                statement.setString(7, food.getImage());
                statement.setTime(8, food.getCookTime());
                statement.setDate(9, food.getDayCreate());
                statement.setDate(10, food.getLastUpdate());
                statement.setInt(11, food.getStatus());
                statement.setInt(12, id);
                rowUpdated = statement.executeUpdate() > 0;



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return rowUpdated;
        }

        @Override
        public void insert(Food food) {
            try{
                PreparedStatement statement = connection.prepareStatement(INSERT_FOOD);
                statement.setInt(1, food.getShop_id());
                statement.setInt(2, food.getTag_id());
                statement.setInt(3, food.getDeal_id());
                statement.setString(4, food.getName());
                statement.setDouble(5, food.getPrice());
                statement.setString(6, food.getDescription());
                statement.setString(7, food.getImage());
                statement.setTime(8, food.getCookTime());
                statement.setDate(9, food.getDayCreate());
                statement.setDate(10, food.getLastUpdate());
                statement.setInt(11, food.getStatus());
                statement.executeUpdate();
                System.out.println(statement);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void save(Food food, Tag tag) {

            try{
//            connection.setAutoCommit(false);
                PreparedStatement statement =connection.prepareStatement(INSERT_FOOD);
                statement.setInt(1, food.getShop_id());
                statement.setInt(2, food.getTag_id());
                statement.setInt(3, food.getDeal_id());
                statement.setString(4, food.getName());
                statement.setDouble(5, food.getPrice());
                statement.setString(6, food.getDescription());
                statement.setString(7, food.getImage());
                statement.setTime(8, food.getCookTime());
                statement.setDate(9, food.getDayCreate());
                statement.setDate(10, food.getLastUpdate());
                statement.setInt(11, food.getStatus());
                statement.executeUpdate();

                PreparedStatement statementF = connection.prepareStatement(SELECT_FOOD_BY_NAME);
                statementF.setString(1, food.getName());
                ResultSet set = statementF.executeQuery();
                int id=0;
                while (set.next())
                {
                id = set.getInt("food_id");
                }








                PreparedStatement statement1 = connection.prepareStatement(INSERT_NEW_FOOD_TAG);

                    statement1.setInt(1,id);
                    statement1.setInt(2,tag.getId());
                    statement1.executeUpdate();

//            connection.commit();
            } catch (SQLException throwables) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                throwables.printStackTrace();
            }
        }

        @Override
        public void save(Food food, int[] tag) {
            int food_id = 0;
            try{
//            connection.setAutoCommit(false);
                PreparedStatement statement =connection.prepareStatement(INSERT_FOOD, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, food.getShop_id());
                statement.setInt(2, food.getTag_id());
                statement.setInt(3, food.getDeal_id());
                statement.setString(4, food.getName());
                statement.setDouble(5, food.getPrice());
                statement.setString(6, food.getDescription());
                statement.setString(7, food.getImage());
                statement.setTime(8, food.getCookTime());
                statement.setDate(9, food.getDayCreate());
                statement.setDate(10, food.getLastUpdate());
                statement.setInt(11, food.getStatus());
                statement.executeUpdate();

                ResultSet resultSet = statement.getGeneratedKeys();
                while (resultSet.next()){
                    food_id = resultSet.getInt(1);
                }


                PreparedStatement statement1 = connection.prepareStatement(INSERT_NEW_FOOD_TAG);
                for (int id_tag : tag
                ) {
                    statement1.setInt(1,food_id);
                    statement1.setInt(2,id_tag);
                    statement1.executeUpdate();
                }
//            connection.commit();
            } catch (SQLException throwables) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                throwables.printStackTrace();
            }
        }


        @Override
        public List<Food> selectFoodByName(String food_name) {

            List<Food> foods = new ArrayList<>();
            try(
                    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FOOD_BY_NAME);){
                preparedStatement.setString(1,"%"+food_name+"%");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){

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
                    foods.add(new Food(shop_id, tag_id, deal_id, name, description, image, price, cookTime, (java.sql.Date) dayCreate, (java.sql.Date) lastUpdate, status)) ;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return foods;

        }

        @Override
        public List<Food> findAllFoodByIdShop(int id) {
            List<Food> foods = new ArrayList<>();
            try(PreparedStatement statement = connection.prepareStatement(SELECT_FOOD_BY_ID_SHOP);){
                statement.setInt(1,id);
                System.out.println(statement);
                ResultSet resultSet =statement.executeQuery();
                while (resultSet.next()) {
                    int shop_id = resultSet.getInt("shop_id");
                    int tag_id = resultSet.getInt("tags_id");
                    int deal_id = resultSet.getInt("deal_id");
                    String name = resultSet.getString("food_name");
                    double price = resultSet.getDouble("food_price");
                    String description = resultSet.getString("food_description");
                    String image = resultSet.getString("food_image");
                    Time cookTime = resultSet.getTime("food_cooktime");
                    Date dayCreate = resultSet.getDate("food_daycreate");
                    Date lastUpdate = resultSet.getDate("food_lastupdate");
                    int status = resultSet.getInt("status");
                    foods.add(new Food(shop_id, tag_id, deal_id, name, description, image, price, cookTime, (java.sql.Date) dayCreate, (java.sql.Date) lastUpdate, status)) ;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return foods;
        }

        @Override
        public List<Food> findAllFoodByIdDeal(int id) {
            List<Food> foods = new ArrayList<>();
            try(PreparedStatement statement = connection.prepareStatement(SELECT_FOOD_BY_ID_DEAL)){
                statement.setInt(1,id);
                System.out.println(statement);
                ResultSet resultSet =statement.executeQuery();
                while (resultSet.next()) {
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
                    foods.add(new Food(shop_id, tag_id, deal_id, name, description, image, price, cookTime, (java.sql.Date) dayCreate, (java.sql.Date) lastUpdate, status)) ;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return foods;
        }


        @Override
        public List<Food> findAllFoodByIdTag(int id) {
            List<Food> foods = new ArrayList<>();
            try(PreparedStatement statement = connection.prepareStatement(SELECT_FOOD_BY_ID_TAG)){
                statement.setInt(1,id);
                System.out.println(statement);
                ResultSet resultSet =statement.executeQuery();
                while (resultSet.next()) {
                    int shop_id = resultSet.getInt("shop_id");
                    int tag_id = resultSet.getInt("tags_id");
                    int deal_id = resultSet.getInt("deal_id");
                    String name = resultSet.getString("food_name");
                    double price = resultSet.getDouble("food_price");
                    String description = resultSet.getString("food_description");
                    String image = resultSet.getString("food_image");
                    Time cookTime = resultSet.getTime("food_cooktime");
                    Date dayCreate = resultSet.getDate("food_daycreate");
                    Date lastUpdate = resultSet.getDate("food_lastupdate");
                    int status = resultSet.getInt("status");
                    foods.add(new Food(id, shop_id, tag_id, deal_id, name, description, image, price, cookTime, (java.sql.Date) dayCreate, (java.sql.Date) lastUpdate, status)) ;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return foods;
        }
    }

