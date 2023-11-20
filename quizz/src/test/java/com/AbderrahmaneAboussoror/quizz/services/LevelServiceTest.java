package com.AbderrahmaneAboussoror.quizz.services;

import com.AbderrahmaneAboussoror.quizz.beans.LevelBean;
import com.AbderrahmaneAboussoror.quizz.services.impl.LevelService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class LevelServiceTest {

    @Mock
    static LevelService levelService;
    static LevelBean levelBean;

    @BeforeAll
    public static void init() {
        levelBean = new LevelBean();
        levelBean.setMinPoints(1);
        levelBean.setMaxPoints(4);
        levelBean.setDescription("this is a description");
        levelBean.setQuestions(new ArrayList<>());
    }

    @Test
    public void createLevelTest() {
        when(levelService.save(levelBean)).thenReturn(Optional.ofNullable(levelBean));
        Optional<LevelBean> levelBeanOptional = levelService.save(levelBean);
        assertTrue(levelBeanOptional.isPresent());
        assertEquals(levelBeanOptional.get(), levelBean);
    }

    @Test
    public void updateLevelTest() {
        levelBean.setDescription("this is an updated description");
        when(levelService.update(levelBean.getId() ,levelBean)).thenReturn(Optional.ofNullable(levelBean));
        Optional<LevelBean> levelBeanOptional = levelService.update(levelBean.getId() ,levelBean);
        assertTrue(levelBeanOptional.isPresent());
        assertEquals(levelBeanOptional.get().getDescription() ,levelBean.getDescription());
    }

    @Test
    public void findLevelByIdTest() {
        when(levelService.findById(levelBean.getId())).thenReturn(Optional.ofNullable(levelBean));
        Optional<LevelBean> levelBeanOptional = levelService.findById(levelBean.getId());
        assertTrue(levelBeanOptional.isPresent());
        assertEquals(levelBeanOptional.get(), levelBean);
    }

    @Test
    public void findAllLevelsTest() {
        List<LevelBean> levelBeans = new ArrayList<>();
        levelBeans.add(levelBean);
        when(levelService.findAll()).thenReturn(levelBeans);
        List<LevelBean> levelBeanList = levelService.findAll();
        assertEquals(levelBeans.size(), levelBeanList.size());
    }

    @Test
    public void deleteLevelTest() {
        when(levelService.delete(levelBean.getId())).thenReturn(true);
        boolean levelDeleted = levelService.delete(levelBean.getId());
        assertTrue(levelDeleted);
    }
}
