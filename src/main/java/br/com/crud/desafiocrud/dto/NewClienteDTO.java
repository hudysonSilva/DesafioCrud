package br.com.crud.desafiocrud.dto;

import br.com.crud.desafiocrud.services.validation.ClienteInsert;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@ClienteInsert
public class NewClienteDTO {

    //@Pattern(regexp = "([A-ZÀ-Ÿ][A-zÀ-ÿ']*\\s||[A-ZÀ-Ÿ][A-zÀ-ÿ']*\\s[A-ZÀ-Ÿ][A-zÀ-ÿ']*){1,20}\\S", message = "Nome Invalido")
    @Pattern(regexp = "([A-ZÀ-Ÿ][A-zÀ-ÿ']*\\s||[A-ZÀ-Ÿ][A-zÀ-ÿ']*\\s[a-zà-ÿ][A-zÀ-ÿ']*||[A-ZÀ-Ÿ][A-zÀ-ÿ']*\\\\s[A-ZÀ-Ÿ][A-zÀ-ÿ']*){1,20}\\S", message = "Nome Invalido")
    @NotBlank(message = "Preenchimento obrigatorio")
    @Length(max = 120, message = "Quantidade de caracteres deve ser no maximo 120")
    private String nome;

    @NotBlank(message = "Preenchimento obrigatorio")
    @CPF
    private String cpf;

    @Pattern(regexp = "^([\\w\\-]+\\.)*[\\w\\- ]+@([\\w\\- ]+\\.)+([\\w\\-]{2,3})$", message = "E-mail inválido!")
    //@Pattern(regexp = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", message = "E-mail inválido")
    @NotBlank(message = "Preenchimento obrigatorio")
    private String email;

    private String dataNascimento;

    private Double renda;

    private Double patrimonio;

    private Integer celular;

    private Integer agencia;

    private Integer conta;

    private Integer senha;




    public NewClienteDTO() {
    }

    public NewClienteDTO(String nome, String cpf, String email, String dataNascimento, Double renda, Double patrimonio, Integer celular, Integer agencia, Integer conta, Integer senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.renda = renda;
        this.patrimonio = patrimonio;
        this.celular = celular;
        this.agencia = agencia;
        this.conta = conta;
        this.senha = senha;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public Double getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Double patrimonio) {
        this.patrimonio = patrimonio;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}