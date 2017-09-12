
package br.mackenzie.lfs.crud_spring_hibernate.model.request;

import br.mackenzie.lfs.crud_spring_hibernate.model.Tag;
import br.mackenzie.lfs.crud_spring_hibernate.services.TagService;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Dias
 */
public class TagPropertyEditor extends PropertyEditorSupport {

    private TagService tagService;
        
    public TagPropertyEditor(TagService tagService){
        this.tagService = tagService;
    }
    
    @Override
    public String getAsText() {
        return ((Tag) getValue()).getId().toString();
    }

    @Override
    public void setAsText(String incomingId) throws IllegalArgumentException {
        Tag tag = tagService.getTag(Integer.valueOf(incomingId));
        setValue(tag);
    }
    
}
