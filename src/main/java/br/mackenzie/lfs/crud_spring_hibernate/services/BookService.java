
package br.mackenzie.lfs.crud_spring_hibernate.services;

import br.mackenzie.lfs.crud_spring_hibernate.model.Book;
import java.util.List;

/**
 *
 * @author Dias
 */
public interface BookService {
    
    public void addBook(Book book);
    public void updateBook(Book book);
    public Book getBook(int id);
    public void deleteBook(int id);
    public List<Book> getBooks();

}
