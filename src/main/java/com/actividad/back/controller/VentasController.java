package com.actividad.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.actividad.back.feign.Feign;
import com.actividad.back.model.ProductoModel;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/venta")
public class VentasController {
	
	@Autowired
	private Feign feignService;
	
	@ApiOperation(value = "Get all products")
	@GetMapping(path="/producto")
	public ResponseEntity<List<ProductoModel>> getProductos(){
		return new ResponseEntity<>(feignService.getProductos(),HttpStatus.OK);
	}
	
}
