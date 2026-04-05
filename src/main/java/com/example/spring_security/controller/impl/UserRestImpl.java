package com.example.spring_security.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_security.UserRecord;
import com.example.spring_security.service.ICustomUserService;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestImpl{

  @Autowired
  private ICustomUserService customUserService;

  @PostMapping(path = "/v1/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> signup(@RequestBody UserRecord userRecord) {

    return customUserService.saveUser(userRecord);
  }

  @GetMapping(path = "/v1/hello", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> hello() {
    return ResponseEntity.ok("Hello World!");
  }
}
