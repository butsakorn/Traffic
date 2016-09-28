package com.example.pc.traffic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create ListView
        createListView();

    }//main method

    private void createListView(){

        MyData objMyData = new MyData();
        int[] intIcon = objMyData.icon();
        String[] strTitle = objMyData.title();

        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this,intIcon,strTitle);
        ListView myListView = (ListView) findViewById(R.id.listView);
        myListView.setAdapter(objMyAdapter);

        //x\Activity when ckick listview
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        
    }   //createListView
    private void myIntentToDetail(int intClick){
        Intent objIntent = new Intent(MainActivity.this, ShowDetailActivity.class);
        objIntent.putExtra("click", intClick);
        startActivity(objIntent);
    }

public  void  ClickAboutMe (View view){
        Intent objIntent = new Intent(Intent.ACTION_VIEW);
        objIntent.setData(Uri.parse("http://www.facebook.com"));
        startActivity(objIntent);
}    //click
}
