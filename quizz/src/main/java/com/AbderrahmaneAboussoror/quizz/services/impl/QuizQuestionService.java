package com.AbderrahmaneAboussoror.quizz.services.impl;

import com.AbderrahmaneAboussoror.quizz.beans.QuizQuestion.QuizQuestionBean;
import com.AbderrahmaneAboussoror.quizz.beans.QuizQuestion.RequestQuizQuestionBean;
import com.AbderrahmaneAboussoror.quizz.entities.QuizQuestion;
import com.AbderrahmaneAboussoror.quizz.repositories.QuestionRepository;
import com.AbderrahmaneAboussoror.quizz.repositories.QuizQuestionRepository;
import com.AbderrahmaneAboussoror.quizz.repositories.QuizRepository;
import com.AbderrahmaneAboussoror.quizz.services.interfaces.IQuizQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizQuestionService implements IQuizQuestionService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private QuizQuestionRepository quizQuestionRepository;
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<QuizQuestionBean> findAll() {
        return List.of(modelMapper.map(quizQuestionRepository.findAll(), QuizQuestionBean[].class));
    }

    @Override
    public Optional<QuizQuestionBean> findById(Integer id) {
        Optional<QuizQuestion> quizQuestionOptional = quizQuestionRepository.findById(id);
        return quizQuestionOptional.map(quizQuestion -> modelMapper.map(quizQuestion, QuizQuestionBean.class));
    }

    @Override
    public Optional<QuizQuestionBean> save(QuizQuestionBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<QuizQuestionBean> save(RequestQuizQuestionBean bean) {
        QuizQuestion quizQuestion = modelMapper.map(bean, QuizQuestion.class);
        quizQuestion.setQuestion(
                questionRepository.findById(bean.getQuestionId()).get()
        );
        quizQuestion.setQuiz(
                quizRepository.findById(bean.getQuizId()).get()
        );
        return Optional.ofNullable(modelMapper.map(quizQuestionRepository.save(quizQuestion), QuizQuestionBean.class));
    }

    @Override
    public Optional<QuizQuestionBean> update(Integer id, QuizQuestionBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<QuizQuestionBean> update(Integer id, RequestQuizQuestionBean bean) {
        Optional<QuizQuestion> quizQuestionOptional = quizQuestionRepository.findById(id);
        if (quizQuestionOptional.isPresent()) {
            QuizQuestion quizQuestion = quizQuestionOptional.get();
            quizQuestion.setDuration(bean.getDuration());
            quizQuestion.setQuestion(
                    questionRepository.findById(bean.getQuestionId()).get()
            );
            quizQuestion.setQuiz(
                    quizRepository.findById(bean.getQuizId()).get()
            );
            return Optional.ofNullable(modelMapper.map(quizQuestionRepository.save(quizQuestion), QuizQuestionBean.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        Optional<QuizQuestion> quizQuestionOptional = quizQuestionRepository.findById(id);
        if (quizQuestionOptional.isPresent()) {
            quizQuestionRepository.delete(quizQuestionOptional.get());
            return true;
        }
        return false;
    }
}
