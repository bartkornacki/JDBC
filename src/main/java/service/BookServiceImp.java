package service;

import dao.BookDao;
import dao.CategoryDao;
import dao.PublisherDao;
import dto.BookDto;
import model.Book;

import java.util.List;

public class BookServiceImp implements BookService {

    private BookDao bookDao;
    private CategoryDao categoryDao;
    private PublisherDao publisherDao;

    public BookServiceImp(BookDao bookDao,CategoryDao categoryDao,PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.categoryDao = categoryDao;
        this.publisherDao = publisherDao;
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

    @Override
    public void insert(BookDto bookDto) {

        int idByCategoryCode = categoryDao.findIdByCategoryCode(bookDto.getCategoryCode());
        int idByPublisherName = publisherDao.findIdByPublisherName(bookDto.getPublisherName());

        bookDao.insert(bookDto.getTitle(),bookDto.getIsbn()
                ,bookDto.getPagesNumber(),idByCategoryCode,idByPublisherName);
    }
}
