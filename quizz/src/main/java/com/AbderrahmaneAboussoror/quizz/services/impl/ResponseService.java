package com.AbderrahmaneAboussoror.quizz.services.impl;

import com.AbderrahmaneAboussoror.quizz.beans.ResponseBean;
import com.AbderrahmaneAboussoror.quizz.entities.Response;
import com.AbderrahmaneAboussoror.quizz.entities.Validation;
import com.AbderrahmaneAboussoror.quizz.repositories.ResponseRepository;
import com.AbderrahmaneAboussoror.quizz.services.interfaces.IResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResponseService implements IResponseService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ResponseRepository responseRepository;

    @Override
    public List<ResponseBean> findAll() {
        return List.of(modelMapper.map(responseRepository.findAll(), ResponseBean[].class));
    }

    @Override
    public Optional<ResponseBean> findById(Integer id) {
        Optional<Response> responseFound = responseRepository.findById(id);
        return responseFound.map(response -> modelMapper.map(response, ResponseBean.class));
    }

    @Override
    public Optional<ResponseBean> save(ResponseBean bean) {
        Response response = modelMapper.map(bean, Response.class);
        return Optional.ofNullable(modelMapper.map(responseRepository.save(response), ResponseBean.class));
    }

    @Override
    @Transactional
    public Optional<ResponseBean> update(Integer id, ResponseBean bean) {
        Optional<Response> responseOptional = responseRepository.findById(id);
        if (responseOptional.isPresent()) {
            Response response = responseOptional.get();
            response.setContent(bean.getContent());
            List<Validation> validationList = new ArrayList<>();
            if (bean.getValidationList() != null && !bean.getValidationList().isEmpty()) {
                validationList = bean.getValidationList()
                        .stream()
                        .map(
                                validationBean -> {
                                    Validation validation = modelMapper.map(validationBean, Validation.class);
                                    validation.setResponse(response);
                                    return validation;
                                }
                        )
                        .toList();
            }
            response.setValidationList(validationList);
            Response updatedResponse = responseRepository.save(response);
            return Optional.ofNullable(modelMapper.map(updatedResponse, ResponseBean.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Response> responseOptional = responseRepository.findById(id);
        if (responseOptional.isPresent()){
            responseRepository.delete(responseOptional.get());
            return true;
        }
        return false;
    }
}
