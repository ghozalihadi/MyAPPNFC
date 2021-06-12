package android.support.design.widget;

import android.content.Context;
import android.support.p016v4.view.MotionEventCompat;
import android.support.p016v4.view.VelocityTrackerCompat;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.widget.ScrollerCompat;
import android.support.p019v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: android.support.design.widget.k */
/* compiled from: HeaderBehavior */
abstract class C0278k<V extends View> extends C0312x<V> {

    /* renamed from: a */
    ScrollerCompat f1011a;

    /* renamed from: b */
    private Runnable f1012b;

    /* renamed from: c */
    private boolean f1013c;

    /* renamed from: d */
    private int f1014d = -1;

    /* renamed from: e */
    private int f1015e;

    /* renamed from: f */
    private int f1016f = -1;

    /* renamed from: g */
    private VelocityTracker f1017g;

    public C0278k() {
    }

    public C0278k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public boolean mo777a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f1016f < 0) {
            this.f1016f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f1013c) {
            return true;
        }
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.f1013c = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (mo745c(v) && coordinatorLayout.mo872a((View) v, x, y)) {
                    this.f1015e = y;
                    this.f1014d = motionEvent.getPointerId(0);
                    m1535d();
                    break;
                }
            case 1:
            case 3:
                this.f1013c = false;
                this.f1014d = -1;
                if (this.f1017g != null) {
                    this.f1017g.recycle();
                    this.f1017g = null;
                    break;
                }
                break;
            case 2:
                int i = this.f1014d;
                if (!(i == -1 || (findPointerIndex = motionEvent.findPointerIndex(i)) == -1)) {
                    int y2 = (int) motionEvent.getY(findPointerIndex);
                    if (Math.abs(y2 - this.f1015e) > this.f1016f) {
                        this.f1013c = true;
                        this.f1015e = y2;
                        break;
                    }
                }
                break;
        }
        if (this.f1017g != null) {
            this.f1017g.addMovement(motionEvent);
        }
        return this.f1013c;
    }

    /* renamed from: b */
    public boolean mo782b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f1016f < 0) {
            this.f1016f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.mo872a((View) v, (int) motionEvent.getX(), y) && mo745c(v)) {
                    this.f1015e = y;
                    this.f1014d = motionEvent.getPointerId(0);
                    m1535d();
                    break;
                } else {
                    return false;
                }
                break;
            case 1:
                if (this.f1017g != null) {
                    this.f1017g.addMovement(motionEvent);
                    this.f1017g.computeCurrentVelocity(1000);
                    mo1285a(coordinatorLayout, v, -mo718a(v), 0, VelocityTrackerCompat.getYVelocity(this.f1017g, this.f1014d));
                    break;
                }
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.f1014d);
                if (findPointerIndex != -1) {
                    int y2 = (int) motionEvent.getY(findPointerIndex);
                    int i = this.f1015e - y2;
                    if (!this.f1013c && Math.abs(i) > this.f1016f) {
                        this.f1013c = true;
                        i = i > 0 ? i - this.f1016f : i + this.f1016f;
                    }
                    if (this.f1013c) {
                        this.f1015e = y2;
                        mo1287b(coordinatorLayout, v, i, mo741b(v), 0);
                        break;
                    }
                } else {
                    return false;
                }
                break;
            case 3:
                break;
        }
        this.f1013c = false;
        this.f1014d = -1;
        if (this.f1017g != null) {
            this.f1017g.recycle();
            this.f1017g = null;
        }
        if (this.f1017g != null) {
            this.f1017g.addMovement(motionEvent);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a_ */
    public int mo1286a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return mo717a(coordinatorLayout, v, i, Integer.MIN_VALUE, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo717a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int a;
        int b = mo739b();
        if (i2 == 0 || b < i2 || b > i3 || b == (a = C0281m.m1558a(i, i2, i3))) {
            return 0;
        }
        mo729a(a);
        return b - a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo715a() {
        return mo739b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final int mo1287b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return mo717a(coordinatorLayout, v, mo715a() - i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo1285a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.f1012b != null) {
            v.removeCallbacks(this.f1012b);
            this.f1012b = null;
        }
        if (this.f1011a == null) {
            this.f1011a = ScrollerCompat.create(v.getContext());
        }
        this.f1011a.fling(0, mo739b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.f1011a.computeScrollOffset()) {
            this.f1012b = new C0279a(coordinatorLayout, v);
            ViewCompat.postOnAnimation(v, this.f1012b);
            return true;
        }
        mo724a(coordinatorLayout, v);
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo724a(CoordinatorLayout coordinatorLayout, V v) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo745c(V v) {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo741b(V v) {
        return -v.getHeight();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo718a(V v) {
        return v.getHeight();
    }

    /* renamed from: d */
    private void m1535d() {
        if (this.f1017g == null) {
            this.f1017g = VelocityTracker.obtain();
        }
    }

    /* renamed from: android.support.design.widget.k$a */
    /* compiled from: HeaderBehavior */
    private class C0279a implements Runnable {

        /* renamed from: b */
        private final CoordinatorLayout f1019b;

        /* renamed from: c */
        private final V f1020c;

        C0279a(CoordinatorLayout coordinatorLayout, V v) {
            this.f1019b = coordinatorLayout;
            this.f1020c = v;
        }

        public void run() {
            if (this.f1020c != null && C0278k.this.f1011a != null) {
                if (C0278k.this.f1011a.computeScrollOffset()) {
                    C0278k.this.mo1286a_(this.f1019b, this.f1020c, C0278k.this.f1011a.getCurrY());
                    ViewCompat.postOnAnimation(this.f1020c, this);
                    return;
                }
                C0278k.this.mo724a(this.f1019b, this.f1020c);
            }
        }
    }
}
