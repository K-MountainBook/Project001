package net.deile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public String index(Model model){
        List<Users> list = usersRepository.getAll();
        System.out.println(list.toString());
        return "index";
    }

}
