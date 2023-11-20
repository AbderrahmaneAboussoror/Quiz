package com.AbderrahmaneAboussoror.quizz.services.interfaces;

import com.AbderrahmaneAboussoror.quizz.beans.Media.MediaBean;
import com.AbderrahmaneAboussoror.quizz.beans.Media.RequestMediaBean;
import com.AbderrahmaneAboussoror.quizz.services.IData;

import java.util.Optional;

public interface IMediaService extends IData<MediaBean, Integer> {
    Optional<MediaBean> save(RequestMediaBean bean);
    Optional<MediaBean> update(Integer id, RequestMediaBean bean);
}
