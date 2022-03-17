package br.com.alura.exercicio1.exercicio1.repository;

import br.com.alura.exercicio1.exercicio1.modelo.Estado;
import br.com.alura.exercicio1.exercicio1.modelo.StatusEstado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EstadosRepository extends JpaRepository<Estado, Long> {

   Page<Estado> findByRegiao(StatusEstado regiao, Pageable paginacao);
}

