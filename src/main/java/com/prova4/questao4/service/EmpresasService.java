package com.prova4.questao4.service;

import com.prova4.questao4.model.Empresas;
import com.prova4.questao4.repository.EmpresasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresasService {
    private final EmpresasRepository repository;

    @Autowired
    public EmpresasService(EmpresasRepository repository) { this.repository = repository; }

    public Empresas create(Empresas empresa) { return repository.save(empresa); }

    public List<Empresas> findAll() { return repository.findAll(); }

    public Empresas findById(Long id) {
        Optional<Empresas> found = repository.findById(id);

        if (found.isPresent()) return found.get();
        else return null;
    }

    public Empresas update(Empresas empresa) { return repository.save(empresa);}

    public void delete(long id) {repository.deleteById(id);}
}
