package com.shifat63.magazine.Service;

import java.util.Set;
import com.shifat63.magazine.Model.Content;

public interface ContentService extends CrudService<Content, Integer> {
	public Set<Content> getSliderContents(Boolean isSlider);
}
