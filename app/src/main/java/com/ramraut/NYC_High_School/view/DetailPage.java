package com.ramraut.NYC_High_School.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ramraut.NYC_High_School.R;
import com.ramraut.NYC_High_School.model.School_Detail;
import com.ramraut.NYC_High_School.viewmodel.DetailViewModel;

import java.util.ArrayList;
import java.util.List;

public class DetailPage extends AppCompatActivity {

    private TextView mathId, readId, writeId, detailName;
    private LinearLayoutManager layoutManager;
    private ArrayList<School_Detail> detailArrayList = new ArrayList<>();
    DetailViewModel detailViewModel;
    private School_Detail school_detail;
    String name = "";
    int position = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String dbn =getIntent().getStringExtra("school_dbn");//"01M292";//savedInstanceState.getI.("school_dbn");//
        setContentView(R.layout.activity_detail_page);

        mathId = findViewById(R.id.mathId);
        readId = findViewById(R.id.readId);
        writeId = findViewById(R.id.writeId);
        detailName = findViewById(R.id.schoolDetailId);

        //receiving school name from other activity
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        detailName.setText(name);



        init();
        getDetails(dbn);
    }


    private void init(){
        layoutManager = new LinearLayoutManager(DetailPage.this);
        detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);

    }

    private void getDetails(String dbn) {
        detailViewModel.getDetailResponseLiveData(dbn).observe(this, fetchResponse -> {
            if(fetchResponse != null){

                List<School_Detail> detailList = fetchResponse;
                detailArrayList.addAll(detailList);
                School_Detail sd = detailArrayList.get(0);
                Log.d("What is dbn Here: ",  dbn);

                readId.setText(sd.getSat_critical_reading_avg_score());
                mathId.setText(sd.getSat_math_avg_score());
                writeId.setText(sd.getSat_writing_avg_score());



            }
        });
    }


}