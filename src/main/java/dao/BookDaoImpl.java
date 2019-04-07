package dao;

import connection.BookstoreDataSource;
import connection.ConnectionManager;
import extractor.BookExtractor;
import model.Book;
import service.BookService;
import service.BookServiceImpl;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookDaoImpl implements BookDao {
    public List<Book> find() {
        try (Connection con = BookstoreDataSource.getConnection();
             Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT id, title, pages_number, category_id, publisher_id FROM books");
            List<Book> booklist = new ArrayList<>();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPagesNumber(resultSet.getInt("pages_number"));
                book.setCategoryId(resultSet.getInt("category_id"));
                book.setPublisherId(resultSet.getInt("publisher_id"));
                booklist.add(book);
            }
            return booklist;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return Collections.emptyList();
    }

    public Book findById(int id) {
        return null;
    }

    public List<Book> findByAuthorFullName(String authorName) {
        return null;
    }

    public List<Book> findByCategoryCode(String category) {
        String select = "select b.id as id, title, isbn, pages_number, category_id, publisher_id " +
                "from books b inner join categories c " +
                "on c.id = b.category_id " +
                "where c.code = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select);
        ) {
            preparedStatement.setString(1, category);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Book> bookList = BookExtractor.extractToList(resultSet);
            return bookList;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return Collections.emptyList();

//        try(Connection con = ConnectionManager.getConnection();
//            Statement statement = con.createStatement()){
//            String select = "select b.id as id, b.title as title, c.code as code " +
//                    "from books b " +
//                    "inner join categories c " +
//                    "on b.category_id = c.id " +
//                    "where c.code = '" + category + "'";
//            ResultSet resultSet = statement.executeQuery(select);
//            while (resultSet.next()){
//                Integer id = resultSet.getInt("id");
//                String title = resultSet.getString("title");
//                String code = resultSet.getString("code");
//                System.out.println("id = " + id + ", title= " + title + ", code= " + code);
//            }
//            return Collections.emptyList();
//        }catch (SQLException e){
//            System.out.println(e);
//        }
//        return Collections.emptyList();
    }

    public void insert(Book book) {
        String insert = "insert into books values (default,?,?,?,?,?)";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert);
        ) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getPagesNumber());
            preparedStatement.setLong(3, book.getIsbn());
            preparedStatement.setInt(4, book.getCategoryId());
            preparedStatement.setInt(5, book.getPublisherId());
            Integer result = preparedStatement.executeUpdate();
            System.out.println(result + " row(s) inserted");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {

    }
}
