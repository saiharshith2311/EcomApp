package com.project.springbootbackend.security;

import com.project.springbootbackend.entity.Customer;
import com.project.springbootbackend.entity.Role;
import com.project.springbootbackend.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EazyStoreUserNamePwdAuthenticationProvider implements AuthenticationProvider {


private final CustomerRepository customerRepository;
private final PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username=authentication.getName();
        String password=authentication.getCredentials().toString();
        Customer customer=customerRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("Customer not found")
        );
        Set<Role> roles=customer.getRoles();
        List<GrantedAuthority> authorities=roles.stream().map(role ->
                (GrantedAuthority) role::getName).toList();
        if(passwordEncoder.matches(password,customer.getPasswordHash())){
            return new UsernamePasswordAuthenticationToken(customer,null, authorities);
        }else{
            throw new BadCredentialsException("Bad credentials");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
