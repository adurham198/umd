package com.example.umd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.umd.objects.Player;
import com.example.umd.objects.SharedDate;
import com.example.umd.objects.Uname;

public class Login extends MainActivity{
    MainActivity ma;
    EditText y_txt_uname;
    EditText y_txt_pword;
    TextView y_txt_err;
    Button y_btn_signin;
    Intent HomeScreen;
    Uname sharedData = Uname.getInstance();
    SharedDate sharedDate = SharedDate.getInstance();

    SQLiteDatabaseHandler dbhelper;
    SharedDate d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        y_txt_uname = (EditText) findViewById(R.id.Login_username);
        y_txt_pword = (EditText) findViewById(R.id.Login_password);
        y_btn_signin = (Button) findViewById(R.id.sign_in_btn);
        y_txt_err = (TextView) findViewById(R.id.errormsg);
        HomeScreen = new Intent(this, HomeScreen.class);
        dbhelper = new SQLiteDatabaseHandler(this);
        dbhelper.initializedb();
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
                boolean passwordValid = dbhelper.checkLoginCredentials(uniqueuser, password);
                dotheyexist= dbhelper.checkifexists(uniqueuser);

                if(dotheyexist==false)
                {
                    y_txt_err.setText("Username not found");
                }
                else if (!passwordValid){
                    y_txt_err.setText("Invalid password");

                }

                else if(dotheyexist==true && passwordValid) {
                    startActivity(HomeScreen);
                }

            }
        });
    }
}