package ru.isaev.demoserver.controllers.requestException;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThereIsNoSuchBookException.class)
    protected ResponseEntity<AwesomeException> handleThereIsNoSuchBookException() {
        return new ResponseEntity<>(new AwesomeException("Нет книги с таким Id"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ThereIsUnacceptableValueException.class)
    protected ResponseEntity<AwesomeException> handleThereIsUnacceptableValueException() {
        return new ResponseEntity<>(new AwesomeException("Id должен быть больше 1"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ThereIsEmptyRequestException.class)
    protected ResponseEntity<AwesomeException> handleThereIsEmptyRequestException() {
        return new ResponseEntity<>(new AwesomeException("Зпрос не должен быть пустым"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ThereIsNotFoundBookException.class)
    protected ResponseEntity<AwesomeException> handleThereIsNotFoundBookException() {
        return new ResponseEntity<>(new AwesomeException("Нет книги с таким названием, жанром или автором"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class AwesomeException {
        private String message;
    }
}
