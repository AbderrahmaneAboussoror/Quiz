package com.AbderrahmaneAboussoror.quizz.repositories;

import com.AbderrahmaneAboussoror.quizz.entities.AssignQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignQuizRepository extends JpaRepository<AssignQuiz, Integer> {
}
