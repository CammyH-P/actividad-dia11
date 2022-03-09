package com.actividad.back.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.actividad.back.model.ProductoModel;

@SpringBootTest
public class ProductoControllerTest {

	int i=8;
	Long id= Long.valueOf(i);
		@Autowired
		ProductoController ProductoController;
		
		
		@Test
		public void obtenerProductos() {
			List<ProductoModel> Producto;
			Producto = ProductoController.obtenerProductos();
			assertNotNull(Producto);
		}
		
		@Test
		public void agregarProducto() {
			ProductoModel Producto= new ProductoModel();
			Producto.setPro_Nombre("Producto 8");
			ProductoController.agregarProducto(Producto);
			assertEquals(Producto.getPro_Nombre(), ProductoController.obtenerProductoId(id).get().getPro_Nombre());
		}
		
		@Test
		public void actualizarProducto() {
			ProductoModel Producto= new ProductoModel();
			Producto.setPro_Nombre("Producto cuatro");
			ProductoController.actualizarProducto((long) 4,Producto);
			assertEquals(Producto.getPro_Nombre(), ProductoController.obtenerProductoId((long) 4).get().getPro_Nombre());
		}
		
		@Test
		public void eliminarProducto() {
			
			ProductoController.eliminarProducto((long) 5);
			assertEquals(Optional.empty(), ProductoController.obtenerProductoId((long) 5));
		}
}
