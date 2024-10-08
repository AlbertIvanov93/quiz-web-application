
package com.albert.quizintratool.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
public class Result {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    private Date date;

    @ElementCollection
    @CollectionTable(name = "RESULT_MAP", joinColumns = @JoinColumn(name = "RESULT_ID"))
    //@MapKeyColumn(name = "QUESTION_ID")
    @Column(name = "USER_ANSWER")
    private Map<Question, String> resultMap = new HashMap<>();

    private int score;

    private int maxScore;
    public Result(User user, Date date, Map<Question, String> resultMap, int score, int maxScore) {
        this.user = user;
        this.date = date;
        this.resultMap = resultMap;
        this.score = score;
        this.maxScore = maxScore;
    }

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        strB.append(user.getFirstName());
        strB.append(" ");
        strB.append(user.getLastName());
        strB.append("\n");
        strB.append(formatter.format(date));
        strB.append("\n");
        strB.append(score);
        strB.append(" правильных ответов из ");
        strB.append(maxScore);
        strB.append("\n");
        strB.append("ID результата: ");
        strB.append(getId());
        strB.append("\n");
        strB.append("\n");
        resultMap.forEach((question, answer) -> {
            strB.append("Вопрос: ");
            strB.append(question.getId());
            strB.append(". ");
            strB.append(question.getTitle());
            strB.append("\n");
            strB.append("Ответ: ");
            strB.append(answer);
            strB.append("\n");
            if (answer.equals(question.getAnswer())) {
                strB.append("Правильный ответ");
            } else {
                strB.append("Неправильный ответ");
            }
            strB.append("\n");
            strB.append("\n");
        });


        return strB.toString();
    }
}