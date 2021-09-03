package net.deile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.deile.entity.Event;
import net.deile.repository.EventRepository;
import net.deile.service.interfaces.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	public Event findById(String event_id) {
		return eventRepository.findById(event_id).get();
	}

}
