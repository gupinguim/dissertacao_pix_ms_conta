package com.ipt.dissertacao.ms.cliente.springbootmscontaservice;


import java.util.*;
import com.ipt.dissertacao.ms.cliente.springbootmscontaservice.entidades.*;
import com.ipt.dissertacao.ms.cliente.springbootmscontaservice.repositorios.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContaController {

	@Autowired
	ContaPIRepository conta_repository;
	
	@GetMapping("/contas/{id_conta}")
	public ContaPI GetContaById(@PathVariable long id_conta){
		return conta_repository.findById(id_conta);
	}
	
	@GetMapping("/contas/cliente/{id_cliente}")
	public List<ContaPI> GetContaByCliente(@PathVariable long id_cliente){
		return conta_repository.findByIdCliente(id_cliente);
	}
	
	
}
