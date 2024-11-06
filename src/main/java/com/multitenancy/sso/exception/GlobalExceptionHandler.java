package com.multitenancy.sso.exception;


import com.multitenancy.sso.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public Response<String> handleUserNotFound(UserNotFoundException ex) {
        log.error("User not found exception occurred : {}", ex.getMessage());
        return new Response<>(HttpStatus.NOT_FOUND, "User not found");
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public Response<String> handleInvalidCredentials(InvalidCredentialsException ex) {
        log.error("Invalid credential exception occurred : {}", ex.getMessage());
        return new Response<>(HttpStatus.UNAUTHORIZED, "Invalid credentials");
    }

    @ExceptionHandler(TenantNotFoundException.class)
    public Response<String> handleTenantNotFound(TenantNotFoundException ex) {
        log.error("Tenant not found exception occurred : {}", ex.getMessage());
        return new Response<>(HttpStatus.NOT_FOUND, "Tenant not found");
    }

    @ExceptionHandler(SystemException.class)
    public Response<String> handleSystemException(SystemException ex) {
        log.error("System exception occurred : {}", ex.getMessage());
        return new Response<>(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Response<String> handleGeneralException(Exception ex) {
        log.error("Exception occurred : {}", ex.getMessage());
        return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred");
    }

    @ExceptionHandler(BadCredentialsException.class)
        public Response<String> handleBadCredential(BadCredentialsException ex) {
        log.error("Bad credentials exception occurred : {}", ex.getMessage());
            return new Response<>(HttpStatus.UNAUTHORIZED, "Invalid Credentials");
        }

    @ExceptionHandler(RuntimeException.class)
    public Response<String> handleRunTimeException(RuntimeException ex) {
        log.error("Runtime exception occurred : {}", ex.getMessage());
        return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Response<String> handleIllegalArg(IllegalArgumentException ex) {
        log.error("Illegal Argument exception occurred : {}", ex.getMessage());
        return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, "Illegal Argument exception occurred");
    }
}
