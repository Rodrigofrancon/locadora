package br.com.locadora.services;

import br.com.locadora.dtos.EnderecoDTO;
import br.com.locadora.entities.Endereco;
import br.com.locadora.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    //Procurar todos os endereços
    @Transactional(readOnly = true)
    public List<EnderecoDTO> procurarTodos(){
        List<Endereco> list = repository.findAll();
        return list.stream().map(x -> new EnderecoDTO(x)).collect(Collectors.toList());
    }

    //Procurar por um endereço por ir
    @Transactional
    public EnderecoDTO procurarPorIdEndereco(Long id){
        Optional<Endereco> object = repository.findById(id);
        Endereco entidade = object.get();
        return new EnderecoDTO(entidade);
    }
    //Criar um novo endereço

    //Procurar por Cliente e endereco

    //Procurar por funcionario e endereco

    //Criar um novo endereço

    //Atualizar um endereço

    //Excluir um endereço
}
