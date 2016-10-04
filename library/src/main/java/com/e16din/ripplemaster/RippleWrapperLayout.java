package com.e16din.ripplemaster;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;


public class RippleWrapperLayout extends FrameLayout {

    {
        setClickable(true);
    }

    public RippleWrapperLayout(Context context) {
        super(context);
        //without init
    }

    public RippleWrapperLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public RippleWrapperLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RippleWrapperLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs, defStyleAttr);
    }

    private void init(@Nullable AttributeSet attrs, int defStyleAttr) {
        int rippleColor = ContextCompat.getColor(getContext(), R.color.rippleMasterDefaultColor);

        if (attrs != null) {
            final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.RippleWrapperLayout,
                    defStyleAttr, 0);

            rippleColor = a.getColor(R.styleable.RippleWrapperLayout_color, rippleColor);

            a.recycle();
        }

        RippleMaster.setRippleBackground(this, rippleColor);
    }

    @Override
    public void setForeground(Drawable foreground) {
        super.setForeground(foreground);
    }

    @Override
    public void setBackground(Drawable background) {
        super.setBackground(background);
    }
}
