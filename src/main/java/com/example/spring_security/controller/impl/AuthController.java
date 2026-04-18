package com.example.spring_security.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_security.dto.Authenticate;
import com.example.spring_security.util.JWTUtil;

@RestController
public class AuthController {

  @Autowired
  AuthenticationManager authenticationManager;

  @PostMapping(path = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String generateToken(@RequestBody Authenticate authenticate) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
          authenticate.getUsername(),
          authenticate.getPassword()
      ));

      return JWTUtil.generateToken(authenticate.getUsername());
    }catch(Exception ex) {
      throw ex;
    }
  }
}
