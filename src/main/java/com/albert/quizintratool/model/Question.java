package com.albert.quizintratool.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Question {

    @Id
    private String title;

    @ManyToOne
    private Topic topic;

    private int number;

    @ElementCollection
    @Column(name = "OPTION")
    private Set<String> options = new HashSet<>();

    private String answer;
}