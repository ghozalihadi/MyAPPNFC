package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.p016v4.view.GravityCompat;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

/* renamed from: android.support.design.widget.l */
/* compiled from: HeaderScrollingViewBehavior */
abstract class C0280l extends C0312x<View> {

    /* renamed from: a */
    final Rect f1021a = new Rect();

    /* renamed from: b */
    final Rect f1022b = new Rect();

    /* renamed from: c */
    private int f1023c = 0;

    /* renamed from: d */
    private int f1024d;

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract View mo755b(List<View> list);

    public C0280l() {
    }

    public C0280l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public boolean mo736a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View b;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (b = mo755b(coordinatorLayout.mo877c(view))) == null) {
            return false;
        }
        if (ViewCompat.getFitsSystemWindows(b) && !ViewCompat.getFitsSystemWindows(view)) {
            ViewCompat.setFitsSystemWindows(view, true);
            if (ViewCompat.getFitsSystemWindows(view)) {
                view.requestLayout();
                return true;
            }
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.mo868a(view, i, i2, View.MeasureSpec.makeMeasureSpec(mo754b(b) + (size - b.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1291b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View b = mo755b(coordinatorLayout.mo877c(view));
        if (b != null) {
            CoordinatorLayout.C0209d dVar = (CoordinatorLayout.C0209d) view.getLayoutParams();
            Rect rect = this.f1021a;
            rect.set(coordinatorLayout.getPaddingLeft() + dVar.leftMargin, b.getBottom() + dVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - dVar.rightMargin, ((coordinatorLayout.getHeight() + b.getBottom()) - coordinatorLayout.getPaddingBottom()) - dVar.bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.f1022b;
            GravityCompat.apply(m1547c(dVar.f692c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int c = mo1292c(b);
            view.layout(rect2.left, rect2.top - c, rect2.right, rect2.bottom - c);
            this.f1023c = rect2.top - b.getBottom();
            return;
        }
        super.mo1291b(coordinatorLayout, view, i);
        this.f1023c = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo751a(View view) {
        return 1.0f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final int mo1292c(View view) {
        if (this.f1024d == 0) {
            return 0;
        }
        return C0281m.m1558a((int) (mo751a(view) * ((float) this.f1024d)), 0, this.f1024d);
    }

    /* renamed from: c */
    private static int m1547c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo754b(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo1289a() {
        return this.f1023c;
    }

    /* renamed from: b */
    public final void mo1290b(int i) {
        this.f1024d = i;
    }

    /* renamed from: d */
    public final int mo1293d() {
        return this.f1024d;
    }
}
