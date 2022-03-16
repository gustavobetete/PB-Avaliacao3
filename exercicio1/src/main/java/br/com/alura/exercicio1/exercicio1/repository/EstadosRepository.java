package br.com.alura.exercicio1.exercicio1.repository;

import br.com.alura.exercicio1.exercicio1.modelo.Estado;
import br.com.alura.exercicio1.exercicio1.modelo.StatusEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface EstadosRepository extends JpaRepository<Estado, Long> {

    List<Estado> findByNome(String nome);

    List<Estado> findByRegiao(StatusEstado regiao);
}

