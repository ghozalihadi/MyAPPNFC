package android.support.design.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.design.widget.C0292s;
import android.support.p016v4.graphics.drawable.DrawableCompat;
import android.view.View;

@TargetApi(21)
/* renamed from: android.support.design.widget.j */
/* compiled from: FloatingActionButtonLollipop */
class C0277j extends C0271h {

    /* renamed from: q */
    private InsetDrawable f1010q;

    C0277j(C0258ab abVar, C0283o oVar, C0292s.C0298d dVar) {
        super(abVar, oVar, dVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1256a(ColorStateList colorStateList, PorterDuff.Mode mode, int i, int i2) {
        Drawable drawable;
        this.f999d = DrawableCompat.wrap(mo1281k());
        DrawableCompat.setTintList(this.f999d, colorStateList);
        if (mode != null) {
            DrawableCompat.setTintMode(this.f999d, mode);
        }
        if (i2 > 0) {
            this.f1001f = mo1272a(i2, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{this.f1001f, this.f999d});
        } else {
            this.f1001f = null;
            drawable = this.f999d;
        }
        this.f1000e = new RippleDrawable(ColorStateList.valueOf(i), drawable, (Drawable) null);
        this.f1002g = this.f1000e;
        this.f1006o.mo994a(this.f1000e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1254a(int i) {
        if (this.f1000e instanceof RippleDrawable) {
            ((RippleDrawable) this.f1000e).setColor(ColorStateList.valueOf(i));
        } else {
            super.mo1254a(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1253a(float f, float f2) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f1005n, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f1005n, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
        animatorSet.setInterpolator(f992b);
        stateListAnimator.addState(f993j, animatorSet);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ObjectAnimator.ofFloat(this.f1005n, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f1005n, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
        animatorSet2.setInterpolator(f992b);
        stateListAnimator.addState(f994k, animatorSet2);
        AnimatorSet animatorSet3 = new AnimatorSet();
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.play(ObjectAnimator.ofFloat(this.f1005n, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100)).after(100);
        animatorSet3.play(ObjectAnimator.ofFloat(this.f1005n, "elevation", new float[]{f}).setDuration(0)).with(animatorSet4);
        animatorSet3.setInterpolator(f992b);
        stateListAnimator.addState(f995l, animatorSet3);
        AnimatorSet animatorSet5 = new AnimatorSet();
        animatorSet5.play(ObjectAnimator.ofFloat(this.f1005n, "elevation", new float[]{0.0f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f1005n, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(0));
        animatorSet5.setInterpolator(f992b);
        stateListAnimator.addState(f996m, animatorSet5);
        this.f1005n.setStateListAnimator(stateListAnimator);
        if (this.f1006o.mo995b()) {
            mo1277g();
        }
    }

    /* renamed from: a */
    public float mo1252a() {
        return this.f1005n.getElevation();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo1263c() {
        mo1277g();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1275b(Rect rect) {
        if (this.f1006o.mo995b()) {
            this.f1010q = new InsetDrawable(this.f1000e, rect.left, rect.top, rect.right, rect.bottom);
            this.f1006o.mo994a(this.f1010q);
            return;
        }
        this.f1006o.mo994a(this.f1000e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1260a(int[] iArr) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1261b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo1265d() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public C0259b mo1280j() {
        return new C0260c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1258a(Rect rect) {
        if (this.f1006o.mo995b()) {
            float a = this.f1006o.mo992a();
            float a2 = mo1252a() + this.f1004i;
            int ceil = (int) Math.ceil((double) C0282n.m1562b(a2, a, false));
            int ceil2 = (int) Math.ceil((double) C0282n.m1559a(a2, a, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
