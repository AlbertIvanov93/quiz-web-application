
package com.albert.quizintratool.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


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
}