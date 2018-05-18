package com.ginius.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ginius.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
