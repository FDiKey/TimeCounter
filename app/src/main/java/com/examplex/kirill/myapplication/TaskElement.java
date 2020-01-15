package com.examplex.kirill.myapplication;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TaskElement implements Runnable {
    private String name;
    private String timerValue;
    private boolean running;
    private int miliseconds;
    private Handler handler;
    public TaskElement(String name )
    {
        this.name = name;
        this.timerValue = "0:00:00";
        this.running = false;
        this.miliseconds = 0;
        this.handler = new Handler();
        handler.post(this);
        handler.postDelayed(this, 1000);
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


    @Override
    public void run() {
        int hours = this.getMiliseconds() / 3600;//000;
        int minutes = (this.getMiliseconds() / 3600) % 60;
        int sec = this.getMiliseconds() % 60;

        String time = String.format("%d:%02d:%02d", hours, minutes, sec);
        if (running) {
            this.timerValue = time;
        }
        if (this.running) {
            //miliseconds+=100;
            this.miliseconds++;

        }
    }
}
