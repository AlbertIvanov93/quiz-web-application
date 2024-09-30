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
    public String getResult(@RequestParam(name = "option_que0", defaultValue = "Время вышло") String firstAns,
                            @RequestParam(name = "option_que1", defaultValue = "Время вышло") String secondAns,
                            @RequestParam(name = "option_que2", defaultValue = "Время вышло") String thirdAns,
                            @RequestParam(name = "option_que3", defaultValue = "Время вышло") String forthAns,
                            @RequestParam(name = "option_que4", defaultValue = "Время вышло") String fifthAns,
                            @RequestParam(name = "option_que5", defaultValue = "Время вышло") String sixthAns,
                            @RequestParam(name = "option_que6", defaultValue = "Время вышло") String seventhAns,
                            @RequestParam(name = "option_que7", defaultValue = "Время вышло") String eighthAns,
                            @RequestParam(name = "option_que8", defaultValue = "Время вышло") String ninthAns,
                            @RequestParam(name = "option_que9", defaultValue = "Время вышло") String tensAns,
                            Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Question> questions = (List<Question>) model.getAttribute("questions");
        Map<Question,String> resultMap = new HashMap<>();
        List<String> userAnswer = List.of(firstAns, secondAns, thirdAns, forthAns,
                fifthAns, sixthAns, seventhAns, eighthAns, ninthAns, tensAns);

        int score = 0;
        int maxScore = questions.size();
        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            String currentAnswer = userAnswer.get(i);
            resultMap.put(currentQuestion, currentAnswer);
            if (currentQuestion.getAnswer().equals(currentAnswer)) {
                score++;
            }
        }

        Result result = new Result(user, new Date(), resultMap, score, maxScore);
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
