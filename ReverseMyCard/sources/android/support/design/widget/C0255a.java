package android.support.design.widget;

import android.support.p016v4.view.animation.FastOutLinearInInterpolator;
import android.support.p016v4.view.animation.FastOutSlowInInterpolator;
import android.support.p016v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* renamed from: android.support.design.widget.a */
/* compiled from: AnimationUtils */
class C0255a {

    /* renamed from: a */
    static final Interpolator f899a = new LinearInterpolator();

    /* renamed from: b */
    static final Interpolator f900b = new FastOutSlowInInterpolator();

    /* renamed from: c */
    static final Interpolator f901c = new FastOutLinearInInterpolator();

    /* renamed from: d */
    static final Interpolator f902d = new LinearOutSlowInInterpolator();

    /* renamed from: e */
    static final Interpolator f903e = new DecelerateInterpolator();

    /* renamed from: a */
    static float m1400a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    /* renamed from: a */
    static int m1401a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }

    /* renamed from: android.support.design.widget.a$a */
    /* compiled from: AnimationUtils */
    static class C0256a implements Animation.AnimationListener {
        C0256a() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }
}
