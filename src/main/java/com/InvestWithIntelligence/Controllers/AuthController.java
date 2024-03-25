package com.InvestWithIntelligence.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InvestWithIntelligence.AuthResponse.JwtRequest;
import com.InvestWithIntelligence.AuthResponse.JwtResponse;
import com.InvestWithIntelligence.Security.JWT.JwtHelper;
import com.InvestWithIntelligence.Services.UserService;

@RestController
@RequestMapping("api/iwi/auth")
@CrossOrigin(origins = "*")

public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper jwtHelper;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    // Admin login Authnetication
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("admin/login")
    public ResponseEntity<JwtResponse> adminLogin(@RequestBody JwtRequest request) {
        try {
            this.doAuthenticate(request.getEmail(), request.getPassword());
            UserDetails userdetails = userService.loadUserByUsername(request.getEmail());
            String token = this.jwtHelper.generateToken(userdetails);

            JwtResponse response = JwtResponse.builder().jwtToken(token).username(userdetails.getUsername()).build();

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            logger.info("Login Admin Account By Username");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Investor Login Authentication

    // @PreAuthorize("hasRole('ROLE_INVESTOR')")
    @PostMapping("investor/login")
    public ResponseEntity<JwtResponse> investorLogin(@RequestBody JwtRequest request) {
        this.doAuthenticate(request.getEmail(), request.getPassword());
        UserDetails userdetails = userService.loadUserByUsername(request.getEmail());
        String token = this.jwtHelper.generateToken(userdetails);

        JwtResponse response = JwtResponse.builder().jwtToken(token).username(userdetails.getUsername()).build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    // Entreprenuer Login

    // @PreAuthorize("hasRole('ROLE_ENTREPRENUER')")
    @PostMapping("entreprenuer/login")
    public ResponseEntity<JwtResponse> entreprenuerLogin(@RequestBody JwtRequest request) {
        this.doAuthenticate(request.getEmail(), request.getPassword());
        UserDetails userdetails = userService.loadUserByUsername(request.getEmail());
        String token = this.jwtHelper.generateToken(userdetails);

        JwtResponse response = JwtResponse.builder().jwtToken(token).username(userdetails.getUsername()).build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    // Authentication of URLS
    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid Username & Password !!");
        }
    }
}
