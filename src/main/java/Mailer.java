import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mailer extends Key {
    public void sendMessage(String message) {
        Key myKey = new Key();
        String password = myKey.getPassword();


        // mail client setup
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tlee753server", password);
            }});

        // mail message setup
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("tlee753server@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    // InternetAddress.parse("8606708284@vzwpix.com")); // JON
                    // InternetAddress.parse("4702634639@message.ting.com")); // LAUREN
                    // InternetAddress.parse("7705708727@vzwpix.com")); // BRANDON
                    InternetAddress.parse("6787391126@vzwpix.com"));

            // email
            message.setSubject("Testing Java App");
            message.setText(

                    messageString.toString()

            );

            // send message
            Transport.send(message);
            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


    }
}