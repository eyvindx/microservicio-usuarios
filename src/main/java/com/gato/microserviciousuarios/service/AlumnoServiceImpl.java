package com.gato.microserviciousuarios.service;

import com.gato.microserviciousuarios.model.entity.Alumno;
import com.gato.microserviciousuarios.model.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class AlumnoServiceImpl implements AlumnoService{

    @Autowired
    AlumnoRepository alumnoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Alumno> finById(Long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    @Transactional
    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        alumnoRepository.deleteById(id);

    }
}
