package com.tareas.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tareas.app.entity.Tarea;

public interface TareaDao extends JpaRepository<Tarea, Integer> {

}
