package com.usmanEjaz.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText goldAmount, silverAmount, moneyAmount, goldPg, silverPg;
    TextView payable, total, goldResult, silverResult, moneyResult;
    Button clearGold, clearSilver, clearMoney, calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goldAmount = findViewById(R.id.goldAmount);
        silverAmount = findViewById(R.id.silverAmount);
        moneyAmount = findViewById(R.id.moneyAmount);
        goldPg = findViewById(R.id.goldPg);
        silverPg = findViewById(R.id.silverPg);
        payable = findViewById(R.id.payable);
        total = findViewById(R.id.total);
        goldResult = findViewById(R.id.goldResult);
        silverResult = findViewById(R.id.silverResult);
        moneyResult = findViewById(R.id.moneyResult);
        clearGold = findViewById(R.id.goldClear);
        clearSilver = findViewById(R.id.silverClear);
        clearMoney = findViewById(R.id.moneyClear);
        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Getting text from Gold values //
                String a = goldAmount.getText().toString();
                int gold = Integer.parseInt(a);
                String gpg = goldPg.getText().toString();
                int goldPg = Integer.parseInt(gpg);

                //Getting text from silver values //
                String b = goldAmount.getText().toString();
                int silver = Integer.parseInt(b);
                String spg = silverPg.getText().toString();
                int silverPg = Integer.parseInt(spg);


                //Getting text from Money values //
                String c = moneyAmount.getText().toString();
                int money = Integer.parseInt(c);


            }
        });

    }
}