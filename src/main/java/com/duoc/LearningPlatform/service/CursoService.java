package com.duoc.LearningPlatform.service;

import com.duoc.LearningPlatform.model.Curso;
import com.duoc.LearningPlatform.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> obtenerCursosDisponibles(){
        List<Curso> cursosActivos = cursoRepository.findByActivoTrue();
        List<Curso> cursosTemporales = new ArrayList<>(cursosActivos);
        return ordenarCursosPorNombre(cursosTemporales);
    }

    private List<Curso> ordenarCursosPorNombre(List<Curso> cursos) {
        cursos.sort(Comparator.comparing(Curso::getNombre));
        return cursos;
    }
}