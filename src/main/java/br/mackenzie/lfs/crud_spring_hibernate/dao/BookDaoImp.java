
package br.mackenzie.lfs.crud_spring_hibernate.dao;

import br.mackenzie.lfs.crud_spring_hibernate.model.Book;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dias
 */
@Repository
public class BookDaoImp implements BookDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public void addBook(Book book) {
        getCurrentSession().save(book);
    }

    @Override
    public void updateBook(Book book) {
        Book bookToUpdate = getBook(book.getId());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setTags(book.getTags());
        
        getCurrentSession().update(bookToUpdate);
    }

    @Override
    public Book getBook(int id) {
        return getCurrentSession().get(Book.class, id);
    }

    @Override
    public void deleteBook(int id) {
        Book book = getBook(id);
        if (book != null)
            getCurrentSession().delete(book);
        
    }

    @Override
    public List<Book> getBooks() {
        return getCurrentSession().createQuery("from Book").list();
    }
    
}
