/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listening.level.Listen.config;

import com.listening.level.Listen.util.Response;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author NMSLAP415
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler{
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity handleAllException(HttpServletRequest request,Exception exception){
        log.debug("All Exception {}", exception);
        Response.Builder res = Response.builder()
                .message(exception.getMessage())
                .statusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body(res.build());
    }
    
    
    
}
