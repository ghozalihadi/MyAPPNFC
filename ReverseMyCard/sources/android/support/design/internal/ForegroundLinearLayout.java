package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.p019v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;

public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* renamed from: a */
    protected boolean f512a;

    /* renamed from: b */
    boolean f513b;

    /* renamed from: c */
    private Drawable f514c;

    /* renamed from: d */
    private final Rect f515d;

    /* renamed from: e */
    private final Rect f516e;

    /* renamed from: f */
    private int f517f;

    public ForegroundLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f515d = new Rect();
        this.f516e = new Rect();
        this.f517f = 119;
        this.f512a = true;
        this.f513b = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ForegroundLinearLayout, i, 0);
        this.f517f = obtainStyledAttributes.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.f517f);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f512a = obtainStyledAttributes.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        obtainStyledAttributes.recycle();
    }

    public int getForegroundGravity() {
        return this.f517f;
    }

    public void setForegroundGravity(int i) {
        int i2;
        if (this.f517f != i) {
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f517f = i2;
            if (this.f517f == 119 && this.f514c != null) {
                this.f514c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f514c;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f514c != null) {
            this.f514c.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f514c != null && this.f514c.isStateful()) {
            this.f514c.setState(getDrawableState());
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.f514c != drawable) {
            if (this.f514c != null) {
                this.f514c.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.f514c);
            }
            this.f514c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f517f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public Drawable getForeground() {
        return this.f514c;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f513b |= z;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f513b = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f514c != null) {
            Drawable drawable = this.f514c;
            if (this.f513b) {
                this.f513b = false;
                Rect rect = this.f515d;
                Rect rect2 = this.f516e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f512a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f517f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.f514c != null) {
            this.f514c.setHotspot(f, f2);
        }
    }
}
