package com.example.evento.Coordinator;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.evento.R;

import butterknife.ButterKnife;

public class AddEvent extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_event);
        ButterKnife.bind((Activity) this);
    }
}
