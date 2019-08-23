package com.enterprise.sib.api.cpf;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpfDAO extends CrudRepository<CpfDadosJPAMdl, Integer> {

    @Query(value = "SELECT * FROM cpfs WHERE cpf = ?1", nativeQuery = true)
    CpfDadosJPAMdl findCpf(String cpf);

}
