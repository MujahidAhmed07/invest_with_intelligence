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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InvestWithIntelligence.AuthResponse.JwtRequest;
import com.InvestWithIntelligence.AuthResponse.JwtResponse;
import com.InvestWithIntelligence.Models.Admin;
import com.InvestWithIntelligence.Security.JWT.JwtHelper;
import com.InvestWithIntelligence.Services.UserService;
import com.InvestWithIntelligence.Services.ServicesImpl.AdminServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/iwi/auth")
public class AuthController {

    @Autowired
    private UserService adminUserService;

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper jwtHelper;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    // login Authnetication
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        this.doAuthenticate(request.getEmail(), request.getPassword());
        UserDetails userdetails = adminUserService.loadUserByUsername(request.getEmail());
        String token = this.jwtHelper.generateToken(userdetails);

        JwtResponse response = JwtResponse.builder().jwtToken(token).username(userdetails.getUsername()).build();

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    // Investor Login Authentication

    // Entreprenuer Login

    // Add Admin Account
    @PostMapping("/add/account")
    private ResponseEntity<?> add_admin_account(@Valid @RequestBody Admin adminModel) {
        try {
            logger.info("in AdminController.add_admin_account() : {}");
            return new ResponseEntity<>(this.adminServiceImpl.addAccount(adminModel), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info("Admin Account Error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

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
