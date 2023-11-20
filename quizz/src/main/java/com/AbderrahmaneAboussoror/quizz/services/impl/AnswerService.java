package com.AbderrahmaneAboussoror.quizz.services.impl;

import com.AbderrahmaneAboussoror.quizz.beans.Answer.AnswerBean;
import com.AbderrahmaneAboussoror.quizz.beans.Answer.RequestAnswerBean;
import com.AbderrahmaneAboussoror.quizz.entities.Answer;
import com.AbderrahmaneAboussoror.quizz.repositories.AnswerRepository;
import com.AbderrahmaneAboussoror.quizz.repositories.AssignQuizRepository;
import com.AbderrahmaneAboussoror.quizz.repositories.ValidationRepository;
import com.AbderrahmaneAboussoror.quizz.services.interfaces.IAnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService implements IAnswerService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private AssignQuizRepository assignQuizRepository;
    @Autowired
    private ValidationRepository validationRepository;

    @Override
    public List<AnswerBean> findAll() {
        return List.of(modelMapper.map(answerRepository.findAll(), AnswerBean[].class));
    }

    @Override
    public Optional<AnswerBean> findById(Integer id)
    {
        Optional<Answer> answerOptional = answerRepository.findById(id);
        return answerOptional.map(answer -> modelMapper.map(answer, AnswerBean.class));
    }

    @Override
    public Optional<AnswerBean> save(AnswerBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<AnswerBean> save(RequestAnswerBean bean) {
        Answer answer = modelMapper.map(bean, Answer.class);
        answer.setValidation(
                validationRepository.findById(bean.getValidationId()).get()
        );
        answer.setAssignQuiz(
                assignQuizRepository.findById(bean.getAssignQuizId()).get()
        );
        return Optional.ofNullable(modelMapper.map(answerRepository.save(answer), AnswerBean.class));
    }

    @Override
    public Optional<AnswerBean> update(Integer id, AnswerBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<AnswerBean> update(Integer id, RequestAnswerBean bean) {
        Optional<Answer> answerOptional = answerRepository.findById(id);
        if (answerOptional.isPresent()) {
            Answer answer = answerOptional.get();
            answer.setValidation(
                    validationRepository.findById(bean.getValidationId()).get()
            );
            answer.setAssignQuiz(
                    assignQuizRepository.findById(bean.getAssignQuizId()).get()
            );
            return Optional.ofNullable(modelMapper.map(answerRepository.save(answer), AnswerBean.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Answer> answerOptional = answerRepository.findById(id);
        if (answerOptional.isPresent()) {
            answerRepository.delete(answerOptional.get());
            return true;
        }
        return false;
    }
}
