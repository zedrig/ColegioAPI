package com.rafaelmorales.colegio.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table (name = "tbl_acudientes")
public class Acudientes {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "nombre_acudiente")
    private String nombreAcudiente;
    @Column (name = "parentesco")
    private String parentesto;
    @Column (name = "telefono_acudiente")
    private Double telefono;
    @ManyToOne(cascade = CascadeType.ALL)
    private Estudiante estudiante;

    
}
