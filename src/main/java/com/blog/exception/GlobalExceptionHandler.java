package com.blog.exception;  // It is a special class to handle exceptions.

import com.blog.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {               // By extends ResponseEntityExceptionHandler this becomes Global Catch Block.
              @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails>  handleGlobalException(                     // When exception occurs it will go to this method and this method put the information into errorDetail object and give it to postman response.
                        Exception exception,
                      WebRequest webRequest                                             // WebResquest help us to understand the details in which url & where exception occur.
              ){
                  ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
                  return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
              }

}


//   Steps to handle exception:
// 1.Create one custom exception class that extends RunTimeException.
// 2.Create a controller advice class in that it will develop exception handler method which has the annotation @ExceptionHandler.
// 3.In that create one exception handler method.

// Steps
// 1.created exception class. By extending RunTimeException.In that one constructor with a super keyword.
// 2. RunTimeException extends Exception class.
// 3. Exception class extends Throwable.

// // Catch Block - Catch Block supress Exception.
// //  Try Block   - Try Block thorws Exception.

// Specific Exception - It can handle only particular exception.ex: Arithmetic Exception, NullPointer Exception
// Global Exception   -
