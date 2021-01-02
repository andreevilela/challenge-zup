package com.andre.challenge.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.andre.challenge.entities.User;
import com.andre.challenge.services.validation.UserInsertValid;
import com.fasterxml.jackson.annotation.JsonFormat;

@UserInsertValid
public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotEmpty(message = "cant't be empty")
	@Length(min = 5, max = 80)
	private String nome;
	@Email
	private String email;
	@CPF
	private String cpf;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, 
	pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
	private Date data_nascimento;
	
	public UserDTO() {
		
	}

	public UserDTO(Long id, String nome, String email, String cpf, Date data_nascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
	}

	public UserDTO(User entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.cpf = entity.getCpf();
		this.data_nascimento = entity.getData_nascimento();
	}
	
	public User toEntity() {
		return new User(id, nome, email, cpf, data_nascimento);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

}
