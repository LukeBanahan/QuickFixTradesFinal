package com.example.quickfixtradesfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyCustomerAdapter extends RecyclerView.Adapter<MyCustomerAdapter.MyViewHolder> {

    Context context;

    ArrayList <Customer> cList;

    public MyCustomerAdapter(Context context, ArrayList<Customer> cList) {
        this.context = context;
        this.cList = cList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.customer_item,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Customer customer = cList.get(position);
        holder.fullName.setText(customer.getFullName());
        holder.phoneNumber.setText(customer.getPhoneNumber());
        holder.location.setText(customer.getLocation());
        holder.need.setText(customer.getNeed());


    }

    @Override
    public int getItemCount() {
        return cList.size();
    }

    public void filterList(ArrayList<Customer> filteredList) {
       cList = filteredList;
       notifyDataSetChanged();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView fullName , phoneNumber, location, need;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fullName = itemView.findViewById(R.id.tvCFullName);
            phoneNumber = itemView.findViewById(R.id.tvCPhoneNumber);
            location = itemView.findViewById(R.id.tvCLocation);
            need = itemView.findViewById(R.id.tvCSkill);
        }
    }
}
/* //FoxAndroid(14/4/2021 Firebase Data to RecyclerView
 How to Retrieve Firebase Data into Recyclerview
 | Android Studio [video].
 https://www.youtube.com/watch?v=M8sKwoVjqU0 */