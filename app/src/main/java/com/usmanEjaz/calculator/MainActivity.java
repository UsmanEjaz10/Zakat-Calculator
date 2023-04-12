package com.usmanEjaz.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText goldAmount, silverAmount, moneyAmount, goldPg, silverPg;
    TextView payable, total, goldResult, silverResult, moneyResult, payableRing;
    Button clearGold, clearSilver, clearMoney, calculate;

    @SuppressLint("MissingInflatedId")
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
        payableRing = findViewById(R.id.payableRing);

        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Getting text from Gold values //
                String a = goldAmount.getText().toString();
                double gold = Double.parseDouble(a);
                String gpg = goldPg.getText().toString();
                double goldPg = Double.parseDouble(gpg);

                //Getting text from silver values //
                String b = goldAmount.getText().toString();
                double silver = Double.parseDouble(b);
                String spg = silverPg.getText().toString();
                double silverPg = Double.parseDouble(spg);


                //Getting text from Money values //
                String c = moneyAmount.getText().toString();
                double money = Double.parseDouble(c);

                //Calculating payable amount for gold //
                int goldValue = calculateZakatAmount(gold, goldPg);
                String finalGold = String.valueOf(goldValue);
                goldResult.setText("Gold Rs."+finalGold);

                //Calculating payable amount for silver //
                int silverValue = calculateZakatAmount(silver, silverPg);
                String finalSilver = String.valueOf(silverValue);
                silverResult.setText("Silver Rs."+finalSilver);

                //Calculating payable amount for money //
                int moneyValue  = (int)(money*2.5)/100;
                String finalMoney = String.valueOf(moneyValue);
                moneyResult.setText("Money Rs."+finalMoney);

                //Calculating Total amount to be paid //
                int total_zakat = moneyValue + goldValue + silverValue;
                payable.setText("Zakat Rs."+String.valueOf(total_zakat));
                payableRing.setVisibility(View.VISIBLE);

                //Calculating Total amount user has //
                int user_total = (int)(money + (gold*goldPg) + (silver*silverPg));
                total.setText("Rs."+String.valueOf(user_total));


            }
        });

        clearGold.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                goldAmount.setText("0");
                goldPg.setText("0");
                goldResult.setText("Gold Rs.0");
                payableRing.setVisibility(View.GONE);
                payable.setText("Zakat Rs.-");
                total.setText("Rs.-");
            }
        });


        clearSilver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                silverAmount.setText("0");
                silverPg.setText("0");
                silverResult.setText("Silver Rs.0");
                payableRing.setVisibility(View.GONE);
                payable.setText("Zakat Rs.-");
                total.setText("Rs.-");
            }
        });

        clearMoney.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                moneyAmount.setText("0");
                moneyResult.setText("Money Rs.0");
                payableRing.setVisibility(View.GONE);
                payable.setText("Zakat Rs.-");
                total.setText("Rs.-");
            }
        });



    }

    public int calculateZakatAmount(double amount, double perGms){
        int zakatAmount = (int)(amount*perGms*2.5)/100;
        return zakatAmount;
    }
}