package br.com.crud.desafiocrud.services;

import br.com.crud.desafiocrud.dto.NewClienteDTO;
import br.com.crud.desafiocrud.dto.NewPixDTO;
import br.com.crud.desafiocrud.entity.Cliente;
import br.com.crud.desafiocrud.entity.Pix;
import br.com.crud.desafiocrud.repositories.PixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class PixService {

    @Autowired
    PixRepository pixRepository;


    //Create
    public Pix create(Pix pixModel) {
        return pixRepository.save(pixModel);
    }

    //Read
    public Optional<Pix> read(Integer idPix) {
        Optional<Pix> pixModel = pixRepository.findById(idPix);

        return pixModel;
    }

    //Read All
    public List<Pix> readAll() {
        return pixRepository.findAll();
    }

    //UPDATE

    public Pix update(Pix pixModel) {
        Pix newPixModel = read(pixModel.getIdPix()).get();
        updatePix(pixModel,newPixModel);
        return pixRepository.save(newPixModel);
    }

    public void updatePix (Pix pixModel, Pix newPixModel){
        newPixModel.setEmail(pixModel.getEmail());
        newPixModel.setCpf(pixModel.getCpf());
        newPixModel.setTelefone(pixModel.getTelefone());
        newPixModel.setAleatoria(pixModel.getAleatoria());
    }

    //Delete

    public void delete(Integer id) {
        pixRepository.deleteById(id);
    }

    //PIX FROM DTO

    public Pix fromNewDto (NewPixDTO pixDto){

        Pix pixModel = new Pix();
        pixModel.setCpf(pixDto.getCpf());
        pixModel.setEmail(pixDto.getEmail());
        pixModel.setAleatoria(pixDto.getAleatoria());
        pixModel.setTelefone(pixDto.getTelefone());

//
        return pixModel;
    }


}
