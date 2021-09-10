package net.deile.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.deile.entity.Event;
import net.deile.form.EventForm;
import net.deile.service.EventServiceImpl;
import net.deile.service.ParticipantServiceImpl;

@Controller
@RequestMapping("/event")
public class EventController {

	Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@Autowired
	EventServiceImpl eventServiceImpl;

	@Autowired
	ParticipantServiceImpl participantServiceImpl;

	@ModelAttribute
	EventForm eventform() {
		return new EventForm();
	}

	@GetMapping("")
	public String event() {

		return "event_list";
	}

	@GetMapping("/make")
	public String make(Model model) {
		return "event_make";

	}

	@PostMapping("/make")
	public String makePost(EventForm form, Model model) {
		logger.info("Run makePost");
		// イベントの登録処理とバリデーション
		Event event = new Event();
		try {
			final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp fromDate = new Timestamp(
					df.parse(form.getFromDate() + " " + form.getFromTime() + ":00").getTime());
			Timestamp toDate = new Timestamp(df.parse(form.getToDate() + " " + form.getToTime() + ":00").getTime());

			System.out.println(fromDate);
			System.out.println(toDate);

			// バリデーション

			// 登録処理
			event.setTitle(form.getTitle());
			event.setDetails(form.getDetails());
			event.setAddress(form.getAddress());
			event.setFromDate(fromDate);
			event.setToDate(toDate);
			event.setParticipant(0);
			event.setMax_participant(form.getMax_participant());
			event.setPublic_flag(form.getPublic_flag());
			// TODO Ownerをセッションから取得して格納する。
			event.setOwner("");

			eventServiceImpl.save(event);
			return "redirect:/event/event_list";

		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return "exception";
		}
	}

	@GetMapping("/event_list")
	public String event_list(Model model) {
		logger.info("Run eventlist");
		// TODO ログインユーザがオーナーのイベントを検索
		List<Event> ownerEvent = new ArrayList<>();
		ownerEvent = eventServiceImpl.findAllByemail("");

		model.addAttribute("ownerEvent", ownerEvent);

		return "event_list";
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
