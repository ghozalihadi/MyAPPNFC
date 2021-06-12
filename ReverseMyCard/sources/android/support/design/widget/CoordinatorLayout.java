package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.design.R;
import android.support.p016v4.content.ContextCompat;
import android.support.p016v4.graphics.drawable.DrawableCompat;
import android.support.p016v4.p018os.ParcelableCompat;
import android.support.p016v4.p018os.ParcelableCompatCreatorCallbacks;
import android.support.p016v4.view.AbsSavedState;
import android.support.p016v4.view.GravityCompat;
import android.support.p016v4.view.MotionEventCompat;
import android.support.p016v4.view.NestedScrollingParent;
import android.support.p016v4.view.NestedScrollingParentHelper;
import android.support.p016v4.view.OnApplyWindowInsetsListener;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.view.WindowInsetsCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent {

    /* renamed from: a */
    static final String f659a;

    /* renamed from: b */
    static final Class<?>[] f660b = {Context.class, AttributeSet.class};

    /* renamed from: c */
    static final ThreadLocal<Map<String, Constructor<C0206a>>> f661c = new ThreadLocal<>();

    /* renamed from: d */
    static final Comparator<View> f662d;

    /* renamed from: A */
    private OnApplyWindowInsetsListener f663A;

    /* renamed from: B */
    private final NestedScrollingParentHelper f664B;

    /* renamed from: e */
    ViewGroup.OnHierarchyChangeListener f665e;

    /* renamed from: f */
    private final List<View> f666f;

    /* renamed from: g */
    private final C0262e<View> f667g;

    /* renamed from: h */
    private final List<View> f668h;

    /* renamed from: i */
    private final List<View> f669i;

    /* renamed from: j */
    private final Rect f670j;

    /* renamed from: k */
    private final Rect f671k;

    /* renamed from: l */
    private final Rect f672l;

    /* renamed from: m */
    private final Rect f673m;

    /* renamed from: n */
    private final int[] f674n;

    /* renamed from: o */
    private Paint f675o;

    /* renamed from: p */
    private boolean f676p;

    /* renamed from: q */
    private boolean f677q;

    /* renamed from: r */
    private int[] f678r;

    /* renamed from: s */
    private View f679s;

    /* renamed from: t */
    private View f680t;

    /* renamed from: u */
    private View f681u;

    /* renamed from: v */
    private C0210e f682v;

    /* renamed from: w */
    private boolean f683w;

    /* renamed from: x */
    private WindowInsetsCompat f684x;

    /* renamed from: y */
    private boolean f685y;

    /* renamed from: z */
    private Drawable f686z;

    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: android.support.design.widget.CoordinatorLayout$b */
    public @interface C0207b {
        /* renamed from: a */
        Class<? extends C0206a> mo930a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r1 = 0
            java.lang.Class<android.support.design.widget.CoordinatorLayout> r0 = android.support.design.widget.CoordinatorLayout.class
            java.lang.Package r0 = r0.getPackage()
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = r0.getName()
        L_0x000d:
            f659a = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r0 < r2) goto L_0x0035
            android.support.design.widget.CoordinatorLayout$f r0 = new android.support.design.widget.CoordinatorLayout$f
            r0.<init>()
            f662d = r0
        L_0x001c:
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r0[r1] = r2
            f660b = r0
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            f661c = r0
            return
        L_0x0033:
            r0 = r1
            goto L_0x000d
        L_0x0035:
            f662d = r1
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.<clinit>():void");
    }

    public CoordinatorLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f666f = new ArrayList();
        this.f667g = new C0262e<>();
        this.f668h = new ArrayList();
        this.f669i = new ArrayList();
        this.f670j = new Rect();
        this.f671k = new Rect();
        this.f672l = new Rect();
        this.f673m = new Rect();
        this.f674n = new int[2];
        this.f664B = new NestedScrollingParentHelper(this);
        C0291r.m1597a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i, R.style.Widget_Design_CoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f678r = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f678r.length;
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr = this.f678r;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
            }
        }
        this.f686z = obtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        m1148g();
        super.setOnHierarchyChangeListener(new C0208c());
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f665e = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m1144e();
        if (this.f683w) {
            if (this.f682v == null) {
                this.f682v = new C0210e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f682v);
        }
        if (this.f684x == null && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
        this.f677q = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1144e();
        if (this.f683w && this.f682v != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f682v);
        }
        if (this.f681u != null) {
            onStopNestedScroll(this.f681u);
        }
        this.f677q = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f686z != drawable) {
            if (this.f686z != null) {
                this.f686z.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f686z = drawable2;
            if (this.f686z != null) {
                if (this.f686z.isStateful()) {
                    this.f686z.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.f686z, ViewCompat.getLayoutDirection(this));
                this.f686z.setVisible(getVisibility() == 0, false);
                this.f686z.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.f686z;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        boolean z = false;
        Drawable drawable = this.f686z;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f686z;
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f686z != null && this.f686z.isVisible() != z) {
            this.f686z.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? ContextCompat.getDrawable(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final WindowInsetsCompat mo864a(WindowInsetsCompat windowInsetsCompat) {
        boolean z = true;
        if (C0314z.m1695a((Object) this.f684x, (Object) windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.f684x = windowInsetsCompat;
        this.f685y = windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0;
        if (this.f685y || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        WindowInsetsCompat b = m1137b(windowInsetsCompat);
        requestLayout();
        return b;
    }

    /* access modifiers changed from: package-private */
    public final WindowInsetsCompat getLastWindowInsets() {
        return this.f684x;
    }

    /* renamed from: e */
    private void m1144e() {
        if (this.f679s != null) {
            C0206a b = ((C0209d) this.f679s.getLayoutParams()).mo939b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                b.mo782b(this, this.f679s, obtain);
                obtain.recycle();
            }
            this.f679s = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((C0209d) getChildAt(i).getLayoutParams()).mo945f();
        }
        this.f676p = false;
    }

    /* renamed from: a */
    private void m1134a(List<View> list) {
        int i;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            if (isChildrenDrawingOrderEnabled) {
                i = getChildDrawingOrder(childCount, i2);
            } else {
                i = i2;
            }
            list.add(getChildAt(i));
        }
        if (f662d != null) {
            Collections.sort(list, f662d);
        }
    }

    /* renamed from: a */
    private boolean m1135a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        MotionEvent motionEvent2;
        boolean z3 = false;
        boolean z4 = false;
        MotionEvent motionEvent3 = null;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        List<View> list = this.f668h;
        m1134a(list);
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                View view = list.get(i2);
                C0209d dVar = (C0209d) view.getLayoutParams();
                C0206a b = dVar.mo939b();
                if ((!z3 && !z4) || actionMasked == 0) {
                    if (!z3 && b != null) {
                        switch (i) {
                            case 0:
                                z3 = b.mo777a(this, view, motionEvent);
                                break;
                            case 1:
                                z3 = b.mo782b(this, view, motionEvent);
                                break;
                        }
                        if (z3) {
                            this.f679s = view;
                        }
                    }
                    z = z3;
                    boolean e = dVar.mo944e();
                    boolean a = dVar.mo937a(this, view);
                    boolean z5 = a && !e;
                    if (!a || z5) {
                        MotionEvent motionEvent4 = motionEvent3;
                        z2 = z5;
                        motionEvent2 = motionEvent4;
                    }
                } else if (b != null) {
                    if (motionEvent3 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    } else {
                        motionEvent2 = motionEvent3;
                    }
                    switch (i) {
                        case 0:
                            b.mo777a(this, view, motionEvent2);
                            break;
                        case 1:
                            b.mo782b(this, view, motionEvent2);
                            break;
                    }
                    z2 = z4;
                    z = z3;
                } else {
                    motionEvent2 = motionEvent3;
                    z = z3;
                    z2 = z4;
                }
                i2++;
                z4 = z2;
                z3 = z;
                motionEvent3 = motionEvent2;
            } else {
                z = z3;
            }
        }
        list.clear();
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            m1144e();
        }
        boolean a = m1135a(motionEvent, 0);
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (actionMasked == 1 || actionMasked == 3) {
            m1144e();
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
            r11 = this;
            r4 = 3
            r10 = 1
            r5 = 0
            r7 = 0
            r2 = 0
            int r9 = android.support.p016v4.view.MotionEventCompat.getActionMasked(r12)
            android.view.View r0 = r11.f679s
            if (r0 != 0) goto L_0x005d
            boolean r0 = r11.m1135a((android.view.MotionEvent) r12, (int) r10)
            if (r0 == 0) goto L_0x005a
            r1 = r0
        L_0x0014:
            android.view.View r0 = r11.f679s
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.support.design.widget.CoordinatorLayout$d r0 = (android.support.design.widget.CoordinatorLayout.C0209d) r0
            android.support.design.widget.CoordinatorLayout$a r0 = r0.mo939b()
            if (r0 == 0) goto L_0x0058
            android.view.View r3 = r11.f679s
            boolean r0 = r0.mo782b((android.support.design.widget.CoordinatorLayout) r11, r3, (android.view.MotionEvent) r12)
            r8 = r0
        L_0x0029:
            android.view.View r0 = r11.f679s
            if (r0 != 0) goto L_0x0043
            boolean r0 = super.onTouchEvent(r12)
            r8 = r8 | r0
        L_0x0032:
            if (r8 != 0) goto L_0x0036
            if (r9 != 0) goto L_0x0036
        L_0x0036:
            if (r2 == 0) goto L_0x003b
            r2.recycle()
        L_0x003b:
            if (r9 == r10) goto L_0x003f
            if (r9 != r4) goto L_0x0042
        L_0x003f:
            r11.m1144e()
        L_0x0042:
            return r8
        L_0x0043:
            if (r1 == 0) goto L_0x0032
            if (r2 != 0) goto L_0x0056
            long r0 = android.os.SystemClock.uptimeMillis()
            r2 = r0
            r6 = r5
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r0, r2, r4, r5, r6, r7)
        L_0x0051:
            super.onTouchEvent(r0)
            r2 = r0
            goto L_0x0032
        L_0x0056:
            r0 = r2
            goto L_0x0051
        L_0x0058:
            r8 = r7
            goto L_0x0029
        L_0x005a:
            r1 = r0
            r8 = r7
            goto L_0x0029
        L_0x005d:
            r1 = r7
            goto L_0x0014
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.f676p) {
            m1144e();
            this.f676p = true;
        }
    }

    /* renamed from: b */
    private int m1136b(int i) {
        if (this.f678r == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.f678r.length) {
            return this.f678r[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    /* renamed from: a */
    static C0206a m1129a(Context context, AttributeSet attributeSet, String str) {
        HashMap hashMap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f659a)) {
            str = f659a + '.' + str;
        }
        try {
            Map map = f661c.get();
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                f661c.set(hashMap2);
                hashMap = hashMap2;
            } else {
                hashMap = map;
            }
            Constructor<?> constructor = (Constructor) hashMap.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(f660b);
                constructor.setAccessible(true);
                hashMap.put(str, constructor);
            }
            return (C0206a) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0209d mo862a(View view) {
        C0209d dVar = (C0209d) view.getLayoutParams();
        if (!dVar.f691b) {
            C0207b bVar = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                bVar = (C0207b) cls.getAnnotation(C0207b.class);
                if (bVar != null) {
                    break;
                }
            }
            C0207b bVar2 = bVar;
            if (bVar2 != null) {
                try {
                    dVar.mo935a((C0206a) bVar2.mo930a().newInstance());
                } catch (Exception e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + bVar2.mo930a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            dVar.f691b = true;
        }
        return dVar;
    }

    /* renamed from: f */
    private void m1147f() {
        this.f666f.clear();
        this.f667g.mo1244a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            mo862a(childAt).mo940b(this, childAt);
            this.f667g.mo1245a(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (mo862a(childAt2).mo938a(this, childAt2, childAt)) {
                        if (!this.f667g.mo1248b(childAt2)) {
                            this.f667g.mo1245a(childAt2);
                        }
                        this.f667g.mo1246a(childAt, childAt2);
                    }
                }
            }
        }
        this.f666f.addAll(this.f667g.mo1247b());
        Collections.reverse(this.f666f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo870a(View view, Rect rect) {
        C0307v.m1677b(this, view, rect);
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* renamed from: a */
    public void mo868a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z;
        boolean z2;
        int i3;
        int i4;
        m1147f();
        mo865a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 1) {
            z = true;
        } else {
            z = false;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i5 = paddingLeft + paddingRight;
        int i6 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (this.f684x == null || !ViewCompat.getFitsSystemWindows(this)) {
            z2 = false;
        } else {
            z2 = true;
        }
        int size3 = this.f666f.size();
        int i7 = 0;
        int i8 = 0;
        int i9 = suggestedMinimumHeight;
        int i10 = suggestedMinimumWidth;
        while (i7 < size3) {
            View view = this.f666f.get(i7);
            C0209d dVar = (C0209d) view.getLayoutParams();
            int i11 = 0;
            if (dVar.f694e >= 0 && mode != 0) {
                int b = m1136b(dVar.f694e);
                int absoluteGravity = GravityCompat.getAbsoluteGravity(m1141d(dVar.f692c), layoutDirection) & 7;
                if ((absoluteGravity == 3 && !z) || (absoluteGravity == 5 && z)) {
                    i11 = Math.max(0, (size - paddingRight) - b);
                } else if ((absoluteGravity == 5 && !z) || (absoluteGravity == 3 && z)) {
                    i11 = Math.max(0, b - paddingLeft);
                }
            }
            if (!z2 || ViewCompat.getFitsSystemWindows(view)) {
                i3 = i2;
                i4 = i;
            } else {
                int systemWindowInsetLeft = this.f684x.getSystemWindowInsetLeft() + this.f684x.getSystemWindowInsetRight();
                int systemWindowInsetTop = this.f684x.getSystemWindowInsetTop() + this.f684x.getSystemWindowInsetBottom();
                i4 = View.MeasureSpec.makeMeasureSpec(size - systemWindowInsetLeft, mode);
                i3 = View.MeasureSpec.makeMeasureSpec(size2 - systemWindowInsetTop, mode2);
            }
            C0206a b2 = dVar.mo939b();
            if (b2 == null || !b2.mo736a(this, view, i4, i11, i3, 0)) {
                mo868a(view, i4, i11, i3, 0);
            }
            int max = Math.max(i10, view.getMeasuredWidth() + i5 + dVar.leftMargin + dVar.rightMargin);
            int max2 = Math.max(i9, view.getMeasuredHeight() + i6 + dVar.topMargin + dVar.bottomMargin);
            i7++;
            i8 = ViewCompat.combineMeasuredStates(i8, ViewCompat.getMeasuredState(view));
            i9 = max2;
            i10 = max;
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(i10, i, -16777216 & i8), ViewCompat.resolveSizeAndState(i9, i2, i8 << 16));
    }

    /* renamed from: b */
    private WindowInsetsCompat m1137b(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        C0206a b;
        if (windowInsetsCompat.isConsumed()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        int i = 0;
        WindowInsetsCompat windowInsetsCompat3 = windowInsetsCompat;
        while (true) {
            if (i >= childCount) {
                windowInsetsCompat2 = windowInsetsCompat3;
                break;
            }
            View childAt = getChildAt(i);
            if (!ViewCompat.getFitsSystemWindows(childAt) || (b = ((C0209d) childAt.getLayoutParams()).mo939b()) == null) {
                windowInsetsCompat2 = windowInsetsCompat3;
            } else {
                windowInsetsCompat2 = b.mo921a(this, childAt, windowInsetsCompat3);
                if (windowInsetsCompat2.isConsumed()) {
                    break;
                }
            }
            i++;
            windowInsetsCompat3 = windowInsetsCompat2;
        }
        return windowInsetsCompat2;
    }

    /* renamed from: a */
    public void mo867a(View view, int i) {
        C0209d dVar = (C0209d) view.getLayoutParams();
        if (dVar.mo943d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (dVar.f700k != null) {
            m1133a(view, dVar.f700k, i);
        } else if (dVar.f694e >= 0) {
            m1138b(view, dVar.f694e, i);
        } else {
            m1140c(view, i);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.f666f.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.f666f.get(i5);
            C0206a b = ((C0209d) view.getLayoutParams()).mo939b();
            if (b == null || !b.mo735a(this, view, layoutDirection)) {
                mo867a(view, layoutDirection);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f685y && this.f686z != null) {
            int systemWindowInsetTop = this.f684x != null ? this.f684x.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.f686z.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.f686z.draw(canvas);
            }
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        m1148g();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo876b(View view, Rect rect) {
        ((C0209d) view.getLayoutParams()).mo934a(rect);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo879c(View view, Rect rect) {
        rect.set(((C0209d) view.getLayoutParams()).mo942c());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo871a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            mo870a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: a */
    private void m1131a(View view, int i, Rect rect, Rect rect2, C0209d dVar, int i2, int i3) {
        int width;
        int height;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(m1143e(dVar.f692c), i);
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(m1139c(dVar.f693d), i);
        int i4 = absoluteGravity & 7;
        int i5 = absoluteGravity & 112;
        int i6 = absoluteGravity2 & 112;
        switch (absoluteGravity2 & 7) {
            case 1:
                width = (rect.width() / 2) + rect.left;
                break;
            case 5:
                width = rect.right;
                break;
            default:
                width = rect.left;
                break;
        }
        switch (i6) {
            case 16:
                height = rect.top + (rect.height() / 2);
                break;
            case 80:
                height = rect.bottom;
                break;
            default:
                height = rect.top;
                break;
        }
        switch (i4) {
            case 1:
                width -= i2 / 2;
                break;
            case 5:
                break;
            default:
                width -= i2;
                break;
        }
        switch (i5) {
            case 16:
                height -= i3 / 2;
                break;
            case 80:
                break;
            default:
                height -= i3;
                break;
        }
        rect2.set(width, height, width + i2, height + i3);
    }

    /* renamed from: a */
    private void m1130a(C0209d dVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - dVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + dVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - dVar.bottomMargin));
        rect.set(max, max2, max + i, max2 + i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo869a(View view, int i, Rect rect, Rect rect2) {
        C0209d dVar = (C0209d) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        m1131a(view, i, rect, rect2, dVar, measuredWidth, measuredHeight);
        m1130a(dVar, rect2, measuredWidth, measuredHeight);
    }

    /* renamed from: a */
    private void m1133a(View view, View view2, int i) {
        C0209d dVar = (C0209d) view.getLayoutParams();
        Rect rect = this.f670j;
        Rect rect2 = this.f671k;
        mo870a(view2, rect);
        mo869a(view, i, rect, rect2);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    /* renamed from: b */
    private void m1138b(View view, int i, int i2) {
        C0209d dVar = (C0209d) view.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(m1141d(dVar.f692c), i2);
        int i3 = absoluteGravity & 7;
        int i4 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int b = m1136b(i) - measuredWidth;
        int i5 = 0;
        switch (i3) {
            case 1:
                b += measuredWidth / 2;
                break;
            case 5:
                b += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                i5 = 0 + (measuredHeight / 2);
                break;
            case 80:
                i5 = 0 + measuredHeight;
                break;
        }
        int max = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(b, ((width - getPaddingRight()) - measuredWidth) - dVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + dVar.topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - dVar.bottomMargin));
        view.layout(max, max2, max + measuredWidth, max2 + measuredHeight);
    }

    /* renamed from: c */
    private void m1140c(View view, int i) {
        C0209d dVar = (C0209d) view.getLayoutParams();
        Rect rect = this.f670j;
        rect.set(getPaddingLeft() + dVar.leftMargin, getPaddingTop() + dVar.topMargin, (getWidth() - getPaddingRight()) - dVar.rightMargin, (getHeight() - getPaddingBottom()) - dVar.bottomMargin);
        if (this.f684x != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view)) {
            rect.left += this.f684x.getSystemWindowInsetLeft();
            rect.top += this.f684x.getSystemWindowInsetTop();
            rect.right -= this.f684x.getSystemWindowInsetRight();
            rect.bottom -= this.f684x.getSystemWindowInsetBottom();
        }
        Rect rect2 = this.f671k;
        GravityCompat.apply(m1139c(dVar.f692c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    /* renamed from: c */
    private static int m1139c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    /* renamed from: d */
    private static int m1141d(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    /* renamed from: e */
    private static int m1143e(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        C0209d dVar = (C0209d) view.getLayoutParams();
        if (dVar.f690a != null) {
            float d = dVar.f690a.mo927d(this, view);
            if (d > 0.0f) {
                if (this.f675o == null) {
                    this.f675o = new Paint();
                }
                this.f675o.setColor(dVar.f690a.mo925c(this, view));
                this.f675o.setAlpha(C0281m.m1558a(Math.round(d * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f675o);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo866a(int i) {
        boolean z;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.f666f.size();
        Rect rect = this.f673m;
        rect.setEmpty();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f666f.get(i2);
            C0209d dVar = (C0209d) view.getLayoutParams();
            for (int i3 = 0; i3 < i2; i3++) {
                if (dVar.f701l == this.f666f.get(i3)) {
                    mo875b(view, layoutDirection);
                }
            }
            Rect rect2 = this.f670j;
            mo871a(view, true, rect2);
            if (dVar.f696g != 0 && !rect2.isEmpty()) {
                int absoluteGravity = GravityCompat.getAbsoluteGravity(dVar.f696g, layoutDirection);
                switch (absoluteGravity & 112) {
                    case 48:
                        rect.top = Math.max(rect.top, rect2.bottom);
                        break;
                    case 80:
                        rect.bottom = Math.max(rect.bottom, getHeight() - rect2.top);
                        break;
                }
                switch (absoluteGravity & 7) {
                    case 3:
                        rect.left = Math.max(rect.left, rect2.right);
                        break;
                    case 5:
                        rect.right = Math.max(rect.right, getWidth() - rect2.left);
                        break;
                }
            }
            if (dVar.f697h != 0 && view.getVisibility() == 0) {
                m1132a(view, rect, layoutDirection);
            }
            if (i == 0) {
                Rect rect3 = this.f671k;
                mo879c(view, rect3);
                if (rect3.equals(rect2)) {
                } else {
                    mo876b(view, rect2);
                }
            }
            for (int i4 = i2 + 1; i4 < size; i4++) {
                View view2 = this.f666f.get(i4);
                C0209d dVar2 = (C0209d) view2.getLayoutParams();
                C0206a b = dVar2.mo939b();
                if (b != null && b.mo756b(this, view2, view)) {
                    if (i != 0 || !dVar2.mo948i()) {
                        switch (i) {
                            case 2:
                                b.mo928d(this, view2, view);
                                z = true;
                                break;
                            default:
                                z = b.mo757c(this, view2, view);
                                break;
                        }
                        if (i == 1) {
                            dVar2.mo941b(z);
                        }
                    } else {
                        dVar2.mo949j();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m1132a(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        int width;
        int i2;
        int height;
        int i3;
        if (ViewCompat.isLaidOut(view)) {
            C0209d dVar = (C0209d) view.getLayoutParams();
            int absoluteGravity = GravityCompat.getAbsoluteGravity(dVar.f697h, i);
            C0206a b = dVar.mo939b();
            Rect rect2 = this.f672l;
            if (b == null || !b.mo923a(this, view, rect2)) {
                rect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else if (!rect2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                throw new IllegalArgumentException("Rect should intersect with child's bounds.");
            }
            if (!rect2.isEmpty()) {
                if ((absoluteGravity & 48) != 48 || (i3 = (rect2.top - dVar.topMargin) - dVar.f699j) >= rect.top) {
                    z = false;
                } else {
                    m1145e(view, rect.top - i3);
                    z = true;
                }
                if ((absoluteGravity & 80) == 80 && (height = ((getHeight() - rect2.bottom) - dVar.bottomMargin) + dVar.f699j) < rect.bottom) {
                    m1145e(view, height - rect.bottom);
                    z = true;
                }
                if (!z) {
                    m1145e(view, 0);
                }
                if ((absoluteGravity & 3) != 3 || (i2 = (rect2.left - dVar.leftMargin) - dVar.f698i) >= rect.left) {
                    z2 = false;
                } else {
                    m1142d(view, rect.left - i2);
                    z2 = true;
                }
                if ((absoluteGravity & 5) != 5 || (width = dVar.f698i + ((getWidth() - rect2.right) - dVar.rightMargin)) >= rect.right) {
                    z3 = z2;
                } else {
                    m1142d(view, width - rect.right);
                    z3 = true;
                }
                if (!z3) {
                    m1142d(view, 0);
                }
            }
        }
    }

    /* renamed from: d */
    private void m1142d(View view, int i) {
        C0209d dVar = (C0209d) view.getLayoutParams();
        if (dVar.f698i != i) {
            ViewCompat.offsetLeftAndRight(view, i - dVar.f698i);
            dVar.f698i = i;
        }
    }

    /* renamed from: e */
    private void m1145e(View view, int i) {
        C0209d dVar = (C0209d) view.getLayoutParams();
        if (dVar.f699j != i) {
            ViewCompat.offsetTopAndBottom(view, i - dVar.f699j);
            dVar.f699j = i;
        }
    }

    /* renamed from: b */
    public void mo874b(View view) {
        List c = this.f667g.mo1249c(view);
        if (c != null && !c.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < c.size()) {
                    View view2 = (View) c.get(i2);
                    C0206a b = ((C0209d) view2.getLayoutParams()).mo939b();
                    if (b != null) {
                        b.mo757c(this, view2, view);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    public List<View> mo877c(View view) {
        List d = this.f667g.mo1250d(view);
        this.f669i.clear();
        if (d != null) {
            this.f669i.addAll(d);
        }
        return this.f669i;
    }

    /* renamed from: d */
    public List<View> mo882d(View view) {
        List c = this.f667g.mo1249c(view);
        this.f669i.clear();
        if (c != null) {
            this.f669i.addAll(c);
        }
        return this.f669i;
    }

    /* access modifiers changed from: package-private */
    public final List<View> getDependencySortedChildren() {
        m1147f();
        return Collections.unmodifiableList(this.f666f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo865a() {
        boolean z = false;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (m1146e(getChildAt(i))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z == this.f683w) {
            return;
        }
        if (z) {
            mo873b();
        } else {
            mo878c();
        }
    }

    /* renamed from: e */
    private boolean m1146e(View view) {
        return this.f667g.mo1251e(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo873b() {
        if (this.f677q) {
            if (this.f682v == null) {
                this.f682v = new C0210e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f682v);
        }
        this.f683w = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo878c() {
        if (this.f677q && this.f682v != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f682v);
        }
        this.f683w = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo875b(View view, int i) {
        C0206a b;
        C0209d dVar = (C0209d) view.getLayoutParams();
        if (dVar.f700k != null) {
            Rect rect = this.f670j;
            Rect rect2 = this.f671k;
            Rect rect3 = this.f672l;
            mo870a(dVar.f700k, rect);
            mo871a(view, false, rect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            m1131a(view, i, rect, rect3, dVar, measuredWidth, measuredHeight);
            boolean z = (rect3.left == rect2.left && rect3.top == rect2.top) ? false : true;
            m1130a(dVar, rect3, measuredWidth, measuredHeight);
            int i2 = rect3.left - rect2.left;
            int i3 = rect3.top - rect2.top;
            if (i2 != 0) {
                ViewCompat.offsetLeftAndRight(view, i2);
            }
            if (i3 != 0) {
                ViewCompat.offsetTopAndBottom(view, i3);
            }
            if (z && (b = dVar.mo939b()) != null) {
                b.mo757c(this, view, dVar.f700k);
            }
        }
    }

    /* renamed from: a */
    public boolean mo872a(View view, int i, int i2) {
        Rect rect = this.f670j;
        mo870a(view, rect);
        return rect.contains(i, i2);
    }

    /* renamed from: a */
    public C0209d generateLayoutParams(AttributeSet attributeSet) {
        return new C0209d(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0209d generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0209d) {
            return new C0209d((C0209d) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0209d((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0209d(layoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C0209d generateDefaultLayoutParams() {
        return new C0209d(-2, -2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0209d) && super.checkLayoutParams(layoutParams);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        boolean z;
        int childCount = getChildCount();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            C0209d dVar = (C0209d) childAt.getLayoutParams();
            C0206a b = dVar.mo939b();
            if (b != null) {
                boolean a = b.mo738a(this, childAt, view, view2, i);
                z = z2 | a;
                dVar.mo936a(a);
            } else {
                dVar.mo936a(false);
                z = z2;
            }
            i2++;
            z2 = z;
        }
        return z2;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        C0206a b;
        this.f664B.onNestedScrollAccepted(view, view2, i);
        this.f680t = view;
        this.f681u = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0209d dVar = (C0209d) childAt.getLayoutParams();
            if (dVar.mo947h() && (b = dVar.mo939b()) != null) {
                b.mo924b(this, childAt, view, view2, i);
            }
        }
    }

    public void onStopNestedScroll(View view) {
        this.f664B.onStopNestedScroll(view);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0209d dVar = (C0209d) childAt.getLayoutParams();
            if (dVar.mo947h()) {
                C0206a b = dVar.mo939b();
                if (b != null) {
                    b.mo726a(this, childAt, view);
                }
                dVar.mo946g();
                dVar.mo949j();
            }
        }
        this.f680t = null;
        this.f681u = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int childCount = getChildCount();
        boolean z2 = false;
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            C0209d dVar = (C0209d) childAt.getLayoutParams();
            if (!dVar.mo947h()) {
                z = z2;
            } else {
                C0206a b = dVar.mo939b();
                if (b != null) {
                    b.mo727a(this, childAt, view, i, i2, i3, i4);
                    z = true;
                } else {
                    z = z2;
                }
            }
            i5++;
            z2 = z;
        }
        if (z2) {
            mo866a(1);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        boolean z;
        int i3;
        int i4;
        int min;
        int i5 = 0;
        int i6 = 0;
        boolean z2 = false;
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            C0209d dVar = (C0209d) childAt.getLayoutParams();
            if (!dVar.mo947h()) {
                z = z2;
                i3 = i5;
                i4 = i6;
            } else {
                C0206a b = dVar.mo939b();
                if (b != null) {
                    int[] iArr2 = this.f674n;
                    this.f674n[1] = 0;
                    iArr2[0] = 0;
                    b.mo728a(this, childAt, view, i, i2, this.f674n);
                    if (i > 0) {
                        i3 = Math.max(i5, this.f674n[0]);
                    } else {
                        i3 = Math.min(i5, this.f674n[0]);
                    }
                    if (i2 > 0) {
                        min = Math.max(i6, this.f674n[1]);
                    } else {
                        min = Math.min(i6, this.f674n[1]);
                    }
                    i4 = min;
                    z = true;
                } else {
                    z = z2;
                    i3 = i5;
                    i4 = i6;
                }
            }
            i7++;
            i6 = i4;
            i5 = i3;
            z2 = z;
        }
        iArr[0] = i5;
        iArr[1] = i6;
        if (z2) {
            mo866a(1);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean z2;
        int childCount = getChildCount();
        int i = 0;
        boolean z3 = false;
        while (i < childCount) {
            View childAt = getChildAt(i);
            C0209d dVar = (C0209d) childAt.getLayoutParams();
            if (!dVar.mo947h()) {
                z2 = z3;
            } else {
                C0206a b = dVar.mo939b();
                if (b != null) {
                    z2 = b.mo737a(this, childAt, view, f, f2, z) | z3;
                } else {
                    z2 = z3;
                }
            }
            i++;
            z3 = z2;
        }
        if (z3) {
            mo866a(1);
        }
        return z3;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        boolean z;
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            View childAt = getChildAt(i);
            C0209d dVar = (C0209d) childAt.getLayoutParams();
            if (!dVar.mo947h()) {
                z = z2;
            } else {
                C0206a b = dVar.mo939b();
                if (b != null) {
                    z = b.mo778a(this, childAt, view, f, f2) | z2;
                } else {
                    z = z2;
                }
            }
            i++;
            z2 = z;
        }
        return z2;
    }

    public int getNestedScrollAxes() {
        return this.f664B.getNestedScrollAxes();
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$e */
    class C0210e implements ViewTreeObserver.OnPreDrawListener {
        C0210e() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.mo866a(0);
            return true;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$f */
    static class C0211f implements Comparator<View> {
        C0211f() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            float z = ViewCompat.getZ(view);
            float z2 = ViewCompat.getZ(view2);
            if (z > z2) {
                return -1;
            }
            if (z < z2) {
                return 1;
            }
            return 0;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$a */
    public static abstract class C0206a<V extends View> {
        public C0206a() {
        }

        public C0206a(Context context, AttributeSet attributeSet) {
        }

        /* renamed from: a */
        public void mo922a(C0209d dVar) {
        }

        /* renamed from: c */
        public void mo926c() {
        }

        /* renamed from: a */
        public boolean mo777a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: b */
        public boolean mo782b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: c */
        public int mo925c(CoordinatorLayout coordinatorLayout, V v) {
            return ViewCompat.MEASURED_STATE_MASK;
        }

        /* renamed from: d */
        public float mo927d(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        /* renamed from: e */
        public boolean mo929e(CoordinatorLayout coordinatorLayout, V v) {
            return mo927d(coordinatorLayout, v) > 0.0f;
        }

        /* renamed from: b */
        public boolean mo756b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        /* renamed from: c */
        public boolean mo757c(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        /* renamed from: d */
        public void mo928d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        /* renamed from: a */
        public boolean mo736a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        /* renamed from: a */
        public boolean mo735a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        /* renamed from: a */
        public boolean mo738a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        /* renamed from: b */
        public void mo924b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        /* renamed from: a */
        public void mo726a(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        /* renamed from: a */
        public void mo727a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        /* renamed from: a */
        public void mo728a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        /* renamed from: a */
        public boolean mo737a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        /* renamed from: a */
        public boolean mo778a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        /* renamed from: a */
        public WindowInsetsCompat mo921a(CoordinatorLayout coordinatorLayout, V v, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        /* renamed from: a */
        public boolean mo753a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        /* renamed from: a */
        public void mo725a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        /* renamed from: b */
        public Parcelable mo743b(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        /* renamed from: a */
        public boolean mo923a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$d */
    public static class C0209d extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        C0206a f690a;

        /* renamed from: b */
        boolean f691b = false;

        /* renamed from: c */
        public int f692c = 0;

        /* renamed from: d */
        public int f693d = 0;

        /* renamed from: e */
        public int f694e = -1;

        /* renamed from: f */
        int f695f = -1;

        /* renamed from: g */
        public int f696g = 0;

        /* renamed from: h */
        public int f697h = 0;

        /* renamed from: i */
        int f698i;

        /* renamed from: j */
        int f699j;

        /* renamed from: k */
        View f700k;

        /* renamed from: l */
        View f701l;

        /* renamed from: m */
        final Rect f702m = new Rect();

        /* renamed from: n */
        Object f703n;

        /* renamed from: o */
        private boolean f704o;

        /* renamed from: p */
        private boolean f705p;

        /* renamed from: q */
        private boolean f706q;

        public C0209d(int i, int i2) {
            super(i, i2);
        }

        C0209d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f692c = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f695f = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f693d = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f694e = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f696g = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f697h = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f691b = obtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            if (this.f691b) {
                this.f690a = CoordinatorLayout.m1129a(context, attributeSet, obtainStyledAttributes.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            if (this.f690a != null) {
                this.f690a.mo922a(this);
            }
        }

        public C0209d(C0209d dVar) {
            super(dVar);
        }

        public C0209d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0209d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: a */
        public int mo933a() {
            return this.f695f;
        }

        /* renamed from: b */
        public C0206a mo939b() {
            return this.f690a;
        }

        /* renamed from: a */
        public void mo935a(C0206a aVar) {
            if (this.f690a != aVar) {
                if (this.f690a != null) {
                    this.f690a.mo926c();
                }
                this.f690a = aVar;
                this.f703n = null;
                this.f691b = true;
                if (aVar != null) {
                    aVar.mo922a(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo934a(Rect rect) {
            this.f702m.set(rect);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public Rect mo942c() {
            return this.f702m;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo943d() {
            return this.f700k == null && this.f695f != -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public boolean mo944e() {
            if (this.f690a == null) {
                this.f704o = false;
            }
            return this.f704o;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo937a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f704o) {
                return true;
            }
            boolean e = (this.f690a != null ? this.f690a.mo929e(coordinatorLayout, view) : false) | this.f704o;
            this.f704o = e;
            return e;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo945f() {
            this.f704o = false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo946g() {
            this.f705p = false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo936a(boolean z) {
            this.f705p = z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public boolean mo947h() {
            return this.f705p;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public boolean mo948i() {
            return this.f706q;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo941b(boolean z) {
            this.f706q = z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void mo949j() {
            this.f706q = false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo938a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.f701l || m1198a(view2, ViewCompat.getLayoutDirection(coordinatorLayout)) || (this.f690a != null && this.f690a.mo756b(coordinatorLayout, view, view2));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public View mo940b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f695f == -1) {
                this.f701l = null;
                this.f700k = null;
                return null;
            }
            if (this.f700k == null || !m1199b(view, coordinatorLayout)) {
                m1197a(view, coordinatorLayout);
            }
            return this.f700k;
        }

        /* renamed from: a */
        private void m1197a(View view, CoordinatorLayout coordinatorLayout) {
            this.f700k = coordinatorLayout.findViewById(this.f695f);
            if (this.f700k != null) {
                if (this.f700k != coordinatorLayout) {
                    View view2 = this.f700k;
                    ViewParent parent = this.f700k.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.f701l = null;
                            this.f700k = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f701l = view2;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f701l = null;
                    this.f700k = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.f701l = null;
                this.f700k = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f695f) + " to anchor view " + view);
            }
        }

        /* renamed from: b */
        private boolean m1199b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f700k.getId() != this.f695f) {
                return false;
            }
            View view2 = this.f700k;
            for (ViewParent parent = this.f700k.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f701l = null;
                    this.f700k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.f701l = view2;
            return true;
        }

        /* renamed from: a */
        private boolean m1198a(View view, int i) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(((C0209d) view.getLayoutParams()).f696g, i);
            return absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.f697h, i) & absoluteGravity) == absoluteGravity;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$c */
    private class C0208c implements ViewGroup.OnHierarchyChangeListener {
        C0208c() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.f665e != null) {
                CoordinatorLayout.this.f665e.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.mo866a(2);
            if (CoordinatorLayout.this.f665e != null) {
                CoordinatorLayout.this.f665e.onChildViewRemoved(view, view2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.f688a;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0206a b = mo862a(childAt).mo939b();
            if (!(id == -1 || b == null || (parcelable2 = sparseArray.get(id)) == null)) {
                b.mo725a(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable b;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0206a b2 = ((C0209d) childAt.getLayoutParams()).mo939b();
            if (!(id == -1 || b2 == null || (b = b2.mo743b(this, childAt)) == null)) {
                sparseArray.append(id, b);
            }
        }
        savedState.f688a = sparseArray;
        return savedState;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        C0206a b = ((C0209d) view.getLayoutParams()).mo939b();
        if (b == null || !b.mo753a(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    /* renamed from: g */
    private void m1148g() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (ViewCompat.getFitsSystemWindows(this)) {
                if (this.f663A == null) {
                    this.f663A = new OnApplyWindowInsetsListener() {
                        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                            return CoordinatorLayout.this.mo864a(windowInsetsCompat);
                        }
                    };
                }
                ViewCompat.setOnApplyWindowInsetsListener(this, this.f663A);
                setSystemUiVisibility(1280);
                return;
            }
            ViewCompat.setOnApplyWindowInsetsListener(this, (OnApplyWindowInsetsListener) null);
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });

        /* renamed from: a */
        SparseArray<Parcelable> f688a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f688a = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f688a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int size = this.f688a != null ? this.f688a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f688a.keyAt(i2);
                parcelableArr[i2] = this.f688a.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }
}
