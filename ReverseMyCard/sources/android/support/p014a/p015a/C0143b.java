package android.support.p014a.p015a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p016v4.graphics.drawable.DrawableCompat;
import android.support.p016v4.util.ArrayMap;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
/* renamed from: android.support.a.a.b */
/* compiled from: AnimatedVectorDrawableCompat */
public class C0143b extends C0151e implements Animatable {

    /* renamed from: a */
    final Drawable.Callback f400a;

    /* renamed from: c */
    private C0145a f401c;

    /* renamed from: d */
    private Context f402d;

    /* renamed from: e */
    private ArgbEvaluator f403e;

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

    C0143b() {
        this((Context) null, (C0145a) null, (Resources) null);
    }

    private C0143b(Context context) {
        this(context, (C0145a) null, (Resources) null);
    }

    private C0143b(Context context, C0145a aVar, Resources resources) {
        this.f403e = null;
        this.f400a = new Drawable.Callback() {
            public void invalidateDrawable(Drawable drawable) {
                C0143b.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                C0143b.this.scheduleSelf(runnable, j);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                C0143b.this.unscheduleSelf(runnable);
            }
        };
        this.f402d = context;
        if (aVar != null) {
            this.f401c = aVar;
        } else {
            this.f401c = new C0145a(context, aVar, this.f400a, resources);
        }
    }

    public Drawable mutate() {
        if (this.f414b != null) {
            this.f414b.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    /* renamed from: a */
    public static C0143b m894a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        C0143b bVar = new C0143b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f414b != null) {
            return new C0146b(this.f414b.getConstantState());
        }
        return null;
    }

    public int getChangingConfigurations() {
        if (this.f414b != null) {
            return this.f414b.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f401c.f405a;
    }

    public void draw(Canvas canvas) {
        if (this.f414b != null) {
            this.f414b.draw(canvas);
            return;
        }
        this.f401c.f406b.draw(canvas);
        if (m897a()) {
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f414b != null) {
            this.f414b.setBounds(rect);
        } else {
            this.f401c.f406b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.f414b != null) {
            return this.f414b.setState(iArr);
        }
        return this.f401c.f406b.setState(iArr);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        if (this.f414b != null) {
            return this.f414b.setLevel(i);
        }
        return this.f401c.f406b.setLevel(i);
    }

    public int getAlpha() {
        if (this.f414b != null) {
            return DrawableCompat.getAlpha(this.f414b);
        }
        return this.f401c.f406b.getAlpha();
    }

    public void setAlpha(int i) {
        if (this.f414b != null) {
            this.f414b.setAlpha(i);
        } else {
            this.f401c.f406b.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f414b != null) {
            this.f414b.setColorFilter(colorFilter);
        } else {
            this.f401c.f406b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i) {
        if (this.f414b != null) {
            DrawableCompat.setTint(this.f414b, i);
        } else {
            this.f401c.f406b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.f414b != null) {
            DrawableCompat.setTintList(this.f414b, colorStateList);
        } else {
            this.f401c.f406b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f414b != null) {
            DrawableCompat.setTintMode(this.f414b, mode);
        } else {
            this.f401c.f406b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.f414b != null) {
            return this.f414b.setVisible(z, z2);
        }
        this.f401c.f406b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public boolean isStateful() {
        if (this.f414b != null) {
            return this.f414b.isStateful();
        }
        return this.f401c.f406b.isStateful();
    }

    public int getOpacity() {
        if (this.f414b != null) {
            return this.f414b.getOpacity();
        }
        return this.f401c.f406b.getOpacity();
    }

    public int getIntrinsicWidth() {
        if (this.f414b != null) {
            return this.f414b.getIntrinsicWidth();
        }
        return this.f401c.f406b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.f414b != null) {
            return this.f414b.getIntrinsicHeight();
        }
        return this.f401c.f406b.getIntrinsicHeight();
    }

    public boolean isAutoMirrored() {
        if (this.f414b != null) {
            return DrawableCompat.isAutoMirrored(this.f414b);
        }
        return this.f401c.f406b.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        if (this.f414b != null) {
            this.f414b.setAutoMirrored(z);
        } else {
            this.f401c.f406b.setAutoMirrored(z);
        }
    }

    /* renamed from: a */
    static TypedArray m893a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.f414b != null) {
            DrawableCompat.inflate(this.f414b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1) {
            if (xmlPullParser.getDepth() >= depth || eventType != 3) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if ("animated-vector".equals(name)) {
                        TypedArray a = m893a(resources, theme, attributeSet, C0142a.f398e);
                        int resourceId = a.getResourceId(0, 0);
                        if (resourceId != 0) {
                            C0152f a2 = C0152f.m917a(resources, resourceId, theme);
                            a2.mo518a(false);
                            a2.setCallback(this.f400a);
                            if (this.f401c.f406b != null) {
                                this.f401c.f406b.setCallback((Drawable.Callback) null);
                            }
                            this.f401c.f406b = a2;
                        }
                        a.recycle();
                    } else if ("target".equals(name)) {
                        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, C0142a.f399f);
                        String string = obtainAttributes.getString(0);
                        int resourceId2 = obtainAttributes.getResourceId(1, 0);
                        if (resourceId2 != 0) {
                            if (this.f402d != null) {
                                m896a(string, AnimatorInflater.loadAnimator(this.f402d, resourceId2));
                            } else {
                                throw new IllegalStateException("Context can't be null when inflating animators");
                            }
                        }
                        obtainAttributes.recycle();
                    } else {
                        continue;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.f414b != null) {
            DrawableCompat.applyTheme(this.f414b, theme);
        }
    }

    public boolean canApplyTheme() {
        if (this.f414b != null) {
            return DrawableCompat.canApplyTheme(this.f414b);
        }
        return false;
    }

    /* renamed from: android.support.a.a.b$b */
    /* compiled from: AnimatedVectorDrawableCompat */
    private static class C0146b extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f409a;

        public C0146b(Drawable.ConstantState constantState) {
            this.f409a = constantState;
        }

        public Drawable newDrawable() {
            C0143b bVar = new C0143b();
            bVar.f414b = this.f409a.newDrawable();
            bVar.f414b.setCallback(bVar.f400a);
            return bVar;
        }

        public Drawable newDrawable(Resources resources) {
            C0143b bVar = new C0143b();
            bVar.f414b = this.f409a.newDrawable(resources);
            bVar.f414b.setCallback(bVar.f400a);
            return bVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            C0143b bVar = new C0143b();
            bVar.f414b = this.f409a.newDrawable(resources, theme);
            bVar.f414b.setCallback(bVar.f400a);
            return bVar;
        }

        public boolean canApplyTheme() {
            return this.f409a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f409a.getChangingConfigurations();
        }
    }

