package com.actividad.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.actividad.back.model.ProductoModel;
import com.actividad.back.repository.ProductoRepository;

public class ProductoService {
	
	private ProductoRepository repositorio;

	@Autowired
	public ProductoService(ProductoRepository repositorio) {
		this.repositorio = repositorio;
	}

	public List<ProductoModel> getCategorias() {
		return repositorio.findAll();
	}

	public void agregarProducto(ProductoModel producto) {
		repositorio.save(new ProductoModel(producto.getPro_Idprod(), producto.getPro_Nombre(),producto.getPro_Descri(),producto.getPro_Catego()));
	}
}