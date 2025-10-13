package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_postagens") // isso é igual a CREATE TABLE tb_postagens
public class Postagem {

	@Id // isso é igual a PRIMARY KEY (id)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // isso seria o AUTO_INCREMENT
	private Long id;
	
	@Column(length = 100) //determina o tamanho que ele vai ter no banco de dados
	@NotBlank(message = "O atributo (titulo) é obrigatório") // não permite que fique em branco
	@Size(min = 5, max = 100, message = "O atributo (titulo) deve conter no mínimo 05 e no máximo 100 caracteres") //determina o tamanho
	private String titulo;
	
	@Column(length = 1000) //
	@NotBlank(message = "O atributo (Texto) é obrigatório")
	@Size(min = 10, max = 1000, message = "O atributo (Texto) deve conter no mínimo 10 e no máximo 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp //toda vez que vc atualizar, ele vai atualizar o local e hora
	private LocalDateTime data;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
}
