package com.actividad.back.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.actividad.back.model.CategoriaModel;
import com.actividad.back.repository.CategoriaRepository;

import io.swagger.annotations.ApiOperation;
import com.actividad.back.exception.ResourceNotFoundExceptions;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaRepository repositorio;

	@ApiOperation(value = "Obtener todas la categorias",
			notes="Regresa una lista de todas la categorias que esten registradas en la base de datos")
	@GetMapping()
	public List<CategoriaModel> obtenerCategorias() {
		return repositorio.findAll();
	}
	
	@ApiOperation(value = "Obtener una categoria de acuerdo a un id",
			notes="Muestra los datos de una categoria que coincida con el id daado")
	@GetMapping("/{id}")
	public Optional<CategoriaModel> obtenerCategoriaId(@PathVariable Long id) {
		Optional<CategoriaModel>categoria = repositorio.findById(id);
		return categoria;
	}
	
	
	@ApiOperation(value = "Agregar una categoria",
			notes="Realizar la insercion de una nueva categoria en la base de datos ")
	@PostMapping()
	public CategoriaModel agregarCategoria(@RequestBody CategoriaModel categoria) {
		return repositorio.save(categoria);
	}
	
	@ApiOperation(value = "Actualizar una categoria de acuerdo al Id",
			notes="Actualiza los datos de una categoria en la base de datos ")
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaModel> actualizarCategoriaId(@PathVariable Long id, @RequestBody CategoriaModel detalleCategoria) {
		CategoriaModel categoria = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptions("No hay elementos relacionados"));

		categoria.setCat_Nombre(detalleCategoria.getCat_Nombre());
		CategoriaModel categoriaActualizada = repositorio.save(categoria);
		return ResponseEntity.ok(categoriaActualizada);
	}

	@ApiOperation(value = "Eliminar una categoria de acuerdo al Id",
			notes="Elimina todo los datos de una categoria en la base de datos ")
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarCategoria(@PathVariable Long id) {
		CategoriaModel categoria = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptions("No hay elementos relacionados"));

		repositorio.delete(categoria);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);

	}
}
