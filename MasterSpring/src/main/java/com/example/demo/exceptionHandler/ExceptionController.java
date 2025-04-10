package com.example.demo.exceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

import javax.security.auth.login.LoginException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.exceptionHandler.customException.DatiNonValidiException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionController {
	
/*	@ExceptionHandler(LoginNonValidaException.class)
	public ResponseEntity<MessaggioErrore> loginNonValida(LoginNonValidaException e, WebRequest wr){
		MessaggioErrore errorMsg=new MessaggioErrore(HttpStatus.NOT_ACCEPTABLE.value(),HttpStatus.NOT_ACCEPTABLE.name() ,e.getMessage(), wr.getDescription(false));
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorMsg);
	}*/
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MessaggioErrore> MethodArgumentNotValid(MethodArgumentNotValidException ex){
		Map<String, String> errori=ex.getBindingResult().getFieldErrors()
				.stream()
				.collect(Collectors.toMap(FieldError::getField,DefaultMessageSourceResolvable::getDefaultMessage));
		MessaggioErrore me=new MessaggioErrore(HttpStatus.NOT_ACCEPTABLE, errori);
		return ResponseEntity.status(me.getStatus()).body(me);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<MessaggioErrore> MethodArgumentNotValid(ConstraintViolationException ex){
		Map<String, String> errori=ex.getConstraintViolations()
				.stream()
				.collect(Collectors.toMap(e->e.getPropertyPath().toString(), e->e.getMessage()));
		MessaggioErrore me=new MessaggioErrore(HttpStatus.I_AM_A_TEAPOT, errori);
		return ResponseEntity.status(me.getStatus()).body(me);
	}
	
	@ExceptionHandler(DatiNonValidiException.class)
	public ResponseEntity<Errore> LoginNonValida(DatiNonValidiException ex, WebRequest wr){
		Errore er=new Errore(HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage(), HttpStatus.NOT_ACCEPTABLE.name(), wr.getDescription(false));
		return ResponseEntity.status(er.getStatus()).body(er);
	}
}
