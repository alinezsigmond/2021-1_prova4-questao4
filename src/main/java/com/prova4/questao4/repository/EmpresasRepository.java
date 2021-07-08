package com.prova4.questao4.repository;

import com.prova4.questao4.model.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresas, Long> {
}
