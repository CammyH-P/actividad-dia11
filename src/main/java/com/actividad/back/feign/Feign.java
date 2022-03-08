package com.actividad.back.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.actividad.back.model.ProductoModel;

@FeignClient(value="feignVentas",url="http://localhost:8080")
public interface Feign {

	@GetMapping(path="/producto")
	List<ProductoModel> getProductos() ;
}
