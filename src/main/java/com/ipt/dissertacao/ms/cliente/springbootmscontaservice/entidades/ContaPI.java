package com.ipt.dissertacao.ms.cliente.springbootmscontaservice.entidades;

import java.util.*;
import javax.persistence.*;

@Entity(name = "conta_pi")
public class ContaPI {
	@OneToOne
	@JoinColumn(name="fk_dict")
	DICT dict;
	
	@OneToMany(mappedBy = "conta")
	List<Movimento> movimentos = new ArrayList<Movimento>();
	
	@Id
	long Id;
	@Column(name="saldo_total")
	double saldoTotal;
	@Column(name="saldo_bloqueado")
	double saldoBloqueado;
	@Column(name="situacao_conta")
	String situacaoConta;
	@Column(name="id_cliente")//é uma fk para dados de outro micro serviço
	long idCliente;
	@Column(name="data_criacao")
	Date dataCriacao;
}
