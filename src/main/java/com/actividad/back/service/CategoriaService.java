package com.actividad.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actividad.back.repository.CategoriaRepository;
import com.actividad.back.model.CategoriaModel;

@Service
public class CategoriaService {

	private CategoriaRepository repositorio;

	@Autowired
	public CategoriaService(CategoriaRepository repositorio) {
		this.repositorio = repositorio;
	}

	public List<CategoriaModel> getCategorias() {
		return repositorio.findAll();
	}

	public void agregarCategoria(CategoriaModel categoria) {
		repositorio.save(new CategoriaModel(categoria.getCat_Idcate(), categoria.getCat_Nombre()));
	}

	public void eliminarCategoria(Integer cat_idcate){
		
	}
}
