package br.com.crud.desafiocrud.controllers;

import br.com.crud.desafiocrud.dto.NewPixDTO;
import br.com.crud.desafiocrud.dto.UpdatePixDto;
import br.com.crud.desafiocrud.entity.Pix;
import br.com.crud.desafiocrud.services.PixService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pix")
public class PixController {

    @Autowired
    private PixService pixService;

    //CREATE
    @ApiOperation("Cadastrar Pix")
    @PostMapping()
    public ResponseEntity<Pix> create(@Valid @RequestBody NewPixDTO pixDto) {
        Pix pixModel = pixService.fromNewDto(pixDto);
        pixService.create(pixModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pixModel.getIdPix()).toUri();
        return ResponseEntity.created(uri).body(pixModel);

        // status(HttpStatus.CREATED).body(endpoint);
    }

    //READ ID
    @ApiOperation("Buscar Pix por ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Integer id) {
        Optional<Pix> pixModel = pixService.read(id);
        if (!pixModel.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pixModel);
    }

    //READ ALL
    @ApiOperation("Buscar todos os pixs")
    @GetMapping()
    public ResponseEntity<List<Pix>> readAll() {
        List<Pix> list = new ArrayList();
        list = pixService.readAll();
        return ResponseEntity.ok().body(list);
    }

    //UPDATE
    @ApiOperation("Atualizar pix por ID")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@Valid @RequestBody UpdatePixDto updatePixDto) {
        Pix pixModel = pixService.fromUpdateDto(updatePixDto);
        if (!pixService.read(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pixModel.setIdPix(id);
        pixService.update(pixModel);
        return ResponseEntity.ok().build();
    }

    //DELETE
    @ApiOperation("Apagar Pix por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!pixService.read(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pixService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
