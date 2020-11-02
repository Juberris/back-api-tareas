package com.tareas.app.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.tareas.app.entity.Tarea;
import com.tareas.app.service.ITareaService;



@RestController
public class TareaController {

	@Autowired
	private ITareaService tareaService;
	
	@GetMapping("/tareas")
	public List<Tarea> listar() {

		return tareaService.findAll();
	}
	
	@PostMapping("/tareas")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Tarea> crear(@RequestBody Tarea tarea) {
		HttpStatus status = HttpStatus.OK;
		
		if (tarea.getNombre().trim().length()==0) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			new ResponseEntity<>("Nombre Tarea vacío", status);
		}
		Calendar cal = Calendar.getInstance();
		tarea.setVigente(true);
		tarea.setFechaCreacion(cal.getTime());
		
		return new ResponseEntity<>(tareaService.save(tarea), status);
		
	}
	
	@PutMapping("/tareas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Tarea> editar(@RequestBody Tarea tarea, @PathVariable Integer id) {
		HttpStatus status = HttpStatus.OK;
		
		if (tarea.getNombre().trim().length()==0) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			new ResponseEntity<>("Nombre Tarea vacío", status);
		}
		
		Tarea tareaDb = tareaService.findById(id);

		if (tareaDb != null) {
						
			tareaDb.setNombre(tarea.getNombre() != null ? tarea.getNombre() : tareaDb.getNombre());
			tareaDb.setVigente(tarea.getVigente() != null ? tarea.getVigente() : tareaDb.getVigente());

			return new ResponseEntity<>(tareaService.save(tareaDb), status);
			

		} else {
			return null;
		}
	}
	
	@DeleteMapping("/tareas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		tareaService.deleteById(id);
	}
	
	
}
