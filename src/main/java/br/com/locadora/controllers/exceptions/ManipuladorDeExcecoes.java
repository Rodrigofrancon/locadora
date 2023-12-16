package br.com.locadora.controllers.exceptions;

import br.com.locadora.services.exceptions.IntegridadeDB;
import br.com.locadora.services.exceptions.RecursoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ManipuladorDeExcecoes {

    @ExceptionHandler(RecursoNaoEncontrado.class)
    public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontrado exception,
                                                           HttpServletRequest requisicion){
        HttpStatus status =  HttpStatus.NOT_FOUND;
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setTimeStamp(Instant.now());
        erroPadrao.setStatus(status.value());
        erroPadrao.setErro("CONTROLLER - 404 (ID não eoncontrado)");
        erroPadrao.setMensagem(exception.getMessage());
        erroPadrao.setCaminho(requisicion.getRequestURI());
        return ResponseEntity.status(status).body(erroPadrao);
    }
    @ExceptionHandler(IntegridadeDB.class)
    public ResponseEntity<ErroPadrao> integridadeDB(IntegridadeDB integ,
                                                    HttpServletRequest requisicion){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setTimeStamp(Instant.now());
        erroPadrao.setStatus(status.value());
        erroPadrao.setErro("CONTROLLER - 400 (Violação de integridade");
        erroPadrao.setMensagem(integ.getMessage());
        erroPadrao.setCaminho(requisicion.getRequestURI());
        return ResponseEntity.status(status).body(erroPadrao);
    }

}