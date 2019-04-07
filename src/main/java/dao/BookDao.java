package dao;

import model.Book;

import java.util.List;

public interface BookDao {

    List<Book> find();

    Book findById(int id);

    List<Book> findByAuthorFullName(String authorName);

    List<Book> findByCategoryCode(String category);

    void insert(Book book);

    void delete(int id);

}
