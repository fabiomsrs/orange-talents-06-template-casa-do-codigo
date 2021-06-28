package br.com.zupacademy.fabiano.casadocodigo.controller;

import br.com.zupacademy.fabiano.casadocodigo.dto.ClienteRegisterDto;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Cliente;
import br.com.zupacademy.fabiano.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.fabiano.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.fabiano.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteRepository repository;

    @Autowired
    PaisRepository paisRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<Cliente> cadastrar (@RequestBody @Valid ClienteRegisterDto dto){
        Cliente cliente = dto.converter(paisRepository, estadoRepository);
        repository.save(cliente);
        return ResponseEntity.ok(cliente);
    }
}