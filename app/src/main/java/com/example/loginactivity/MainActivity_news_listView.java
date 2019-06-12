package com.example.loginactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity_news_listView extends AppCompatActivity {

    List<newsList_DataModel> NewsList;
    ListView newslistView;
    newsList_CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_news_list_view);

        NewsList = new ArrayList<>();

        try {

            JSONObject newsListjson_obj = new JSONObject(loadJSON());
            JSONArray newsList_jsonArray = newsListjson_obj.getJSONArray("All_News");

            for (int i = 0; i < newsList_jsonArray.length(); i++){

                JSONObject newsList_objc = newsList_jsonArray.getJSONObject(i);
                NewsList.add(new newsList_DataModel(newsList_objc));

            }

            newslistView = findViewById(R.id.MyNewsListView);

            adapter = new newsList_CustomAdapter(this, R.layout.custom_news_list, NewsList);
            newslistView.setAdapter(adapter);

        }catch (JSONException e){

            e.printStackTrace();

        }

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
