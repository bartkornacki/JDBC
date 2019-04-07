package dao;

import model.Book;

import java.util.List;

public interface BookDao {

    List<Book> find();

    Book findById(int id);

    List<Book> findByAuthorFullName(String authorName);

    List<Book> findByCategoryCode(String category);

    void insert(Book book);

    void insert(String title, Long isbn, Integer pagesNumber,
                Integer categoryId, Integer publisherId);

    void delete(int id);

}
