
package com.InvestWithIntelligence.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Admin;
import com.InvestWithIntelligence.Repositories.AdminRepository;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load Username from database
        if (username == null || username.isBlank()) {
            throw new RuntimeException("Invalid Credentials");
        }
        Admin adminemail = adminRespository.findByEmail(username);
        return adminemail;
    }

}