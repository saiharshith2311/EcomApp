package com.project.springbootbackend.scopes;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@ApplicationScope
@Getter
@Setter
public class ApplicationScopedBean {
    private int counter;
    public void incrementCounter() {
        counter++;
    }
}
