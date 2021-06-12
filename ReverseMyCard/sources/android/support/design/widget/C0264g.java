package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.R;
import android.support.design.widget.C0255a;
import android.support.design.widget.C0274i;
import android.support.design.widget.C0292s;
import android.support.p016v4.graphics.drawable.DrawableCompat;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* renamed from: android.support.design.widget.g */
/* compiled from: FloatingActionButtonGingerbread */
class C0264g extends C0274i {

    /* renamed from: a */
    C0282n f970a;

    /* renamed from: q */
    private final C0288q f971q = new C0288q();

    C0264g(C0258ab abVar, C0283o oVar, C0292s.C0298d dVar) {
        super(abVar, oVar, dVar);
        this.f971q.mo1316a(f993j, m1469a((C0270d) new C0268b()));
        this.f971q.mo1316a(f994k, m1469a((C0270d) new C0268b()));
        this.f971q.mo1316a(f995l, m1469a((C0270d) new C0269c()));
        this.f971q.mo1316a(f996m, m1469a((C0270d) new C0267a()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1256a(ColorStateList colorStateList, PorterDuff.Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.f999d = DrawableCompat.wrap(mo1281k());
        DrawableCompat.setTintList(this.f999d, colorStateList);
        if (mode != null) {
            DrawableCompat.setTintMode(this.f999d, mode);
        }
        this.f1000e = DrawableCompat.wrap(mo1281k());
        DrawableCompat.setTintList(this.f1000e, m1470b(i));
        if (i2 > 0) {
            this.f1001f = mo1272a(i2, colorStateList);
            drawableArr = new Drawable[]{this.f1001f, this.f999d, this.f1000e};
        } else {
            this.f1001f = null;
            drawableArr = new Drawable[]{this.f999d, this.f1000e};
        }
        this.f1002g = new LayerDrawable(drawableArr);
        this.f970a = new C0282n(this.f1005n.getContext(), this.f1002g, this.f1006o.mo992a(), this.f1003h, this.f1003h + this.f1004i);
        this.f970a.mo1297a(false);
        this.f1006o.mo994a(this.f970a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1255a(ColorStateList colorStateList) {
        if (this.f999d != null) {
            DrawableCompat.setTintList(this.f999d, colorStateList);
        }
        if (this.f1001f != null) {
            this.f1001f.mo1204a(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1257a(PorterDuff.Mode mode) {
        if (this.f999d != null) {
            DrawableCompat.setTintMode(this.f999d, mode);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1254a(int i) {
        if (this.f1000e != null) {
            DrawableCompat.setTintList(this.f1000e, m1470b(i));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo1252a() {
        return this.f1003h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1253a(float f, float f2) {
        if (this.f970a != null) {
            this.f970a.mo1296a(f, this.f1004i + f);
            mo1277g();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1260a(int[] iArr) {
        this.f971q.mo1315a(iArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1261b() {
        this.f971q.mo1314a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1259a(final C0274i.C0276a aVar, final boolean z) {
        if (!mo1283m()) {
            this.f998c = 1;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f1005n.getContext(), R.anim.design_fab_out);
            loadAnimation.setInterpolator(C0255a.f901c);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new C0255a.C0256a() {
                public void onAnimationEnd(Animation animation) {
                    C0264g.this.f998c = 0;
                    C0264g.this.f1005n.mo1200a(8, z);
                    if (aVar != null) {
                        aVar.mo986b();
                    }
                }
            });
            this.f1005n.startAnimation(loadAnimation);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1262b(final C0274i.C0276a aVar, boolean z) {
        if (!mo1282l()) {
            this.f998c = 2;
            this.f1005n.mo1200a(0, z);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f1005n.getContext(), R.anim.design_fab_in);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(C0255a.f902d);
            loadAnimation.setAnimationListener(new C0255a.C0256a() {
                public void onAnimationEnd(Animation animation) {
                    C0264g.this.f998c = 0;
                    if (aVar != null) {
                        aVar.mo985a();
                    }
                }
            });
            this.f1005n.startAnimation(loadAnimation);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo1263c() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1258a(Rect rect) {
        this.f970a.getPadding(rect);
    }

    /* renamed from: a */
    private C0292s m1469a(C0270d dVar) {
        C0292s a = this.f1007p.mo1337a();
        a.mo1323a(f992b);
        a.mo1320a(100);
        a.mo1321a((C0292s.C0295a) dVar);
        a.mo1322a((C0292s.C0297c) dVar);
        a.mo1318a(0.0f, 1.0f);
        return a;
    }

    /* renamed from: android.support.design.widget.g$d */
    /* compiled from: FloatingActionButtonGingerbread */
    private abstract class C0270d extends C0292s.C0296b implements C0292s.C0297c {

        /* renamed from: a */
        private boolean f980a;

        /* renamed from: c */
        private float f982c;

        /* renamed from: d */
        private float f983d;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract float mo1264a();

        private C0270d() {
        }

        /* renamed from: a */
        public void mo746a(C0292s sVar) {
            if (!this.f980a) {
                this.f982c = C0264g.this.f970a.mo1294a();
                this.f983d = mo1264a();
                this.f980a = true;
            }
            C0264g.this.f970a.mo1298b(this.f982c + ((this.f983d - this.f982c) * sVar.mo1328f()));
        }

        /* renamed from: b */
        public void mo1125b(C0292s sVar) {
            C0264g.this.f970a.mo1298b(this.f983d);
            this.f980a = false;
        }
    }

    /* renamed from: android.support.design.widget.g$c */
    /* compiled from: FloatingActionButtonGingerbread */
    private class C0269c extends C0270d {
        C0269c() {
            super();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public float mo1264a() {
            return C0264g.this.f1003h;
        }
    }

    /* renamed from: android.support.design.widget.g$b */
    /* compiled from: FloatingActionButtonGingerbread */
    private class C0268b extends C0270d {
        C0268b() {
            super();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public float mo1264a() {
            return C0264g.this.f1003h + C0264g.this.f1004i;
        }
    }

    /* renamed from: android.support.design.widget.g$a */
    /* compiled from: FloatingActionButtonGingerbread */
    private class C0267a extends C0270d {
        C0267a() {
            super();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public float mo1264a() {
            return 0.0f;
        }
    }

    /* renamed from: b */
    private static ColorStateList m1470b(int i) {
        return new ColorStateList(new int[][]{f994k, f993j, new int[0]}, new int[]{i, i, 0});
    }
}
