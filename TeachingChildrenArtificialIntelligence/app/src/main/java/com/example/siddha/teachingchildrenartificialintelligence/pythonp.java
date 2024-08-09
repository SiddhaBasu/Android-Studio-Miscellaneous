package com.example.siddha.teachingchildrenartificialintelligence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pythonp extends AppCompatActivity {
    private Button btnpythonprogram2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pythonp);

        Button btnpythonprogram2 = (Button) findViewById(R.id.btnpythonprogram2);
        /* names btnpythonprogram2 to the button btnpythonprogram2 */

        btnpythonprogram2.setOnClickListener(new View.OnClickListener() {
            //this listens for the click of the btnpythoprogram2 button
            @Override
            public void onClick(View v) {
                //when the btnpythoprogram2 button is clicked, call the method,"openActivitypythonprogram2"
                openActivitypythonprogram2();
            }
        });
    }
    public void openActivitypythonprogram2() {//defines method that was called above
        Intent intent = new Intent(this, pythonprogram2.class);
        startActivity(intent);//starts up the new activity, pythonprogram2
    }
}
