package Emailer;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      final String senderemail="qolsystest12@gmail.com";
      final String apppassword="fpxrtkukedehnsyu";
      final String receiveremail="qolsystest12@gmail.com";
      
      Properties prop=new Properties();
      prop.put("mail.smtp.auth", "true");
      prop.put("mail.smtp.host", "smtp.gmail.com");
      prop.put("mail.smtp.starttls.enable","true");
      prop.put("mail.smtp.port", "587");
      
      
      Session session=Session.getInstance(prop,new Authenticator() {
    	  protected PasswordAuthentication getPasswordAuthentication() {
    		  return new PasswordAuthentication(senderemail,apppassword);
    	  }
      });
      session.setDebug(true);
      
      try {
    	  Message message=new MimeMessage(session);
    	  message.setFrom(new InternetAddress(senderemail));
    	  message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(receiveremail));
    	  message.setSubject("Testing email");
    	//  message.setText("hello ! this is testing email");
    	  
    	  //Email body
    	  
    	  MimeBodyPart textpart=new MimeBodyPart();
    	  textpart.setText("hello testing mail");
    	  
    	  //Email Attachment
    	  MimeBodyPart attachpart=new MimeBodyPart();
    	  String filepath=System.getProperty("user.dir")+"/reports/ExtentReport.html";
    	  attachpart.attachFile(new File(filepath));
    	  
    	  //Combine both body and attach part
    	  
    	  MimeMultipart multi=new MimeMultipart();
    	  multi.addBodyPart(textpart);
    	  multi.addBodyPart(attachpart);
    	  message.setContent(multi);
    	  
    	  Transport.send(message);
    	  System.out.println("email sent");
      }
      catch(Exception e){
    	  e.printStackTrace();
      }
	}

}
