package com.duoc.LearningPlatform.service;

import com.duoc.LearningPlatform.model.Curso;
import com.duoc.LearningPlatform.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    private List<Curso> cursosTemporales = new ArrayList<>();

    public CursoService() {
        cursosTemporales.add(new Curso("Java Básico", "Curso de introducción a Java", true));
        cursosTemporales.add(new Curso("Python para Data Science", "Curso de Python enfocado en Data Science", false));
        cursosTemporales.add(new Curso("Spring Boot", "Curso avanzado de Spring Boot", true));
        cursosTemporales.add(new Curso("Bases de Datos", "Curso de introducción a las Bases de Datos", true));
        cursosTemporales.add(new Curso("Seguridad en Aplicaciones", "Curso sobre seguridad en aplicaciones", true));
        cursosTemporales.add(new Curso("Machine Learning", "Curso avanzado de Machine Learning", true));
    }

    public List<Curso> obtenerCursosDisponibles(){
        return cursosTemporales.stream()
                .filter(Curso::isActivo)
                .sorted(Comparator.comparing(Curso::getNombre))
                .collect(Collectors.toList());
    }
}