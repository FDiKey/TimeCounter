package com.examplex.kirill.myapplication.adapters;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.examplex.kirill.myapplication.R;
import com.examplex.kirill.myapplication.TaskElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvHolder> {
    private ArrayList<TaskElement> taskList = new ArrayList<>();

    public void setItems(Collection<TaskElement> tasks){
        taskList.addAll(tasks);
        notifyDataSetChanged();
    }

    public void clearItems()
    {
        taskList.clear();
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RvAdapter.RvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new RvHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvHolder holder, int position) {
        holder.bind(taskList.get(position));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
    class RvHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView timmerValue;
        private ImageButton imgStop;
        private RelativeLayout rl;




        public RvHolder(@NonNull View item) {
            super(item);

            name = item.findViewById(R.id.taskName);
            timmerValue = item.findViewById(R.id.timerValue);
            imgStop = item.findViewById(R.id.imgStop);
            rl = item.findViewById(R.id.rel);


        }




        public void bind(final TaskElement taskElement)
        {
            name.setText(taskElement.getName());
            timmerValue.setText(taskElement.getTimerValue());
            taskElement.setView(timmerValue);
            taskElement.StartTimmer();
            rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                            taskElement.setRunning();
                    }
                });
            imgStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskElement.setMiliseconds(0);
                    taskElement.setRunning(false);
                    timmerValue.setText("0:00:00");
                    name.setText("text 123");
                }
                });

            }
        }
}


