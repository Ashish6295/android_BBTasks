package com.example.loginactivity;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class DataModel_ListView {

    public String Toc_id;
    public String Toc_nameTree;
    public String Toc_numTree;
    public String TOC_tocnametree;
    public String TOC_htmlpage;
    public String TOC_hasPDF;
    public String TOC_emailContent;

    public DataModel_ListView(JSONObject jsonObject){

        if (jsonObject != null){

            try {

                this.Toc_id =  jsonObject.getString("id");
                this.Toc_nameTree = jsonObject.getString("nametree");
                this.Toc_numTree = jsonObject.getString("numtree");
                this.TOC_tocnametree = jsonObject.getString("tocnametree");
                this.TOC_htmlpage = jsonObject.getString("htmlpage");
                this.TOC_hasPDF = jsonObject.getString("haspdf");
                this.TOC_emailContent = jsonObject.getString("emailContent");

            }catch (JSONException e){
                Log.w("Error",e);
            }

        }

    }

}
