package br.com.crud.desafiocrud.services.validation;

import br.com.crud.desafiocrud.exception.FieldMessage;
import br.com.crud.desafiocrud.dto.NewPixDTO;
import br.com.crud.desafiocrud.entity.Pix;
import br.com.crud.desafiocrud.repositories.PixRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class PixInsertValidator implements ConstraintValidator<PixInsert, NewPixDTO> {

    @Autowired
    private PixRepository repo;

    @Override
    public void initialize(PixInsert ann) {
        // TODO document why this method is empty
    }

    @Override
    public boolean isValid(NewPixDTO objDto, ConstraintValidatorContext context) {

        //Injeção de dependencia
        Pix aux = new Pix();

        List<FieldMessage> erros = new ArrayList<>();

        //Validação de email duplicado
        aux = repo.findByEmail(objDto.getEmail());
        if (aux != null) {
            erros.add(new FieldMessage("email", "Email já existente"));
        }

        //Validação de cpf duplicado
        aux = repo.findByCpf(objDto.getCpf());
        if (aux != null) {
            erros.add(new FieldMessage("cpf", "CPF já existente"));
        }

        for (FieldMessage e : erros) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }

        return erros.isEmpty();
    }

}