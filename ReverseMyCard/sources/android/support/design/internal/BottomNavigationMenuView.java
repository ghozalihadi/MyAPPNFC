package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.support.design.R;
import android.support.p016v4.util.Pools;
import android.support.p016v4.view.ViewCompat;
import android.support.p019v7.view.menu.MenuBuilder;
import android.support.p019v7.view.menu.MenuItemImpl;
import android.support.p019v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BottomNavigationMenuView extends ViewGroup implements MenuView {

    /* renamed from: g */
    private static final Pools.Pool<BottomNavigationItemView> f496g = new Pools.SynchronizedPool(5);

    /* renamed from: a */
    private final int f497a;

    /* renamed from: b */
    private final int f498b;

    /* renamed from: c */
    private final int f499c;

    /* renamed from: d */
    private final int f500d;

    /* renamed from: e */
    private final View.OnClickListener f501e;

    /* renamed from: f */
    private final C0167a f502f;

    /* renamed from: h */
    private boolean f503h;

    /* renamed from: i */
    private BottomNavigationItemView[] f504i;

    /* renamed from: j */
    private int f505j;

    /* renamed from: k */
    private ColorStateList f506k;

    /* renamed from: l */
    private ColorStateList f507l;

    /* renamed from: m */
    private int f508m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C0170d f509n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public MenuBuilder f510o;

    public BottomNavigationMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f503h = true;
        this.f505j = 0;
        Resources resources = getResources();
        this.f497a = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.f498b = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.f499c = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.f500d = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
        if (Build.VERSION.SDK_INT >= 14) {
            this.f502f = new C0168b();
        } else {
            this.f502f = new C0167a();
        }
        this.f501e = new View.OnClickListener() {
            public void onClick(View view) {
                BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) view;
                BottomNavigationMenuView.this.m963a(bottomNavigationItemView.getItemPosition());
                BottomNavigationMenuView.this.f510o.performItemAction(bottomNavigationItemView.getItemData(), BottomNavigationMenuView.this.f509n, 0);
            }
        };
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.f510o = menuBuilder;
        if (this.f510o != null && this.f510o.size() > this.f505j) {
            this.f510o.getItem(this.f505j).setChecked(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f500d, 1073741824);
        int[] iArr = new int[childCount];
        if (this.f503h) {
            int i5 = childCount - 1;
            int min = Math.min(size - (this.f498b * i5), this.f499c);
            int min2 = Math.min((size - min) / i5, this.f497a);
            int i6 = (size - min) - (i5 * min2);
            int i7 = 0;
            while (i7 < childCount) {
                if (i7 == this.f505j) {
                    i3 = min;
                } else {
                    i3 = min2;
                }
                iArr[i7] = i3;
                if (i6 > 0) {
                    iArr[i7] = iArr[i7] + 1;
                    i4 = i6 - 1;
                } else {
                    i4 = i6;
                }
                i7++;
                i6 = i4;
            }
        } else {
            int min3 = Math.min(size / childCount, this.f499c);
            int i8 = size - (min3 * childCount);
            for (int i9 = 0; i9 < childCount; i9++) {
                iArr[i9] = min3;
                if (i8 > 0) {
                    iArr[i9] = iArr[i9] + 1;
                    i8--;
                }
            }
        }
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(iArr[i11], 1073741824), makeMeasureSpec);
                childAt.getLayoutParams().width = childAt.getMeasuredWidth();
                i10 += childAt.getMeasuredWidth();
            }
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(i10, View.MeasureSpec.makeMeasureSpec(i10, 1073741824), 0), ViewCompat.resolveSizeAndState(this.f500d, makeMeasureSpec, 0));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    childAt.layout((i5 - i7) - childAt.getMeasuredWidth(), 0, i5 - i7, i6);
                } else {
                    childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                }
                i7 += childAt.getMeasuredWidth();
            }
        }
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f506k = colorStateList;
        if (this.f504i != null) {
            for (BottomNavigationItemView iconTintList : this.f504i) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.f506k;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f507l = colorStateList;
        if (this.f504i != null) {
            for (BottomNavigationItemView textColor : this.f504i) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.f507l;
    }

    public void setItemBackgroundRes(int i) {
        this.f508m = i;
        if (this.f504i != null) {
            for (BottomNavigationItemView itemBackground : this.f504i) {
                itemBackground.setItemBackground(i);
            }
        }
    }

    public int getItemBackgroundRes() {
        return this.f508m;
    }

    public void setPresenter(C0170d dVar) {
        this.f509n = dVar;
    }

    /* renamed from: a */
    public void mo588a() {
        boolean z;
        if (this.f504i != null) {
            for (BottomNavigationItemView release : this.f504i) {
                f496g.release(release);
            }
        }
        removeAllViews();
        this.f504i = new BottomNavigationItemView[this.f510o.size()];
        if (this.f510o.size() > 3) {
            z = true;
        } else {
            z = false;
        }
        this.f503h = z;
        for (int i = 0; i < this.f510o.size(); i++) {
            this.f509n.mo635a(true);
            this.f510o.getItem(i).setCheckable(true);
            this.f509n.mo635a(false);
            BottomNavigationItemView newItem = getNewItem();
            this.f504i[i] = newItem;
            newItem.setIconTintList(this.f506k);
            newItem.setTextColor(this.f507l);
            newItem.setItemBackground(this.f508m);
            newItem.setShiftingMode(this.f503h);
            newItem.initialize((MenuItemImpl) this.f510o.getItem(i), 0);
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.f501e);
            addView(newItem);
        }
    }

    /* renamed from: b */
    public void mo589b() {
        int size = this.f510o.size();
        if (size != this.f504i.length) {
            mo588a();
            return;
        }
        for (int i = 0; i < size; i++) {
            this.f509n.mo635a(true);
            this.f504i[i].initialize((MenuItemImpl) this.f510o.getItem(i), 0);
            this.f509n.mo635a(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m963a(int i) {
        if (this.f505j != i) {
            this.f502f.mo631a(this);
            this.f509n.mo635a(true);
            this.f504i[this.f505j].setChecked(false);
            this.f504i[i].setChecked(true);
            this.f509n.mo635a(false);
            this.f505j = i;
        }
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView acquire = f496g.acquire();
        if (acquire == null) {
            return new BottomNavigationItemView(getContext());
        }
        return acquire;
    }
}
