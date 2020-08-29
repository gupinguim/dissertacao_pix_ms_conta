package com.ipt.dissertacao.ms.cliente.springbootmscontaservice.entidades;

import javax.persistence.*;

@Entity(name = "dict")
public class DICT {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dict_sequence")
	@SequenceGenerator(name = "dict_sequence", sequenceName = "dict_seq")
	long id;
	@Column(name="telefone")
	String telefone;
	@Column(name="email")
	String email;
	@Column(name="cpf_cnpj")
	String cpfCnpj;
	@Column(name="uuid")
	String uuid;


	public long getId() {
		return id;
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
