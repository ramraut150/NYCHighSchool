package com.ramraut.NYC_High_School.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramraut.NYC_High_School.R;
import com.ramraut.NYC_High_School.model.School;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    private final Context context;
    ArrayList<School> schoolArrayList;
    private itemClicked itemclicked;

    public AdapterClass(Context context, ArrayList<School> articleArrayList, itemClicked itemclicked) {
        this.context = context;
        this.schoolArrayList = articleArrayList;
        this.itemclicked = itemclicked;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_display,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {

        School school = schoolArrayList.get(position);
        holder.name.setText(school.getSchool_name());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemclicked.clickedOnGetSchools(schoolArrayList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return schoolArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameId);

        }
    }

    public interface itemClicked{
        public void clickedOnGetSchools(School school);
    }
}

