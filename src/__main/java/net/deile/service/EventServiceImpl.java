package net.deile.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.deile.entity.Event;
import net.deile.repository.EventRepository;
import net.deile.service.interfaces.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	public Event findById(long event_id) {
		return eventRepository.findById(event_id).get();
	}

	public Event save(Event event) {
		return eventRepository.save(event);
	}

	public List<Event> findAllByEmail(String email) {
		return eventRepository.findallByEmail(email);
	}
}
