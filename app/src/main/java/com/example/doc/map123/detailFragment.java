package com.example.doc.map123;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class detailFragment extends android.support.v4.app.Fragment {
    int[] count = new int[100];

    public DBHelper2 mDbHelper2;

    static int index = -1;

    public detailFragment(){

    }

    public void setSelection(int i){index = i;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //inflate layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        mDbHelper2 = new DBHelper2(getActivity());

        Cursor df = mDbHelper2.getAllUsersByMethod();

        Intent intent = new Intent();

        int select = intent.getIntExtra("title",index);

        df.moveToPosition(select);


        TextView tv1 = (TextView)view.findViewById(R.id.Text1);
        tv1.setText(df.getString(1));

        TextView tv2 = (TextView)view.findViewById(R.id.Text2);
        tv2.setText(df.getString(2));

        ImageView img = (ImageView)view.findViewById(R.id.image1);
        img.setImageURI(Uri.parse(df.getString(3)));

        TextView tv3 = (TextView)view.findViewById(R.id.Text3);
        tv3.setText(df.getString(4));



        return view;
    }

}