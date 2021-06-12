package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.transition.C0325ae;
import android.support.transition.C0358m;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

/* renamed from: android.support.design.internal.h */
/* compiled from: TextScale */
public class C0185h extends C0358m {
    /* renamed from: a */
    public void mo682a(C0325ae aeVar) {
        m1006c(aeVar);
    }

    /* renamed from: b */
    public void mo683b(C0325ae aeVar) {
        m1006c(aeVar);
    }

    /* renamed from: c */
    private void m1006c(C0325ae aeVar) {
        if (aeVar.f1102b instanceof TextView) {
            aeVar.f1101a.put("android:textscale:scale", Float.valueOf(((TextView) aeVar.f1102b).getScaleX()));
        }
    }

    /* renamed from: a */
    public Animator mo681a(ViewGroup viewGroup, C0325ae aeVar, C0325ae aeVar2) {
        float f = 1.0f;
        if (aeVar == null || aeVar2 == null || !(aeVar.f1102b instanceof TextView) || !(aeVar2.f1102b instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) aeVar2.f1102b;
        Map<String, Object> map = aeVar.f1101a;
        Map<String, Object> map2 = aeVar2.f1101a;
        float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        if (map2.get("android:textscale:scale") != null) {
            f = ((Float) map2.get("android:textscale:scale")).floatValue();
        }
        if (floatValue == f) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{floatValue, f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
