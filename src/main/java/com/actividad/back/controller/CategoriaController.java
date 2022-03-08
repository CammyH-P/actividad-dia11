package com.actividad.back.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@ApiOperation(value = "Get all Categories")
	@GetMapping()
	public List<CategoriaModel> obtenerCategorias() {
		return repositorio.findAll();
	}
	
	@ApiOperation(value = "Add a new category")
	@PostMapping()
	public CategoriaModel agregarCategoria(@RequestBody CategoriaModel categoria) {
		return repositorio.save(categoria);
	}
	
	@ApiOperation(value = "Update category by Id")
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaModel> actualizarCuentaId(@PathVariable Long id, @RequestBody CategoriaModel detalleCategoria) {
		CategoriaModel categoria = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptions("No hay elementos relacionados"));

		categoria.setCat_Nombre(detalleCategoria.getCat_Nombre());
		CategoriaModel categoriaActualizada = repositorio.save(categoria);
		return ResponseEntity.ok(categoriaActualizada);
	}

	@ApiOperation(value = "Delete category by Id")
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
