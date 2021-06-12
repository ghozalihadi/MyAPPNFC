package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Paint;
import android.os.Build;
import android.support.design.widget.C0274i;
import android.support.design.widget.C0292s;
import android.support.p016v4.view.ViewCompat;

/* renamed from: android.support.design.widget.h */
/* compiled from: FloatingActionButtonIcs */
class C0271h extends C0264g {

    /* renamed from: q */
    private float f984q = this.f1005n.getRotation();

    C0271h(C0258ab abVar, C0283o oVar, C0292s.C0298d dVar) {
        super(abVar, oVar, dVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo1265d() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo1266e() {
        float rotation = this.f1005n.getRotation();
        if (this.f984q != rotation) {
            this.f984q = rotation;
            m1490o();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1259a(final C0274i.C0276a aVar, final boolean z) {
        if (!mo1283m()) {
            this.f1005n.animate().cancel();
            if (m1489n()) {
                this.f998c = 1;
                this.f1005n.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(C0255a.f901c).setListener(new AnimatorListenerAdapter() {

                    /* renamed from: d */
                    private boolean f988d;

                    public void onAnimationStart(Animator animator) {
                        C0271h.this.f1005n.mo1200a(0, z);
                        this.f988d = false;
                    }

                    public void onAnimationCancel(Animator animator) {
                        this.f988d = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        C0271h.this.f998c = 0;
                        if (!this.f988d) {
                            C0271h.this.f1005n.mo1200a(8, z);
                            if (aVar != null) {
                                aVar.mo986b();
                            }
                        }
                    }
                });
                return;
            }
            this.f1005n.mo1200a(8, z);
            if (aVar != null) {
                aVar.mo986b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1262b(final C0274i.C0276a aVar, final boolean z) {
        if (!mo1282l()) {
            this.f1005n.animate().cancel();
            if (m1489n()) {
                this.f998c = 2;
                if (this.f1005n.getVisibility() != 0) {
                    this.f1005n.setAlpha(0.0f);
                    this.f1005n.setScaleY(0.0f);
                    this.f1005n.setScaleX(0.0f);
                }
                this.f1005n.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(C0255a.f902d).setListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        C0271h.this.f1005n.mo1200a(0, z);
                    }

                    public void onAnimationEnd(Animator animator) {
                        C0271h.this.f998c = 0;
                        if (aVar != null) {
                            aVar.mo985a();
                        }
                    }
                });
                return;
            }
            this.f1005n.mo1200a(0, z);
            this.f1005n.setAlpha(1.0f);
            this.f1005n.setScaleY(1.0f);
            this.f1005n.setScaleX(1.0f);
            if (aVar != null) {
                aVar.mo985a();
            }
        }
    }

    /* renamed from: n */
    private boolean m1489n() {
        return ViewCompat.isLaidOut(this.f1005n) && !this.f1005n.isInEditMode();
    }

    /* renamed from: o */
    private void m1490o() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.f984q % 90.0f != 0.0f) {
                if (this.f1005n.getLayerType() != 1) {
                    this.f1005n.setLayerType(1, (Paint) null);
                }
            } else if (this.f1005n.getLayerType() != 0) {
                this.f1005n.setLayerType(0, (Paint) null);
            }
        }
        if (this.f970a != null) {
            this.f970a.mo1295a(-this.f984q);
        }
        if (this.f1001f != null) {
            this.f1001f.mo1205b(-this.f984q);
        }
    }
}
