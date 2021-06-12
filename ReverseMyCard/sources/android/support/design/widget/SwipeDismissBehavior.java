package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.p016v4.view.MotionEventCompat;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.widget.ViewDragHelper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.C0206a<V> {

    /* renamed from: a */
    private boolean f764a;

    /* renamed from: b */
    ViewDragHelper f765b;

    /* renamed from: c */
    C0235a f766c;

    /* renamed from: d */
    int f767d = 2;

    /* renamed from: e */
    float f768e = 0.5f;

    /* renamed from: f */
    float f769f = 0.0f;

    /* renamed from: g */
    float f770g = 0.5f;

    /* renamed from: h */
    private float f771h = 0.0f;

    /* renamed from: i */
    private boolean f772i;

    /* renamed from: j */
    private final ViewDragHelper.Callback f773j = new ViewDragHelper.Callback() {

        /* renamed from: b */
        private int f775b;

        /* renamed from: c */
        private int f776c = -1;

        public boolean tryCaptureView(View view, int i) {
            return this.f776c == -1 && SwipeDismissBehavior.this.mo1058a(view);
        }

        public void onViewCaptured(View view, int i) {
            this.f776c = i;
            this.f775b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public void onViewDragStateChanged(int i) {
            if (SwipeDismissBehavior.this.f766c != null) {
                SwipeDismissBehavior.this.f766c.mo1037a(i);
            }
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            this.f776c = -1;
            int width = view.getWidth();
            boolean z = false;
            if (m1302a(view, f)) {
                i = view.getLeft() < this.f775b ? this.f775b - width : this.f775b + width;
                z = true;
            } else {
                i = this.f775b;
            }
            if (SwipeDismissBehavior.this.f765b.settleCapturedViewAt(i, view.getTop())) {
                ViewCompat.postOnAnimation(view, new C0236b(view, z));
            } else if (z && SwipeDismissBehavior.this.f766c != null) {
                SwipeDismissBehavior.this.f766c.mo1038a(view);
            }
        }

        /* renamed from: a */
        private boolean m1302a(View view, float f) {
            if (f != 0.0f) {
                boolean z = ViewCompat.getLayoutDirection(view) == 1;
                if (SwipeDismissBehavior.this.f767d == 2) {
                    return true;
                }
                if (SwipeDismissBehavior.this.f767d == 0) {
                    if (z) {
                        if (f >= 0.0f) {
                            return false;
                        }
                        return true;
                    } else if (f <= 0.0f) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (SwipeDismissBehavior.this.f767d != 1) {
                    return false;
                } else {
                    if (z) {
                        if (f <= 0.0f) {
                            return false;
                        }
                        return true;
                    } else if (f >= 0.0f) {
                        return false;
                    } else {
                        return true;
                    }
                }
            } else {
                if (Math.abs(view.getLeft() - this.f775b) < Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f768e)) {
                    return false;
                }
                return true;
            }
        }

        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            int width;
            int width2;
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            if (SwipeDismissBehavior.this.f767d == 0) {
                if (z) {
                    width = this.f775b - view.getWidth();
                    width2 = this.f775b;
                } else {
                    width = this.f775b;
                    width2 = this.f775b + view.getWidth();
                }
            } else if (SwipeDismissBehavior.this.f767d != 1) {
                width = this.f775b - view.getWidth();
                width2 = this.f775b + view.getWidth();
            } else if (z) {
                width = this.f775b;
                width2 = this.f775b + view.getWidth();
            } else {
                width = this.f775b - view.getWidth();
                width2 = this.f775b;
            }
            return SwipeDismissBehavior.m1292a(width, i, width2);
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            float width = ((float) this.f775b) + (((float) view.getWidth()) * SwipeDismissBehavior.this.f769f);
            float width2 = ((float) this.f775b) + (((float) view.getWidth()) * SwipeDismissBehavior.this.f770g);
            if (((float) i) <= width) {
                ViewCompat.setAlpha(view, 1.0f);
            } else if (((float) i) >= width2) {
                ViewCompat.setAlpha(view, 0.0f);
            } else {
                ViewCompat.setAlpha(view, SwipeDismissBehavior.m1291a(0.0f, 1.0f - SwipeDismissBehavior.m1294b(width, width2, (float) i), 1.0f));
            }
        }
    };

    /* renamed from: android.support.design.widget.SwipeDismissBehavior$a */
    public interface C0235a {
        /* renamed from: a */
        void mo1037a(int i);

        /* renamed from: a */
        void mo1038a(View view);
    }

    /* renamed from: a */
    public void mo1063a(C0235a aVar) {
        this.f766c = aVar;
    }

    /* renamed from: a */
    public void mo1062a(int i) {
        this.f767d = i;
    }

    /* renamed from: a */
    public void mo1061a(float f) {
        this.f769f = m1291a(0.0f, f, 1.0f);
    }

    /* renamed from: b */
    public void mo1064b(float f) {
        this.f770g = m1291a(0.0f, f, 1.0f);
    }

    /* renamed from: a */
    public boolean mo777a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f764a;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.f764a = coordinatorLayout.mo872a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
                z = this.f764a;
                break;
            case 1:
            case 3:
                this.f764a = false;
                break;
        }
        if (!z) {
            return false;
        }
        m1293a((ViewGroup) coordinatorLayout);
        return this.f765b.shouldInterceptTouchEvent(motionEvent);
    }

    /* renamed from: b */
    public boolean mo782b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f765b == null) {
            return false;
        }
        this.f765b.processTouchEvent(motionEvent);
        return true;
    }

    /* renamed from: a */
    public boolean mo1058a(View view) {
        return true;
    }

    /* renamed from: a */
    private void m1293a(ViewGroup viewGroup) {
        ViewDragHelper create;
        if (this.f765b == null) {
            if (this.f772i) {
                create = ViewDragHelper.create(viewGroup, this.f771h, this.f773j);
            } else {
                create = ViewDragHelper.create(viewGroup, this.f773j);
            }
            this.f765b = create;
        }
    }

    /* renamed from: android.support.design.widget.SwipeDismissBehavior$b */
    private class C0236b implements Runnable {

        /* renamed from: b */
        private final View f778b;

        /* renamed from: c */
        private final boolean f779c;

        C0236b(View view, boolean z) {
            this.f778b = view;
            this.f779c = z;
        }

        public void run() {
            if (SwipeDismissBehavior.this.f765b != null && SwipeDismissBehavior.this.f765b.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.f778b, this);
            } else if (this.f779c && SwipeDismissBehavior.this.f766c != null) {
                SwipeDismissBehavior.this.f766c.mo1038a(this.f778b);
            }
        }
    }

    /* renamed from: a */
    static float m1291a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    /* renamed from: a */
    static int m1292a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    /* renamed from: b */
    static float m1294b(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }
}
