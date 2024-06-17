package org.project.tasklist_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class TasklistDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasklistDemoApplication.class, args);
    }

}
