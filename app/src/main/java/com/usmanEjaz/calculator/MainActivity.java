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
    TextView payable, total, goldResult, silverResult, moneyResult, payableRing, reset;
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
      //  goldResult = findViewById(R.id.goldResult);
      //  silverResult = findViewById(R.id.silverResult);
      //  moneyResult = findViewById(R.id.moneyResult);
        clearGold = findViewById(R.id.goldClear);
        clearSilver = findViewById(R.id.silverClear);
        clearMoney = findViewById(R.id.moneyClear);
        calculate = findViewById(R.id.calculate);
        payableRing = findViewById(R.id.payableRing);
        reset = findViewById(R.id.reset);

        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Getting text from Gold values //
                String a = goldAmount.getText().toString();
                if(a.equals("")){a="0.0";}
                double gold = Double.parseDouble(a);
                String gpg = goldPg.getText().toString();
                if(gpg.equals("")){gpg = "0.0";}
                double goldPg = Double.parseDouble(gpg);

                //Getting text from silver values //
                String b = goldAmount.getText().toString();
                if(b.equals("")){b = "0.0";}
                double silver = Double.parseDouble(b);
                String spg = silverPg.getText().toString();
                if(spg.equals("")){spg = "0.0";}
                double silverPg = Double.parseDouble(spg);


                //Getting text from Money values //
                String c = moneyAmount.getText().toString();
                if(c.equals("")){c = "0.0";}
                double money = Double.parseDouble(c);

                //Calculating payable amount for gold //
                int goldValue = calculateZakatAmount(gold, goldPg);
                String finalGold = String.valueOf(goldValue);
            //    goldResult.setText("Gold Rs."+finalGold);

                //Calculating payable amount for silver //
                int silverValue = calculateZakatAmount(silver, silverPg);
                String finalSilver = String.valueOf(silverValue);
            //    silverResult.setText("Silver Rs."+finalSilver);

                //Calculating payable amount for money //
                int moneyValue  = (int)(money*2.5)/100;
                String finalMoney = String.valueOf(moneyValue);
            //    moneyResult.setText("Money Rs."+finalMoney);

                //Calculating Total amount to be paid //
                int total_zakat = moneyValue + goldValue + silverValue;
                payable.setText("Zakat Rs."+String.valueOf(total_zakat));
                payableRing.setVisibility(View.VISIBLE);

                //Calculating Total amount user has //
                int user_total = (int)(money + (gold*goldPg) + (silver*silverPg));
                total.setText("Rs."+String.valueOf(user_total));

                reset.setText("Result Generated");
            }
        });

        clearGold.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                goldAmount.setText("0");
                goldPg.setText("0");
            //    goldResult.setText("Gold Rs.0");
                payableRing.setVisibility(View.GONE);
                payable.setText("Zakat Rs.-");
                total.setText("Rs.-");
                reset.setText("Calculate Zakat Value");
            }
        });


        clearSilver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                silverAmount.setText("0");
                silverPg.setText("0");
            //    silverResult.setText("Silver Rs.0");
                payableRing.setVisibility(View.GONE);
                payable.setText("Zakat Rs.-");
                total.setText("Rs.-");

                reset.setText("Calculate Zakat Value");
            }
        });

        clearMoney.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                moneyAmount.setText("0");
            //    moneyResult.setText("Money Rs.0");
                payableRing.setVisibility(View.GONE);
                payable.setText("Zakat Rs.-");
                total.setText("Rs.-");
                reset.setText("Calculate Zakat Value");
            }
        });



    }

    public int calculateZakatAmount(double amount, double perGms){
        int zakatAmount = (int)(amount*perGms*2.5)/100;
        return zakatAmount;
    }
}