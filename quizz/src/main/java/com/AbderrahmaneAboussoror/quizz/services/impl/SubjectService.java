package com.AbderrahmaneAboussoror.quizz.services.impl;

import com.AbderrahmaneAboussoror.quizz.beans.Subject.RequestSubjectBean;
import com.AbderrahmaneAboussoror.quizz.beans.Subject.SubjectBean;
import com.AbderrahmaneAboussoror.quizz.entities.Question;
import com.AbderrahmaneAboussoror.quizz.entities.Subject;
import com.AbderrahmaneAboussoror.quizz.repositories.SubjectRepository;
import com.AbderrahmaneAboussoror.quizz.services.interfaces.ISubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements ISubjectService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<SubjectBean> findAll() {
        return List.of(modelMapper.map(subjectRepository.findAll(), SubjectBean[].class));
    }

    @Override
    public Optional<SubjectBean> findById(Integer id) {
        Optional<Subject> subjectOptional = subjectRepository.findById(id);
        return subjectOptional.map(subject -> modelMapper.map(subject, SubjectBean.class));
    }

    @Override
    public Optional<SubjectBean> save(SubjectBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<SubjectBean> save(RequestSubjectBean bean) {
        Subject subject = modelMapper.map(bean, Subject.class);
        if(bean.getParentId() != 0) {
            subject.setParentSubject(
                    subjectRepository.findById(bean.getParentId()).get()
            );
        }
        return Optional.ofNullable(modelMapper.map(subjectRepository.save(subject), SubjectBean.class));
    }

    @Override
    @Transactional
    public Optional<SubjectBean> update(Integer id, SubjectBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<SubjectBean> update(int id, RequestSubjectBean bean) {
        boolean changed = false;
        Optional<Subject> subjectOptional = subjectRepository.findById(id);
        if (subjectOptional.isPresent()) {
            Subject subject = subjectOptional.get();
            if (bean.getParentId() != 0) {
                subject.setParentSubject(subjectRepository.findById(bean.getParentId()).get());
                changed = true;
            }
            if (!bean.getTitle().isEmpty()) {
                subject.setTitle(bean.getTitle());
                changed = true;
            }
            if (changed) {
                return Optional.ofNullable(modelMapper.map(subjectRepository.save(subject), SubjectBean.class));
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Subject> subjectOptional = subjectRepository.findById(id);
        if (subjectOptional.isPresent()) {
            subjectRepository.delete(subjectOptional.get());
            return true;
        }
        return false;
    }
}
