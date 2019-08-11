package com.enterprise.sib.api.cpf;

import com.enterprise.sib.api.log.DadosLogCpfJPAMdl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CpfDAO extends CrudRepository<DadosLogCpfJPAMdl, Integer>{

}
