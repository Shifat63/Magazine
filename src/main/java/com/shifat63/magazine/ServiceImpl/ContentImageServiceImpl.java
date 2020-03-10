package com.shifat63.magazine.ServiceImpl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.shifat63.magazine.Model.ContentImage;
import com.shifat63.magazine.Repositories.ContentImageRepository;
import com.shifat63.magazine.Service.ContentImageService;

@Service
@Profile({"springdatajpa"})
public class ContentImageServiceImpl implements ContentImageService {
	private ContentImageRepository contentImageRepository;
	
	public ContentImageServiceImpl(ContentImageRepository contentImageRepository) {
		this.contentImageRepository = contentImageRepository;
	}
	
	@Override
	public Set<ContentImage> findAll() throws Exception {
		Set<ContentImage> ContentImageSet = new HashSet<>();
        contentImageRepository.findAll().forEach(ContentImageSet::add);
        return ContentImageSet;
	}

	@Override
	public ContentImage findById(Integer id) throws Exception {
		return contentImageRepository.findById(id).get();
	}

	@Override
	public ContentImage save(ContentImage object) throws Exception {
		return contentImageRepository.save(object);
	}

	@Override
	public void delete(ContentImage object) throws Exception {
		contentImageRepository.delete(object);
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		contentImageRepository.deleteById(id);;
		
	}

	@Override
	public void deleteAll() throws Exception {
		contentImageRepository.deleteAll();
	}

}
