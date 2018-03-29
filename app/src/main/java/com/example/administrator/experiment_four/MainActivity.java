package com.example.administrator.experiment_four;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
          protected Button btn1,btn2;
          protected TextView txt1;
          private static final String ONE_NAME="第一个名字";
          protected  String value="我传给第二个界面的值";
          private static final String  GET_VALUE_NAME="返回的第一个名字";
          protected  Button btn3,btn4,btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       txt1=  findViewById(R.id.txt_one_);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn_tiaozhuan);
        btn3=findViewById(R.id.btn_menu);
        btn4=findViewById(R.id.simpadapter_tiaozhuan);
        btn5=findViewById(R.id.actionmode_menu);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent=new Intent(MainActivity.this,Main_Actionmode_listview_Activity.class);
                 startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent=new Intent(MainActivity.this,Main_List_View_Activity.class)
                         ;
                 startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   Intent intent=new Intent(MainActivity.this, Menu_Demo.class);
                   startActivity(intent);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Intent_tiaozhuan();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.btn1:AlertDialog_one();break;
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         if(requestCode!=1)
         {
             return;
         }
         if(resultCode==2)
         {  if(data==null)
              return;
         }
        String value=data.getStringExtra(GET_VALUE_NAME);
         txt1.setText(value);
    }

    private void Intent_tiaozhuan() {
        Intent intent =new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra(ONE_NAME,value);
        startActivityForResult(intent,1);

    }

    private void AlertDialog_two() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("温馨提示"
        );
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "w ", Toast.LENGTH_SHORT).show();
            }
        });
          builder.setPositiveButton("wanc", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                  Toast.makeText(MainActivity.this, "w ", Toast.LENGTH_SHORT).show();
              }
          });

          builder.show();
    }

    private void AlertDialog_one() {
        View v=LayoutInflater.from(MainActivity.this).inflate(R.layout.manage_layout,null);
      Button btn2=v.findViewById(R.id.btn2);
      Button btn3=v.findViewById(R.id.btn3);
      final Dialog dialog=new Dialog(MainActivity.this);

      btn2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              dialog.dismiss();
              Toast.makeText(MainActivity.this,"关闭",Toast.LENGTH_SHORT).show();

          }
      });
      btn3.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              dialog.dismiss();
              Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
          }
      });


        dialog.show();
        dialog.setContentView(v);


    }
}
