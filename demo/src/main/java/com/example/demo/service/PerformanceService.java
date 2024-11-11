package com.example.demo.service;

import com.example.demo.dto.PerformanceDto;
import com.example.demo.dto.api.AddPerformanceDto;

import java.util.List;
import java.util.Optional;

public interface PerformanceService {
    List<PerformanceDto> findPerformanceByPlayerFullName(String fullName);
    List<PerformanceDto> findPerformanceByNameAndDate(String fullName);
    PerformanceDto addPerformance(AddPerformanceDto addPerformanceDto);
    Optional<PerformanceDto> updatePerformance(PerformanceDto updatePerformanceDto);
}
