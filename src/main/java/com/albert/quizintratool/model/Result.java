
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

    //@OneToMany
    //private List<Question> questions = new ArrayList<>(); // совместить в одну мапу
//
    //@ElementCollection
    //private List<String> userAnswer = new ArrayList<>(); // совместить в одну мапу

    @ElementCollection
    private Map<Question, String> resultMap = new HashMap<>();

    public Result(User user, Date date, Map<Question, String> resultMap) {
        this.user = user;
        this.date = date;
        this.resultMap = resultMap;
    }
}