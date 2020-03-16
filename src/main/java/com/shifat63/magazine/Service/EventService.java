package com.shifat63.magazine.Service;

import java.util.Set;
import com.shifat63.magazine.Model.Event;

public interface EventService extends CrudService<Event, Integer> {
	public Set<Event> getFrontEvents(Boolean isFront);
}
