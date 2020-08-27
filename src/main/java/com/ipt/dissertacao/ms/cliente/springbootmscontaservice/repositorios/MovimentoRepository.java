package com.ipt.dissertacao.ms.cliente.springbootmscontaservice.repositorios;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ipt.dissertacao.ms.cliente.springbootmscontaservice.entidades.*;

public interface MovimentoRepository extends JpaRepository<Movimento, Long> {
	
	Movimento findById(long id);
}
