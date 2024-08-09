package com.example.siddha.teachingchildrenartificialintelligence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class pythonprogram2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pythonprogram2);

        Button interexamplebtn = (Button) findViewById(R.id.interexamplebtn);
        /*
        names interexamplebtn to the button interexamplebtn
        */
        interexamplebtn.setOnClickListener(new View.OnClickListener() {
        /*
        this listens for the click of the interexamplebtn button
        */
            @Override
            public void onClick(View v) {
                //when the interexamplebtn button is clicked, call the method,"openinteractivepythonprogram"
                openinteractivepythonprogram();
            }
        });
    }

    public void openinteractivepythonprogram() {//define method that was called above
        Intent intent = new Intent(this, interactivepythonprogram.class);
        startActivity(intent);//open the new activity, interactivepythonprogram
    }

}
