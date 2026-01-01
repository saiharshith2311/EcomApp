package com.project.springbootbackend.controller;


import com.project.springbootbackend.scopes.ApplicationScopedBean;
import com.project.springbootbackend.scopes.RequestScopedBean;
import com.project.springbootbackend.scopes.SessionScopedBean;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/scope")
@RequiredArgsConstructor
public class ScopeController {
    private final RequestScopedBean requestScopedBean;
    private final SessionScopedBean sessionScopedBean;
    private final ApplicationScopedBean applicationScopedBean;

    @GetMapping("/request")
    public ResponseEntity<String> testRequestScope() {
        requestScopedBean.setName("JOHN");
        return ResponseEntity.ok().body(requestScopedBean.getName());

    }
    @GetMapping("/session")
    public ResponseEntity<String> testSessionScope() {
        sessionScopedBean.setName("JOHN");
        return ResponseEntity.ok().body(sessionScopedBean.getName());

    }
    @GetMapping("/application")
    public ResponseEntity<Integer> testApplicationScope() {
        applicationScopedBean.incrementCounter();
        return ResponseEntity.ok().body(applicationScopedBean.getCounter());

    }

    @GetMapping("/test")
    public ResponseEntity<String> testScope() {

        return ResponseEntity.ok().body(sessionScopedBean.getName());

    }


}
