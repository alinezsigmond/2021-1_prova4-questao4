package com.prova4.questao4.service;

import com.prova4.questao4.model.Produtos;
import com.prova4.questao4.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {
    private final ProdutosRepository repository;

    @Autowired
    public ProdutosService(ProdutosRepository repository) {
        this.repository = repository;
    }

    public Produtos create(Produtos produto) {
        return repository.save(produto);
    }

    public List<Produtos> findAll() {
        return repository.findAll();
    }

    public Produtos findById(Long id) {
        Optional<Produtos> found = repository.findById(id);

        if(found.isPresent()) return found.get();
        else return null;
    }

    public Produtos update(Produtos produto) {
        return repository.save(produto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
