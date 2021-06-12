package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.R;
import android.support.design.widget.C0292s;
import android.support.p016v4.util.Pools;
import android.support.p016v4.view.GravityCompat;
import android.support.p016v4.view.PagerAdapter;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.view.ViewPager;
import android.support.p016v4.widget.TextViewCompat;
import android.support.p019v7.app.ActionBar;
import android.support.p019v7.appcompat.C0555R;
import android.support.p019v7.content.res.AppCompatResources;
import android.support.p019v7.widget.ActivityChooserView;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {

    /* renamed from: n */
    private static final Pools.Pool<C0244e> f783n = new Pools.SynchronizedPool(16);

    /* renamed from: A */
    private DataSetObserver f784A;

    /* renamed from: B */
    private C0245f f785B;

    /* renamed from: C */
    private C0238a f786C;

    /* renamed from: D */
    private boolean f787D;

    /* renamed from: E */
    private final Pools.Pool<C0246g> f788E;

    /* renamed from: a */
    int f789a;

    /* renamed from: b */
    int f790b;

    /* renamed from: c */
    int f791c;

    /* renamed from: d */
    int f792d;

    /* renamed from: e */
    int f793e;

    /* renamed from: f */
    ColorStateList f794f;

    /* renamed from: g */
    float f795g;

    /* renamed from: h */
    float f796h;

    /* renamed from: i */
    final int f797i;

    /* renamed from: j */
    int f798j;

    /* renamed from: k */
    int f799k;

    /* renamed from: l */
    int f800l;

    /* renamed from: m */
    ViewPager f801m;

    /* renamed from: o */
    private final ArrayList<C0244e> f802o;

    /* renamed from: p */
    private C0244e f803p;

    /* renamed from: q */
    private final C0241d f804q;

    /* renamed from: r */
    private final int f805r;

    /* renamed from: s */
    private final int f806s;

    /* renamed from: t */
    private final int f807t;

    /* renamed from: u */
    private int f808u;

    /* renamed from: v */
    private C0239b f809v;

    /* renamed from: w */
    private final ArrayList<C0239b> f810w;

    /* renamed from: x */
    private C0239b f811x;

    /* renamed from: y */
    private C0292s f812y;

    /* renamed from: z */
    private PagerAdapter f813z;

    /* renamed from: android.support.design.widget.TabLayout$b */
    public interface C0239b {
        /* renamed from: a */
        void mo1110a(C0244e eVar);

        /* renamed from: b */
        void mo1111b(C0244e eVar);

        /* renamed from: c */
        void mo1112c(C0244e eVar);
    }

    public TabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f802o = new ArrayList<>();
        this.f798j = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f810w = new ArrayList<>();
        this.f788E = new Pools.SimplePool(12);
        C0291r.m1597a(context);
        setHorizontalScrollBarEnabled(false);
        this.f804q = new C0241d(context);
        super.addView(this.f804q, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TabLayout, i, R.style.Widget_Design_TabLayout);
        this.f804q.mo1120b(obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, 0));
        this.f804q.mo1115a(obtainStyledAttributes.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.f792d = dimensionPixelSize;
        this.f791c = dimensionPixelSize;
        this.f790b = dimensionPixelSize;
        this.f789a = dimensionPixelSize;
        this.f789a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.f789a);
        this.f790b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.f790b);
        this.f791c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.f791c);
        this.f792d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.f792d);
        this.f793e = obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.f793e, C0555R.styleable.TextAppearance);
        try {
            this.f795g = (float) obtainStyledAttributes2.getDimensionPixelSize(C0555R.styleable.TextAppearance_android_textSize, 0);
            this.f794f = obtainStyledAttributes2.getColorStateList(C0555R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes2.recycle();
            if (obtainStyledAttributes.hasValue(R.styleable.TabLayout_tabTextColor)) {
                this.f794f = obtainStyledAttributes.getColorStateList(R.styleable.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
                this.f794f = m1306a(this.f794f.getDefaultColor(), obtainStyledAttributes.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.f805r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.f806s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.f797i = obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.f808u = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.f800l = obtainStyledAttributes.getInt(R.styleable.TabLayout_tabMode, 1);
            this.f799k = obtainStyledAttributes.getInt(R.styleable.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.f796h = (float) resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.f807t = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            m1319f();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.f804q.mo1115a(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.f804q.mo1120b(i);
    }

    /* renamed from: a */
    public void mo1070a(int i, float f, boolean z) {
        mo1071a(i, f, z, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1071a(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0 && round < this.f804q.getChildCount()) {
            if (z2) {
                this.f804q.mo1116a(i, f);
            }
            if (this.f812y != null && this.f812y.mo1324b()) {
                this.f812y.mo1327e();
            }
            scrollTo(m1305a(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private float getScrollPosition() {
        return this.f804q.mo1119b();
    }

    /* renamed from: a */
    public void mo1073a(C0244e eVar) {
        mo1075a(eVar, this.f802o.isEmpty());
    }

    /* renamed from: a */
    public void mo1075a(C0244e eVar, boolean z) {
        mo1074a(eVar, this.f802o.size(), z);
    }

    /* renamed from: a */
    public void mo1074a(C0244e eVar, int i, boolean z) {
        if (eVar.f833a != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        m1308a(eVar, i);
        m1316d(eVar);
        if (z) {
            eVar.mo1136e();
        }
    }

    /* renamed from: a */
    private void m1307a(TabItem tabItem) {
        C0244e a = mo1068a();
        if (tabItem.f780a != null) {
            a.mo1129a(tabItem.f780a);
        }
        if (tabItem.f781b != null) {
            a.mo1127a(tabItem.f781b);
        }
        if (tabItem.f782c != 0) {
            a.mo1126a(tabItem.f782c);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            a.mo1132b(tabItem.getContentDescription());
        }
        mo1073a(a);
    }

    @Deprecated
    public void setOnTabSelectedListener(C0239b bVar) {
        if (this.f809v != null) {
            mo1085b(this.f809v);
        }
        this.f809v = bVar;
        if (bVar != null) {
            mo1072a(bVar);
        }
    }

    /* renamed from: a */
    public void mo1072a(C0239b bVar) {
        if (!this.f810w.contains(bVar)) {
            this.f810w.add(bVar);
        }
    }

    /* renamed from: b */
    public void mo1085b(C0239b bVar) {
        this.f810w.remove(bVar);
    }

    /* renamed from: a */
    public C0244e mo1068a() {
        C0244e acquire = f783n.acquire();
        if (acquire == null) {
            acquire = new C0244e();
        }
        acquire.f833a = this;
        acquire.f834b = m1312c(acquire);
        return acquire;
    }

    public int getTabCount() {
        return this.f802o.size();
    }

    /* renamed from: a */
    public C0244e mo1069a(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.f802o.get(i);
    }

    public int getSelectedTabPosition() {
        if (this.f803p != null) {
            return this.f803p.mo1134c();
        }
        return -1;
    }

    /* renamed from: b */
    public void mo1084b() {
        for (int childCount = this.f804q.getChildCount() - 1; childCount >= 0; childCount--) {
            m1313c(childCount);
        }
        Iterator<C0244e> it = this.f802o.iterator();
        while (it.hasNext()) {
            C0244e next = it.next();
            it.remove();
            next.mo1140i();
            f783n.release(next);
        }
        this.f803p = null;
    }

    public void setTabMode(int i) {
        if (i != this.f800l) {
            this.f800l = i;
            m1319f();
        }
    }

    public int getTabMode() {
        return this.f800l;
    }

    public void setTabGravity(int i) {
        if (this.f799k != i) {
            this.f799k = i;
            m1319f();
        }
    }

    public int getTabGravity() {
        return this.f799k;
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f794f != colorStateList) {
            this.f794f = colorStateList;
            m1314d();
        }
    }

    public ColorStateList getTabTextColors() {
        return this.f794f;
    }

    public void setupWithViewPager(ViewPager viewPager) {
        mo1077a(viewPager, true);
    }

    /* renamed from: a */
    public void mo1077a(ViewPager viewPager, boolean z) {
        m1309a(viewPager, z, false);
    }

    /* renamed from: a */
    private void m1309a(ViewPager viewPager, boolean z, boolean z2) {
        if (this.f801m != null) {
            if (this.f785B != null) {
                this.f801m.removeOnPageChangeListener(this.f785B);
            }
            if (this.f786C != null) {
                this.f801m.removeOnAdapterChangeListener(this.f786C);
            }
        }
        if (this.f811x != null) {
            mo1085b(this.f811x);
            this.f811x = null;
        }
        if (viewPager != null) {
            this.f801m = viewPager;
            if (this.f785B == null) {
                this.f785B = new C0245f(this);
            }
            this.f785B.mo1141a();
            viewPager.addOnPageChangeListener(this.f785B);
            this.f811x = new C0247h(viewPager);
            mo1072a(this.f811x);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                mo1076a(adapter, z);
            }
            if (this.f786C == null) {
                this.f786C = new C0238a();
            }
            this.f786C.mo1108a(z);
            viewPager.addOnAdapterChangeListener(this.f786C);
            mo1070a(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f801m = null;
            mo1076a((PagerAdapter) null, false);
        }
        this.f787D = z2;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        mo1076a(pagerAdapter, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f801m == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                m1309a((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f787D) {
            setupWithViewPager((ViewPager) null);
            this.f787D = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f804q.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1076a(PagerAdapter pagerAdapter, boolean z) {
        if (!(this.f813z == null || this.f784A == null)) {
            this.f813z.unregisterDataSetObserver(this.f784A);
        }
        this.f813z = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.f784A == null) {
                this.f784A = new C0240c();
            }
            pagerAdapter.registerDataSetObserver(this.f784A);
        }
        mo1088c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo1088c() {
        int currentItem;
        mo1084b();
        if (this.f813z != null) {
            int count = this.f813z.getCount();
            for (int i = 0; i < count; i++) {
                mo1075a(mo1068a().mo1129a(this.f813z.getPageTitle(i)), false);
            }
            if (this.f801m != null && count > 0 && (currentItem = this.f801m.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                mo1086b(mo1069a(currentItem));
            }
        }
    }

    /* renamed from: d */
    private void m1314d() {
        int size = this.f802o.size();
        for (int i = 0; i < size; i++) {
            this.f802o.get(i).mo1139h();
        }
    }

    /* renamed from: c */
    private C0246g m1312c(C0244e eVar) {
        C0246g acquire = this.f788E != null ? this.f788E.acquire() : null;
        if (acquire == null) {
            acquire = new C0246g(getContext());
        }
        acquire.mo1146a(eVar);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        return acquire;
    }

    /* renamed from: a */
    private void m1308a(C0244e eVar, int i) {
        eVar.mo1133b(i);
        this.f802o.add(i, eVar);
        int size = this.f802o.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            this.f802o.get(i2).mo1133b(i2);
        }
    }

    /* renamed from: d */
    private void m1316d(C0244e eVar) {
        this.f804q.addView(eVar.f834b, eVar.mo1134c(), m1317e());
    }

    public void addView(View view) {
        m1310a(view);
    }

    public void addView(View view, int i) {
        m1310a(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m1310a(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        m1310a(view);
    }

    /* renamed from: a */
    private void m1310a(View view) {
        if (view instanceof TabItem) {
            m1307a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    /* renamed from: e */
    private LinearLayout.LayoutParams m1317e() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        m1311a(layoutParams);
        return layoutParams;
    }

    /* renamed from: a */
    private void m1311a(LinearLayout.LayoutParams layoutParams) {
        if (this.f800l == 1 && this.f799k == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo1083b(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z;
        int b;
        boolean z2 = true;
        int b2 = mo1083b(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        switch (View.MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(b2, View.MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = View.MeasureSpec.makeMeasureSpec(b2, 1073741824);
                break;
        }
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            if (this.f806s > 0) {
                b = this.f806s;
            } else {
                b = size - mo1083b(56);
            }
            this.f798j = b;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.f800l) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        z2 = false;
                    }
                    z = z2;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    /* renamed from: c */
    private void m1313c(int i) {
        C0246g gVar = (C0246g) this.f804q.getChildAt(i);
        this.f804q.removeViewAt(i);
        if (gVar != null) {
            gVar.mo1145a();
            this.f788E.release(gVar);
        }
        requestLayout();
    }

    /* renamed from: d */
    private void m1315d(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.f804q.mo1118a()) {
                mo1070a(i, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int a = m1305a(i, 0.0f);
            if (scrollX != a) {
                if (this.f812y == null) {
                    this.f812y = C0314z.m1694a();
                    this.f812y.mo1323a(C0255a.f900b);
                    this.f812y.mo1320a(300);
                    this.f812y.mo1322a((C0292s.C0297c) new C0292s.C0297c() {
                        /* renamed from: a */
                        public void mo746a(C0292s sVar) {
                            TabLayout.this.scrollTo(sVar.mo1325c(), 0);
                        }
                    });
                }
                this.f812y.mo1319a(scrollX, a);
                this.f812y.mo1317a();
            }
            this.f804q.mo1121b(i, 300);
        }
    }

    private void setSelectedTabView(int i) {
        boolean z;
        int childCount = this.f804q.getChildCount();
        if (i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f804q.getChildAt(i2);
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1086b(C0244e eVar) {
        mo1087b(eVar, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1087b(C0244e eVar, boolean z) {
        C0244e eVar2 = this.f803p;
        if (eVar2 != eVar) {
            int c = eVar != null ? eVar.mo1134c() : -1;
            if (z) {
                if ((eVar2 == null || eVar2.mo1134c() == -1) && c != -1) {
                    mo1070a(c, 0.0f, true);
                } else {
                    m1315d(c);
                }
                if (c != -1) {
                    setSelectedTabView(c);
                }
            }
            if (eVar2 != null) {
                m1320f(eVar2);
            }
            this.f803p = eVar;
            if (eVar != null) {
                m1318e(eVar);
            }
        } else if (eVar2 != null) {
            m1321g(eVar);
            m1315d(eVar.mo1134c());
        }
    }

    /* renamed from: e */
    private void m1318e(C0244e eVar) {
        for (int size = this.f810w.size() - 1; size >= 0; size--) {
            this.f810w.get(size).mo1110a(eVar);
        }
    }

    /* renamed from: f */
    private void m1320f(C0244e eVar) {
        for (int size = this.f810w.size() - 1; size >= 0; size--) {
            this.f810w.get(size).mo1111b(eVar);
        }
    }

    /* renamed from: g */
    private void m1321g(C0244e eVar) {
        for (int size = this.f810w.size() - 1; size >= 0; size--) {
            this.f810w.get(size).mo1112c(eVar);
        }
    }

    /* renamed from: a */
    private int m1305a(int i, float f) {
        int i2;
        int i3 = 0;
        if (this.f800l != 0) {
            return 0;
        }
        View childAt = this.f804q.getChildAt(i);
        View childAt2 = i + 1 < this.f804q.getChildCount() ? this.f804q.getChildAt(i + 1) : null;
        if (childAt != null) {
            i2 = childAt.getWidth();
        } else {
            i2 = 0;
        }
        if (childAt2 != null) {
            i3 = childAt2.getWidth();
        }
        return ((((int) ((((float) (i3 + i2)) * f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    /* renamed from: f */
    private void m1319f() {
        int i;
        if (this.f800l == 0) {
            i = Math.max(0, this.f808u - this.f789a);
        } else {
            i = 0;
        }
        ViewCompat.setPaddingRelative(this.f804q, i, 0, 0, 0);
        switch (this.f800l) {
            case 0:
                this.f804q.setGravity(GravityCompat.START);
                break;
            case 1:
                this.f804q.setGravity(1);
                break;
        }
        mo1078a(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1078a(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f804q.getChildCount()) {
                View childAt = this.f804q.getChildAt(i2);
                childAt.setMinimumWidth(getTabMinWidth());
                m1311a((LinearLayout.LayoutParams) childAt.getLayoutParams());
                if (z) {
                    childAt.requestLayout();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: android.support.design.widget.TabLayout$e */
    public static final class C0244e {

        /* renamed from: a */
        TabLayout f833a;

        /* renamed from: b */
        C0246g f834b;

        /* renamed from: c */
        private Object f835c;

        /* renamed from: d */
        private Drawable f836d;

        /* renamed from: e */
        private CharSequence f837e;

        /* renamed from: f */
        private CharSequence f838f;

        /* renamed from: g */
        private int f839g = -1;

        /* renamed from: h */
        private View f840h;

        C0244e() {
        }

        /* renamed from: a */
        public View mo1130a() {
            return this.f840h;
        }

        /* renamed from: a */
        public C0244e mo1128a(View view) {
            this.f840h = view;
            mo1139h();
            return this;
        }

        /* renamed from: a */
        public C0244e mo1126a(int i) {
            return mo1128a(LayoutInflater.from(this.f834b.getContext()).inflate(i, this.f834b, false));
        }

        /* renamed from: b */
        public Drawable mo1131b() {
            return this.f836d;
        }

        /* renamed from: c */
        public int mo1134c() {
            return this.f839g;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo1133b(int i) {
            this.f839g = i;
        }

        /* renamed from: d */
        public CharSequence mo1135d() {
            return this.f837e;
        }

        /* renamed from: a */
        public C0244e mo1127a(Drawable drawable) {
            this.f836d = drawable;
            mo1139h();
            return this;
        }

        /* renamed from: a */
        public C0244e mo1129a(CharSequence charSequence) {
            this.f837e = charSequence;
            mo1139h();
            return this;
        }

        /* renamed from: e */
        public void mo1136e() {
            if (this.f833a == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.f833a.mo1086b(this);
        }

        /* renamed from: f */
        public boolean mo1137f() {
            if (this.f833a != null) {
                return this.f833a.getSelectedTabPosition() == this.f839g;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        /* renamed from: b */
        public C0244e mo1132b(CharSequence charSequence) {
            this.f838f = charSequence;
            mo1139h();
            return this;
        }

        /* renamed from: g */
        public CharSequence mo1138g() {
            return this.f838f;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo1139h() {
            if (this.f834b != null) {
                this.f834b.mo1147b();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo1140i() {
            this.f833a = null;
            this.f834b = null;
            this.f835c = null;
            this.f836d = null;
            this.f837e = null;
            this.f838f = null;
            this.f839g = -1;
            this.f840h = null;
        }
    }

    /* renamed from: android.support.design.widget.TabLayout$g */
    class C0246g extends LinearLayout implements View.OnLongClickListener {

        /* renamed from: b */
        private C0244e f845b;

        /* renamed from: c */
        private TextView f846c;

        /* renamed from: d */
        private ImageView f847d;

        /* renamed from: e */
        private View f848e;

        /* renamed from: f */
        private TextView f849f;

        /* renamed from: g */
        private ImageView f850g;

        /* renamed from: h */
        private int f851h = 2;

        public C0246g(Context context) {
            super(context);
            if (TabLayout.this.f797i != 0) {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(context, TabLayout.this.f797i));
            }
            ViewCompat.setPaddingRelative(this, TabLayout.this.f789a, TabLayout.this.f790b, TabLayout.this.f791c, TabLayout.this.f792d);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f845b == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f845b.mo1136e();
            return true;
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            if (this.f846c != null) {
                this.f846c.setSelected(z);
            }
            if (this.f847d != null) {
                this.f847d.setSelected(z);
            }
            if (this.f848e != null) {
                this.f848e.setSelected(z);
            }
        }

        @TargetApi(14)
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        public void onMeasure(int i, int i2) {
            Layout layout;
            boolean z = true;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f798j, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.f846c != null) {
                getResources();
                float f = TabLayout.this.f795g;
                int i3 = this.f851h;
                if (this.f847d != null && this.f847d.getVisibility() == 0) {
                    i3 = 1;
                } else if (this.f846c != null && this.f846c.getLineCount() > 1) {
                    f = TabLayout.this.f796h;
                }
                float textSize = this.f846c.getTextSize();
                int lineCount = this.f846c.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.f846c);
                if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                    if (TabLayout.this.f800l == 1 && f > textSize && lineCount == 1 && ((layout = this.f846c.getLayout()) == null || m1370a(layout, 0, f) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())))) {
                        z = false;
                    }
                    if (z) {
                        this.f846c.setTextSize(0, f);
                        this.f846c.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1146a(C0244e eVar) {
            if (eVar != this.f845b) {
                this.f845b = eVar;
                mo1147b();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1145a() {
            mo1146a((C0244e) null);
            setSelected(false);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final void mo1147b() {
            boolean z;
            C0244e eVar = this.f845b;
            View a = eVar != null ? eVar.mo1130a() : null;
            if (a != null) {
                ViewParent parent = a.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(a);
                    }
                    addView(a);
                }
                this.f848e = a;
                if (this.f846c != null) {
                    this.f846c.setVisibility(8);
                }
                if (this.f847d != null) {
                    this.f847d.setVisibility(8);
                    this.f847d.setImageDrawable((Drawable) null);
                }
                this.f849f = (TextView) a.findViewById(16908308);
                if (this.f849f != null) {
                    this.f851h = TextViewCompat.getMaxLines(this.f849f);
                }
                this.f850g = (ImageView) a.findViewById(16908294);
            } else {
                if (this.f848e != null) {
                    removeView(this.f848e);
                    this.f848e = null;
                }
                this.f849f = null;
                this.f850g = null;
            }
            if (this.f848e == null) {
                if (this.f847d == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
                    addView(imageView, 0);
                    this.f847d = imageView;
                }
                if (this.f846c == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
                    addView(textView);
                    this.f846c = textView;
                    this.f851h = TextViewCompat.getMaxLines(this.f846c);
                }
                TextViewCompat.setTextAppearance(this.f846c, TabLayout.this.f793e);
                if (TabLayout.this.f794f != null) {
                    this.f846c.setTextColor(TabLayout.this.f794f);
                }
                m1371a(this.f846c, this.f847d);
            } else if (!(this.f849f == null && this.f850g == null)) {
                m1371a(this.f849f, this.f850g);
            }
            if (eVar == null || !eVar.mo1137f()) {
                z = false;
            } else {
                z = true;
            }
            setSelected(z);
        }

        /* renamed from: a */
        private void m1371a(TextView textView, ImageView imageView) {
            CharSequence charSequence;
            CharSequence charSequence2;
            boolean z;
            int i;
            Drawable b = this.f845b != null ? this.f845b.mo1131b() : null;
            if (this.f845b != null) {
                charSequence = this.f845b.mo1135d();
            } else {
                charSequence = null;
            }
            if (this.f845b != null) {
                charSequence2 = this.f845b.mo1138g();
            } else {
                charSequence2 = null;
            }
            if (imageView != null) {
                if (b != null) {
                    imageView.setImageDrawable(b);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable((Drawable) null);
                }
                imageView.setContentDescription(charSequence2);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                z = true;
            } else {
                z = false;
            }
            if (textView != null) {
                if (z) {
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
                textView.setContentDescription(charSequence2);
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (!z || imageView.getVisibility() != 0) {
                    i = 0;
                } else {
                    i = TabLayout.this.mo1083b(8);
                }
                if (i != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i;
                    imageView.requestLayout();
                }
            }
            if (z || TextUtils.isEmpty(charSequence2)) {
                setOnLongClickListener((View.OnLongClickListener) null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            Rect rect = new Rect();
            getLocationOnScreen(iArr);
            getWindowVisibleDisplayFrame(rect);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = iArr[1] + (height / 2);
            int i2 = (width / 2) + iArr[0];
            if (ViewCompat.getLayoutDirection(view) == 0) {
                i2 = context.getResources().getDisplayMetrics().widthPixels - i2;
            }
            Toast makeText = Toast.makeText(context, this.f845b.mo1138g(), 0);
            if (i < rect.height()) {
                makeText.setGravity(8388661, i2, (iArr[1] + height) - rect.top);
            } else {
                makeText.setGravity(81, 0, height);
            }
            makeText.show();
            return true;
        }

        /* renamed from: a */
        private float m1370a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }
    }

    /* renamed from: android.support.design.widget.TabLayout$d */
    private class C0241d extends LinearLayout {

        /* renamed from: a */
        int f818a = -1;

        /* renamed from: b */
        float f819b;

        /* renamed from: d */
        private int f821d;

        /* renamed from: e */
        private final Paint f822e;

        /* renamed from: f */
        private int f823f = -1;

        /* renamed from: g */
        private int f824g = -1;

        /* renamed from: h */
        private C0292s f825h;

        C0241d(Context context) {
            super(context);
            setWillNotDraw(false);
            this.f822e = new Paint();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1115a(int i) {
            if (this.f822e.getColor() != i) {
                this.f822e.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo1120b(int i) {
            if (this.f821d != i) {
                this.f821d = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo1118a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1116a(int i, float f) {
            if (this.f825h != null && this.f825h.mo1324b()) {
                this.f825h.mo1327e();
            }
            this.f818a = i;
            this.f819b = f;
            m1344c();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public float mo1119b() {
            return ((float) this.f818a) + this.f819b;
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            boolean z;
            int i3;
            boolean z2 = false;
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824 && TabLayout.this.f800l == 1 && TabLayout.this.f799k == 1) {
                int childCount = getChildCount();
                int i4 = 0;
                int i5 = 0;
                while (i4 < childCount) {
                    View childAt = getChildAt(i4);
                    if (childAt.getVisibility() == 0) {
                        i3 = Math.max(i5, childAt.getMeasuredWidth());
                    } else {
                        i3 = i5;
                    }
                    i4++;
                    i5 = i3;
                }
                if (i5 > 0) {
                    if (i5 * childCount <= getMeasuredWidth() - (TabLayout.this.mo1083b(16) * 2)) {
                        int i6 = 0;
                        while (i6 < childCount) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                            if (layoutParams.width == i5 && layoutParams.weight == 0.0f) {
                                z = z2;
                            } else {
                                layoutParams.width = i5;
                                layoutParams.weight = 0.0f;
                                z = true;
                            }
                            i6++;
                            z2 = z;
                        }
                    } else {
                        TabLayout.this.f799k = 0;
                        TabLayout.this.mo1078a(false);
                        z2 = true;
                    }
                    if (z2) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f825h == null || !this.f825h.mo1324b()) {
                m1344c();
                return;
            }
            this.f825h.mo1327e();
            mo1121b(this.f818a, Math.round(((float) this.f825h.mo1330h()) * (1.0f - this.f825h.mo1328f())));
        }

        /* renamed from: c */
        private void m1344c() {
            int i;
            int i2;
            View childAt = getChildAt(this.f818a);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i2 = childAt.getLeft();
                i = childAt.getRight();
                if (this.f819b > 0.0f && this.f818a < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f818a + 1);
                    i2 = (int) ((((float) i2) * (1.0f - this.f819b)) + (this.f819b * ((float) childAt2.getLeft())));
                    i = (int) ((((float) i) * (1.0f - this.f819b)) + (((float) childAt2.getRight()) * this.f819b));
                }
            }
            mo1117a(i2, i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1117a(int i, int i2) {
            if (i != this.f823f || i2 != this.f824g) {
                this.f823f = i;
                this.f824g = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo1121b(final int i, int i2) {
            final int i3;
            final int i4;
            if (this.f825h != null && this.f825h.mo1324b()) {
                this.f825h.mo1327e();
            }
            boolean z = ViewCompat.getLayoutDirection(this) == 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                m1344c();
                return;
            }
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (Math.abs(i - this.f818a) <= 1) {
                i4 = this.f823f;
                i3 = this.f824g;
            } else {
                int b = TabLayout.this.mo1083b(24);
                if (i < this.f818a) {
                    if (z) {
                        i3 = left - b;
                        i4 = i3;
                    } else {
                        i3 = right + b;
                        i4 = i3;
                    }
                } else if (z) {
                    i3 = right + b;
                    i4 = i3;
                } else {
                    i3 = left - b;
                    i4 = i3;
                }
            }
            if (i4 != left || i3 != right) {
                C0292s a = C0314z.m1694a();
                this.f825h = a;
                a.mo1323a(C0255a.f900b);
                a.mo1320a((long) i2);
                a.mo1318a(0.0f, 1.0f);
                a.mo1322a((C0292s.C0297c) new C0292s.C0297c() {
                    /* renamed from: a */
                    public void mo746a(C0292s sVar) {
                        float f = sVar.mo1328f();
                        C0241d.this.mo1117a(C0255a.m1401a(i4, left, f), C0255a.m1401a(i3, right, f));
                    }
                });
                a.mo1321a((C0292s.C0295a) new C0292s.C0296b() {
                    /* renamed from: b */
                    public void mo1125b(C0292s sVar) {
                        C0241d.this.f818a = i;
                        C0241d.this.f819b = 0.0f;
                    }
                });
                a.mo1317a();
            }
        }

        public void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.f823f >= 0 && this.f824g > this.f823f) {
                canvas.drawRect((float) this.f823f, (float) (getHeight() - this.f821d), (float) this.f824g, (float) getHeight(), this.f822e);
            }
        }
    }

    /* renamed from: a */
    private static ColorStateList m1306a(int i, int i2) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i});
    }

    private int getDefaultHeight() {
        boolean z;
        int size = this.f802o.size();
        int i = 0;
        while (true) {
            if (i < size) {
                C0244e eVar = this.f802o.get(i);
                if (eVar != null && eVar.mo1131b() != null && !TextUtils.isEmpty(eVar.mo1135d())) {
                    z = true;
                    break;
                }
                i++;
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            return 72;
        }
        return 48;
    }

    private int getTabMinWidth() {
        if (this.f805r != -1) {
            return this.f805r;
        }
        if (this.f800l == 0) {
            return this.f807t;
        }
        return 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.f798j;
    }

    /* renamed from: android.support.design.widget.TabLayout$f */
    public static class C0245f implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        private final WeakReference<TabLayout> f841a;

        /* renamed from: b */
        private int f842b;

        /* renamed from: c */
        private int f843c;

        public C0245f(TabLayout tabLayout) {
            this.f841a = new WeakReference<>(tabLayout);
        }

        public void onPageScrollStateChanged(int i) {
            this.f842b = this.f843c;
            this.f843c = i;
        }

        public void onPageScrolled(int i, float f, int i2) {
            boolean z = false;
            TabLayout tabLayout = (TabLayout) this.f841a.get();
            if (tabLayout != null) {
                boolean z2 = this.f843c != 2 || this.f842b == 1;
                if (!(this.f843c == 2 && this.f842b == 0)) {
                    z = true;
                }
                tabLayout.mo1071a(i, f, z2, z);
            }
        }

        public void onPageSelected(int i) {
            TabLayout tabLayout = (TabLayout) this.f841a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                tabLayout.mo1087b(tabLayout.mo1069a(i), this.f843c == 0 || (this.f843c == 2 && this.f842b == 0));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1141a() {
            this.f843c = 0;
            this.f842b = 0;
        }
    }

    /* renamed from: android.support.design.widget.TabLayout$h */
    public static class C0247h implements C0239b {

        /* renamed from: a */
        private final ViewPager f852a;

        public C0247h(ViewPager viewPager) {
            this.f852a = viewPager;
        }

        /* renamed from: a */
        public void mo1110a(C0244e eVar) {
            this.f852a.setCurrentItem(eVar.mo1134c());
        }

        /* renamed from: b */
        public void mo1111b(C0244e eVar) {
        }

        /* renamed from: c */
        public void mo1112c(C0244e eVar) {
        }
    }

    /* renamed from: android.support.design.widget.TabLayout$c */
    private class C0240c extends DataSetObserver {
        C0240c() {
        }

        public void onChanged() {
            TabLayout.this.mo1088c();
        }

        public void onInvalidated() {
            TabLayout.this.mo1088c();
        }
    }

    /* renamed from: android.support.design.widget.TabLayout$a */
    private class C0238a implements ViewPager.OnAdapterChangeListener {

        /* renamed from: b */
        private boolean f816b;

        C0238a() {
        }

        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            if (TabLayout.this.f801m == viewPager) {
                TabLayout.this.mo1076a(pagerAdapter2, this.f816b);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1108a(boolean z) {
            this.f816b = z;
        }
    }
}
