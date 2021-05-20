package br.com.itau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.dao.TransacaoDAO;

@RestController
@CrossOrigin("*")
public class TransacaoController {

	@Autowired
	private TransacaoDAO dao;
	
}
