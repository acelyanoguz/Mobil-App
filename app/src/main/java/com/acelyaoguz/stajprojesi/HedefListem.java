package com.acelyaoguz.stajprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HedefListem extends AppCompatActivity {

    List<String> hedefListem;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    EditText Edhedef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hedef_listem);

        hedefListem=new ArrayList<>();
        arrayAdapter=new ArrayAdapter<>(this,R.layout.list_view_layout,hedefListem);

        listView=findViewById(R.id.id_listView);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView=(TextView)view;
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context=getApplicationContext();
                Toast.makeText(context,"hedef silindi",Toast.LENGTH_LONG).show();

                hedefListem.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return true;
            }
        });
        Edhedef=findViewById(R.id.Edhedef);
    }
    public void maddeEkle(View view){
       hedefListem.add(Edhedef.getText().toString());
       arrayAdapter.notifyDataSetChanged();
       Edhedef.setText("");
    }
}