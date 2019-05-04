package br.com.daggerexample.repository;

import java.util.List;

public interface IRepository<T> {

    void save(T entity);
    void delete(T entity);
    List<T> findAll();
    void deleteAll();


}
