package br.com.locadora.dtos;

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
}
