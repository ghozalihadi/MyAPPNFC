package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.p016v4.content.ContextCompat;
import android.support.p019v7.graphics.drawable.DrawableWrapper;

/* renamed from: android.support.design.widget.n */
/* compiled from: ShadowDrawableWrapper */
class C0282n extends DrawableWrapper {

    /* renamed from: a */
    static final double f1025a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: b */
    final Paint f1026b;

    /* renamed from: c */
    final Paint f1027c;

    /* renamed from: d */
    final RectF f1028d;

    /* renamed from: e */
    float f1029e;

    /* renamed from: f */
    Path f1030f;

    /* renamed from: g */
    float f1031g;

    /* renamed from: h */
    float f1032h;

    /* renamed from: i */
    float f1033i;

    /* renamed from: j */
    float f1034j;

    /* renamed from: k */
    private boolean f1035k = true;

    /* renamed from: l */
    private final int f1036l;

    /* renamed from: m */
    private final int f1037m;

    /* renamed from: n */
    private final int f1038n;

    /* renamed from: o */
    private boolean f1039o = true;

    /* renamed from: p */
    private float f1040p;

    /* renamed from: q */
    private boolean f1041q = false;

    public C0282n(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.f1036l = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.f1037m = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.f1038n = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        this.f1026b = new Paint(5);
        this.f1026b.setStyle(Paint.Style.FILL);
        this.f1029e = (float) Math.round(f);
        this.f1028d = new RectF();
        this.f1027c = new Paint(this.f1026b);
        this.f1027c.setAntiAlias(false);
        mo1296a(f2, f3);
    }

    /* renamed from: c */
    private static int m1564c(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    /* renamed from: a */
    public void mo1297a(boolean z) {
        this.f1039o = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f1026b.setAlpha(i);
        this.f1027c.setAlpha(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f1035k = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1296a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float c = (float) m1564c(f);
        float c2 = (float) m1564c(f2);
        if (c > c2) {
            if (!this.f1041q) {
                this.f1041q = true;
            }
            c = c2;
        }
        if (this.f1034j != c || this.f1032h != c2) {
            this.f1034j = c;
            this.f1032h = c2;
            this.f1033i = (float) Math.round(c * 1.5f);
            this.f1031g = c2;
            this.f1035k = true;
            invalidateSelf();
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m1559a(this.f1032h, this.f1029e, this.f1039o));
        int ceil2 = (int) Math.ceil((double) m1562b(this.f1032h, this.f1029e, this.f1039o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* renamed from: a */
    public static float m1559a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - f1025a) * ((double) f2)));
        }
        return 1.5f * f;
    }

    /* renamed from: b */
    public static float m1562b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - f1025a) * ((double) f2)));
        }
        return f;
    }

    public int getOpacity() {
        return -3;
    }

    public void draw(Canvas canvas) {
        if (this.f1035k) {
            m1561a(getBounds());
            this.f1035k = false;
        }
        m1560a(canvas);
        super.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo1295a(float f) {
        if (this.f1040p != f) {
            this.f1040p = f;
            invalidateSelf();
        }
    }

    /* renamed from: a */
    private void m1560a(Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(this.f1040p, this.f1028d.centerX(), this.f1028d.centerY());
        float f = (-this.f1029e) - this.f1033i;
        float f2 = this.f1029e;
        boolean z = this.f1028d.width() - (2.0f * f2) > 0.0f;
        boolean z2 = this.f1028d.height() - (2.0f * f2) > 0.0f;
        float f3 = this.f1034j - (this.f1034j * 0.25f);
        float f4 = f2 / ((this.f1034j - (this.f1034j * 0.5f)) + f2);
        float f5 = f2 / (f3 + f2);
        float f6 = f2 / (f2 + (this.f1034j - (this.f1034j * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.f1028d.left + f2, this.f1028d.top + f2);
        canvas.scale(f4, f5);
        canvas.drawPath(this.f1030f, this.f1026b);
        if (z) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.f1028d.width() - (2.0f * f2), -this.f1029e, this.f1027c);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f1028d.right - f2, this.f1028d.bottom - f2);
        canvas.scale(f4, f6);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1030f, this.f1026b);
        if (z) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.f1028d.width() - (2.0f * f2), this.f1033i + (-this.f1029e), this.f1027c);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.f1028d.left + f2, this.f1028d.bottom - f2);
        canvas.scale(f4, f6);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1030f, this.f1026b);
        if (z2) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f, this.f1028d.height() - (2.0f * f2), -this.f1029e, this.f1027c);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        canvas.translate(this.f1028d.right - f2, this.f1028d.top + f2);
        canvas.scale(f4, f5);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1030f, this.f1026b);
        if (z2) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.f1028d.height() - (2.0f * f2), -this.f1029e, this.f1027c);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(save);
    }

    /* renamed from: b */
    private void m1563b() {
        RectF rectF = new RectF(-this.f1029e, -this.f1029e, this.f1029e, this.f1029e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f1033i, -this.f1033i);
        if (this.f1030f == null) {
            this.f1030f = new Path();
        } else {
            this.f1030f.reset();
        }
        this.f1030f.setFillType(Path.FillType.EVEN_ODD);
        this.f1030f.moveTo(-this.f1029e, 0.0f);
        this.f1030f.rLineTo(-this.f1033i, 0.0f);
        this.f1030f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1030f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1030f.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.f1029e / f;
            this.f1026b.setShader(new RadialGradient(0.0f, 0.0f, f, new int[]{0, this.f1036l, this.f1037m, this.f1038n}, new float[]{0.0f, f2, f2 + ((1.0f - f2) / 2.0f), 1.0f}, Shader.TileMode.CLAMP));
        }
        this.f1027c.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.f1036l, this.f1037m, this.f1038n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1027c.setAntiAlias(false);
    }

    /* renamed from: a */
    private void m1561a(Rect rect) {
        float f = this.f1032h * 1.5f;
        this.f1028d.set(((float) rect.left) + this.f1032h, ((float) rect.top) + f, ((float) rect.right) - this.f1032h, ((float) rect.bottom) - f);
        getWrappedDrawable().setBounds((int) this.f1028d.left, (int) this.f1028d.top, (int) this.f1028d.right, (int) this.f1028d.bottom);
        m1563b();
    }

    /* renamed from: b */
    public void mo1298b(float f) {
        mo1296a(f, this.f1032h);
    }

    /* renamed from: a */
    public float mo1294a() {
        return this.f1034j;
    }
}
