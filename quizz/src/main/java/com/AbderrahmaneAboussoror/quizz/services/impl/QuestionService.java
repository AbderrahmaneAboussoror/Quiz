package com.AbderrahmaneAboussoror.quizz.services.impl;

import com.AbderrahmaneAboussoror.quizz.beans.Question.QuestionBean;
import com.AbderrahmaneAboussoror.quizz.beans.Question.RequestQuestionBean;
import com.AbderrahmaneAboussoror.quizz.entities.Media;
import com.AbderrahmaneAboussoror.quizz.entities.Question;
import com.AbderrahmaneAboussoror.quizz.entities.Validation;
import com.AbderrahmaneAboussoror.quizz.enums.ResponseType;
import com.AbderrahmaneAboussoror.quizz.repositories.*;
import com.AbderrahmaneAboussoror.quizz.services.interfaces.IQuestionService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Log4j2
@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private LevelRepository levelRepository;

    @Override
    public List<QuestionBean> findAll() {
        return List.of(modelMapper.map(questionRepository.findAll(), QuestionBean[].class));
    }

    @Override
    public Optional<QuestionBean> findById(Integer id) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        return questionOptional.map(question -> modelMapper.map(question, QuestionBean.class));
    }

    @Override
    public Optional<QuestionBean> save(QuestionBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<QuestionBean> save(RequestQuestionBean bean) {
        Question question = modelMapper.map(bean, Question.class);
        question.setTypeQuestion(ResponseType.valueOf(bean.getTypeQuestion().name()));
        question.setSubject(
                subjectRepository.findById(bean.getSubjectId()).get()
        );
        question.setLevel(
                levelRepository.findById(bean.getLevelId()).get()
        );
        Question questionInserted = questionRepository.save(question);
        return Optional.ofNullable(modelMapper.map(questionInserted, QuestionBean.class));
    }

    @Override
    public Optional<QuestionBean> update(Integer id, QuestionBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<QuestionBean> update(Integer id, RequestQuestionBean bean) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            question.setNumberOfResponses(bean.getNumberOfResponses());
            question.setNumberOfCorrectAnswers(bean.getNumberOfCorrectAnswers());
            question.setContent(bean.getContent());
            question.setTypeQuestion(ResponseType.valueOf(bean.getTypeQuestion().name()));
            question.setPoints(bean.getPoints());
            question.setSubject(
                    subjectRepository.findById(bean.getSubjectId()).get()
            );
            question.setLevel(
                    levelRepository.findById(bean.getLevelId()).get()
            );
            return Optional.ofNullable(modelMapper.map(questionRepository.save(question), QuestionBean.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            questionRepository.delete(question);
            return true;
        }
        return false;
    }
}
