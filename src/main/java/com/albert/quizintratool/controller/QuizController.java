package com.albert.quizintratool.controller;

import com.albert.quizintratool.model.Question;
import com.albert.quizintratool.model.Result;
import com.albert.quizintratool.model.User;
import com.albert.quizintratool.repository.QuestionRepository;
import com.albert.quizintratool.repository.ResultRepository;
import com.albert.quizintratool.repository.TopicRepository;
import com.albert.quizintratool.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/quiz/")
@SessionAttributes("questions")
@RequiredArgsConstructor
public class QuizController {

    private final TopicRepository topicRepository;
    private final QuestionRepository questionRepository;
    private final ResultRepository resultRepository;
    private final MailSenderService mailSenderService;

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
    public String getResult(Model model,
                            @RequestParam(name = "answer[0]", defaultValue = "Время вышло") String answer0,
                            @RequestParam(name = "answer[1]", defaultValue = "Время вышло") String answer1,
                            @RequestParam(name = "answer[2]", defaultValue = "Время вышло") String answer2,
                            @RequestParam(name = "answer[3]", defaultValue = "Время вышло") String answer3,
                            @RequestParam(name = "answer[4]", defaultValue = "Время вышло") String answer4,
                            @RequestParam(name = "answer[5]", defaultValue = "Время вышло") String answer5,
                            @RequestParam(name = "answer[6]", defaultValue = "Время вышло") String answer6,
                            @RequestParam(name = "answer[7]", defaultValue = "Время вышло") String answer7,
                            @RequestParam(name = "answer[8]", defaultValue = "Время вышло") String answer8,
                            @RequestParam(name = "answer[9]", defaultValue = "Время вышло") String answer9,
                            @RequestParam(name = "answer[10]", defaultValue = "Время вышло") String answer10,
                            @RequestParam(name = "answer[11]", defaultValue = "Время вышло") String answer11,
                            @RequestParam(name = "answer[12]", defaultValue = "Время вышло") String answer12,
                            @RequestParam(name = "answer[13]", defaultValue = "Время вышло") String answer13,
                            @RequestParam(name = "answer[14]", defaultValue = "Время вышло") String answer14,
                            @RequestParam(name = "answer[15]", defaultValue = "Время вышло") String answer15,
                            @RequestParam(name = "answer[16]", defaultValue = "Время вышло") String answer16,
                            @RequestParam(name = "answer[17]", defaultValue = "Время вышло") String answer17,
                            @RequestParam(name = "answer[18]", defaultValue = "Время вышло") String answer18,
                            @RequestParam(name = "answer[19]", defaultValue = "Время вышло") String answer19,
                            @RequestParam(name = "answer[20]", defaultValue = "Время вышло") String answer20,
                            @RequestParam(name = "answer[21]", defaultValue = "Время вышло") String answer21,
                            @RequestParam(name = "answer[22]", defaultValue = "Время вышло") String answer22,
                            @RequestParam(name = "answer[23]", defaultValue = "Время вышло") String answer23,
                            @RequestParam(name = "answer[24]", defaultValue = "Время вышло") String answer24,
                            @RequestParam(name = "answer[25]", defaultValue = "Время вышло") String answer25,
                            @RequestParam(name = "answer[26]", defaultValue = "Время вышло") String answer26,
                            @RequestParam(name = "answer[27]", defaultValue = "Время вышло") String answer27,
                            @RequestParam(name = "answer[28]", defaultValue = "Время вышло") String answer28,
                            @RequestParam(name = "answer[29]", defaultValue = "Время вышло") String answer29
    ) {


        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Question> questions = (List<Question>) model.getAttribute("questions");
        Map<Question, String> resultMap = new HashMap<>();

        List<String> userAnswer = List.of(answer0, answer1, answer2, answer3, answer4,
                answer5, answer6, answer7, answer8, answer9, answer10, answer11, answer12,
                answer13, answer14, answer15, answer16, answer17, answer18, answer19,
                answer20, answer21, answer22, answer23, answer24, answer25, answer26,
                answer27, answer28, answer29);


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
        mailSenderService.send(result.toString());
        return "redirect:/result/?id=" + result.getId();
    }

    private void addAttributeToModel(Long topicId, Model model) {
        String modelQuestionsName = "questions";
        List<Question> questions;
        if (topicId.equals(topicRepository.findByName("Общий тест").getId())) {
            questions = questionRepository.findAllOrderByRandomLimit30();
        } else {
            questions = questionRepository.findByTopicIdOrderByRandomLimit10(topicId);
        }
        model.addAttribute(modelQuestionsName, questions);
    }
}
