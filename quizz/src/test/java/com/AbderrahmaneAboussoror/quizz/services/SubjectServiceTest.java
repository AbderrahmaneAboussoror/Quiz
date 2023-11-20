package com.AbderrahmaneAboussoror.quizz.services;

import com.AbderrahmaneAboussoror.quizz.beans.Subject.RequestSubjectBean;
import com.AbderrahmaneAboussoror.quizz.beans.Subject.SubjectBean;
import com.AbderrahmaneAboussoror.quizz.services.impl.SubjectService;
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
public class SubjectServiceTest {
    @Mock
    static SubjectService subjectService;
    static RequestSubjectBean requestSubjectBean;
    static SubjectBean subjectBean;

    @BeforeAll
    public static void init() {
        requestSubjectBean = new RequestSubjectBean();
        requestSubjectBean.setTitle("this is a title");
        requestSubjectBean.setParentId(0);
        requestSubjectBean.setParent(null);

        subjectBean = new SubjectBean();
        subjectBean.setId(1);
        subjectBean.setTitle(requestSubjectBean.getTitle());
        subjectBean.setParentSubject(null);
        subjectBean.setChildren(new ArrayList<>());
        subjectBean.setQuestions(new ArrayList<>());
    }

    @Test
    public void createSubjectTest() {
        when(subjectService.save(requestSubjectBean)).thenReturn(Optional.ofNullable(subjectBean));
        Optional<SubjectBean> subjectBeanOptional = subjectService.save(requestSubjectBean);
        assertTrue(subjectBeanOptional.isPresent());
        assertEquals(subjectBean, subjectBeanOptional.get());
    }

    @Test
    public void updateSubjectTest() {
        requestSubjectBean.setTitle("this is an updated title");
        subjectBean.setTitle(requestSubjectBean.getTitle());
        when(subjectService.update(subjectBean.getId(), requestSubjectBean)).thenReturn(Optional.ofNullable(subjectBean));
        Optional<SubjectBean> subjectBeanOptional = subjectService.update(subjectBean.getId() ,requestSubjectBean);
        assertTrue(subjectBeanOptional.isPresent());
        assertEquals(subjectBean.getTitle(), subjectBeanOptional.get().getTitle());
    }

    @Test
    public void findSubjectById() {
        when(subjectService.findById(subjectBean.getId())).thenReturn(Optional.ofNullable(subjectBean));
        Optional<SubjectBean> subjectBeanOptional = subjectService.findById(subjectBean.getId());
        assertTrue(subjectBeanOptional.isPresent());
        assertEquals(subjectBean, subjectBeanOptional.get());
    }

    @Test
    public void findAllSubjects() {
        List<SubjectBean> subjectBeans = new ArrayList<>();
        subjectBeans.add(subjectBean);
        when(subjectService.findAll()).thenReturn(subjectBeans);
        List<SubjectBean> subjectBeanList = subjectService.findAll();
        assertEquals(subjectBeans.size(), subjectBeanList.size());
    }

    @Test
    public void deleteSubjectTest() {
        when(subjectService.delete(subjectBean.getId())).thenReturn(true);
        boolean subjectDeleted = subjectService.delete(subjectBean.getId());
        assertTrue(subjectDeleted);
    }
}
