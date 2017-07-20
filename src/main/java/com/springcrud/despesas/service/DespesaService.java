package com.springcrud.despesas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcrud.despesas.model.Despesa;
import com.springcrud.despesas.repository.DespesasRepository;

@Service
public class DespesaService {
	
    @Autowired
    private DespesasRepository repository;
     
    public List<Despesa> findAll() {
        return repository.findAll();
    }
    
    public Despesa findOne(Long id) {
        return repository.findOne(id);
    }
     
    public Despesa save(Despesa despesa) {
        return repository.saveAndFlush(despesa);
    }
     
    public void delete(Long id) {
        repository.delete(id);
    }
    
}