package android.support.p019v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p016v4.widget.TintableCompoundButton;
import android.support.p019v7.appcompat.C0555R;
import android.support.p019v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* renamed from: android.support.v7.widget.AppCompatCheckBox */
public class AppCompatCheckBox extends CheckBox implements TintableCompoundButton {
    private AppCompatCompoundButtonHelper mCompoundButtonHelper;

    public AppCompatCheckBox(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0555R.attr.checkboxStyle);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        this.mCompoundButtonHelper = new AppCompatCompoundButtonHelper(this);
        this.mCompoundButtonHelper.loadFromAttributes(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.mCompoundButtonHelper != null) {
            this.mCompoundButtonHelper.onSetButtonDrawable();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.mCompoundButtonHelper != null ? this.mCompoundButtonHelper.getCompoundPaddingLeft(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.mCompoundButtonHelper != null) {
            this.mCompoundButtonHelper.setSupportButtonTintList(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.mCompoundButtonHelper != null) {
            return this.mCompoundButtonHelper.getSupportButtonTintList();
        }
        return null;
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.mCompoundButtonHelper != null) {
            this.mCompoundButtonHelper.setSupportButtonTintMode(mode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.mCompoundButtonHelper != null) {
            return this.mCompoundButtonHelper.getSupportButtonTintMode();
        }
        return null;
    }
}
