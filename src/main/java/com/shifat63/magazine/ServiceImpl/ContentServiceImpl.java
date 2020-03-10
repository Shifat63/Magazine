package com.shifat63.magazine.ServiceImpl;

import java.util.HashSet;
import java.util.Set;
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
		Set<Content> ContentSet = new HashSet<>();
        contentRepository.findAll().forEach(ContentSet::add);
        return ContentSet;
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
		contentRepository.deleteById(id);;
		
	}

	@Override
	public void deleteAll() throws Exception {
		contentRepository.deleteAll();
	}

}
