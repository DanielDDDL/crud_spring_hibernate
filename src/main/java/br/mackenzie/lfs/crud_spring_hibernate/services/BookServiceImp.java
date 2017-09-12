
package br.mackenzie.lfs.crud_spring_hibernate.services;

import br.mackenzie.lfs.crud_spring_hibernate.dao.BookDao;
import br.mackenzie.lfs.crud_spring_hibernate.model.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dias
 */
@Service
@Transactional
public class BookServiceImp implements BookService{

    @Autowired
    private BookDao bookDao;
    
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book getBook(int id) {
        return bookDao.getBook(id);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }
    
}
