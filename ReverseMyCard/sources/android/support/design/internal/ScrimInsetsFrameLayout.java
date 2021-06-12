package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.p016v4.view.OnApplyWindowInsetsListener;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: a */
    Drawable f530a;

    /* renamed from: b */
    Rect f531b;

    /* renamed from: c */
    private Rect f532c;

    public ScrimInsetsFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f532c = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrimInsetsFrameLayout, i, R.style.Widget_Design_ScrimInsetsFrameLayout);
        this.f530a = obtainStyledAttributes.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                if (ScrimInsetsFrameLayout.this.f531b == null) {
                    ScrimInsetsFrameLayout.this.f531b = new Rect();
                }
                ScrimInsetsFrameLayout.this.f531b.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                ScrimInsetsFrameLayout.this.mo626a(windowInsetsCompat);
                ScrimInsetsFrameLayout.this.setWillNotDraw(!windowInsetsCompat.hasSystemWindowInsets() || ScrimInsetsFrameLayout.this.f530a == null);
                ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f531b != null && this.f530a != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.f532c.set(0, 0, width, this.f531b.top);
            this.f530a.setBounds(this.f532c);
            this.f530a.draw(canvas);
            this.f532c.set(0, height - this.f531b.bottom, width, height);
            this.f530a.setBounds(this.f532c);
            this.f530a.draw(canvas);
            this.f532c.set(0, this.f531b.top, this.f531b.left, height - this.f531b.bottom);
            this.f530a.setBounds(this.f532c);
            this.f530a.draw(canvas);
            this.f532c.set(width - this.f531b.right, this.f531b.top, width, height - this.f531b.bottom);
            this.f530a.setBounds(this.f532c);
            this.f530a.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f530a != null) {
            this.f530a.setCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f530a != null) {
            this.f530a.setCallback((Drawable.Callback) null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo626a(WindowInsetsCompat windowInsetsCompat) {
    }
}
