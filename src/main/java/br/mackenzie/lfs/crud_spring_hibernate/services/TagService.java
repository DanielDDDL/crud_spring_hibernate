
package br.mackenzie.lfs.crud_spring_hibernate.services;

import br.mackenzie.lfs.crud_spring_hibernate.exceptions.TagNotFoundException;
import br.mackenzie.lfs.crud_spring_hibernate.model.Tag;
import java.util.List;

/**
 *
 * @author Dias
 */
public interface TagService {
    
    void addTag(Tag tag);
    void updateTag(Tag tag) throws TagNotFoundException;
    Tag getTag(int id);
    void deleteTag(int id) throws TagNotFoundException;
    List<Tag> getTags();
    
}
