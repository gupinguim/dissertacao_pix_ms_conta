package com.ipt.dissertacao.ms.cliente.springbootmscontaservice.entidades;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.*;

@Entity(name = "movimento")
public class Movimento {

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "fk_conta")
	ContaPI conta;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movimento_sequence")
	@SequenceGenerator(name = "movimento_sequence", sequenceName = "movimento_seq")
	long id;
	@Column(name = "tipo_movimento")
	String tipoMovimento;
	@Column(name = "valor_movimento")
	double valorMovimento;
	@Column(name = "origem_movimento")
	String origemMovimento;
	@Column(name = "data_movimento")
	Date dataMovimento;

	public long getId() {
		return id;
	}

	public String getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public double getValorMovimento() {
		return valorMovimento;
	}

	public void setValorMovimento(double valorMovimento) {
		this.valorMovimento = valorMovimento;
	}

	public String getOrigemMovimento() {
		return origemMovimento;
	}

	public void setOrigemMovimento(String origemMovimento) {
		this.origemMovimento = origemMovimento;
	}

	public Date getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public ContaPI getConta() {
		return conta;
	}

	public void setConta(ContaPI conta) {
		this.conta = conta;
	}

	public void setId(long id) {
		this.id = id;
	}
}
