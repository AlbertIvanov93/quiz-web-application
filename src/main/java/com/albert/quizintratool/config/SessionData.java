package com.albert.quizintratool.config;

import com.albert.quizintratool.model.Question;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Scope("session")
public class SessionData {

    private Date beginDate = new Date();

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
}
