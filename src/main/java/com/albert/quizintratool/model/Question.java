package com.albert.quizintratool.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToOne
    private Topic topic;

    @ElementCollection
    @Column(name = "OPTION")
    private Set<String> options = new HashSet<>();

    private String answer;

    public Question(String title, Topic topic, Set<String> options, String answer) {
        this.title = title;
        this.topic = topic;
        this.options = options;
        this.answer = answer;
    }
}