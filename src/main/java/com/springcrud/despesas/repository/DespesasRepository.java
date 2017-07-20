package com.springcrud.despesas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcrud.despesas.model.Despesa;

@Repository
public interface DespesasRepository extends JpaRepository<Despesa, Long>{}