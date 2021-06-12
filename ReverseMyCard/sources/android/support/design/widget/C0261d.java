package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.support.p016v4.text.TextDirectionHeuristicsCompat;
import android.support.p016v4.view.GravityCompat;
import android.support.p016v4.view.ViewCompat;
import android.support.p019v7.appcompat.C0555R;
import android.support.p019v7.widget.TintTypedArray;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;

/* renamed from: android.support.design.widget.d */
/* compiled from: CollapsingTextHelper */
final class C0261d {

    /* renamed from: a */
    private static final boolean f918a = (Build.VERSION.SDK_INT < 18);

    /* renamed from: b */
    private static final Paint f919b = null;

    /* renamed from: A */
    private boolean f920A;

    /* renamed from: B */
    private Bitmap f921B;

    /* renamed from: C */
    private Paint f922C;

    /* renamed from: D */
    private float f923D;

    /* renamed from: E */
    private float f924E;

    /* renamed from: F */
    private float f925F;

    /* renamed from: G */
    private float f926G;

    /* renamed from: H */
    private int[] f927H;

    /* renamed from: I */
    private boolean f928I;

    /* renamed from: J */
    private final TextPaint f929J;

    /* renamed from: K */
    private Interpolator f930K;

    /* renamed from: L */
    private Interpolator f931L;

    /* renamed from: M */
    private float f932M;

    /* renamed from: N */
    private float f933N;

    /* renamed from: O */
    private float f934O;

    /* renamed from: P */
    private int f935P;

    /* renamed from: Q */
    private float f936Q;

    /* renamed from: R */
    private float f937R;

    /* renamed from: S */
    private float f938S;

    /* renamed from: T */
    private int f939T;

    /* renamed from: c */
    private final View f940c;

    /* renamed from: d */
    private boolean f941d;

    /* renamed from: e */
    private float f942e;

    /* renamed from: f */
    private final Rect f943f;

    /* renamed from: g */
    private final Rect f944g;

    /* renamed from: h */
    private final RectF f945h;

    /* renamed from: i */
    private int f946i = 16;

    /* renamed from: j */
    private int f947j = 16;

    /* renamed from: k */
    private float f948k = 15.0f;

    /* renamed from: l */
    private float f949l = 15.0f;

    /* renamed from: m */
    private ColorStateList f950m;

    /* renamed from: n */
    private ColorStateList f951n;

    /* renamed from: o */
    private float f952o;

    /* renamed from: p */
    private float f953p;

    /* renamed from: q */
    private float f954q;

    /* renamed from: r */
    private float f955r;

    /* renamed from: s */
    private float f956s;

    /* renamed from: t */
    private float f957t;

    /* renamed from: u */
    private Typeface f958u;

    /* renamed from: v */
    private Typeface f959v;

    /* renamed from: w */
    private Typeface f960w;

    /* renamed from: x */
    private CharSequence f961x;

    /* renamed from: y */
    private CharSequence f962y;

    /* renamed from: z */
    private boolean f963z;

    static {
        if (f919b != null) {
            f919b.setAntiAlias(true);
            f919b.setColor(-65281);
        }
    }

