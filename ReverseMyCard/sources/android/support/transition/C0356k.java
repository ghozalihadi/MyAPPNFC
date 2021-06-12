package android.support.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* renamed from: android.support.transition.k */
/* compiled from: RectEvaluator */
class C0356k implements TypeEvaluator<Rect> {

    /* renamed from: a */
    private Rect f1156a;

    /* renamed from: a */
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i = ((int) (((float) (rect2.left - rect.left)) * f)) + rect.left;
        int i2 = ((int) (((float) (rect2.top - rect.top)) * f)) + rect.top;
        int i3 = ((int) (((float) (rect2.right - rect.right)) * f)) + rect.right;
        int i4 = ((int) (((float) (rect2.bottom - rect.bottom)) * f)) + rect.bottom;
        if (this.f1156a == null) {
            return new Rect(i, i2, i3, i4);
        }
        this.f1156a.set(i, i2, i3, i4);
        return this.f1156a;
    }
}
