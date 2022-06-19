package com.example.myapplication.service;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.widget.TextView;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class InsertInBd extends AsyncTask<String, Void, String[]> {

    @SuppressLint("StaticFieldLeak")
    private final TextView textViewTemp;
    private final TextView textViewHum;
    private final String link = "http://94.26.135.188:1337/";

    public InsertInBd(TextView textViewTemp, TextView textViewHum) {
        this.textViewTemp = textViewTemp;
        this.textViewHum = textViewHum;
    }


    @Override
    protected String[] doInBackground(String... employees) {

        final String[] text = {"", ""};


        try {
            Document doc = Jsoup.connect(link).get();
            Elements tempEl = doc.getElementsByClass("info");
            Elements humEl = doc.getElementsByClass("warning");
            text[0] = tempEl.text();
            text[1] = humEl.text();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return text;
    }

    @Override
    protected void onPostExecute(String[] s) {
        textViewTemp.setText(s[0]);
        textViewHum.setText(s[1]);
    }


}