    public C0261d(View view) {
        this.f940c = view;
        this.f929J = new TextPaint(129);
        this.f944g = new Rect();
        this.f943f = new Rect();
        this.f945h = new RectF();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1222a(Interpolator interpolator) {
        this.f931L = interpolator;
        mo1241i();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1231b(Interpolator interpolator) {
        this.f930K = interpolator;
        mo1241i();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1216a(float f) {
        if (this.f948k != f) {
            this.f948k = f;
            mo1241i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1219a(ColorStateList colorStateList) {
        if (this.f951n != colorStateList) {
            this.f951n = colorStateList;
            mo1241i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1229b(ColorStateList colorStateList) {
        if (this.f950m != colorStateList) {
            this.f950m = colorStateList;
            mo1241i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1218a(int i, int i2, int i3, int i4) {
        if (!m1414a(this.f943f, i, i2, i3, i4)) {
            this.f943f.set(i, i2, i3, i4);
            this.f928I = true;
            mo1215a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1228b(int i, int i2, int i3, int i4) {
        if (!m1414a(this.f944g, i, i2, i3, i4)) {
            this.f944g.set(i, i2, i3, i4);
            this.f928I = true;
            mo1215a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1215a() {
        this.f941d = this.f944g.width() > 0 && this.f944g.height() > 0 && this.f943f.width() > 0 && this.f943f.height() > 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1217a(int i) {
        if (this.f946i != i) {
            this.f946i = i;
            mo1241i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo1225b() {
        return this.f946i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1227b(int i) {
        if (this.f947j != i) {
            this.f947j = i;
            mo1241i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo1232c() {
        return this.f947j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo1233c(int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f940c.getContext(), i, C0555R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(C0555R.styleable.TextAppearance_android_textColor)) {
            this.f951n = obtainStyledAttributes.getColorStateList(C0555R.styleable.TextAppearance_android_textColor);
        }
        if (obtainStyledAttributes.hasValue(C0555R.styleable.TextAppearance_android_textSize)) {
            this.f949l = (float) obtainStyledAttributes.getDimensionPixelSize(C0555R.styleable.TextAppearance_android_textSize, (int) this.f949l);
        }
        this.f935P = obtainStyledAttributes.getInt(C0555R.styleable.TextAppearance_android_shadowColor, 0);
        this.f933N = obtainStyledAttributes.getFloat(C0555R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f934O = obtainStyledAttributes.getFloat(C0555R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f932M = obtainStyledAttributes.getFloat(C0555R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.f958u = m1418e(i);
        }
        mo1241i();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo1236d(int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f940c.getContext(), i, C0555R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(C0555R.styleable.TextAppearance_android_textColor)) {
            this.f950m = obtainStyledAttributes.getColorStateList(C0555R.styleable.TextAppearance_android_textColor);
        }
        if (obtainStyledAttributes.hasValue(C0555R.styleable.TextAppearance_android_textSize)) {
            this.f948k = (float) obtainStyledAttributes.getDimensionPixelSize(C0555R.styleable.TextAppearance_android_textSize, (int) this.f948k);
        }
        this.f939T = obtainStyledAttributes.getInt(C0555R.styleable.TextAppearance_android_shadowColor, 0);
        this.f937R = obtainStyledAttributes.getFloat(C0555R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f938S = obtainStyledAttributes.getFloat(C0555R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f936Q = obtainStyledAttributes.getFloat(C0555R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.f959v = m1418e(i);
        }
        mo1241i();
    }

    /* renamed from: e */
    private Typeface m1418e(int i) {
        TypedArray obtainStyledAttributes = this.f940c.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1221a(Typeface typeface) {
        if (this.f958u != typeface) {
            this.f958u = typeface;
            mo1241i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1230b(Typeface typeface) {
        if (this.f959v != typeface) {
            this.f959v = typeface;
            mo1241i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo1234c(Typeface typeface) {
        this.f959v = typeface;
        this.f958u = typeface;
        mo1241i();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Typeface mo1235d() {
        return this.f958u != null ? this.f958u : Typeface.DEFAULT;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Typeface mo1237e() {
        return this.f959v != null ? this.f959v : Typeface.DEFAULT;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1226b(float f) {
        float a = C0281m.m1557a(f, 0.0f, 1.0f);
        if (a != this.f942e) {
            this.f942e = a;
            m1421l();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo1224a(int[] iArr) {
        this.f927H = iArr;
        if (!mo1238f()) {
            return false;
        }
        mo1241i();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final boolean mo1238f() {
        return (this.f951n != null && this.f951n.isStateful()) || (this.f950m != null && this.f950m.isStateful());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public float mo1239g() {
        return this.f942e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public float mo1240h() {
        return this.f949l;
    }

    /* renamed from: l */
    private void m1421l() {
        m1416c(this.f942e);
    }

    /* renamed from: c */
    private void m1416c(float f) {
        m1417d(f);
        this.f956s = m1411a(this.f954q, this.f955r, f, this.f930K);
        this.f957t = m1411a(this.f952o, this.f953p, f, this.f930K);
        m1419e(m1411a(this.f948k, this.f949l, f, this.f931L));
        if (this.f951n != this.f950m) {
            this.f929J.setColor(m1412a(m1422m(), m1423n(), f));
        } else {
            this.f929J.setColor(m1423n());
        }
        this.f929J.setShadowLayer(m1411a(this.f936Q, this.f932M, f, (Interpolator) null), m1411a(this.f937R, this.f933N, f, (Interpolator) null), m1411a(this.f938S, this.f934O, f, (Interpolator) null), m1412a(this.f939T, this.f935P, f));
        ViewCompat.postInvalidateOnAnimation(this.f940c);
    }

    /* renamed from: m */
    private int m1422m() {
        if (this.f927H != null) {
            return this.f950m.getColorForState(this.f927H, 0);
        }
        return this.f950m.getDefaultColor();
    }

    /* renamed from: n */
    private int m1423n() {
        if (this.f927H != null) {
            return this.f951n.getColorForState(this.f927H, 0);
        }
        return this.f951n.getDefaultColor();
    }

    /* renamed from: o */
    private void m1424o() {
        int i;
        int i2 = 1;
        float f = 0.0f;
        float f2 = this.f926G;
        m1420f(this.f949l);
        float measureText = this.f962y != null ? this.f929J.measureText(this.f962y, 0, this.f962y.length()) : 0.0f;
        int i3 = this.f947j;
        if (this.f963z) {
            i = 1;
        } else {
            i = 0;
        }
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i3, i);
        switch (absoluteGravity & 112) {
            case 48:
                this.f953p = ((float) this.f944g.top) - this.f929J.ascent();
                break;
            case 80:
                this.f953p = (float) this.f944g.bottom;
                break;
            default:
                this.f953p = (((this.f929J.descent() - this.f929J.ascent()) / 2.0f) - this.f929J.descent()) + ((float) this.f944g.centerY());
                break;
        }
        switch (absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) {
            case 1:
                this.f955r = ((float) this.f944g.centerX()) - (measureText / 2.0f);
                break;
            case 5:
                this.f955r = ((float) this.f944g.right) - measureText;
                break;
            default:
                this.f955r = (float) this.f944g.left;
                break;
        }
        m1420f(this.f948k);
        if (this.f962y != null) {
            f = this.f929J.measureText(this.f962y, 0, this.f962y.length());
        }
        int i4 = this.f946i;
        if (!this.f963z) {
            i2 = 0;
        }
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(i4, i2);
        switch (absoluteGravity2 & 112) {
            case 48:
                this.f952o = ((float) this.f943f.top) - this.f929J.ascent();
                break;
            case 80:
                this.f952o = (float) this.f943f.bottom;
                break;
            default:
                this.f952o = (((this.f929J.descent() - this.f929J.ascent()) / 2.0f) - this.f929J.descent()) + ((float) this.f943f.centerY());
                break;
        }
        switch (absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) {
            case 1:
                this.f954q = ((float) this.f943f.centerX()) - (f / 2.0f);
                break;
            case 5:
                this.f954q = ((float) this.f943f.right) - f;
                break;
            default:
                this.f954q = (float) this.f943f.left;
                break;
        }
        m1426q();
        m1419e(f2);
    }

    /* renamed from: d */
    private void m1417d(float f) {
        this.f945h.left = m1411a((float) this.f943f.left, (float) this.f944g.left, f, this.f930K);
        this.f945h.top = m1411a(this.f952o, this.f953p, f, this.f930K);
        this.f945h.right = m1411a((float) this.f943f.right, (float) this.f944g.right, f, this.f930K);
        this.f945h.bottom = m1411a((float) this.f943f.bottom, (float) this.f944g.bottom, f, this.f930K);
    }

    /* renamed from: a */
    public void mo1220a(Canvas canvas) {
        float ascent;
        int save = canvas.save();
        if (this.f962y != null && this.f941d) {
            float f = this.f956s;
            float f2 = this.f957t;
            boolean z = this.f920A && this.f921B != null;
            if (z) {
                ascent = this.f923D * this.f925F;
                float f3 = this.f924E * this.f925F;
            } else {
                ascent = this.f929J.ascent() * this.f925F;
                float descent = this.f929J.descent() * this.f925F;
            }
            if (z) {
                f2 += ascent;
            }
            if (this.f925F != 1.0f) {
                canvas.scale(this.f925F, this.f925F, f, f2);
            }
            if (z) {
                canvas.drawBitmap(this.f921B, f, f2, this.f922C);
            } else {
                canvas.drawText(this.f962y, 0, this.f962y.length(), f, f2, this.f929J);
            }
        }
        canvas.restoreToCount(save);
    }

    /* renamed from: b */
    private boolean m1415b(CharSequence charSequence) {
        boolean z = true;
        if (ViewCompat.getLayoutDirection(this.f940c) != 1) {
            z = false;
        }
        return (z ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    /* renamed from: e */
    private void m1419e(float f) {
        m1420f(f);
        this.f920A = f918a && this.f925F != 1.0f;
        if (this.f920A) {
            m1425p();
        }
        ViewCompat.postInvalidateOnAnimation(this.f940c);
    }

    /* renamed from: f */
    private void m1420f(float f) {
        float f2;
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (this.f961x != null) {
            float width = (float) this.f944g.width();
            float width2 = (float) this.f943f.width();
            if (m1413a(f, this.f949l)) {
                f2 = this.f949l;
                this.f925F = 1.0f;
                if (this.f960w != this.f958u) {
                    this.f960w = this.f958u;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                f2 = this.f948k;
                if (this.f960w != this.f959v) {
                    this.f960w = this.f959v;
                    z = true;
                } else {
                    z = false;
                }
                if (m1413a(f, this.f948k)) {
                    this.f925F = 1.0f;
                } else {
                    this.f925F = f / this.f948k;
                }
                float f3 = this.f949l / this.f948k;
                width = width2 * f3 > width ? Math.min(width / f3, width2) : width2;
            }
            if (width > 0.0f) {
                if (this.f926G != f2 || this.f928I || z2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f926G = f2;
                this.f928I = false;
            }
            if (this.f962y == null || z2) {
                this.f929J.setTextSize(this.f926G);
                this.f929J.setTypeface(this.f960w);
                TextPaint textPaint = this.f929J;
                if (this.f925F == 1.0f) {
                    z3 = false;
                }
                textPaint.setLinearText(z3);
                CharSequence ellipsize = TextUtils.ellipsize(this.f961x, this.f929J, width, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.f962y)) {
                    this.f962y = ellipsize;
                    this.f963z = m1415b(this.f962y);
                }
            }
        }
    }

    /* renamed from: p */
    private void m1425p() {
        if (this.f921B == null && !this.f943f.isEmpty() && !TextUtils.isEmpty(this.f962y)) {
            m1416c(0.0f);
            this.f923D = this.f929J.ascent();
            this.f924E = this.f929J.descent();
            int round = Math.round(this.f929J.measureText(this.f962y, 0, this.f962y.length()));
            int round2 = Math.round(this.f924E - this.f923D);
            if (round > 0 && round2 > 0) {
                this.f921B = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                new Canvas(this.f921B).drawText(this.f962y, 0, this.f962y.length(), 0.0f, ((float) round2) - this.f929J.descent(), this.f929J);
                if (this.f922C == null) {
                    this.f922C = new Paint(3);
                }
            }
        }
    }

    /* renamed from: i */
    public void mo1241i() {
        if (this.f940c.getHeight() > 0 && this.f940c.getWidth() > 0) {
            m1424o();
            m1421l();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1223a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f961x)) {
            this.f961x = charSequence;
            this.f962y = null;
            m1426q();
            mo1241i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public CharSequence mo1242j() {
        return this.f961x;
    }

    /* renamed from: q */
    private void m1426q() {
        if (this.f921B != null) {
            this.f921B.recycle();
            this.f921B = null;
        }
    }

    /* renamed from: a */
    private static boolean m1413a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public ColorStateList mo1243k() {
        return this.f951n;
    }

    /* renamed from: a */
    private static int m1412a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (((float) Color.blue(i2)) * f)));
    }

    /* renamed from: a */
    private static float m1411a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return C0255a.m1400a(f, f2, f3);
    }

    /* renamed from: a */
    private static boolean m1414a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
