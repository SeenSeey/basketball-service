package com.example.demo.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface CrudRepository<T, Integer> extends BaseRepository<T, Integer> {
    T update(T object);
}
