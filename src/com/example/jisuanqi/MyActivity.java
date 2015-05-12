package com.example.jisuanqi;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MyActivity extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_c,btn_equal,btn_dian,btn_ride,btn_divide,btn_del,btn_reduce,btn_plus;
    EditText edit_input;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_dian = (Button) findViewById(R.id.btn_dian);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_reduce = (Button) findViewById(R.id.btn_reduce);
        btn_ride = (Button) findViewById(R.id.btn_ride);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_del = (Button) findViewById(R.id.btn_del);
        edit_input = (EditText)findViewById(R.id.edit_input);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_plus:
            case R.id.btn_reduce:
        }
    }
}
