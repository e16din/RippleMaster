package com.e16din.ripplemaster;


import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

public class RippleWrapper {

    public RippleWrapper(@NonNull View view, @NonNull Drawable rippleDrawable) {
        this(view, rippleDrawable, false);
    }

    public RippleWrapper(@NonNull View view, @NonNull Drawable rippleDrawable, boolean foreground) {
        ViewGroup vParent = (ViewGroup) view.getParent();
        vParent.removeView(view);

        RippleWrapperLayout vContainer = new RippleWrapperLayout(view.getContext());
        vContainer.setLayoutParams(view.getLayoutParams());
        if (foreground) {
            vContainer.setForeground(rippleDrawable);
        } else {
            vContainer.setBackground(rippleDrawable);
        }
        vContainer.addView(view);
        vContainer.setOnClickListener(Utils.getOnClickListener(view));
        view.setOnClickListener(null);
        view.setClickable(false);
        vParent.addView(vContainer);
    }
}
