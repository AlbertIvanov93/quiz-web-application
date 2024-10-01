package com.albert.quizintratool.repository;

import com.albert.quizintratool.model.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

    Topic findByName(String name);
}
