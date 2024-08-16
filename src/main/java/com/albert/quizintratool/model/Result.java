/*

package com.albert.quizintratool.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    @Id
    Long id;

    */
/*@ManyToOne
    private User user;*//*


    private String user;

    private Date beginDate;

    private Date endDate;

    @ElementCollection
    private List<String> question = new ArrayList<>();

    @ElementCollection
    private List<String> userAnswer = new ArrayList<>();


}

*/
