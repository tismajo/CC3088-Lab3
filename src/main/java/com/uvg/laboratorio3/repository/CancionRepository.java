package com.uvg.laboratorio3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uvg.laboratorio3.model.CancionModel;


public interface CancionRepository extends JpaRepository<CancionModel, Integer> {}
