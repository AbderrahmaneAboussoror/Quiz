package com.AbderrahmaneAboussoror.quizz.services.interfaces;

import com.AbderrahmaneAboussoror.quizz.beans.Subject.RequestSubjectBean;
import com.AbderrahmaneAboussoror.quizz.beans.Subject.SubjectBean;
import com.AbderrahmaneAboussoror.quizz.services.IData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISubjectService extends IData<SubjectBean, Integer> {
    Page<SubjectBean> findAll(Pageable pageable);
    Optional<SubjectBean> save(RequestSubjectBean bean);
    Optional<SubjectBean> update(int id, RequestSubjectBean bean);
}
