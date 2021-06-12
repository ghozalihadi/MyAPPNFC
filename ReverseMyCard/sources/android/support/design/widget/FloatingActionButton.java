package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.R;
import android.support.design.widget.C0274i;
import android.support.design.widget.CoordinatorLayout;
import android.support.p016v4.content.res.ConfigurationHelper;
import android.support.p016v4.view.ViewCompat;
import android.support.p019v7.widget.AppCompatImageHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

@CoordinatorLayout.C0207b(mo930a = Behavior.class)
public class FloatingActionButton extends C0258ab {

    /* renamed from: a */
    int f708a;

    /* renamed from: b */
    boolean f709b;

    /* renamed from: c */
    final Rect f710c;

    /* renamed from: d */
    private ColorStateList f711d;

    /* renamed from: e */
    private PorterDuff.Mode f712e;

    /* renamed from: f */
    private int f713f;

    /* renamed from: g */
    private int f714g;

    /* renamed from: h */
    private int f715h;

    /* renamed from: i */
    private int f716i;

    /* renamed from: j */
    private final Rect f717j;

    /* renamed from: k */
    private AppCompatImageHelper f718k;

    /* renamed from: l */
    private C0274i f719l;

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    /* renamed from: android.support.design.widget.FloatingActionButton$a */
    public static abstract class C0213a {
        /* renamed from: a */
        public void mo990a(FloatingActionButton floatingActionButton) {
        }

        /* renamed from: b */
        public void mo991b(FloatingActionButton floatingActionButton) {
        }
    }

