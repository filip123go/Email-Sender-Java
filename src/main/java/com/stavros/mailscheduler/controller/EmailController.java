package com.stavros.mailscheduler.controller;

import com.stavros.mailscheduler.MailConstructor;
import com.stavros.mailscheduler.jsonmapper.JsonMapperToPojo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class EmailController {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    JsonMapperToPojo jsonMapperToPojo;

    @Autowired
    MailConstructor mailConstructor;


    @ApiOperation(value = "Send an email.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping(value = "/sendemail", consumes = "application/json")
    public void sendEmail(@RequestBody String emailSubjectAndBody) throws MessagingException, IOException {
        LOGGER.log(Level.INFO, "Process started");
        mailConstructor.sendmail(jsonMapperToPojo.eMailJsonToPojo(emailSubjectAndBody));
    }
}