package com.rafaelmorales.colegio.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AcudientesRequest {
    @ApiModelProperty(notes = "Nombre completo del acudiente", example = "Juana", required = true)
    private String nombreAcudiente;
    @ApiModelProperty(notes = "Parentesco con el estudiante", example = "Madre", required = true)
    private String parentesto;
    @ApiModelProperty(notes = "Teléfono del acudiente", example = "555123", required = true)
    private Double telefono;
    
}
