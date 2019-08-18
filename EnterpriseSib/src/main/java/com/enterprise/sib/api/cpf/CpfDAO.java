package com.enterprise.sib.api.cpf;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpfDAO extends CrudRepository<CpfDadosJPAMdl, Integer>{
	
	
	@Query(value = "select * from cpfs where cpf = ?1", nativeQuery = true)
	CpfDadosJPAMdl findCpf (String cpf);

}
