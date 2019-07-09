package junk;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;


public class TrySendEmail {

    @Test
    public void sendEmail() throws EmailException {
        Email email = new SimpleEmail(); // Create Object
        email.setHostName("smtp.googlemail.com"); // Set SMTP hostname
        email.setSmtpPort(465); // Set port
        email.setAuthenticator(new DefaultAuthenticator("muzyria.oleg@pdffiller.team", "Machmala89")); // Set email/password
        email.setSSLOnConnect(true); // SSL true
        email.setFrom("user@gmail.com"); // set FROM
        email.setSubject("TestMail"); // set Subject
        email.setMsg("This is a test mail ... :-)"); // Set message
        email.addTo("muzyria.oleg@pdffiller.team"); // Set recipients
        email.send(); // Send Email
    }


}
