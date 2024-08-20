package com.albert.quizintratool.controller;

import com.albert.quizintratool.model.Question;
import com.albert.quizintratool.repository.QuestionRepository;
import com.albert.quizintratool.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quiz2/")
@SessionAttributes("questions")
public class Quiz2Controller {

    private final TopicRepository topicRepository;
    private final QuestionRepository questionRepository;



    @Autowired
    public Quiz2Controller(TopicRepository topicRepository, QuestionRepository questionRepository) {
        this.topicRepository = topicRepository;
        this.questionRepository = questionRepository;
    }



    @GetMapping
    public String showQuiz(@RequestParam(name = "topic_id", required = true) Long topicId,
                           Model model) {
        // если тема есть, то обновить модель и вернуть страницу квиза
        if (topicRepository.findById(topicId).isPresent()) {
            addAttributeToModel(topicId, model);
            return "quiz2";
        }
        // в ином случае - домашнюю страницу
        return "home";
    }

    @PostMapping
    public String getResult(@RequestParam String option, Model model) {

        return "result";
    }


    private void addAttributeToModel(Long topicId, Model model) {
        String modelQuestionsName = "questions";
        List<Question> questions = questionRepository.findByTopicIdOrderByRandomLimit10(topicId);
        model.addAttribute("questions", questions);

    }
}
