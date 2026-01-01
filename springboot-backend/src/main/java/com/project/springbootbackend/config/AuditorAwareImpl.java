package com.project.springbootbackend.config;

import com.project.springbootbackend.entity.Customer;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component("auditorAwareImpl")
public class AuditorAwareImpl implements AuditorAware<String> {



    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated()  || authentication.getPrincipal() == "anonymousUser") {
           return Optional.of("anonymousUser");
        }
        Object principal = authentication.getPrincipal();
        String username;
        if(principal instanceof Customer customer) {
            username=customer.getEmail();
        }else{
            username=principal.toString();
        }


        return Optional.of(username);
    }
}
