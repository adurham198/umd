package com.example.umd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.umd.objects.Player;
import com.example.umd.objects.Uname;

public class Login extends MainActivity{
    MainActivity ma;
    EditText y_txt_uname;
    EditText y_txt_pword;
    Button y_btn_signin;
    Intent HomeScreen;
    Uname sharedData = Uname.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        y_txt_uname = (EditText) findViewById(R.id.Login_username);
        y_txt_pword = (EditText) findViewById(R.id.Login_password);
        y_btn_signin = (Button) findViewById(R.id.sign_in_btn);
        HomeScreen = new Intent(this, HomeScreen.class);
        signIn();
    }

    public void signIn() {

        y_btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player pl = new Player();
                String uniqueuser = y_txt_uname.getText().toString();
                sharedData.setValue(y_txt_uname.getText().toString());
                String password = y_txt_pword.getText().toString();
                boolean dotheyexist;
                dotheyexist= dbhelper.checkifexists(uniqueuser);
                if(dotheyexist==false)
                {
                    Log.d("USER NOT EXIST", "NOPE");
                }
                if(dotheyexist==true) {
                    startActivity(HomeScreen);
                    }
                }
        });
    }
}