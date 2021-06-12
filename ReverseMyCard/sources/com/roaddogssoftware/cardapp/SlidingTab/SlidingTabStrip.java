package com.roaddogssoftware.cardapp.SlidingTab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.p016v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.roaddogssoftware.cardapp.R;
import com.roaddogssoftware.cardapp.SlidingTab.SlidingTabLayout;

public class SlidingTabStrip extends LinearLayout {

    /* renamed from: a */
    private final int f1480a;

    /* renamed from: b */
    private final Paint f1481b;

    /* renamed from: c */
    private final int f1482c;

    /* renamed from: d */
    private final Paint f1483d;

    /* renamed from: e */
    private final int f1484e;

    /* renamed from: f */
    private final Paint f1485f;

    /* renamed from: g */
    private final float f1486g;

    /* renamed from: h */
    private int f1487h;

    /* renamed from: i */
    private float f1488i;

    /* renamed from: j */
    private SlidingTabLayout.C0721c f1489j;

    /* renamed from: k */
    private final C0723a f1490k;

    SlidingTabStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    SlidingTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        float f = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        int i = typedValue.data;
        this.f1484e = m2180a(i, (byte) 38);
        this.f1490k = new C0723a();
        this.f1490k.mo8229a(ContextCompat.getColor(context, R.color.colorPrimary));
        this.f1490k.mo8230b(m2180a(i, (byte) 32));
        this.f1480a = (int) (2.0f * f);
        this.f1481b = new Paint();
        this.f1481b.setColor(this.f1484e);
        this.f1482c = (int) (8.0f * f);
        this.f1483d = new Paint();
        this.f1486g = 0.5f;
        this.f1485f = new Paint();
        this.f1485f.setStrokeWidth((float) ((int) (f * 1.0f)));
    }

    /* access modifiers changed from: package-private */
    public void setCustomTabColorizer(SlidingTabLayout.C0721c cVar) {
        this.f1489j = cVar;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void setSelectedIndicatorColors(int... iArr) {
        this.f1489j = null;
        this.f1490k.mo8229a(iArr);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void setDividerColors(int... iArr) {
        this.f1489j = null;
        this.f1490k.mo8230b(iArr);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8224a(int i, float f) {
        this.f1487h = i;
        this.f1488i = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int height = getHeight();
        int childCount = getChildCount();
        int min = (int) (Math.min(Math.max(0.0f, this.f1486g), 1.0f) * ((float) height));
        SlidingTabLayout.C0721c cVar = this.f1489j != null ? this.f1489j : this.f1490k;
        if (childCount > 0) {
            View childAt = getChildAt(this.f1487h);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            int a = cVar.mo8222a(this.f1487h);
            if (this.f1488i <= 0.0f || this.f1487h >= getChildCount() - 1) {
                i = right;
                i2 = left;
            } else {
                int a2 = cVar.mo8222a(this.f1487h + 1);
                if (a != a2) {
                    a = m2181a(a2, a, this.f1488i);
                }
                View childAt2 = getChildAt(this.f1487h + 1);
                i = (int) ((((float) right) * (1.0f - this.f1488i)) + (((float) childAt2.getRight()) * this.f1488i));
                i2 = (int) ((((float) left) * (1.0f - this.f1488i)) + (this.f1488i * ((float) childAt2.getLeft())));
            }
            this.f1483d.setColor(a);
            canvas.drawRect((float) i2, (float) (height - this.f1482c), (float) i, (float) height, this.f1483d);
        }
        canvas.drawRect(0.0f, (float) (height - this.f1480a), (float) getWidth(), (float) height, this.f1481b);
        int i3 = (height - min) / 2;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < childCount - 1) {
                View childAt3 = getChildAt(i5);
                this.f1485f.setColor(cVar.mo8223b(i5));
                canvas.drawLine((float) childAt3.getRight(), (float) i3, (float) childAt3.getRight(), (float) (i3 + min), this.f1485f);
                i4 = i5 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static int m2180a(int i, byte b) {
        return Color.argb(b, Color.red(i), Color.green(i), Color.blue(i));
    }

    /* renamed from: a */
    private static int m2181a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.rgb((int) ((((float) Color.red(i)) * f) + (((float) Color.red(i2)) * f2)), (int) ((((float) Color.green(i)) * f) + (((float) Color.green(i2)) * f2)), (int) ((f2 * ((float) Color.blue(i2))) + (((float) Color.blue(i)) * f)));
    }

    /* renamed from: com.roaddogssoftware.cardapp.SlidingTab.SlidingTabStrip$a */
    private static class C0723a implements SlidingTabLayout.C0721c {

        /* renamed from: a */
        private int[] f1491a;

        /* renamed from: b */
        private int[] f1492b;

        private C0723a() {
        }

        /* renamed from: a */
        public final int mo8222a(int i) {
            return this.f1491a[i % this.f1491a.length];
        }

        /* renamed from: b */
        public final int mo8223b(int i) {
            return this.f1492b[i % this.f1492b.length];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo8229a(int... iArr) {
            this.f1491a = iArr;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo8230b(int... iArr) {
            this.f1492b = iArr;
        }
    }
}
