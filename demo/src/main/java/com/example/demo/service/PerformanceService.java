package com.example.demo.service;

import com.example.demo.dto.PerformanceDto;
import com.example.demo.dto.api.AddPerformanceDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PerformanceService {
    List<PerformanceDto> findPerformanceByPlayerFullName(String fullName);
    List<PerformanceDto> findPerformanceByNameAndDate(String fullName);
    void addPerformance(AddPerformanceDto addPerformanceDto);
    void updatePerformance(PerformanceDto updatePerformanceDto);
    Page<PerformanceDto> getPerformances(String search, int page, int size);
    PerformanceDto getPerformance(int id);
}
