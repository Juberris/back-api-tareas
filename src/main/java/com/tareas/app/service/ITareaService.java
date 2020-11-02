package com.tareas.app.service;

import java.util.List;

import com.tareas.app.entity.Tarea;


public interface ITareaService {
	
	public List<Tarea> findAll();

	public Tarea findById(Integer id);
	
    public Tarea save(Tarea tarea);
    
    public void deleteById(Integer id);
    
}
