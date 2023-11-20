package com.AbderrahmaneAboussoror.quizz.services.interfaces;

import com.AbderrahmaneAboussoror.quizz.beans.Question.QuestionBean;
import com.AbderrahmaneAboussoror.quizz.beans.Question.RequestQuestionBean;
import com.AbderrahmaneAboussoror.quizz.services.IData;

import java.util.Optional;

public interface IQuestionService extends IData<QuestionBean, Integer> {
    Optional<QuestionBean> save(RequestQuestionBean bean);
    Optional<QuestionBean> update(Integer id, RequestQuestionBean bean);
}
