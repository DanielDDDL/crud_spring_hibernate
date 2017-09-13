
package br.mackenzie.lfs.crud_spring_hibernate.dao;

import br.mackenzie.lfs.crud_spring_hibernate.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dias
 */
public interface BookDao extends JpaRepository<Book, Integer> {

    
}
