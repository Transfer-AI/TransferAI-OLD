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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> dateTemplates = new ArrayList<String>();
        List<String> timeTemplates = new ArrayList<String>();

        //Intent intent = new Intent(this, GmailClient.class);
        //startActivity(intent);

        OutlookClient client = new OutlookClient("baietto.2@buckeyemail.osu.edu", "e0z9-g?#!U@z?H0-");
        client.generateMessages();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Log.i("TEST", "I SLEEP");
        try {
            Thread.sleep((client.count / 3) * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Log.i("TEST", "I AWAKE");

        for(int x = 0; x < client.messages.size(); x++) {
            Linguistics parser = new Linguistics(client.content.get(x));
            Log.i("OUTPUT", "_______________________________________________________________________");
            Log.i("OUTPUT", "From: " + client.from.get(x));
            Log.i("OUTPUT", "To: " + client.to.get(x));
            Log.i("OUTPUT", "CC: " + client.cc.get(x));
            Log.i("OUTPUT", "Send Date: " + client.sentDate.get(x));
            Log.i("OUTPUT", "Subject: " + client.subject.get(x));
            Log.i("OUTPUT", "Content: " + client.content.get(x));

            Log.i("OUTPUT", "\n");
            Log.i("OUTPUT", "\n");

            Log.i("OUTPUT", "Event Date-Time: " + parser.getDate() + parser.getTime());
            Log.i("OUTPUT", "Event Name: " + client.subject.get(x));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
