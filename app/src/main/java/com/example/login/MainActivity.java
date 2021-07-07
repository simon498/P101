 package com.example.login;

 import android.content.Intent;
 import android.os.Bundle;
 import android.os.Handler;
 import android.view.WindowManager;
 import android.view.animation.Animation;
 import android.view.animation.AnimationUtils;
 import android.widget.ImageView;
 import android.widget.TextView;

 import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //variables

    private static int SPLASH_SCREEN = 5000;

    Animation topAnim, bottomAnim;
    ImageView logo;
    TextView splash_name, splash_slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //call the animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //hooking the image and the texts
        logo = findViewById(R.id.logo);
        splash_name = findViewById(R.id.splash_name);
        splash_slogan = findViewById(R.id.splash_slogan);

        logo.setAnimation(topAnim);
        splash_name.setAnimation(bottomAnim);
        splash_slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}