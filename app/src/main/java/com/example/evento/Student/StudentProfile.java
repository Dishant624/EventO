package com.example.evento.Student;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.evento.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentProfile extends AppCompatActivity {


    @BindView(R.id.student)
    ImageView student;
    @BindView(R.id.floating_action_button)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.textView12)
    TextView textView12;
    @BindView(R.id.linearLayout5)
    ConstraintLayout linearLayout5;
    @BindView(R.id.edit_profile)
    Button editProfile;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_student_profile);
        ButterKnife.bind((Activity) this);
        this.editProfile.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                StudentProfile.this.editProfile();
            }
        });
    }

    /* access modifiers changed from: private */
    public void editProfile() {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        View contentView = getLayoutInflater().inflate(R.layout.dialog_student_profile_edit, null);
        dialog.setContentView(contentView);
        ((View) contentView.getParent()).setBackgroundColor(getResources().getColor(R.color.transparent));
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        LayoutParams lp = new LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = -1;
        lp.height = -1;
        lp.gravity = 17;
        dialog.getWindow().setAttributes(lp);
        dialog.show();
    }
}
