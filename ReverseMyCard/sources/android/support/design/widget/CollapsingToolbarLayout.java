package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.C0292s;
import android.support.p016v4.content.ContextCompat;
import android.support.p016v4.graphics.drawable.DrawableCompat;
import android.support.p016v4.view.OnApplyWindowInsetsListener;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.view.WindowInsetsCompat;
import android.support.p019v7.appcompat.C0555R;
import android.support.p019v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

public class CollapsingToolbarLayout extends FrameLayout {

    /* renamed from: a */
    final C0261d f630a;

    /* renamed from: b */
    Drawable f631b;

    /* renamed from: c */
    int f632c;

    /* renamed from: d */
    WindowInsetsCompat f633d;

    /* renamed from: e */
    private boolean f634e;

    /* renamed from: f */
    private int f635f;

    /* renamed from: g */
    private Toolbar f636g;

    /* renamed from: h */
    private View f637h;

    /* renamed from: i */
    private View f638i;

    /* renamed from: j */
    private int f639j;

    /* renamed from: k */
    private int f640k;

    /* renamed from: l */
    private int f641l;

    /* renamed from: m */
    private int f642m;

    /* renamed from: n */
    private int f643n;

    /* renamed from: o */
    private final Rect f644o;

    /* renamed from: p */
    private boolean f645p;

    /* renamed from: q */
    private boolean f646q;

    /* renamed from: r */
    private Drawable f647r;

    /* renamed from: s */
    private int f648s;

    /* renamed from: t */
    private boolean f649t;

    /* renamed from: u */
    private C0292s f650u;

    /* renamed from: v */
    private long f651v;

    /* renamed from: w */
    private int f652w;

    /* renamed from: x */
    private AppBarLayout.C0192b f653x;

