package br.com.crud.desafiocrud.dto;

import br.com.crud.desafiocrud.services.validation.ClienteUpdate;
import br.com.crud.desafiocrud.services.validation.PixUpdate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@ClienteUpdate
public class UpdatePixDto {

    private String telefone;

    @Pattern(regexp = "^([\\w\\-]+\\.)*[\\w\\- ]+@([\\w\\- ]+\\.)+([\\w\\-]{2,3})$", message = "E-mail inválido!")
    @NotBlank(message = "Preenchimento obrigatorio")
    private String email;

    public UpdatePixDto(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;
    }

    public UpdatePixDto() {
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
