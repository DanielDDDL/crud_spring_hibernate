/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
