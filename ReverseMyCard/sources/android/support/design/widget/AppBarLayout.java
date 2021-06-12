package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.R;
import android.support.design.widget.C0292s;
import android.support.design.widget.CoordinatorLayout;
import android.support.p016v4.p018os.ParcelableCompat;
import android.support.p016v4.p018os.ParcelableCompatCreatorCallbacks;
import android.support.p016v4.view.AbsSavedState;
import android.support.p016v4.view.OnApplyWindowInsetsListener;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout.C0207b(mo930a = Behavior.class)
public class AppBarLayout extends LinearLayout {

    /* renamed from: a */
    private int f564a;

    /* renamed from: b */
    private int f565b;

    /* renamed from: c */
    private int f566c;

    /* renamed from: d */
    private boolean f567d;

    /* renamed from: e */
    private int f568e;

    /* renamed from: f */
    private WindowInsetsCompat f569f;

    /* renamed from: g */
    private List<C0192b> f570g;

    /* renamed from: h */
    private boolean f571h;

    /* renamed from: i */
    private boolean f572i;

    /* renamed from: j */
    private final int[] f573j;

    /* renamed from: android.support.design.widget.AppBarLayout$b */
    public interface C0192b {
        /* renamed from: a */
        void mo761a(AppBarLayout appBarLayout, int i);
    }

