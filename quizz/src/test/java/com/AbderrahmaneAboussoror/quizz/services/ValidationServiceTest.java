package com.AbderrahmaneAboussoror.quizz.services;

import com.AbderrahmaneAboussoror.quizz.beans.Question.QuestionBean;
import com.AbderrahmaneAboussoror.quizz.beans.Question.RequestQuestionBean;
import com.AbderrahmaneAboussoror.quizz.beans.ResponseBean;
import com.AbderrahmaneAboussoror.quizz.beans.Validation.RequestValidationBean;
import com.AbderrahmaneAboussoror.quizz.beans.Validation.ValidationBean;
import com.AbderrahmaneAboussoror.quizz.enums.ResponseType;
import com.AbderrahmaneAboussoror.quizz.services.impl.QuestionService;
import com.AbderrahmaneAboussoror.quizz.services.impl.ResponseService;
import com.AbderrahmaneAboussoror.quizz.services.impl.ValidationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ValidationServiceTest {
    @Mock
    static ValidationService validationService;
    static RequestValidationBean requestValidationBean;
    static ValidationBean validationBean;
    static RequestQuestionBean requestQuestionBean;
    static QuestionBean questionBean;
    static ResponseBean responseBean;
    @BeforeAll
    public static void init() {
        requestQuestionBean = new RequestQuestionBean();
        requestQuestionBean.setId(1);
        requestQuestionBean.setContent("this is the content of a question");
        requestQuestionBean.setNumberOfResponses(3);
        requestQuestionBean.setNumberOfCorrectAnswers(1);
        requestQuestionBean.setPoints(4);
        requestQuestionBean.setTypeQuestion(ResponseType.SINGLE);
        requestQuestionBean.setLevelId(0);
        requestQuestionBean.setSubjectId(0);

        questionBean = new QuestionBean();
        questionBean.setId(1);
        questionBean.setLevel(null);
        questionBean.setSubject(null);
        questionBean.setMediaList(new ArrayList<>());
        questionBean.setValidationList(new ArrayList<>());
        questionBean.setNumberOfResponses(requestQuestionBean.getNumberOfResponses());
        questionBean.setNumberOfCorrectAnswers(requestQuestionBean.getNumberOfCorrectAnswers());
        questionBean.setContent(requestQuestionBean.getContent());
        questionBean.setPoints(requestQuestionBean.getPoints());
        questionBean.setTypeQuestion(requestQuestionBean.getTypeQuestion());

        responseBean = new ResponseBean();
        responseBean.setId(1);
        responseBean.setContent("this is a content");
        responseBean.setValidationList(new ArrayList<>());

        requestValidationBean = new RequestValidationBean();
        requestValidationBean.setPoints(5);
        requestValidationBean.setQuestionId(1);
        requestValidationBean.setResponseId(1);

        validationBean = new ValidationBean();
        validationBean.setId(1);
        validationBean.setPoints(5);
        validationBean.setResponse(responseBean);
        validationBean.setQuestion(requestQuestionBean);
        validationBean.setAnswerList(new ArrayList<>());

    }
    @Test
    public void saveValidationTest() {
        when(validationService.save(requestValidationBean)).thenReturn(Optional.ofNullable(validationBean));
        Optional<ValidationBean> validationBeanOptional = validationService.save(requestValidationBean);
        assertTrue(validationBeanOptional.isPresent());
        assertEquals(validationBean, validationBeanOptional.get());
        verify(validationService).save(requestValidationBean);
    }
    @Test
    public void updateValidationTest() {
        requestValidationBean.setPoints(2);
        validationBean.setPoints(2);
        when(validationService.update(1, requestValidationBean)).thenReturn(Optional.ofNullable(validationBean));
        Optional<ValidationBean> validationBeanOptional = validationService.update(1, requestValidationBean);
        assertTrue(validationBeanOptional.isPresent());
        assertEquals(validationBean.getPoints(), validationBeanOptional.get().getPoints());
    }
    @Test
    public void findAllValidationsTest() {
        List<ValidationBean> validationBeans = new ArrayList<>();
        validationBeans.add(validationBean);
        when(validationService.findAll()).thenReturn(validationBeans);
        List<ValidationBean> validationBeanList = validationService.findAll();
        assertEquals(validationBeans.size(), validationBeanList.size());
    }
    @Test
    public void findValidationByIdTest() {
        when(validationService.findById(1)).thenReturn(Optional.ofNullable(validationBean));
        Optional<ValidationBean> validationBeanOptional = validationService.findById(1);
        assertTrue(validationBeanOptional.isPresent());
        assertEquals(validationBean, validationBeanOptional.get());
    }
    @Test
    public void deleteValidationTest() {
        when(validationService.delete(validationBean.getId())).thenReturn(true);
        boolean validationDeleted = validationService.delete(validationBean.getId());
        assertTrue(validationDeleted);
    }
}
