package br.com.alura.exercicio1.exercicio1.modelo;

import javax.persistence.*;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private StatusEstado regiao;
    private Long populacao;
    private String capital;
    private double area;

    public Estado(String nome, StatusEstado regiao, Long populacao, String capital, double area) {
        this.nome = nome;
        this.regiao = regiao;
        this.populacao = populacao;
        this.capital = capital;
        this.area = area;

    }

    public Estado(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusEstado getRegiao() {
        return regiao;
    }

    public void setRegiao(StatusEstado regiao) {
        this.regiao = regiao;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
