package com.albert.quizintratool.controller.admin;

import com.albert.quizintratool.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TopicsController {

    private TopicRepository topicRepository;

    @GetMapping
    public String getTopicsPage() {
        return "/topics";
    }

    @ModelAttribute
    public void addTopicsToModel(Model model) {
        model.addAttribute("topics", topicRepository.findAll());
    }
}
