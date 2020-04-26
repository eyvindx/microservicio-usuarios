package com.gato.microserviciousuarios.service;

import com.gato.microserviciousuarios.model.entity.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    List<Alumno> findAll();
    Optional<Alumno> finById(Long id);
    Alumno save(Alumno alumno);
    void deleteById(Long id);
}
