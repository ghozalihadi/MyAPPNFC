package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.p016v4.content.ContextCompat;
import android.support.p016v4.graphics.drawable.DrawableCompat;
import android.support.p016v4.view.ViewCompat;
import android.support.p019v7.view.menu.MenuItemImpl;
import android.support.p019v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {

    /* renamed from: a */
    private static final int[] f484a = {16842912};

    /* renamed from: b */
    private final int f485b;

    /* renamed from: c */
    private final int f486c;

    /* renamed from: d */
    private final float f487d;

    /* renamed from: e */
    private final float f488e;

    /* renamed from: f */
    private boolean f489f;

    /* renamed from: g */
    private ImageView f490g;

    /* renamed from: h */
    private final TextView f491h;

    /* renamed from: i */
    private final TextView f492i;

    /* renamed from: j */
    private int f493j;

    /* renamed from: k */
    private MenuItemImpl f494k;

    /* renamed from: l */
    private ColorStateList f495l;

    public BottomNavigationItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f493j = -1;
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_text_size);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_text_size);
        this.f485b = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
        this.f486c = dimensionPixelSize - dimensionPixelSize2;
        this.f487d = (((float) dimensionPixelSize2) * 1.0f) / ((float) dimensionPixelSize);
        this.f488e = (((float) dimensionPixelSize) * 1.0f) / ((float) dimensionPixelSize2);
        LayoutInflater.from(context).inflate(R.layout.design_bottom_navigation_item, this, true);
        setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
        this.f490g = (ImageView) findViewById(R.id.icon);
        this.f491h = (TextView) findViewById(R.id.smallLabel);
        this.f492i = (TextView) findViewById(R.id.largeLabel);
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.f494k = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
    }

    public void setItemPosition(int i) {
        this.f493j = i;
    }

    public int getItemPosition() {
        return this.f493j;
    }

    public void setShiftingMode(boolean z) {
        this.f489f = z;
    }

    public MenuItemImpl getItemData() {
        return this.f494k;
    }

    public void setTitle(CharSequence charSequence) {
        this.f491h.setText(charSequence);
        this.f492i.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        this.f494k.setChecked(z);
        ViewCompat.setPivotX(this.f492i, (float) (this.f492i.getWidth() / 2));
        ViewCompat.setPivotY(this.f492i, (float) this.f492i.getBaseline());
        ViewCompat.setPivotX(this.f491h, (float) (this.f491h.getWidth() / 2));
        ViewCompat.setPivotY(this.f491h, (float) this.f491h.getBaseline());
        if (this.f489f) {
            if (z) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f490g.getLayoutParams();
                layoutParams.gravity = 49;
                layoutParams.topMargin = this.f485b;
                this.f490g.setLayoutParams(layoutParams);
                this.f492i.setVisibility(0);
                ViewCompat.setScaleX(this.f492i, 1.0f);
                ViewCompat.setScaleY(this.f492i, 1.0f);
            } else {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f490g.getLayoutParams();
                layoutParams2.gravity = 17;
                layoutParams2.topMargin = this.f485b;
                this.f490g.setLayoutParams(layoutParams2);
                this.f492i.setVisibility(4);
                ViewCompat.setScaleX(this.f492i, 0.5f);
                ViewCompat.setScaleY(this.f492i, 0.5f);
            }
            this.f491h.setVisibility(4);
        } else if (z) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f490g.getLayoutParams();
            layoutParams3.gravity = 49;
            layoutParams3.topMargin = this.f485b + this.f486c;
            this.f490g.setLayoutParams(layoutParams3);
            this.f492i.setVisibility(0);
            this.f491h.setVisibility(4);
            ViewCompat.setScaleX(this.f492i, 1.0f);
            ViewCompat.setScaleY(this.f492i, 1.0f);
            ViewCompat.setScaleX(this.f491h, this.f487d);
            ViewCompat.setScaleY(this.f491h, this.f487d);
        } else {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.f490g.getLayoutParams();
            layoutParams4.gravity = 49;
            layoutParams4.topMargin = this.f485b;
            this.f490g.setLayoutParams(layoutParams4);
            this.f492i.setVisibility(4);
            this.f491h.setVisibility(0);
            ViewCompat.setScaleX(this.f492i, this.f488e);
            ViewCompat.setScaleY(this.f492i, this.f488e);
            ViewCompat.setScaleX(this.f491h, 1.0f);
            ViewCompat.setScaleY(this.f491h, 1.0f);
        }
        refreshDrawableState();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f491h.setEnabled(z);
        this.f492i.setEnabled(z);
        this.f490g.setEnabled(z);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f494k != null && this.f494k.isCheckable() && this.f494k.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f484a);
        }
        return onCreateDrawableState;
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(drawable, this.f495l);
        }
        this.f490g.setImageDrawable(drawable);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public boolean showsIcon() {
        return true;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f495l = colorStateList;
        if (this.f494k != null) {
            setIcon(this.f494k.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f491h.setTextColor(colorStateList);
        this.f492i.setTextColor(colorStateList);
    }

    public void setItemBackground(int i) {
        Drawable drawable;
        if (i == 0) {
            drawable = null;
        } else {
            drawable = ContextCompat.getDrawable(getContext(), i);
        }
        ViewCompat.setBackground(this, drawable);
    }
}
