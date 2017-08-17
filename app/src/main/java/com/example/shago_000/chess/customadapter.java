package com.example.shago_000.chess;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shago_000 on 8/28/2015.
 */
public class customadapter extends ArrayAdapter {
    String str[];
    int ig[];
    Context context;
    public customadapter(Context context,String str[],int ig[]) {
        super(context,R.layout.single_row,str);
        this.context=context;
        this.str=str;
        this.ig=ig;
    }
    @Override
    public View getView(int position,View convertVIew,ViewGroup parent){
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row,parent,false);
        ImageView image= (ImageView) row.findViewById(R.id.image);
        TextView tx= (TextView) row.findViewById(R.id.txt);
        image.setImageResource(ig[position]);
        tx.setText(str[position]);
        return row;
    }
}
