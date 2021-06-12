package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.R;
import android.support.design.widget.C0292s;
import android.support.p016v4.content.ContextCompat;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;

/* renamed from: android.support.design.widget.i */
/* compiled from: FloatingActionButtonImpl */
abstract class C0274i {

    /* renamed from: b */
    static final Interpolator f992b = C0255a.f901c;

    /* renamed from: j */
    static final int[] f993j = {16842919, 16842910};

    /* renamed from: k */
    static final int[] f994k = {16842908, 16842910};

    /* renamed from: l */
    static final int[] f995l = {16842910};

    /* renamed from: m */
    static final int[] f996m = new int[0];

    /* renamed from: a */
    private final Rect f997a = new Rect();

    /* renamed from: c */
    int f998c = 0;

    /* renamed from: d */
    Drawable f999d;

    /* renamed from: e */
    Drawable f1000e;

    /* renamed from: f */
    C0259b f1001f;

    /* renamed from: g */
    Drawable f1002g;

    /* renamed from: h */
    float f1003h;

    /* renamed from: i */
    float f1004i;

    /* renamed from: n */
    final C0258ab f1005n;

    /* renamed from: o */
    final C0283o f1006o;

    /* renamed from: p */
    final C0292s.C0298d f1007p;

    /* renamed from: q */
    private ViewTreeObserver.OnPreDrawListener f1008q;

    /* renamed from: android.support.design.widget.i$a */
    /* compiled from: FloatingActionButtonImpl */
    interface C0276a {
        /* renamed from: a */
        void mo985a();

        /* renamed from: b */
        void mo986b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract float mo1252a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo1253a(float f, float f2);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo1254a(int i);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo1255a(ColorStateList colorStateList);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo1256a(ColorStateList colorStateList, PorterDuff.Mode mode, int i, int i2);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo1257a(PorterDuff.Mode mode);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo1258a(Rect rect);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo1259a(C0276a aVar, boolean z);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo1260a(int[] iArr);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo1261b();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo1262b(C0276a aVar, boolean z);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract void mo1263c();

    C0274i(C0258ab abVar, C0283o oVar, C0292s.C0298d dVar) {
        this.f1005n = abVar;
        this.f1006o = oVar;
        this.f1007p = dVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo1273a(float f) {
        if (this.f1003h != f) {
            this.f1003h = f;
            mo1253a(f, this.f1004i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo1274b(float f) {
        if (this.f1004i != f) {
            this.f1004i = f;
            mo1253a(this.f1003h, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final Drawable mo1276f() {
        return this.f1002g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final void mo1277g() {
        Rect rect = this.f997a;
        mo1258a(rect);
        mo1275b(rect);
        this.f1006o.mo993a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1275b(Rect rect) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo1278h() {
        if (mo1265d()) {
            m1495n();
            this.f1005n.getViewTreeObserver().addOnPreDrawListener(this.f1008q);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo1279i() {
        if (this.f1008q != null) {
            this.f1005n.getViewTreeObserver().removeOnPreDrawListener(this.f1008q);
            this.f1008q = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo1265d() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0259b mo1272a(int i, ColorStateList colorStateList) {
        Context context = this.f1005n.getContext();
        C0259b j = mo1280j();
        j.mo1203a(ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color));
        j.mo1202a((float) i);
        j.mo1204a(colorStateList);
        return j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public C0259b mo1280j() {
        return new C0259b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo1266e() {
    }

    /* renamed from: n */
    private void m1495n() {
        if (this.f1008q == null) {
            this.f1008q = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    C0274i.this.mo1266e();
                    return true;
                }
            };
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public GradientDrawable mo1281k() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public boolean mo1282l() {
        if (this.f1005n.getVisibility() != 0) {
            if (this.f998c == 2) {
                return true;
            }
            return false;
        } else if (this.f998c == 1) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo1283m() {
        if (this.f1005n.getVisibility() == 0) {
            if (this.f998c == 1) {
                return true;
            }
            return false;
        } else if (this.f998c == 2) {
            return false;
        } else {
            return true;
        }
    }
}
