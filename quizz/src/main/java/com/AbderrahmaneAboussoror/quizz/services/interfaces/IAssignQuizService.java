package com.AbderrahmaneAboussoror.quizz.services.interfaces;

import com.AbderrahmaneAboussoror.quizz.beans.AssignQuiz.AssignQuizBean;
import com.AbderrahmaneAboussoror.quizz.beans.AssignQuiz.RequestAssignQuizBean;
import com.AbderrahmaneAboussoror.quizz.services.IData;

import java.util.Optional;

public interface IAssignQuizService extends IData<AssignQuizBean, Integer> {
    Optional<AssignQuizBean> save(RequestAssignQuizBean bean);
    Optional<AssignQuizBean> update(Integer integer, RequestAssignQuizBean bean);
}
