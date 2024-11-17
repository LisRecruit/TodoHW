package com.example.config;

import com.example.model.Note;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppConfig {

    @Bean
    public SessionFactory getSessionFactory(){
        return new org.hibernate.cfg.Configuration()
                .addAnnotatedClass(Note.class)
                .buildSessionFactory();
    }
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
