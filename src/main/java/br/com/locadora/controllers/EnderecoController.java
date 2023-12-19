package br.com.locadora.controllers;

import br.com.locadora.dtos.EnderecoDTO;
import br.com.locadora.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/v1/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    //Procurar Todos Enderecos
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> procurarTodos(){
        List<EnderecoDTO> list = service.procurarTodos();
        for (EnderecoDTO e : list){
            long id = e.getId();
            e.add(linkTo(methodOn(EnderecoController.class)
                    .procurarPorIdEndereco(id)).withSelfRel());
        }

        return ResponseEntity.ok(list);
    }

    //buscar endereco por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<EnderecoDTO> procurarPorIdEndereco(@PathVariable Long id){
        EnderecoDTO dto = service.procurarPorIdEndereco(id);
        dto.add(linkTo(methodOn(EnderecoController.class)
                .procurarTodos()).withRel("Lista de Endereco"));
        return ResponseEntity.ok().body(dto);
    }
}
