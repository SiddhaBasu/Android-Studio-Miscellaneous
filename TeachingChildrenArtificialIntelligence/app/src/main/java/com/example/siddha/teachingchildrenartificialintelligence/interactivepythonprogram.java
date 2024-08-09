package com.example.siddha.teachingchildrenartificialintelligence;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class interactivepythonprogram extends AppCompatActivity implements View.OnClickListener  {

    EditText iterations;//declare edit text variable
    TextView outputone;//declare textview variable
    TextView outputtwo;//declare textview variable
    TextView outputthree;//declare textview variable


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactivepythonprogram);

        Button confirm = (Button) findViewById(R.id.confirm);//find button "confirm" and name it to the button confirm

        confirm.setOnClickListener(this); /*turn the listener for the click of the button on. "This" is needed because
        the onclicklistener is implemented above*/

    }

    @Override
    public void onClick(View v) { //when the button is clicked
        iterations = (EditText) findViewById(R.id.edititerations);
        /* find edit text "edititerations" and name it to the variable iterations */

        int numberofiterations = Integer.parseInt(String.valueOf(iterations.getText()));
        /*State that the number,"numberofiterations", is equal to the text of the variable,iterations, which is from
        the edit text, convert that to a string, and convert that to an integer*/

        if (!(numberofiterations % 10 == 0 && numberofiterations > 9)) {
            /*State that if the remainder of the operation of dividing the number of iterations by 10 is 0 and the number of
        iterations is greater than 9, the output text views will show nothing. There will also be a toast message
        saying "Please input a value that is a power of 10"*/
            outputone.setText("");
            outputtwo.setText("");
            outputthree.setText("");
            Toast.makeText(this, "Please input a value that is a power of 10", Toast.LENGTH_SHORT).show();


        }
        outputone = (TextView) findViewById(R.id.output1);//call "outputone" to the textview output1
        outputtwo = (TextView) findViewById(R.id.output2); //call "outputtwo" to the textview output2
        outputthree = (TextView) findViewById(R.id.output3);//call "outputthree" to the textview output3

        if (numberofiterations == 10) {//if the input for the number of iterations is 10, then display these values
            outputone.setText("0.78049526");
            outputtwo.setText("0.78475742");
            outputthree.setText("0.7869146");
        }
        else if (numberofiterations == 100) {/*if the input for the number of iterations is 100, then
            display these values*/
            outputone.setText("0.99007123");
            outputtwo.setText("0.99007933");
            outputthree.setText("0.99008058");
        }
        else if (numberofiterations == 1000) {/*if the input for the number of iterations is 1000,
            then display these values*/
            outputone.setText("0.99929747");
            outputtwo.setText("0.99929738");
            outputthree.setText("0.99929738");
        }
        else if (numberofiterations == 10000) {/*if the input for the number of iterations is 10000,
            then display these values*/
            outputone.setText("0.99993703");
            outputtwo.setText("0.99993703");
            outputthree.setText("0.99993703");
        }
        else if (numberofiterations == 100000) {/*if the input for the number of iterations is 100000,
            then display these values*/
            outputone.setText("0.99999391");
            outputtwo.setText("0.99999391");
            outputthree.setText("0.99999391");
        }
    }
}
