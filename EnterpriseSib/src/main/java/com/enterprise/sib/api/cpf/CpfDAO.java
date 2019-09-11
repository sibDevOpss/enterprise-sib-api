package com.enterprise.sib.api.cpf;

import com.enterprise.sib.utils.Constant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpfDAO extends CrudRepository<CpfMdlBaseDados, Integer> {

    @Query(value = "SELECT * FROM " + Constant.TABLE_CPF + " WHERE cpf = ?1", nativeQuery = true)
    CpfMdlBaseDados findCpf(String cpf);

}
