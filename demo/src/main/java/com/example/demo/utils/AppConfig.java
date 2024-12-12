package com.example.demo.utils;

import com.example.demo.dto.PerformanceDto;
import com.example.demo.dto.api.AddPerformanceDto;
import com.example.demo.models.Performance;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<AddPerformanceDto, Performance>() {
            @Override
            protected void configure() {
                map(source.getPoints(), destination.getPoints());
                map(source.getBlocks(), destination.getBlocks());
                map(source.getPasses(), destination.getPasses());
                map(source.getThreePointsShots(), destination.getThreePointsShots());

                skip(destination.getId());
            }
        });

        return modelMapper;
    }
}


