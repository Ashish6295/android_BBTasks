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

    static class ViewHolder{
        TextView textView_readStatus;
        TextView textView_newsHeader;
        TextView textView_newsDate;
        TextView textView_newsContent;
    }

    public newsList_CustomAdapter(Context context, int resource, List<newsList_DataModel> newsItem){
        super(context, resource, newsItem);
        this.NewsListItem = newsItem;
        this.context = context;
    }

    @NonNull
    @Override

    public View getView(final int position, @Nullable  View convertView, @NonNull ViewGroup parent){

        final newsList_DataModel  newsList = getItem(position);
        ViewHolder holder = null;

        //code for ListView without ViewHolder pattern is below removeNewsItem()

        if (convertView == null){

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.custom_news_list,null);

            holder = new ViewHolder();

            holder.textView_newsHeader = convertView.findViewById(R.id.custom_newsList_textView_News_header);
            holder.textView_newsDate = convertView.findViewById(R.id.custom_newsList_textView_News_date);
            holder.textView_newsContent = convertView.findViewById(R.id.custom_newsList_textView_News_preview);
            holder.textView_readStatus = convertView.findViewById(R.id.custom_newsList_textView_read_status);

            convertView.setTag(holder);

        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.textView_newsHeader.setText(newsList.newsList_header);
        holder.textView_newsDate.setText(newsList.newsList_date);
        holder.textView_newsContent.setText(Html.fromHtml(newsList.newsList_content));

        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                removeNewsItem(position);
                return true;
            }
        });

        final ViewHolder finalHolder = holder;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, MainActivity_DetailedNewsView.class );
                intent.putExtra("ClickedItemTitle",newsList.newsList_header);
                context.startActivity(intent);

                finalHolder.textView_readStatus.setBackgroundResource(R.drawable.rounded_textview_read_status_read);

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
                //notifyDataSetChanged();
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

//code for listView without viewHolder
//        if (convertView == null){
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_news_list, parent,false);
//        }
//
//        final TextView textView_newsHeader = convertView.findViewById(R.id.custom_newsList_textView_News_header);
//        TextView textView_newsDate = convertView.findViewById(R.id.custom_newsList_textView_News_date);
//        TextView textView_newsContent = convertView.findViewById(R.id.custom_newsList_textView_News_preview);
////        final TextView textView_readStatus = convertView.findViewById(R.id.custom_newsList_textView_read_status);
//
//        textView_newsHeader.setText(newsList.newsList_header);
//        textView_newsDate.setText(newsList.newsList_date);
//        textView_newsContent.setText(Html.fromHtml(newsList.newsList_content));









