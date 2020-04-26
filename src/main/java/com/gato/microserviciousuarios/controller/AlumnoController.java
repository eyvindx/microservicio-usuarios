package com.gato.microserviciousuarios.controller;

import com.gato.microserviciousuarios.model.entity.Alumno;
import com.gato.microserviciousuarios.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AlumnoController {
    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(alumnoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable("id") Long id){
        Optional<Alumno> alumno = alumnoService.finById(id);
        if(alumno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(alumno.get());

    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
        Alumno alumnoDb = alumnoService.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){
        Optional<Alumno> alumnito = alumnoService.finById(id);
        if(alumnito.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        Alumno alumnoDb = alumnito.get();
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumnoDb));
    }

    @DeleteMapping("/id")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        alumnoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
