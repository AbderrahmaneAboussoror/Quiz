package com.AbderrahmaneAboussoror.quizz.services.impl;

import com.AbderrahmaneAboussoror.quizz.beans.SubjectBean;
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
        Subject subject = modelMapper.map(bean, Subject.class);
        return Optional.ofNullable(modelMapper.map(subjectRepository.save(subject), SubjectBean.class));
    }

    @Override
    @Transactional
    public Optional<SubjectBean> update(Integer id, SubjectBean bean) {
        Optional<Subject> subjectOptional = subjectRepository.findById(id);
        if (subjectOptional.isPresent()) {
            Subject subject = subjectOptional.get();
            subject.setTitle(bean.getTitle());
            subject.setParentSubject(modelMapper.map(bean.getParentSubject(), Subject.class));
            List<Subject> childrenList = new ArrayList<>();
            if (bean.getChildren() != null && !bean.getChildren().isEmpty()) {
                childrenList = bean.getChildren()
                        .stream()
                        .map(
                                subjectBean -> modelMapper.map(subjectBean, Subject.class)
                        )
                        .toList();
            }
            subject.setChildren(childrenList);
            List<Question> questionList = new ArrayList<>();
            if (bean.getQuestions() != null && !bean.getQuestions().isEmpty()) {
                questionList = bean.getQuestions()
                        .stream()
                        .map(
                                questionBean -> modelMapper.map(questionBean, Question.class)
                        )
                        .toList();
            }
            subject.setQuestions(questionList);
            Subject updatedSubject = subjectRepository.save(subject);
            return Optional.ofNullable(modelMapper.map(updatedSubject, SubjectBean.class));
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
