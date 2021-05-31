package com.sapient.demo.weatherforcast.controller;

import com.sapient.demo.weatherforcast.dto.ErrorResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseControllerTest {

    @Autowired
    BaseController baseController;

    @Test
    public void handleError() {

        ResponseEntity<ErrorResponse> resp = baseController.handleError();
        Assert.assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
    }
}