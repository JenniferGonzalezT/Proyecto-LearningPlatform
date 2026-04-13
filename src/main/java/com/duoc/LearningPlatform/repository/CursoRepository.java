package com.duoc.LearningPlatform.repository;

import com.duoc.LearningPlatform.model.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CursoRepository {

    // Estructura de almacenamiento temporal
    private List<Curso> cursos;

    public CursoRepository() {
    	cursos = new ArrayList<>();
        
        // Simulamos la base de datos agregando algunos cursos
		Curso c1 = new Curso("Java Básico", "Curso de introducción a Java", true);
        c1.setId(1L);
        cursos.add(c1);

        Curso c2 = new Curso("Python para Data Science", "Curso de Python enfocado en Data Science", false);
        c2.setId(2L);
        cursos.add(c2);

        Curso c3 = new Curso("Spring Boot", "Curso avanzado de Spring Boot", true);
        c3.setId(3L);
        cursos.add(c3);

        Curso c4 = new Curso("Bases de Datos", "Curso de introducción a las Bases de Datos", true);
        c4.setId(4L);
        cursos.add(c4);

        Curso c5 = new Curso("Seguridad en Aplicaciones", "Curso sobre seguridad en aplicaciones", true);
        c5.setId(5L);
        cursos.add(c5);

        Curso c6 = new Curso("Machine Learning", "Curso avanzado de Machine Learning", true);
        c6.setId(6L);
        cursos.add(c6);
    }

    public List<Curso> findByActivoTrue() {
        return cursos.stream()
                .filter(Curso::isActivo)
                .collect(Collectors.toList());
    }
}