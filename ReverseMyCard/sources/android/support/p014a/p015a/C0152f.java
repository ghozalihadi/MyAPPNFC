package android.support.p014a.p015a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.p014a.p015a.C0147c;
import android.support.p016v4.graphics.drawable.DrawableCompat;
import android.support.p016v4.util.ArrayMap;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
/* renamed from: android.support.a.a.f */
/* compiled from: VectorDrawableCompat */
public class C0152f extends C0151e {

    /* renamed from: a */
    static final PorterDuff.Mode f415a = PorterDuff.Mode.SRC_IN;

    /* renamed from: c */
    private C0158f f416c;

    /* renamed from: d */
    private PorterDuffColorFilter f417d;

    /* renamed from: e */
    private ColorFilter f418e;

    /* renamed from: f */
    private boolean f419f;

    /* renamed from: g */
    private boolean f420g;

    /* renamed from: h */
    private Drawable.ConstantState f421h;

    /* renamed from: i */
    private final float[] f422i;

    /* renamed from: j */
    private final Matrix f423j;

    /* renamed from: k */
    private final Rect f424k;

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    C0152f() {
        this.f420g = true;
        this.f422i = new float[9];
        this.f423j = new Matrix();
        this.f424k = new Rect();
        this.f416c = new C0158f();
    }

    C0152f(C0158f fVar) {
        this.f420g = true;
        this.f422i = new float[9];
        this.f423j = new Matrix();
        this.f424k = new Rect();
        this.f416c = fVar;
        this.f417d = mo516a(this.f417d, fVar.f472c, fVar.f473d);
    }

