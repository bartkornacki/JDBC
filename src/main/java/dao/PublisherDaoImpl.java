package dao;

import connection.BookstoreDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherDaoImpl implements PublisherDao {
    @Override
    public int findIdByPublisherName(String name) {
        String select ="select id from publishers where name = ?";
        try(Connection connection = BookstoreDataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(select)) {

            ps.setString(1,name);

            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                return id;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }
}
