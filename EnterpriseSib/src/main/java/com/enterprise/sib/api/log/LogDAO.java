package com.enterprise.sib.api.log;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.enterprise.sib.api.log.DadosLogCpfJPAMdl;

@Repository
public interface LogDAO extends CrudRepository<DadosLogCpfJPAMdl, Integer>{
	
	@Query(value = "select * from logs where nm_operadora = ?1", nativeQuery = true)
	List<DadosLogCpfJPAMdl> findLogsByNomeOperadora (String nomeOperadora);
	
	
	@Query(value = "select * from logs where nm_usuario = ?1", nativeQuery = true)
	List<DadosLogCpfJPAMdl> findLogsByNomeUsuario (String nomeUsuario);
	
	
	@Query(value = "select * from logs where cd_operadora = ?1", nativeQuery = true)
	List<DadosLogCpfJPAMdl> findLogsByCodigoOperadora (int codigoOperadora);
	
	

}
