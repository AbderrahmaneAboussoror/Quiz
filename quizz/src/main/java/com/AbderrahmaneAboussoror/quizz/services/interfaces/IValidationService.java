package com.AbderrahmaneAboussoror.quizz.services.interfaces;

import com.AbderrahmaneAboussoror.quizz.beans.Validation.RequestValidationBean;
import com.AbderrahmaneAboussoror.quizz.beans.Validation.ValidationBean;
import com.AbderrahmaneAboussoror.quizz.services.IData;

import java.util.Optional;

public interface IValidationService extends IData<ValidationBean, Integer> {
    Optional<ValidationBean> save(RequestValidationBean bean);
    Optional<ValidationBean> update(Integer id, RequestValidationBean bean);
}
