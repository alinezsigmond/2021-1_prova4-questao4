package com.prova4.questao4.controller;

import com.prova4.questao4.model.Produtos;
import com.prova4.questao4.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private ProdutosService service;

    @Autowired
    public ProdutosController(ProdutosService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> listar() throws Exception{
        try{
            List<Produtos> found = service.findAll();
            if(!found.isEmpty()){
                return new ResponseEntity<>(found, null, HttpStatus.OK);
            } else return new ResponseEntity<>(found, null, HttpStatus.NO_CONTENT);
        }
        catch(Exception ex){
            throw new Exception(ex);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) throws Exception {
        try{
            Produtos found = service.findById(id);
            if(found != null) return new ResponseEntity<>(found, null, HttpStatus.OK);
            else return new ResponseEntity<>( null, null, HttpStatus.NOT_FOUND);
        }
        catch(Exception ex){
            throw new Exception(ex);
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Produtos produto) throws Exception {
        try{
            Produtos saved = service.create(produto);
            return new ResponseEntity<>(saved, null, HttpStatus.CREATED);

        }
        catch(Exception e){
            throw new Exception(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Produtos produto) throws Exception {
        try{
            if(service.findById(id) != null) {
                produto.setId(id);
                return new ResponseEntity<>( service.update(produto), null, HttpStatus.OK);
            } else return new ResponseEntity<>( null, null, HttpStatus.NOT_FOUND);

        }
        catch(Exception ex){
            throw new Exception(ex);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) throws Exception {
        try{
            if(service.findById(id) != null) {
                service.delete(id);
                return new ResponseEntity<>(null, null, HttpStatus.OK);
            } else return new ResponseEntity<>( null, null, HttpStatus.NOT_FOUND);
        }
        catch(Exception ex){
            throw new Exception(ex);
        }
    }
}
