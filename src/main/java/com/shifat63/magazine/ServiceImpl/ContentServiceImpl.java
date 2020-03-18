package com.shifat63.magazine.ServiceImpl;

import java.util.HashSet;
import java.util.Set;

import com.shifat63.magazine.Model.ContentCategory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.shifat63.magazine.Model.Content;
import com.shifat63.magazine.Repositories.ContentRepository;
import com.shifat63.magazine.Service.ContentService;

@Service
@Profile({"springdatajpa"})
public class ContentServiceImpl implements ContentService {
	private ContentRepository contentRepository;
	
	public ContentServiceImpl(ContentRepository contentRepository) {
		this.contentRepository = contentRepository;
	}
	
	@Override
	public Set<Content> findAll() throws Exception {
		Set<Content> contentSet = new HashSet<>();
		contentRepository.findAll().forEach(contentSet::add);
        return contentSet;
	}

	@Override
	public Content findById(Integer id) throws Exception {
		return contentRepository.findById(id).get();
	}

	@Override
	public Content save(Content object) throws Exception {
		return contentRepository.save(object);
	}

	@Override
	public void delete(Content object) throws Exception {
		contentRepository.delete(object);
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		contentRepository.deleteById(id);
		
	}

	@Override
	public void deleteAll() throws Exception {
		contentRepository.deleteAll();
	}

	@Override
	public Set<Content> getSliderContents(Boolean isSlider) {
		Set<Content> sliderContentSet = new HashSet<>();
        contentRepository.findByIsSlider(isSlider).forEach(sliderContentSet::add);
        return sliderContentSet;
	}

	@Override
	public Set<Content> getFrontContents(Boolean isFront) {
		Set<Content> frontContentSet = new HashSet<>();
        contentRepository.findByIsFront(isFront).forEach(frontContentSet::add);
        return frontContentSet;
	}

	@Override
	public Set<Content> getContentsSearchedByKeyword(String keyword) {
		Set<Content> contentSet = new HashSet<>();
		contentRepository.findAllByKeywordContaining(keyword).forEach(contentSet::add);
		return contentSet;
	}

}
