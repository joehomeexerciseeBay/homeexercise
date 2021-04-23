package com.joe.homeexercise;

import static org.assertj.core.api.Assertions.assertThat;

import com.joe.homeexercise.controller.ItemEligibilityController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private ItemEligibilityController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
