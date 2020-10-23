package com.example.demo.repository;

import com.example.demo.model.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import java.io.Serializable;

public interface KundeRepository extends JpaRepository<Kunde, Integer> {



}
