package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p016v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* renamed from: android.support.transition.ah */
/* compiled from: ViewOverlay */
class C0328ah {

    /* renamed from: a */
    protected C0329a f1106a;

    C0328ah(Context context, ViewGroup viewGroup, View view) {
        this.f1106a = new C0329a(context, viewGroup, view, this);
    }

    /* renamed from: c */
    static ViewGroup m1733c(View view) {
        View view2 = view;
        while (view2 != null) {
            if (view2.getId() == 16908290 && (view2 instanceof ViewGroup)) {
                return (ViewGroup) view2;
            }
            if (view2.getParent() instanceof ViewGroup) {
                view2 = (ViewGroup) view2.getParent();
            }
        }
        return null;
    }

    /* renamed from: d */
    public static C0328ah m1734d(View view) {
        ViewGroup c = m1733c(view);
        if (c == null) {
            return null;
        }
        int childCount = c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = c.getChildAt(i);
            if (childAt instanceof C0329a) {
                return ((C0329a) childAt).f1111e;
            }
        }
        return new C0327ag(c.getContext(), c, view);
    }

    /* renamed from: a */
    public void mo1398a(Drawable drawable) {
        this.f1106a.mo1400a(drawable);
    }

    /* renamed from: b */
    public void mo1399b(Drawable drawable) {
        this.f1106a.mo1403b(drawable);
    }

    /* renamed from: android.support.transition.ah$a */
    /* compiled from: ViewOverlay */
    static class C0329a extends ViewGroup {

        /* renamed from: a */
        static Method f1107a;

        /* renamed from: b */
        ViewGroup f1108b;

        /* renamed from: c */
        View f1109c;

        /* renamed from: d */
        ArrayList<Drawable> f1110d = null;

        /* renamed from: e */
        C0328ah f1111e;

        static {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                f1107a = cls.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});
            } catch (NoSuchMethodException e) {
            }
        }

        C0329a(Context context, ViewGroup viewGroup, View view, C0328ah ahVar) {
            super(context);
            this.f1108b = viewGroup;
            this.f1109c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f1111e = ahVar;
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: a */
        public void mo1400a(Drawable drawable) {
            if (this.f1110d == null) {
                this.f1110d = new ArrayList<>();
            }
            if (!this.f1110d.contains(drawable)) {
                this.f1110d.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        /* renamed from: b */
        public void mo1403b(Drawable drawable) {
            if (this.f1110d != null) {
                this.f1110d.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback((Drawable.Callback) null);
            }
        }

        /* access modifiers changed from: protected */
        public boolean verifyDrawable(Drawable drawable) {
            return super.verifyDrawable(drawable) || (this.f1110d != null && this.f1110d.contains(drawable));
        }

        /* renamed from: a */
        public void mo1401a(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.f1108b || viewGroup.getParent() == null)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f1108b.getLocationOnScreen(iArr2);
                    ViewCompat.offsetLeftAndRight(view, iArr[0] - iArr2[0]);
                    ViewCompat.offsetTopAndBottom(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        /* renamed from: b */
        public void mo1404b(View view) {
            super.removeView(view);
            if (mo1402a()) {
                this.f1108b.removeView(this);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo1402a() {
            if (getChildCount() == 0 && (this.f1110d == null || this.f1110d.size() == 0)) {
                return true;
            }
            return false;
        }

        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            ViewGroup viewGroup = (ViewGroup) getParent();
            this.f1108b.getLocationOnScreen(iArr);
            this.f1109c.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f1109c.getWidth(), this.f1109c.getHeight()));
            super.dispatchDraw(canvas);
            int size = this.f1110d == null ? 0 : this.f1110d.size();
            for (int i = 0; i < size; i++) {
                this.f1110d.get(i).draw(canvas);
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        /* renamed from: a */
        private void m1737a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            ViewGroup viewGroup = (ViewGroup) getParent();
            this.f1108b.getLocationOnScreen(iArr2);
            this.f1109c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f1108b != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.f1108b instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    m1737a(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
            }
            return null;
        }
    }
}
