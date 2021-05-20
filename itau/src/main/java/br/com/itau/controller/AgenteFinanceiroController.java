package br.com.itau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.beans.AgenteFinanceiro;
import br.com.itau.dao.AgenteFinanceiroDAO;

@RestController
@CrossOrigin("*")
public class AgenteFinanceiroController {
	
	@Autowired
	private AgenteFinanceiroDAO dao;
	
	@GetMapping("/topagentesfinanceiros")
	public ResponseEntity<List<AgenteFinanceiro>> getTopAgentesFinanceiros(){
		return ResponseEntity.ok(dao.findByTopTen());
	}
	
	@GetMapping("/agentesfinanceiros") 
	public ResponseEntity<List<AgenteFinanceiro>> getAllAgenteFinanceiro(){
		try {
			List<AgenteFinanceiro> listaAgenteFinanceiro = (List<AgenteFinanceiro>) dao.findAll();
			if (listaAgenteFinanceiro.size() == 0) {
				return ResponseEntity.status(404).build();
			}
			return ResponseEntity.ok(listaAgenteFinanceiro);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
	
	
}
