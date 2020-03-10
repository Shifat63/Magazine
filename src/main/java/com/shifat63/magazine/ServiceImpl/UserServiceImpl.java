package com.shifat63.magazine.ServiceImpl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.shifat63.magazine.Model.User;
import com.shifat63.magazine.Repositories.UserRepository;
import com.shifat63.magazine.Service.UserService;

@Service
@Profile({"springdatajpa"})
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Set<User> findAll() throws Exception {
		Set<User> UserSet = new HashSet<>();
        userRepository.findAll().forEach(UserSet::add);
        return UserSet;
	}

	@Override
	public User findById(Integer id) throws Exception {
		return userRepository.findById(id).get();
	}

	@Override
	public User save(User object) throws Exception {
		return userRepository.save(object);
	}

	@Override
	public void delete(User object) throws Exception {
		userRepository.delete(object);
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		userRepository.deleteById(id);;
		
	}

	@Override
	public void deleteAll() throws Exception {
		userRepository.deleteAll();
	}
}
