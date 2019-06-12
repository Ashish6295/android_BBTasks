package com.example.loginactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter_ListView extends ArrayAdapter<DataModel_ListView> {

    public MyAdapter_ListView(Context context, int resource, List<DataModel_ListView> userList){
        super(context,resource,userList);
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        // Get the data item for this position
        DataModel_ListView tocFileItemList = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);
        }

        // Lookup view for data population
        TextView textView_TocID = convertView.findViewById(R.id.customListView_textView_Toc_id);
        TextView textView_Toc_nameTree = convertView.findViewById(R.id.customListView_textView_Toc_nameTree);
        TextView textView_Toc_numTree = convertView.findViewById(R.id.customListView_textView_Toc_numTree);

        // Populate the data into the template view using the data object
        textView_TocID.setText(tocFileItemList.Toc_id);
        textView_Toc_nameTree.setText(tocFileItemList.Toc_nameTree);
        textView_Toc_numTree.setText(tocFileItemList.Toc_numTree);

        return convertView;

    }

}
