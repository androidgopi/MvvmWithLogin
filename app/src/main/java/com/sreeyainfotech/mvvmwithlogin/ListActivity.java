package com.sreeyainfotech.mvvmwithlogin;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.sreeyainfotech.mvvmwithlogin.model.LoadDetails;
import com.sreeyainfotech.mvvmwithlogin.viewmodel.LoadDetailViewModel;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    LoadDetailViewModel loadDetailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        loadDetailViewModel.getInstance();
        loadDetailViewModel= ViewModelProviders.of(this).get(LoadDetailViewModel.class);
        getLoadDetails();
    }

    private void getLoadDetails() {
       try {
           loadDetailViewModel.getLoadDetailsLiveData(ListActivity.this).observe(this, new Observer<List<LoadDetails>>() {
               @Override
               public void onChanged(@Nullable List<LoadDetails> loadDetails) {
                   Toast.makeText(getApplicationContext(), loadDetails.size(), Toast.LENGTH_SHORT).toString();
               }
           });
       }catch (NullPointerException e){

       }
    }


}
