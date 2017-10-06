
package br.mackenzie.lfs.crud_spring_hibernate.services;

import br.mackenzie.lfs.crud_spring_hibernate.dao.TagDao;
import br.mackenzie.lfs.crud_spring_hibernate.exceptions.TagNotFoundException;
import br.mackenzie.lfs.crud_spring_hibernate.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author Dias
 */
@Service
public class TagServiceImp implements TagService{

    @Resource
    private TagDao tagDao;

    @Override
    @Transactional
    public void addTag(Tag tag) {

        tagDao.save(tag);
    }

    @Override
    @Transactional(rollbackFor = TagNotFoundException.class)
    public void updateTag(Tag tag) throws TagNotFoundException {
       
        Tag updatedTag = tagDao.findOne(tag.getId());

        if(updatedTag == null)
            throw new TagNotFoundException();

        updatedTag.setDescription(tag.getDescription());
        tagDao.save(updatedTag);

    }

    @Override
    @Transactional
    public Tag getTag(int id) {

        return tagDao.findOne(id);
    }

    @Override
    @Transactional(rollbackFor = TagNotFoundException.class)
    public void deleteTag(int id) throws TagNotFoundException {

        Tag deletedTag = tagDao.findOne(id);

        if(deletedTag == null)
            throw new TagNotFoundException();

        tagDao.delete(deletedTag);

    }

    @Override
    @Transactional@Autowired
    public List<Tag> getTags() {

        return tagDao.findAll();
    }
}
