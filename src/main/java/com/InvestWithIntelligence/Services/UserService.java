
package com.InvestWithIntelligence.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Admin;
import com.InvestWithIntelligence.Models.Entreprenuer;
import com.InvestWithIntelligence.Models.Investor;
import com.InvestWithIntelligence.Repositories.AdminRepository;
import com.InvestWithIntelligence.Repositories.EntreprenuerRepository;
import com.InvestWithIntelligence.Repositories.InvestorRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private InvestorRepository investorRepository;

    @Autowired
    private EntreprenuerRepository entrepreneurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.isBlank()) {
            throw new RuntimeException("Invalid Credentials");
        }

        // Check if the user is an admin
        Admin admin = adminRepository.findByEmail(username);
        if (admin != null) {
            System.out.println("admin loading..");
            return admin;
        }

        // Check if the user is an investor
        Investor investor = investorRepository.findByEmail(username);
        if (investor != null) {
            System.out.println("investor loading..");
            return investor;
        }

        // Check if the user is an entrepreneur
        Entreprenuer entrepreneur = entrepreneurRepository.findByEmail(username);
        if (entrepreneur != null) {
            System.out.println("entreprenuer loading..");
            return entrepreneur;
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
