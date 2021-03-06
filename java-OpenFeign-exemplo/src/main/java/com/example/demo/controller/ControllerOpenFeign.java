package com.example.demo.controller;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CepModel;
import com.example.demo.service.ServiceOpenFeign;

import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@RequestMapping("/FeignClient")
@CrossOrigin(origins = "*")
public class ControllerOpenFeign {

	@Autowired
	private ServiceOpenFeign serviceOpenFeign;

	@ApiOperation(value = "Serviço de consulta cep", response = ResponseEntity.class)
	@GetMapping(path = "/consultar/cep/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultaNoWebServieceCep(@PathVariable("cep") @NotNull String cep) {

		Optional<CepModel>  CepModelResponse = serviceOpenFeign.consultaCep(cep);

		return new ResponseEntity<>( CepModelResponse , HttpStatus.OK);
	}
}
