package com.rafaelmorales.colegio.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rafaelmorales.colegio.enums.Estado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_estudiante")
    private String nombre;
    @Column (name = "identificacion")
    private double numeroIdentificacion;
    @Column (name = "correo")
    private String correo;
    @Column (name = "edad")
    private int edad;
    @Column (name = "estado")
    private Estado estado;
    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<Acudientes> acudientes;
    
}
