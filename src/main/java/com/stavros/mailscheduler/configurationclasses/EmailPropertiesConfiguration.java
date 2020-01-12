package com.stavros.mailscheduler.configurationclasses;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
@Configuration
@PropertySource("classpath:application.properties")
public class EmailPropertiesConfiguration {

    @Value("${ca.email.from}")
    private String emailFrom;

    @Value("${ca.password.from}")
    private String password;

    @Value("${ca.mail.smtp.auth}")
    private String mailSmtpAuth;

    @Value("${ca.mail.smtp.starttls.enable}")
    private String mailSmtpStartTls;

    @Value("${ca.mail.smtp.host}")
    private String mailSmtpHost;

    @Value("${ca.mail.smtp.port}")
    private String mailSmtpPort;

    @Value("${ca.mail.smtp.recipient.1}")
    private String mailSmtpRecipient;


    public Properties setUpMailProperties() {

        Properties props = new Properties();
        props.put("mail.smtp.auth", mailSmtpAuth);
        props.put("mail.smtp.starttls.enable", mailSmtpStartTls);
        props.put("mail.smtp.host", mailSmtpHost);
        props.put("mail.smtp.port", mailSmtpPort);

        return props;
    }

    public String[] getEmailAndPassword() {
        return new String[]{emailFrom, password};
    }

    public List<String> getEmailRecipients() {
        ArrayList<String> emailRecipients = new ArrayList<>();
        emailRecipients.add(mailSmtpRecipient);
        return emailRecipients;
    }
}
