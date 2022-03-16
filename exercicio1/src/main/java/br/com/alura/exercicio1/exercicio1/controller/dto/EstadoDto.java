package br.com.alura.exercicio1.exercicio1.controller.dto;

import br.com.alura.exercicio1.exercicio1.modelo.Estado;
import br.com.alura.exercicio1.exercicio1.modelo.StatusEstado;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<EstadoDto> converter(List<Estado> estados) {
        return estados.stream().map(EstadoDto::new).collect(Collectors.toList());
        //Chama o construtor que recebe o próprio tópico como parâmetro e transformo numa lista
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
