package com.example.spring_security.service.impl;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_security.UserRecord;
import com.example.spring_security.entity.User;
import com.example.spring_security.repository.UserRepository;
import com.example.spring_security.service.ICustomUserService;

@Service
public class CustomUserService implements ICustomUserService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional
  public ResponseEntity<String> saveUser(UserRecord userRecord) {
    try {
      User user = new User();
      user.setUsername(userRecord.username());
      user.setRole(userRecord.role());
      user.setPassword(passwordEncoder.encode(userRecord.password()));
      userRepository.save(user);
      return ResponseEntity.ok("User created successfully");
    } catch (Exception e) {
      System.out.println("Exception occurred cause: "+ ExceptionUtils.getStackTrace(e));
      throw new RuntimeException(e);
    }
  }
}
