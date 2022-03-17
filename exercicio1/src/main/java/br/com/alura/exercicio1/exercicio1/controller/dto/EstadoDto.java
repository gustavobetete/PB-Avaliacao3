package br.com.alura.exercicio1.exercicio1.controller.dto;

import br.com.alura.exercicio1.exercicio1.modelo.Estado;
import br.com.alura.exercicio1.exercicio1.modelo.StatusEstado;
import org.springframework.data.domain.Page;


public class EstadoDto {

    private Long id;
    private String nome;
    private StatusEstado regiao;
    private Long populacao;
    private String capital;
    private double area;

    public EstadoDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.regiao = estado.getRegiao();
        this.populacao = estado.getPopulacao();
        this.capital = estado.getCapital();
        this.area = estado.getArea();
    }

    public static Page<EstadoDto> converter(Page<Estado> estados) {
        return estados.map(EstadoDto::new);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public StatusEstado getRegiao() {
        return regiao;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public String getCapital() {
        return capital;
    }

    public double getArea() {
        return area;
    }
}
