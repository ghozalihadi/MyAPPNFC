package android.support.p014a.p015a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.p016v4.graphics.drawable.DrawableCompat;
import android.support.p016v4.graphics.drawable.TintAwareDrawable;
import android.util.AttributeSet;

@TargetApi(21)
/* renamed from: android.support.a.a.e */
/* compiled from: VectorDrawableCommon */
abstract class C0151e extends Drawable implements TintAwareDrawable {

    /* renamed from: b */
    Drawable f414b;

    C0151e() {
    }

    /* renamed from: b */
    static TypedArray m914b(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void setColorFilter(int i, PorterDuff.Mode mode) {
        if (this.f414b != null) {
            this.f414b.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.f414b != null) {
            return DrawableCompat.getColorFilter(this.f414b);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        if (this.f414b != null) {
            return this.f414b.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f414b != null) {
            this.f414b.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f414b != null) {
            DrawableCompat.setHotspot(this.f414b, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f414b != null) {
            DrawableCompat.setHotspotBounds(this.f414b, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f414b != null) {
            this.f414b.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.f414b != null) {
            DrawableCompat.jumpToCurrentState(this.f414b);
        }
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.f414b != null) {
            DrawableCompat.applyTheme(this.f414b, theme);
        }
    }

    public void clearColorFilter() {
        if (this.f414b != null) {
            this.f414b.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.f414b != null) {
            return this.f414b.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.f414b != null) {
            return this.f414b.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.f414b != null) {
            return this.f414b.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.f414b != null) {
            return this.f414b.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.f414b != null) {
            return this.f414b.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.f414b != null) {
            return this.f414b.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.f414b != null) {
            this.f414b.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.f414b != null) {
            return this.f414b.setState(iArr);
        }
        return super.setState(iArr);
    }
}
