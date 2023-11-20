package com.AbderrahmaneAboussoror.quizz.repositories;

import com.AbderrahmaneAboussoror.quizz.entities.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationRepository extends JpaRepository<Validation, Integer> {
}
