package com.duoc.LearningPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.LearningPlatform.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
    
}