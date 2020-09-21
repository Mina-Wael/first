package com.example.fragment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.vh> {
    ArrayList<name> names;
    onitemclicklistener listener;

    public adapter(ArrayList<name> names,onitemclicklistener listener) {
        this.names = names;
        this.listener=listener;
    }

    @NonNull
    @Override
    public vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_name_layout,parent,false);
        return new vh(v);
    }

    @Override
    public void onBindViewHolder(@NonNull vh holder, int position) {
        name name=names.get(position);
        holder.bind(name);

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    class vh extends RecyclerView.ViewHolder {
        TextView tv_name;
        name name;
        public vh(@NonNull View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.custom_tv_name);
            tv_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onitemclicked(name);
                }
            });
        }
        void bind(name name)
        {
            this.name=name;
            tv_name.setText(name.getName());
        }
    }

}
