package br.com.crud.desafiocrud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cliente")
    @SequenceGenerator(name = "sq_cliente", initialValue = 1, allocationSize = 1)
    private Integer idCliente;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nm_nome")
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "dt_data")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    @Column
    private Double renda;

    @Column
    private Double patrimonio;

    @Column
    private Integer celular;

    @Column
    private Integer agencia;

    @Column
    private Integer conta;

    @Column
    private Integer senha;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String cpf, String nome, String email, Date dataNascimento, Double renda, Double patrimonio, Integer celular, Integer agencia, Integer conta, Integer senha) {
        this.idCliente = idCliente;
        this.cpf = cpf;
        this.nome = nome;
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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
