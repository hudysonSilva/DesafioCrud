package br.com.crud.desafiocrud.dto;

import br.com.crud.desafiocrud.services.validation.ClienteInsert;
import br.com.crud.desafiocrud.services.validation.PixInsert;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@PixInsert
public class NewPixDTO {

    @CPF
    private String cpf;
    private String email;
    private String telefone;
    private String aleatoria;


    public NewPixDTO() {
    }

    public NewPixDTO(String cpf, String email, String telefone, String aleatoria) {
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.aleatoria = aleatoria;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getAleatoria() {
        return aleatoria;
    }

    public void setAleatoria(String aleatoria) {
        this.aleatoria = aleatoria;
    }
}
