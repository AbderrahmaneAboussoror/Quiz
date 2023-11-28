package com.AbderrahmaneAboussoror.quizz.services.impl;

import com.AbderrahmaneAboussoror.quizz.beans.StudentBean;
import com.AbderrahmaneAboussoror.quizz.entities.Student;
import com.AbderrahmaneAboussoror.quizz.repositories.StudentRepository;
import com.AbderrahmaneAboussoror.quizz.services.interfaces.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;

    public StudentService(ModelMapper modelMapper, StudentRepository studentRepository) {
        this.modelMapper = modelMapper;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentBean> findAll() {
        return List.of(modelMapper.map(studentRepository.findAll(), StudentBean[].class));
    }

    @Override
    public Optional<StudentBean> findById(Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.map(student -> modelMapper.map(student, StudentBean.class));
    }

    @Override
    public Optional<StudentBean> save(StudentBean bean) {
        Student student = modelMapper.map(bean, Student.class);
        return Optional.ofNullable(modelMapper.map(studentRepository.save(student), StudentBean.class));
    }

    @Override
    public Optional<StudentBean> update(Integer id, StudentBean bean) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setRegisteredAt(bean.getRegisteredAt());
            student.setAddress(bean.getAddress());
            student.setFirstname(bean.getFirstname());
            student.setLastname(bean.getLastname());
            student.setBirthdate(bean.getBirthdate());
            return Optional.ofNullable(modelMapper.map(studentRepository.save(student), StudentBean.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
            return true;
        }
        return false;
    }
}
