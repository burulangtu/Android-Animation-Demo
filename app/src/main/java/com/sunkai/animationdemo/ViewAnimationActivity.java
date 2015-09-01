package com.sunkai.animationdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ViewAnimationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);

        findViewById(R.id.animation_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewAnimationActivity.this, "点击了测试按钮", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = null;
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton1:
                        animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.translate_animation);
                        break;
                    case R.id.radioButton2:
                        animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.rotate_animation);
                        break;
                    case R.id.radioButton3:
                        animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.scale_animation);
                        break;
                    case R.id.radioButton4:
                        animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.alpha_animation);
                        break;
                }
                findViewById(R.id.animation_view).startAnimation(animation);
            }
        });
    }
}
