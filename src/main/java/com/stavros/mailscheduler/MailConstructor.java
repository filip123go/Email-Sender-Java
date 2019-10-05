package com.stavros.mailscheduler;

import com.stavros.mailscheduler.Model.EmailModel;
import com.stavros.mailscheduler.configurationclasses.EmailPropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class MailConstructor {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    EmailPropertiesConfiguration props;

    public void sendmail(EmailModel emailModel) throws MessagingException {


        LOGGER.log(Level.INFO, "Creating Session");
        Session session = Session.getInstance(props.setUpMailProperties(), new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                LOGGER.log(Level.INFO, "Authenticating sender's Email and Password");
                return new PasswordAuthentication(props.getEmailAndPassword()[0], props.getEmailAndPassword()[1]); //props.setEmailAndPassword()[0] = email from , props.setEmailAndPassword()[1] = email password
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(props.getEmailAndPassword()[0], false));

        LOGGER.log(Level.INFO, "Parsing Recipients");
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(props.getEmailRecipients().get(0))); //list of email recipients separated by comma (ex: email1@gmail.com,email2@gmail.com ) todo// make this more efficient
        msg.setSubject(emailModel.getEmailSubject());
        msg.setContent(emailModel.getEmailBody(), "text/html");
        msg.setSentDate(new Date());

        LOGGER.log(Level.INFO, "Sending E-mail");
        Transport.send(msg);
    }
}
