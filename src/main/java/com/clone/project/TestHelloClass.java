package com.clone.project;

//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import twitter4j.Status;
//import twitter4j.Twitter;
//import twitter4j.TwitterException;
//import twitter4j.TwitterFactory;

@Controller
public class TestHelloClass {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("index");

		return mv;
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public ModelAndView send(@RequestParam("inputValue") String inputvalue, ModelAndView mv) {
		mv.setViewName("result");
		mv.addObject("message", inputvalue);
//		try {
//			Twitter twitter = TwitterFactory.getSingleton();
//			List<Status> statuses = twitter.getHomeTimeline();
//			System.out.println("drowing home timeline");
//
//			for (Status status : statuses) {
//
//				System.out.println(status.getUser().getName() + ":" + status.getText());
//			}
//
//		} catch (TwitterException e) {
//			e.printStackTrace();
//		}
		return mv;
	}

}
