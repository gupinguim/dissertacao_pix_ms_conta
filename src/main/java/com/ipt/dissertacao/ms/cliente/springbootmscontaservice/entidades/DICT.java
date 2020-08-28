package com.ipt.dissertacao.ms.cliente.springbootmscontaservice.entidades;

import javax.persistence.*;

@Entity
public class DICT {
	
	@OneToOne(mappedBy = "dict")
	ContaPI conta;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column
	String telefone;
	@Column
	String email;
	@Column
	String cpfCnpj;
	@Column
	String uuid;
	public ContaPI getConta() {
		return conta;
	}
	public void setConta(ContaPI conta) {
		this.conta = conta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
