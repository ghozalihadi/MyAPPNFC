package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.R;
import android.support.design.internal.C0171e;
import android.support.design.internal.C0172f;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.p016v4.content.ContextCompat;
import android.support.p016v4.p018os.ParcelableCompat;
import android.support.p016v4.p018os.ParcelableCompatCreatorCallbacks;
import android.support.p016v4.view.AbsSavedState;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.view.WindowInsetsCompat;
import android.support.p019v7.appcompat.C0555R;
import android.support.p019v7.content.res.AppCompatResources;
import android.support.p019v7.view.SupportMenuInflater;
import android.support.p019v7.view.menu.MenuBuilder;
import android.support.p019v7.view.menu.MenuItemImpl;
import android.support.p019v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class NavigationView extends ScrimInsetsFrameLayout {

    /* renamed from: d */
    private static final int[] f726d = {16842912};

    /* renamed from: e */
    private static final int[] f727e = {-16842910};

    /* renamed from: c */
    C0217a f728c;

    /* renamed from: f */
    private final C0171e f729f;

    /* renamed from: g */
    private final C0172f f730g;

    /* renamed from: h */
    private int f731h;

    /* renamed from: i */
    private MenuInflater f732i;

    /* renamed from: android.support.design.widget.NavigationView$a */
    public interface C0217a {
        /* renamed from: a */
        boolean mo1015a(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ColorStateList c;
        int i2;
        boolean z;
        this.f730g = new C0172f();
        C0291r.m1597a(context);
        this.f729f = new C0171e(context);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.NavigationView, i, R.style.Widget_Design_NavigationView);
        ViewCompat.setBackground(this, obtainStyledAttributes.getDrawable(R.styleable.NavigationView_android_background));
        if (obtainStyledAttributes.hasValue(R.styleable.NavigationView_elevation)) {
            ViewCompat.setElevation(this, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationView_elevation, 0));
        }
        ViewCompat.setFitsSystemWindows(this, obtainStyledAttributes.getBoolean(R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.f731h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationView_android_maxWidth, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.NavigationView_itemIconTint)) {
            c = obtainStyledAttributes.getColorStateList(R.styleable.NavigationView_itemIconTint);
        } else {
            c = m1250c(16842808);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.NavigationView_itemTextAppearance)) {
            i2 = obtainStyledAttributes.getResourceId(R.styleable.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            i2 = 0;
            z = false;
        }
        ColorStateList colorStateList = obtainStyledAttributes.hasValue(R.styleable.NavigationView_itemTextColor) ? obtainStyledAttributes.getColorStateList(R.styleable.NavigationView_itemTextColor) : null;
        if (!z && colorStateList == null) {
            colorStateList = m1250c(16842806);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.NavigationView_itemBackground);
        this.f729f.setCallback(new MenuBuilder.Callback() {
            public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                return NavigationView.this.f728c != null && NavigationView.this.f728c.mo1015a(menuItem);
            }

            public void onMenuModeChange(MenuBuilder menuBuilder) {
            }
        });
        this.f730g.mo649a(1);
        this.f730g.initForMenu(context, this.f729f);
        this.f730g.mo650a(c);
        if (z) {
            this.f730g.mo660c(i2);
        }
        this.f730g.mo658b(colorStateList);
        this.f730g.mo651a(drawable);
        this.f729f.addMenuPresenter(this.f730g);
        addView((View) this.f730g.getMenuView(this));
        if (obtainStyledAttributes.hasValue(R.styleable.NavigationView_menu)) {
            mo996a(obtainStyledAttributes.getResourceId(R.styleable.NavigationView_menu, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.NavigationView_headerLayout)) {
            mo997b(obtainStyledAttributes.getResourceId(R.styleable.NavigationView_headerLayout, 0));
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f734a = new Bundle();
        this.f729f.savePresenterStates(savedState.f734a);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f729f.restorePresenterStates(savedState.f734a);
    }

    public void setNavigationItemSelectedListener(C0217a aVar) {
        this.f728c = aVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        switch (View.MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.f731h), 1073741824);
                break;
            case 0:
                i = View.MeasureSpec.makeMeasureSpec(this.f731h, 1073741824);
                break;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo626a(WindowInsetsCompat windowInsetsCompat) {
        this.f730g.mo652a(windowInsetsCompat);
    }

    /* renamed from: a */
    public void mo996a(int i) {
        this.f730g.mo655a(true);
        getMenuInflater().inflate(i, this.f729f);
        this.f730g.mo655a(false);
        this.f730g.updateMenuView(false);
    }

    public Menu getMenu() {
        return this.f729f;
    }

    /* renamed from: b */
    public View mo997b(int i) {
        return this.f730g.mo657b(i);
    }

    public int getHeaderCount() {
        return this.f730g.mo648a();
    }

    public ColorStateList getItemIconTintList() {
        return this.f730g.mo656b();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f730g.mo650a(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.f730g.mo659c();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f730g.mo658b(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.f730g.mo661d();
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        this.f730g.mo651a(drawable);
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.f729f.findItem(i);
        if (findItem != null) {
            this.f730g.mo653a((MenuItemImpl) findItem);
        }
    }

    public void setItemTextAppearance(int i) {
        this.f730g.mo660c(i);
    }

    private MenuInflater getMenuInflater() {
        if (this.f732i == null) {
            this.f732i = new SupportMenuInflater(getContext());
        }
        return this.f732i;
    }

    /* renamed from: c */
    private ColorStateList m1250c(int i) {
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
        return new ColorStateList(new int[][]{f727e, f726d, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(f727e, defaultColor), i2, defaultColor});
    }

    public static class SavedState extends AbsSavedState {
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
        public Bundle f734a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f734a = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f734a);
        }
    }
}
