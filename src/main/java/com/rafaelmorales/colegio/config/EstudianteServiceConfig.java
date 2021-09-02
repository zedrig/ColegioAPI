package com.rafaelmorales.colegio.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstudianteServiceConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
