package com.example.demo.exceptionHandler;

import java.time.LocalDateTime;

import javax.security.auth.login.LoginException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.exceptionHandler.customException.DatiNonValidiException;

@RestControllerAdvice
public class ExceptionController {
	
/*	@ExceptionHandler(LoginNonValidaException.class)
	public ResponseEntity<MessaggioErrore> loginNonValida(LoginNonValidaException e, WebRequest wr){
		MessaggioErrore errorMsg=new MessaggioErrore(HttpStatus.NOT_ACCEPTABLE.value(),HttpStatus.NOT_ACCEPTABLE.name() ,e.getMessage(), wr.getDescription(false));
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorMsg);
	}*/
	
	
}
