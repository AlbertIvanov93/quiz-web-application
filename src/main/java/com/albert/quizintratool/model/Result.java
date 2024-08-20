
package com.albert.quizintratool.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    private User user;

    private Date beginDate;

    private Date endDate;

    @ElementCollection
    private List<String> question = new ArrayList<>();

    @ElementCollection
    private List<String> userAnswer = new ArrayList<>();


}

