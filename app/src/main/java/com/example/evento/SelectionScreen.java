package com.example.evento;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.evento.Coordinator.CoordinatorLogin;
import com.example.evento.Student.StudentLogin;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectionScreen extends AppCompatActivity {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.videos)
    TextView videos;
    @BindView(R.id.student)
    ImageView student;
    @BindView(R.id.coordinator)
    ImageView coordinator;
    @BindView(R.id.studentSelection)
    ImageView studentSelection;
    @BindView(R.id.coordinatorSelection)
    ImageView coordinatorSelection;
    @BindView(R.id.textView12)
    TextView textView12;
    @BindView(R.id.textView13)
    TextView textView13;
    @BindView(R.id.linearLayout5)
    ConstraintLayout linearLayout5;


    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView((int) R.layout.activity_user_selection);
        ButterKnife.bind((Activity) this);
        this.studentSelection.setVisibility(View.GONE);
        this.coordinatorSelection.setVisibility(View.GONE);
        this.student.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SelectionScreen.this.startActivity(new Intent(SelectionScreen.this, StudentLogin.class));
                SelectionScreen.this.studentSelection.setVisibility(View.VISIBLE);
                SelectionScreen.this.coordinatorSelection.setVisibility(View.GONE);

            }
        });
        this.coordinator.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SelectionScreen.this.startActivity(new Intent(SelectionScreen.this, CoordinatorLogin.class));
                SelectionScreen.this.studentSelection.setVisibility(View.GONE);
                SelectionScreen.this.coordinatorSelection.setVisibility(View.VISIBLE);
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
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
