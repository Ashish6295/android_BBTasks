package com.example.loginactivity;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class newsList_DataModel {

    public String newsList_header;
    public String newsList_date;
    public String newsList_content;

    public newsList_DataModel(JSONObject jsonObject){

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

}
