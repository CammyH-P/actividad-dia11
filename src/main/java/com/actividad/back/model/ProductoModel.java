package com.actividad.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "baproduc")
public class ProductoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long pro_idprod;
	
	@Column(name = "pro_nombre")
	private String pro_nombre;
	
	@Column(name = "pro_descri")
	private String pro_descri;
	
	@Column(name = "pro_catego")
	private int pro_catego;
	public ProductoModel(){}
	public ProductoModel(Long pro_idprod, String pro_nombre, String pro_descri, int  pro_catego) {
		super();
		this.pro_idprod = pro_idprod;
		this.pro_nombre = pro_nombre;
		this.pro_descri=pro_descri;
		this.pro_catego = pro_catego;
	}

	public Long getPro_Idprod() {
		return pro_idprod;
	}

	public void setPro_Idprod(Long pro_idprod) {
		this.pro_idprod = pro_idprod;
	}

	public String getPro_Nombre() {
		return pro_nombre;
	}

	public void setPro_Nombre(String pro_nombre) {
		this.pro_nombre = pro_nombre;
	}
	
	public String getPro_Descri() {
		return pro_descri;
	}

	public void setPro_Descri(String pro_descri) {
		this.pro_descri = pro_descri;
	}
	
	public int getPro_Catego() {
		return pro_catego;
	}

	public void setPro_Catego(int pro_catego) {
		this.pro_catego = pro_catego;
	}

}
