
package br.mackenzie.lfs.crud_spring_hibernate.dao;

import br.mackenzie.lfs.crud_spring_hibernate.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dias
 */
public interface TagDao extends JpaRepository<Tag, Integer> {

}
