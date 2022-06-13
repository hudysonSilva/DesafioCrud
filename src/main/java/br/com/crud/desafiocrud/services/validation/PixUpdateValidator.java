package br.com.crud.desafiocrud.services.validation;


import br.com.crud.desafiocrud.exception.FieldMessage;
import br.com.crud.desafiocrud.dto.UpdatePixDto;
import br.com.crud.desafiocrud.repositories.PixRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class PixUpdateValidator implements ConstraintValidator<PixUpdate, UpdatePixDto> {

    @Autowired
    private PixRepository repo;

    @Override
    public void initialize(PixUpdate ann) {
    }

    @Override
    public boolean isValid(UpdatePixDto objDto, ConstraintValidatorContext context) {

        List<FieldMessage> erros = new ArrayList<>();

        for (FieldMessage e : erros) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return erros.isEmpty();
    }


    //UPDATE SENHA VALIDATTOR #@!@#@#!@#!@#!@#!@#

}