package com.sunkai.animationdemo;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.animation.LayoutTransition.CHANGE_APPEARING;

public class LayoutAnimationActivity extends Activity {

    private LinearLayout linearLayout;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);
        linearLayout = (LinearLayout) findViewById(R.id.layout_animation);
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = new TextView(LayoutAnimationActivity.this);
                textView.setBackgroundColor(0xffff0000);
                index++;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
                layoutParams.setMargins(10, 10, 10, 10);
                textView.setLayoutParams(layoutParams);

                textView.setText("Item: " + index);
                if (linearLayout.getChildCount() > 1)
                    linearLayout.addView(textView, 1);
                else
                    linearLayout.addView(textView);

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        linearLayout.removeView(view);
                    }
                });
            }
        });
        LayoutTransition layoutTransition = new LayoutTransition();

        layoutTransition.setAnimator(LayoutTransition.APPEARING, ObjectAnimator.ofFloat(this, "scaleX", 0, 1));
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, ObjectAnimator.ofFloat(this, "scaleX", 1, 0));

        linearLayout.setLayoutTransition(layoutTransition);
    }
}
