package com.AbderrahmaneAboussoror.quizz.services;

import com.AbderrahmaneAboussoror.quizz.beans.Media.MediaBean;
import com.AbderrahmaneAboussoror.quizz.beans.Media.RequestMediaBean;
import com.AbderrahmaneAboussoror.quizz.enums.MediaType;
import com.AbderrahmaneAboussoror.quizz.services.impl.MediaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MediaServiceTest {
    @Mock
    static MediaService mediaService;
    static MediaBean mediaBean;
    static RequestMediaBean requestMediaBean;

    @BeforeAll
    public static void init() {
        requestMediaBean = new RequestMediaBean();
        requestMediaBean.setUrl("this is a url");
        requestMediaBean.setMediaType(MediaType.IMAGE);

        mediaBean = new MediaBean();
        mediaBean.setId(1);
        mediaBean.setMediaType(MediaType.IMAGE);
        mediaBean.setUrl("this is a url");
    }
    @Test
    public void saveMediaTest() {
        when(mediaService.save(requestMediaBean)).thenReturn(Optional.ofNullable(mediaBean));
        Optional<MediaBean> mediaBeanOptional = mediaService.save(requestMediaBean);
        assertTrue(mediaBeanOptional.isPresent());
        assertEquals(mediaBean, mediaBeanOptional.get());
        verify(mediaService).save(requestMediaBean);
    }
    @Test
    public void updateMediaTest() {
        requestMediaBean.setUrl("this is an updated url");
        mediaBean.setUrl("this is an updated url");
        when(mediaService.update(1, requestMediaBean)).thenReturn(Optional.ofNullable(mediaBean));
        Optional<MediaBean> mediaBeanOptional = mediaService.update(1, requestMediaBean);
        assertTrue(mediaBeanOptional.isPresent());
        assertEquals(mediaBean.getUrl(), mediaBeanOptional.get().getUrl());
    }
    @Test
    public void findAllMediasTest() {
        List<MediaBean> mediaBeanList = new ArrayList<>();
        mediaBeanList.add(mediaBean);
        when(mediaService.findAll()).thenReturn(mediaBeanList);
        List<MediaBean> mediaBeans = mediaService.findAll();
        assertEquals(mediaBeans.size(), mediaBeanList.size());
    }
    @Test
    public void findMediaByIdTest() {
        when(mediaService.findById(1)).thenReturn(Optional.ofNullable(mediaBean));
        Optional<MediaBean> mediaBeanOptional = mediaService.findById(1);
        assertTrue(mediaBeanOptional.isPresent());
        assertEquals(mediaBean, mediaBeanOptional.get());
    }
    @Test
    public void deleteMediaTest() {
        when(mediaService.delete(mediaBean.getId())).thenReturn(true);
        boolean mediaDeleted = mediaService.delete(mediaBean.getId());
        assertTrue(mediaDeleted);
    }
}
