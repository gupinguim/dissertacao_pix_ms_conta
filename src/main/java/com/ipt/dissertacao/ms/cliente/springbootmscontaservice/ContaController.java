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

	@Autowired
	MovimentoRepository movimento_repository;

	@GetMapping("/contas/{id_conta}")
	public ResponseEntity<ContaPI> ContaRecuperar(@PathVariable long id_conta) {
		ContaPI c = conta_repository.findById(id_conta);
		return new ResponseEntity<ContaPI>(c, HttpStatus.OK);
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
		try {
			ContaPI conta = conta_repository.findById(id_conta);

			if (conta == null)
				return new ResponseEntity<String>("Conta não foi encontrada", HttpStatus.NOT_FOUND);

			mov.setConta(conta);

			movimento_repository.save(mov);

			return ResponseEntity
					.created(new URI(String.format("contas/%d/movimentos/%d", id_conta, mov.getId())))
					.body("Movimento criado");
		} catch (URISyntaxException e) {
			return new ResponseEntity<String>("Erro no processamento", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
