package com.example.spring_security.dto;

import lombok.Data;

@Data
public class Authenticate {
  private String username;
  private String password;
}
