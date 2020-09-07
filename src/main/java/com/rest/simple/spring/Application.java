package com.rest.simple.spring;

import com.rest.simple.spring.config.Handler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        //non mvc exception handler (like db connection errors and so on)
        Thread.setDefaultUncaughtExceptionHandler(new Handler());
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        this.onStartup();
    }

    void onStartup() {
        log.info("\n\n\t+=========================================+\n" +
                "\t| APPLICATION STARTED SUCCESSFULLY |\n" +
                "\t+=========================================+\n\n");
    }
}


