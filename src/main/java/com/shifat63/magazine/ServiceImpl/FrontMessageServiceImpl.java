package com.shifat63.magazine.ServiceImpl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.shifat63.magazine.Model.FrontMessage;
import com.shifat63.magazine.Repositories.FrontMessageRepository;
import com.shifat63.magazine.Service.FrontMessageService;

@Service
@Profile({"springdatajpa"})
public class FrontMessageServiceImpl implements FrontMessageService {
	private FrontMessageRepository frontMessageRepository;
	
	public FrontMessageServiceImpl(FrontMessageRepository frontMessageRepository) {
		this.frontMessageRepository = frontMessageRepository;
	}
	
	@Override
	public Set<FrontMessage> findAll() throws Exception {
		Set<FrontMessage> FrontMessageSet = new HashSet<>();
        frontMessageRepository.findAll().forEach(FrontMessageSet::add);
        return FrontMessageSet;
	}

	@Override
	public FrontMessage findById(Integer id) throws Exception {
		return frontMessageRepository.findById(id).get();
	}

	@Override
	public FrontMessage save(FrontMessage object) throws Exception {
		return frontMessageRepository.save(object);
	}

	@Override
	public void delete(FrontMessage object) throws Exception {
		frontMessageRepository.delete(object);
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		frontMessageRepository.deleteById(id);;
		
	}

	@Override
	public void deleteAll() throws Exception {
		frontMessageRepository.deleteAll();
	}

	@Override
	public Set<FrontMessage> getActiveFrontMessages(Boolean isActive) {
		Set<FrontMessage> activeFrontMessageSet = new HashSet<>();
		frontMessageRepository.findByIsActive(isActive).forEach(activeFrontMessageSet::add);
        return activeFrontMessageSet;
	}

}
