package com.AbderrahmaneAboussoror.quizz.services.interfaces;

import com.AbderrahmaneAboussoror.quizz.beans.Question.QuestionBean;
import com.AbderrahmaneAboussoror.quizz.beans.Question.RequestQuestionBean;
import com.AbderrahmaneAboussoror.quizz.services.IData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IQuestionService extends IData<QuestionBean, Integer> {
    Page<QuestionBean> findAll(Pageable pageable);
    Optional<QuestionBean> save(RequestQuestionBean bean);
    Optional<QuestionBean> update(Integer id, RequestQuestionBean bean);
}
