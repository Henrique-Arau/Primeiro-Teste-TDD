package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CadastroPessoaTest {

    @Test
    @DisplayName("Deve criar o cadastro de pessoas")
    public void deveCriarOCadastroDePessoas() {
        //cenario e execução
        CadastroPessoas cadastro = new CadastroPessoas();

        //verificação
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }
    @Test
    @DisplayName("Deve adicionar uma pessoa")
    public void deveAdicionarUmaPessoa() {
        //cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Henrique");


        //execução
        cadastroPessoas.adicionar(pessoa);

        //verificação
        Assertions.assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);

    }

    @Test
    @DisplayName("Nã deve adicionar pessoa com nome vazio")
    public void naoDeveAdicionarPessoaComNomeVazio() {
        //cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execução
        org.junit.jupiter.api
                .Assertions.assertThrows( PessoaSemNotException.class, () -> cadastroPessoas.adicionar(pessoa) );

    }

    @Test
    @DisplayName("Deve remover uma pessoa")
    public void deveRemoverUmaPessoa() {
        //cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Henrique");
        cadastroPessoas.adicionar(pessoa);

        //execução
        cadastroPessoas.remover(pessoa);

        //verificação
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();


    }
    @Test
    @DisplayName("Deve lançar erro ao tentar remover pessoa inexistente")
    public void deveLancarErroAoTentarRemoverPessoaInexistente() {
        //cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execução
        org.junit.jupiter.api
                .Assertions.assertThrows( CadastroVazioException.class, () -> cadastroPessoas.remover (pessoa) );


    }
}
