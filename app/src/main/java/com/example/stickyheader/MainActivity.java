package com.example.stickyheader;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.stickyheader.Alphabet.PersonAdapter;
import com.example.stickyheader.Common.Common;
import com.example.stickyheader.Common.LinearLayoutManagerSmoothScroller;
import com.example.stickyheader.Model.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity { RecyclerView recyclerView;LinearLayoutManager layoutManager;
    ArrayList<Person> people=new ArrayList<>(); @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.rec);layoutManager=new LinearLayoutManagerSmoothScroller(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,layoutManager.getOrientation())); createPersonList();
        PersonAdapter adapter=new PersonAdapter(this,people); recyclerView.setAdapter(adapter); }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Common.RESULT_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                String group_Character = data.getStringExtra("result");
                int position=Common.findPosWithName(group_Character,people);
                recyclerView.smoothScrollToPosition(position);
            }
        }
    }

    private void createPersonList() {
        people= Common.getPeopleGroup();
        people=Common.sortList(people);
        people=Common.arrayList(people);

    }
}