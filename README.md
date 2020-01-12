# Email-Sender-Java
An Email sender for sending an Email from a single Sender to multiple Recipients.

Clone or download and run. For the program to work the right configuration must be done. 
In the  application.properties : ca.email.from , ca.password.from and ca.mail.smtp.recipient.1 (if you want more recipients you have to add them in emailRecipients ArrayList and add the names in application.properties) should be setted up correctly.
Also Less secure apps must be enabled to the sender's account. Here more info: https://support.google.com/cloudidentity/answer/6260879?hl=en

The program is configured to work with a gmail as  a sender's email (The recipients can be emails from any provider).
To change sender's provider additional changes must be made in Properties method in the EmailPropertiesConfiguration.class .

The Api can be seen here after running the program to your machine: http://localhost:8080/swagger-ui.html
There is a post request which recieves a json . The json should have the bellow structure:

{
"emailSubject": "This is the subject",
"emailBody":"This is the body"
}

A scheduler for the emails will be added in the future.


Technologies: Swagger, Maven, SpringBoot, javax.mail, json
