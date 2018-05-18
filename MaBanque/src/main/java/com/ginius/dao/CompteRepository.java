package com.ginius.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ginius.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {

}
