package br.com.itau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.dao.TransacaoDAO;

@RestController
@CrossOrigin("*")
public class TransacaoController {

        @Autowired
        private TransacaoDAO dao;

        @GetMapping("/transacao/{codagente}/{codstatus}")
        public ResponseEntity<Integer> getTotalTransacoesAgente(@PathVariable int codagente, @PathVariable int codstatus){
                return ResponseEntity.ok(dao.findByTotalTransacoesAgenteEStatus(codagente, codstatus));
        }
}
