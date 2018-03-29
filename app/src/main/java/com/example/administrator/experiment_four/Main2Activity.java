package com.example.administrator.experiment_four;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
             protected Button  btn1;
             protected TextView txt1;
             private static final String ONE_NAME_="第一个名字";
             private static final String RETURN_ONE_NAME="返回的第一个名字";
             String value="我得到了子界面的值";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String get_value=getIntent().getStringExtra(ONE_NAME_);
        init();
        txt1.setText(get_value);
        setListern();

    }



    private void setListern() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra(RETURN_ONE_NAME,value);
                setResult(2,intent);
                Main2Activity.this.finish();
            }
        });
    }

    private void init() {
        btn1=findViewById(R.id.btn_two);
        txt1=findViewById(R.id.txt_two);

    }
}
