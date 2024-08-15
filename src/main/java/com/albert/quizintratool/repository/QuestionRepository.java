package com.albert.quizintratool.repository;

import com.albert.quizintratool.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, String> {
    Question findByTopicIdAndNumber(Long topicId, Long queNum);

    List<Question> findByTopicId(Long topicId);
}
