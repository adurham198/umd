package com.example.umd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.umd.objects.Deletion;

public class DeletionActivity extends AppCompatActivity {
    private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10;
    SQLiteDatabaseHandler dbhelper;
    Deletion myModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletion);

        //
        editText1 = findViewById(R.id.et_title);
        editText2 = findViewById(R.id.et_desc);
        editText3 = findViewById(R.id.et_actor);
        editText4 = findViewById(R.id.et_precond);
        editText5 = findViewById(R.id.et_postcond);
        editText6 = findViewById(R.id.et_scenario);
        editText7 = findViewById(R.id.et_extension);
        editText8 = findViewById(R.id.et_freq);
        editText9 = findViewById(R.id.et_status);
        editText10 = findViewById(R.id.et_priority);


    }

    public void addData(View view) {
        if (isValid()) {
            dbhelper = new SQLiteDatabaseHandler(this);

            myModel = new Deletion();
            myModel.setTitle(editText1.getText().toString());
            myModel.setDescription(editText2.getText().toString());
            myModel.setPrimary_actor(editText3.getText().toString());
            myModel.setPreconditions(editText4.getText().toString());
            myModel.setPostconditions(editText5.getText().toString());
            myModel.setMain_success_scenario(editText6.getText().toString());
            myModel.setExtensions(editText7.getText().toString());
            myModel.setFrequency_of_use(editText8.getText().toString());
            myModel.setStatus(editText9.getText().toString());
            myModel.setPriority(editText10.getText().toString());

            //dbManager.insert(myModel);
            dbhelper.addDeletion(myModel);
        }
    }

    private boolean isValid() {
        if (editText1.getText().length() == 0) {
            Toast.makeText(this, "Please input title", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editText2.getText().length() == 0) {
            Toast.makeText(this, "Please input description", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editText3.getText().length() == 0) {
            Toast.makeText(this, "Please input primary actor", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editText4.getText().length() == 0) {
            Toast.makeText(this, "Please input preconditions", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editText5.getText().length() == 0) {
            Toast.makeText(this, "Please input postconditions", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editText6.getText().length() == 0) {
            Toast.makeText(this, "Please input main success scenario", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editText7.getText().length() == 0) {
            Toast.makeText(this, "Please input extensions", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editText8.getText().length() == 0) {
            Toast.makeText(this, "Please input frequency of use", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editText9.getText().length() == 0) {
            Toast.makeText(this, "Please input status", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editText10.getText().length() == 0) {
            Toast.makeText(this, "Please input priority", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}