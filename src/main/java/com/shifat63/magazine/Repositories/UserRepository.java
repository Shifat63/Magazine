package com.shifat63.magazine.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shifat63.magazine.Model.User;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

}
