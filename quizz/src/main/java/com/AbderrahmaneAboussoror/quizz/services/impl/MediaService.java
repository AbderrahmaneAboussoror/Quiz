package com.AbderrahmaneAboussoror.quizz.services.impl;

import com.AbderrahmaneAboussoror.quizz.beans.Media.MediaBean;
import com.AbderrahmaneAboussoror.quizz.beans.Media.RequestMediaBean;
import com.AbderrahmaneAboussoror.quizz.entities.Media;
import com.AbderrahmaneAboussoror.quizz.enums.MediaType;
import com.AbderrahmaneAboussoror.quizz.repositories.MediaRepository;
import com.AbderrahmaneAboussoror.quizz.repositories.QuestionRepository;
import com.AbderrahmaneAboussoror.quizz.services.interfaces.IMediaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService implements IMediaService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MediaRepository mediaRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<MediaBean> findAll() {
        return List.of(modelMapper.map(mediaRepository.findAll(), MediaBean[].class));
    }

    @Override
    public Optional<MediaBean> findById(Integer id) {
        Optional<Media> mediaOptional = mediaRepository.findById(id);
        return mediaOptional.map(media -> modelMapper.map(media, MediaBean.class));
    }

    @Override
    public Optional<MediaBean> save(MediaBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<MediaBean> save(RequestMediaBean bean) {
        Media media = modelMapper.map(bean, Media.class);
        media.setQuestion(
                questionRepository.findById(bean.getQuestionId()).get()
        );
        return Optional.ofNullable(modelMapper.map(mediaRepository.save(media), MediaBean.class));
    }

    @Override
    public Optional<MediaBean> update(Integer id, MediaBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<MediaBean> update(Integer id, RequestMediaBean bean) {
        Optional<Media> mediaOptional = mediaRepository.findById(id);
        if (mediaOptional.isPresent()) {
            Media media = mediaOptional.get();
            media.setUrl(bean.getUrl());
            media.setMediaType(
                    MediaType.valueOf(bean.getMediaType().name())
            );
            media.setQuestion(
                    questionRepository.findById(bean.getQuestionId()).get()
            );
            return Optional.ofNullable(modelMapper.map(mediaRepository.save(media), MediaBean.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Media> mediaOptional = mediaRepository.findById(id);
        if (mediaOptional.isPresent()) {
            mediaRepository.delete(mediaOptional.get());
            return true;
        }
        return false;
    }
}
