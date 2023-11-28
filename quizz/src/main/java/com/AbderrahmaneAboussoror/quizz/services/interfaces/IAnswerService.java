package com.AbderrahmaneAboussoror.quizz.services.interfaces;

import com.AbderrahmaneAboussoror.quizz.beans.Answer.AnswerBean;
import com.AbderrahmaneAboussoror.quizz.beans.Answer.RequestAnswerBean;
import com.AbderrahmaneAboussoror.quizz.services.IData;

import java.util.Optional;

public interface IAnswerService extends IData<AnswerBean, Integer> {
    Optional<AnswerBean> save(RequestAnswerBean bean);
    Optional<AnswerBean> update(Integer id, RequestAnswerBean bean);
}
