/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package freelancer.DAO.classes;
import freelancer.entities.Message;
import java.io.File;
import java.net.ConnectException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
/**
 *
 * @author houssem_tmn
 */
public class MessageDAO {
   // private static String PATH_TO_DATA;
     public static boolean envoieMessage (Message m,String to[])/*(String from, String password,String message, String to[]) */{
    
         String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", m.getMailAdmin());
        props.put("mail.smtp. password", m.getPasswordAdmin());
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {

  
            mimeMessage.setFrom(new InternetAddress(m.getMailAdmin()));
            InternetAddress[] toAddress = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }
            for (int i = 0; i < toAddress.length; i++) {
            mimeMessage.addRecipient(javax.mail.Message.RecipientType.TO, toAddress[i]);

            }
            
           if(m.getUrl()!=null){
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                Multipart multipart = new MimeMultipart();
                messageBodyPart = new MimeBodyPart();
                javax.activation.DataSource source = new FileDataSource(m.getUrl());
                mimeMessage.setDataHandler(new DataHandler(source));
                mimeMessage.setFileName(m.getFilename());
               
       }
                mimeMessage.setSubject(m.getObjet());
                mimeMessage.setText(m.getMessage());
           Transport transport =session.getTransport("smtp");
               
                try{
                transport.connect(host, m.getMailAdmin(), m.getPasswordAdmin());
                } catch (MessagingException me) {
               JOptionPane.showMessageDialog(null, "Mot de passe ou Adresse e-mail incorrecte ","Message",JOptionPane.ERROR_MESSAGE);
                 }
                transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients() );
                transport.close();
               return true;
        } catch (MessagingException me) {
            me.printStackTrace();

        }
        return false;
    }
    
}
