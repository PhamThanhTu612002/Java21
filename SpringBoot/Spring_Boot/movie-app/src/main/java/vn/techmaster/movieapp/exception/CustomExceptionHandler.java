package vn.techmaster.movieapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vn.techmaster.movieapp.model.response.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException exception){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST); //400
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND,exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND); //404
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR); //500
    }

}
