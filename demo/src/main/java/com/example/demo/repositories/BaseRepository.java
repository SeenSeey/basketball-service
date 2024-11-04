package com.example.demo.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseRepository<T, Integer> extends Repository<T, Integer> {
    T save(T object);
}

