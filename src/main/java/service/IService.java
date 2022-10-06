package service;

import java.sql.SQLException;
import java.util.List;

public interface IService<E> {
    List<E> fillAll();
    E findById(int id);
    void insert(E p);
    boolean delete(int id) throws SQLException;
    boolean edit(int id, E t) throws SQLException;
}
