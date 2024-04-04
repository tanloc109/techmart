package sample.sp24.t4s2.google;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtilsOTP {

    public static void sendMail(String recepient, String otp) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "locptfu@gmail.com"; 
        String password = "ozrzatwrgicusndl"; 

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }

        });

        Message message = prepareMessage(session, myAccountEmail, recepient, otp);
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String otp) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Reset Password OTP");
            message.setText("Dear User, \n\nYour OTP to reset the password is: " + otp);
            return message;
        } catch (Exception ex) {
            Logger.getLogger(JavaMailUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
