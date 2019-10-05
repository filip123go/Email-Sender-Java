package com.stavros.mailscheduler.configurationclasses;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
public class EmailPropertiesConfiguration {

    public Properties setUpMailProperties() {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        return props;
    }

    public String[] getEmailAndPassword(){
        String emailFrom = "<< INPUT THE SENDER'S EMAIL ADDRESS HERE e.x thisismyemail@gmail.com >>";
        String password = "<< INPUT THE SENDER'S PASSWORD HERE e.x 12345678 >>";
        return new String[]{emailFrom, password};
    }

    public List<String> getEmailRecipients(){
        ArrayList<String> emailRecipients= new ArrayList<>();
        emailRecipients.add("<< INPUT THE FIRST'S RECIPIENT'S EMAIL HERE >>");
        emailRecipients.add("<< INPUT THE SECOND'S RECIPIENT'S EMAIL HERE etc>>");
        return emailRecipients;
    }
}
