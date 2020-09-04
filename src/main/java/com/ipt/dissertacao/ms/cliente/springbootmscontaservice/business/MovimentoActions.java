package com.ipt.dissertacao.ms.cliente.springbootmscontaservice.business;

import com.ipt.dissertacao.ms.cliente.springbootmscontaservice.entidades.*;

public class MovimentoActions {

	public static void Registrar(Movimento mov) {

		if (mov == null)
			throw new RuntimeException("Movimento não pode ser nulo");

		if (mov.getValorMovimento() <= 0)
			throw new RuntimeException("Valor do movimento deve ser maior que zero");

		ContaPI conta = mov.getConta();

		if (conta == null)
			throw new RuntimeException("Conta associada ao movimento não pode ser nula");

		if (mov.getTipoMovimento().equalsIgnoreCase("credito") || mov.getTipoMovimento().equalsIgnoreCase("bloqueio credito")) {

			double saldo = conta.getSaldoTotal() - conta.getSaldoBloqueado();

			if (mov.getValorMovimento() > saldo)
				throw new RuntimeException("Saldo insuficiente para operação");

			if (mov.getTipoMovimento().equalsIgnoreCase("credito")) {
				conta.setSaldoTotal(conta.getSaldoTotal() - mov.getValorMovimento());
			}

			if (mov.getTipoMovimento().equalsIgnoreCase("bloqueio credito")) {
				conta.setSaldoBloqueado(conta.getSaldoBloqueado() + mov.getValorMovimento());
			}

		} else if (mov.getTipoMovimento().equalsIgnoreCase("debito")) {
			conta.setSaldoTotal(conta.getSaldoTotal() + mov.getValorMovimento());
		} else if (mov.getTipoMovimento().equalsIgnoreCase("bloqueio debito")) {
			if(mov.getValorMovimento()>conta.getSaldoBloqueado())
				throw new RuntimeException("Não há saldo bloqueado o suficiente, favor repetir operacao");
			
			conta.setSaldoBloqueado(conta.getSaldoBloqueado() - mov.getValorMovimento());
		} else
			throw new RuntimeException("Tipo de movimento não reconhecido");

	}
}
