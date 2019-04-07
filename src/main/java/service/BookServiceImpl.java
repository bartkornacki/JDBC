package service;

import dao.BookDao;
import dao.CategoryDao;
import dto.BookDto;
import model.Book;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;
    private CategoryDao categoryDao;

    public BookServiceImpl(BookDao bookDao, CategoryDao categoryDao) {
        this.bookDao = bookDao;
        this.categoryDao = categoryDao;
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


        System.out.println(idByCategoryCode);
//        bookDao.insert(bookDto.getTitle(),bookDto.getIsbn(),bookDto.getPagesNumber(),1,1);
    }


}
