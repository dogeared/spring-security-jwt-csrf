package com.afitnerd.jjwtfun.controller;

import com.afitnerd.jjwtfun.model.JwtResponse;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BaseController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({SignatureException.class, MalformedJwtException.class, JwtException.class})
    public JwtResponse exception(Exception e) {
        JwtResponse response = new JwtResponse();
        response.setStatus(JwtResponse.Status.ERROR);
        response.setMessage(e.getMessage());
        response.setExceptionType(e.getClass().getName());

        return response;
    }
}
