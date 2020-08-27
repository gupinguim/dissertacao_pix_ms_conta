package com.ipt.dissertacao.ms.cliente.springbootmscontaservice.repositorios;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ipt.dissertacao.ms.cliente.springbootmscontaservice.entidades.*;

public interface DICTRepository extends JpaRepository<DICT, Long> {
	List<DICT> findAllByTelefoneAndEmailAndCpfCnpj(String telefone, String email, String cpfCnpj);
	DICT findByTelefoneAndEmailAndCpfCnpjAndUuid(String telefone, String email, String cpfCnpj, String uuid);
}
