
package br.mackenzie.lfs.crud_spring_hibernate.dao;

import br.mackenzie.lfs.crud_spring_hibernate.model.Tag;
import java.util.List;

/**
 *
 * @author Dias
 */
public interface TagDao {
    
    public void addTag(Tag tag);
    public void updateTag(Tag tag);
    public Tag getTag(int id);
    public void deleteTag(int id);
    public List<Tag> getTags();
    
}
