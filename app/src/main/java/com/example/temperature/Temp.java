package com.example.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Temp extends AppCompatActivity {
    private static DecimalFormat df2 = new DecimalFormat(".##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        Button c = findViewById(R.id.CToF_button);
        Button f = findViewById(R.id.FToC_button);
        final TextView sumTextview = findViewById(R.id.sum_text);
        final EditText numText = findViewById(R.id.numNeed_Text);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String in = numText.getText().toString();

                if(in.isEmpty()){
                alert();
                }
                else{
                    Double input = Double.valueOf(in);
                   sumTextview.setText(calcu_CF(input));
                }
            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String in = numText.getText().toString();
                if(in.isEmpty()){
                    alert();
                }
                else{
                    Double input = Double.valueOf(in);
                    sumTextview.setText(calcu_FC(input));
                }


            }
        });
    }
    public String calcu_CF(Double input){
        return df2.format(input*1.8+32.0);
    }
    public String calcu_FC(Double input){
        return df2.format((input-32.0)/1.8);
    }
    public void alert(){
        Toast t = Toast.makeText(getApplicationContext(),R.string.app_name,Toast.LENGTH_LONG);
        t.show();
    }
}
