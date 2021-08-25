package net.deile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.deile.entity.Comment;
import net.deile.repository.CommentRepository;

@Controller
@RequestMapping("test/comment")
public class CommentController {

	private final CommentRepository repository;

	@Autowired
	public CommentController(CommentRepository repository) {
		this.repository = repository;
	}

	@GetMapping("")
	public String getAllComments(@ModelAttribute Comment comment, Model model) {
		model.addAttribute("comments", repository.findAll());
		return "list";

	}

	@PostMapping("/add")
	public String addComment(@Validated @ModelAttribute Comment comment, BindingResult result, Model model) {
		model.addAttribute("comments", repository.findAll());
		if (result.hasErrors()) {
			return "list";
		}
		repository.save(comment);

		return "redirect:/comment";
	}

}
