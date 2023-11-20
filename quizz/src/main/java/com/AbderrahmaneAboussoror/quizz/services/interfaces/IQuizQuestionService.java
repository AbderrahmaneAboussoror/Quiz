package com.AbderrahmaneAboussoror.quizz.services.interfaces;

import com.AbderrahmaneAboussoror.quizz.beans.QuizQuestion.QuizQuestionBean;
import com.AbderrahmaneAboussoror.quizz.beans.QuizQuestion.RequestQuizQuestionBean;
import com.AbderrahmaneAboussoror.quizz.services.IData;

import java.util.Optional;

public interface IQuizQuestionService extends IData<QuizQuestionBean, Integer> {
    Optional<QuizQuestionBean> save(RequestQuizQuestionBean bean);
    Optional<QuizQuestionBean> update(Integer integer, RequestQuizQuestionBean bean);
}
