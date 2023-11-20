package com.AbderrahmaneAboussoror.quizz.services.impl;

import com.AbderrahmaneAboussoror.quizz.beans.TrainerBean;
import com.AbderrahmaneAboussoror.quizz.entities.Trainer;
import com.AbderrahmaneAboussoror.quizz.repositories.TrainerRepository;
import com.AbderrahmaneAboussoror.quizz.services.interfaces.ITrainerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService implements ITrainerService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public List<TrainerBean> findAll() {
        return List.of(modelMapper.map(trainerRepository.findAll(), TrainerBean[].class));
    }
    @Override
    public Optional<TrainerBean> findById(Integer id) {
        Optional<Trainer> trainerBeanOptional = trainerRepository.findById(id);
        return trainerBeanOptional.map(trainer -> modelMapper.map(trainer, TrainerBean.class));
    }

    @Override
    public Optional<TrainerBean> save(TrainerBean bean) {
        Trainer trainer = modelMapper.map(bean, Trainer.class);
        return Optional.ofNullable(modelMapper.map(trainerRepository.save(trainer), TrainerBean.class));
    }

    @Override
    public Optional<TrainerBean> update(Integer id, TrainerBean bean) {
        Optional<Trainer> trainerBeanOptional = trainerRepository.findById(id);
        if (trainerBeanOptional.isPresent()) {
            Trainer trainer = trainerBeanOptional.get();
            trainer.setSpeciality(bean.getSpeciality());
            trainer.setAddress(bean.getAddress());
            trainer.setFirstname(bean.getFirstname());
            trainer.setBirthdate(bean.getBirthdate());
            trainer.setLastname(bean.getLastname());
            return Optional.ofNullable(modelMapper.map(trainerRepository.save(trainer), TrainerBean.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Trainer> trainerBeanOptional = trainerRepository.findById(id);
        if (trainerBeanOptional.isPresent()) {
            trainerRepository.delete(trainerBeanOptional.get());
            return true;
        }
        return false;
    }
}
