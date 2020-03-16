package com.shifat63.magazine.ServiceImpl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.shifat63.magazine.Model.Event;
import com.shifat63.magazine.Repositories.EventRepository;
import com.shifat63.magazine.Service.EventService;

@Service
@Profile({"springdatajpa"})
public class EventServiceImpl implements EventService {
	private EventRepository eventRepository;
	
	public EventServiceImpl(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	@Override
	public Set<Event> findAll() throws Exception {
		Set<Event> EventSet = new HashSet<>();
        eventRepository.findAll().forEach(EventSet::add);
        return EventSet;
	}

	@Override
	public Event findById(Integer id) throws Exception {
		return eventRepository.findById(id).get();
	}

	@Override
	public Event save(Event object) throws Exception {
		return eventRepository.save(object);
	}

	@Override
	public void delete(Event object) throws Exception {
		eventRepository.delete(object);
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		eventRepository.deleteById(id);;
		
	}

	@Override
	public void deleteAll() throws Exception {
		eventRepository.deleteAll();
	}

	@Override
	public Set<Event> getFrontEvents(Boolean isFront) {
		Set<Event> frontEventSet = new HashSet<>();
		eventRepository.findByIsFront(isFront).forEach(frontEventSet::add);
        return frontEventSet;
	}

}
