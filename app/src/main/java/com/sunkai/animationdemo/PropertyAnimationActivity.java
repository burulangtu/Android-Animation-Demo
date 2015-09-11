package com.sunkai.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.RadioGroup;

public class PropertyAnimationActivity extends Activity {
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton1:
                        valueAnimatorTest();
                        break;
                    case R.id.radioButton2:
                        objectAnimatorTestByXML();
                        break;
                    case R.id.radioButton3:
                        objectAnimatorTest();
                        break;

                }

            }
        });

    }

    private void objectAnimatorTest() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(findViewById(R.id.animation_view), "scaleX", 1.0f, 2.0f);
        animation.setDuration(1000);
        animation.start();
    }


    private void valueAnimatorTest() {
        i = 0;
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(1000);
        valueAnimator.setObjectValues(new PointF());
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator() {
            @Override
            public PointF evaluate(float v, Object o, Object t1) {
                i++;
                Log.d("TEST", " " + v + ",i: " + i);
                PointF pointF = new PointF();
                pointF.x = 200 * v + 100;
                pointF.y = 0.5f * 200 * v * v + 100;
                return pointF;
            }
        });
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                findViewById(R.id.animation_view).setX(pointF.x);
                findViewById(R.id.animation_view).setY(pointF.y);
            }
        });
    }

    private void objectAnimatorTestByXML() {
        Animator animation = AnimatorInflater.loadAnimator(PropertyAnimationActivity.this, R.animator.object_animation);
        animation.setTarget(findViewById(R.id.animation_view));
        animation.start();
    }

}
