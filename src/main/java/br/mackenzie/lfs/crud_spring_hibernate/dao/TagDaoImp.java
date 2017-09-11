
package br.mackenzie.lfs.crud_spring_hibernate.dao;

import br.mackenzie.lfs.crud_spring_hibernate.model.Tag;
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
public class TagDaoImp implements TagDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public void addTag(Tag tag) {
        getCurrentSession().save(tag);
    }

    @Override
    public void updateTag(Tag tag) {
        Tag tagToUpdate = getTag(tag.getId());
        tagToUpdate.setDescription(tag.getDescription());
        
        Session session = getCurrentSession();
        session.clear();
        session.update(tag);
    }

    @Override
    public Tag getTag(int id) {
        return getCurrentSession().get(Tag.class, id);
    }

    @Override
    public void deleteTag(int id) {
        Tag tag = getTag(id);
        if(tag != null)
            getCurrentSession().delete(tag);
    }

    @Override
    public List<Tag> getTags() {
        return getCurrentSession().createQuery("from Tag").list();
    }
    
}
