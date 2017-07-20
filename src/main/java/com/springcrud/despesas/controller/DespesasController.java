package com.springcrud.despesas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springcrud.despesas.model.Despesa;
import com.springcrud.despesas.service.DespesaService;

@Controller
public class DespesasController {
	
	@Autowired
	private DespesaService service;
	
    @GetMapping("/")
    public ModelAndView findAll() {         
        ModelAndView mv = new ModelAndView("/despesas_view");
        mv.addObject("despesas", service.findAll());
        mv.addObject("despesa", new Despesa());        

        return mv;
        
    }
    
    
    
    @PostMapping("/save")
    public ModelAndView save(@Valid Despesa despesa, BindingResult result) {
        if(result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/despesas_view");
            mv.addObject("despesas", service.findAll());        
            mv.addObject(despesa);            	
            return mv;
        }
         
        service.save(despesa);
        return findAll();
    }
    
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {        
        service.delete(id);         
        return findAll();
    }   
    
	//Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
        ModelAndView mv = new ModelAndView("/despesas_view");
        mv.addObject("despesas", service.findAll());                
        mv.addObject("despesa", service.findOne(id));        
        return mv;		
	}
}
