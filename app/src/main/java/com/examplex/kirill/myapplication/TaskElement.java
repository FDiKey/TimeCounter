package com.examplex.kirill.myapplication;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TaskElement implements Runnable {
    final Handler handler;
    private String name;
    private String timerValue;
    private boolean running;
    private int miliseconds;
    private TextView item;

    public TaskElement(String name )
    {
        this.name = name;
        this.timerValue = "0:00:00";
        this.running = true;
        this.miliseconds = 0;
        this.handler = new Handler();

    }

    public String getName() {
        return this.name;
    }
    public String getTimerValue()
    {
        return  this.timerValue;
    }
    public boolean getRunning()
    {
        return this.getRunning();
    }
    public void setRunning(boolean val)
    {
        this.running = val;
    }
    public void setRunning()
    {
        this.running = !this.running;
    }
    public void setMiliseconds(int val)
    {
        this.miliseconds = val;
    }
    public int getMiliseconds()
    {
        return this.miliseconds;
    }
    public void setView(TextView tv)
    {
        this.item = tv;
    }

    public void StartTimmer()
    {
        this.handler.post(this);
    }

    @Override
    public void run() {
        int hours = this.getMiliseconds() / 3600000;//000;
        int minutes = (this.getMiliseconds() % 3600000) / 60000;
        int sec = (this.getMiliseconds() % 60000)/ 1000;



        String time = String.format("%d:%02d:%02d", hours, minutes, sec);

        if (running) {
            this.item.setText(time);
            this.setMiliseconds(this.getMiliseconds() + 100);
        }
        this.handler.postDelayed(this, 100);
    }
}
