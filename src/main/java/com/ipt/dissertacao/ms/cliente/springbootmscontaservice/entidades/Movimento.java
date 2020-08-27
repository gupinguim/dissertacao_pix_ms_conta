package com.ipt.dissertacao.ms.cliente.springbootmscontaservice.entidades;

import javax.persistence.*;
import java.util.*;

@Entity
public class Movimento {

	@ManyToOne
	@JoinColumn(name="fk_conta")
	ContaPI conta;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	@Column(name="tipo_movimento")
	String tipoMovimento;
	@Column(name="valor_movimento")
	double valorMovimento;
	@Column(name="origem_movimento")
	String origemMovimento;
	@Column(name="data_movimento")
	Date dataMovimento;
}