    public FloatingActionButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f710c = new Rect();
        this.f717j = new Rect();
        C0291r.m1597a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton, i, R.style.Widget_Design_FloatingActionButton);
        this.f711d = obtainStyledAttributes.getColorStateList(R.styleable.FloatingActionButton_backgroundTint);
        this.f712e = C0314z.m1693a(obtainStyledAttributes.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), (PorterDuff.Mode) null);
        this.f714g = obtainStyledAttributes.getColor(R.styleable.FloatingActionButton_rippleColor, 0);
        this.f715h = obtainStyledAttributes.getInt(R.styleable.FloatingActionButton_fabSize, -1);
        this.f713f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f709b = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
        obtainStyledAttributes.recycle();
        this.f718k = new AppCompatImageHelper(this);
        this.f718k.loadFromAttributes(attributeSet, i);
        this.f716i = (int) getResources().getDimension(R.dimen.design_fab_image_size);
        getImpl().mo1256a(this.f711d, this.f712e, this.f714g, this.f713f);
        getImpl().mo1273a(dimension);
        getImpl().mo1274b(dimension2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.f708a = (sizeDimension - this.f716i) / 2;
        getImpl().mo1277g();
        int min = Math.min(m1219a(sizeDimension, i), m1219a(sizeDimension, i2));
        setMeasuredDimension(this.f710c.left + min + this.f710c.right, min + this.f710c.top + this.f710c.bottom);
    }

    public int getRippleColor() {
        return this.f714g;
    }

    public void setRippleColor(int i) {
        if (this.f714g != i) {
            this.f714g = i;
            getImpl().mo1254a(i);
        }
    }

    public ColorStateList getBackgroundTintList() {
        return this.f711d;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f711d != colorStateList) {
            this.f711d = colorStateList;
            getImpl().mo1255a(colorStateList);
        }
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f712e;
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f712e != mode) {
            this.f712e = mode;
            getImpl().mo1257a(mode);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setImageResource(int i) {
        this.f718k.setImageResource(i);
    }

    /* renamed from: a */
    public void mo953a() {
        mo954a((C0213a) null);
    }

    /* renamed from: a */
    public void mo954a(C0213a aVar) {
        mo955a(aVar, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo955a(C0213a aVar, boolean z) {
        getImpl().mo1262b(m1221c(aVar), z);
    }

    /* renamed from: b */
    public void mo957b() {
        mo958b((C0213a) null);
    }

    /* renamed from: b */
    public void mo958b(C0213a aVar) {
        mo959b(aVar, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo959b(C0213a aVar, boolean z) {
        getImpl().mo1259a(m1221c(aVar), z);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f709b != z) {
            this.f709b = z;
            getImpl().mo1263c();
        }
    }

    public boolean getUseCompatPadding() {
        return this.f709b;
    }

    public void setSize(int i) {
        if (i != this.f715h) {
            this.f715h = i;
            requestLayout();
        }
    }

    public int getSize() {
        return this.f715h;
    }

    /* renamed from: c */
    private C0274i.C0276a m1221c(final C0213a aVar) {
        if (aVar == null) {
            return null;
        }
        return new C0274i.C0276a() {
            /* renamed from: a */
            public void mo985a() {
                aVar.mo990a(FloatingActionButton.this);
            }

            /* renamed from: b */
            public void mo986b() {
                aVar.mo991b(FloatingActionButton.this);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public int getSizeDimension() {
        return m1218a(this.f715h);
    }

    /* renamed from: a */
    private int m1218a(int i) {
        Resources resources = getResources();
        switch (i) {
            case -1:
                if (Math.max(ConfigurationHelper.getScreenWidthDp(resources), ConfigurationHelper.getScreenHeightDp(resources)) < 470) {
                    return m1218a(1);
                }
                return m1218a(0);
            case 1:
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
            default:
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().mo1278h();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().mo1279i();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo1260a(getDrawableState());
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo1261b();
    }

    /* renamed from: a */
    public boolean mo956a(Rect rect) {
        if (!ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        rect.left += this.f710c.left;
        rect.top += this.f710c.top;
        rect.right -= this.f710c.right;
        rect.bottom -= this.f710c.bottom;
        return true;
    }

    public Drawable getContentBackground() {
        return getImpl().mo1276f();
    }

    /* renamed from: a */
    private static int m1219a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!mo956a(this.f717j) || this.f717j.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public static class Behavior extends CoordinatorLayout.C0206a<FloatingActionButton> {

        /* renamed from: a */
        private Rect f722a;

        /* renamed from: b */
        private C0213a f723b;

        /* renamed from: c */
        private boolean f724c;

        public Behavior() {
            this.f724c = true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.f724c = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public void mo922a(CoordinatorLayout.C0209d dVar) {
            if (dVar.f697h == 0) {
                dVar.f697h = 80;
            }
        }

        /* renamed from: a */
        public boolean mo757c(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                m1233a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (!m1234a(view)) {
                return false;
            } else {
                m1236b(view, floatingActionButton);
                return false;
            }
        }

        /* renamed from: a */
        private static boolean m1234a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.C0209d) {
                return ((CoordinatorLayout.C0209d) layoutParams).mo939b() instanceof BottomSheetBehavior;
            }
            return false;
        }

        /* renamed from: a */
        private boolean m1235a(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.C0209d dVar = (CoordinatorLayout.C0209d) floatingActionButton.getLayoutParams();
            if (!this.f724c) {
                return false;
            }
            if (dVar.mo933a() != view.getId()) {
                return false;
            }
            if (floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        private boolean m1233a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!m1235a((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f722a == null) {
                this.f722a = new Rect();
            }
            Rect rect = this.f722a;
            C0307v.m1677b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.mo959b(this.f723b, false);
            } else {
                floatingActionButton.mo955a(this.f723b, false);
            }
            return true;
        }

        /* renamed from: b */
        private boolean m1236b(View view, FloatingActionButton floatingActionButton) {
            if (!m1235a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < ((CoordinatorLayout.C0209d) floatingActionButton.getLayoutParams()).topMargin + (floatingActionButton.getHeight() / 2)) {
                floatingActionButton.mo959b(this.f723b, false);
            } else {
                floatingActionButton.mo955a(this.f723b, false);
            }
            return true;
        }

        /* renamed from: a */
        public boolean mo735a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> c = coordinatorLayout.mo877c((View) floatingActionButton);
            int size = c.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = c.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (m1234a(view) && m1236b(view, floatingActionButton)) {
                        break;
                    }
                } else if (m1233a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.mo867a((View) floatingActionButton, i);
            m1232a(coordinatorLayout, floatingActionButton);
            return true;
        }

        /* renamed from: a */
        public boolean mo923a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f710c;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        /* renamed from: a */
        private void m1232a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            int i2 = 0;
            Rect rect = floatingActionButton.f710c;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.C0209d dVar = (CoordinatorLayout.C0209d) floatingActionButton.getLayoutParams();
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - dVar.rightMargin) {
                    i = rect.right;
                } else if (floatingActionButton.getLeft() <= dVar.leftMargin) {
                    i = -rect.left;
                } else {
                    i = 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - dVar.bottomMargin) {
                    i2 = rect.bottom;
                } else if (floatingActionButton.getTop() <= dVar.topMargin) {
                    i2 = -rect.top;
                }
                if (i2 != 0) {
                    ViewCompat.offsetTopAndBottom(floatingActionButton, i2);
                }
                if (i != 0) {
                    ViewCompat.offsetLeftAndRight(floatingActionButton, i);
                }
            }
        }
    }

    public float getCompatElevation() {
        return getImpl().mo1252a();
    }

    public void setCompatElevation(float f) {
        getImpl().mo1273a(f);
    }

    private C0274i getImpl() {
        if (this.f719l == null) {
            this.f719l = m1222c();
        }
        return this.f719l;
    }

    /* renamed from: c */
    private C0274i m1222c() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            return new C0277j(this, new C0214b(), C0314z.f1091a);
        }
        if (i >= 14) {
            return new C0271h(this, new C0214b(), C0314z.f1091a);
        }
        return new C0264g(this, new C0214b(), C0314z.f1091a);
    }

    /* renamed from: android.support.design.widget.FloatingActionButton$b */
    private class C0214b implements C0283o {
        C0214b() {
        }

        /* renamed from: a */
        public float mo992a() {
            return ((float) FloatingActionButton.this.getSizeDimension()) / 2.0f;
        }

        /* renamed from: a */
        public void mo993a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.f710c.set(i, i2, i3, i4);
            FloatingActionButton.this.setPadding(FloatingActionButton.this.f708a + i, FloatingActionButton.this.f708a + i2, FloatingActionButton.this.f708a + i3, FloatingActionButton.this.f708a + i4);
        }

        /* renamed from: a */
        public void mo994a(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        /* renamed from: b */
        public boolean mo995b() {
            return FloatingActionButton.this.f709b;
        }
    }
}
