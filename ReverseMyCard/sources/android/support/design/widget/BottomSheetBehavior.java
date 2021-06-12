package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout;
import android.support.p016v4.p018os.ParcelableCompat;
import android.support.p016v4.p018os.ParcelableCompatCreatorCallbacks;
import android.support.p016v4.view.AbsSavedState;
import android.support.p016v4.view.MotionEventCompat;
import android.support.p016v4.view.NestedScrollingChild;
import android.support.p016v4.view.VelocityTrackerCompat;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.C0206a<V> {

    /* renamed from: a */
    int f600a;

    /* renamed from: b */
    int f601b;

    /* renamed from: c */
    boolean f602c;

    /* renamed from: d */
    int f603d = 4;

    /* renamed from: e */
    ViewDragHelper f604e;

    /* renamed from: f */
    int f605f;

    /* renamed from: g */
    WeakReference<V> f606g;

    /* renamed from: h */
    WeakReference<View> f607h;

    /* renamed from: i */
    int f608i;

    /* renamed from: j */
    boolean f609j;

    /* renamed from: k */
    private float f610k;

    /* renamed from: l */
    private int f611l;

    /* renamed from: m */
    private boolean f612m;

    /* renamed from: n */
    private int f613n;

    /* renamed from: o */
    private boolean f614o;

    /* renamed from: p */
    private boolean f615p;

    /* renamed from: q */
    private int f616q;

    /* renamed from: r */
    private boolean f617r;

    /* renamed from: s */
    private C0197a f618s;

    /* renamed from: t */
    private VelocityTracker f619t;

    /* renamed from: u */
    private int f620u;

    /* renamed from: v */
    private final ViewDragHelper.Callback f621v = new ViewDragHelper.Callback() {
        public boolean tryCaptureView(View view, int i) {
            View view2;
            if (BottomSheetBehavior.this.f603d == 1 || BottomSheetBehavior.this.f609j) {
                return false;
            }
            if (BottomSheetBehavior.this.f603d == 3 && BottomSheetBehavior.this.f608i == i && (view2 = (View) BottomSheetBehavior.this.f607h.get()) != null && ViewCompat.canScrollVertically(view2, -1)) {
                return false;
            }
            return BottomSheetBehavior.this.f606g != null && BottomSheetBehavior.this.f606g.get() == view;
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.mo783c(i2);
        }

        public void onViewDragStateChanged(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.mo780b(1);
            }
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            int i2 = 3;
            if (f2 < 0.0f) {
                i = BottomSheetBehavior.this.f600a;
            } else if (BottomSheetBehavior.this.f602c && BottomSheetBehavior.this.mo779a(view, f2)) {
                i = BottomSheetBehavior.this.f605f;
                i2 = 5;
            } else if (f2 == 0.0f) {
                int top = view.getTop();
                if (Math.abs(top - BottomSheetBehavior.this.f600a) < Math.abs(top - BottomSheetBehavior.this.f601b)) {
                    i = BottomSheetBehavior.this.f600a;
                } else {
                    i = BottomSheetBehavior.this.f601b;
                    i2 = 4;
                }
            } else {
                i = BottomSheetBehavior.this.f601b;
                i2 = 4;
            }
            if (BottomSheetBehavior.this.f604e.settleCapturedViewAt(view.getLeft(), i)) {
                BottomSheetBehavior.this.mo780b(2);
                ViewCompat.postOnAnimation(view, new C0198b(view, i2));
                return;
            }
            BottomSheetBehavior.this.mo780b(i2);
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return C0281m.m1558a(i, BottomSheetBehavior.this.f600a, BottomSheetBehavior.this.f602c ? BottomSheetBehavior.this.f605f : BottomSheetBehavior.this.f601b);
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return view.getLeft();
        }

        public int getViewVerticalDragRange(View view) {
            if (BottomSheetBehavior.this.f602c) {
                return BottomSheetBehavior.this.f605f - BottomSheetBehavior.this.f600a;
            }
            return BottomSheetBehavior.this.f601b - BottomSheetBehavior.this.f600a;
        }
    };

    /* renamed from: android.support.design.widget.BottomSheetBehavior$a */
    public static abstract class C0197a {
        /* renamed from: a */
        public abstract void mo793a(View view, float f);

        /* renamed from: a */
        public abstract void mo794a(View view, int i);
    }

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            mo775a(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            mo775a(peekValue.data);
        }
        mo776a(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        mo781b(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.f610k = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    /* renamed from: b */
    public Parcelable mo743b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.mo743b(coordinatorLayout, v), this.f603d);
    }

    /* renamed from: a */
    public void mo725a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.mo725a(coordinatorLayout, v, savedState.getSuperState());
        if (savedState.f623a == 1 || savedState.f623a == 2) {
            this.f603d = 4;
        } else {
            this.f603d = savedState.f623a;
        }
    }

    /* renamed from: a */
    public boolean mo735a(CoordinatorLayout coordinatorLayout, V v, int i) {
        int i2;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            ViewCompat.setFitsSystemWindows(v, true);
        }
        int top = v.getTop();
        coordinatorLayout.mo867a((View) v, i);
        this.f605f = coordinatorLayout.getHeight();
        if (this.f612m) {
            if (this.f613n == 0) {
                this.f613n = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            }
            i2 = Math.max(this.f613n, this.f605f - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            i2 = this.f611l;
        }
        this.f600a = Math.max(0, this.f605f - v.getHeight());
        this.f601b = Math.max(this.f605f - i2, this.f600a);
        if (this.f603d == 3) {
            ViewCompat.offsetTopAndBottom(v, this.f600a);
        } else if (this.f602c && this.f603d == 5) {
            ViewCompat.offsetTopAndBottom(v, this.f605f);
        } else if (this.f603d == 4) {
            ViewCompat.offsetTopAndBottom(v, this.f601b);
        } else if (this.f603d == 1 || this.f603d == 2) {
            ViewCompat.offsetTopAndBottom(v, top - v.getTop());
        }
        if (this.f604e == null) {
            this.f604e = ViewDragHelper.create(coordinatorLayout, this.f621v);
        }
        this.f606g = new WeakReference<>(v);
        this.f607h = new WeakReference<>(m1091a((View) v));
        return true;
    }

    /* renamed from: a */
    public boolean mo777a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = true;
        if (!v.isShown()) {
            this.f615p = true;
            return false;
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            m1092a();
        }
        if (this.f619t == null) {
            this.f619t = VelocityTracker.obtain();
        }
        this.f619t.addMovement(motionEvent);
        switch (actionMasked) {
            case 0:
                int x = (int) motionEvent.getX();
                this.f620u = (int) motionEvent.getY();
                View view = (View) this.f607h.get();
                if (view != null && coordinatorLayout.mo872a(view, x, this.f620u)) {
                    this.f608i = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f609j = true;
                }
                this.f615p = this.f608i == -1 && !coordinatorLayout.mo872a((View) v, x, this.f620u);
                break;
            case 1:
            case 3:
                this.f609j = false;
                this.f608i = -1;
                if (this.f615p) {
                    this.f615p = false;
                    return false;
                }
                break;
        }
        if (!this.f615p && this.f604e.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        View view2 = (View) this.f607h.get();
        if (actionMasked != 2 || view2 == null || this.f615p || this.f603d == 1 || coordinatorLayout.mo872a(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.f620u) - motionEvent.getY()) <= ((float) this.f604e.getTouchSlop())) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    public boolean mo782b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.f603d == 1 && actionMasked == 0) {
            return true;
        }
        this.f604e.processTouchEvent(motionEvent);
        if (actionMasked == 0) {
            m1092a();
        }
        if (this.f619t == null) {
            this.f619t = VelocityTracker.obtain();
        }
        this.f619t.addMovement(motionEvent);
        if (actionMasked == 2 && !this.f615p && Math.abs(((float) this.f620u) - motionEvent.getY()) > ((float) this.f604e.getTouchSlop())) {
            this.f604e.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        if (this.f615p) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo738a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.f616q = 0;
        this.f617r = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo728a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == ((View) this.f607h.get())) {
            int top = v.getTop();
            int i3 = top - i2;
            if (i2 > 0) {
                if (i3 < this.f600a) {
                    iArr[1] = top - this.f600a;
                    ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                    mo780b(3);
                } else {
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(v, -i2);
                    mo780b(1);
                }
            } else if (i2 < 0 && !ViewCompat.canScrollVertically(view, -1)) {
                if (i3 <= this.f601b || this.f602c) {
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(v, -i2);
                    mo780b(1);
                } else {
                    iArr[1] = top - this.f601b;
                    ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                    mo780b(4);
                }
            }
            mo783c(v.getTop());
            this.f616q = i2;
            this.f617r = true;
        }
    }

    /* renamed from: a */
    public void mo726a(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i;
        int i2 = 3;
        if (v.getTop() == this.f600a) {
            mo780b(3);
        } else if (view == this.f607h.get() && this.f617r) {
            if (this.f616q > 0) {
                i = this.f600a;
            } else if (this.f602c && mo779a(v, m1093b())) {
                i = this.f605f;
                i2 = 5;
            } else if (this.f616q == 0) {
                int top = v.getTop();
                if (Math.abs(top - this.f600a) < Math.abs(top - this.f601b)) {
                    i = this.f600a;
                } else {
                    i = this.f601b;
                    i2 = 4;
                }
            } else {
                i = this.f601b;
                i2 = 4;
            }
            if (this.f604e.smoothSlideViewTo(v, v.getLeft(), i)) {
                mo780b(2);
                ViewCompat.postOnAnimation(v, new C0198b(v, i2));
            } else {
                mo780b(i2);
            }
            this.f617r = false;
        }
    }

    /* renamed from: a */
    public boolean mo778a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.f607h.get() && (this.f603d != 3 || super.mo778a(coordinatorLayout, v, view, f, f2));
    }

    /* renamed from: a */
    public final void mo775a(int i) {
        View view;
        boolean z = true;
        if (i == -1) {
            if (!this.f612m) {
                this.f612m = true;
            }
            z = false;
        } else {
            if (this.f612m || this.f611l != i) {
                this.f612m = false;
                this.f611l = Math.max(0, i);
                this.f601b = this.f605f - i;
            }
            z = false;
        }
        if (z && this.f603d == 4 && this.f606g != null && (view = (View) this.f606g.get()) != null) {
            view.requestLayout();
        }
    }

    /* renamed from: a */
    public void mo776a(boolean z) {
        this.f602c = z;
    }

    /* renamed from: b */
    public void mo781b(boolean z) {
        this.f614o = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo780b(int i) {
        if (this.f603d != i) {
            this.f603d = i;
            View view = (View) this.f606g.get();
            if (view != null && this.f618s != null) {
                this.f618s.mo794a(view, i);
            }
        }
    }

    /* renamed from: a */
    private void m1092a() {
        this.f608i = -1;
        if (this.f619t != null) {
            this.f619t.recycle();
            this.f619t = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo779a(View view, float f) {
        if (this.f614o) {
            return true;
        }
        if (view.getTop() < this.f601b) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.f601b)) / ((float) this.f611l) <= 0.5f) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private View m1091a(View view) {
        if (view instanceof NestedScrollingChild) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View a = m1091a(viewGroup.getChildAt(i));
                if (a != null) {
                    return a;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private float m1093b() {
        this.f619t.computeCurrentVelocity(1000, this.f610k);
        return VelocityTrackerCompat.getYVelocity(this.f619t, this.f608i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo783c(int i) {
        View view = (View) this.f606g.get();
        if (view != null && this.f618s != null) {
            if (i > this.f601b) {
                this.f618s.mo793a(view, ((float) (this.f601b - i)) / ((float) (this.f605f - this.f601b)));
            } else {
                this.f618s.mo793a(view, ((float) (this.f601b - i)) / ((float) (this.f601b - this.f600a)));
            }
        }
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior$b */
    private class C0198b implements Runnable {

        /* renamed from: b */
        private final View f625b;

        /* renamed from: c */
        private final int f626c;

        C0198b(View view, int i) {
            this.f625b = view;
            this.f626c = i;
        }

        public void run() {
            if (BottomSheetBehavior.this.f604e == null || !BottomSheetBehavior.this.f604e.continueSettling(true)) {
                BottomSheetBehavior.this.mo780b(this.f626c);
            } else {
                ViewCompat.postOnAnimation(this.f625b, this);
            }
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });

        /* renamed from: a */
        final int f623a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f623a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f623a = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f623a);
        }
    }
}
