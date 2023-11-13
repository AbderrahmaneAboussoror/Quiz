package com.AbderrahmaneAboussoror.quizz.services;

import java.util.List;
import java.util.Optional;

public interface IData<T, ID> {
    Optional<T> save(T bean);
    Optional<T> update(ID id, T bean);
    boolean delete(ID id);
    List<T> findAll();
    Optional<T> findById(ID id);
}
