package com.example.demo.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface CrudRepository<T, Integer> extends BaseRepository<T, Integer> {
    Optional<T> update(T object);
}
