package br.com.crud.desafiocrud.entity;


import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "TB_PIX")
public class Pix {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pix")
    @SequenceGenerator(name = "sq_pix", initialValue = 1, allocationSize = 1)
    private Integer idPix;

    @Column
    private String cpf;

    @Pattern(regexp = "^([\\w\\-]+\\.)*[\\w\\- ]+@([\\w\\- ]+\\.)+([\\w\\-]{2,3})$", message = "E-mail inválido!")
    private String email;

    @Column
    private String telefone;

    @Column
    private String aleatoria;


    public Pix() {
    }

    public Pix(Integer idPix, String cpf, String email, String telefone, String aleatoria) {
        this.idPix = idPix;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.aleatoria = aleatoria;
    }

    public Integer getIdPix() {
        return idPix;
    }

    public void setIdPix(Integer idPix) {
        this.idPix = idPix;
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
