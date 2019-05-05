package com.rspace.controller;

import com.rspace.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/rohancv")
public class IndexController {

//    @Autowired
//    private UserRepository userRepository;

    @GetMapping(path = "/index")
    public ModelAndView index(Model model) {
        ModelAndView mav = new ModelAndView("index");

        User user = new User();
        user.setFirstName("Rohan");
        user.setLastName("Parekh");
        user.setEmail("rohan.parekh.in@gmail.com");
        user.setPhone("+49-176-5902-6005");
        user.setLinkedUrl("https://www.linkedin.com/in/rohan-parekh/");
        user.setId(1L);

//        model.addAttribute("user", userRepository.findById(1L));
        mav.addObject("user", user);
        return mav;
    }


    @GetMapping(path = "/index2")
    public ModelAndView index2(Model model) {
        ModelAndView mav = new ModelAndView("/pages/index");

        User user = new User();
        user.setFirstName("Rohan");
        user.setLastName("Parekh");
        user.setEmail("rohan.parekh.in@gmail.com");
        user.setPhone("+49-176-5902-6005");
        user.setAddress("Berlin, Germany");
        user.setLinkedUrl("https://www.linkedin.com/in/rohan-parekh/");
        user.setId(1L);

//        model.addAttribute("user", userRepository.findById(1L));
        mav.addObject("user", user);
        return mav;
    }
}
