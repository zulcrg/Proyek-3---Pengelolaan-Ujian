package com.jtk.pengelolaanujianserver.model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Zulkhair Abdullah D
 */
public class SendEmailModel {

    private List<String> reciever;
    private List<String> cc;
    private List<String> bcc;
    private String subject;
    private String messageBody;
    private String pathAttachmentFile;

    public List<String> getReciever() {
        return reciever;
    }

    public void setReciever(List<String> reciever) {
        this.reciever = reciever;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getPathAttachmentFile() {
        return pathAttachmentFile;
    }

    public void setPathAttachmentFile(String pathAttachmentFile) {
        this.pathAttachmentFile = pathAttachmentFile;
    }

    public Address[] getReceiverAddresses() {
        InternetAddress address[];
        if (reciever != null && !reciever.isEmpty()) {
            address = new InternetAddress[reciever.size()];
            for (int i = 0; i < reciever.size(); i++) {
                try {
                    address[i] = new InternetAddress(reciever.get(i));
                } catch (AddressException ex) {
                    Logger.getLogger(SendEmailModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return address;
        }
        return null;
    }

    public Address[] getCcAddresses() {
        InternetAddress address[];
        if (cc != null && !cc.isEmpty()) {
            address = new InternetAddress[cc.size()];
            for (int i = 0; i < cc.size(); i++) {
                try {
                    address[i] = new InternetAddress(cc.get(i));
                } catch (AddressException ex) {
                    Logger.getLogger(SendEmailModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return address;
        }
        return null;
    }

    public Address[] getBccAddresses() {
        InternetAddress address[];
        if (bcc != null && !bcc.isEmpty()) {
            address = new InternetAddress[bcc.size()];
            for (int i = 0; i < bcc.size(); i++) {
                try {
                    address[i] = new InternetAddress(bcc.get(i));
                } catch (AddressException ex) {
                    Logger.getLogger(SendEmailModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return address;
        }
        return null;
    }

}
