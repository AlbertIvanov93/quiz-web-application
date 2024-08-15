package com.albert.quizintratool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Result {

    @Id
    Long id;

    @ManyToOne
    private User user;

    private Date beginQuizDate;

    private Date endQuizDate;



}
