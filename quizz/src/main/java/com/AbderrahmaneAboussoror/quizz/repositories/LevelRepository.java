package com.AbderrahmaneAboussoror.quizz.repositories;

import com.AbderrahmaneAboussoror.quizz.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {
}
