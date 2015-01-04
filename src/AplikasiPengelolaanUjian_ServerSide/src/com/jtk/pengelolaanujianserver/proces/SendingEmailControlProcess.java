/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.proces;

import com.jtk.pengelolaanujianserver.model.SendEmailModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class SendingEmailControlProcess {

    private static Properties mailServerProperties;
    private static Session getMailSession;
    private static MimeMessage message;

//    public static void main(String[] args) {
//        try {
//            SendingEmailControlProcess controlProcess = new SendingEmailControlProcess();
//            List<String> reciever = new ArrayList<>();
//            reciever.add("zulkhair.abdullah.tifd13@polban.ac.id");
//            reciever.add("pahlevi.ridwan.tifd13@polban.ac.id");
//            reciever.add("muhammad.rizki.tifd13@polban.ac.id");
//            reciever.add("muhammad.haska.tifd13@polban.ac.id");
//
//            List<String> cc = new ArrayList<>();
//            cc.add("rangga.rahardian.tidf13@polban.ac.id");
//
//            String subject = "Test Lagi Euy Rame";
//            String email = "<table>\n"
//                    + "	<tr>\n"
//                    + "		<td style=\"width : 50px;\">Nama</td>\n"
//                    + "		<td>:</td>\n"
//                    + "		<td>Zulkhair Abdullah Daim</td>\n"
//                    + "	</tr>\n"
//                    + "	<tr>\n"
//                    + "		<td>Alamat</td>\n"
//                    + "		<td>:</td>\n"
//                    + "		<td>Jl. Caringin no 126 bandung</td>\n"
//                    + "	</tr>\n"
//                    + "	<tr>\n"
//                    + "		<td colspan=\"3\" >Pake HTML Euy formatna</td>\n"
//                    + "	</tr>\n"
//                    + "</table>";
//
//            SendEmailModel model = new SendEmailModel();
//            model.setReciever(reciever);
//            model.setCc(cc);
//            model.setSubject(subject);
//            model.setMessageBody(email);
//            JFileChooser fileChooser = new JFileChooser();
//            int a = fileChooser.showOpenDialog(null);
//            if (a == JFileChooser.APPROVE_OPTION) {
//                model.setPathAttachmentFile(fileChooser.getSelectedFile().getAbsolutePath());
//            }
//            controlProcess.SendEmail(model);
//        } catch (MessagingException ex) {
//            Logger.getLogger(SendingEmailControlProcess.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    /**
     *
     * @param model
     * @throws AddressException
     * @throws MessagingException
     */
    public void SendEmail(SendEmailModel model) throws AddressException, MessagingException {

        //Setting properties
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        //Get mail session
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        message = new MimeMessage(getMailSession);

        createMultipart(model);
        System.out.println("Mail Session has been created successfully..");

        Transport transport = getMailSession.getTransport("smtp");

        //Setting email pengirim
        transport.connect("smtp.gmail.com", "matkul.proyek.sender@gmail.com", "proyek3kelompok2");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        System.out.println("Mail has been sent succesfully..");
    }

    private void createMultipart(SendEmailModel model) throws MessagingException {
        // Set From: header field of the header.
        message.setFrom(new InternetAddress("matkul.proyek.sender@gmail.com"));

        // Set To: header field of the header.
        message.addRecipients(Message.RecipientType.TO, model.getReceiverAddresses());

        // Set CC: header field of the header.
        message.addRecipients(Message.RecipientType.CC, model.getCcAddresses());
        
        // Set BCC: header field of the header.
        message.addRecipients(Message.RecipientType.BCC, model.getBccAddresses());

        // Set Subject: header field
        message.setSubject(model.getSubject());

        // Create the message part 
        BodyPart messageBodyPart = new MimeBodyPart();

        // Fill the message
        messageBodyPart.setContent(model.getMessageBody(), "text/html");

        // Create a multipar message
        Multipart multipart = new MimeMultipart();

        // Set text message part
        multipart.addBodyPart(messageBodyPart);

        // Part two is attachment
        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(model.getPathAttachmentFile());
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(source.getName());
        multipart.addBodyPart(messageBodyPart);

        // Send the complete message parts
        message.setContent(multipart);
    }
}
