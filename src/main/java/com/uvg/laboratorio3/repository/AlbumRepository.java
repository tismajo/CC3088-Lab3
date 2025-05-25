package com.uvg.laboratorio3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uvg.laboratorio3.model.AlbumModel;

public interface AlbumRepository extends JpaRepository<AlbumModel, Integer> {

}
