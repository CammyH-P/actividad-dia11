package com.actividad.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bacatego")
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long cat_idcate;
	
	@Column(name = "cat_nombre")
	private String cat_nombre;
	
	public CategoriaModel() {
	}
	public CategoriaModel(Long cat_idcate, String cat_nombre) {
		super();
		this.cat_idcate = cat_idcate;
		this.cat_nombre = cat_nombre;
	}

	public Long getCat_Idcate() {
		return cat_idcate;
	}

	public void setCat_Idcate(Long cat_idcate) {
		this.cat_idcate = cat_idcate;
	}

	public String getCat_Nombre() {
		return cat_nombre;
	}

	public void setCat_Nombre(String cat_nombre) {
		this.cat_nombre = cat_nombre;
	}

}
