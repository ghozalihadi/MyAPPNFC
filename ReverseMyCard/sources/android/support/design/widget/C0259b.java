package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.p016v4.graphics.ColorUtils;

/* renamed from: android.support.design.widget.b */
/* compiled from: CircularBorderDrawable */
class C0259b extends Drawable {

    /* renamed from: a */
    final Paint f906a = new Paint(1);

    /* renamed from: b */
    final Rect f907b = new Rect();

    /* renamed from: c */
    final RectF f908c = new RectF();

    /* renamed from: d */
    float f909d;

    /* renamed from: e */
    private int f910e;

    /* renamed from: f */
    private int f911f;

    /* renamed from: g */
    private int f912g;

    /* renamed from: h */
    private int f913h;

    /* renamed from: i */
    private ColorStateList f914i;

    /* renamed from: j */
    private int f915j;

    /* renamed from: k */
    private boolean f916k = true;

    /* renamed from: l */
    private float f917l;

    public C0259b() {
        this.f906a.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1203a(int i, int i2, int i3, int i4) {
        this.f910e = i;
        this.f911f = i2;
        this.f912g = i3;
        this.f913h = i4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1202a(float f) {
        if (this.f909d != f) {
            this.f909d = f;
            this.f906a.setStrokeWidth(1.3333f * f);
            this.f916k = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f916k) {
            this.f906a.setShader(m1406a());
            this.f916k = false;
        }
        float strokeWidth = this.f906a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f908c;
        copyBounds(this.f907b);
        rectF.set(this.f907b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f917l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f906a);
        canvas.restore();
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f909d);
        rect.set(round, round, round, round);
        return true;
    }

    public void setAlpha(int i) {
        this.f906a.setAlpha(i);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1204a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f915j = colorStateList.getColorForState(getState(), this.f915j);
        }
        this.f914i = colorStateList;
        this.f916k = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f906a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.f909d > 0.0f ? -3 : -2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo1205b(float f) {
        if (f != this.f917l) {
            this.f917l = f;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f916k = true;
    }

    public boolean isStateful() {
        return (this.f914i != null && this.f914i.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        if (!(this.f914i == null || (colorForState = this.f914i.getColorForState(iArr, this.f915j)) == this.f915j)) {
            this.f916k = true;
            this.f915j = colorForState;
        }
        if (this.f916k) {
            invalidateSelf();
        }
        return this.f916k;
    }

    /* renamed from: a */
    private Shader m1406a() {
        Rect rect = this.f907b;
        copyBounds(rect);
        float height = this.f909d / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{ColorUtils.compositeColors(this.f910e, this.f915j), ColorUtils.compositeColors(this.f911f, this.f915j), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f911f, 0), this.f915j), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f913h, 0), this.f915j), ColorUtils.compositeColors(this.f913h, this.f915j), ColorUtils.compositeColors(this.f912g, this.f915j)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }
}
