package com.albert.quizintratool.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Question {
    @Id
    private String question;

    private String topic;

    private int number;

    @OneToMany
    private List<String> options;
}
