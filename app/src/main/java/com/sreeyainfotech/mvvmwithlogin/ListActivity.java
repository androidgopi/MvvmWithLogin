package com.sreeyainfotech.mvvmwithlogin;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sreeyainfotech.mvvmwithlogin.adapter.ListAdapter;
import com.sreeyainfotech.mvvmwithlogin.model.LoadDetails;
import com.sreeyainfotech.mvvmwithlogin.viewmodel.LoadDetailViewModel;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    LoadDetailViewModel loadDetailViewModel;
    RecyclerView recycler_view;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recycler_view=(RecyclerView) findViewById(R.id.recycler_view);
        loadDetailViewModel.getInstance();
        loadDetailViewModel= ViewModelProviders.of(this).get(LoadDetailViewModel.class);
        getLoadDetails();
    }

    private void getLoadDetails() {
       try {
           loadDetailViewModel.getLoadDetailsLiveData(ListActivity.this).observe(this, new Observer<List<LoadDetails>>() {
               @Override
               public void onChanged(@Nullable List<LoadDetails> loadDetails) {
                   prepareData(loadDetails);
               }
           });
       }catch (NullPointerException e){

       }
    }

    private void prepareData(List<LoadDetails> loadDetails) {
        listAdapter = new ListAdapter(loadDetails);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setAdapter(listAdapter);
    }


}
