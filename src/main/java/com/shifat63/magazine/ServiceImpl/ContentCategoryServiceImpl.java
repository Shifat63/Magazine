package com.shifat63.magazine.ServiceImpl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.shifat63.magazine.Model.ContentCategory;
import com.shifat63.magazine.Repositories.ContentCategoryRepository;
import com.shifat63.magazine.Service.ContentCategoryService;

@Service
@Profile({"springdatajpa"})
public class ContentCategoryServiceImpl implements ContentCategoryService {
	private ContentCategoryRepository contentCategoryRepository;
	
	public ContentCategoryServiceImpl(ContentCategoryRepository contentCategoryRepository) {
		this.contentCategoryRepository = contentCategoryRepository;
	}
	
	@Override
	public Set<ContentCategory> findAll() throws Exception {
		Set<ContentCategory> ContentCategorySet = new HashSet<>();
        contentCategoryRepository.findAll().forEach(ContentCategorySet::add);
        return ContentCategorySet;
	}

	@Override
	public ContentCategory findById(Integer id) throws Exception {
		return contentCategoryRepository.findById(id).get();
	}

	@Override
	public ContentCategory save(ContentCategory object) throws Exception {
		return contentCategoryRepository.save(object);
	}

	@Override
	public void delete(ContentCategory object) throws Exception {
		contentCategoryRepository.delete(object);
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		contentCategoryRepository.deleteById(id);;
		
	}

	@Override
	public void deleteAll() throws Exception {
		contentCategoryRepository.deleteAll();
	}

}
