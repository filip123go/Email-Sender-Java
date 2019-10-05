package com.stavros.mailscheduler.jsonmapper;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stavros.mailscheduler.Model.EmailModel;
import org.springframework.stereotype.Component;

@Component
public class JsonMapperToPojo {
    private ObjectMapper mapper = new ObjectMapper();

    public EmailModel eMailJsonToPojo(String userJson) throws IOException {
        return mapper.readValue(userJson, EmailModel.class);
    }
}
