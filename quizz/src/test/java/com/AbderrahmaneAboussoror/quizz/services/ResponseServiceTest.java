package com.AbderrahmaneAboussoror.quizz.services;

import com.AbderrahmaneAboussoror.quizz.beans.ResponseBean;
import com.AbderrahmaneAboussoror.quizz.services.impl.ResponseService;
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
public class ResponseServiceTest {
    @Mock
    static ResponseService responseService;
    static ResponseBean responseBean;
    @BeforeAll
    public static void init() {
        responseBean = new ResponseBean();
        responseBean.setId(1);
        responseBean.setContent("this is a content");
        responseBean.setValidationList(new ArrayList<>());
    }
    @Test
    public void saveResponseTest() {
        when(responseService.save(responseBean)).thenReturn(Optional.ofNullable(responseBean));
        Optional<ResponseBean> responseBeanOptional = responseService.save(responseBean);
        assertTrue(responseBeanOptional.isPresent());
        assertEquals(responseBean, responseBeanOptional.get());
        verify(responseService).save(responseBean);
    }
    @Test
    public void updateResponseTest() {
        responseBean.setContent("this is the updated content");
        when(responseService.update(1, responseBean)).thenReturn(Optional.ofNullable(responseBean));
        Optional<ResponseBean> responseBeanOptional = responseService.update(1, responseBean);
        assertTrue(responseBeanOptional.isPresent());
        assertEquals(responseBean.getContent(), responseBeanOptional.get().getContent());
    }
    @Test
    public void findAllResponsesTest() {
        List<ResponseBean> responseBeanList = new ArrayList<>();
        responseBeanList.add(responseBean);
        when(responseService.findAll()).thenReturn(responseBeanList);
        List<ResponseBean> responseBeans = responseService.findAll();
        assertEquals(responseBeanList.size(), responseBeans.size());
    }
    @Test
    public void findResponseByIdTest() {
        when(responseService.findById(1)).thenReturn(Optional.ofNullable(responseBean));
        Optional<ResponseBean> responseBeanOptional = responseService.findById(1);
        assertTrue(responseBeanOptional.isPresent());
        assertEquals(responseBean, responseBeanOptional.get());
    }
    @Test
    public void deleteResponseTest() {
        when(responseService.delete(responseBean.getId())).thenReturn(true);
        boolean responseDeleted = responseService.delete(responseBean.getId());
        assertTrue(responseDeleted);
    }
}
