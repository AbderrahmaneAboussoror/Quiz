package com.AbderrahmaneAboussoror.quizz.services.impl;

import com.AbderrahmaneAboussoror.quizz.beans.LevelBean;
import com.AbderrahmaneAboussoror.quizz.entities.Level;
import com.AbderrahmaneAboussoror.quizz.entities.Question;
import com.AbderrahmaneAboussoror.quizz.repositories.LevelRepository;
import com.AbderrahmaneAboussoror.quizz.services.interfaces.ILevelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LevelService implements ILevelService {

    private final ModelMapper modelMapper;
    private final LevelRepository levelRepository;

    public LevelService(ModelMapper modelMapper, LevelRepository levelRepository) {
        this.modelMapper = modelMapper;
        this.levelRepository = levelRepository;
    }

    @Override
    public List<LevelBean> findAll() {
        return List.of(modelMapper.map(levelRepository.findAll(), LevelBean[].class));
    }

    @Override
    public Optional<LevelBean> findById(Integer id) {
        Optional<Level> level = levelRepository.findById(id);
        return level.map(entity -> modelMapper.map(entity, LevelBean.class));
    }

    @Override
    public Optional<LevelBean> save(LevelBean bean) {
        Level level = modelMapper.map(bean, Level.class);
        Level levelInserted = levelRepository.save(level);
        return Optional.ofNullable(modelMapper.map(levelInserted, LevelBean.class));
    }

    @Override
    @Transactional
    public Optional<LevelBean> update(Integer id, LevelBean bean) {
        Optional<Level> existingLevel = levelRepository.findById(id);
        if (existingLevel.isPresent()) {
            Level level = existingLevel.get();
            level.setDescription(bean.getDescription());
            level.setMaxPoints(bean.getMaxPoints());
            level.setMinPoints(bean.getMinPoints());
            List<Question> questions = new ArrayList<>();
            if (bean.getQuestions() != null && !bean.getQuestions().isEmpty()) {
                questions = bean.getQuestions()
                        .stream()
                        .map(questionBean -> {
                            Question question = modelMapper.map(questionBean, Question.class);
                            question.setLevel(level);
                            return question;
                        })
                        .toList();
            }
            level.setQuestions(questions);
            Level updatedLevel = levelRepository.save(level);
            return Optional.ofNullable(modelMapper.map(updatedLevel, LevelBean.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Level> existingLevel = levelRepository.findById(id);
        if (existingLevel.isPresent()) {
            levelRepository.delete(existingLevel.get());
            return true;
        }
        return false;
    }
}
