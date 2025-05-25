package com.uvg.laboratorio3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uvg.laboratorio3.model.PlaylistModel;

public interface PlaylistRepository extends JpaRepository<PlaylistModel, Integer> {}
