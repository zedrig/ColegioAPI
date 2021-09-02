package com.rafaelmorales.colegio.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.rafaelmorales.colegio.dto.EstudianteRequest;
import com.rafaelmorales.colegio.entities.Acudientes;
import com.rafaelmorales.colegio.entities.Estudiante;
import com.rafaelmorales.colegio.enums.Estado;
import com.rafaelmorales.colegio.repository.EstudianteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante crearEstudiante(EstudianteRequest datos) {
        Estudiante estudiante = new Estudiante();

        estudiante.setNombre(datos.getNombre());
        estudiante.setNumeroIdentificacion(datos.getNumeroIdentificacion());
        estudiante.setCorreo(datos.getCorreo());
        estudiante.setEdad(datos.getEdad());
        estudiante.setEstado(Estado.ACTIVO);

        List<Acudientes> acudientes = datos.getAcudientes().stream()
                .map(mapper -> Acudientes.builder().nombreAcudiente(mapper.getNombreAcudiente())
                        .parentesto(mapper.getParentesto()).telefono(mapper.getTelefono()).estudiante(estudiante)
                        .build())
                .collect(Collectors.toList());
        estudiante.setAcudientes(acudientes);

        if (estudiante.getEdad() < 18) {
            estudianteRepository.save(estudiante);

            return estudiante;
        } else {
            return null;
        }

    }

    public List<Estudiante> mostraEstudiantes() {
        List<Estudiante> lEstudiantes = estudianteRepository.findAll();
        return lEstudiantes;
    }

    public Estudiante buscarPorId(Long id) {
        Estudiante estudiante = new Estudiante();
        estudiante = estudianteRepository.findById(id).get();
        return estudiante;
    }

    public Estudiante eliminarEstudiante(Long id) {
        Estudiante estudiante = new Estudiante();
        estudiante = buscarPorId(id);
        estudiante.setEstado(Estado.INACTIVO);
        // if (estudianteRepository.existsById(id)) {
        // estudiante.setEstado(Estado.INACTIVO);
        // //estudianteRepository.deleteById(id);
        // return estudiante;
        // }
        estudianteRepository.save(estudiante);
        return estudiante;
    }

    public Estudiante editarEstudiante(Long id, EstudianteRequest datos) {
        Estudiante estudiante = new Estudiante();
        estudiante = buscarPorId(id);
        estudiante.setNombre(datos.getNombre());
        estudiante.setNumeroIdentificacion(datos.getNumeroIdentificacion());
        estudiante.setCorreo(datos.getCorreo());
        estudiante.setEdad(datos.getEdad());

        estudianteRepository.save(estudiante);
        return estudiante;
    }

    public Estudiante buscarPorEdadyEstado(int edad, Estado estado) {
        // Cambiar este tipo de método por List<Estudiantes>, imposible debido a que el
        // metodo findByEdadAndEstado no admite List
        Estudiante estudiante = new Estudiante();
        estudiante = estudianteRepository.findByEdadAndEstado(edad, estado);
        return estudiante;
    }
}
