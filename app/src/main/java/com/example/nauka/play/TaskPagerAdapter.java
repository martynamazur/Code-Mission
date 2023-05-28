package com.example.nauka.play;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;



public class TaskPagerAdapter extends FragmentStateAdapter {
    private static Lifecycle lifecycle;
    private List<TaskModel> taskList;
    //private Lifecycle lifecycle = new LifecycleRegistry(this);


    public TaskPagerAdapter(FragmentManager fragmentManager, List<TaskModel> tasks,  Lifecycle lifecycle,String category) {
        super(fragmentManager, getLifecycle());
        this.taskList = tasks;
        this.lifecycle = lifecycle;
    }



    private static Lifecycle getLifecycle() {

        return lifecycle;
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        TaskModel task = taskList.get(position);

        // W zależności od typu zadania, zwróć odpowiedni fragment
        switch (task.getTaskTitle()) {
            case "abcd_question":
                return Exercise1Fragment.newInstance(task);
            // Dodaj kolejne typy zadań i odpowiadające im fragmenty
            default:
                return null;
        }
    }
}

