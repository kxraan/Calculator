package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView displayArea;
    private ArrayList<String> numbers = new ArrayList<>();
    private ArrayList<String> values = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayArea = findViewById(R.id.display);

        Button add = findViewById(R.id.add);
        add.setOnClickListener(v-> {
            operationHandler("+");
        });

        Button minus = findViewById(R.id.minus);
        minus.setOnClickListener(v->{
            operationHandler("-");
        });

        Button mult = findViewById(R.id.multiply);
        mult.setOnClickListener(v->{
            operationHandler("*");
        });

        Button divide = findViewById(R.id.divide);
        divide.setOnClickListener(v->{
            operationHandler("/");
        });

        Button one = findViewById(R.id.one);
        one.setOnClickListener(v->{
            numberHandler("1");
        });

        Button two = findViewById(R.id.two);
        two.setOnClickListener(v->{
            numberHandler("2");
        });

        Button three = findViewById(R.id.three);
        three.setOnClickListener(v->{
            numberHandler("3");
        });

        Button four = findViewById(R.id.four);
        four.setOnClickListener(v->{
            numberHandler("4");
        });

        Button five = findViewById(R.id.five);
        five.setOnClickListener(v->{
            numberHandler("5");
        });

        Button six = findViewById(R.id.six);
        six.setOnClickListener(v->{
            numberHandler("6");
        });

        Button seven = findViewById(R.id.seven);
        seven.setOnClickListener(v->{
            numberHandler("7");
        });

        Button eight = findViewById(R.id.eight);
        eight.setOnClickListener(v->{
            numberHandler("8");
        });

        Button nine = findViewById(R.id.nine);
        nine.setOnClickListener(v->{
            numberHandler("9");
        });

        Button zero = findViewById(R.id.zero);
        zero.setOnClickListener(v->{
            numberHandler("0");
        });

        Button equal = findViewById(R.id.equal);
        equal.setOnClickListener(v->{
            operationHandler("=");

            Calculations calculate = new Calculations(values);
            String answer = calculate.compute();
            displayArea.setText(answer);
            numbers.clear();
            numbers.add(answer);
            values.clear();
        });

        Button ac = findViewById(R.id.ac);
        ac.setOnClickListener(v->{
            numbers.clear();
            values.clear();
            displayArea.setText("");
        });

        Button decimal = findViewById(R.id.decimal);
        decimal.setOnClickListener(v->{
            numberHandler(".");
        });
    }
    public void numberHandler(String number) {

        numbers.add(number);
        displayArea.setText(toString(values) + toString(numbers));
    }

    /*
     * Since the numbers arraylist stored every digit at a new index, it becomes
     * necessary to combine numbers greater than 2 digit, this method does that and
     * stored the combined number in a new arraylist along with the operations
     */

    public void operationHandler(String operation) {
        if (numbers.size() > 0) {
            values.add(toString(numbers));
        }
        numbers.clear();
        values.add(operation);
        displayArea.setText(toString(values));
    }

    public String toString(ArrayList<String> temp) {
        String answer = "";
        for (String element : temp) {
            answer += element;
        }
        return answer;
    }
}