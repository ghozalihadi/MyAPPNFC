package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.support.design.widget.C0292s;
import android.view.animation.Interpolator;

/* renamed from: android.support.design.widget.u */
/* compiled from: ValueAnimatorCompatImplHoneycombMr1 */
class C0304u extends C0292s.C0299e {

    /* renamed from: a */
    private final ValueAnimator f1075a = new ValueAnimator();

    C0304u() {
    }

    /* renamed from: a */
    public void mo1338a() {
        this.f1075a.start();
    }

    /* renamed from: b */
    public boolean mo1345b() {
        return this.f1075a.isRunning();
    }

    /* renamed from: a */
    public void mo1344a(Interpolator interpolator) {
        this.f1075a.setInterpolator(interpolator);
    }

    /* renamed from: a */
    public void mo1343a(final C0292s.C0299e.C0301b bVar) {
        this.f1075a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                bVar.mo1331a();
            }
        });
    }

    /* renamed from: a */
    public void mo1342a(final C0292s.C0299e.C0300a aVar) {
        this.f1075a.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                aVar.mo1332a();
            }

            public void onAnimationEnd(Animator animator) {
                aVar.mo1333b();
            }

            public void onAnimationCancel(Animator animator) {
                aVar.mo1334c();
            }
        });
    }

    /* renamed from: a */
    public void mo1340a(int i, int i2) {
        this.f1075a.setIntValues(new int[]{i, i2});
    }

    /* renamed from: c */
    public int mo1346c() {
        return ((Integer) this.f1075a.getAnimatedValue()).intValue();
    }

    /* renamed from: a */
    public void mo1339a(float f, float f2) {
        this.f1075a.setFloatValues(new float[]{f, f2});
    }

    /* renamed from: d */
    public float mo1347d() {
        return ((Float) this.f1075a.getAnimatedValue()).floatValue();
    }

    /* renamed from: a */
    public void mo1341a(long j) {
        this.f1075a.setDuration(j);
    }

    /* renamed from: e */
    public void mo1348e() {
        this.f1075a.cancel();
    }

    /* renamed from: f */
    public float mo1349f() {
        return this.f1075a.getAnimatedFraction();
    }

    /* renamed from: g */
    public void mo1350g() {
        this.f1075a.end();
    }

    /* renamed from: h */
    public long mo1351h() {
        return this.f1075a.getDuration();
    }
}
