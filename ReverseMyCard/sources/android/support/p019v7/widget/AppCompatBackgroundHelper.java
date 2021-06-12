package android.support.p019v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p016v4.view.ViewCompat;
import android.support.p019v7.appcompat.C0555R;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v7.widget.AppCompatBackgroundHelper */
class AppCompatBackgroundHelper {
    private int mBackgroundResId = -1;
    private BackgroundTintInfo mBackgroundTint;
    private final AppCompatDrawableManager mDrawableManager;
    private BackgroundTintInfo mInternalBackgroundTint;
    private BackgroundTintInfo mTmpInfo;
    private final View mView;

    AppCompatBackgroundHelper(View view) {
        this.mView = view;
        this.mDrawableManager = AppCompatDrawableManager.get();
    }

    /* access modifiers changed from: package-private */
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, C0555R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0555R.styleable.ViewBackgroundHelper_android_background)) {
                this.mBackgroundResId = obtainStyledAttributes.getResourceId(C0555R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList tintList = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);
                if (tintList != null) {
                    setInternalBackgroundTint(tintList);
                }
            }
            if (obtainStyledAttributes.hasValue(C0555R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList(this.mView, obtainStyledAttributes.getColorStateList(C0555R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(C0555R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(C0555R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public void onSetBackgroundResource(int i) {
        this.mBackgroundResId = i;
        setInternalBackgroundTint(this.mDrawableManager != null ? this.mDrawableManager.getTintList(this.mView.getContext(), i) : null);
        if (updateBackgroundTint()) {
            applySupportBackgroundTint();
        }
    }

    /* access modifiers changed from: package-private */
    public void onSetBackgroundDrawable(Drawable drawable) {
        this.mBackgroundResId = -1;
        setInternalBackgroundTint((ColorStateList) null);
        if (updateBackgroundTint()) {
            applySupportBackgroundTint();
        }
    }

    /* access modifiers changed from: package-private */
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new BackgroundTintInfo();
        }
        this.mBackgroundTint.mOriginalTintList = colorStateList;
        this.mBackgroundTint.mTintList = null;
        this.mBackgroundTint.mHasTintList = true;
        if (updateBackgroundTint()) {
            applySupportBackgroundTint();
        }
    }

    private boolean updateBackgroundTint() {
        ColorStateList tintList;
        if (this.mBackgroundTint != null && this.mBackgroundTint.mHasTintList) {
            if (this.mBackgroundResId >= 0 && (tintList = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId, this.mBackgroundTint.mOriginalTintList)) != null) {
                this.mBackgroundTint.mTintList = tintList;
                return true;
            } else if (this.mBackgroundTint.mTintList != this.mBackgroundTint.mOriginalTintList) {
                this.mBackgroundTint.mTintList = this.mBackgroundTint.mOriginalTintList;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getSupportBackgroundTintList() {
        if (this.mBackgroundTint != null) {
            return this.mBackgroundTint.mTintList;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new BackgroundTintInfo();
        }
        this.mBackgroundTint.mTintMode = mode;
        this.mBackgroundTint.mHasTintMode = true;
        applySupportBackgroundTint();
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.mBackgroundTint != null) {
            return this.mBackgroundTint.mTintMode;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void applySupportBackgroundTint() {
        Drawable background = this.mView.getBackground();
        if (background == null) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && applyFrameworkTintUsingColorFilter(background)) {
            return;
        }
        if (this.mBackgroundTint != null) {
            AppCompatDrawableManager.tintDrawable(background, this.mBackgroundTint, this.mView.getDrawableState());
        } else if (this.mInternalBackgroundTint != null) {
            AppCompatDrawableManager.tintDrawable(background, this.mInternalBackgroundTint, this.mView.getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalBackgroundTint == null) {
                this.mInternalBackgroundTint = new BackgroundTintInfo();
            }
            this.mInternalBackgroundTint.mTintList = colorStateList;
            this.mInternalBackgroundTint.mHasTintList = true;
        } else {
            this.mInternalBackgroundTint = null;
        }
        applySupportBackgroundTint();
    }

    private boolean applyFrameworkTintUsingColorFilter(Drawable drawable) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new BackgroundTintInfo();
        }
        BackgroundTintInfo backgroundTintInfo = this.mTmpInfo;
        backgroundTintInfo.clear();
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.mView);
        if (backgroundTintList != null) {
            backgroundTintInfo.mHasTintList = true;
            backgroundTintInfo.mTintList = backgroundTintList;
        }
        PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.mView);
        if (backgroundTintMode != null) {
            backgroundTintInfo.mHasTintMode = true;
            backgroundTintInfo.mTintMode = backgroundTintMode;
        }
        if (!backgroundTintInfo.mHasTintList && !backgroundTintInfo.mHasTintMode) {
            return false;
        }
        AppCompatDrawableManager.tintDrawable(drawable, backgroundTintInfo, this.mView.getDrawableState());
        return true;
    }

    /* renamed from: android.support.v7.widget.AppCompatBackgroundHelper$BackgroundTintInfo */
    private static class BackgroundTintInfo extends TintInfo {
        public ColorStateList mOriginalTintList;

        BackgroundTintInfo() {
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            super.clear();
            this.mOriginalTintList = null;
        }
    }
}
