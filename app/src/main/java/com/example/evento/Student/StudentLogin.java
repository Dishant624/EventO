package com.example.evento.Student;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evento.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentLogin extends AppCompatActivity {


    @BindView(R.id.videos)
    TextView videos;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.sign_up)
    TextView signUp;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_login_student);
        ButterKnife.bind((Activity) this);
        this.login.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                StudentLogin.this.startActivity(new Intent(StudentLogin.this, StudentMain.class));
            }
        });
        this.register.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                StudentLogin.this.startActivity(new Intent(StudentLogin.this, StudentRegister.class));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        hideSystemUI();
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(3846);
    }

    private void showSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(1792);
    }
}
