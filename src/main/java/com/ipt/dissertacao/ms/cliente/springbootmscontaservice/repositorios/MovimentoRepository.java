package com.ipt.dissertacao.ms.cliente.springbootmscontaservice.repositorios;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ipt.dissertacao.ms.cliente.springbootmscontaservice.entidades.*;

public interface MovimentoRepository extends JpaRepository<Movimento, Long> {

	Movimento findById(long id);

	@Query(value = "SELECT m.* FROM movimento m INNER JOIN conta_pi c ON c.id = m.fk_conta WHERE m.id= :id AND c.id = :id_conta", nativeQuery = true)
	Movimento findByIdAndIdConta(@Param("id") long id, @Param("id_conta") long id_conta);
}
