package com.example.loginactivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class newsList_CustomAdapter extends ArrayAdapter<newsList_DataModel> {

    List<newsList_DataModel> NewsListItem;
    Context context;

    public newsList_CustomAdapter(Context context, int resource, List<newsList_DataModel> newsItem){
        super(context, resource, newsItem);
        this.NewsListItem = newsItem;
        this.context = context;
    }

    @NonNull
    @Override

    public View getView(final int position, @Nullable  View convertView, @NonNull ViewGroup parent){

        final newsList_DataModel  newsList = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_news_list, parent,false);
        }

        final TextView textView_newsHeader = convertView.findViewById(R.id.custom_newsList_textView_News_header);
        TextView textView_newsDate = convertView.findViewById(R.id.custom_newsList_textView_News_date);
        TextView textView_newsContent = convertView.findViewById(R.id.custom_newsList_textView_News_preview);
        final TextView textView_readStatus = convertView.findViewById(R.id.custom_newsList_textView_read_status);

        textView_newsHeader.setText(newsList.getNewsList_header());
        textView_newsDate.setText(newsList.getNewsList_date());
        textView_newsContent.setText(Html.fromHtml(newsList.getNewsList_content()));

        if (newsList.getNewsItemReadStatus()){
            textView_readStatus.setBackgroundResource(R.drawable.rounded_textview_read_status_read);
        }else{
            textView_readStatus.setBackgroundResource(R.drawable.rounded_textview_read_status_unread);
        }

        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                removeNewsItem(position);
                return true;
            }
        });

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, MainActivity_DetailedNewsView.class );
                intent.putExtra("ClickedItemTitle",newsList.getNewsList_header());
                context.startActivity(intent);

                textView_readStatus.setBackgroundResource(R.drawable.rounded_textview_read_status_read);
                newsList.setNewsItemReadStatus(true);
            }
        });

        return convertView;

    }

    private void removeNewsItem(final int position){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(),R.style.MyDialogTheme);
        builder.setTitle("Select Action");

        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                NewsListItem.remove(position);
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}








