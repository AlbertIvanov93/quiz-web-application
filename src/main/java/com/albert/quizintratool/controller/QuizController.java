package com.albert.quizintratool.controller;

import com.albert.quizintratool.model.Question;
import com.albert.quizintratool.model.Result;
import com.albert.quizintratool.model.User;
import com.albert.quizintratool.repository.QuestionRepository;
import com.albert.quizintratool.repository.ResultRepository;
import com.albert.quizintratool.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/quiz/")
@SessionAttributes("questions")
public class QuizController {

    private final TopicRepository topicRepository;
    private final QuestionRepository questionRepository;
    private final ResultRepository resultRepository;


    @Autowired
    public QuizController(TopicRepository topicRepository, QuestionRepository questionRepository, ResultRepository resultRepository) {
        this.topicRepository = topicRepository;
        this.questionRepository = questionRepository;
        this.resultRepository = resultRepository;
    }


    @GetMapping
    public String showQuiz(@RequestParam(name = "topic_id") Long topicId,
                           Model model) {
        // если тема есть, то обновить модель и вернуть страницу квиза
        if (topicRepository.findById(topicId).isPresent()) {
            addAttributeToModel(topicId, model);
            return "quiz";
        }
        // в ином случае - домашнюю страницу
        return "home";
    }

    @PostMapping
    public String getResult(@RequestParam(name = "option_que0", required = false) String firstAns,
                            @RequestParam(name = "option_que1", required = false) String secondAns,
                            @RequestParam(name = "option_que2", required = false) String thirdAns,
                            @RequestParam(name = "option_que3", required = false) String forthAns,
                            @RequestParam(name = "option_que4", required = false) String fifthAns,
                            @RequestParam(name = "option_que5", required = false) String sixthAns,
                            @RequestParam(name = "option_que6", required = false) String seventhAns,
                            @RequestParam(name = "option_que7", required = false) String eighthAns,
                            @RequestParam(name = "option_que8", required = false) String ninthAns,
                            @RequestParam(name = "option_que9", required = false) String tensAns,
                            Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Question> questions = (List<Question>) model.getAttribute("questions");
        Map<Question,String> resultMap = new HashMap<>();
        List<String> userAnswer = List.of(firstAns, secondAns, thirdAns, forthAns,
                fifthAns, sixthAns, seventhAns, eighthAns, ninthAns, tensAns);
        for (int i = 0; i < 10; i++) {
            resultMap.put(questions.get(i), userAnswer.get(i));
        }

        Result result = new Result(user, new Date(), resultMap);
        resultRepository.save(result);
        return "redirect:/result/?id=" + result.getId();
    }

    @ModelAttribute(name = "questions")
    private List<Question> addAttributeToModel(Long topicId, Model model) {
        String modelQuestionsName = "questions";
        List<Question> questions = questionRepository.findByTopicIdOrderByRandomLimit10(topicId);
        model.addAttribute("questions", questions);
        return questions;
    }
}
