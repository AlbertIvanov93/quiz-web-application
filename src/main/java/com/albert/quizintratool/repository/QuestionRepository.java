package com.albert.quizintratool.repository;

import com.albert.quizintratool.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, String> {

    @Query("from Question q where q.topic.id = :id order by random() limit 10")
    List<Question> findByTopicIdOrderByRandomLimit10(@Param("id") Long topicId);

    @Query("from Question q order by random() limit 10")
    List<Question> findAllOrderByRandomLimit10();
}