    public CollapsingToolbarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f634e = true;
        this.f644o = new Rect();
        this.f652w = -1;
        C0291r.m1597a(context);
        this.f630a = new C0261d(this);
        this.f630a.mo1222a(C0255a.f903e);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout, i, R.style.Widget_Design_CollapsingToolbar);
        this.f630a.mo1217a(obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.f630a.mo1227b(obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f643n = dimensionPixelSize;
        this.f642m = dimensionPixelSize;
        this.f641l = dimensionPixelSize;
        this.f640k = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f640k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.f642m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.f641l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.f643n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.f645p = obtainStyledAttributes.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(obtainStyledAttributes.getText(R.styleable.CollapsingToolbarLayout_title));
        this.f630a.mo1236d(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.f630a.mo1233c(C0555R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.f630a.mo1236d(obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.f630a.mo1233c(obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.f652w = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.f651v = (long) obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(obtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        this.f635f = obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return CollapsingToolbarLayout.this.mo802a(windowInsetsCompat);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) parent));
            if (this.f653x == null) {
                this.f653x = new C0203b();
            }
            ((AppBarLayout) parent).mo690a(this.f653x);
            ViewCompat.requestApplyInsets(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.f653x != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).mo693b(this.f653x);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public WindowInsetsCompat mo802a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = null;
        if (ViewCompat.getFitsSystemWindows(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        }
        if (!C0314z.m1695a((Object) this.f633d, (Object) windowInsetsCompat2)) {
            this.f633d = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        m1115c();
        if (this.f636g == null && this.f647r != null && this.f648s > 0) {
            this.f647r.mutate().setAlpha(this.f648s);
            this.f647r.draw(canvas);
        }
        if (this.f645p && this.f646q) {
            this.f630a.mo1220a(canvas);
        }
        if (this.f631b != null && this.f648s > 0) {
            int systemWindowInsetTop = this.f633d != null ? this.f633d.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.f631b.setBounds(0, -this.f632c, getWidth(), systemWindowInsetTop - this.f632c);
                this.f631b.mutate().setAlpha(this.f648s);
                this.f631b.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        if (this.f647r == null || this.f648s <= 0 || !m1116c(view)) {
            return drawChild;
        }
        this.f647r.mutate().setAlpha(this.f648s);
        this.f647r.draw(canvas);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f647r != null) {
            this.f647r.setBounds(0, 0, i, i2);
        }
    }

    /* renamed from: c */
    private void m1115c() {
        Toolbar toolbar;
        if (this.f634e) {
            this.f636g = null;
            this.f637h = null;
            if (this.f635f != -1) {
                this.f636g = (Toolbar) findViewById(this.f635f);
                if (this.f636g != null) {
                    this.f637h = m1117d(this.f636g);
                }
            }
            if (this.f636g == null) {
                int childCount = getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        toolbar = null;
                        break;
                    }
                    View childAt = getChildAt(i);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i++;
                }
                this.f636g = toolbar;
            }
            m1118d();
            this.f634e = false;
        }
    }

    /* renamed from: c */
    private boolean m1116c(View view) {
        return this.f639j >= 0 && this.f639j == indexOfChild(view) + 1;
    }

    /* renamed from: d */
    private View m1117d(View view) {
        ViewParent parent = view.getParent();
        View view2 = view;
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view2 = (View) parent;
            }
            parent = parent.getParent();
        }
        return view2;
    }

    /* renamed from: d */
    private void m1118d() {
        if (!this.f645p && this.f638i != null) {
            ViewParent parent = this.f638i.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f638i);
            }
        }
        if (this.f645p && this.f636g != null) {
            if (this.f638i == null) {
                this.f638i = new View(getContext());
            }
            if (this.f638i.getParent() == null) {
                this.f636g.addView(this.f638i, -1, -1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        m1115c();
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int titleMarginStart;
        int titleMarginEnd;
        int i5;
        boolean z2 = true;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f633d != null) {
            int systemWindowInsetTop = this.f633d.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        if (this.f645p && this.f638i != null) {
            this.f646q = ViewCompat.isAttachedToWindow(this.f638i) && this.f638i.getVisibility() == 0;
            if (this.f646q) {
                if (ViewCompat.getLayoutDirection(this) != 1) {
                    z2 = false;
                }
                int b = mo805b(this.f637h != null ? this.f637h : this.f636g);
                C0307v.m1677b(this, this.f638i, this.f644o);
                C0261d dVar = this.f630a;
                int i7 = this.f644o.left;
                if (z2) {
                    titleMarginStart = this.f636g.getTitleMarginEnd();
                } else {
                    titleMarginStart = this.f636g.getTitleMarginStart();
                }
                int i8 = i7 + titleMarginStart;
                int titleMarginTop = this.f636g.getTitleMarginTop() + this.f644o.top + b;
                int i9 = this.f644o.right;
                if (z2) {
                    titleMarginEnd = this.f636g.getTitleMarginStart();
                } else {
                    titleMarginEnd = this.f636g.getTitleMarginEnd();
                }
                dVar.mo1228b(i8, titleMarginTop, titleMarginEnd + i9, (b + this.f644o.bottom) - this.f636g.getTitleMarginBottom());
                C0261d dVar2 = this.f630a;
                int i10 = z2 ? this.f642m : this.f640k;
                int i11 = this.f644o.top + this.f641l;
                int i12 = i3 - i;
                if (z2) {
                    i5 = this.f640k;
                } else {
                    i5 = this.f642m;
                }
                dVar2.mo1218a(i10, i11, i12 - i5, (i4 - i2) - this.f643n);
                this.f630a.mo1241i();
            }
        }
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            m1113a(getChildAt(i13)).mo1360a();
        }
        if (this.f636g != null) {
            if (this.f645p && TextUtils.isEmpty(this.f630a.mo1242j())) {
                this.f630a.mo1223a(this.f636g.getTitle());
            }
            if (this.f637h == null || this.f637h == this) {
                setMinimumHeight(m1119e(this.f636g));
                this.f639j = indexOfChild(this.f636g);
            } else {
                setMinimumHeight(m1119e(this.f637h));
                this.f639j = indexOfChild(this.f637h);
            }
        } else {
            this.f639j = -1;
        }
        mo806b();
    }

    /* renamed from: e */
    private static int m1119e(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + view.getHeight() + marginLayoutParams.topMargin;
    }

    /* renamed from: a */
    static C0313y m1113a(View view) {
        C0313y yVar = (C0313y) view.getTag(R.id.view_offset_helper);
        if (yVar != null) {
            return yVar;
        }
        C0313y yVar2 = new C0313y(view);
        view.setTag(R.id.view_offset_helper, yVar2);
        return yVar2;
    }

    public void setTitle(CharSequence charSequence) {
        this.f630a.mo1223a(charSequence);
    }

    public CharSequence getTitle() {
        if (this.f645p) {
            return this.f630a.mo1242j();
        }
        return null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f645p) {
            this.f645p = z;
            m1118d();
            requestLayout();
        }
    }

    public void setScrimsShown(boolean z) {
        mo804a(z, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    /* renamed from: a */
    public void mo804a(boolean z, boolean z2) {
        int i = 255;
        if (this.f649t != z) {
            if (z2) {
                if (!z) {
                    i = 0;
                }
                m1114a(i);
            } else {
                if (!z) {
                    i = 0;
                }
                setScrimAlpha(i);
            }
            this.f649t = z;
        }
    }

    /* renamed from: a */
    private void m1114a(int i) {
        m1115c();
        if (this.f650u == null) {
            this.f650u = C0314z.m1694a();
            this.f650u.mo1320a(this.f651v);
            this.f650u.mo1323a(i > this.f648s ? C0255a.f901c : C0255a.f902d);
            this.f650u.mo1322a((C0292s.C0297c) new C0292s.C0297c() {
                /* renamed from: a */
                public void mo746a(C0292s sVar) {
                    CollapsingToolbarLayout.this.setScrimAlpha(sVar.mo1325c());
                }
            });
        } else if (this.f650u.mo1324b()) {
            this.f650u.mo1327e();
        }
        this.f650u.mo1319a(this.f648s, i);
        this.f650u.mo1317a();
    }

    /* access modifiers changed from: package-private */
    public void setScrimAlpha(int i) {
        if (i != this.f648s) {
            if (!(this.f647r == null || this.f636g == null)) {
                ViewCompat.postInvalidateOnAnimation(this.f636g);
            }
            this.f648s = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f647r != drawable) {
            if (this.f647r != null) {
                this.f647r.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f647r = drawable2;
            if (this.f647r != null) {
                this.f647r.setBounds(0, 0, getWidth(), getHeight());
                this.f647r.setCallback(this);
                this.f647r.setAlpha(this.f648s);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public Drawable getContentScrim() {
        return this.f647r;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f631b != drawable) {
            if (this.f631b != null) {
                this.f631b.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f631b = drawable2;
            if (this.f631b != null) {
                if (this.f631b.isStateful()) {
                    this.f631b.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.f631b, ViewCompat.getLayoutDirection(this));
                this.f631b.setVisible(getVisibility() == 0, false);
                this.f631b.setCallback(this);
                this.f631b.setAlpha(this.f648s);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        boolean z = false;
        Drawable drawable = this.f631b;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f647r;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (this.f630a != null) {
            z |= this.f630a.mo1224a(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f647r || drawable == this.f631b;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (!(this.f631b == null || this.f631b.isVisible() == z)) {
            this.f631b.setVisible(z, false);
        }
        if (this.f647r != null && this.f647r.isVisible() != z) {
            this.f647r.setVisible(z, false);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public Drawable getStatusBarScrim() {
        return this.f631b;
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.f630a.mo1233c(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f630a.mo1219a(colorStateList);
    }

    public void setCollapsedTitleGravity(int i) {
        this.f630a.mo1227b(i);
    }

    public int getCollapsedTitleGravity() {
        return this.f630a.mo1232c();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.f630a.mo1236d(i);
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f630a.mo1229b(colorStateList);
    }

    public void setExpandedTitleGravity(int i) {
        this.f630a.mo1217a(i);
    }

    public int getExpandedTitleGravity() {
        return this.f630a.mo1225b();
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f630a.mo1221a(typeface);
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f630a.mo1235d();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f630a.mo1230b(typeface);
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f630a.mo1237e();
    }

    public int getExpandedTitleMarginStart() {
        return this.f640k;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f640k = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.f641l;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.f641l = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.f642m;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.f642m = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f643n;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.f643n = i;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.f652w != i) {
            this.f652w = i;
            mo806b();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        if (this.f652w >= 0) {
            return this.f652w;
        }
        int systemWindowInsetTop = this.f633d != null ? this.f633d.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min(systemWindowInsetTop + (minimumHeight * 2), getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j) {
        this.f651v = j;
    }

    public long getScrimAnimationDuration() {
        return this.f651v;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0202a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0202a generateDefaultLayoutParams() {
        return new C0202a(-1, -1);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0202a(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0202a(layoutParams);
    }

    /* renamed from: android.support.design.widget.CollapsingToolbarLayout$a */
    public static class C0202a extends FrameLayout.LayoutParams {

        /* renamed from: a */
        int f656a = 0;

        /* renamed from: b */
        float f657b = 0.5f;

        public C0202a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.f656a = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            mo860a(obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public C0202a(int i, int i2) {
            super(i, i2);
        }

        public C0202a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: a */
        public void mo860a(float f) {
            this.f657b = f;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo806b() {
        if (this.f647r != null || this.f631b != null) {
            setScrimsShown(getHeight() + this.f632c < getScrimVisibleHeightTrigger());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final int mo805b(View view) {
        return ((getHeight() - m1113a(view).mo1364c()) - view.getHeight()) - ((C0202a) view.getLayoutParams()).bottomMargin;
    }

    /* renamed from: android.support.design.widget.CollapsingToolbarLayout$b */
    private class C0203b implements AppBarLayout.C0192b {
        C0203b() {
        }

        /* renamed from: a */
        public void mo761a(AppBarLayout appBarLayout, int i) {
            int i2;
            CollapsingToolbarLayout.this.f632c = i;
            if (CollapsingToolbarLayout.this.f633d != null) {
                i2 = CollapsingToolbarLayout.this.f633d.getSystemWindowInsetTop();
            } else {
                i2 = 0;
            }
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                C0202a aVar = (C0202a) childAt.getLayoutParams();
                C0313y a = CollapsingToolbarLayout.m1113a(childAt);
                switch (aVar.f656a) {
                    case 1:
                        a.mo1361a(C0281m.m1558a(-i, 0, CollapsingToolbarLayout.this.mo805b(childAt)));
                        break;
                    case 2:
                        a.mo1361a(Math.round(aVar.f657b * ((float) (-i))));
                        break;
                }
            }
            CollapsingToolbarLayout.this.mo806b();
            if (CollapsingToolbarLayout.this.f631b != null && i2 > 0) {
                ViewCompat.postInvalidateOnAnimation(CollapsingToolbarLayout.this);
            }
            CollapsingToolbarLayout.this.f630a.mo1226b(((float) Math.abs(i)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - i2)));
        }
    }
}
