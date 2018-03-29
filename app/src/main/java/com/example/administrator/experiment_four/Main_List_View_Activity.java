package com.example.administrator.experiment_four;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_List_View_Activity extends AppCompatActivity {
    protected ListView listview;
    protected List<Map<String, Object>> list;
    protected String[] key={"key","picture"};
    protected int [] id={R.id.unit_txt,R.id.unit_image};
    protected String[] value_txt = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    protected int[] value_iamge = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__list__view_);
        listview = findViewById(R.id.list_view);
        list = getData();
        SimpleAdapter adapter=new SimpleAdapter(Main_List_View_Activity.this,list,R.layout.list_view_unit,key,id);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                              view.setBackgroundColor(Color.RED);
                              TextView txt1=view.findViewById(R.id.unit_txt);
                              Toast.makeText(Main_List_View_Activity.this,txt1.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < value_txt.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("key", value_txt[i]);
            map.put("picture", value_iamge[i]);
            list.add(map);
        }
        return list;

    }
}