package com.pittest;

import com.pittest.car.usecase.FiltersByBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;


@ComponentScan({ "com.pittest.car" })
@SpringBootApplication
public class Starter implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);

    @Autowired
    private FiltersByBrand identificaCarrosAudi;

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        LOGGER.info("start application");
        identificaCarrosAudi.process(new ArrayList(),"");
    }

}
