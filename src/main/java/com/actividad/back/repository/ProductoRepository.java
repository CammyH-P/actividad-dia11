package com.actividad.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.actividad.back.model.ProductoModel;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel,Long>{

}
