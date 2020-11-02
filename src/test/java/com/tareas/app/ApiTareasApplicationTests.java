package com.tareas.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tareas.app.entity.Tarea;
import com.tareas.app.service.ITareaService;

@SpringBootTest
class ApiTareasApplicationTests {
@Autowired
ITareaService tareaService;

	@Test
	public void buscarTareaById() {
		Tarea tarea = tareaService.findById(1);
		
		assertThat(tarea)
		.isNotNull();
		
	}

}
