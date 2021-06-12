package com.roaddogssoftware.cardapp;

import android.support.p016v4.view.ViewPager;
import android.view.View;

/* renamed from: com.roaddogssoftware.cardapp.d */
/* compiled from: PageTransformer */
public class C0792d implements ViewPager.PageTransformer {
    public void transformPage(View view, float f) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (f < -1.0f) {
            view.setAlpha(0.0f);
        } else if (f <= 1.0f) {
            float max = Math.max(0.85f, 1.0f - Math.abs(f));
            float f2 = (((float) height) * (1.0f - max)) / 2.0f;
            float f3 = (((float) width) * (1.0f - max)) / 2.0f;
            if (f < 0.0f) {
                view.setTranslationX(f3 - (f2 / 2.0f));
            } else {
                view.setTranslationX((-f3) + (f2 / 2.0f));
            }
            view.setScaleX(max);
            view.setScaleY(max);
            view.setAlpha((((max - 0.85f) / 0.14999998f) * 0.5f) + 0.5f);
        } else {
            view.setAlpha(0.0f);
        }
    }
}
