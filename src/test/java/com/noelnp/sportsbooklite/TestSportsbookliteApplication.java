package com.noelnp.sportsbooklite;

import org.springframework.boot.SpringApplication;

public class TestSportsbookliteApplication {

    public static void main(String[] args) {
        SpringApplication.from(SportsbookliteApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
