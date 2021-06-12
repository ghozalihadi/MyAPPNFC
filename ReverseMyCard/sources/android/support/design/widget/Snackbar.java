package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.R;
import android.support.design.widget.C0284p;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.p016v4.view.OnApplyWindowInsetsListener;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.p016v4.view.WindowInsetsCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class Snackbar {

    /* renamed from: a */
    static final Handler f735a = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((Snackbar) message.obj).mo1022c();
                    return true;
                case 1:
                    ((Snackbar) message.obj).mo1023c(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    });

    /* renamed from: b */
    final SnackbarLayout f736b;

    /* renamed from: c */
    final C0284p.C0286a f737c = new C0284p.C0286a() {
        /* renamed from: a */
        public void mo1035a() {
            Snackbar.f735a.sendMessage(Snackbar.f735a.obtainMessage(0, Snackbar.this));
        }

        /* renamed from: a */
        public void mo1036a(int i) {
            Snackbar.f735a.sendMessage(Snackbar.f735a.obtainMessage(1, i, 0, Snackbar.this));
        }
    };

    /* renamed from: d */
    private final ViewGroup f738d;

    /* renamed from: e */
    private final Context f739e;

    /* renamed from: f */
    private int f740f;

    /* renamed from: g */
    private C0233b f741g;

    /* renamed from: h */
    private final AccessibilityManager f742h;

    /* renamed from: android.support.design.widget.Snackbar$b */
    public static abstract class C0233b {
        /* renamed from: a */
        public void mo1060a(Snackbar snackbar, int i) {
        }

        /* renamed from: a */
        public void mo1059a(Snackbar snackbar) {
        }
    }

    private Snackbar(ViewGroup viewGroup) {
        this.f738d = viewGroup;
        this.f739e = viewGroup.getContext();
        C0291r.m1597a(this.f739e);
        this.f736b = (SnackbarLayout) LayoutInflater.from(this.f739e).inflate(R.layout.design_layout_snackbar, this.f738d, false);
        this.f742h = (AccessibilityManager) this.f739e.getSystemService("accessibility");
    }

    /* renamed from: a */
    public static Snackbar m1257a(View view, CharSequence charSequence, int i) {
        Snackbar snackbar = new Snackbar(m1258a(view));
        snackbar.mo1017a(charSequence);
        snackbar.mo1016a(i);
        return snackbar;
    }

    /* renamed from: a */
    private static ViewGroup m1258a(View view) {
        ViewGroup viewGroup = null;
        View view2 = view;
        while (!(view2 instanceof CoordinatorLayout)) {
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 16908290) {
                    return (ViewGroup) view2;
                }
                viewGroup = (ViewGroup) view2;
            }
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                    continue;
                } else {
                    view2 = null;
                    continue;
                }
            }
            if (view2 == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view2;
    }

    /* renamed from: a */
    public Snackbar mo1018a(CharSequence charSequence, final View.OnClickListener onClickListener) {
        Button actionView = this.f736b.getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener((View.OnClickListener) null);
        } else {
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    onClickListener.onClick(view);
                    Snackbar.this.mo1020b(1);
                }
            });
        }
        return this;
    }

    /* renamed from: a */
    public Snackbar mo1017a(CharSequence charSequence) {
        this.f736b.getMessageView().setText(charSequence);
        return this;
    }

    /* renamed from: a */
    public Snackbar mo1016a(int i) {
        this.f740f = i;
        return this;
    }

    /* renamed from: a */
    public void mo1019a() {
        C0284p.m1574a().mo1304a(this.f740f, this.f737c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1020b(int i) {
        C0284p.m1574a().mo1306a(this.f737c, i);
    }

    /* renamed from: b */
    public boolean mo1021b() {
        return C0284p.m1574a().mo1311e(this.f737c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo1022c() {
        if (this.f736b.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f736b.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.C0209d) {
                CoordinatorLayout.C0209d dVar = (CoordinatorLayout.C0209d) layoutParams;
                C0232a aVar = new C0232a();
                aVar.mo1061a(0.1f);
                aVar.mo1064b(0.6f);
                aVar.mo1062a(0);
                aVar.mo1063a((SwipeDismissBehavior.C0235a) new SwipeDismissBehavior.C0235a() {
                    /* renamed from: a */
                    public void mo1038a(View view) {
                        view.setVisibility(8);
                        Snackbar.this.mo1020b(0);
                    }

                    /* renamed from: a */
                    public void mo1037a(int i) {
                        switch (i) {
                            case 0:
                                C0284p.m1574a().mo1310d(Snackbar.this.f737c);
                                return;
                            case 1:
                            case 2:
                                C0284p.m1574a().mo1309c(Snackbar.this.f737c);
                                return;
                            default:
                                return;
                        }
                    }
                });
                dVar.mo935a((CoordinatorLayout.C0206a) aVar);
                dVar.f696g = 80;
            }
            this.f738d.addView(this.f736b);
        }
        this.f736b.setOnAttachStateChangeListener(new SnackbarLayout.C0230a() {
            /* renamed from: a */
            public void mo1039a(View view) {
            }

            /* renamed from: b */
            public void mo1040b(View view) {
                if (Snackbar.this.mo1021b()) {
                    Snackbar.f735a.post(new Runnable() {
                        public void run() {
                            Snackbar.this.mo1025d(3);
                        }
                    });
                }
            }
        });
        if (!ViewCompat.isLaidOut(this.f736b)) {
            this.f736b.setOnLayoutChangeListener(new SnackbarLayout.C0231b() {
                /* renamed from: a */
                public void mo1042a(View view, int i, int i2, int i3, int i4) {
                    Snackbar.this.f736b.setOnLayoutChangeListener((SnackbarLayout.C0231b) null);
                    if (Snackbar.this.mo1027f()) {
                        Snackbar.this.mo1024d();
                    } else {
                        Snackbar.this.mo1026e();
                    }
                }
            });
        } else if (mo1027f()) {
            mo1024d();
        } else {
            mo1026e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo1024d() {
        if (Build.VERSION.SDK_INT >= 14) {
            ViewCompat.setTranslationY(this.f736b, (float) this.f736b.getHeight());
            ViewCompat.animate(this.f736b).translationY(0.0f).setInterpolator(C0255a.f900b).setDuration(250).setListener(new ViewPropertyAnimatorListenerAdapter() {
                public void onAnimationStart(View view) {
                    Snackbar.this.f736b.mo1046a(70, 180);
                }

                public void onAnimationEnd(View view) {
                    Snackbar.this.mo1026e();
                }
            }).start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f736b.getContext(), R.anim.design_snackbar_in);
        loadAnimation.setInterpolator(C0255a.f900b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                Snackbar.this.mo1026e();
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.f736b.startAnimation(loadAnimation);
    }

    /* renamed from: e */
    private void m1259e(final int i) {
        if (Build.VERSION.SDK_INT >= 14) {
            ViewCompat.animate(this.f736b).translationY((float) this.f736b.getHeight()).setInterpolator(C0255a.f900b).setDuration(250).setListener(new ViewPropertyAnimatorListenerAdapter() {
                public void onAnimationStart(View view) {
                    Snackbar.this.f736b.mo1047b(0, 180);
                }

                public void onAnimationEnd(View view) {
                    Snackbar.this.mo1025d(i);
                }
            }).start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f736b.getContext(), R.anim.design_snackbar_out);
        loadAnimation.setInterpolator(C0255a.f900b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                Snackbar.this.mo1025d(i);
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.f736b.startAnimation(loadAnimation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo1023c(int i) {
        if (!mo1027f() || this.f736b.getVisibility() != 0) {
            mo1025d(i);
        } else {
            m1259e(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo1026e() {
        C0284p.m1574a().mo1308b(this.f737c);
        if (this.f741g != null) {
            this.f741g.mo1059a(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo1025d(int i) {
        C0284p.m1574a().mo1305a(this.f737c);
        if (this.f741g != null) {
            this.f741g.mo1060a(this, i);
        }
        if (Build.VERSION.SDK_INT < 11) {
            this.f736b.setVisibility(8);
        }
        ViewParent parent = this.f736b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f736b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo1027f() {
        return !this.f742h.isEnabled();
    }

    public static class SnackbarLayout extends LinearLayout {

        /* renamed from: a */
        private TextView f756a;

        /* renamed from: b */
        private Button f757b;

        /* renamed from: c */
        private int f758c;

        /* renamed from: d */
        private int f759d;

        /* renamed from: e */
        private C0231b f760e;

        /* renamed from: f */
        private C0230a f761f;

        /* renamed from: android.support.design.widget.Snackbar$SnackbarLayout$a */
        interface C0230a {
            /* renamed from: a */
            void mo1039a(View view);

            /* renamed from: b */
            void mo1040b(View view);
        }

        /* renamed from: android.support.design.widget.Snackbar$SnackbarLayout$b */
        interface C0231b {
            /* renamed from: a */
            void mo1042a(View view, int i, int i2, int i3, int i4);
        }

        public SnackbarLayout(Context context) {
            this(context, (AttributeSet) null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            this.f758c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
            this.f759d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
            if (obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(R.layout.design_layout_snackbar_include, this);
            ViewCompat.setAccessibilityLiveRegion(this, 1);
            ViewCompat.setImportantForAccessibility(this, 1);
            ViewCompat.setFitsSystemWindows(this, true);
            ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                    return windowInsetsCompat;
                }
            });
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            this.f756a = (TextView) findViewById(R.id.snackbar_text);
            this.f757b = (Button) findViewById(R.id.snackbar_action);
        }

        /* access modifiers changed from: package-private */
        public TextView getMessageView() {
            return this.f756a;
        }

        /* access modifiers changed from: package-private */
        public Button getActionView() {
            return this.f757b;
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            boolean z;
            super.onMeasure(i, i2);
            if (this.f758c > 0 && getMeasuredWidth() > this.f758c) {
                i = View.MeasureSpec.makeMeasureSpec(this.f758c, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
            boolean z2 = this.f756a.getLayout().getLineCount() > 1;
            if (!z2 || this.f759d <= 0 || this.f757b.getMeasuredWidth() <= this.f759d) {
                if (!z2) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (m1280a(0, dimensionPixelSize, dimensionPixelSize)) {
                    z = true;
                }
                z = false;
            } else {
                if (m1280a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    z = true;
                }
                z = false;
            }
            if (z) {
                super.onMeasure(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1046a(int i, int i2) {
            ViewCompat.setAlpha(this.f756a, 0.0f);
            ViewCompat.animate(this.f756a).alpha(1.0f).setDuration((long) i2).setStartDelay((long) i).start();
            if (this.f757b.getVisibility() == 0) {
                ViewCompat.setAlpha(this.f757b, 0.0f);
                ViewCompat.animate(this.f757b).alpha(1.0f).setDuration((long) i2).setStartDelay((long) i).start();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo1047b(int i, int i2) {
            ViewCompat.setAlpha(this.f756a, 1.0f);
            ViewCompat.animate(this.f756a).alpha(0.0f).setDuration((long) i2).setStartDelay((long) i).start();
            if (this.f757b.getVisibility() == 0) {
                ViewCompat.setAlpha(this.f757b, 1.0f);
                ViewCompat.animate(this.f757b).alpha(0.0f).setDuration((long) i2).setStartDelay((long) i).start();
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f760e != null) {
                this.f760e.mo1042a(this, i, i2, i3, i4);
            }
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f761f != null) {
                this.f761f.mo1039a(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f761f != null) {
                this.f761f.mo1040b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void setOnLayoutChangeListener(C0231b bVar) {
            this.f760e = bVar;
        }

        /* access modifiers changed from: package-private */
        public void setOnAttachStateChangeListener(C0230a aVar) {
            this.f761f = aVar;
        }

        /* renamed from: a */
        private boolean m1280a(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.f756a.getPaddingTop() == i2 && this.f756a.getPaddingBottom() == i3) {
                return z;
            }
            m1279a((View) this.f756a, i2, i3);
            return true;
        }

        /* renamed from: a */
        private static void m1279a(View view, int i, int i2) {
            if (ViewCompat.isPaddingRelative(view)) {
                ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i, ViewCompat.getPaddingEnd(view), i2);
            } else {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
            }
        }
    }

    /* renamed from: android.support.design.widget.Snackbar$a */
    final class C0232a extends SwipeDismissBehavior<SnackbarLayout> {
        C0232a() {
        }

        /* renamed from: a */
        public boolean mo1058a(View view) {
            return view instanceof SnackbarLayout;
        }

        /* renamed from: a */
        public boolean mo777a(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
            if (coordinatorLayout.mo872a((View) snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        C0284p.m1574a().mo1309c(Snackbar.this.f737c);
                        break;
                    case 1:
                    case 3:
                        C0284p.m1574a().mo1310d(Snackbar.this.f737c);
                        break;
                }
            }
            return super.mo777a(coordinatorLayout, snackbarLayout, motionEvent);
        }
    }
}
