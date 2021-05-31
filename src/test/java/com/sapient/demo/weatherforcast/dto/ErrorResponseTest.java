package com.sapient.demo.weatherforcast.dto;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ErrorResponseTest {

    @Test
    public void errorResponseTest_Success() {

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setErrorCode("TESTCODE");
        errorResponse.setMessage("TEST MESSAGE");

        Assert.assertEquals("TESTCODE",errorResponse.getErrorCode());

        Assert.assertEquals("TEST MESSAGE",errorResponse.getMessage());
    }

}