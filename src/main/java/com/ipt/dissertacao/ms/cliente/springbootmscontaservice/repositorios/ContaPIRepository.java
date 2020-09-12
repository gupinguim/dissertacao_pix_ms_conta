package com.ipt.dissertacao.ms.cliente.springbootmscontaservice.repositorios;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ipt.dissertacao.ms.cliente.springbootmscontaservice.entidades.*;

public interface ContaPIRepository extends JpaRepository<ContaPI, Long> {

	ContaPI findById(long id);

	List<ContaPI> findByIdCliente(long idCliente);

	// Query para buscar por parametros da chave secundaria, o DICT
	@Query(value = "SELECT c.* FROM conta_pi c INNER JOIN dict d ON c.fk_dict = d.id WHERE d.telefone= :telefone AND d.email = :email AND d.cpf_cnpj = :cpf_cnpj AND d.uuid = :uuid", nativeQuery = true)
	ContaPI findByDict(@Param("telefone") String telefone, @Param("email") String email,
			@Param("cpf_cnpj") String cpf_cnpj, @Param("uuid") String uuid);
}
