package com.actividad.back.controller;

import java.util.List;
import java.util.HashMap;
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

import com.actividad.back.exception.ResourceNotFoundExceptions;
import com.actividad.back.model.ProductoModel;
import com.actividad.back.repository.ProductoRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoRepository repositorio;
	
	@ApiOperation(value = "Get all products")
	@GetMapping()
	public List<ProductoModel> obtenerProductos() {
		return repositorio.findAll();
	}
	
	@ApiOperation(value = "Add a new product")
	@PostMapping()
	public ProductoModel agregarProducto(@RequestBody ProductoModel producto) {
		return repositorio.save(producto);
	}
	
	@ApiOperation(value = "Update product by Id")
	@PutMapping("/{id}")
	public ResponseEntity<ProductoModel> actualizarProducto(@PathVariable Long id, @RequestBody ProductoModel detalleProducto) {
		ProductoModel producto = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptions("No hay elementos relacionados"));

		producto.setPro_Nombre(detalleProducto.getPro_Nombre());
		producto.setPro_Descri(detalleProducto.getPro_Descri());
		producto.setPro_Catego(detalleProducto.getPro_Catego());
		ProductoModel productoActualizada = repositorio.save(producto);
		return ResponseEntity.ok(productoActualizada);
	}
	
	@ApiOperation(value = "Delete product by Id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable Long id) {
		ProductoModel producto = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptions("No hay elementos relacionados"));

		repositorio.delete(producto);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);

	}
}
