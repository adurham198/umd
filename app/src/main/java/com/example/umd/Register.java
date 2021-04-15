package com.example.umd;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.umd.objects.Player;

public class Register extends Activity {
    MainActivity ma;
    EditText x_txt_uname;
    EditText x_txt_age;
    EditText x_txt_pword;
    EditText x_txt_gender;
    EditText x_txt_weight;
    EditText x_txt_height;
    Spinner x_spin_freq;
    Button  x_btn_back;
    Button x_btn_register;
    Intent x_view_gethome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        String[] frequencyChoices = new String[] {
                "0", "1", "2", "3", "4", "5", "6", "7"
        };

        x_spin_freq = (Spinner) findViewById(R.id.FrequencyChoices);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, frequencyChoices);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        x_spin_freq.setAdapter(adapter);

        x_txt_uname = (EditText) findViewById(R.id.Name);
        x_txt_age = (EditText) findViewById(R.id.age);
        x_txt_pword = (EditText) findViewById(R.id.password);
        x_txt_gender = (EditText) findViewById(R.id.gender);
        x_txt_weight = (EditText) findViewById(R.id.weight);
        x_txt_height = (EditText) findViewById(R.id.Height);
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

    @SuppressLint("ResourceAsColor")
    public void addplayer()
    {
        ma.dbhelper = new SQLiteDatabaseHandler(this);

        boolean ifempty = false;

        Player player = new Player();

        String uname = x_txt_uname.getText().toString();
        String age = x_txt_age.getText().toString();
        String gender = x_txt_gender.getText().toString();
        String weight= x_txt_weight.getText().toString();
        String height = x_txt_height.getText().toString();
        String pword = x_txt_pword.getText().toString();
        String freq = x_spin_freq.getSelectedItem().toString();

        player.setName(uname);
        player.setAge(Integer.parseInt(age.trim()));
        player.setPass(pword);
        player.setGender(gender);
        player.setWeight(Integer.parseInt(weight.trim()));
        player.setHeight(Integer.parseInt(height.trim()));
        player.setFreq(freq);
        ifempty = ma.dbhelper.checkifexists(uname);
        if(ifempty){
            x_txt_uname.setText("Sorry, that username is taken");
            x_txt_uname.setHighlightColor(android.R.color.holo_red_light);

        }
       else{
            ma.dbhelper.addPlayer(player);
        }
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
