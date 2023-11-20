package com.AbderrahmaneAboussoror.quizz.services.impl;

import com.AbderrahmaneAboussoror.quizz.beans.Validation.RequestValidationBean;
import com.AbderrahmaneAboussoror.quizz.beans.Validation.ValidationBean;
import com.AbderrahmaneAboussoror.quizz.entities.Validation;
import com.AbderrahmaneAboussoror.quizz.repositories.QuestionRepository;
import com.AbderrahmaneAboussoror.quizz.repositories.ResponseRepository;
import com.AbderrahmaneAboussoror.quizz.repositories.ValidationRepository;
import com.AbderrahmaneAboussoror.quizz.services.interfaces.IValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValidationService implements IValidationService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ResponseRepository responseRepository;

    @Override
    public List<ValidationBean> findAll() {
        return List.of(modelMapper.map(validationRepository.findAll(), ValidationBean[].class));
    }

    @Override
    public Optional<ValidationBean> findById(Integer id) {
        Optional<Validation> validationOptional = validationRepository.findById(id);
        return validationOptional.map(validation -> modelMapper.map(validation, ValidationBean.class));
    }

    @Override
    public Optional<ValidationBean> save(ValidationBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<ValidationBean> save(RequestValidationBean bean) {
        Validation validation = modelMapper.map(bean, Validation.class);
        validation.setQuestion(
                questionRepository.findById(bean.getQuestionId()).get()
        );
        validation.setResponse(
                responseRepository.findById(bean.getResponseId()).get()
        );
        return Optional.ofNullable(modelMapper.map(validationRepository.save(validation), ValidationBean.class));
    }

    @Override
    public Optional<ValidationBean> update(Integer id, ValidationBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<ValidationBean> update(Integer id, RequestValidationBean bean) {
        Optional<Validation> validationOptional = validationRepository.findById(id);
        if (validationOptional.isPresent()) {
            Validation validation = validationOptional.get();
            validation.setPoints(bean.getPoints());
            validation.setQuestion(
                    questionRepository.findById(bean.getQuestionId()).get()
            );
            validation.setResponse(
                    responseRepository.findById(bean.getResponseId()).get()
            );
            return Optional.ofNullable(modelMapper.map(validationRepository.save(validation), ValidationBean.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Validation> validationOptional = validationRepository.findById(id);
        if (validationOptional.isPresent()) {
            validationRepository.delete(validationOptional.get());
            return true;
        }
        return false;
    }
}
