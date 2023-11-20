package com.AbderrahmaneAboussoror.quizz.repositories;

import com.AbderrahmaneAboussoror.quizz.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> {
}
