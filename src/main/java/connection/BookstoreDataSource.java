package connection;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class BookstoreDataSource {
    private static BasicDataSource basicDataSource = new BasicDataSource();

    static {
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/bookstore14?useSSL=false");
        basicDataSource.setUsername("admin14");
        basicDataSource.setPassword("admin14");
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(10);
        basicDataSource.setMaxOpenPreparedStatements(100);

    }

    public static Connection getConnection() throws SQLException {
        return basicDataSource.getConnection();
    }
}
