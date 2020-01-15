package com.examplex.kirill.myapplication;



import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import com.examplex.kirill.myapplication.adapters.RvAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {
    private TextView timmerValue;
    private ImageButton imgPlay;
    private boolean running;
    private int miliseconds;
    private RecyclerView rv;
    private List<TaskElement> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTasks();
        initRecyclerView();

        timmerValue = findViewById(R.id.timerValue);



    }

    private void initTasks() {
           list.add(new TaskElement("MainActivity"));
        list.add(new TaskElement("ItemView"));
        list.add(new TaskElement("Adapter"));
    }

    private void initRecyclerView() {
        rv = findViewById(R.id.recView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RvAdapter adapter = new RvAdapter();
        rv.setAdapter(adapter);
        adapter.setItems(list);

    }

    //Timmer Start
    public void Start(View view) {
        running = !running;
    }
    public void StopClick(View view) {
        running = false;
        miliseconds = 0;
        timmerValue.setText("0:00:00");
    }

}
    // Timer End





