package com.shifat63.magazine.Repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shifat63.magazine.Model.FrontMessage;

@Repository
@Transactional
public interface FrontMessageRepository extends CrudRepository<FrontMessage, Integer> {
	Set<FrontMessage> findByIsActive(Boolean isActive);
}