    public AppBarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f564a = -1;
        this.f565b = -1;
        this.f566c = -1;
        this.f568e = 0;
        this.f573j = new int[2];
        setOrientation(1);
        C0291r.m1597a(context);
        if (Build.VERSION.SDK_INT >= 21) {
            C0257aa.m1402a(this);
            C0257aa.m1404a(this, attributeSet, 0, R.style.Widget_Design_AppBarLayout);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout, 0, R.style.Widget_Design_AppBarLayout);
        ViewCompat.setBackground(this, obtainStyledAttributes.getDrawable(R.styleable.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_expanded)) {
            setExpanded(obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_expanded, false));
        }
        if (Build.VERSION.SDK_INT >= 21 && obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_elevation)) {
            C0257aa.m1403a(this, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
        }
        obtainStyledAttributes.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return AppBarLayout.this.mo688a(windowInsetsCompat);
            }
        });
    }

    /* renamed from: a */
    public void mo690a(C0192b bVar) {
        if (this.f570g == null) {
            this.f570g = new ArrayList();
        }
        if (bVar != null && !this.f570g.contains(bVar)) {
            this.f570g.add(bVar);
        }
    }

    /* renamed from: b */
    public void mo693b(C0192b bVar) {
        if (this.f570g != null && bVar != null) {
            this.f570g.remove(bVar);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m1012f();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m1012f();
        this.f567d = false;
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            } else if (((C0191a) getChildAt(i5).getLayoutParams()).mo759b() != null) {
                this.f567d = true;
                break;
            } else {
                i5++;
            }
        }
        m1011e();
    }

    /* renamed from: e */
    private void m1011e() {
        boolean z;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = false;
                break;
            } else if (((C0191a) getChildAt(i).getLayoutParams()).mo760c()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        m1010b(z);
    }

    /* renamed from: f */
    private void m1012f() {
        this.f564a = -1;
        this.f565b = -1;
        this.f566c = -1;
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setExpanded(boolean z) {
        mo691a(z, ViewCompat.isLaidOut(this));
    }

    /* renamed from: a */
    public void mo691a(boolean z, boolean z2) {
        this.f568e = (z2 ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0191a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0191a generateDefaultLayoutParams() {
        return new C0191a(-1, -2);
    }

    /* renamed from: a */
    public C0191a generateLayoutParams(AttributeSet attributeSet) {
        return new C0191a(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0191a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new C0191a((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0191a((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0191a(layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo694b() {
        return this.f567d;
    }

    public final int getTotalScrollRange() {
        int i;
        if (this.f564a != -1) {
            return this.f564a;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            C0191a aVar = (C0191a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = aVar.f590a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += aVar.bottomMargin + measuredHeight + aVar.topMargin;
            if ((i4 & 2) != 0) {
                i = i3 - ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i2++;
        }
        i = i3;
        int max = Math.max(0, i - getTopInset());
        this.f564a = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo695c() {
        return getTotalScrollRange() != 0;
    }

    /* access modifiers changed from: package-private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedPreScrollRange() {
        int i;
        if (this.f565b != -1) {
            return this.f565b;
        }
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            C0191a aVar = (C0191a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = aVar.f590a;
            if ((i3 & 5) == 5) {
                int i4 = aVar.bottomMargin + aVar.topMargin + i2;
                if ((i3 & 8) != 0) {
                    i = i4 + ViewCompat.getMinimumHeight(childAt);
                } else if ((i3 & 2) != 0) {
                    i = i4 + (measuredHeight - ViewCompat.getMinimumHeight(childAt));
                } else {
                    i = i4 + measuredHeight;
                }
            } else if (i2 > 0) {
                break;
            } else {
                i = i2;
            }
            childCount--;
            i2 = i;
        }
        int max = Math.max(0, i2);
        this.f565b = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedScrollRange() {
        int i;
        if (this.f566c != -1) {
            return this.f566c;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            C0191a aVar = (C0191a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + aVar.topMargin + aVar.bottomMargin;
            int i4 = aVar.f590a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight;
            if ((i4 & 2) != 0) {
                i = i3 - (ViewCompat.getMinimumHeight(childAt) + getTopInset());
                break;
            }
            i2++;
        }
        i = i3;
        int max = Math.max(0, i);
        this.f566c = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo689a(int i) {
        if (this.f570g != null) {
            int size = this.f570g.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0192b bVar = this.f570g.get(i2);
                if (bVar != null) {
                    bVar.mo761a(this, i);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight != 0) {
            return (minimumHeight * 2) + topInset;
        }
        int childCount = getChildCount();
        int minimumHeight2 = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
        if (minimumHeight2 != 0) {
            return (minimumHeight2 * 2) + topInset;
        }
        return getHeight() / 3;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] iArr = this.f573j;
        int[] onCreateDrawableState = super.onCreateDrawableState(iArr.length + i);
        iArr[0] = this.f571h ? R.attr.state_collapsible : -R.attr.state_collapsible;
        iArr[1] = (!this.f571h || !this.f572i) ? -R.attr.state_collapsed : R.attr.state_collapsed;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* renamed from: b */
    private boolean m1010b(boolean z) {
        if (this.f571h == z) {
            return false;
        }
        this.f571h = z;
        refreshDrawableState();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo692a(boolean z) {
        if (this.f572i == z) {
            return false;
        }
        this.f572i = z;
        refreshDrawableState();
        return true;
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0257aa.m1403a(this, f);
        }
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.f568e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo697d() {
        this.f568e = 0;
    }

    /* access modifiers changed from: package-private */
    public final int getTopInset() {
        if (this.f569f != null) {
            return this.f569f.getSystemWindowInsetTop();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public WindowInsetsCompat mo688a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = null;
        if (ViewCompat.getFitsSystemWindows(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        }
        if (!C0314z.m1695a((Object) this.f569f, (Object) windowInsetsCompat2)) {
            this.f569f = windowInsetsCompat2;
            m1012f();
        }
        return windowInsetsCompat;
    }

    /* renamed from: android.support.design.widget.AppBarLayout$a */
    public static class C0191a extends LinearLayout.LayoutParams {

        /* renamed from: a */
        int f590a = 1;

        /* renamed from: b */
        Interpolator f591b;

        public C0191a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.f590a = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f591b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public C0191a(int i, int i2) {
            super(i, i2);
        }

        public C0191a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0191a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0191a(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: a */
        public int mo758a() {
            return this.f590a;
        }

        /* renamed from: b */
        public Interpolator mo759b() {
            return this.f591b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo760c() {
            return (this.f590a & 1) == 1 && (this.f590a & 10) != 0;
        }
    }

    public static class Behavior extends C0278k<AppBarLayout> {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f575b;

        /* renamed from: c */
        private boolean f576c;

        /* renamed from: d */
        private boolean f577d;

        /* renamed from: e */
        private C0292s f578e;

        /* renamed from: f */
        private int f579f = -1;

        /* renamed from: g */
        private boolean f580g;

        /* renamed from: h */
        private float f581h;

        /* renamed from: i */
        private WeakReference<View> f582i;

        /* renamed from: j */
        private C0190a f583j;

        /* renamed from: android.support.design.widget.AppBarLayout$Behavior$a */
        public static abstract class C0190a {
            /* renamed from: a */
            public abstract boolean mo750a(AppBarLayout appBarLayout);
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo729a(int i) {
            return super.mo729a(i);
        }

        /* renamed from: b */
        public /* bridge */ /* synthetic */ int mo739b() {
            return super.mo739b();
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* renamed from: a */
        public boolean mo738a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
            boolean z = (i & 2) != 0 && appBarLayout.mo695c() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.f578e != null) {
                this.f578e.mo1327e();
            }
            this.f582i = null;
            return z;
        }

        /* renamed from: a */
        public void mo728a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
            int i3;
            int i4;
            if (i2 != 0 && !this.f576c) {
                if (i2 < 0) {
                    i3 = -appBarLayout.getTotalScrollRange();
                    i4 = i3 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i3 = -appBarLayout.getUpNestedPreScrollRange();
                    i4 = 0;
                }
                iArr[1] = mo1287b(coordinatorLayout, appBarLayout, i2, i3, i4);
            }
        }

        /* renamed from: a */
        public void mo727a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
            if (i4 < 0) {
                mo1287b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
                this.f576c = true;
                return;
            }
            this.f576c = false;
        }

        /* renamed from: a */
        public void mo726a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (!this.f577d) {
                m1033c(coordinatorLayout, appBarLayout);
            }
            this.f576c = false;
            this.f577d = false;
            this.f582i = new WeakReference<>(view);
        }

        /* renamed from: a */
        public boolean mo737a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
            boolean z2 = false;
            if (!z) {
                z2 = mo1285a(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -f2);
            } else if (f2 < 0.0f) {
                int downNestedPreScrollRange = (-appBarLayout.getTotalScrollRange()) + appBarLayout.getDownNestedPreScrollRange();
                if (mo715a() < downNestedPreScrollRange) {
                    m1027a(coordinatorLayout, appBarLayout, downNestedPreScrollRange, f2);
                    z2 = true;
                }
            } else {
                int i = -appBarLayout.getUpNestedPreScrollRange();
                if (mo715a() > i) {
                    m1027a(coordinatorLayout, appBarLayout, i, f2);
                    z2 = true;
                }
            }
            this.f577d = z2;
            return z2;
        }

        /* renamed from: a */
        private void m1027a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int height;
            int abs = Math.abs(mo715a() - i);
            float abs2 = Math.abs(f);
            if (abs2 > 0.0f) {
                height = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((((float) abs) / ((float) appBarLayout.getHeight())) + 1.0f) * 150.0f);
            }
            m1028a(coordinatorLayout, appBarLayout, i, height);
        }

        /* renamed from: a */
        private void m1028a(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i, int i2) {
            int a = mo715a();
            if (a != i) {
                if (this.f578e == null) {
                    this.f578e = C0314z.m1694a();
                    this.f578e.mo1323a(C0255a.f903e);
                    this.f578e.mo1322a((C0292s.C0297c) new C0292s.C0297c() {
                        /* renamed from: a */
                        public void mo746a(C0292s sVar) {
                            Behavior.this.mo1286a_(coordinatorLayout, appBarLayout, sVar.mo1325c());
                        }
                    });
                } else {
                    this.f578e.mo1327e();
                }
                this.f578e.mo1320a((long) Math.min(i2, 600));
                this.f578e.mo1319a(a, i);
                this.f578e.mo1317a();
            } else if (this.f578e != null && this.f578e.mo1324b()) {
                this.f578e.mo1327e();
            }
        }

        /* renamed from: a */
        private int m1026a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return i2;
                }
            }
            return -1;
        }

        /* renamed from: c */
        private void m1033c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int i;
            int a = mo715a();
            int a2 = m1026a(appBarLayout, a);
            if (a2 >= 0) {
                View childAt = appBarLayout.getChildAt(a2);
                int a3 = ((C0191a) childAt.getLayoutParams()).mo758a();
                if ((a3 & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int i3 = -childAt.getBottom();
                    if (a2 == appBarLayout.getChildCount() - 1) {
                        i3 += appBarLayout.getTopInset();
                    }
                    if (m1029a(a3, 2)) {
                        i3 += ViewCompat.getMinimumHeight(childAt);
                        i = i2;
                    } else if (m1029a(a3, 5)) {
                        i = ViewCompat.getMinimumHeight(childAt) + i3;
                        if (a >= i) {
                            i3 = i;
                            i = i2;
                        }
                    } else {
                        i = i2;
                    }
                    if (a >= (i3 + i) / 2) {
                        i3 = i;
                    }
                    m1027a(coordinatorLayout, appBarLayout, C0281m.m1558a(i3, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        /* renamed from: a */
        private static boolean m1029a(int i, int i2) {
            return (i & i2) == i2;
        }

        /* renamed from: a */
        public boolean mo736a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((CoordinatorLayout.C0209d) appBarLayout.getLayoutParams()).height != -2) {
                return super.mo736a(coordinatorLayout, appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.mo868a(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        /* renamed from: a */
        public boolean mo735a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int round;
            boolean a = super.mo735a(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i2 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        m1027a(coordinatorLayout, appBarLayout, i2, 0.0f);
                    } else {
                        mo1286a_(coordinatorLayout, appBarLayout, i2);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        m1027a(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        mo1286a_(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (this.f579f >= 0) {
                View childAt = appBarLayout.getChildAt(this.f579f);
                int i3 = -childAt.getBottom();
                if (this.f580g) {
                    round = ViewCompat.getMinimumHeight(childAt) + i3;
                } else {
                    round = Math.round(((float) childAt.getHeight()) * this.f581h) + i3;
                }
                mo729a(round);
            }
            appBarLayout.mo697d();
            this.f579f = -1;
            mo729a(C0281m.m1558a(mo739b(), -appBarLayout.getTotalScrollRange(), 0));
            appBarLayout.mo689a(mo739b());
            return a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo745c(AppBarLayout appBarLayout) {
            if (this.f583j != null) {
                return this.f583j.mo750a(appBarLayout);
            }
            if (this.f582i == null) {
                return true;
            }
            View view = (View) this.f582i.get();
            return view != null && view.isShown() && !ViewCompat.canScrollVertically(view, -1);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo724a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            m1033c(coordinatorLayout, appBarLayout);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo741b(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int mo718a(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo717a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int a = mo715a();
            if (i2 == 0 || a < i2 || a > i3) {
                this.f575b = 0;
                return 0;
            }
            int a2 = C0281m.m1558a(i, i2, i3);
            if (a == a2) {
                return 0;
            }
            int b = appBarLayout.mo694b() ? m1030b(appBarLayout, a2) : a2;
            boolean a3 = mo729a(b);
            int i4 = a - a2;
            this.f575b = a2 - b;
            if (!a3 && appBarLayout.mo694b()) {
                coordinatorLayout.mo874b((View) appBarLayout);
            }
            appBarLayout.mo689a(mo739b());
            m1031b(coordinatorLayout, appBarLayout, a2, a2 < a ? -1 : 1);
            return i4;
        }

        /* renamed from: b */
        private int m1030b(AppBarLayout appBarLayout, int i) {
            int i2;
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = appBarLayout.getChildAt(i3);
                C0191a aVar = (C0191a) childAt.getLayoutParams();
                Interpolator b = aVar.mo759b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i3++;
                } else if (b == null) {
                    return i;
                } else {
                    int a = aVar.mo758a();
                    if ((a & 1) != 0) {
                        i2 = aVar.bottomMargin + childAt.getHeight() + aVar.topMargin + 0;
                        if ((a & 2) != 0) {
                            i2 -= ViewCompat.getMinimumHeight(childAt);
                        }
                    } else {
                        i2 = 0;
                    }
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        i2 -= appBarLayout.getTopInset();
                    }
                    if (i2 <= 0) {
                        return i;
                    }
                    return Integer.signum(i) * (Math.round(b.getInterpolation(((float) (abs - childAt.getTop())) / ((float) i2)) * ((float) i2)) + childAt.getTop());
                }
            }
            return i;
        }

        /* renamed from: b */
        private void m1031b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2) {
            boolean z = true;
            boolean z2 = false;
            View c = m1032c(appBarLayout, i);
            if (c != null) {
                int a = ((C0191a) c.getLayoutParams()).mo758a();
                if ((a & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(c);
                    if (i2 > 0 && (a & 12) != 0) {
                        z2 = (-i) >= (c.getBottom() - minimumHeight) - appBarLayout.getTopInset();
                    } else if ((a & 2) != 0) {
                        if ((-i) < (c.getBottom() - minimumHeight) - appBarLayout.getTopInset()) {
                            z = false;
                        }
                        z2 = z;
                    }
                }
                if (appBarLayout.mo692a(z2) && Build.VERSION.SDK_INT >= 11 && m1034d(coordinatorLayout, appBarLayout)) {
                    appBarLayout.jumpDrawablesToCurrentState();
                }
            }
        }

        /* renamed from: d */
        private boolean m1034d(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List<View> d = coordinatorLayout.mo882d((View) appBarLayout);
            int size = d.size();
            int i = 0;
            while (i < size) {
                CoordinatorLayout.C0206a b = ((CoordinatorLayout.C0209d) d.get(i).getLayoutParams()).mo939b();
                if (!(b instanceof ScrollingViewBehavior)) {
                    i++;
                } else if (((ScrollingViewBehavior) b).mo1293d() != 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        /* renamed from: c */
        private static View m1032c(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo715a() {
            return mo739b() + this.f575b;
        }

        /* renamed from: b */
        public Parcelable mo743b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            boolean z = false;
            Parcelable b = super.mo743b(coordinatorLayout, appBarLayout);
            int b2 = mo739b();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(b);
                    savedState.f587a = i;
                    if (bottom == ViewCompat.getMinimumHeight(childAt) + appBarLayout.getTopInset()) {
                        z = true;
                    }
                    savedState.f589c = z;
                    savedState.f588b = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return b;
        }

        /* renamed from: a */
        public void mo725a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.mo725a(coordinatorLayout, appBarLayout, savedState.getSuperState());
                this.f579f = savedState.f587a;
                this.f581h = savedState.f588b;
                this.f580g = savedState.f589c;
                return;
            }
            super.mo725a(coordinatorLayout, appBarLayout, parcelable);
            this.f579f = -1;
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
            int f587a;

            /* renamed from: b */
            float f588b;

            /* renamed from: c */
            boolean f589c;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f587a = parcel.readInt();
                this.f588b = parcel.readFloat();
                this.f589c = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f587a);
                parcel.writeFloat(this.f588b);
                parcel.writeByte((byte) (this.f589c ? 1 : 0));
            }
        }
    }

    public static class ScrollingViewBehavior extends C0280l {
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo729a(int i) {
            return super.mo729a(i);
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo735a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.mo735a(coordinatorLayout, view, i);
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo736a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.mo736a(coordinatorLayout, view, i, i2, i3, i4);
        }

        /* renamed from: b */
        public /* bridge */ /* synthetic */ int mo739b() {
            return super.mo739b();
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            mo1290b(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        /* renamed from: b */
        public boolean mo756b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        /* renamed from: c */
        public boolean mo757c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m1071e(coordinatorLayout, view, view2);
            return false;
        }

        /* renamed from: a */
        public boolean mo753a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            boolean z2;
            AppBarLayout a = mo755b(coordinatorLayout.mo877c(view));
            if (a != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f1021a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    if (!z) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    a.mo691a(false, z2);
                    return true;
                }
            }
            return false;
        }

        /* renamed from: e */
        private void m1071e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            CoordinatorLayout.C0206a b = ((CoordinatorLayout.C0209d) view2.getLayoutParams()).mo939b();
            if (b instanceof Behavior) {
                ViewCompat.offsetTopAndBottom(view, ((((Behavior) b).f575b + (view2.getBottom() - view.getTop())) + mo1289a()) - mo1292c(view2));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public float mo751a(View view) {
            int i;
            if (!(view instanceof AppBarLayout)) {
                return 0.0f;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            int a = m1070a(appBarLayout);
            if ((downNestedPreScrollRange == 0 || totalScrollRange + a > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                return 1.0f + (((float) a) / ((float) i));
            }
            return 0.0f;
        }

        /* renamed from: a */
        private static int m1070a(AppBarLayout appBarLayout) {
            CoordinatorLayout.C0206a b = ((CoordinatorLayout.C0209d) appBarLayout.getLayoutParams()).mo939b();
            if (b instanceof Behavior) {
                return ((Behavior) b).mo715a();
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public AppBarLayout mo755b(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo754b(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.mo754b(view);
        }
    }
}
