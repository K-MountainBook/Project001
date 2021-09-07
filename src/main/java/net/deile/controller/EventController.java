package net.deile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/event")
public class EventController {

	Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());


	@GetMapping("")
	public String event() {

		return "eventlist";
	}

	@GetMapping("/make")
	public String makeevent(Model model) {
		return "event_make";

	}

	@GetMapping("/search")
	public String search(Model model) {
		return "event_search";
	}

	@GetMapping("/details")
	public String eventDetails(Model model) {
		return "event_details";
	}

	@GetMapping("/join")
	public String eventjoin(@RequestParam String event_id, Model model) {
		return "event_join_confirm";
	}

}
