package com.rspace.controller;

import com.rspace.model.User;
import com.rspace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rohancv")
public class IndexController {

//    @Autowired
//    private UserRepository userRepository;

    @GetMapping(path = "/index")
    public String index(Model model) {

        User user = new User();
        user.setFirstName("Rohan");
        user.setLastName("Parekh");
        user.setEmail("rohan.parekh.in@gmail.com");
        user.setPhone("+49-176-5902-6005");
        user.setLinkedUrl("https://www.linkedin.com/in/rohan-parekh/");
        user.setId(1L);

//        model.addAttribute("user", userRepository.findById(1L));
        model.addAttribute("user", user);
        return "index";
    }
}
