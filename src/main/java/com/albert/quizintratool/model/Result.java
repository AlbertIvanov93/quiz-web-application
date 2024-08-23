
package com.albert.quizintratool.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private List<String> question = new ArrayList<>();

    @ElementCollection
    private List<String> userAnswer = new ArrayList<>();

    public Result(User user, Date date, List<String> question, List<String> userAnswer) {
        this.user = user;
        this.date = date;
        this.question = question;
        this.userAnswer = userAnswer;
    }
}