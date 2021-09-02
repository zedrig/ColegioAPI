package com.rafaelmorales.colegio.repository;
import com.rafaelmorales.colegio.entities.Estudiante;
import com.rafaelmorales.colegio.enums.Estado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Estudiante findByEdadAndEstado (int edad, Estado estado);

    
}
