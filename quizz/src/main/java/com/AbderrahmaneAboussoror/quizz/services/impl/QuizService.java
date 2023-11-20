package com.AbderrahmaneAboussoror.quizz.services.impl;

import com.AbderrahmaneAboussoror.quizz.beans.Quiz.QuizBean;
import com.AbderrahmaneAboussoror.quizz.beans.Quiz.RequestQuizBean;
import com.AbderrahmaneAboussoror.quizz.entities.Quiz;
import com.AbderrahmaneAboussoror.quizz.repositories.QuizRepository;
import com.AbderrahmaneAboussoror.quizz.repositories.TrainerRepository;
import com.AbderrahmaneAboussoror.quizz.services.interfaces.IQuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService implements IQuizService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public List<QuizBean> findAll() {
        return List.of(modelMapper.map(quizRepository.findAll(), QuizBean[].class));
    }

    @Override
    public Optional<QuizBean> findById(Integer id) {
        Optional<Quiz> quizOptional = quizRepository.findById(id);
        return quizOptional.map(quiz -> modelMapper.map(quiz, QuizBean.class));
    }

    @Override
    public Optional<QuizBean> save(QuizBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<QuizBean> save(RequestQuizBean bean) {
        Quiz quiz = modelMapper.map(bean, Quiz.class);
        quiz.setTrainer(
                trainerRepository.findById(bean.getTrainerId()).get()
        );
        return Optional.ofNullable(modelMapper.map(quizRepository.save(quiz), QuizBean.class));
    }

    @Override
    public Optional<QuizBean> update(Integer id, QuizBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<QuizBean> update(Integer id, RequestQuizBean bean) {
        Optional<Quiz> quizOptional = quizRepository.findById(id);
        if (quizOptional.isPresent()) {
            Quiz quiz = quizOptional.get();
            quiz.setDuration(bean.getDuration());
            quiz.setRemarks(bean.getRemarks());
            quiz.setScore(bean.getScore());
            quiz.setShowResult(bean.getShowResult());
            quiz.setShowResponses(bean.getShowResponses());
            quiz.setTrainer(
                    trainerRepository.findById(bean.getTrainerId()).get()
            );
            quiz.setNumberOfChances(bean.getNumberOfChances());
            return Optional.ofNullable(modelMapper.map(quizRepository.save(quiz), QuizBean.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Quiz> quizOptional = quizRepository.findById(id);
        if (quizOptional.isPresent()) {
            quizRepository.delete(quizOptional.get());
            return true;
        }
        return false;
    }
}
