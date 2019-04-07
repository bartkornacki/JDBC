package dao;

import connection.BookstoreDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public int findIdByCategoryCode(String categoryCode) {
        String select = "select id from categories where code = ?";
        try(Connection connection = BookstoreDataSource.getConnection();
            PreparedStatement ps = ((Connection) connection).prepareStatement(select)){
            ps.setString(1, categoryCode);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                        return id;
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return -1;
    }
}
