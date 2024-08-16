package com.albert.quizintratool.controller;

import com.albert.quizintratool.model.Question;
//import com.albert.quizintratool.model.Result;
import com.albert.quizintratool.model.Topic;
import com.albert.quizintratool.repository.QuestionRepository;
import com.albert.quizintratool.repository.TopicRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/quiz2/")
@SessionAttributes
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
                           @RequestParam(name = "que_ind", required = false) Long queInd,
                           Model model) {
        // если тема есть, то обновить модель и вернуть страницу квиза
        if (topicRepository.findById(topicId).isPresent()) {
            addAttributeToModel(topicId, queInd, model);
            return "quiz2";
        }
        // в ином случае - домашнюю страницу
        return "home";
    }

    @PostMapping
    public String getResult(@RequestParam(name = "topic_id", required = true) Long topicId,
                            @RequestParam(name = "que_ind", required = false) Long queInd,
                            @RequestParam(name = "option", required = false) String option) {
        System.out.println(option);
        return "redirect:/quiz2/?topic_id=" + topicId + "&que_ind=" + queInd;
    }

    //для всех вопросов
    private void addAttributeToModel(Long topicId, Long queInd, Model model) {

        String modelTopicName = "topic";
        String modelQueNumName = "queNum";
        String modelQuestionsName = "questions";
        if (queInd == null) {
            queInd = 0L;
        }
        Long queNum = queInd + 1L;

        if (!model.containsAttribute(modelTopicName)) {
            Topic topic = topicRepository.findById(topicId).get();
            model.addAttribute(modelTopicName, topic);
        }


        model.addAttribute(modelQueNumName, queNum);


        if (!model.containsAttribute(modelQuestionsName)) {
            List<Question> questions = questionRepository.findByTopicIdOrderByRandomLimit10(topicId);
            // Collections.shuffle(questions);
            System.out.println(questions);
            model.addAttribute("questions", questions);
        }
    }

    //для одного вопроса
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
    }*/
}
