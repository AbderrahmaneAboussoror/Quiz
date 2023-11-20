package com.AbderrahmaneAboussoror.quizz.repositories;

import com.AbderrahmaneAboussoror.quizz.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
