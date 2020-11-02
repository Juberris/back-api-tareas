package com.tareas.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tareas.app.dao.TareaDao;
import com.tareas.app.entity.Tarea;

@Service
public class TareaServiceImpl implements ITareaService {

	@Autowired
	private TareaDao tareaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tarea> findAll() {
		
		return tareaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Tarea findById(Integer id) {
		
		return tareaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Tarea save(Tarea tarea) {
		
		return tareaDao.save(tarea);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		tareaDao.deleteById(id);
	}

}
