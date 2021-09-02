package com.rafaelmorales.colegio.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EstudianteRequest {
    @ApiModelProperty(notes = "Nombre completo del estudiante", example = "Pedro", required = true)
    private String nombre;
    @ApiModelProperty(notes = "Numero de identificación del estudiante", example = "123", required = true)
    private double numeroIdentificacion;
    @ApiModelProperty(notes = "Correo personal del estudiante", example = "Pedro@correo", required = true)
    private String correo;
    @ApiModelProperty(notes = "Edad del estudiante", example = "15", required = true)
    private int edad;
    private List<AcudientesRequest> acudientes;
}
