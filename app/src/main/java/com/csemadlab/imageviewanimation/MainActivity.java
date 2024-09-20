package com.csemadlab.imageviewanimation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button buttonRotate, buttonTranslate, buttonScale;
    ImageView imageView;

    public void resetImage(){
        imageView.setScaleX(1f);
        imageView.setScaleY(1f);
        imageView.setTranslationX(0f);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonRotate = findViewById(R.id.buttonRotate);
        buttonTranslate = findViewById(R.id.buttonTranslate);
        buttonScale = findViewById(R.id.buttonScale);
        imageView = findViewById(R.id.imageView);

        buttonRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetImage();
                ObjectAnimator rotate = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
                rotate.setDuration(1000);
                rotate.start();
            }
        });

        buttonTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetImage();
                ObjectAnimator translate = ObjectAnimator.ofFloat(imageView, "translationX", 0f, 200f);
                translate.setDuration(1000);
                translate.start();
            }
        });

        buttonScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetImage();
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 1.5f);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 1f, 1.5f);
                scaleX.setDuration(1000);
                scaleY.setDuration(1000);
                scaleX.start();
                scaleY.start();
            }
        });
    }
}