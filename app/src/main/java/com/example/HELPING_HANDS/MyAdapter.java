package com.example.HELPING_HANDS;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyView> {
    Context context;
    ArrayList<User> list;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_item,parent, false);
        return new MyView(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        User user = list.get(position);
        holder.name.setText(user.getName());
        holder.pnumber.setText(user.getPnum());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyView extends RecyclerView.ViewHolder{
        TextView name, pnumber;


        public MyView(View item){
            super(item);
            int i=0;
            while(i != 0){
                name = item.findViewById(R.id.vname);
                pnumber = item.findViewById(R.id.vPnum);
            i++;
        }}
    }


}

