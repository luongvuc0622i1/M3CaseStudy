package service.tag;


import connection.ConnectionCMS;
import model.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagService implements ITagService {

    Connection connection = ConnectionCMS.getConnection();
    public static final String SELECT_ALL_TAG = "SELECT * FROM tags;";
    public static final String SELECT_TAG_BY_ID = "SELECT * FROM tags WHERE tags_id=?";
    private static final String INSERT_TAG = "INSERT INTO tags (tags_code, tags_name, tags_description, tags_status) VALUE (?,?,?,?);";
    private static final String DELETE_TAG = "DELETE FROM tags WHERE tags_id =? ;";
    private static final String UPDATE_TAG = "UPDATE item SET tags_code =?, tags_name =?," +
            " tags_description =?  WHERE tags_id =?;";
    public static final String SELECT_TAG_BY_FOOD_ID = "SELECT * FROM tags JOIN food_tags ft ON tags_id = ft.tags_id AND ft.tags_id = ?";


    @Override
    public List<Tag> fillAll() {
        List<Tag> tags = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_TAG);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int tag_id = resultSet.getInt("tags_id");
                String tag_code = resultSet.getString("tags_code");
                String tag_name = resultSet.getString("tags_name");
                String tag_description = resultSet.getString("tags_description");

//                List<Item> items = itemService.findAllByCategoryId(category_id);
                Tag tag = new Tag(tag_id, tag_code, tag_name, tag_description);

                tags.add(tag);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tags;
    }

    @Override
    public Tag findById(int id) {
        return null;
    }

    @Override
    public void insert(Tag p) {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean edit(int id, Tag t) throws SQLException {
        return false;
    }

    @Override
    public List<Tag> findAllByFoodId(int id) {
        List<Tag> tags = new ArrayList<>();

        try {
            PreparedStatement statement1 = connection.prepareStatement(SELECT_TAG_BY_FOOD_ID);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();
            ResultSet resultSet1 = statement1.getGeneratedKeys();
            while (resultSet.next()) {
                int tag_id = resultSet.getInt("tags_id");
                String tag_code = resultSet.getString("tags_code");
                String tag_name = resultSet.getString("tags_name");
                String tag_description = resultSet.getString("tags_description");

//                List<Item> items = itemService.findAllByCategoryId(category_id);
                Tag category = new Tag(tag_id, tag_code, tag_name, tag_description);

                tags.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
//        }
        }
        return tags;
    }
}
