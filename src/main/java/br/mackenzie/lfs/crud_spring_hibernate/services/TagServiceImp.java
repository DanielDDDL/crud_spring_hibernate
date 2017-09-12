
package br.mackenzie.lfs.crud_spring_hibernate.services;

import br.mackenzie.lfs.crud_spring_hibernate.dao.TagDao;
import br.mackenzie.lfs.crud_spring_hibernate.model.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dias
 */
@Service
@Transactional
public class TagServiceImp implements TagService{

    @Autowired
    private TagDao tagDao;
    
    @Override
    public void addTag(Tag tag) {
        tagDao.addTag(tag);
    }

    @Override
    public void updateTag(Tag tag) {
        tagDao.updateTag(tag);
    }

    @Override
    public Tag getTag(int id) {
        return tagDao.getTag(id);
    }

    @Override
    public void deleteTag(int id) {
        tagDao.deleteTag(id);
    }

    @Override
    public List<Tag> getTags() {
        return tagDao.getTags();
    }
    
}