    public Drawable mutate() {
        if (this.f414b != null) {
            this.f414b.mutate();
        } else if (!this.f419f && super.mutate() == this) {
            this.f416c = new C0158f(this.f416c);
            this.f419f = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo517a(String str) {
        return this.f416c.f471b.f462h.get(str);
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f414b != null) {
            return new C0159g(this.f414b.getConstantState());
        }
        this.f416c.f470a = getChangingConfigurations();
        return this.f416c;
    }

    public void draw(Canvas canvas) {
        if (this.f414b != null) {
            this.f414b.draw(canvas);
            return;
        }
        copyBounds(this.f424k);
        if (this.f424k.width() > 0 && this.f424k.height() > 0) {
            ColorFilter colorFilter = this.f418e == null ? this.f417d : this.f418e;
            canvas.getMatrix(this.f423j);
            this.f423j.getValues(this.f422i);
            float abs = Math.abs(this.f422i[0]);
            float abs2 = Math.abs(this.f422i[4]);
            float abs3 = Math.abs(this.f422i[1]);
            float abs4 = Math.abs(this.f422i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int min = Math.min(2048, (int) (abs * ((float) this.f424k.width())));
            int min2 = Math.min(2048, (int) (abs2 * ((float) this.f424k.height())));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                canvas.translate((float) this.f424k.left, (float) this.f424k.top);
                if (m920a()) {
                    canvas.translate((float) this.f424k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f424k.offsetTo(0, 0);
                this.f416c.mo556b(min, min2);
                if (!this.f420g) {
                    this.f416c.mo553a(min, min2);
                } else if (!this.f416c.mo557b()) {
                    this.f416c.mo553a(min, min2);
                    this.f416c.mo558c();
                }
                this.f416c.mo554a(canvas, colorFilter, this.f424k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        if (this.f414b != null) {
            return DrawableCompat.getAlpha(this.f414b);
        }
        return this.f416c.f471b.mo547a();
    }

    public void setAlpha(int i) {
        if (this.f414b != null) {
            this.f414b.setAlpha(i);
        } else if (this.f416c.f471b.mo547a() != i) {
            this.f416c.f471b.mo549a(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f414b != null) {
            this.f414b.setColorFilter(colorFilter);
            return;
        }
        this.f418e = colorFilter;
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PorterDuffColorFilter mo516a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void setTint(int i) {
        if (this.f414b != null) {
            DrawableCompat.setTint(this.f414b, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.f414b != null) {
            DrawableCompat.setTintList(this.f414b, colorStateList);
            return;
        }
        C0158f fVar = this.f416c;
        if (fVar.f472c != colorStateList) {
            fVar.f472c = colorStateList;
            this.f417d = mo516a(this.f417d, colorStateList, fVar.f473d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f414b != null) {
            DrawableCompat.setTintMode(this.f414b, mode);
            return;
        }
        C0158f fVar = this.f416c;
        if (fVar.f473d != mode) {
            fVar.f473d = mode;
            this.f417d = mo516a(this.f417d, fVar.f472c, mode);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        if (this.f414b != null) {
            return this.f414b.isStateful();
        }
        return super.isStateful() || !(this.f416c == null || this.f416c.f472c == null || !this.f416c.f472c.isStateful());
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.f414b != null) {
            return this.f414b.setState(iArr);
        }
        C0158f fVar = this.f416c;
        if (fVar.f472c == null || fVar.f473d == null) {
            return false;
        }
        this.f417d = mo516a(this.f417d, fVar.f472c, fVar.f473d);
        invalidateSelf();
        return true;
    }

    public int getOpacity() {
        if (this.f414b != null) {
            return this.f414b.getOpacity();
        }
        return -3;
    }

    public int getIntrinsicWidth() {
        if (this.f414b != null) {
            return this.f414b.getIntrinsicWidth();
        }
        return (int) this.f416c.f471b.f456b;
    }

    public int getIntrinsicHeight() {
        if (this.f414b != null) {
            return this.f414b.getIntrinsicHeight();
        }
        return (int) this.f416c.f471b.f457c;
    }

    public boolean canApplyTheme() {
        if (this.f414b == null) {
            return false;
        }
        DrawableCompat.canApplyTheme(this.f414b);
        return false;
    }

    public boolean isAutoMirrored() {
        if (this.f414b != null) {
            return DrawableCompat.isAutoMirrored(this.f414b);
        }
        return this.f416c.f474e;
    }

    public void setAutoMirrored(boolean z) {
        if (this.f414b != null) {
            DrawableCompat.setAutoMirrored(this.f414b, z);
        } else {
            this.f416c.f474e = z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033 A[Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045 A[SYNTHETIC, Splitter:B:15:0x0045] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p014a.p015a.C0152f m917a(android.content.res.Resources r5, int r6, android.content.res.Resources.Theme r7) {
        /*
            r4 = 2
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L_0x0020
            android.support.a.a.f r0 = new android.support.a.a.f
            r0.<init>()
            android.graphics.drawable.Drawable r1 = android.support.p016v4.content.res.ResourcesCompat.getDrawable(r5, r6, r7)
            r0.f414b = r1
            android.support.a.a.f$g r1 = new android.support.a.a.f$g
            android.graphics.drawable.Drawable r2 = r0.f414b
            android.graphics.drawable.Drawable$ConstantState r2 = r2.getConstantState()
            r1.<init>(r2)
            r0.f421h = r1
        L_0x001f:
            return r0
        L_0x0020:
            android.content.res.XmlResourceParser r0 = r5.getXml(r6)     // Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r0)     // Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }
        L_0x0028:
            int r2 = r0.next()     // Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }
            if (r2 == r4) goto L_0x0031
            r3 = 1
            if (r2 != r3) goto L_0x0028
        L_0x0031:
            if (r2 == r4) goto L_0x0045
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }
            java.lang.String r1 = "No start tag found"
            r0.<init>(r1)     // Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }
            throw r0     // Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }
        L_0x003b:
            r0 = move-exception
            java.lang.String r1 = "VectorDrawableCompat"
            java.lang.String r2 = "parser error"
            android.util.Log.e(r1, r2, r0)
        L_0x0043:
            r0 = 0
            goto L_0x001f
        L_0x0045:
            android.support.a.a.f r0 = m918a(r5, r0, r1, r7)     // Catch:{ XmlPullParserException -> 0x003b, IOException -> 0x004a }
            goto L_0x001f
        L_0x004a:
            r0 = move-exception
            java.lang.String r1 = "VectorDrawableCompat"
            java.lang.String r2 = "parser error"
            android.util.Log.e(r1, r2, r0)
            goto L_0x0043
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p014a.p015a.C0152f.m917a(android.content.res.Resources, int, android.content.res.Resources$Theme):android.support.a.a.f");
    }

    /* renamed from: a */
    public static C0152f m918a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        C0152f fVar = new C0152f();
        fVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return fVar;
    }

    /* renamed from: a */
    static int m915a(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (16777215 & i);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.f414b != null) {
            this.f414b.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.f414b != null) {
            DrawableCompat.inflate(this.f414b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0158f fVar = this.f416c;
        fVar.f471b = new C0157e();
        TypedArray b = m914b(resources, theme, attributeSet, C0142a.f394a);
        m919a(b, xmlPullParser);
        b.recycle();
        fVar.f470a = getChangingConfigurations();
        fVar.f480k = true;
        m921b(resources, xmlPullParser, attributeSet, theme);
        this.f417d = mo516a(this.f417d, fVar.f472c, fVar.f473d);
    }

    /* renamed from: a */
    private static PorterDuff.Mode m916a(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* renamed from: a */
    private void m919a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        C0158f fVar = this.f416c;
        C0157e eVar = fVar.f471b;
        fVar.f473d = m916a(C0150d.m910a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            fVar.f472c = colorStateList;
        }
        fVar.f474e = C0150d.m911a(typedArray, xmlPullParser, "autoMirrored", 5, fVar.f474e);
        eVar.f458d = C0150d.m909a(typedArray, xmlPullParser, "viewportWidth", 7, eVar.f458d);
        eVar.f459e = C0150d.m909a(typedArray, xmlPullParser, "viewportHeight", 8, eVar.f459e);
        if (eVar.f458d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (eVar.f459e <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            eVar.f456b = typedArray.getDimension(3, eVar.f456b);
            eVar.f457c = typedArray.getDimension(2, eVar.f457c);
            if (eVar.f456b <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (eVar.f457c <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                eVar.mo548a(C0150d.m909a(typedArray, xmlPullParser, "alpha", 4, eVar.mo551b()));
                String string = typedArray.getString(0);
                if (string != null) {
                    eVar.f461g = string;
                    eVar.f462h.put(string, eVar);
                }
            }
        }
    }

    /* renamed from: b */
    private void m921b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        boolean z;
        C0158f fVar = this.f416c;
        C0157e eVar = fVar.f471b;
        Stack stack = new Stack();
        stack.push(eVar.f455a);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                C0155c cVar = (C0155c) stack.peek();
                if ("path".equals(name)) {
                    C0154b bVar = new C0154b();
                    bVar.mo542a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f438a.add(bVar);
                    if (bVar.mo546b() != null) {
                        eVar.f462h.put(bVar.mo546b(), bVar);
                    }
                    z = false;
                    fVar.f470a = bVar.f453o | fVar.f470a;
                } else if ("clip-path".equals(name)) {
                    C0153a aVar = new C0153a();
                    aVar.mo540a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f438a.add(aVar);
                    if (aVar.mo546b() != null) {
                        eVar.f462h.put(aVar.mo546b(), aVar);
                    }
                    fVar.f470a |= aVar.f453o;
                    z = z2;
                } else {
                    if ("group".equals(name)) {
                        C0155c cVar2 = new C0155c();
                        cVar2.mo544a(resources, attributeSet, theme, xmlPullParser);
                        cVar.f438a.add(cVar2);
                        stack.push(cVar2);
                        if (cVar2.mo543a() != null) {
                            eVar.f462h.put(cVar2.mo543a(), cVar2);
                        }
                        fVar.f470a |= cVar2.f440c;
                    }
                    z = z2;
                }
                z2 = z;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                stack.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z2) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo518a(boolean z) {
        this.f420g = z;
    }

    /* renamed from: a */
    private boolean m920a() {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (!isAutoMirrored() || getLayoutDirection() != 1) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f414b != null) {
            this.f414b.setBounds(rect);
        }
    }

    public int getChangingConfigurations() {
        if (this.f414b != null) {
            return this.f414b.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f416c.getChangingConfigurations();
    }

    public void invalidateSelf() {
        if (this.f414b != null) {
            this.f414b.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.f414b != null) {
            this.f414b.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.f414b != null) {
            return this.f414b.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.f414b != null) {
            this.f414b.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* renamed from: android.support.a.a.f$g */
    /* compiled from: VectorDrawableCompat */
    private static class C0159g extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f482a;

        public C0159g(Drawable.ConstantState constantState) {
            this.f482a = constantState;
        }

        public Drawable newDrawable() {
            C0152f fVar = new C0152f();
            fVar.f414b = (VectorDrawable) this.f482a.newDrawable();
            return fVar;
        }

        public Drawable newDrawable(Resources resources) {
            C0152f fVar = new C0152f();
            fVar.f414b = (VectorDrawable) this.f482a.newDrawable(resources);
            return fVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            C0152f fVar = new C0152f();
            fVar.f414b = (VectorDrawable) this.f482a.newDrawable(resources, theme);
            return fVar;
        }

        public boolean canApplyTheme() {
            return this.f482a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f482a.getChangingConfigurations();
        }
    }

    /* renamed from: android.support.a.a.f$f */
    /* compiled from: VectorDrawableCompat */
    private static class C0158f extends Drawable.ConstantState {

        /* renamed from: a */
        int f470a;

        /* renamed from: b */
        C0157e f471b;

        /* renamed from: c */
        ColorStateList f472c;

        /* renamed from: d */
        PorterDuff.Mode f473d;

        /* renamed from: e */
        boolean f474e;

        /* renamed from: f */
        Bitmap f475f;

        /* renamed from: g */
        ColorStateList f476g;

        /* renamed from: h */
        PorterDuff.Mode f477h;

        /* renamed from: i */
        int f478i;

        /* renamed from: j */
        boolean f479j;

        /* renamed from: k */
        boolean f480k;

        /* renamed from: l */
        Paint f481l;

        public C0158f(C0158f fVar) {
            this.f472c = null;
            this.f473d = C0152f.f415a;
            if (fVar != null) {
                this.f470a = fVar.f470a;
                this.f471b = new C0157e(fVar.f471b);
                if (fVar.f471b.f467n != null) {
                    Paint unused = this.f471b.f467n = new Paint(fVar.f471b.f467n);
                }
                if (fVar.f471b.f466m != null) {
                    Paint unused2 = this.f471b.f466m = new Paint(fVar.f471b.f466m);
                }
                this.f472c = fVar.f472c;
                this.f473d = fVar.f473d;
                this.f474e = fVar.f474e;
            }
        }

        /* renamed from: a */
        public void mo554a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f475f, (Rect) null, rect, mo552a(colorFilter));
        }

        /* renamed from: a */
        public boolean mo555a() {
            return this.f471b.mo547a() < 255;
        }

        /* renamed from: a */
        public Paint mo552a(ColorFilter colorFilter) {
            if (!mo555a() && colorFilter == null) {
                return null;
            }
            if (this.f481l == null) {
                this.f481l = new Paint();
                this.f481l.setFilterBitmap(true);
            }
            this.f481l.setAlpha(this.f471b.mo547a());
            this.f481l.setColorFilter(colorFilter);
            return this.f481l;
        }

        /* renamed from: a */
        public void mo553a(int i, int i2) {
            this.f475f.eraseColor(0);
            this.f471b.mo550a(new Canvas(this.f475f), i, i2, (ColorFilter) null);
        }

        /* renamed from: b */
        public void mo556b(int i, int i2) {
            if (this.f475f == null || !mo559c(i, i2)) {
                this.f475f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.f480k = true;
            }
        }

        /* renamed from: c */
        public boolean mo559c(int i, int i2) {
            if (i == this.f475f.getWidth() && i2 == this.f475f.getHeight()) {
                return true;
            }
            return false;
        }

        /* renamed from: b */
        public boolean mo557b() {
            if (!this.f480k && this.f476g == this.f472c && this.f477h == this.f473d && this.f479j == this.f474e && this.f478i == this.f471b.mo547a()) {
                return true;
            }
            return false;
        }

        /* renamed from: c */
        public void mo558c() {
            this.f476g = this.f472c;
            this.f477h = this.f473d;
            this.f478i = this.f471b.mo547a();
            this.f479j = this.f474e;
            this.f480k = false;
        }

        public C0158f() {
            this.f472c = null;
            this.f473d = C0152f.f415a;
            this.f471b = new C0157e();
        }

        public Drawable newDrawable() {
            return new C0152f(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0152f(this);
        }

        public int getChangingConfigurations() {
            return this.f470a;
        }
    }

    /* renamed from: android.support.a.a.f$e */
    /* compiled from: VectorDrawableCompat */
    private static class C0157e {

        /* renamed from: k */
        private static final Matrix f454k = new Matrix();

        /* renamed from: a */
        final C0155c f455a;

        /* renamed from: b */
        float f456b;

        /* renamed from: c */
        float f457c;

        /* renamed from: d */
        float f458d;

        /* renamed from: e */
        float f459e;

        /* renamed from: f */
        int f460f;

        /* renamed from: g */
        String f461g;

        /* renamed from: h */
        final ArrayMap<String, Object> f462h;

        /* renamed from: i */
        private final Path f463i;

        /* renamed from: j */
        private final Path f464j;

        /* renamed from: l */
        private final Matrix f465l;
        /* access modifiers changed from: private */

        /* renamed from: m */
        public Paint f466m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public Paint f467n;

        /* renamed from: o */
        private PathMeasure f468o;

        /* renamed from: p */
        private int f469p;

        public C0157e() {
            this.f465l = new Matrix();
            this.f456b = 0.0f;
            this.f457c = 0.0f;
            this.f458d = 0.0f;
            this.f459e = 0.0f;
            this.f460f = 255;
            this.f461g = null;
            this.f462h = new ArrayMap<>();
            this.f455a = new C0155c();
            this.f463i = new Path();
            this.f464j = new Path();
        }

        /* renamed from: a */
        public void mo549a(int i) {
            this.f460f = i;
        }

        /* renamed from: a */
        public int mo547a() {
            return this.f460f;
        }

        /* renamed from: a */
        public void mo548a(float f) {
            mo549a((int) (255.0f * f));
        }

        /* renamed from: b */
        public float mo551b() {
            return ((float) mo547a()) / 255.0f;
        }

        public C0157e(C0157e eVar) {
            this.f465l = new Matrix();
            this.f456b = 0.0f;
            this.f457c = 0.0f;
            this.f458d = 0.0f;
            this.f459e = 0.0f;
            this.f460f = 255;
            this.f461g = null;
            this.f462h = new ArrayMap<>();
            this.f455a = new C0155c(eVar.f455a, this.f462h);
            this.f463i = new Path(eVar.f463i);
            this.f464j = new Path(eVar.f464j);
            this.f456b = eVar.f456b;
            this.f457c = eVar.f457c;
            this.f458d = eVar.f458d;
            this.f459e = eVar.f459e;
            this.f469p = eVar.f469p;
            this.f460f = eVar.f460f;
            this.f461g = eVar.f461g;
            if (eVar.f461g != null) {
                this.f462h.put(eVar.f461g, this);
            }
        }

        /* renamed from: a */
        private void m945a(C0155c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.f441d.set(matrix);
            cVar.f441d.preConcat(cVar.f448k);
            canvas.save();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < cVar.f438a.size()) {
                    Object obj = cVar.f438a.get(i4);
                    if (obj instanceof C0155c) {
                        m945a((C0155c) obj, cVar.f441d, canvas, i, i2, colorFilter);
                    } else if (obj instanceof C0156d) {
                        m946a(cVar, (C0156d) obj, canvas, i, i2, colorFilter);
                    }
                    i3 = i4 + 1;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }

        /* renamed from: a */
        public void mo550a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m945a(this.f455a, f454k, canvas, i, i2, colorFilter);
        }

        /* renamed from: a */
        private void m946a(C0155c cVar, C0156d dVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.f458d;
            float f2 = ((float) i2) / this.f459e;
            float min = Math.min(f, f2);
            Matrix a = cVar.f441d;
            this.f465l.set(a);
            this.f465l.postScale(f, f2);
            float a2 = m942a(a);
            if (a2 != 0.0f) {
                dVar.mo545a(this.f463i);
                Path path = this.f463i;
                this.f464j.reset();
                if (dVar.mo541a()) {
                    this.f464j.addPath(path, this.f465l);
                    canvas.clipPath(this.f464j);
                    return;
                }
                C0154b bVar = (C0154b) dVar;
                if (!(bVar.f431g == 0.0f && bVar.f432h == 1.0f)) {
                    float f3 = (bVar.f431g + bVar.f433i) % 1.0f;
                    float f4 = (bVar.f432h + bVar.f433i) % 1.0f;
                    if (this.f468o == null) {
                        this.f468o = new PathMeasure();
                    }
                    this.f468o.setPath(this.f463i, false);
                    float length = this.f468o.getLength();
                    float f5 = f3 * length;
                    float f6 = f4 * length;
                    path.reset();
                    if (f5 > f6) {
                        this.f468o.getSegment(f5, length, path, true);
                        this.f468o.getSegment(0.0f, f6, path, true);
                    } else {
                        this.f468o.getSegment(f5, f6, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f464j.addPath(path, this.f465l);
                if (bVar.f427c != 0) {
                    if (this.f467n == null) {
                        this.f467n = new Paint();
                        this.f467n.setStyle(Paint.Style.FILL);
                        this.f467n.setAntiAlias(true);
                    }
                    Paint paint = this.f467n;
                    paint.setColor(C0152f.m915a(bVar.f427c, bVar.f430f));
                    paint.setColorFilter(colorFilter);
                    canvas.drawPath(this.f464j, paint);
                }
                if (bVar.f425a != 0) {
                    if (this.f466m == null) {
                        this.f466m = new Paint();
                        this.f466m.setStyle(Paint.Style.STROKE);
                        this.f466m.setAntiAlias(true);
                    }
                    Paint paint2 = this.f466m;
                    if (bVar.f435k != null) {
                        paint2.setStrokeJoin(bVar.f435k);
                    }
                    if (bVar.f434j != null) {
                        paint2.setStrokeCap(bVar.f434j);
                    }
                    paint2.setStrokeMiter(bVar.f436l);
                    paint2.setColor(C0152f.m915a(bVar.f425a, bVar.f428d));
                    paint2.setColorFilter(colorFilter);
                    paint2.setStrokeWidth(a2 * min * bVar.f426b);
                    canvas.drawPath(this.f464j, paint2);
                }
            }
        }

        /* renamed from: a */
        private static float m941a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        /* renamed from: a */
        private float m942a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float a = m941a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), hypot);
            if (max > 0.0f) {
                return Math.abs(a) / max;
            }
            return 0.0f;
        }
    }

    /* renamed from: android.support.a.a.f$c */
    /* compiled from: VectorDrawableCompat */
    private static class C0155c {

        /* renamed from: a */
        final ArrayList<Object> f438a = new ArrayList<>();

        /* renamed from: b */
        float f439b = 0.0f;

        /* renamed from: c */
        int f440c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final Matrix f441d = new Matrix();

        /* renamed from: e */
        private float f442e = 0.0f;

        /* renamed from: f */
        private float f443f = 0.0f;

        /* renamed from: g */
        private float f444g = 1.0f;

        /* renamed from: h */
        private float f445h = 1.0f;

        /* renamed from: i */
        private float f446i = 0.0f;

        /* renamed from: j */
        private float f447j = 0.0f;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public final Matrix f448k = new Matrix();

        /* renamed from: l */
        private int[] f449l;

        /* renamed from: m */
        private String f450m = null;

        public C0155c(C0155c cVar, ArrayMap<String, Object> arrayMap) {
            C0156d aVar;
            this.f439b = cVar.f439b;
            this.f442e = cVar.f442e;
            this.f443f = cVar.f443f;
            this.f444g = cVar.f444g;
            this.f445h = cVar.f445h;
            this.f446i = cVar.f446i;
            this.f447j = cVar.f447j;
            this.f449l = cVar.f449l;
            this.f450m = cVar.f450m;
            this.f440c = cVar.f440c;
            if (this.f450m != null) {
                arrayMap.put(this.f450m, this);
            }
            this.f448k.set(cVar.f448k);
            ArrayList<Object> arrayList = cVar.f438a;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    Object obj = arrayList.get(i2);
                    if (obj instanceof C0155c) {
                        this.f438a.add(new C0155c((C0155c) obj, arrayMap));
                    } else {
                        if (obj instanceof C0154b) {
                            aVar = new C0154b((C0154b) obj);
                        } else if (obj instanceof C0153a) {
                            aVar = new C0153a((C0153a) obj);
                        } else {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        this.f438a.add(aVar);
                        if (aVar.f452n != null) {
                            arrayMap.put(aVar.f452n, aVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        public C0155c() {
        }

        /* renamed from: a */
        public String mo543a() {
            return this.f450m;
        }

        /* renamed from: a */
        public void mo544a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = C0151e.m914b(resources, theme, attributeSet, C0142a.f395b);
            m933a(b, xmlPullParser);
            b.recycle();
        }

        /* renamed from: a */
        private void m933a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f449l = null;
            this.f439b = C0150d.m909a(typedArray, xmlPullParser, "rotation", 5, this.f439b);
            this.f442e = typedArray.getFloat(1, this.f442e);
            this.f443f = typedArray.getFloat(2, this.f443f);
            this.f444g = C0150d.m909a(typedArray, xmlPullParser, "scaleX", 3, this.f444g);
            this.f445h = C0150d.m909a(typedArray, xmlPullParser, "scaleY", 4, this.f445h);
            this.f446i = C0150d.m909a(typedArray, xmlPullParser, "translateX", 6, this.f446i);
            this.f447j = C0150d.m909a(typedArray, xmlPullParser, "translateY", 7, this.f447j);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f450m = string;
            }
            m935b();
        }

        /* renamed from: b */
        private void m935b() {
            this.f448k.reset();
            this.f448k.postTranslate(-this.f442e, -this.f443f);
            this.f448k.postScale(this.f444g, this.f445h);
            this.f448k.postRotate(this.f439b, 0.0f, 0.0f);
            this.f448k.postTranslate(this.f446i + this.f442e, this.f447j + this.f443f);
        }
    }

    /* renamed from: android.support.a.a.f$d */
    /* compiled from: VectorDrawableCompat */
    private static class C0156d {

        /* renamed from: m */
        protected C0147c.C0149b[] f451m = null;

        /* renamed from: n */
        String f452n;

        /* renamed from: o */
        int f453o;

        public C0156d() {
        }

        public C0156d(C0156d dVar) {
            this.f452n = dVar.f452n;
            this.f453o = dVar.f453o;
            this.f451m = C0147c.m903a(dVar.f451m);
        }

        /* renamed from: a */
        public void mo545a(Path path) {
            path.reset();
            if (this.f451m != null) {
                C0147c.C0149b.m908a(this.f451m, path);
            }
        }

        /* renamed from: b */
        public String mo546b() {
            return this.f452n;
        }

        /* renamed from: a */
        public boolean mo541a() {
            return false;
        }
    }

    /* renamed from: android.support.a.a.f$a */
    /* compiled from: VectorDrawableCompat */
    private static class C0153a extends C0156d {
        public C0153a() {
        }

        public C0153a(C0153a aVar) {
            super(aVar);
        }

        /* renamed from: a */
        public void mo540a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (C0150d.m912a(xmlPullParser, "pathData")) {
                TypedArray b = C0151e.m914b(resources, theme, attributeSet, C0142a.f397d);
                m925a(b);
                b.recycle();
            }
        }

        /* renamed from: a */
        private void m925a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f452n = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f451m = C0147c.m902a(string2);
            }
        }

        /* renamed from: a */
        public boolean mo541a() {
            return true;
        }
    }

    /* renamed from: android.support.a.a.f$b */
    /* compiled from: VectorDrawableCompat */
    private static class C0154b extends C0156d {

        /* renamed from: a */
        int f425a = 0;

        /* renamed from: b */
        float f426b = 0.0f;

        /* renamed from: c */
        int f427c = 0;

        /* renamed from: d */
        float f428d = 1.0f;

        /* renamed from: e */
        int f429e;

        /* renamed from: f */
        float f430f = 1.0f;

        /* renamed from: g */
        float f431g = 0.0f;

        /* renamed from: h */
        float f432h = 1.0f;

        /* renamed from: i */
        float f433i = 0.0f;

        /* renamed from: j */
        Paint.Cap f434j = Paint.Cap.BUTT;

        /* renamed from: k */
        Paint.Join f435k = Paint.Join.MITER;

        /* renamed from: l */
        float f436l = 4.0f;

        /* renamed from: p */
        private int[] f437p;

        public C0154b() {
        }

        public C0154b(C0154b bVar) {
            super(bVar);
            this.f437p = bVar.f437p;
            this.f425a = bVar.f425a;
            this.f426b = bVar.f426b;
            this.f428d = bVar.f428d;
            this.f427c = bVar.f427c;
            this.f429e = bVar.f429e;
            this.f430f = bVar.f430f;
            this.f431g = bVar.f431g;
            this.f432h = bVar.f432h;
            this.f433i = bVar.f433i;
            this.f434j = bVar.f434j;
            this.f435k = bVar.f435k;
            this.f436l = bVar.f436l;
        }

        /* renamed from: a */
        private Paint.Cap m928a(int i, Paint.Cap cap) {
            switch (i) {
                case 0:
                    return Paint.Cap.BUTT;
                case 1:
                    return Paint.Cap.ROUND;
                case 2:
                    return Paint.Cap.SQUARE;
                default:
                    return cap;
            }
        }

        /* renamed from: a */
        private Paint.Join m929a(int i, Paint.Join join) {
            switch (i) {
                case 0:
                    return Paint.Join.MITER;
                case 1:
                    return Paint.Join.ROUND;
                case 2:
                    return Paint.Join.BEVEL;
                default:
                    return join;
            }
        }

        /* renamed from: a */
        public void mo542a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = C0151e.m914b(resources, theme, attributeSet, C0142a.f396c);
            m930a(b, xmlPullParser);
            b.recycle();
        }

        /* renamed from: a */
        private void m930a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f437p = null;
            if (C0150d.m912a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f452n = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f451m = C0147c.m902a(string2);
                }
                this.f427c = C0150d.m913b(typedArray, xmlPullParser, "fillColor", 1, this.f427c);
                this.f430f = C0150d.m909a(typedArray, xmlPullParser, "fillAlpha", 12, this.f430f);
                this.f434j = m928a(C0150d.m910a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f434j);
                this.f435k = m929a(C0150d.m910a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f435k);
                this.f436l = C0150d.m909a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f436l);
                this.f425a = C0150d.m913b(typedArray, xmlPullParser, "strokeColor", 3, this.f425a);
                this.f428d = C0150d.m909a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f428d);
                this.f426b = C0150d.m909a(typedArray, xmlPullParser, "strokeWidth", 4, this.f426b);
                this.f432h = C0150d.m909a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f432h);
                this.f433i = C0150d.m909a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f433i);
                this.f431g = C0150d.m909a(typedArray, xmlPullParser, "trimPathStart", 5, this.f431g);
            }
        }
    }
}
