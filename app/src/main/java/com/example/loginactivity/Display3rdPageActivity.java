package com.example.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Display3rdPageActivity extends AppCompatActivity {

    List<DataModel_ListView> TocContents;
    ListView listView;
    Button NewsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display3rd_page);

        TocContents = new ArrayList<>();
        NewsList = findViewById(R.id.Button_NewsList);

        try {

            JSONObject toc_obj = new JSONObject(loadJSON());

            JSONArray toc_jsonArray = toc_obj.getJSONArray("data");

            for (int i = 0; i < toc_jsonArray.length(); i++){

                JSONObject toc_objc = toc_jsonArray.getJSONObject(i);
                TocContents.add(new DataModel_ListView(toc_objc));

            }

            listView = findViewById(R.id.MyListView);

            MyAdapter_ListView adapter = new MyAdapter_ListView(this, R.layout.custom_list_view, TocContents);
            listView.setAdapter(adapter);

        }catch (JSONException e){

            e.printStackTrace();

        }

        NewsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Display3rdPageActivity.this, MainActivity_news_listView.class);
                startActivity(intent);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //int itemPosition = position;

                Intent intent = new Intent(Display3rdPageActivity.this,Display4thPageActivity.class);
                intent.putExtra("ClickedItemPosition",position);
                startActivity(intent);

            }
        });

    }

    public String loadJSON(){

        String json;

        try {

            InputStream stream = getAssets().open("TocTree_1.json");
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
