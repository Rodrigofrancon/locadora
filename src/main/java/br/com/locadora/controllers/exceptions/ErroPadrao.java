package br.com.locadora.controllers.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
@Getter
@Setter

public class ErroPadrao implements Serializable {

    private static final long serialVersionUID = 1L;

    private Instant timeStamp;
    private Integer status;
    private String erro;
    private String mensagem;
    private String caminho;

    public ErroPadrao() {
    }
}
