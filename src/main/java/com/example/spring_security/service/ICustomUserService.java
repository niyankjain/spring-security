package com.example.spring_security.service;

import org.springframework.http.ResponseEntity;

import com.example.spring_security.UserRecord;

public interface ICustomUserService {

  public ResponseEntity<String> saveUser(UserRecord userRecord);
}
