package com.example.spring_security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spring_security.entity.User;
import com.example.spring_security.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository repository;

  @Override
  public User loadUserByUsername(String username) {
    return repository.findByUsername(username).orElseThrow(
        () -> new UsernameNotFoundException("User not found with username: " + username));
  }
}
