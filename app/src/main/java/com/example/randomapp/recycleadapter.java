package com.example.randomapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;


public class recycleadapter extends RecyclerView.Adapter<recycleadapter.ViewHolder> {

    private ArrayList<FireBaseRecordModel> mData;
    private LayoutInflater mInflater;
    private  Context mContext;

    // data is passed into the constructor
    public recycleadapter(Context context, ArrayList<FireBaseRecordModel> data) {
        this.mInflater = LayoutInflater.from(context);
        mContext=context;
        this.mData = data;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recordlayout, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position)
    {

        final FireBaseRecordModel obj = mData.get(position);
        holder.equation.setText("Equation : "+obj.getEquation());
        holder.timestamp.setText("TimeStamp  : "+getDate(Long.parseLong(obj.getTimeStamp())));




    }



    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  String getDate(Long l)
    {
        Date d = new Date(l* 1000);
        android.text.format.DateFormat df = new android.text.format.DateFormat();
        return String.valueOf(df.format("MMMM dd,yyyy hh:mm", new Date()));

    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView equation;
        TextView timestamp;

        ViewHolder(View itemView) {
            super(itemView);
            equation=itemView.findViewById(R.id.equation);
            timestamp = itemView.findViewById(R.id.TimeStamp);
        }

    }

}