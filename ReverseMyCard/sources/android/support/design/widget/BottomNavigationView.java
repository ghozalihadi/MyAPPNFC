package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.design.R;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.C0169c;
import android.support.design.internal.C0170d;
import android.support.p019v7.appcompat.C0555R;
import android.support.p019v7.content.res.AppCompatResources;
import android.support.p019v7.view.SupportMenuInflater;
import android.support.p019v7.view.menu.MenuBuilder;
import android.support.p019v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class BottomNavigationView extends FrameLayout {

    /* renamed from: a */
    private static final int[] f592a = {16842912};

    /* renamed from: b */
    private static final int[] f593b = {-16842910};

    /* renamed from: c */
    private final MenuBuilder f594c;

    /* renamed from: d */
    private final BottomNavigationMenuView f595d;

    /* renamed from: e */
    private final C0170d f596e;

    /* renamed from: f */
    private MenuInflater f597f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0194a f598g;

    /* renamed from: android.support.design.widget.BottomNavigationView$a */
    public interface C0194a {
        /* renamed from: a */
        boolean mo774a(MenuItem menuItem);
    }

    public BottomNavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f596e = new C0170d();
        C0291r.m1597a(context);
        this.f594c = new C0169c(context);
        this.f595d = new BottomNavigationMenuView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f595d.setLayoutParams(layoutParams);
        this.f596e.mo634a(this.f595d);
        this.f595d.setPresenter(this.f596e);
        this.f594c.addMenuPresenter(this.f596e);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.BottomNavigationView, i, R.style.Widget_Design_BottomNavigationView);
        if (obtainStyledAttributes.hasValue(R.styleable.BottomNavigationView_itemIconTint)) {
            this.f595d.setIconTintList(obtainStyledAttributes.getColorStateList(R.styleable.BottomNavigationView_itemIconTint));
        } else {
            this.f595d.setIconTintList(m1088b(16842808));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BottomNavigationView_itemTextColor)) {
            this.f595d.setItemTextColor(obtainStyledAttributes.getColorStateList(R.styleable.BottomNavigationView_itemTextColor));
        } else {
            this.f595d.setItemTextColor(m1088b(16842808));
        }
        this.f595d.setItemBackgroundRes(obtainStyledAttributes.getResourceId(R.styleable.BottomNavigationView_itemBackground, 0));
        if (obtainStyledAttributes.hasValue(R.styleable.BottomNavigationView_menu)) {
            mo762a(obtainStyledAttributes.getResourceId(R.styleable.BottomNavigationView_menu, 0));
        }
        obtainStyledAttributes.recycle();
        addView(this.f595d, layoutParams);
        this.f594c.setCallback(new MenuBuilder.Callback() {
            public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                return BottomNavigationView.this.f598g != null && BottomNavigationView.this.f598g.mo774a(menuItem);
            }

            public void onMenuModeChange(MenuBuilder menuBuilder) {
            }
        });
    }

    public void setOnNavigationItemSelectedListener(C0194a aVar) {
        this.f598g = aVar;
    }

    public Menu getMenu() {
        return this.f594c;
    }

    /* renamed from: a */
    public void mo762a(int i) {
        this.f596e.mo635a(true);
        getMenuInflater().inflate(i, this.f594c);
        this.f596e.initForMenu(getContext(), this.f594c);
        this.f596e.mo635a(false);
        this.f596e.updateMenuView(true);
    }

    public int getMaxItemCount() {
        return 5;
    }

    public ColorStateList getItemIconTintList() {
        return this.f595d.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f595d.setIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.f595d.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f595d.setItemTextColor(colorStateList);
    }

    public int getItemBackgroundResource() {
        return this.f595d.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i) {
        this.f595d.setItemBackgroundRes(i);
    }

    private MenuInflater getMenuInflater() {
        if (this.f597f == null) {
            this.f597f = new SupportMenuInflater(getContext());
        }
        return this.f597f;
    }

    /* renamed from: b */
    private ColorStateList m1088b(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(C0555R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        return new ColorStateList(new int[][]{f593b, f592a, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(f593b, defaultColor), i2, defaultColor});
    }
}
