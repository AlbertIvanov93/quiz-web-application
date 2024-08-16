/*
package com.albert.quizintratool.repository;

import com.albert.quizintratool.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("from User u " +
    "where concat(u.lastName, u.firstName)" +
    "like :username")
    User findByUsername(@Param("username")String username);
}*/
