package com.BooksMemory.booksMemory.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Configuration
public class MapperConfiguration {

    @Bean
    public Jackson2RepositoryPopulatorFactoryBean getRepositoryPopulate(ObjectMapper objectMapper) {
        Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
        factory.setMapper(objectMapper);
        factory.setResources(new Resource[]{new ClassPathResource("books-data.json")});
        return factory;
    }

}
