package com.actividad.back.controller;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.actividad.back.model.CategoriaModel;

@SpringBootTest
public class CategoriaControllerTest {
int i=12;
Long id= Long.valueOf(i);
	@Autowired
	CategoriaController categoriaController;	
	
	@Test
	public void obtenerCategorias() {
		List<CategoriaModel> categoria;
		categoria = categoriaController.obtenerCategorias();
		assertNotNull(categoria);
	}
	
	@Test
	public void agregarCategoria() {
		CategoriaModel categoria= new CategoriaModel();
		categoria.setCat_Nombre("Categoria 12");
		categoriaController.agregarCategoria(categoria);
		assertEquals(categoria.getCat_Nombre(), categoriaController.obtenerCategoriaId(id).get().getCat_Nombre());
	}
	
	@Test
	public void actualizarCategoria() {
		CategoriaModel categoria= new CategoriaModel();
		categoria.setCat_Nombre("Categoria doce");
		categoriaController.actualizarCategoriaId(id,categoria);
		assertEquals(categoria.getCat_Nombre(), categoriaController.obtenerCategoriaId(id).get().getCat_Nombre());
	}
	
	@Test
	public void eliminarCategoria() {
		categoriaController.eliminarCategoria((long) 2);
		assertEquals(Optional.empty(), categoriaController.obtenerCategoriaId(id));
	}
	
}
