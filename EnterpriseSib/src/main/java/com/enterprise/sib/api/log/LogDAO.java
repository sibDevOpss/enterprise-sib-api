package com.enterprise.sib.api.log;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.enterprise.sib.api.log.DadosLogJPAMdl;

@Repository
public interface LogDAO extends CrudRepository<DadosLogJPAMdl, Integer>{
	
	@Query(value = "select * from logsss where operadora_nome = ?1", nativeQuery = true)
	List<DadosLogJPAMdl> findLogsByNomeOperadora (String nomeOperadora);
	
	
	@Query(value = "select * from logsss where usuario_nome = ?1", nativeQuery = true)
	List<DadosLogJPAMdl> findLogsByNomeUsuario (String nomeUsuario);
	
	
	@Query(value = "select * from logsss where operadora_id = ?1", nativeQuery = true)
	List<DadosLogJPAMdl> findLogsByCodigoOperadora (int codigoOperadora);
	
	
	@Query(value = "select * from logsss where usuario_id = ?1", nativeQuery = true)
	List<DadosLogJPAMdl> findLogsByUsuarioId (String usuarioId);
	
	
	@Query(value = "select * from logsss where operadoraCnpj = ?1", nativeQuery = true)
	List<DadosLogJPAMdl> findLogsByOperadoraCnpj (String operadoraCNPJ);
	
	

}
