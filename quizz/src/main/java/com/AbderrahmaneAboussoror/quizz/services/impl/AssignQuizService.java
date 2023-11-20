package com.AbderrahmaneAboussoror.quizz.services.impl;

import com.AbderrahmaneAboussoror.quizz.beans.AssignQuiz.AssignQuizBean;
import com.AbderrahmaneAboussoror.quizz.beans.AssignQuiz.RequestAssignQuizBean;
import com.AbderrahmaneAboussoror.quizz.entities.AssignQuiz;
import com.AbderrahmaneAboussoror.quizz.repositories.AssignQuizRepository;
import com.AbderrahmaneAboussoror.quizz.repositories.QuizRepository;
import com.AbderrahmaneAboussoror.quizz.repositories.StudentRepository;
import com.AbderrahmaneAboussoror.quizz.services.interfaces.IAssignQuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignQuizService implements IAssignQuizService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AssignQuizRepository assignQuizRepository;
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<AssignQuizBean> findAll() {
        return List.of(modelMapper.map(assignQuizRepository.findAll(), AssignQuizBean[].class));
    }

    @Override
    public Optional<AssignQuizBean> findById(Integer id) {
        Optional<AssignQuiz> assignQuizOptional = assignQuizRepository.findById(id);
        return assignQuizOptional.map(assignQuiz -> modelMapper.map(assignQuiz, AssignQuizBean.class));
    }

    @Override
    public Optional<AssignQuizBean> save(AssignQuizBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<AssignQuizBean> save(RequestAssignQuizBean bean) {
        AssignQuiz assignQuiz = modelMapper.map(bean, AssignQuiz.class);
        assignQuiz.setStudent(
                studentRepository.findById(bean.getStudentId()).get()
        );
        assignQuiz.setQuiz(
                quizRepository.findById(bean.getQuizId()).get()
        );
        return Optional.of(modelMapper.map(assignQuizRepository.save(assignQuiz), AssignQuizBean.class));
    }

    @Override
    public Optional<AssignQuizBean> update(Integer id, AssignQuizBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<AssignQuizBean> update(Integer id, RequestAssignQuizBean bean) {
        Optional<AssignQuiz> assignQuizOptional = assignQuizRepository.findById(id);
        if (assignQuizOptional.isPresent()) {
            AssignQuiz assignQuiz = assignQuizOptional.get();
            assignQuiz.setResult(bean.getResult());
            assignQuiz.setScore(bean.getScore());
            assignQuiz.setEndedAt(bean.getEndedAt());
            assignQuiz.setStartedAt(bean.getStartedAt());
            assignQuiz.setStudent(
                    studentRepository.findById(bean.getStudentId()).get()
            );
            assignQuiz.setQuiz(
                    quizRepository.findById(bean.getQuizId()).get()
            );
            return Optional.ofNullable(modelMapper.map(assignQuizRepository.save(assignQuiz), AssignQuizBean.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        Optional<AssignQuiz> assignQuizOptional = assignQuizRepository.findById(id);
        if (assignQuizOptional.isPresent()) {
            assignQuizRepository.delete(assignQuizOptional.get());
            return true;
        }
        return false;
    }
}
