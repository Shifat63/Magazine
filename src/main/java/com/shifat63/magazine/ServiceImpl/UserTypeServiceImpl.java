package com.shifat63.magazine.ServiceImpl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.shifat63.magazine.Model.UserType;
import com.shifat63.magazine.Repositories.UserTypeRepository;
import com.shifat63.magazine.Service.UserTypeService;

@Service
@Profile({"springdatajpa"})
public class UserTypeServiceImpl implements UserTypeService {
	private UserTypeRepository userTypeRepository;
	
	public UserTypeServiceImpl(UserTypeRepository userTypeRepository) {
		this.userTypeRepository = userTypeRepository;
	}

	@Override
	public Set<UserType> findAll() throws Exception {
		Set<UserType> userTypeSet = new HashSet<>();
        userTypeRepository.findAll().forEach(userTypeSet::add);
        return userTypeSet;
	}

	@Override
	public UserType findById(Integer id) throws Exception {
		return userTypeRepository.findById(id).get();
	}

	@Override
	public UserType save(UserType object) throws Exception {
		return userTypeRepository.save(object);
	}

	@Override
	public void delete(UserType object) throws Exception {
		userTypeRepository.delete(object);
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		userTypeRepository.deleteById(id);;
		
	}

	@Override
	public void deleteAll() throws Exception {
		userTypeRepository.deleteAll();
	}

}
