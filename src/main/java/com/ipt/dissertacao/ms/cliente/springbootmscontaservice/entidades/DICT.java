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
}
