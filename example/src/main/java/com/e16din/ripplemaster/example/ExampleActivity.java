package com.e16din.ripplemaster.example;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.e16din.ripplemaster.RippleMaster;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        final int color = ContextCompat.getColor(this, R.color.colorAccent);
        RippleMaster.setRippleBackground(this, R.id.vPushMeButton, color);

        RippleMaster.setRippleBackground(this, R.id.vLeftImage, Color.RED, true);
        RippleMaster.setRippleBackground(this, R.id.vCenterImage, Color.GREEN, true);
        RippleMaster.setRippleBackground(this, R.id.vRightImage, Color.BLUE, true);
    }
}
