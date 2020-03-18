package com.shifat63.magazine.Service;

import java.util.Set;
import com.shifat63.magazine.Model.Content;
import com.shifat63.magazine.Model.ContentCategory;

public interface ContentService extends CrudService<Content, Integer> {
	public Set<Content> getSliderContents(Boolean isSlider);
	public Set<Content> getFrontContents(Boolean isFront);
	public Set<Content> getContentsSearchedByKeyword(String keyword);
}
