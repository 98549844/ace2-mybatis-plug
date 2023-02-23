package com.ace2.mybatisplug;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Ace2MybatisPlugApplication {

    private static final Logger log = LogManager.getLogger(Ace2MybatisPlugApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(Ace2MybatisPlugApplication.class, args);
        log.info("Ace2 Mybatis-plus startup complete !!!");
    }

}
