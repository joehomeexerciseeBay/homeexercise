package com.joe.homeexercise;

import static org.assertj.core.api.Assertions.assertThat;

import com.joe.homeexercise.controller.AdminController;
import com.joe.homeexercise.controller.GreetingsController;
import com.joe.homeexercise.controller.ItemEligibilityController;


import com.joe.homeexercise.resolver.ControllerParameterResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Controller context load")
@ExtendWith(ControllerParameterResolver.class)
public class SmokeTest {
    @ParameterizedTest
    @ValueSource(classes = {ItemEligibilityController.class, GreetingsController.class, AdminController.class})
    public void contextLoads(Object controller) throws Exception {
        //System.out.println(Class.forName(controller.toString()));
        assertThat(controller).isNotNull();
    }
}
