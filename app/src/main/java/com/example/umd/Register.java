package com.example.umd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.umd.objects.Player;

public class Register extends Activity {
    MainActivity ma;
    EditText x_txt_uname;
    EditText x_txt_mobile;
    EditText x_txt_pword;
    EditText x_txt_gender;
    EditText x_txt_weight;
    EditText x_txt_height;
    EditText x_txt_freq;
    Button  x_btn_back;
    Button x_btn_register;
    Intent x_view_gethome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        x_txt_uname = (EditText) findViewById(R.id.Name);
        x_txt_mobile = (EditText) findViewById(R.id.mobile);
        x_txt_pword = (EditText) findViewById(R.id.password);
        x_txt_gender = (EditText) findViewById(R.id.gender);
        x_txt_weight = (EditText) findViewById(R.id.weight);
        x_txt_height = (EditText) findViewById(R.id.Height);
        x_txt_freq = (EditText) findViewById(R.id.freq);
        x_btn_back = (Button) findViewById(R.id.back);
        x_btn_register = (Button) findViewById(R.id.register_btn);
        x_view_gethome = new Intent(Register.this, MainActivity.class);
        ma = new MainActivity();
        goback();
        registerfunc();
    }
    public void registerfunc()
    {

        x_btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addplayer();
            }
        });
    }

    public void addplayer()
    {
        ma.dbhelper = new SQLiteDatabaseHandler(this);

        boolean ifempty = false;

        Player player = new Player();

        String uname = x_txt_uname.getText().toString();
        String mobile = x_txt_mobile.getText().toString();
        String gender = x_txt_gender.getText().toString();
        String weight= x_txt_weight.getText().toString();
        String height = x_txt_height.getText().toString();
        String pword = x_txt_pword.getText().toString();
        String freq = x_txt_freq.getText().toString();

        player.setName(uname);
        player.setMobile(mobile);
        player.setPass(pword);
        player.setGender(gender);
        player.setWeight(Integer.parseInt(weight.trim()));
        player.setHeight(Integer.parseInt(height.trim()));
        player.setFreq(freq);
        ma.dbhelper.addPlayer(player);
    }
    public void goback()
    {
        x_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(x_view_gethome);
            }
        });
    }


}
