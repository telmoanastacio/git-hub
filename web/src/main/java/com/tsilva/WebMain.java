package com.tsilva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class WebMain implements CommandLineRunner
{
    @Autowired
    Environment env;

    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("======================");
        System.out.println("== APPLICATION LINK ==");
        System.out.println("======================");
        String port = env.getProperty("local.server.port");
        System.out.println("http://localhost:" + port + "/");
        System.out.println("== OR ==");
        System.out.println("http://127.0.0.1:" + port + "/");
        System.out.println("======================");
    }

    public static void main(String[] args)
    {
        SpringApplication.run(WebMain.class, args);
    }
}