package com.examplex.kirill.myapplication.adapters;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.examplex.kirill.myapplication.R;
import com.examplex.kirill.myapplication.TaskElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.zip.Inflater;

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

    public void addItem(TaskElement te)
    {
        taskList.add(te);
        taskList.get(taskList.size() - 1).setTaskId(taskList.size() - 1);

        notifyDataSetChanged();
    }
    public void upateItem(int position, String name)
    {
        taskList.get(position).setName(name);
        notifyItemChanged(position);
    }
    public void deleteItem(int position)
    {
        taskList.remove(position);
        for(int i = 0; i < taskList.size(); i++)
            taskList.get(i).setTaskId(i);

        notifyDataSetChanged();
    }


    class RvHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView timmerValue;
        private ImageButton imgStop;
        private ImageButton popup;
        private RelativeLayout rl;
        private AlertDialog.Builder adEdit;
        private AlertDialog.Builder adDel;
        private LayoutInflater inflater;





        public RvHolder(@NonNull View item) {
            super(item);
            name = item.findViewById(R.id.taskName);
            timmerValue = item.findViewById(R.id.timerValue);
            imgStop = item.findViewById(R.id.imgStop);
            rl = item.findViewById(R.id.rel);
            popup = item.findViewById(R.id.popup);
            adEdit = new AlertDialog.Builder(item.getContext());
            adDel = new AlertDialog.Builder(item.getContext());
            inflater = LayoutInflater.from(item.getContext());
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
                }
                });
            popup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu pop = new PopupMenu(popup.getContext(), v);
                    pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch(item.getItemId())
                            {
                                case R.id.menu_edit:
                                    final View v1 = inflater.inflate(R.layout.add_timmer, null);
                                    final EditText mewTimerName = v1.findViewById(R.id.newTimerName);
                                    adEdit.setTitle("Edit Task name?");
                                    adEdit.setView(v1);
                                    adEdit.setPositiveButton("Save", new DialogInterface.OnClickListener(){
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            upateItem(taskElement.getTaskId(), mewTimerName.getText().toString());
                                        }}
                                    ).setNegativeButton("Cancel", null).create();
                                    adEdit.show();

                                    break;
                                case R.id.menu_del:
                                    adDel.setTitle("Delete Timer?");
                                    adDel.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            deleteItem(taskElement.getTaskId());
                                        }}
                                    ).setNegativeButton("Cancel", null).create();
                                    adDel.show();
                                    break;
                            }
                            return false;
                        }
                    });
                    pop.inflate(R.menu.context_menu_item);
                    pop.show();
                }
            });


            }
        }



}


