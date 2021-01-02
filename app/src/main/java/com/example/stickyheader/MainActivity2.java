package com.example.stickyheader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.stickyheader.Alphabet.AlphabetAdapter;
import com.example.stickyheader.Interface.IONAlpha;

public class MainActivity2 extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView=(RecyclerView)findViewById(R.id.rec2);
        AlphabetAdapter alphabetAdapter=new AlphabetAdapter();
        alphabetAdapter.setIonAlpha(new IONAlpha() {
            @Override
            public void onAlpha(String alphabet, int position) {
                if (position!=-1){
                    Intent intent=new Intent();
                   intent.putExtra("result",alphabet);
                   setResult(Activity.RESULT_OK,intent);
                   finish();
                }
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.setAdapter(alphabetAdapter);
    }
}