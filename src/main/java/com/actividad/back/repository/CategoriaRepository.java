package com.actividad.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.actividad.back.model.CategoriaModel;


@Repository
public interface CategoriaRepository  extends JpaRepository<CategoriaModel, Long>{

}
