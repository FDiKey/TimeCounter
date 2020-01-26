package com.examplex.kirill.myapplication;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.examplex.kirill.myapplication.adapters.RvAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {
    final private Context mContext = this;
    private RvAdapter adapter;
    private AlertDialog.Builder ad;
    private Activity mActivity;
    private FloatingActionButton fab;
    private RecyclerView rv;
    private List<TaskElement> list = new ArrayList<>();
    private PopupWindow popup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVarriables();
        initTasks();
        initRecyclerView();

    }

    private void initVarriables() {
        mActivity = MainActivity.this;
        rv = findViewById(R.id.recView);
        fab = findViewById(R.id.fab);

    }

    private void initTasks() {
           //list.add(new TaskElement("MainActivity"));

    }

    private void initRecyclerView() {

        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RvAdapter();
        rv.setAdapter(adapter);


    }

    public void fabClick(View view) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.add_timmer,null);
        ad = new AlertDialog.Builder(mContext);
        ad.setTitle("Enter name of timer");
        ad.setView(v);
        final EditText addEdit = (EditText) v.findViewById(R.id.newTimerName);
        ad.setPositiveButton("add", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String temp = addEdit.getText().toString();

                adapter.addItem(new TaskElement(temp));
            }
        }).create();
        ad.show();
    }


}
    // Timer End





