package com.albert.quizintratool.controller;

import com.albert.quizintratool.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/result/")
public class ResultController {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultController(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @GetMapping
    public String showResult(@RequestParam Long id, Model model) {
        model.addAttribute("result", resultRepository.findById(id).orElseThrow());
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "result";
    }
}
