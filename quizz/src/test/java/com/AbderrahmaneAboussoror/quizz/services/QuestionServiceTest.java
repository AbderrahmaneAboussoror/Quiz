package com.AbderrahmaneAboussoror.quizz.services;

import com.AbderrahmaneAboussoror.quizz.beans.Question.QuestionBean;
import com.AbderrahmaneAboussoror.quizz.beans.Question.RequestQuestionBean;
import com.AbderrahmaneAboussoror.quizz.enums.ResponseType;
import com.AbderrahmaneAboussoror.quizz.services.impl.QuestionService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {
    @Mock
    static QuestionService questionService;
    static QuestionBean questionBean;
    static RequestQuestionBean requestQuestionBean;

    @BeforeAll
    public static void init() {
        requestQuestionBean = new RequestQuestionBean();
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
    }

    @Test
    public void createQuestionTest() {
        when(questionService.save(requestQuestionBean)).thenReturn(Optional.ofNullable(questionBean));
        Optional<QuestionBean> questionBeanOptional = questionService.save(requestQuestionBean);
        assertTrue(questionBeanOptional.isPresent());
        assertEquals(questionBean, questionBeanOptional.get());
    }

    @Test
    public void updateQuestionTest() {
        requestQuestionBean.setContent("this is the content of an updated question");
        questionBean.setContent(requestQuestionBean.getContent());
        when(questionService.update(questionBean.getId(), requestQuestionBean)).thenReturn(Optional.ofNullable(questionBean));
        Optional<QuestionBean> questionBeanOptional = questionService.update(questionBean.getId(), requestQuestionBean);
        assertTrue(questionBeanOptional.isPresent());
        assertEquals(questionBean.getContent(), questionBeanOptional.get().getContent());
    }

    @Test
    public void findQuestionById() {
        when(questionService.findById(questionBean.getId())).thenReturn(Optional.ofNullable(questionBean));
        Optional<QuestionBean> questionBeanOptional = questionService.findById(questionBean.getId());
        assertTrue(questionBeanOptional.isPresent());
        assertEquals(questionBean, questionBeanOptional.get());
    }
}
