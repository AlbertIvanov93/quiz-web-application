/*
package com.albert.quizintratool.controller;

import com.albert.quizintratool.model.Question;
import com.albert.quizintratool.model.Result;
import com.albert.quizintratool.model.Topic;
import com.albert.quizintratool.repository.QuestionRepository;
import com.albert.quizintratool.repository.TopicRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/quiz/")
@SessionAttributes
public class QuizController {

    private final TopicRepository topicRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public QuizController(TopicRepository topicRepository, QuestionRepository questionRepository) {
        this.topicRepository = topicRepository;
        this.questionRepository = questionRepository;
    }


    @GetMapping
    public String showQuiz(@RequestParam(name = "topic_id") Long topicId,
                           @RequestParam(name = "que_num", required = false) Long queNum,
                           Model model,
                           HttpSession httpSession) {
        if (topicRepository.findById(topicId).isPresent()) {
            //addAttributeToModel(topicId, queNum, model, httpSession);
            addAttributeToModel(topicId, model);
            return "quiz";
        }
        return "home";
    }

    @PostMapping
    public void getResult(@RequestBody Result result) {
        System.out.println(result);
    }

    //для всех вопросов
    private void addAttributeToModel(Long topicId, Model model) {
        Topic topic = topicRepository.findById(topicId).get();
        model.addAttribute("topic", topic);

        List<Question> questions = questionRepository.findByTopicId(topicId);
        Collections.shuffle(questions);
        model.addAttribute("questions", questions);
    }

    //для одного вопроса
*/
/*    private void addAttributeToModel(Long topicId, Long queNum, Model model, HttpSession httpSession) {
        Topic topic = topicRepository.findById(topicId).get();
        model.addAttribute("topic", topic);

        if (queNum == null) {
            queNum = 0L;
            httpSession
        }
        Question question = questionRepository.findByTopicIdAndNumber(topicId, queNum);
        System.out.println(question.getOptions().size());
        model.addAttribute("question", question);
    }*//*

}
*/
