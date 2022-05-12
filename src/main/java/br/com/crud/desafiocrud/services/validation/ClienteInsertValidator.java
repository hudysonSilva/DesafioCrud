package br.com.crud.desafiocrud.services.validation;


import br.com.crud.desafiocrud.controllers.exception.FieldMessage;
import br.com.crud.desafiocrud.dto.NewClienteDTO;
import br.com.crud.desafiocrud.entity.Cliente;
import br.com.crud.desafiocrud.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, NewClienteDTO> {

    @Autowired
    private ClienteRepository repo;

    @Override
    public void initialize(ClienteInsert ann) {
        // TODO document why this method is empty
    }

    public boolean dataOk(String dataNascimento) {
        //variaveis que recebem o valor
        Integer Dia, Mes;
        Integer Ano;

        String Dt = dataNascimento;

        //Se a data estiver completa
        if (Dt.trim().length() >=8 && Dt.trim().length()<= 10) {

            //quebra a string
            String[] splitData = Dt.split("/");

            Dia = Integer.parseInt(splitData[0]);
            Mes = Integer.parseInt(splitData[1]);
            Ano = Integer.parseInt(splitData[2]);

            //verifica variaveis
            if (
                    ((Mes.equals(1) || Mes.equals(3) || Mes.equals(5) || Mes.equals(7) || Mes.equals(8) || Mes.equals(10) || Mes.equals(12)) && (Dia >= 1 && Dia <= 31))
                            ||
                            ((Mes.equals(4) || Mes.equals(6) || Mes.equals(9) || Mes.equals(11)) && (Dia >= 1 && Dia <= 30))
                            ||
                            ((Mes.equals(2)) && (AnoBissexto(Ano)) && (Dia >= 1 && Dia <= 29))
                            ||
                            ((Mes.equals(2)) && !(AnoBissexto(Ano)) && (Dia >= 1 && Dia <= 28))
            ) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean AnoBissexto(int ano) {
        return ano % 4 == 0;
    }

    @Override
    public boolean isValid(NewClienteDTO objDto, ConstraintValidatorContext context) {

        //Injeção de dependencia
        Cliente aux = new Cliente();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dataNascimento = Calendar.getInstance();

        try {
            if (objDto.getDataNascimento().matches("[0-9]{1,2}/[0-9]{1,2}/[0-9]{4,4}")){
            dataNascimento.setTime(formato.parse(objDto.getDataNascimento()));}
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar hoje = Calendar.getInstance();
        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

        //Calcular idade
        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
            idade--;
        } else {
            if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) <= dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                idade--;
            }
        }

        List<FieldMessage> erros = new ArrayList<>();

        //Validação de data e maior idade
        if (!objDto.getDataNascimento().matches("[0-9]{1,2}/[0-9]{1,2}/[0-9]{4,4}")){
            erros.add(new FieldMessage("dataNascimento", "Data com formato incorreto"));
        }
        else if (!dataOk(objDto.getDataNascimento())) {
            erros.add(new FieldMessage("dataNascimento", "Insira uma data válida"));
        } else if (idade < 18) {
            erros.add(new FieldMessage("dataNascimento", "Insira idade maior que 18 anos"));
        }

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

//        //Validacao de nome
//        String[] splitNome = objDto.getNome().toUpperCase(Locale.ROOT).split("\\s");
//        for (int i = 0; splitNome.length > i; i++) {
//            if (!splitNome[i].matches("[A-ZÀ-Ÿ]*")) {
//                erros.add(new FieldMessage("nome", "ERRO NO NOME"));
//            }
//        }

        for (FieldMessage e : erros) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return erros.isEmpty();
    }

}