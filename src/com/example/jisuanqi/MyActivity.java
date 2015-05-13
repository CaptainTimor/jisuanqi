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
    boolean clear;
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

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_dian.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_reduce.setOnClickListener(this);
        btn_ride.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        edit_input.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //定义一个String类型的变量来接受edittext的内容
        String str = edit_input.getText().toString();
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
            case R.id.btn_dian:
                if(clear){
                    clear = false;
                    edit_input.setText("");
                }
                //添加数字到输入框
                edit_input.setText(str+((Button)v).getText());
                break;
            case R.id.btn_plus:
            case R.id.btn_reduce:
            case R.id.btn_ride:
            case R.id.btn_divide:
                //添加运算符到输入框
                edit_input.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.btn_c:
                if(clear){
                    clear = false;
                    edit_input.setText("");
                }
                edit_input.setText("");
                break;
            case R.id.btn_del:
                if(clear){
                    clear = false;
                    edit_input.setText("");
                }
                if(str!=null&&!str.equals("")){
                    edit_input.setText(str.substring(0,str.length()-1));
                }
                break;
            case R.id.btn_equal:
                getResult();
                break;
            default:
                break;
        }
    }
    private void getResult() {
        double result = 0;
        String exp = edit_input.getText().toString();
        //
        if (exp == null || exp.equals("")) {
            return;
        }
        //
        if (exp.contains(" ")) {
            return;
        }
        if(clear){
            clear = false;
            return;
        }
        clear = true;
        //取运算符前面的数字
        String s1 = exp.substring(0, exp.indexOf(" "));
        //取运算符
        String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
        //取运算符后面的数字
        String s2 = exp.substring(exp.indexOf(" ") + 3);
        //第一种情况d1和d2都不为空
        if (!s1.equals("") && !s2.equals("")) {
            //强制转化为double类型
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if (op.equals("＋")) {
                result = d1 + d2;
            } else if (op.equals("－")) {
                result = d1 - d2;
            } else if (op.equals("×")) {
                result = d1 * d2;
            } else if (op.equals("÷")) {
                if (d2 == 0) {
                    result = 0;
                } else {
                    result = d1 / d2;
                }
            }
            if (!s1.equals(".") && !s2.equals(".")&&!op.equals("÷")) {
                int r = (int) result;
                edit_input.setText(r + "");
            } else {
                edit_input.setText(result + "");
            }
        } else if (s1.equals("") && !s2.equals("")) {
            double d2 = Double.parseDouble(s2);
            if (op.equals("＋")) {
                result = 0 + d2;
            } else if (op.equals("－")) {
                result = 0 - d2;
            } else if (op.equals("×")) {
                result = 0 * d2;
            } else if (op.equals("÷")) {
                result = 0;
            }
        }else if(!s1.equals("")&&s2.equals("")){
            double d1 = Double.parseDouble(s1);
            if (op.equals("＋")) {
                result = d1 + 0;
            } else if (op.equals("－")) {
                result = d1 - 0;
            } else if (op.equals("×")) {
                result = d1 * 0;
            } else if (op.equals("÷")) {
                edit_input.setText("Error");
            }
        }
    }
}
