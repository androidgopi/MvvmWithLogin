package com.sreeyainfotech.mvvmwithlogin;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.sreeyainfotech.mvvmwithlogin.model.LoginModel;
import com.sreeyainfotech.mvvmwithlogin.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    LoginViewModel loginViewModel;
    LoginModel loginModel = new LoginModel();
    String firstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewes();
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    private void findViewes() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    public void LoginClick(View view) {
        //  firstName = loginViewModel.getLoginModelLiveValueData(username.getText().toString(), password.getText().toString()).getValue().getFullName().toString();
        Utilities.showLoading(LoginActivity.this, "Loading");
        loginViewModel.getLoginModelLiveValueData(username.getText().toString(), password.getText().toString()).observe(this, new Observer<LoginModel>() {
            @Override
            public void onChanged(LoginModel loginModel) {
                Utilities.hideLoading();
                try {
                    if (loginModel != null) {
                        if (loginModel.getEmailAddress() != null) {
                            Toast.makeText(getApplicationContext(), loginModel.getEmailAddress().toString(), Toast.LENGTH_SHORT).show();
                            Utilities.savePref(LoginActivity.this,"driverId",loginModel.getDriverId());
                            Utilities.savePref(LoginActivity.this,"token",loginModel.getToken());

                        } else {
                            Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
                    }
                }catch (NullPointerException e){

                }
            }
        });

    }
}
