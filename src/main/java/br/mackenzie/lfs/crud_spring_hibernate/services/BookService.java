
package br.mackenzie.lfs.crud_spring_hibernate.services;

import br.mackenzie.lfs.crud_spring_hibernate.exceptions.BookNotFoundException;
import br.mackenzie.lfs.crud_spring_hibernate.model.Book;
import java.util.List;

/**
 *
 * @author Dias
 */
public interface BookService {
    
    void addBook(Book book);
    void updateBook(Book book) throws BookNotFoundException;
    Book getBook(int id);
    void deleteBook(int id) throws BookNotFoundException;
    List<Book> getBooks();

}
