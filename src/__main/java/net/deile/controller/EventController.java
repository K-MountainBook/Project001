package net.deile.controller;

import java.sql.Timestamp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.deile.entity.Event;
import net.deile.form.EventForm;
import net.deile.repository.EventRepository;
import net.deile.service.EventServiceImpl;
import net.deile.service.ParticipantServiceImpl;

/**
 * "/event"配下のパスへのアクセスコントローラ
 * 
 * @author k_yamamoto
 *
 */
@Controller
@RequestMapping("/event")
public class EventController {

	Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@Autowired
	EventServiceImpl eventServiceImpl;

	@Autowired
	ParticipantServiceImpl participantServiceImpl;

	@Autowired
	EventRepository eventRepository;

	@ModelAttribute
	EventForm eventform() {
		// イベント作成フォームの定義
		return new EventForm();
	}

	/**
	 * /eventのトップページを表示する（公開されているイベントのある程度の一覧を表示）(Get)
	 * 
	 * @return Template Name
	 */
	@GetMapping("")
	public String event() {
		String template = "event_list";
		// 公開可のイベントを表示（抽出アルゴリズムを考える）
		return template;
	}

	/**
	 * イベント作成画面を表示(Get)
	 * 
	 * @param model {@link org.springframework.ui.Model}
	 * @return Template Name
	 */
	@GetMapping("/make")
	public String make(Model model) {
		String template = "event_make";
		// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// System.out.println(((User) auth.getPrincipal()).getEmail());
		// イベント作成画面へ遷移
		return template;
	}

	/**
	 * イベント作成画面を表示(登録)(Post)
	 * 
	 * @param form  {@link net.deile.form.EventForm}
	 * @param model {@link org.springframework.ui.Model}
	 * @return Template Name
	 */

	@PostMapping("/make")
	public String makePost(EventForm form, Model model) {
		logger.info("Run makePost");
		// イベントの登録処理とバリデーション
		String template = "redirect:/event/event_list";

		Event event = new Event();
		try {
			final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp fromDate = new Timestamp(
					df.parse(form.getFromDate() + " " + form.getFromTime() + ":00").getTime());
			Timestamp toDate = new Timestamp(df.parse(form.getToDate() + " " + form.getToTime() + ":00").getTime());

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

		} catch (ParseException e) {
			logger.error(e.getMessage());
			template = "exception";

		}

		return template;

	}

	/**
	 * ログインユーザがオーナーのイベント一覧の表示(Get)
	 * 
	 * @param model {@link org.springframework.ui.Model}
	 * @return Template Name
	 */
	@GetMapping("/event_list")
	public String event_list(Model model) {
		logger.info("Run eventlist");
		String template = "event_list";
		// TODO ログインユーザがオーナーのイベントを検索
		List<Event> ownerEvent = new ArrayList<>();
		ownerEvent = eventServiceImpl.findAllByEmail("");

		model.addAttribute("ownerEvent", ownerEvent);

		return template;
	}

	@PostMapping("/search")
	public String search(@RequestParam(name = "word") String word, Model model) {
		String template = "event_search";
		return template;
	}

	@GetMapping("/details/{event_id}")
	public String eventDetails(@PathVariable(name = "eventid", required = true) Long event_id, Model model) {
		logger.info("view event details");

		String template = "event_details";
		// イベント詳細画面に遷移
		Optional<Event> eventdetails = eventRepository.findById(event_id);
		if (eventdetails.isEmpty()) {
			// イベントデータが取得できない場合
			logger.warn("Event Not Found. event_id:" + event_id);
			template = "event_notfound";
		}
		return template;
	}

	@GetMapping("/join/{event_id}")
	public String eventjoin(@PathVariable(name = "eventid", required = true) Long event_id, Model model) {
		String template = "event_join_confirm";
		return template;
	}

}
