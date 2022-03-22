package com.ramraut.NYC_High_School.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.ramraut.NYC_High_School.R;
import com.ramraut.NYC_High_School.adapter.AdapterClass;
import com.ramraut.NYC_High_School.model.School;
import com.ramraut.NYC_High_School.viewmodel.FetchViewModel;

import java.util.ArrayList;
import java.util.List;

public class FetchSchoolName extends AppCompatActivity implements AdapterClass.itemClicked {

    private static final String TAG = FetchSchoolName.class.getSimpleName();
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private LinearLayoutManager layoutManager;
    private ArrayList<School> schoolArrayList = new ArrayList<>();
    FetchViewModel fetchViewModel;
    private AdapterClass fetchSchoolAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_shool_name);

        init();
        getSchools();
    }

    private void init(){
        progressBar = findViewById(R.id.progressID);
        recyclerView = findViewById(R.id.recyclerid);
        layoutManager = new LinearLayoutManager(FetchSchoolName.this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        fetchSchoolAdapter = new AdapterClass(FetchSchoolName.this, schoolArrayList, this);
        recyclerView.setAdapter(fetchSchoolAdapter);
        fetchViewModel = ViewModelProviders.of(this).get(FetchViewModel.class);

    }

    private void getSchools() {
        fetchViewModel.getSchoolResponseLiveData().observe(this, fetchResponse -> {
            if(fetchResponse != null){
                progressBar.setVisibility(View.GONE);
                List<School> schoolList = fetchResponse;

                schoolArrayList.addAll(schoolList);
                fetchSchoolAdapter.notifyDataSetChanged();
            }
        });
    }



    @Override
    public void clickedOnGetSchools(School school) {
        //Toast.makeText(this, "You cliked on List ID: "+ school.getSchool_name(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(FetchSchoolName.this, DetailPage.class);
        intent.putExtra("school_dbn",school.getDbn());
        intent.putExtra("name", school.getSchool_name());
        startActivity(intent);
    }
}
