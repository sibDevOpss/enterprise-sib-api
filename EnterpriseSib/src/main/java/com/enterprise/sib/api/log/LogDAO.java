package com.enterprise.sib.api.log;

import com.enterprise.sib.utils.Constant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDAO extends CrudRepository<LogMdlBaseDados, Integer> {

    @Query(value = "SELECT * FROM " + Constant.TABLE_LOG + " WHERE operadora_cnpj = ?1", nativeQuery = true)
    List<LogMdlBaseDados> findLogsByOperadoraCnpj(String operadoraCNPJ);

    @Query(value = "SELECT * FROM " + Constant.TABLE_LOG + " WHERE operadora_id = ?1", nativeQuery = true)
    List<LogMdlBaseDados> findLogsByOperadoraId(int operadoraId);

    @Query(value = "SELECT * FROM " + Constant.TABLE_LOG + " WHERE usuario_id = ?1", nativeQuery = true)
    List<LogMdlBaseDados> findLogsByUsuarioId(String usuarioId);

    @Query(value = "SELECT * FROM " + Constant.TABLE_LOG + " WHERE operadora_nome = ?1", nativeQuery = true)
    List<LogMdlBaseDados> findLogsByNomeOperadora(String nomeOperadora);

    @Query(value = "SELECT * FROM " + Constant.TABLE_LOG + " WHERE usuario_nome = ?1", nativeQuery = true)
    List<LogMdlBaseDados> findLogsByNomeUsuario(String nomeUsuario);

}