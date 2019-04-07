package service;

import dao.BookDao;
import model.Book;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> find() {
        return bookDao.find();
    }

    @Override
    public List<Book> findByCategoryCode(String categoryCode) {
        return bookDao.findByCategoryCode(categoryCode);
    }

    @Override
    public void insert(Book book) {
        bookDao.insert(book);
    }


}
