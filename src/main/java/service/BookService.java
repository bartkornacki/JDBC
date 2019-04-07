package service;

import model.Book;

import java.util.List;

public interface BookService {

    List<Book> find();

    List<Book> findByCategoryCode(String categoryCode);

    void insert(Book book);
}
