package com.example.quickfixtradesfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList <Worker> list;

    public MyAdapter(Context context, ArrayList<Worker> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.worker_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Worker worker = list.get(position);
        holder.fullName.setText(worker.getFullName());
        holder.phoneNumber.setText(worker.getPhoneNumber());
        holder.location.setText(worker.getLocation());
        holder.skill.setText(worker.getSkill());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void searchWorker(ArrayList <Worker> filteredList ) {
        list = filteredList;
        notifyDataSetChanged();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView fullName , phoneNumber, location, skill;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fullName = itemView.findViewById(R.id.tvFullName);
            phoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
            location = itemView.findViewById(R.id.tvLocation);
            skill = itemView.findViewById(R.id.tvSkill);
        }
    }
}
