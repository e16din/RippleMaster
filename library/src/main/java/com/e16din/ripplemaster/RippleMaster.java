package com.e16din.ripplemaster;


import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;


public final class RippleMaster {

    public static ColorStateList createSelector(int normalColor, int pressedColor) {
        return new ColorStateList(
                new int[][]
                        {
                                new int[]{android.R.attr.state_pressed},
                                new int[]{android.R.attr.state_focused},
                                new int[]{android.R.attr.state_activated},
                                new int[]{}
                        },
                new int[]
                        {
                                pressedColor,
                                pressedColor,
                                pressedColor,
                                normalColor
                        }
        );
    }


    public static void setRippleBackground(@NonNull Activity activity, @IdRes int[] layoutIds) {
        setRippleBackground(activity, layoutIds, false);
    }

    public static void setRippleBackground(@NonNull Activity activity, @IdRes int[] layoutIds, @ColorInt int color) {
        setRippleBackground(activity, layoutIds, color, false);
    }

    public static void setRippleBackground(@NonNull View[] views) {
        setRippleBackground(views, false);
    }

    public static void setRippleBackground(@NonNull View[] views, @ColorInt int rippleColor) {
        setRippleBackground(views, rippleColor, false);
    }
    //

    public static void setRippleBackground(@NonNull Activity activity, @IdRes int[] layoutIds, boolean oval) {
        for (int id : layoutIds) {
            final View view = activity.findViewById(id);
            setRippleEffect(view, getDefaultColor(view), false, oval);
        }
    }

    public static void setRippleBackground(@NonNull Activity activity, @IdRes int[] layoutIds, @ColorInt int color, boolean oval) {
        for (int id : layoutIds) {
            setRippleEffect(activity.findViewById(id), color, false, oval);
        }
    }

    public static void setRippleBackground(@NonNull View[] views, boolean oval) {
        for (View v : views) {
            setRippleEffect(v, getDefaultColor(v), false, oval);
        }
    }

    public static void setRippleBackground(@NonNull View[] views, @ColorInt int rippleColor, boolean oval) {
        for (View v : views) {
            setRippleEffect(v, rippleColor, false, oval);
        }
    }
    //

    public static void setRippleBackground(@NonNull Activity activity, @IdRes int layoutId, boolean oval) {
        final View view = activity.findViewById(layoutId);
        setRippleEffect(view, getDefaultColor(view), false, oval);
    }

    public static void setRippleBackground(@NonNull Activity activity, @IdRes int layoutId, @ColorInt int color, boolean oval) {
        setRippleEffect(activity.findViewById(layoutId), color, false, oval);
    }

    public static void setRippleBackground(@NonNull View view, boolean oval) {
        setRippleEffect(view, getDefaultColor(view), false, oval);
    }

    public static void setRippleBackground(@NonNull View view, @ColorInt int rippleColor, boolean oval) {
        setRippleEffect(view, rippleColor, false, oval);
    }
    //

    public static void setRippleBackground(@NonNull Activity activity, @IdRes int layoutId) {
        final View view = activity.findViewById(layoutId);
        setRippleEffect(view, getDefaultColor(view), false, false);
    }

    public static void setRippleBackground(@NonNull Activity activity, @IdRes int layoutId, @ColorInt int color) {
        setRippleEffect(activity.findViewById(layoutId), color, false, false);
    }

    public static void setRippleBackground(@NonNull View view) {
        setRippleEffect(view, getDefaultColor(view), false, false);
    }

    public static void setRippleBackground(@NonNull View view, @ColorInt int rippleColor) {
        setRippleEffect(view, rippleColor, false, false);
    }

    public static void setRippleForeground(@NonNull Activity activity, @IdRes int layoutId) {
        final View view = activity.findViewById(layoutId);
        setRippleEffect(view, getDefaultColor(view), true, false);
    }

    public static void setRippleForeground(@NonNull Activity activity, @IdRes int layoutId, @ColorInt int color) {
        setRippleEffect(activity.findViewById(layoutId), color, true, false);
    }

    public static void setRippleForeground(@NonNull View view) {
        setRippleEffect(view, getDefaultColor(view), true, false);
    }

    public static void setRippleForeground(@NonNull View view, @ColorInt int rippleColor) {
        setRippleEffect(view, rippleColor, true, false);
    }

    public static void setRippleEffect(@NonNull View view, @ColorInt int rippleColor, boolean foreground, boolean oval) {
        view.setClickable(true);

        final ColorStateList selector = RippleMaster.createSelector(Color.TRANSPARENT, rippleColor);
        if (!foreground && updateRippleColor(view, selector)) {
            return;// ripple color updated
        } // else

        final Context context = view.getContext();
        final Resources.Theme theme = context.getTheme();
        final Resources resources = view.getResources();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            RippleDrawable drawable;

            if (oval) {
                drawable = (RippleDrawable) resources.getDrawable(R.drawable.ripple_oval, theme);

            } else {
                final int[] selectableAttrs = new int[]{android.R.attr.selectableItemBackground};

                final TypedArray ta = context.obtainStyledAttributes(selectableAttrs);
                drawable = (RippleDrawable) ta.getDrawable(0);
                ta.recycle();
            }

            assert drawable != null;
            drawable.setColor(selector);

            if (foreground) {
                setForegroundDrawable(view, drawable);
            } else {
                view.setBackground(drawable);
            }
        } else {
            final Drawable mask = ContextCompat.getDrawable(context, R.drawable.shape_oval);

            Drawable drawable = new codetail.graphics.drawables.RippleDrawable(selector, view.getBackground(),
                    oval ? mask : null);

            if (foreground) {
                setForegroundDrawable(view, drawable);
            } else {
                view.setBackgroundDrawable(drawable);
            }
        }

        view.requestLayout();
    }

    public static boolean updateRippleColor(@NonNull View view, @ColorInt int rippleColor) {
        return updateRippleColor(view, RippleMaster.createSelector(Color.TRANSPARENT, rippleColor));
    }

    public static boolean updateRippleColor(@NonNull View view, ColorStateList selector) {
        final Drawable drawable = view.getBackground();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (drawable instanceof RippleDrawable) {
                final RippleDrawable rippleBackground = (RippleDrawable) drawable;
                rippleBackground.setColor(selector);
                return true;
            }
        } else {
            if (drawable instanceof codetail.graphics.drawables.RippleDrawable) {
                final codetail.graphics.drawables.RippleDrawable rippleBackground =
                        (codetail.graphics.drawables.RippleDrawable) drawable;
                rippleBackground.setColor(selector);
                return true;
            }
        }

        return false;
    }

    private static int getDefaultColor(@NonNull View view) {
        return ContextCompat.getColor(view.getContext(), R.color.rippleMasterDefaultColor);
    }

    private static void setForegroundDrawable(@NonNull View view, @ColorInt Drawable rippleDrawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.setForeground(rippleDrawable);
        } else {
            new RippleWrapper(view, rippleDrawable, true);
        }
    }
}
