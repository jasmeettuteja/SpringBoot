package com.example.SpringBootPractice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends RuntimeException{
}
