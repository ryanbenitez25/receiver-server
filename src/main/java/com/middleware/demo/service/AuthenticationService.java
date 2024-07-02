package com.middleware.demo.service;

import com.middleware.demo.dto.LoginUserDto;
import com.middleware.demo.dto.RegisterUserDto;
import com.middleware.demo.model.User;
import com.middleware.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
   @Autowired private UserRepository userRepository;
   @Autowired private PasswordEncoder passwordEncoder;
   @Autowired private AuthenticationManager authenticationManager;

   public User signup(RegisterUserDto input) {
      User user = new User();
      user.setUsername(input.getUsername());
      user.setFullName(input.getFullName());
      user.setPassword(passwordEncoder.encode(input.getPassword()));
      return userRepository.save(user);
   }

   public User authenticate(LoginUserDto input) {
      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      input.getUsername(),
                      input.getPassword()
              )
      );

      return userRepository.findByUsername(input.getUsername())
              .orElseThrow();
   }
}
