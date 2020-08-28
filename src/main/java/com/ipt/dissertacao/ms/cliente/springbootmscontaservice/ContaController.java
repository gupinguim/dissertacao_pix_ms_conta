package com.ipt.dissertacao.ms.cliente.springbootmscontaservice;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import com.ipt.dissertacao.ms.cliente.springbootmscontaservice.entidades.*;
import com.ipt.dissertacao.ms.cliente.springbootmscontaservice.repositorios.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContaController {

	@Autowired
	ContaPIRepository conta_repository;

	@GetMapping("/contas/{id_conta}")
	public ResponseEntity<ContaPI> ContaRecuperar(@PathVariable long id_conta) {
		return new ResponseEntity<ContaPI>(conta_repository.findById(id_conta), HttpStatus.OK);
	}

	@GetMapping("/contas/cliente/{id_cliente}")
	public ResponseEntity<List<ContaPI>> ContaRecuperarByCliente(@PathVariable long id_cliente) {
		return new ResponseEntity<List<ContaPI>>(conta_repository.findByIdCliente(id_cliente), HttpStatus.OK);
	}

	@GetMapping("/contas/{id_conta}/movimentos")
	public ResponseEntity<List<Movimento>> ContaMovimentoRecuperar(@PathVariable long id_conta) {
		ContaPI conta = conta_repository.findById(id_conta);
		if (conta != null)
			return new ResponseEntity<List<Movimento>>(conta.getMovimentos(), HttpStatus.OK);
		else
			return new ResponseEntity<List<Movimento>>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/contas/{id_conta}/movimentos")
	public ResponseEntity<?> ContaMovimentoRegistrar(@PathVariable long id_conta, @RequestBody Movimento mov) {
		ContaPI conta = conta_repository.findById(id_conta);

		if (conta == null)
			return new ResponseEntity<String>("Conta não foi encontrada", HttpStatus.NOT_FOUND);

		conta.getMovimentos().add(mov);
		conta_repository.save(conta);

		try {
			return ResponseEntity
					.created(new URI("contas/", String.valueOf(id_conta), "/movimentos/", String.valueOf(mov.getId())))
					.body(mov);
		} catch (URISyntaxException e) {
			return new ResponseEntity<String>("Erro no processamento", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
