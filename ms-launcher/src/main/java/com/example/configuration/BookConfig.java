package com.example.configuration;

import com.example.adapter.BookJpaAdapter;
import com.example.ports.api.BookServicePort;
import com.example.ports.spi.BookPersistencePort;
import com.example.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean
    public BookPersistencePort bookPersistencePort() {
        return new BookJpaAdapter();
    }

    @Bean
    public BookServicePort bookServicePort() {
        return new BookServiceImpl(bookPersistencePort());
    }
}
