package com.gato.microserviciousuarios.model.repository;

import com.gato.microserviciousuarios.model.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
