package service;

import dto.BookDto;
import model.Book;

import java.util.List;

public interface BookService {

    List<Book> find();

    List<Book> findByCategoryCode(String categoryCode);

    void insert(Book book);

    void insert(BookDto bookDto);
}
