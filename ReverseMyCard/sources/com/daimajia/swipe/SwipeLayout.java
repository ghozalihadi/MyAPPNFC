package com.daimajia.swipe;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.p016v4.view.GravityCompat;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SwipeLayout extends FrameLayout {

    /* renamed from: c */
    private static final C0685b f1323c = C0685b.Right;

    /* renamed from: a */
    View.OnClickListener f1324a;

    /* renamed from: b */
    View.OnLongClickListener f1325b;

    /* renamed from: d */
    private int f1326d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0685b f1327e;

    /* renamed from: f */
    private ViewDragHelper f1328f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f1329g;

    /* renamed from: h */
    private LinkedHashMap<C0685b, View> f1330h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0688e f1331i;

    /* renamed from: j */
    private float[] f1332j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<C0692i> f1333k;

    /* renamed from: l */
    private List<C0690g> f1334l;

    /* renamed from: m */
    private Map<View, ArrayList<C0687d>> f1335m;

    /* renamed from: n */
    private Map<View, Boolean> f1336n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C0684a f1337o;

    /* renamed from: p */
    private boolean f1338p;

    /* renamed from: q */
    private boolean[] f1339q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f1340r;

    /* renamed from: s */
    private ViewDragHelper.Callback f1341s;

    /* renamed from: t */
    private int f1342t;

    /* renamed from: u */
    private List<C0686c> f1343u;

    /* renamed from: v */
    private boolean f1344v;

    /* renamed from: w */
    private float f1345w;

    /* renamed from: x */
    private float f1346x;

    /* renamed from: y */
    private Rect f1347y;

    /* renamed from: z */
    private GestureDetector f1348z;

    /* renamed from: com.daimajia.swipe.SwipeLayout$a */
    public interface C0684a {
        /* renamed from: a */
        void mo8150a(SwipeLayout swipeLayout, boolean z);
    }

    /* renamed from: com.daimajia.swipe.SwipeLayout$b */
    public enum C0685b {
        Left,
        Top,
        Right,
        Bottom
    }

    /* renamed from: com.daimajia.swipe.SwipeLayout$c */
    public interface C0686c {
        /* renamed from: a */
        void mo8151a(SwipeLayout swipeLayout);
    }

    /* renamed from: com.daimajia.swipe.SwipeLayout$d */
    public interface C0687d {
        /* renamed from: a */
        void mo8152a(View view, C0685b bVar, float f, int i);
    }

    /* renamed from: com.daimajia.swipe.SwipeLayout$e */
    public enum C0688e {
        LayDown,
        PullOut
    }

    /* renamed from: com.daimajia.swipe.SwipeLayout$f */
    public enum C0689f {
        Middle,
        Open,
        Close
    }

    /* renamed from: com.daimajia.swipe.SwipeLayout$g */
    public interface C0690g {
        /* renamed from: a */
        boolean mo8153a(MotionEvent motionEvent);
    }

    /* renamed from: com.daimajia.swipe.SwipeLayout$i */
    public interface C0692i {
        /* renamed from: a */
        void mo8156a(SwipeLayout swipeLayout);

        /* renamed from: a */
        void mo8157a(SwipeLayout swipeLayout, float f, float f2);

        /* renamed from: a */
        void mo8158a(SwipeLayout swipeLayout, int i, int i2);

        /* renamed from: b */
        void mo8159b(SwipeLayout swipeLayout);

        /* renamed from: c */
        void mo8160c(SwipeLayout swipeLayout);

        /* renamed from: d */
        void mo8161d(SwipeLayout swipeLayout);
    }

    public SwipeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1327e = f1323c;
        this.f1329g = 0;
        this.f1330h = new LinkedHashMap<>();
        this.f1332j = new float[4];
        this.f1333k = new ArrayList();
        this.f1334l = new ArrayList();
        this.f1335m = new HashMap();
        this.f1336n = new HashMap();
        this.f1338p = true;
        this.f1339q = new boolean[]{true, true, true, true};
        this.f1340r = false;
        this.f1341s = new ViewDragHelper.Callback() {

            /* renamed from: a */
            boolean f1349a = true;

            public int clampViewPositionHorizontal(View view, int i, int i2) {
                if (view == SwipeLayout.this.getSurfaceView()) {
                    switch (C06834.f1353a[SwipeLayout.this.f1327e.ordinal()]) {
                        case 1:
                        case 2:
                            return SwipeLayout.this.getPaddingLeft();
                        case 3:
                            if (i < SwipeLayout.this.getPaddingLeft()) {
                                return SwipeLayout.this.getPaddingLeft();
                            }
                            if (i > SwipeLayout.this.getPaddingLeft() + SwipeLayout.this.f1329g) {
                                return SwipeLayout.this.getPaddingLeft() + SwipeLayout.this.f1329g;
                            }
                            return i;
                        case 4:
                            if (i > SwipeLayout.this.getPaddingLeft()) {
                                return SwipeLayout.this.getPaddingLeft();
                            }
                            if (i < SwipeLayout.this.getPaddingLeft() - SwipeLayout.this.f1329g) {
                                return SwipeLayout.this.getPaddingLeft() - SwipeLayout.this.f1329g;
                            }
                            return i;
                        default:
                            return i;
                    }
                } else if (SwipeLayout.this.getCurrentBottomView() != view) {
                    return i;
                } else {
                    switch (C06834.f1353a[SwipeLayout.this.f1327e.ordinal()]) {
                        case 1:
                        case 2:
                            return SwipeLayout.this.getPaddingLeft();
                        case 3:
                            if (SwipeLayout.this.f1331i != C0688e.PullOut || i <= SwipeLayout.this.getPaddingLeft()) {
                                return i;
                            }
                            return SwipeLayout.this.getPaddingLeft();
                        case 4:
                            if (SwipeLayout.this.f1331i != C0688e.PullOut || i >= SwipeLayout.this.getMeasuredWidth() - SwipeLayout.this.f1329g) {
                                return i;
                            }
                            return SwipeLayout.this.getMeasuredWidth() - SwipeLayout.this.f1329g;
                        default:
                            return i;
                    }
                }
            }

            public int clampViewPositionVertical(View view, int i, int i2) {
                if (view == SwipeLayout.this.getSurfaceView()) {
                    switch (C06834.f1353a[SwipeLayout.this.f1327e.ordinal()]) {
                        case 1:
                            if (i < SwipeLayout.this.getPaddingTop()) {
                                return SwipeLayout.this.getPaddingTop();
                            }
                            if (i > SwipeLayout.this.getPaddingTop() + SwipeLayout.this.f1329g) {
                                return SwipeLayout.this.getPaddingTop() + SwipeLayout.this.f1329g;
                            }
                            return i;
                        case 2:
                            if (i < SwipeLayout.this.getPaddingTop() - SwipeLayout.this.f1329g) {
                                return SwipeLayout.this.getPaddingTop() - SwipeLayout.this.f1329g;
                            }
                            if (i > SwipeLayout.this.getPaddingTop()) {
                                return SwipeLayout.this.getPaddingTop();
                            }
                            return i;
                        case 3:
                        case 4:
                            return SwipeLayout.this.getPaddingTop();
                        default:
                            return i;
                    }
                } else {
                    View surfaceView = SwipeLayout.this.getSurfaceView();
                    int top = surfaceView == null ? 0 : surfaceView.getTop();
                    switch (C06834.f1353a[SwipeLayout.this.f1327e.ordinal()]) {
                        case 1:
                            if (SwipeLayout.this.f1331i == C0688e.PullOut) {
                                if (i > SwipeLayout.this.getPaddingTop()) {
                                    return SwipeLayout.this.getPaddingTop();
                                }
                                return i;
                            } else if (top + i2 < SwipeLayout.this.getPaddingTop()) {
                                return SwipeLayout.this.getPaddingTop();
                            } else {
                                if (top + i2 > SwipeLayout.this.getPaddingTop() + SwipeLayout.this.f1329g) {
                                    return SwipeLayout.this.getPaddingTop() + SwipeLayout.this.f1329g;
                                }
                                return i;
                            }
                        case 2:
                            if (SwipeLayout.this.f1331i == C0688e.PullOut) {
                                if (i < SwipeLayout.this.getMeasuredHeight() - SwipeLayout.this.f1329g) {
                                    return SwipeLayout.this.getMeasuredHeight() - SwipeLayout.this.f1329g;
                                }
                                return i;
                            } else if (top + i2 >= SwipeLayout.this.getPaddingTop()) {
                                return SwipeLayout.this.getPaddingTop();
                            } else {
                                if (top + i2 <= SwipeLayout.this.getPaddingTop() - SwipeLayout.this.f1329g) {
                                    return SwipeLayout.this.getPaddingTop() - SwipeLayout.this.f1329g;
                                }
                                return i;
                            }
                        case 3:
                        case 4:
                            return SwipeLayout.this.getPaddingTop();
                        default:
                            return i;
                    }
                }
            }

            public boolean tryCaptureView(View view, int i) {
                boolean z;
                boolean z2 = true;
                if (view == SwipeLayout.this.getSurfaceView() || SwipeLayout.this.getBottomViews().contains(view)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (SwipeLayout.this.getOpenStatus() != C0689f.Close) {
                        z2 = false;
                    }
                    this.f1349a = z2;
                }
                return z;
            }

            public int getViewHorizontalDragRange(View view) {
                return SwipeLayout.this.f1329g;
            }

            public int getViewVerticalDragRange(View view) {
                return SwipeLayout.this.f1329g;
            }

            public void onViewReleased(View view, float f, float f2) {
                super.onViewReleased(view, f, f2);
                for (C0692i a : SwipeLayout.this.f1333k) {
                    a.mo8157a(SwipeLayout.this, f, f2);
                }
                SwipeLayout.this.mo8098a(f, f2, this.f1349a);
                SwipeLayout.this.invalidate();
            }

            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                View surfaceView = SwipeLayout.this.getSurfaceView();
                if (surfaceView != null) {
                    View currentBottomView = SwipeLayout.this.getCurrentBottomView();
                    int left = surfaceView.getLeft();
                    int right = surfaceView.getRight();
                    int top = surfaceView.getTop();
                    int bottom = surfaceView.getBottom();
                    if (view == surfaceView) {
                        if (SwipeLayout.this.f1331i == C0688e.PullOut && currentBottomView != null) {
                            if (SwipeLayout.this.f1327e == C0685b.Left || SwipeLayout.this.f1327e == C0685b.Right) {
                                currentBottomView.offsetLeftAndRight(i3);
                            } else {
                                currentBottomView.offsetTopAndBottom(i4);
                            }
                        }
                    } else if (SwipeLayout.this.getBottomViews().contains(view)) {
                        if (SwipeLayout.this.f1331i == C0688e.PullOut) {
                            surfaceView.offsetLeftAndRight(i3);
                            surfaceView.offsetTopAndBottom(i4);
                        } else {
                            Rect a = SwipeLayout.this.m2034a(SwipeLayout.this.f1327e);
                            if (currentBottomView != null) {
                                currentBottomView.layout(a.left, a.top, a.right, a.bottom);
                            }
                            int left2 = surfaceView.getLeft() + i3;
                            int top2 = surfaceView.getTop() + i4;
                            if (SwipeLayout.this.f1327e == C0685b.Left && left2 < SwipeLayout.this.getPaddingLeft()) {
                                left2 = SwipeLayout.this.getPaddingLeft();
                            } else if (SwipeLayout.this.f1327e == C0685b.Right && left2 > SwipeLayout.this.getPaddingLeft()) {
                                left2 = SwipeLayout.this.getPaddingLeft();
                            } else if (SwipeLayout.this.f1327e == C0685b.Top && top2 < SwipeLayout.this.getPaddingTop()) {
                                top2 = SwipeLayout.this.getPaddingTop();
                            } else if (SwipeLayout.this.f1327e == C0685b.Bottom && top2 > SwipeLayout.this.getPaddingTop()) {
                                top2 = SwipeLayout.this.getPaddingTop();
                            }
                            surfaceView.layout(left2, top2, SwipeLayout.this.getMeasuredWidth() + left2, SwipeLayout.this.getMeasuredHeight() + top2);
                        }
                    }
                    SwipeLayout.this.mo8109b(left, top, right, bottom);
                    SwipeLayout.this.mo8099a(left, top, i3, i4);
                    SwipeLayout.this.invalidate();
                }
            }
        };
        this.f1342t = 0;
        this.f1345w = -1.0f;
        this.f1346x = -1.0f;
        this.f1348z = new GestureDetector(getContext(), new C0691h());
        this.f1328f = ViewDragHelper.create(this, this.f1341s);
        this.f1326d = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwipeLayout);
        int i2 = obtainStyledAttributes.getInt(R.styleable.SwipeLayout_drag_edge, 2);
        this.f1332j[C0685b.Left.ordinal()] = obtainStyledAttributes.getDimension(R.styleable.SwipeLayout_leftEdgeSwipeOffset, 0.0f);
        this.f1332j[C0685b.Right.ordinal()] = obtainStyledAttributes.getDimension(R.styleable.SwipeLayout_rightEdgeSwipeOffset, 0.0f);
        this.f1332j[C0685b.Top.ordinal()] = obtainStyledAttributes.getDimension(R.styleable.SwipeLayout_topEdgeSwipeOffset, 0.0f);
        this.f1332j[C0685b.Bottom.ordinal()] = obtainStyledAttributes.getDimension(R.styleable.SwipeLayout_bottomEdgeSwipeOffset, 0.0f);
        setClickToClose(obtainStyledAttributes.getBoolean(R.styleable.SwipeLayout_clickToClose, this.f1340r));
        if ((i2 & 1) == 1) {
            this.f1330h.put(C0685b.Left, (Object) null);
        }
        if ((i2 & 4) == 4) {
            this.f1330h.put(C0685b.Top, (Object) null);
        }
        if ((i2 & 2) == 2) {
            this.f1330h.put(C0685b.Right, (Object) null);
        }
        if ((i2 & 8) == 8) {
            this.f1330h.put(C0685b.Bottom, (Object) null);
        }
        this.f1331i = C0688e.values()[obtainStyledAttributes.getInt(R.styleable.SwipeLayout_show_mode, C0688e.PullOut.ordinal())];
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public void mo8104a(C0692i iVar) {
        this.f1333k.add(iVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo8106a(View view, Rect rect, C0685b bVar, int i, int i2, int i3, int i4) {
        boolean z;
        if (this.f1336n.get(view).booleanValue()) {
            return false;
        }
        int i5 = rect.left;
        int i6 = rect.right;
        int i7 = rect.top;
        int i8 = rect.bottom;
        if (getShowMode() == C0688e.LayDown) {
            if ((bVar == C0685b.Right && i3 <= i5) || ((bVar == C0685b.Left && i >= i6) || ((bVar == C0685b.Top && i2 >= i8) || (bVar == C0685b.Bottom && i4 <= i7)))) {
                z = true;
            }
            z = false;
        } else {
            if (getShowMode() == C0688e.PullOut && ((bVar == C0685b.Right && i6 <= getWidth()) || ((bVar == C0685b.Left && i5 >= getPaddingLeft()) || ((bVar == C0685b.Top && i7 >= getPaddingTop()) || (bVar == C0685b.Bottom && i8 <= getHeight()))))) {
                z = true;
            }
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x001c A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo8111b(android.view.View r8, android.graphics.Rect r9, com.daimajia.swipe.SwipeLayout.C0685b r10, int r11, int r12, int r13, int r14) {
        /*
            r7 = this;
            r0 = 1
            int r1 = r9.left
            int r2 = r9.right
            int r3 = r9.top
            int r4 = r9.bottom
            com.daimajia.swipe.SwipeLayout$e r5 = r7.getShowMode()
            com.daimajia.swipe.SwipeLayout$e r6 = com.daimajia.swipe.SwipeLayout.C0688e.LayDown
            if (r5 != r6) goto L_0x0032
            int[] r5 = com.daimajia.swipe.SwipeLayout.C06834.f1353a
            int r6 = r10.ordinal()
            r5 = r5[r6]
            switch(r5) {
                case 1: goto L_0x0028;
                case 2: goto L_0x002d;
                case 3: goto L_0x0023;
                case 4: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        L_0x001e:
            if (r13 <= r1) goto L_0x001c
            if (r13 > r2) goto L_0x001c
            goto L_0x001d
        L_0x0023:
            if (r11 >= r2) goto L_0x001c
            if (r11 < r1) goto L_0x001c
            goto L_0x001d
        L_0x0028:
            if (r12 < r3) goto L_0x001c
            if (r12 >= r4) goto L_0x001c
            goto L_0x001d
        L_0x002d:
            if (r14 <= r3) goto L_0x001c
            if (r14 > r4) goto L_0x001c
            goto L_0x001d
        L_0x0032:
            com.daimajia.swipe.SwipeLayout$e r5 = r7.getShowMode()
            com.daimajia.swipe.SwipeLayout$e r6 = com.daimajia.swipe.SwipeLayout.C0688e.PullOut
            if (r5 != r6) goto L_0x001c
            int[] r5 = com.daimajia.swipe.SwipeLayout.C06834.f1353a
            int r6 = r10.ordinal()
            r5 = r5[r6]
            switch(r5) {
                case 1: goto L_0x0046;
                case 2: goto L_0x006d;
                case 3: goto L_0x0060;
                case 4: goto L_0x0053;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x001c
        L_0x0046:
            int r1 = r7.getPaddingTop()
            if (r3 >= r1) goto L_0x001c
            int r1 = r7.getPaddingTop()
            if (r4 < r1) goto L_0x001c
            goto L_0x001d
        L_0x0053:
            int r3 = r7.getWidth()
            if (r1 > r3) goto L_0x001c
            int r1 = r7.getWidth()
            if (r2 <= r1) goto L_0x001c
            goto L_0x001d
        L_0x0060:
            int r3 = r7.getPaddingLeft()
            if (r2 < r3) goto L_0x001c
            int r2 = r7.getPaddingLeft()
            if (r1 >= r2) goto L_0x001c
            goto L_0x001d
        L_0x006d:
            int r1 = r7.getHeight()
            if (r3 >= r1) goto L_0x001c
            int r1 = r7.getPaddingTop()
            if (r3 < r1) goto L_0x001c
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.daimajia.swipe.SwipeLayout.mo8111b(android.view.View, android.graphics.Rect, com.daimajia.swipe.SwipeLayout$b, int, int, int, int):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Rect mo8096a(View view) {
        Rect rect = new Rect(view.getLeft(), view.getTop(), 0, 0);
        View view2 = view;
        while (view2.getParent() != null && view2 != getRootView() && (view2 = (View) view2.getParent()) != this) {
            rect.left += view2.getLeft();
            rect.top += view2.getTop();
        }
        rect.right = rect.left + view.getMeasuredWidth();
        rect.bottom = rect.top + view.getMeasuredHeight();
        return rect;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8099a(int i, int i2, int i3, int i4) {
        boolean z = false;
        C0685b dragEdge = getDragEdge();
        if (dragEdge != C0685b.Left ? dragEdge != C0685b.Right ? dragEdge != C0685b.Top ? dragEdge != C0685b.Bottom || i4 <= 0 : i4 >= 0 : i3 <= 0 : i3 >= 0) {
            z = true;
        }
        mo8100a(i, i2, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8100a(int i, int i2, boolean z) {
        m2049j();
        C0689f openStatus = getOpenStatus();
        if (!this.f1333k.isEmpty()) {
            this.f1342t++;
            for (C0692i next : this.f1333k) {
                if (this.f1342t == 1) {
                    if (z) {
                        next.mo8156a(this);
                    } else {
                        next.mo8160c(this);
                    }
                }
                next.mo8158a(this, i - getPaddingLeft(), i2 - getPaddingTop());
            }
            if (openStatus == C0689f.Close) {
                for (C0692i d : this.f1333k) {
                    d.mo8161d(this);
                }
                this.f1342t = 0;
            }
            if (openStatus == C0689f.Open) {
                View currentBottomView = getCurrentBottomView();
                if (currentBottomView != null) {
                    currentBottomView.setEnabled(true);
                }
                for (C0692i b : this.f1333k) {
                    b.mo8159b(this);
                }
                this.f1342t = 0;
            }
        }
    }

    /* renamed from: j */
    private void m2049j() {
        C0689f openStatus = getOpenStatus();
        List<View> bottomViews = getBottomViews();
        if (openStatus == C0689f.Close) {
            for (View next : bottomViews) {
                if (!(next == null || next.getVisibility() == 4)) {
                    next.setVisibility(4);
                }
            }
            return;
        }
        View currentBottomView = getCurrentBottomView();
        if (currentBottomView != null && currentBottomView.getVisibility() != 0) {
            currentBottomView.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8109b(int i, int i2, int i3, int i4) {
        int i5;
        float f;
        if (!this.f1335m.isEmpty()) {
            for (Map.Entry next : this.f1335m.entrySet()) {
                View view = (View) next.getKey();
                Rect a = mo8096a(view);
                if (mo8111b(view, a, this.f1327e, i, i2, i3, i4)) {
                    this.f1336n.put(view, false);
                    int i6 = 0;
                    float f2 = 0.0f;
                    if (getShowMode() == C0688e.LayDown) {
                        switch (this.f1327e) {
                            case Top:
                                i6 = a.top - i2;
                                f2 = ((float) i6) / ((float) view.getHeight());
                                break;
                            case Bottom:
                                i6 = a.bottom - i4;
                                f2 = ((float) i6) / ((float) view.getHeight());
                                break;
                            case Left:
                                i6 = a.left - i;
                                f2 = ((float) i6) / ((float) view.getWidth());
                                break;
                            case Right:
                                i6 = a.right - i3;
                                f2 = ((float) i6) / ((float) view.getWidth());
                                break;
                        }
                        i5 = i6;
                        f = f2;
                    } else {
                        if (getShowMode() == C0688e.PullOut) {
                            switch (this.f1327e) {
                                case Top:
                                    int paddingTop = a.bottom - getPaddingTop();
                                    i5 = paddingTop;
                                    f = ((float) paddingTop) / ((float) view.getHeight());
                                    break;
                                case Bottom:
                                    int height = a.top - getHeight();
                                    i5 = height;
                                    f = ((float) height) / ((float) view.getHeight());
                                    break;
                                case Left:
                                    int paddingLeft = a.right - getPaddingLeft();
                                    i5 = paddingLeft;
                                    f = ((float) paddingLeft) / ((float) view.getWidth());
                                    break;
                                case Right:
                                    int width = a.left - getWidth();
                                    i5 = width;
                                    f = ((float) width) / ((float) view.getWidth());
                                    break;
                            }
                        }
                        i5 = 0;
                        f = 0.0f;
                    }
                    Iterator it = ((ArrayList) next.getValue()).iterator();
                    while (it.hasNext()) {
                        ((C0687d) it.next()).mo8152a(view, this.f1327e, Math.abs(f), i5);
                        if (Math.abs(f) == 1.0f) {
                            this.f1336n.put(view, true);
                        }
                    }
                }
                if (mo8106a(view, a, this.f1327e, i, i2, i3, i4)) {
                    this.f1336n.put(view, true);
                    Iterator it2 = ((ArrayList) next.getValue()).iterator();
                    while (it2.hasNext()) {
                        C0687d dVar = (C0687d) it2.next();
                        if (this.f1327e == C0685b.Left || this.f1327e == C0685b.Right) {
                            dVar.mo8152a(view, this.f1327e, 1.0f, view.getWidth());
                        } else {
                            dVar.mo8152a(view, this.f1327e, 1.0f, view.getHeight());
                        }
                    }
                }
            }
        }
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.f1328f.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* renamed from: a */
    public void mo8103a(C0686c cVar) {
        if (this.f1343u == null) {
            this.f1343u = new ArrayList();
        }
        this.f1343u.add(cVar);
    }

    /* renamed from: a */
    public void mo8101a(C0685b bVar, View view) {
        mo8102a(bVar, view, (ViewGroup.LayoutParams) null);
    }

    /* renamed from: a */
    public void mo8102a(C0685b bVar, View view, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParams2;
        int i;
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        if (!checkLayoutParams(layoutParams)) {
            layoutParams2 = generateLayoutParams(layoutParams);
        } else {
            layoutParams2 = layoutParams;
        }
        switch (bVar) {
            case Top:
                i = 48;
                break;
            case Bottom:
                i = 80;
                break;
            case Left:
                i = 3;
                break;
            case Right:
                i = 5;
                break;
            default:
                i = -1;
                break;
        }
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams2).gravity = i;
        }
        addView(view, 0, layoutParams2);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        int i2;
        try {
            i2 = ((Integer) layoutParams.getClass().getField("gravity").get(layoutParams)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            i2 = 0;
        }
        if (i2 <= 0) {
            Iterator<Map.Entry<C0685b, View>> it = this.f1330h.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (next.getValue() == null) {
                    this.f1330h.put(next.getKey(), view);
                    break;
                }
            }
        } else {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this));
            if ((absoluteGravity & 3) == 3) {
                this.f1330h.put(C0685b.Left, view);
            }
            if ((absoluteGravity & 5) == 5) {
                this.f1330h.put(C0685b.Right, view);
            }
            if ((absoluteGravity & 48) == 48) {
                this.f1330h.put(C0685b.Top, view);
            }
            if ((absoluteGravity & 80) == 80) {
                this.f1330h.put(C0685b.Bottom, view);
            }
        }
        if (view != null && view.getParent() != this) {
            super.addView(view, i, layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m2053n();
        if (this.f1343u != null) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < this.f1343u.size()) {
                    this.f1343u.get(i6).mo8151a(this);
                    i5 = i6 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8097a() {
        Rect a = m2037a(false);
        View surfaceView = getSurfaceView();
        if (surfaceView != null) {
            surfaceView.layout(a.left, a.top, a.right, a.bottom);
            bringChildToFront(surfaceView);
        }
        Rect a2 = m2035a(C0688e.PullOut, a);
        View currentBottomView = getCurrentBottomView();
        if (currentBottomView != null) {
            currentBottomView.layout(a2.left, a2.top, a2.right, a2.bottom);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8108b() {
        Rect a = m2037a(false);
        View surfaceView = getSurfaceView();
        if (surfaceView != null) {
            surfaceView.layout(a.left, a.top, a.right, a.bottom);
            bringChildToFront(surfaceView);
        }
        Rect a2 = m2035a(C0688e.LayDown, a);
        View currentBottomView = getCurrentBottomView();
        if (currentBottomView != null) {
            currentBottomView.layout(a2.left, a2.top, a2.right, a2.bottom);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e2  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2039a(android.view.MotionEvent r12) {
        /*
            r11 = this;
            r10 = 1114636288(0x42700000, float:60.0)
            r9 = 1106247680(0x41f00000, float:30.0)
            r8 = 0
            r1 = 0
            r2 = 1
            boolean r0 = r11.f1344v
            if (r0 == 0) goto L_0x000c
        L_0x000b:
            return
        L_0x000c:
            com.daimajia.swipe.SwipeLayout$f r0 = r11.getOpenStatus()
            com.daimajia.swipe.SwipeLayout$f r3 = com.daimajia.swipe.SwipeLayout.C0689f.Middle
            if (r0 != r3) goto L_0x0017
            r11.f1344v = r2
            goto L_0x000b
        L_0x0017:
            com.daimajia.swipe.SwipeLayout$f r4 = r11.getOpenStatus()
            float r0 = r12.getRawX()
            float r3 = r11.f1345w
            float r3 = r0 - r3
            float r0 = r12.getRawY()
            float r5 = r11.f1346x
            float r5 = r0 - r5
            float r0 = r5 / r3
            float r0 = java.lang.Math.abs(r0)
            double r6 = (double) r0
            double r6 = java.lang.Math.atan(r6)
            double r6 = java.lang.Math.toDegrees(r6)
            float r6 = (float) r6
            com.daimajia.swipe.SwipeLayout$f r0 = r11.getOpenStatus()
            com.daimajia.swipe.SwipeLayout$f r7 = com.daimajia.swipe.SwipeLayout.C0689f.Close
            if (r0 != r7) goto L_0x0058
            r0 = 1110704128(0x42340000, float:45.0)
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x011c
            int r0 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x010e
            boolean r0 = r11.mo8114d()
            if (r0 == 0) goto L_0x010e
            com.daimajia.swipe.SwipeLayout$b r0 = com.daimajia.swipe.SwipeLayout.C0685b.Left
        L_0x0055:
            r11.setCurrentDragEdge(r0)
        L_0x0058:
            com.daimajia.swipe.SwipeLayout$b r0 = r11.f1327e
            com.daimajia.swipe.SwipeLayout$b r7 = com.daimajia.swipe.SwipeLayout.C0685b.Right
            if (r0 != r7) goto L_0x014e
            com.daimajia.swipe.SwipeLayout$f r0 = com.daimajia.swipe.SwipeLayout.C0689f.Open
            if (r4 != r0) goto L_0x0069
            int r0 = r11.f1326d
            float r0 = (float) r0
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0075
        L_0x0069:
            com.daimajia.swipe.SwipeLayout$f r0 = com.daimajia.swipe.SwipeLayout.C0689f.Close
            if (r4 != r0) goto L_0x0138
            int r0 = r11.f1326d
            int r0 = -r0
            float r0 = (float) r0
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0138
        L_0x0075:
            r0 = r2
        L_0x0076:
            if (r0 != 0) goto L_0x007c
            com.daimajia.swipe.SwipeLayout$f r0 = com.daimajia.swipe.SwipeLayout.C0689f.Middle
            if (r4 != r0) goto L_0x013b
        L_0x007c:
            r0 = r2
        L_0x007d:
            int r7 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r7 > 0) goto L_0x0083
            if (r0 != 0) goto L_0x014e
        L_0x0083:
            r0 = r2
        L_0x0084:
            com.daimajia.swipe.SwipeLayout$b r7 = r11.f1327e
            com.daimajia.swipe.SwipeLayout$b r8 = com.daimajia.swipe.SwipeLayout.C0685b.Left
            if (r7 != r8) goto L_0x00b0
            com.daimajia.swipe.SwipeLayout$f r7 = com.daimajia.swipe.SwipeLayout.C0689f.Open
            if (r4 != r7) goto L_0x0096
            int r7 = r11.f1326d
            int r7 = -r7
            float r7 = (float) r7
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 < 0) goto L_0x00a1
        L_0x0096:
            com.daimajia.swipe.SwipeLayout$f r7 = com.daimajia.swipe.SwipeLayout.C0689f.Close
            if (r4 != r7) goto L_0x013e
            int r7 = r11.f1326d
            float r7 = (float) r7
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x013e
        L_0x00a1:
            r3 = r2
        L_0x00a2:
            if (r3 != 0) goto L_0x00a8
            com.daimajia.swipe.SwipeLayout$f r3 = com.daimajia.swipe.SwipeLayout.C0689f.Middle
            if (r4 != r3) goto L_0x0141
        L_0x00a8:
            r3 = r2
        L_0x00a9:
            int r7 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r7 > 0) goto L_0x00af
            if (r3 != 0) goto L_0x00b0
        L_0x00af:
            r0 = r2
        L_0x00b0:
            com.daimajia.swipe.SwipeLayout$b r3 = r11.f1327e
            com.daimajia.swipe.SwipeLayout$b r7 = com.daimajia.swipe.SwipeLayout.C0685b.Top
            if (r3 != r7) goto L_0x00dc
            com.daimajia.swipe.SwipeLayout$f r3 = com.daimajia.swipe.SwipeLayout.C0689f.Open
            if (r4 != r3) goto L_0x00c2
            int r3 = r11.f1326d
            int r3 = -r3
            float r3 = (float) r3
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x00cd
        L_0x00c2:
            com.daimajia.swipe.SwipeLayout$f r3 = com.daimajia.swipe.SwipeLayout.C0689f.Close
            if (r4 != r3) goto L_0x0144
            int r3 = r11.f1326d
            float r3 = (float) r3
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0144
        L_0x00cd:
            r3 = r2
        L_0x00ce:
            if (r3 != 0) goto L_0x00d4
            com.daimajia.swipe.SwipeLayout$f r3 = com.daimajia.swipe.SwipeLayout.C0689f.Middle
            if (r4 != r3) goto L_0x0146
        L_0x00d4:
            r3 = r2
        L_0x00d5:
            int r7 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r7 < 0) goto L_0x00db
            if (r3 != 0) goto L_0x00dc
        L_0x00db:
            r0 = r2
        L_0x00dc:
            com.daimajia.swipe.SwipeLayout$b r3 = r11.f1327e
            com.daimajia.swipe.SwipeLayout$b r7 = com.daimajia.swipe.SwipeLayout.C0685b.Bottom
            if (r3 != r7) goto L_0x0108
            com.daimajia.swipe.SwipeLayout$f r3 = com.daimajia.swipe.SwipeLayout.C0689f.Open
            if (r4 != r3) goto L_0x00ed
            int r3 = r11.f1326d
            float r3 = (float) r3
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x00f9
        L_0x00ed:
            com.daimajia.swipe.SwipeLayout$f r3 = com.daimajia.swipe.SwipeLayout.C0689f.Close
            if (r4 != r3) goto L_0x0148
            int r3 = r11.f1326d
            int r3 = -r3
            float r3 = (float) r3
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0148
        L_0x00f9:
            r3 = r2
        L_0x00fa:
            if (r3 != 0) goto L_0x0100
            com.daimajia.swipe.SwipeLayout$f r3 = com.daimajia.swipe.SwipeLayout.C0689f.Middle
            if (r4 != r3) goto L_0x014a
        L_0x0100:
            r3 = r2
        L_0x0101:
            int r4 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r4 < 0) goto L_0x0107
            if (r3 != 0) goto L_0x0108
        L_0x0107:
            r0 = r2
        L_0x0108:
            if (r0 != 0) goto L_0x014c
        L_0x010a:
            r11.f1344v = r2
            goto L_0x000b
        L_0x010e:
            int r0 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x000b
            boolean r0 = r11.mo8115e()
            if (r0 == 0) goto L_0x000b
            com.daimajia.swipe.SwipeLayout$b r0 = com.daimajia.swipe.SwipeLayout.C0685b.Right
            goto L_0x0055
        L_0x011c:
            int r0 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x012a
            boolean r0 = r11.mo8116f()
            if (r0 == 0) goto L_0x012a
            com.daimajia.swipe.SwipeLayout$b r0 = com.daimajia.swipe.SwipeLayout.C0685b.Top
            goto L_0x0055
        L_0x012a:
            int r0 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x000b
            boolean r0 = r11.mo8117g()
            if (r0 == 0) goto L_0x000b
            com.daimajia.swipe.SwipeLayout$b r0 = com.daimajia.swipe.SwipeLayout.C0685b.Bottom
            goto L_0x0055
        L_0x0138:
            r0 = r1
            goto L_0x0076
        L_0x013b:
            r0 = r1
            goto L_0x007d
        L_0x013e:
            r3 = r1
            goto L_0x00a2
        L_0x0141:
            r3 = r1
            goto L_0x00a9
        L_0x0144:
            r3 = r1
            goto L_0x00ce
        L_0x0146:
            r3 = r1
            goto L_0x00d5
        L_0x0148:
            r3 = r1
            goto L_0x00fa
        L_0x014a:
            r3 = r1
            goto L_0x0101
        L_0x014c:
            r2 = r1
            goto L_0x010a
        L_0x014e:
            r0 = r1
            goto L_0x0084
        */
        throw new UnsupportedOperationException("Method not decompiled: com.daimajia.swipe.SwipeLayout.m2039a(android.view.MotionEvent):void");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (!mo8112c()) {
            return false;
        }
        if (this.f1340r && getOpenStatus() == C0689f.Open && m2042b(motionEvent)) {
            return true;
        }
        for (C0690g next : this.f1334l) {
            if (next != null && next.mo8153a(motionEvent)) {
                return false;
            }
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f1328f.processTouchEvent(motionEvent);
                this.f1344v = false;
                this.f1345w = motionEvent.getRawX();
                this.f1346x = motionEvent.getRawY();
                if (getOpenStatus() == C0689f.Middle) {
                    this.f1344v = true;
                    break;
                }
                break;
            case 1:
            case 3:
                this.f1344v = false;
                this.f1328f.processTouchEvent(motionEvent);
                break;
            case 2:
                boolean z = this.f1344v;
                m2039a(motionEvent);
                if (this.f1344v && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (!z && this.f1344v) {
                    return false;
                }
            default:
                this.f1328f.processTouchEvent(motionEvent);
                break;
        }
        return this.f1344v;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!mo8112c()) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        this.f1348z.onTouchEvent(motionEvent);
        switch (actionMasked) {
            case 0:
                this.f1328f.processTouchEvent(motionEvent);
                this.f1345w = motionEvent.getRawX();
                this.f1346x = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                this.f1344v = false;
                this.f1328f.processTouchEvent(motionEvent);
                break;
            case 2:
                break;
            default:
                this.f1328f.processTouchEvent(motionEvent);
                break;
        }
        m2039a(motionEvent);
        if (this.f1344v) {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.f1328f.processTouchEvent(motionEvent);
        }
        if (super.onTouchEvent(motionEvent) || this.f1344v || actionMasked == 0) {
            return true;
        }
        return false;
    }

    public void setClickToClose(boolean z) {
        this.f1340r = z;
    }

    public void setSwipeEnabled(boolean z) {
        this.f1338p = z;
    }

    /* renamed from: c */
    public boolean mo8112c() {
        return this.f1338p;
    }

    /* renamed from: d */
    public boolean mo8114d() {
        View view = this.f1330h.get(C0685b.Left);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.f1339q[C0685b.Left.ordinal()];
    }

    public void setLeftSwipeEnabled(boolean z) {
        this.f1339q[C0685b.Left.ordinal()] = z;
    }

    /* renamed from: e */
    public boolean mo8115e() {
        View view = this.f1330h.get(C0685b.Right);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.f1339q[C0685b.Right.ordinal()];
    }

    public void setRightSwipeEnabled(boolean z) {
        this.f1339q[C0685b.Right.ordinal()] = z;
    }

    /* renamed from: f */
    public boolean mo8116f() {
        View view = this.f1330h.get(C0685b.Top);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.f1339q[C0685b.Top.ordinal()];
    }

    public void setTopSwipeEnabled(boolean z) {
        this.f1339q[C0685b.Top.ordinal()] = z;
    }

    /* renamed from: g */
    public boolean mo8117g() {
        View view = this.f1330h.get(C0685b.Bottom);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.f1339q[C0685b.Bottom.ordinal()];
    }

    public void setBottomSwipeEnabled(boolean z) {
        this.f1339q[C0685b.Bottom.ordinal()] = z;
    }

    /* renamed from: k */
    private boolean m2050k() {
        return getAdapterView() != null;
    }

    private AdapterView getAdapterView() {
        ViewParent parent = getParent();
        if (parent instanceof AdapterView) {
            return (AdapterView) parent;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r0 = (android.widget.AdapterView) r0;
     */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m2051l() {
        /*
            r6 = this;
            com.daimajia.swipe.SwipeLayout$f r0 = r6.getOpenStatus()
            com.daimajia.swipe.SwipeLayout$f r1 = com.daimajia.swipe.SwipeLayout.C0689f.Close
            if (r0 == r1) goto L_0x0009
        L_0x0008:
            return
        L_0x0009:
            android.view.ViewParent r0 = r6.getParent()
            boolean r1 = r0 instanceof android.widget.AdapterView
            if (r1 == 0) goto L_0x0008
            android.widget.AdapterView r0 = (android.widget.AdapterView) r0
            int r1 = r0.getPositionForView(r6)
            r2 = -1
            if (r1 == r2) goto L_0x0008
            int r2 = r0.getFirstVisiblePosition()
            int r2 = r1 - r2
            android.view.View r2 = r0.getChildAt(r2)
            android.widget.Adapter r3 = r0.getAdapter()
            long r4 = r3.getItemId(r1)
            r0.performItemClick(r2, r1, r4)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.daimajia.swipe.SwipeLayout.m2051l():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean m2052m() {
        boolean z;
        if (getOpenStatus() != C0689f.Close) {
            return false;
        }
        ViewParent parent = getParent();
        if (!(parent instanceof AdapterView)) {
            return false;
        }
        AdapterView adapterView = (AdapterView) parent;
        int positionForView = adapterView.getPositionForView(this);
        if (positionForView == -1) {
            return false;
        }
        long itemIdAtPosition = adapterView.getItemIdAtPosition(positionForView);
        try {
            Method declaredMethod = AbsListView.class.getDeclaredMethod("performLongPress", new Class[]{View.class, Integer.TYPE, Long.TYPE});
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(adapterView, new Object[]{this, Integer.valueOf(positionForView), Long.valueOf(itemIdAtPosition)})).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            if (adapterView.getOnItemLongClickListener() != null) {
                z = adapterView.getOnItemLongClickListener().onItemLongClick(adapterView, this, positionForView, itemIdAtPosition);
            } else {
                z = false;
            }
            if (!z) {
                return z;
            }
            adapterView.performHapticFeedback(0);
            return z;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (m2050k()) {
            if (this.f1324a == null) {
                setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SwipeLayout.this.m2051l();
                    }
                });
            }
            if (this.f1325b == null) {
                setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        boolean unused = SwipeLayout.this.m2052m();
                        return true;
                    }
                });
            }
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f1324a = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
        this.f1325b = onLongClickListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m2042b(MotionEvent motionEvent) {
        View surfaceView = getSurfaceView();
        if (surfaceView == null) {
            return false;
        }
        if (this.f1347y == null) {
            this.f1347y = new Rect();
        }
        surfaceView.getHitRect(this.f1347y);
        return this.f1347y.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    /* renamed from: com.daimajia.swipe.SwipeLayout$h */
    class C0691h extends GestureDetector.SimpleOnGestureListener {
        C0691h() {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (SwipeLayout.this.f1340r && SwipeLayout.this.m2042b(motionEvent)) {
                SwipeLayout.this.mo8128i();
            }
            return super.onSingleTapUp(motionEvent);
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwipeLayout.this.f1337o != null) {
                View currentBottomView = SwipeLayout.this.getCurrentBottomView();
                View surfaceView = SwipeLayout.this.getSurfaceView();
                if (currentBottomView == null || motionEvent.getX() <= ((float) currentBottomView.getLeft()) || motionEvent.getX() >= ((float) currentBottomView.getRight()) || motionEvent.getY() <= ((float) currentBottomView.getTop()) || motionEvent.getY() >= ((float) currentBottomView.getBottom())) {
                    currentBottomView = surfaceView;
                }
                SwipeLayout.this.f1337o.mo8150a(SwipeLayout.this, currentBottomView == surfaceView);
            }
            return true;
        }
    }

    public void setDragDistance(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f1329g = m2033a((float) i);
        requestLayout();
    }

    public void setShowMode(C0688e eVar) {
        this.f1331i = eVar;
        requestLayout();
    }

    public C0685b getDragEdge() {
        return this.f1327e;
    }

    public int getDragDistance() {
        return this.f1329g;
    }

    public C0688e getShowMode() {
        return this.f1331i;
    }

    public View getSurfaceView() {
        if (getChildCount() == 0) {
            return null;
        }
        return getChildAt(getChildCount() - 1);
    }

    public View getCurrentBottomView() {
        List<View> bottomViews = getBottomViews();
        if (this.f1327e.ordinal() < bottomViews.size()) {
            return bottomViews.get(this.f1327e.ordinal());
        }
        return null;
    }

    public List<View> getBottomViews() {
        ArrayList arrayList = new ArrayList();
        for (C0685b bVar : C0685b.values()) {
            arrayList.add(this.f1330h.get(bVar));
        }
        return arrayList;
    }

    public C0689f getOpenStatus() {
        View surfaceView = getSurfaceView();
        if (surfaceView == null) {
            return C0689f.Close;
        }
        int left = surfaceView.getLeft();
        int top = surfaceView.getTop();
        if (left == getPaddingLeft() && top == getPaddingTop()) {
            return C0689f.Close;
        }
        if (left == getPaddingLeft() - this.f1329g || left == getPaddingLeft() + this.f1329g || top == getPaddingTop() - this.f1329g || top == getPaddingTop() + this.f1329g) {
            return C0689f.Open;
        }
        return C0689f.Middle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8098a(float f, float f2, boolean z) {
        float minVelocity = this.f1328f.getMinVelocity();
        View surfaceView = getSurfaceView();
        C0685b bVar = this.f1327e;
        if (bVar != null && surfaceView != null) {
            float f3 = z ? 0.25f : 0.75f;
            if (bVar == C0685b.Left) {
                if (f > minVelocity) {
                    mo8127h();
                } else if (f < (-minVelocity)) {
                    mo8128i();
                } else if ((((float) getSurfaceView().getLeft()) * 1.0f) / ((float) this.f1329g) > f3) {
                    mo8127h();
                } else {
                    mo8128i();
                }
            } else if (bVar == C0685b.Right) {
                if (f > minVelocity) {
                    mo8128i();
                } else if (f < (-minVelocity)) {
                    mo8127h();
                } else if ((((float) (-getSurfaceView().getLeft())) * 1.0f) / ((float) this.f1329g) > f3) {
                    mo8127h();
                } else {
                    mo8128i();
                }
            } else if (bVar == C0685b.Top) {
                if (f2 > minVelocity) {
                    mo8127h();
                } else if (f2 < (-minVelocity)) {
                    mo8128i();
                } else if ((((float) getSurfaceView().getTop()) * 1.0f) / ((float) this.f1329g) > f3) {
                    mo8127h();
                } else {
                    mo8128i();
                }
            } else if (bVar != C0685b.Bottom) {
            } else {
                if (f2 > minVelocity) {
                    mo8128i();
                } else if (f2 < (-minVelocity)) {
                    mo8127h();
                } else if ((((float) (-getSurfaceView().getTop())) * 1.0f) / ((float) this.f1329g) > f3) {
                    mo8127h();
                } else {
                    mo8128i();
                }
            }
        }
    }

    /* renamed from: h */
    public void mo8127h() {
        mo8105a(true, true);
    }

    /* renamed from: a */
    public void mo8105a(boolean z, boolean z2) {
        View surfaceView = getSurfaceView();
        View currentBottomView = getCurrentBottomView();
        if (surfaceView != null) {
            Rect a = m2037a(true);
            if (z) {
                this.f1328f.smoothSlideViewTo(surfaceView, a.left, a.top);
            } else {
                int left = a.left - surfaceView.getLeft();
                int top = a.top - surfaceView.getTop();
                surfaceView.layout(a.left, a.top, a.right, a.bottom);
                if (getShowMode() == C0688e.PullOut) {
                    Rect a2 = m2035a(C0688e.PullOut, a);
                    if (currentBottomView != null) {
                        currentBottomView.layout(a2.left, a2.top, a2.right, a2.bottom);
                    }
                }
                if (z2) {
                    mo8109b(a.left, a.top, a.right, a.bottom);
                    mo8099a(a.left, a.top, left, top);
                } else {
                    m2049j();
                }
            }
            invalidate();
        }
    }

    /* renamed from: i */
    public void mo8128i() {
        mo8110b(true, true);
    }

    /* renamed from: b */
    public void mo8110b(boolean z, boolean z2) {
        View surfaceView = getSurfaceView();
        if (surfaceView != null) {
            if (z) {
                this.f1328f.smoothSlideViewTo(getSurfaceView(), getPaddingLeft(), getPaddingTop());
            } else {
                Rect a = m2037a(false);
                int left = a.left - surfaceView.getLeft();
                int top = a.top - surfaceView.getTop();
                surfaceView.layout(a.left, a.top, a.right, a.bottom);
                if (z2) {
                    mo8109b(a.left, a.top, a.right, a.bottom);
                    mo8099a(a.left, a.top, left, top);
                } else {
                    m2049j();
                }
            }
            invalidate();
        }
    }

    /* renamed from: a */
    private Rect m2037a(boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (z) {
            if (this.f1327e == C0685b.Left) {
                paddingLeft = getPaddingLeft() + this.f1329g;
            } else if (this.f1327e == C0685b.Right) {
                paddingLeft = getPaddingLeft() - this.f1329g;
            } else {
                paddingTop = this.f1327e == C0685b.Top ? getPaddingTop() + this.f1329g : getPaddingTop() - this.f1329g;
            }
        }
        return new Rect(paddingLeft, paddingTop, getMeasuredWidth() + paddingLeft, getMeasuredHeight() + paddingTop);
    }

    /* renamed from: a */
    private Rect m2035a(C0688e eVar, Rect rect) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        View currentBottomView = getCurrentBottomView();
        int i6 = rect.left;
        int i7 = rect.top;
        int i8 = rect.right;
        int i9 = rect.bottom;
        if (eVar == C0688e.PullOut) {
            if (this.f1327e == C0685b.Left) {
                i6 = rect.left - this.f1329g;
            } else if (this.f1327e == C0685b.Right) {
                i6 = rect.right;
            } else {
                i7 = this.f1327e == C0685b.Top ? rect.top - this.f1329g : rect.bottom;
            }
            if (this.f1327e == C0685b.Left || this.f1327e == C0685b.Right) {
                int i10 = rect.bottom;
                if (currentBottomView != null) {
                    i5 = currentBottomView.getMeasuredWidth();
                }
                int i11 = i10;
                i3 = i6;
                i4 = i5 + i6;
                i = i7;
                i2 = i11;
            } else {
                if (currentBottomView != null) {
                    i5 = currentBottomView.getMeasuredHeight();
                }
                int i12 = i5 + i7;
                i = i7;
                i2 = i12;
                i3 = i6;
                i4 = rect.right;
            }
        } else if (eVar != C0688e.LayDown) {
            i = i7;
            i2 = i9;
            i3 = i6;
            i4 = i8;
        } else if (this.f1327e == C0685b.Left) {
            int i13 = i9;
            i3 = i6;
            i4 = this.f1329g + i6;
            i = i7;
            i2 = i13;
        } else if (this.f1327e == C0685b.Right) {
            i = i7;
            i2 = i9;
            i3 = i8 - this.f1329g;
            i4 = i8;
        } else if (this.f1327e == C0685b.Top) {
            i3 = i6;
            i4 = i8;
            int i14 = i7;
            i2 = this.f1329g + i7;
            i = i14;
        } else {
            i = i9 - this.f1329g;
            i2 = i9;
            i3 = i6;
            i4 = i8;
        }
        return new Rect(i3, i, i4, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Rect m2034a(C0685b bVar) {
        int i;
        int i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (bVar == C0685b.Right) {
            paddingLeft = getMeasuredWidth() - this.f1329g;
        } else if (bVar == C0685b.Bottom) {
            paddingTop = getMeasuredHeight() - this.f1329g;
        }
        if (bVar == C0685b.Left || bVar == C0685b.Right) {
            i = paddingLeft + this.f1329g;
            i2 = getMeasuredHeight() + paddingTop;
        } else {
            i = paddingLeft + getMeasuredWidth();
            i2 = this.f1329g + paddingTop;
        }
        return new Rect(paddingLeft, paddingTop, i, i2);
    }

    public void setOnDoubleClickListener(C0684a aVar) {
        this.f1337o = aVar;
    }

    /* renamed from: a */
    private int m2033a(float f) {
        return (int) ((getContext().getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    @Deprecated
    public void setDragEdge(C0685b bVar) {
        if (getChildCount() >= 2) {
            this.f1330h.put(bVar, getChildAt(getChildCount() - 2));
        }
        setCurrentDragEdge(bVar);
    }

    /* access modifiers changed from: protected */
    public void onViewRemoved(View view) {
        for (Map.Entry entry : new HashMap(this.f1330h).entrySet()) {
            if (entry.getValue() == view) {
                this.f1330h.remove(entry.getKey());
            }
        }
    }

    public Map<C0685b, View> getDragEdgeMap() {
        return this.f1330h;
    }

    @Deprecated
    public List<C0685b> getDragEdges() {
        return new ArrayList(this.f1330h.keySet());
    }

    @Deprecated
    public void setDragEdges(List<C0685b> list) {
        int min = Math.min(list.size(), getChildCount() - 1);
        for (int i = 0; i < min; i++) {
            this.f1330h.put(list.get(i), getChildAt(i));
        }
        if (list.size() == 0 || list.contains(f1323c)) {
            setCurrentDragEdge(f1323c);
        } else {
            setCurrentDragEdge(list.get(0));
        }
    }

    @Deprecated
    public void setDragEdges(C0685b... bVarArr) {
        setDragEdges((List<C0685b>) Arrays.asList(bVarArr));
    }

    private float getCurrentOffset() {
        if (this.f1327e == null) {
            return 0.0f;
        }
        return this.f1332j[this.f1327e.ordinal()];
    }

    private void setCurrentDragEdge(C0685b bVar) {
        if (this.f1327e != bVar) {
            this.f1327e = bVar;
            m2053n();
        }
    }

    /* renamed from: n */
    private void m2053n() {
        View currentBottomView = getCurrentBottomView();
        if (currentBottomView != null) {
            if (this.f1327e == C0685b.Left || this.f1327e == C0685b.Right) {
                this.f1329g = currentBottomView.getMeasuredWidth() - m2033a(getCurrentOffset());
            } else {
                this.f1329g = currentBottomView.getMeasuredHeight() - m2033a(getCurrentOffset());
            }
        }
        if (this.f1331i == C0688e.PullOut) {
            mo8097a();
        } else if (this.f1331i == C0688e.LayDown) {
            mo8108b();
        }
        m2049j();
    }
}
