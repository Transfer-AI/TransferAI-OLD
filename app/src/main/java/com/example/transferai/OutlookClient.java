package com.example.transferai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.*;
import java.io.*;

import android.*;
import android.Manifest;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.mail.*;
import javax.mail.internet.*;
import javax.net.*;
import javax.*;


public class OutlookClient {

    public final String protocol = "imap";
    public final String host = "outlook.office365.com";
    public final String port = "993";

    public String username;
    public String password;

    public int count;

    public List<Message> messages;

    public List<String> from;
    public List<String> to;
    public List<String> cc;
    public List<String> sentDate;
    public List<String> subject;
    public List<String> content;

    OutlookClient(String USERNAME, String PASSWORD) {
        //getNewEmails("imap", "outlook.office365.com", "993", "osuad\\baietto.2@buckeyemail.osu.edu", "e0z9-g?#!U@z?H0-");

        //getNewEmails("imaps", "imap.googlemail.com", "993", "thisisnthemailyourelookingfor@gmail.com", "vcrk=ocC^SCwnIehZuh");
        //getNewEmails("imap", "email.osu.edu", "993", "baietto.2@.osu.edu", "e0z9-g?#!U@z?H0-");
        username = USERNAME;
        password = PASSWORD;
    }

    public void generateMessages() {
        //Log.i("START", "START STOPWATCH");
        new Thread(new Runnable() {
            public void run(){
                //Log.i("TEST", "HELLO");
                Properties properties = new Properties();
                properties.setProperty("mail.store.protocol", protocol);
                properties.setProperty(String.format("mail.%s.ssl.enable", protocol), "true");
                properties.setProperty(String.format("mail.%s.host", protocol), host);
                properties.setProperty(String.format("mail.%s.port", protocol), port);

                Session session = Session.getInstance(properties);
                try {
                    Store store = session.getStore(protocol);
                    store.connect(host, "osuad\\" + username, password);

                    Folder inbox = store.getFolder("INBOX");
                    inbox.open(Folder.READ_WRITE);

                    count = inbox.getMessageCount();
                    Log.i("TEST", "COUNT: " + count);

                    messages = new ArrayList<Message>();
                    Message[] messagesArray = inbox.getMessages(1, count);
                    for (int x = 0; x < messagesArray.length; x++) {
                        //Log.i("TEST", "*message " + x + ": " + messagesArray[x].toString());
                        //Log.i("TEST", "*subject " + x + ": " + messagesArray[x].getSubject());
                        Address[] add = messagesArray[x].getFrom();
                        //Log.i("TEST", "*from " + x + ": " + add[0]);
                        messages.add(messagesArray[x]);
                    }

                    generateFromList();
                    generateToList();
                    generateCCList();
                    generateSentDateList();
                    generateSubjectList();
                    generateContentList();

                    //Log.i("START", "STOP STOPWATCH");

                    //testMethod();

                    inbox.close(false);
                    store.close();
                } catch (NoSuchProviderException ex) {
                    ex.printStackTrace();
                } catch (MessagingException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();

    }

    public void generateFromList() {
        from = new ArrayList<String>();
        for(int x = 0; x < messages.size(); x++) {
            //Log.i("TEST", "getFrom " + x);
            try {
                Address[] address = messages.get(x).getFrom();
                from.add(address[0].toString());
                //Log.i("TEST", "*getFrom " + x + ": " + from.get(x));
            } catch(Exception ex) {
                ex.printStackTrace();
                //Log.i("TEST", "*getFrom " + x + ": I COULDNT DO IT");
            }
        }
    }

    public void generateToList() {
        to = new ArrayList<String>();
        for(int x = 0; x < messages.size(); x++) {
            try {
                to.add(parseAddresses(messages.get(x).getRecipients(Message.RecipientType.TO)));
            } catch(Exception ex) {
            }
        }
    }

    public void generateCCList() {
        cc = new ArrayList<String>();
        for(int x = 0; x < messages.size(); x++) {
            try {
                cc.add(parseAddresses(messages.get(x).getRecipients(Message.RecipientType.CC)));
            } catch(Exception ex) {
            }
        }
    }

    public void generateSentDateList() {
        sentDate = new ArrayList<String>();
        for(int x = 0; x < messages.size(); x++) {
            try {
                sentDate.add(messages.get(x).getSentDate().toString());
            } catch(Exception ex) {
            }
        }
    }

    public void generateSubjectList() {
        subject = new ArrayList<String>();
        for(int x = 0; x < messages.size(); x++) {
            try {
                subject.add(messages.get(x).getSubject());
            } catch(Exception ex) {
            }
        }
    }

    public void generateContentList() {
        content = new ArrayList<String>();
        for(int x = 0; x < messages.size(); x++) {
            try {
                content.add(getTextFromMessage(messages.get(x)));
            } catch(Exception ex) {
            }
        }
    }

    private String parseAddresses(Address[] address) {

        String listOfAddress = "";
        if ((address == null) || (address.length < 1))
            return null;
        if (!(address[0] instanceof InternetAddress))
            return null;

        for (int i = 0; i < address.length; i++) {
            InternetAddress internetAddress = (InternetAddress) address[0];
            listOfAddress += internetAddress.getAddress()+",";
        }
        return listOfAddress;
    }

    private String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            //Log.i("TEST", "\t Type: text/plain");
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            //Log.i("TEST", "\t Type: multipart/*");
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    private String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart)  throws MessagingException, IOException {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                //Log.i("TEST", "\t Type: text/plain");
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
                //} else if (bodyPart.isMimeType("text/html")) {
                //Log.i("TEST", "\t Type: text/html");
                //    String html = (String) bodyPart.getContent();
                //    result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                //Log.i("TEST", "\t Type: MimeMultipart");
                result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return result;
    }
}