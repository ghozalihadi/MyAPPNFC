package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.design.R;
import android.support.p016v4.content.res.ResourcesCompat;
import android.support.p016v4.graphics.drawable.DrawableCompat;
import android.support.p016v4.view.AccessibilityDelegateCompat;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p016v4.widget.TextViewCompat;
import android.support.p019v7.appcompat.C0555R;
import android.support.p019v7.view.menu.MenuItemImpl;
import android.support.p019v7.view.menu.MenuView;
import android.support.p019v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {

    /* renamed from: d */
    private static final int[] f518d = {16842912};

    /* renamed from: c */
    boolean f519c;

    /* renamed from: e */
    private final int f520e;

    /* renamed from: f */
    private boolean f521f;

    /* renamed from: g */
    private final CheckedTextView f522g;

    /* renamed from: h */
    private FrameLayout f523h;

    /* renamed from: i */
    private MenuItemImpl f524i;

    /* renamed from: j */
    private ColorStateList f525j;

    /* renamed from: k */
    private boolean f526k;

    /* renamed from: l */
    private Drawable f527l;

    /* renamed from: m */
    private final AccessibilityDelegateCompat f528m;

    public NavigationMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f528m = new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.f519c);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.design_navigation_menu_item, this, true);
        this.f520e = context.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size);
        this.f522g = (CheckedTextView) findViewById(R.id.design_menu_item_text);
        this.f522g.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(this.f522g, this.f528m);
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.f524i = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ViewCompat.setBackground(this, m970d());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        m969c();
    }

    /* renamed from: b */
    private boolean m968b() {
        return this.f524i.getTitle() == null && this.f524i.getIcon() == null && this.f524i.getActionView() != null;
    }

    /* renamed from: c */
    private void m969c() {
        if (m968b()) {
            this.f522g.setVisibility(8);
            if (this.f523h != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) this.f523h.getLayoutParams();
                layoutParams.width = -1;
                this.f523h.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.f522g.setVisibility(0);
        if (this.f523h != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) this.f523h.getLayoutParams();
            layoutParams2.width = -2;
            this.f523h.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: a */
    public void mo613a() {
        if (this.f523h != null) {
            this.f523h.removeAllViews();
        }
        this.f522g.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f523h == null) {
                this.f523h = (FrameLayout) ((ViewStub) findViewById(R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.f523h.removeAllViews();
            this.f523h.addView(view);
        }
    }

    /* renamed from: d */
    private StateListDrawable m970d() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(C0555R.attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f518d, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public MenuItemImpl getItemData() {
        return this.f524i;
    }

    public void setTitle(CharSequence charSequence) {
        this.f522g.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f519c != z) {
            this.f519c = z;
            this.f528m.sendAccessibilityEvent(this.f522g, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f522g.setChecked(z);
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f526k) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                DrawableCompat.setTintList(drawable, this.f525j);
            }
            drawable.setBounds(0, 0, this.f520e, this.f520e);
        } else if (this.f521f) {
            if (this.f527l == null) {
                this.f527l = ResourcesCompat.getDrawable(getResources(), R.drawable.navigation_empty_icon, getContext().getTheme());
                if (this.f527l != null) {
                    this.f527l.setBounds(0, 0, this.f520e, this.f520e);
                }
            }
            drawable = this.f527l;
        }
        TextViewCompat.setCompoundDrawablesRelative(this.f522g, drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public boolean showsIcon() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f524i != null && this.f524i.isCheckable() && this.f524i.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f518d);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        this.f525j = colorStateList;
        this.f526k = this.f525j != null;
        if (this.f524i != null) {
            setIcon(this.f524i.getIcon());
        }
    }

    public void setTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.f522g, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f522g.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f521f = z;
    }
}
