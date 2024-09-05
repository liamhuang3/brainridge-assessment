package com.example.brainridgeassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// not using a database
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BrainridgeAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrainridgeAssessmentApplication.class, args);
    }

}
