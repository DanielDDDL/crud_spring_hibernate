
package br.mackenzie.lfs.crud_spring_hibernate.services;

import br.mackenzie.lfs.crud_spring_hibernate.dao.BookDao;
import br.mackenzie.lfs.crud_spring_hibernate.exceptions.BookNotFoundException;
import br.mackenzie.lfs.crud_spring_hibernate.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author Dias
 */
@Service
public class BookServiceImp implements BookService{

    @Resource
    private BookDao bookDao;

    @Override
    @Transactional
    public void addBook(Book book) {
        
        Book createdBook = book;
        bookDao.save(createdBook);
        
    }

    @Override
    @Transactional(rollbackFor = BookNotFoundException.class)
    public void updateBook(Book book) throws BookNotFoundException {

        Book updatedBook = bookDao.findOne(book.getId());

        if(updatedBook == null)
            throw new BookNotFoundException();

        updatedBook.setTitle(book.getTitle());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setTags(book.getTags());
        bookDao.save(updatedBook);
    }

    @Override
    @Transactional
    public Book getBook(int id) {

        return bookDao.findOne(id);
    }

    @Override
    @Transactional(rollbackFor = BookNotFoundException.class)
    public void deleteBook(int id) throws BookNotFoundException {

        Book deletedBook = bookDao.findOne(id);

        if(deletedBook == null)
            throw new BookNotFoundException();

        bookDao.delete(id);

    }

    @Override
    @Transactional
    public List<Book> getBooks() {

        return bookDao.findAll();
    }

}
