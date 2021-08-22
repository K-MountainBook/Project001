package net.deile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UsersController {

	@Autowired
	private UsersRepository usersRepository;

	@GetMapping("/")
	public String index(Model model) {
		List<Users> list = usersRepository.getAll();

		if (list != null) {
			for (Users user : list) {
				System.out.println(user.toString());
			}
		}

		return "index";
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(required = false) String message, Model model) {
		model.addAttribute("sample", message);
		return "index";

	}

	@PostMapping("/confirm")
	public String confirm(@RequestParam String inputValue, Model model) {
		model.addAttribute("message", inputValue);
		return "result";

	}

}
