package com.example.emicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    TextInputEditText u1, u2, u3;
    Button btn;

    TextView txt1, txtan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        u1 = findViewById(R.id.u1);
        u2 = findViewById(R.id.u2);
        u3 = findViewById(R.id.u3);
        btn = findViewById(R.id.btn);
        txt1 = findViewById(R.id.txt1);
        txtan = findViewById(R.id.txtan);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int amt = Integer.parseInt(u1.getText().toString());
                double inr = Double.parseDouble(u2.getText().toString());
                int mon = Integer.parseInt(u3.getText().toString());

                double r = inr / (12 * 100);
                double ans1 = 1;

                for (int i = 0; i <= mon; i++) {

                    ans1 *= (1 + r);
                }

                double ans = amt * r * (ans1 / (ans1 - 1));
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(1);
                u2.setText("EMi = " + df.format(ans));
                Double tmt = ans * mon;
                txtan.setText("total amount : "+df.format(tmt));
                Double iamt = tmt-amt;
                u2.setText("Intrest amount : "+df.format(iamt));

            }
        });

    }




}