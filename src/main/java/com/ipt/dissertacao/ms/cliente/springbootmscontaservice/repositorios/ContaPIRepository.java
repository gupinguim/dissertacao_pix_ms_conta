package com.ipt.dissertacao.ms.cliente.springbootmscontaservice.repositorios;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ipt.dissertacao.ms.cliente.springbootmscontaservice.entidades.*;

public interface ContaPIRepository extends JpaRepository<ContaPI, Long> {

	ContaPI findById(long id);
	List<ContaPI> findByIdCliente(long idCliente);
}
