package com.rafaelmorales.colegio.util;

import java.util.List;
import java.util.stream.Collectors;

import com.rafaelmorales.colegio.dto.EstudianteResponse;
import com.rafaelmorales.colegio.entities.Estudiante;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstudianteConverter {
    @Autowired
    private ModelMapper modelMapper;

    public EstudianteResponse convertirEntidad (Estudiante estudiante){
        return modelMapper.map(estudiante, EstudianteResponse.class);
    }

    public List<EstudianteResponse> convertirEntidad (List<Estudiante> estudiantes){
        return estudiantes.stream().map(mapper -> convertirEntidad(mapper)).collect(Collectors.toList());
    }
}
