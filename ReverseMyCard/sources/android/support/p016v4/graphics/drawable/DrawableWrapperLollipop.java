package android.support.p016v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.support.p016v4.graphics.drawable.DrawableWrapperGingerbread;

/* renamed from: android.support.v4.graphics.drawable.DrawableWrapperLollipop */
class DrawableWrapperLollipop extends DrawableWrapperKitKat {
    DrawableWrapperLollipop(Drawable drawable) {
        super(drawable);
    }

    DrawableWrapperLollipop(DrawableWrapperGingerbread.DrawableWrapperState drawableWrapperState, Resources resources) {
        super(drawableWrapperState, resources);
    }

    public void setHotspot(float f, float f2) {
        this.mDrawable.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.mDrawable.setHotspotBounds(i, i2, i3, i4);
    }

    public void getOutline(Outline outline) {
        this.mDrawable.getOutline(outline);
    }

    public Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    public void setTintList(ColorStateList colorStateList) {
        if (isCompatTintEnabled()) {
            super.setTintList(colorStateList);
        } else {
            this.mDrawable.setTintList(colorStateList);
        }
    }

    public void setTint(int i) {
        if (isCompatTintEnabled()) {
            super.setTint(i);
        } else {
            this.mDrawable.setTint(i);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (isCompatTintEnabled()) {
            super.setTintMode(mode);
        } else {
            this.mDrawable.setTintMode(mode);
        }
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isCompatTintEnabled() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.mDrawable;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public DrawableWrapperGingerbread.DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateLollipop(this.mState, (Resources) null);
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableWrapperLollipop$DrawableWrapperStateLollipop */
    private static class DrawableWrapperStateLollipop extends DrawableWrapperGingerbread.DrawableWrapperState {
        DrawableWrapperStateLollipop(DrawableWrapperGingerbread.DrawableWrapperState drawableWrapperState, Resources resources) {
            super(drawableWrapperState, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new DrawableWrapperLollipop(this, resources);
        }
    }
}
