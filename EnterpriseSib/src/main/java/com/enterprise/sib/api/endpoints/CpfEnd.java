package com.enterprise.sib.api.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api()
@RestController
@RequestMapping("/enterprise")
public class CpfEnd {

	@ApiOperation(value="Consulta de cpf",tags = "Enterprise SIB Endpoints")
	@GetMapping(path = "/consultar_cpf", produces = "application/json")
	public String obtemCpf() {
	
		return "{\"Nome\":\"Mateus\", \"Idade\":27, \"CPF\":\"578.984.324-95\"}";
		
	}
	
}
