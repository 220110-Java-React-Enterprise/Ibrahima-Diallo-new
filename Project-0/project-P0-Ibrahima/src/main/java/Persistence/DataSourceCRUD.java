package Persistence;


import java.io.IOException;
import java.sql.SQLException;

// CRUD: Create Read, Update, Delete
// class
public interface DataSourceCRUD<T> {

    public Integer create(T t) throws SQLException, IOException;
    public T read(Integer id) throws SQLException, IOException;
    public T update(T t) throws SQLException, IOException;
    public void delete(Integer id) throws SQLException, IOException;
}