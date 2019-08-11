package com.enterprise.sib.api.cep;

import com.enterprise.sib.utilitarios.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api
@RestController
@RequestMapping(Constant.URL_MAIN_PATH)
public class CepEnd {

	@ApiOperation(value = "Consulta de cep", tags = Constant.DEFAULT_TAG)
	@GetMapping(path = "/consultar_cep", produces = MediaType.APPLICATION_JSON_VALUE)
	public String obtemCpf() {
	
		return "    {\r\n" + 
				"      \"cep\": \"01001-000\",\r\n" + 
				"      \"logradouro\": \"Praça da Sé\",\r\n" + 
				"      \"complemento\": \"lado ímpar\",\r\n" + 
				"      \"bairro\": \"Sé\",\r\n" + 
				"      \"localidade\": \"São Paulo\",\r\n" + 
				"      \"uf\": \"SP\",\r\n" + 
				"      \"unidade\": \"\",\r\n" + 
				"      \"ibge\": \"3550308\",\r\n" + 
				"      \"gia\": \"1004\"\r\n" + 
				"    }";
		
	}
}
