package com.springcrud.despesas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "tbl_despesas")
public class Despesa implements Serializable  {
		 
	    private static final long serialVersionUID = 1L;
	 	    
	    @Id
	    @GeneratedValue(generator = "increment")
	    @GenericGenerator(name = "increment", strategy = "increment")
	    private Long id;	    
	    
	    @Column(nullable = false, length = 50)
	    @NotBlank(message = "Descrição é uma informação obrigatória.")
	    private String descricao;

	    @Column(nullable = false, length = 50)
	    @NotBlank(message = "Local é uma informação obrigatória.")
	    private String local;
	    
	    @Column(nullable = false)
	    @NotNull(message = "Valor é uma informação obrigatória.")
	    private Double valor;
	    	   	    
	    @Column(nullable = false)
	    @Temporal(TemporalType.DATE)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @NotNull(message = "Data é uma informação obrigatória.")
	    private Date data;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getLocal() {
			return local;
		}

		public void setLocal(String local) {
			this.local = local;
		}

		public Double getValor() {
			return valor;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}

		public Date getData() {
			return data;
		}

		public void setData(Date data) {
			this.data = data;
		}
}
