package br.com.alura.exercicio1.exercicio1.config.validacao;

public class ErroDeFormularioDto {

    private String nome;
    private String erro;

    public ErroDeFormularioDto(String campo, String erro) {
        this.nome = campo;
        this.erro = erro;
    }

    public String getNome() {
        return nome;
    }

    public String getErro() {
        return erro;
    }
}
