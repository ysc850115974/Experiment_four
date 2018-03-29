package com.example.administrator.experiment_four;

import android.content.ClipData;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Menu_Demo extends AppCompatActivity {
          protected TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__demo);
        txt=findViewById(R.id.txt_test);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();//通过getMenuInflater()方法得到MenuInflater对象
        inflater.inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
           switch(item.getItemId())
           {
               case R.id.item_one_small:  txt.setTextSize(TypedValue.COMPLEX_UNIT_DIP,  10);break;
               case R.id.item_one_medium : txt.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);break;
               case R.id.item_one_big : txt.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);break;
               case R.id.item_two:
                   Toast.makeText(Menu_Demo.this,"这是普通菜单栏",Toast.LENGTH_SHORT).show();break;
               case R.id.item_three_black: txt.setTextColor(Color.BLACK);break;
               case R.id.item_three_red: txt.setTextColor(Color.RED);break;
           }
         return super.onOptionsItemSelected(item);
    }
}
