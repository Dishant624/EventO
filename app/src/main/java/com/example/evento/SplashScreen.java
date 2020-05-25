package com.example.evento;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.text1)
    TextView text1;
    @BindView(R.id.main_logo)
    LinearLayout mainLogo;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind((Activity) this);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                String str = "scaleX";
                ObjectAnimator oa1 = ObjectAnimator.ofFloat(SplashScreen.this.image, str, new float[]{1.0f, 0.0f});
                final ObjectAnimator oa2 = ObjectAnimator.ofFloat(SplashScreen.this.image, str, new float[]{0.0f, 1.0f});
                oa1.setInterpolator(new DecelerateInterpolator());
                oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                oa1.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        oa2.start();
                    }
                });
                oa1.start();
                oa1.setDuration(1000);
                oa2.setDuration(1000);
            }
        }, 1000);
        this.image.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreen.this, SelectionScreen.class);
                Pair<View, String> p1 = Pair.create(SplashScreen.this.image, "image");
                Pair<View, String> p2 = Pair.create(SplashScreen.this.text1, "text1");
                SplashScreen.this.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(SplashScreen.this, p1, p2).toBundle());
            }
        });
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashScreen.this, SelectionScreen.class);
                Pair<View, String> p1 = Pair.create(SplashScreen.this.image, "image");
                Pair<View, String> p2 = Pair.create(SplashScreen.this.text1, "text1");
                SplashScreen.this.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(SplashScreen.this, p1, p2).toBundle());
                SplashScreen.this.overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
            }
        }, 5000);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        finish();
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
