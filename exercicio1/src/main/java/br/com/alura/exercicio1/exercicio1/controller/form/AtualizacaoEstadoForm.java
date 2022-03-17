package br.com.alura.exercicio1.exercicio1.controller.form;

import br.com.alura.exercicio1.exercicio1.modelo.Estado;
import br.com.alura.exercicio1.exercicio1.modelo.StatusEstado;
import br.com.alura.exercicio1.exercicio1.repository.EstadosRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoEstadoForm {

    @NotNull @NotEmpty
    private String nome;

    @NotNull
    private StatusEstado regiao;

    @NotNull
    private Long populacao;

   @NotNull @NotEmpty
    private String capital ;

    @NotNull
    private double area;

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

    public Estado atualizar(Long id, EstadosRepository estadoRepository) {
        Estado estado = estadoRepository.getOne(id);
        estado.setNome(this.nome);
        estado.setRegiao(this.regiao);
        estado.setPopulacao(this.populacao);
        estado.setCapital(this.capital);
        estado.setArea(this.area);

        return estado;
    }


}
