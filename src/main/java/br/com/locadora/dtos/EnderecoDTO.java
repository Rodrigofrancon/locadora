package br.com.locadora.dtos;

import br.com.locadora.entities.Endereco;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Getter
@Setter
public class EnderecoDTO extends RepresentationModel<EnderecoDTO> implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Long id, String logradouro, String numero, String complemento, String bairro, String cep, String cidade, String estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }
    public EnderecoDTO(Endereco entity) {
        this.id = entity.getId();
        this.logradouro = entity.getLogradouro();
        this.numero = entity.getNumero();
        this.complemento = entity.getComplemento();
        this.bairro = entity.getBairro();
        this.cep = entity.getCep();
        this.cidade = entity.getCidade();
        this.estado = entity.getEstado();
    }
}
