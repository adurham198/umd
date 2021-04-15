package com.example.umd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.umd.objects.Deletion;
import com.example.umd.objects.Uname;

public class DeletionActivity extends AppCompatActivity {
    private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10;
    Button j_btn_del;
    SQLiteDatabaseHandler dbhelper;
    Intent ma;
    Deletion myModel;
    Uname sharedData = Uname.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletion);
        j_btn_del = (Button) findViewById(R.id.delete_account);
        ma = new Intent(this, MainActivity.class);
        dbhelper = new SQLiteDatabaseHandler(this);
        dbhelper.initializedb();
        DeleteAccount();

    }

    public void DeleteAccount() {
       j_btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbhelper.deleteOne(sharedData.getValue());
                startActivity(ma);
            }
        });
    }

}