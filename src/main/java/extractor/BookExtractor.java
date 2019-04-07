package extractor;

import model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookExtractor {

    public static List<Book> extractToList(ResultSet resultSet) throws SQLException {

        List<Book> bookList = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setTitle(resultSet.getString("title"));
            book.setIsbn(resultSet.getLong("isbn"));
            book.setPagesNumber(resultSet.getInt("pages_number"));
            book.setCategoryId(resultSet.getInt("category_id"));
            book.setPublisherId(resultSet.getInt("publisher_id"));
            bookList.add(book);
        }
        return bookList;

    }

}