    /* renamed from: android.support.a.a.b$a */
    /* compiled from: AnimatedVectorDrawableCompat */
    private static class C0145a extends Drawable.ConstantState {

        /* renamed from: a */
        int f405a;

        /* renamed from: b */
        C0152f f406b;

        /* renamed from: c */
        ArrayList<Animator> f407c;

        /* renamed from: d */
        ArrayMap<Animator, String> f408d;

        public C0145a(Context context, C0145a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.f405a = aVar.f405a;
                if (aVar.f406b != null) {
                    Drawable.ConstantState constantState = aVar.f406b.getConstantState();
                    if (resources != null) {
                        this.f406b = (C0152f) constantState.newDrawable(resources);
                    } else {
                        this.f406b = (C0152f) constantState.newDrawable();
                    }
                    this.f406b = (C0152f) this.f406b.mutate();
                    this.f406b.setCallback(callback);
                    this.f406b.setBounds(aVar.f406b.getBounds());
                    this.f406b.mo518a(false);
                }
                if (aVar.f407c != null) {
                    int size = aVar.f407c.size();
                    this.f407c = new ArrayList<>(size);
                    this.f408d = new ArrayMap<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.f407c.get(i);
                        Animator clone = animator.clone();
                        String str = aVar.f408d.get(animator);
                        clone.setTarget(this.f406b.mo517a(str));
                        this.f407c.add(clone);
                        this.f408d.put(clone, str);
                    }
                }
            }
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public int getChangingConfigurations() {
            return this.f405a;
        }
    }

    /* renamed from: a */
    private void m895a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childAnimations.size()) {
                    break;
                }
                m895a(childAnimations.get(i2));
                i = i2 + 1;
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f403e == null) {
                    this.f403e = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f403e);
            }
        }
    }

    /* renamed from: a */
    private void m896a(String str, Animator animator) {
        animator.setTarget(this.f401c.f406b.mo517a(str));
        if (Build.VERSION.SDK_INT < 21) {
            m895a(animator);
        }
        if (this.f401c.f407c == null) {
            this.f401c.f407c = new ArrayList<>();
            this.f401c.f408d = new ArrayMap<>();
        }
        this.f401c.f407c.add(animator);
        this.f401c.f408d.put(animator, str);
    }

    public boolean isRunning() {
        if (this.f414b != null) {
            return ((AnimatedVectorDrawable) this.f414b).isRunning();
        }
        ArrayList<Animator> arrayList = this.f401c.f407c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).isRunning()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m897a() {
        ArrayList<Animator> arrayList = this.f401c.f407c;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        if (this.f414b != null) {
            ((AnimatedVectorDrawable) this.f414b).start();
        } else if (!m897a()) {
            ArrayList<Animator> arrayList = this.f401c.f407c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList.get(i).start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.f414b != null) {
            ((AnimatedVectorDrawable) this.f414b).stop();
            return;
        }
        ArrayList<Animator> arrayList = this.f401c.f407c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).end();
        }
    }
}
