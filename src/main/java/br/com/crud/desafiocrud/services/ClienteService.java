package br.com.crud.desafiocrud.services;

import br.com.crud.desafiocrud.dto.NewClienteDTO;
import br.com.crud.desafiocrud.dto.UpdateClienteDto;
import br.com.crud.desafiocrud.entity.Cliente;
import br.com.crud.desafiocrud.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    //CREATE
    public Cliente create(Cliente clienteModel) {
        return clienteRepository.save(clienteModel);
    }

    //READ
    public Optional<Cliente> read(Integer idCliente) {
        Optional<Cliente> clienteModel = clienteRepository.findById(idCliente);

        return clienteModel;
    }

    //READ ALL

    public List<Cliente> readAll() {
        return clienteRepository.findAll();
    }

    //UPDATE

    public Cliente update(Cliente clienteModel) {
        Cliente newClienteModel = read(clienteModel.getIdCliente()).get();
        updateCliente(clienteModel,newClienteModel);
        return clienteRepository.save(newClienteModel);
    }

    public void updateCliente (Cliente clienteModel, Cliente newClienteModel){
    newClienteModel.setEmail(clienteModel.getEmail());
    newClienteModel.setNome(clienteModel.getNome());
    newClienteModel.setDataNascimento(clienteModel.getDataNascimento());
    }

    //DELETE

    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }

    //CLIENTE FROM DTO
    public Cliente fromNewDto (NewClienteDTO clienteDto){
        Date data = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data = formato.parse(clienteDto.getDataNascimento());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Cliente clienteModel = new Cliente();
        clienteModel.setNome(clienteDto.getNome());
        clienteModel.setEmail(clienteDto.getEmail());
        clienteModel.setCpf(clienteDto.getCpf());
        clienteModel.setDataNascimento(data);
        clienteModel.setAgencia(clienteDto.getAgencia());
        clienteModel.setConta(clienteDto.getConta());
        clienteModel.setRenda(clienteDto.getRenda());
        clienteModel.setPatrimonio(clienteDto.getPatrimonio());
        clienteModel.setCelular(clienteDto.getCelular());
        clienteModel.setCelular(clienteDto.getCelular());
        clienteModel.setSenha(clienteDto.getSenha());
        clienteModel.setSaldo(clienteDto.getSaldo());

        return clienteModel;
    }

    //UPDATE CLIENTEDTO
    public Cliente fromUpdateDto (UpdateClienteDto updateClienteDto){
        Date data = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data = formato.parse(updateClienteDto.getDataNascimento());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Cliente clienteModel = new Cliente();
        clienteModel.setNome(updateClienteDto.getNome());
        clienteModel.setEmail(updateClienteDto.getEmail());
        clienteModel.setDataNascimento(data);
        return clienteModel;
    }
}
//C-reate
//R-ead
//U-pdate
//D-elete
