package com.example.administrator.experiment_four;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_Actionmode_listview_Activity extends AppCompatActivity {
        protected ListView  listview;
        protected SimpleAdapter adapter;
        protected List<Map<String,Object>> list;
        protected String  [] key={"key_image","key_txt"};
        protected int [] id={R.id.image_actionmoed_unit,R.id.txt_actionmode_unit};
        protected int []value_image={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
        protected String [] value_txt={"One","Two","Three","Four","Five"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionmode_listview);
        listview=findViewById(R.id.list_view_actionmode);
        list=getData();
        adapter=new SimpleAdapter(Main_Actionmode_listview_Activity.this,list,R.layout.actionmode_listview_unit,key,id);
        listview.setAdapter(adapter);
        this.registerForContextMenu(listview);//对列表视图进行登记才能长按产生浮动上下文菜单
        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
         listview.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
             @Override
             public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {

             }

             @Override
             public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                      MenuInflater inflater=actionMode.getMenuInflater();//上下文操作模式要绑定上下文菜单通过上下文操作对象得到菜单对象进行绑定
                      inflater.inflate(R.menu.menu_actionmode,menu);
                 return true;
             }

             @Override
             public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                 return false;
             }

             @Override
             public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                  actionMode.finish();
                 return true;
             }

             @Override
             public void onDestroyActionMode(ActionMode actionMode) {

             }
         });


    }

    private List<Map<String,Object>> getData() {
        List<Map<String,Object>> data= new ArrayList<>() ;

        for(int i=0;i<value_image.length;i++)
        {  Map<String,Object> map=new HashMap<>();
            map.put("key_image",value_image[i]);
            map.put("key_txt",value_txt[i]);
            data.add(map);

        }
        return data;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
         getMenuInflater().inflate(R.menu.menu_actionmode,menu);

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position=info.position;
        switch(item.getItemId())
        {
          case  R.id.menu_delete: list.remove(position);
              adapter.notifyDataSetChanged();break;

        }


        return super.onContextItemSelected(item);
    }


}
