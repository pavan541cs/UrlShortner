package org.example.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ShortLinkConfiguration {
    @Bean
    public ModelMapper createMapper() {
        return new ModelMapper();
    }

    @Bean
    public Random createRandom() {
        return new Random();
    }
}
