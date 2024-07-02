package com.middleware.demo.controller;

import com.middleware.demo.dto.LoginResponseDto;
import com.middleware.demo.dto.LoginUserDto;
import com.middleware.demo.dto.RegisterUserDto;
import com.middleware.demo.model.User;
import com.middleware.demo.service.AuthenticationService;
import com.middleware.demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

   @Autowired private JwtService jwtService;

   @Autowired
   private AuthenticationService authenticationService;

   @PostMapping("/signup")
   @ResponseBody
   public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
      User registeredUser = authenticationService.signup(registerUserDto);
      return ResponseEntity.ok(registeredUser);
   }

   @PostMapping( path = "/signin", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody
   public ResponseEntity<LoginResponseDto> authenticate(LoginUserDto loginUserDto) {
      User authenticatedUser = authenticationService.authenticate(loginUserDto);
      String jwtToken = jwtService.generateToken(authenticatedUser);
      LoginResponseDto loginResponse = new LoginResponseDto();
      loginResponse.setToken(jwtToken);
      loginResponse.setExpiresIn(jwtService.getExpirationTime());
      return ResponseEntity.ok(loginResponse);
   }
}