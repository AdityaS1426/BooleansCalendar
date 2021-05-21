package com.booleans.calendar.controllers.ListComparisonDataClasses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class ListRepositoryLoader {



    private static final Logger log = LoggerFactory.getLogger(ListRepositoryLoader.class);

    @Bean
    CommandLineRunner initDatabase(ListRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new ListEntity(new ArrayList(Arrays.asList(1,2,3,4,5,6)))));
        };
    }
}

