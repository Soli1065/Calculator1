package com.example.woo.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt_result;
    TextView txt_memory;
    Button btn_num1;
    Button btn_num2;
    Button btn_num3;
    Button btn_num4;
    Button btn_num5;
    Button btn_num6;
    Button btn_num7;
    Button btn_num8;
    Button btn_num9;
    Button btn_num0;
    Button btn_dot;
    Button btn_sign;
    Button btn_equal;
    Button btn_plus;
    Button btn_multiply;
    Button btn_mines;
    Button btn_division;
    Button btn_delete;
    Button btn_clear;
    Button btn_erase;

    boolean mustReset = false;
    float currentValue = 0;
    String operand = "";

    public void appendnumber(int num){
        String oldValue = txt_result.getText().toString();
        String memoryValue = txt_memory.getText().toString();



        if (mustReset){
            oldValue = "0";
            mustReset = false;
        }
        if (oldValue.length() > 10){
            return;
        }
        if (oldValue.equals("0") && num == 0){
            return;
        }
        if (oldValue.equals("0") && num != 0){
            txt_result.setText("" + num);
        }else{
        txt_result.setText("" + oldValue + num);
        }

    }

    public void doOperand(String nextoperand){
        String resultValue = txt_result.getText().toString();
        String memoryValue = txt_memory.getText().toString();
        float resultNumber = Float.parseFloat(resultValue);

        if (operand.equals("")){
            currentValue = resultNumber;
        }
        if (operand.equals("+")) {
            currentValue += resultNumber;
        }
        else if (operand.equals("-")){
            currentValue -= resultNumber;
        }
        else if (operand.equals("*")){
            currentValue *= resultNumber;
        }
        else if (operand.equals("/")){
            currentValue /= resultNumber;
        }
        txt_result.setText("" + currentValue);
        txt_memory.setText("" + memoryValue +resultNumber + nextoperand );
        operand = nextoperand;
        mustReset = true;

    }

    public void deleteNumber (String del){
        String numbers = txt_result.getText().toString();
        String value = numbers.substring(0, numbers.length()-1);
        txt_result.setText("" + value);
    }

    public void equalOperation(String s){
        String finalValue = txt_result.getText().toString();
        int number = Integer.parseInt(finalValue);
        appendnumber(number);
        txt_memory.setText("");
        mustReset = true;

    }

    public void addDot(){
        String oldValue = txt_result.getText().toString();
        if (mustReset){
            oldValue = " ";
            mustReset = false;
        }
        if (oldValue.length() > 10){
            return;
        }
        if (oldValue.contains(".")){
            return;
        }
        txt_result.setText(oldValue + ".");
    }

    public void signOperator(){
        String result = txt_result.getText().toString();
        if (result.contains("-")){
            result =  result.replace("-" , "");
        }
        else { result = "-" + result;
        }

        txt_result.setText(result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_result = (TextView) findViewById(R.id.txt_result);
        txt_memory = (TextView) findViewById(R.id.txt_memory);
        btn_num1 = (Button) findViewById(R.id.btn_num1);
        btn_num2 = (Button) findViewById(R.id.btn_num2);
        btn_num3 = (Button) findViewById(R.id.btn_num3);
        btn_num4 = (Button) findViewById(R.id.btn_num4);
        btn_num5 = (Button) findViewById(R.id.btn_num5);
        btn_num6 = (Button) findViewById(R.id.btn_num6);
        btn_num7 = (Button) findViewById(R.id.btn_num7);
        btn_num8 = (Button) findViewById(R.id.btn_num8);
        btn_num9 = (Button) findViewById(R.id.btn_num9);
        btn_num0 = (Button) findViewById(R.id.btn_num0);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_sign = (Button) findViewById(R.id.btn_sign);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_mines = (Button) findViewById(R.id.btn_mines);
        btn_division = (Button) findViewById(R.id.btn_division);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_erase = (Button) findViewById(R.id.btn_erase);

        btn_num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendnumber(0);
            }
        });
        btn_num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendnumber(1);
            }
        });
        btn_num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendnumber(2);
            }
        });
        btn_num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendnumber(3);
            }
        });
        btn_num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendnumber(4);
            }
        });
        btn_num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendnumber(5);
            }
        });
        btn_num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendnumber(6);
            }
        });
        btn_num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendnumber(7);
            }
        });
        btn_num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendnumber(8);
            }
        });
        btn_num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendnumber(9);
            }
        });

        btn_erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_result.setText("0");
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_result.setText("0");
                txt_memory.setText("");
                currentValue = 0;
                mustReset = false;
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOperand("+");
            }
        });

        btn_mines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOperand("-");
            }
        });

        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOperand("/");
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOperand("*");
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equalOperation("=");
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteNumber("del");
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDot();
            }
        });

        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOperator();
            }
        });

    }
}
