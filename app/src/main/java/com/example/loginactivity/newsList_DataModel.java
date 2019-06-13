package com.example.loginactivity;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

class newsList_DataModel {

    private String newsList_header;
    private String newsList_date;
    private String newsList_content;

    private boolean newsItemReadStatus = false;

    newsList_DataModel(JSONObject jsonObject){

        if (jsonObject != null){

            try{
                this.newsList_header = jsonObject.getString("header");
                this.newsList_date = jsonObject.getString("date");
                this.newsList_content = jsonObject.getString("content");

            }catch (JSONException e){

                Log.w("Error",e);

            }

        }

    }

    String getNewsList_header() {
        return newsList_header;
    }


    String getNewsList_date() {
        return newsList_date;
    }


    String getNewsList_content() {
        return newsList_content;
    }

    boolean getNewsItemReadStatus() {
        return newsItemReadStatus;
    }

    public void setNewsItemReadStatus(boolean newsItemReadStatus) {
        this.newsItemReadStatus = newsItemReadStatus;
    }
}
