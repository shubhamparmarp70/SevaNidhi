package org.example.sevanidhi.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


public class RegisterRequest {

 private String fullName;
 private String email;
 private String password;
 private String confirmPassword;
 private String mobileNumber;
 private String aadhaarNumber;
 private String state;
 private String district;

 public RegisterRequest() {}

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 // add other getters/setters as needed
}