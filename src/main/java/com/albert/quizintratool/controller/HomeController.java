package com.albert.quizintratool.controller;

import com.albert.quizintratool.model.Role;
import com.albert.quizintratool.model.Topic;
import com.albert.quizintratool.model.User;
import com.albert.quizintratool.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@SessionAttributes
public class HomeController {

    private TopicRepository topicRepository;

    @Autowired
    public HomeController(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @ModelAttribute
    public void addTopicsToModel(Model model) {
        Iterable<Topic> topics = topicRepository.findAll();
        model.addAttribute("topics" ,topics);

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userRole" ,user.getRoles());
        model.addAttribute("admin", Role.ADMIN);
    }

    @GetMapping
    public String showHomePage() {
        return "home";
    }
}
