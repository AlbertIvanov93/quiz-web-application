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
    @CollectionTable(name = "OPTION")
    @Column(name = "NAME")
    private Set<String> options = new HashSet<>();

    private String answer;

    @Column(name = "IMAGE_NAME")
    private String image;

    public Question(String title, Topic topic, Set<String> options, String answer) {
        this.title = title;
        this.topic = topic;
        this.options = options;
        this.answer = answer;
    }

    public Question(String title, Topic topic, Set<String> options, String answer, String image) {
        this.title = title;
        this.topic = topic;
        this.options = options;
        this.answer = answer;
        this.image = image;
    }
}