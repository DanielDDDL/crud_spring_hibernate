/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.lfs.crud_spring_hibernate.dao;

import br.mackenzie.lfs.crud_spring_hibernate.model.Book;
import java.util.List;

/**
 *
 * @author Dias
 */
public interface BookDao {
    
    public void addBook(Book book);
    public void updateBook(Book book);
    public Book getBook(int id);
    public void deleteBook(int id);
    public List<Book> getBooks();
    
}
