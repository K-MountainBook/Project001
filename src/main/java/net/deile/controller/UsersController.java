package net.deile.controller;

import java.util.List;

import net.deile.model.Users;
import net.deile.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UsersController {


    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository repository) {
        this.usersRepository = repository;
    }

    @GetMapping("/")
    public String index(@ModelAttribute Users users, Model model) {

        List<Users> list = usersRepository.findAll();
        model.addAttribute("users", list);

        if (list.size() != 0) {
            for (Users user : list) {
                System.out.println(user.getUser_id().toString() + " - " + user.getUser_name());
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
