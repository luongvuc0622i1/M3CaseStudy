package service.tag;

import connection.ConnectionCMS;
import model.Deal;
import model.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagService implements ITagService {
    private static final String FIND_ALL_TAG = "select * from category;";
    private Connection c = ConnectionCMS.getConnection();
    @Override
    public List<Tag> fillAll() {
        List<Tag> tags = new ArrayList<>();
        try {
            PreparedStatement ps= c.prepareStatement(FIND_ALL_TAG);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                int id= rs.getInt(1);
                String code= rs.getString(2);
                String name= rs.getString(3);
                String description= rs.getString(4);
                Tag tag = new Tag(id, code, name, description);
                tags.add(tag);
            }
        } catch (SQLException e) {
            printSQLException(e);
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
