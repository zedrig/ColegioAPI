package com.rafaelmorales.colegio.controller;

import java.util.List;

import com.rafaelmorales.colegio.Service.EstudianteService;
import com.rafaelmorales.colegio.dto.EstudianteRequest;
import com.rafaelmorales.colegio.dto.EstudianteResponse;
import com.rafaelmorales.colegio.entities.Estudiante;
import com.rafaelmorales.colegio.enums.Estado;
import com.rafaelmorales.colegio.util.EstudianteConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class EstudianteController {
    
    @Autowired
    private EstudianteService estudianteService;
    @Autowired
    private EstudianteConverter converter;

    @PostMapping(value = "estudiante")
    @ApiOperation(value = "Crear estudiante", notes = "Método para ingresar nuevos estudiantes")
    public ResponseEntity<EstudianteResponse> crearEstudiante (@RequestBody EstudianteRequest datos){
        Estudiante estudiante = estudianteService.crearEstudiante(datos);
        if (estudiante == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(converter.convertirEntidad(estudiante),HttpStatus.OK);
    }

    @DeleteMapping(value = "estudiante/{id}")
    @ApiOperation(value = "Eliminar estudiante", notes = "Método para eliminar estudiantes")
    public ResponseEntity<Estado> eliminarEstudiante(@PathVariable Long id){
        Estado existeEstudiante = estudianteService.eliminarEstudiante(id).getEstado();
        if (existeEstudiante == Estado.INACTIVO) {

            return new ResponseEntity<>(Estado.INACTIVO, HttpStatus.OK);
        }
        return new ResponseEntity<>(Estado.ACTIVO, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "estudiante")
    @ApiOperation(value = "Listar estudiantes", notes = "Método para mostrar todos los estudiantes")
    public ResponseEntity<List<EstudianteResponse>> listarEstudiantes(){
        List<Estudiante> lEstudiantes = estudianteService.mostraEstudiantes();
        return new ResponseEntity<>(converter.convertirEntidad(lEstudiantes), HttpStatus.OK);
    }

    @GetMapping(value = "estudiante/{id}")
    @ApiOperation(value = "Mostrar estudiantes ID", notes = "Método para mostrar estudiantes por su ID")
    public ResponseEntity<EstudianteResponse> buscarEstudianteId(@PathVariable Long id){
        Estudiante estudiante = estudianteService.buscarPorId(id);
        return new ResponseEntity<>(converter.convertirEntidad(estudiante), HttpStatus.OK);
    }

    @PutMapping (value = "estudiante/{id}")
    @ApiOperation(value = "Editar estudiante", notes = "Método para editar antiguos estudiantes")
    public ResponseEntity<EstudianteResponse> editarEstudiante (@PathVariable Long id, @RequestBody EstudianteRequest datos){
        Estudiante estudiante = estudianteService.editarEstudiante(id, datos);
        return new ResponseEntity<>(converter.convertirEntidad(estudiante), HttpStatus.OK) ;
    }

    @GetMapping (value = "estudiante/{edad}/{estado}")
    @ApiOperation(value = "Mostrar estudiante edad y estado", notes = "Método para mostrar estudiantes por edad y Estado")
    public ResponseEntity<EstudianteResponse> mostrarEdadEstado (@PathVariable int edad, @PathVariable Estado estado){
        Estudiante estudiante = estudianteService.buscarPorEdadyEstado(edad, estado);
        return new ResponseEntity<EstudianteResponse>(converter.convertirEntidad(estudiante), HttpStatus.OK);
    }
}
