package com.rafaelmorales.colegio.dto;

import com.rafaelmorales.colegio.enums.Estado;

import lombok.Data;

@Data
public class EstudianteResponse {
    private Long id;
    private String nombre;
    private double numeroIdentificacion;
    private String correo;
    private int edad;
    private Estado estado;
}
