package com.example.loginactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Display4thPageActivity extends AppCompatActivity {

    DataModel_ListView displayToc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display4th_page);

        Bundle received_dataFromIntent = getIntent().getExtras();

        int position = received_dataFromIntent.getInt("ClickedItemPosition");

        TextView TOC_id = (TextView) findViewById(R.id.pageFour_TextView_Display_Toc_ID);
        TextView TOC_numtree = (TextView) findViewById(R.id.pageFour_TextView_Display_Toc_NumTree);
        TextView TOC_nametree = (TextView) findViewById(R.id.pageFour_TextView_Display_Toc_NameTree);
        TextView TOC_tocnametree = (TextView) findViewById(R.id.pageFour_TextView_Display_Toc_TocNameTree);
        TextView TOC_htmlpage = (TextView) findViewById(R.id.pageFour_TextView_Display_Toc_HtmlPage);
        TextView TOC_hasPDF = (TextView) findViewById(R.id.pageFour_TextView_Display_Toc_hasPDF);
        TextView TOC_emailContent = (TextView) findViewById(R.id.pageFour_TextView_Display_Toc_emailContent);

        try {

            JSONObject toc_obj = new JSONObject(loadJSON());
            JSONArray toc_jsonArray = toc_obj.getJSONArray("data");
            JSONObject toc_objcc = toc_jsonArray.getJSONObject(position);
            displayToc = new DataModel_ListView(toc_objcc);

        }catch (JSONException e){

            e.printStackTrace();

        }

        TOC_id.setText(displayToc.Toc_id);
        TOC_numtree.setText(displayToc.Toc_numTree);
        TOC_nametree.setText(displayToc.Toc_nameTree);
        TOC_tocnametree.setText(displayToc.TOC_tocnametree);
        TOC_htmlpage.setText(displayToc.TOC_htmlpage);
        TOC_hasPDF.setText(displayToc.TOC_hasPDF);
        TOC_emailContent.setText(displayToc.TOC_emailContent);

    }

    public String loadJSON(){

        String json = null;

        try {

            InputStream stream = getAssets().open("TocTree_1.json");
            int size = stream.available();

            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();

            json = new String(buffer, "ISO-8859-1");

        }catch (IOException ex){
            ex.printStackTrace();
            return null;
        }

        return json;
    }

}
