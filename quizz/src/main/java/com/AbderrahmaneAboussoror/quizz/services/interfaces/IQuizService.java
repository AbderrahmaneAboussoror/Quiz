package com.AbderrahmaneAboussoror.quizz.services.interfaces;

import com.AbderrahmaneAboussoror.quizz.beans.Quiz.QuizBean;
import com.AbderrahmaneAboussoror.quizz.beans.Quiz.RequestQuizBean;
import com.AbderrahmaneAboussoror.quizz.services.IData;

import java.util.Optional;

public interface IQuizService extends IData<QuizBean, Integer> {
    Optional<QuizBean> save(RequestQuizBean bean);
    Optional<QuizBean> update(Integer integer, RequestQuizBean bean);
}
