package com.shifat63.magazine.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shifat63.magazine.Model.Event;

@Repository
@Transactional
public interface EventRepository extends CrudRepository<Event, Integer> {

}
