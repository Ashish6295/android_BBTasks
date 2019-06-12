package com.example.loginactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity_DetailedNewsView extends AppCompatActivity {

   newsList_DataModel displayNews;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__detailed_news_view);

        Bundle recieved_data_from_intent = getIntent().getExtras();

        String ClickedItemTitle = recieved_data_from_intent.getString("ClickedItemTitle");

        TextView news_header = (TextView) findViewById(R.id.Detailed_news_textView_header);
        TextView news_content = (TextView) findViewById(R.id.Detailed_news_textView_Content);
        TextView backButton = findViewById(R.id.Back_Button_detailNews);

        try {

            JSONObject newsListjson_obj = new JSONObject(loadJSON());
            JSONArray newsList_jsonArray = newsListjson_obj.getJSONArray("All_News");

            for (int i = 0; i < newsList_jsonArray.length(); i++){

                JSONObject newsList_objc = newsList_jsonArray.getJSONObject(i);
                String newsHeader = newsList_objc.getString("header");

                if (newsHeader.equals(ClickedItemTitle)){
                    displayNews = new newsList_DataModel(newsList_objc);
                    break;
                }

            }

        }catch (JSONException e){

            e.printStackTrace();

        }

//        try {
//
//            JSONObject news_obj = new JSONObject(loadJSON());
//            JSONArray news_jsonArray = news_obj.getJSONArray("All_News");
//            JSONObject news_objc = news_jsonArray.getJSONObject(position);
//            displayNews = new newsList_DataModel(news_objc);
//
//        }catch(JSONException e){
//            e.printStackTrace();
//        }

        news_header.setText(displayNews.newsList_header);
        news_content.setText(Html.fromHtml(displayNews.newsList_content));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }

    public String loadJSON(){

        String json;

        try {

            InputStream stream = getAssets().open("news.json");
            int size = stream.available();

            byte[] buffer = new byte[size];
            int no_bytes_read = stream.read(buffer);
            stream.close();

            json = new String(buffer, "ISO-8859-1");

        }catch (IOException ex){
            ex.printStackTrace();
            return null;
        }

        return json;
    }

}
