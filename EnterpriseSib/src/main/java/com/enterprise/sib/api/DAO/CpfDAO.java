package com.enterprise.sib.api.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.sib.api.models.DadosLogCpfJPAMdl;
import com.enterprise.sib.api.models.DadosLogCpfMdl;


@Repository
public interface CpfDAO extends CrudRepository<DadosLogCpfJPAMdl, Integer>{

}
