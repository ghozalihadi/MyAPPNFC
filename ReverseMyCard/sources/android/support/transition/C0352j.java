package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.p016v4.view.ViewCompat;
import android.support.transition.C0373y;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.transition.j */
/* compiled from: FadePort */
class C0352j extends C0337an {

    /* renamed from: a */
    private static boolean f1136a = false;

    /* renamed from: b */
    private int f1137b;

    public C0352j() {
        this(3);
    }

    public C0352j(int i) {
        this.f1137b = i;
    }

    /* renamed from: a */
    private Animator m1801a(View view, float f, float f2, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator objectAnimator = null;
        if (f != f2) {
            objectAnimator = ObjectAnimator.ofFloat(view, "alpha", new float[]{f, f2});
            if (f1136a) {
                Log.d("Fade", "Created animator " + objectAnimator);
            }
            if (animatorListenerAdapter != null) {
                objectAnimator.addListener(animatorListenerAdapter);
            }
        } else if (animatorListenerAdapter != null) {
            animatorListenerAdapter.onAnimationEnd((Animator) null);
        }
        return objectAnimator;
    }

    /* renamed from: d */
    private void m1802d(C0325ae aeVar) {
        int[] iArr = new int[2];
        aeVar.f1102b.getLocationOnScreen(iArr);
        aeVar.f1101a.put("android:fade:screenX", Integer.valueOf(iArr[0]));
        aeVar.f1101a.put("android:fade:screenY", Integer.valueOf(iArr[1]));
    }

    /* renamed from: a */
    public void mo1377a(C0325ae aeVar) {
        super.mo1377a(aeVar);
        m1802d(aeVar);
    }

    /* renamed from: a */
    public Animator mo1418a(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
        if ((this.f1137b & 1) != 1 || aeVar2 == null) {
            return null;
        }
        final View view = aeVar2.f1102b;
        if (f1136a) {
            Log.d("Fade", "Fade.onAppear: startView, startVis, endView, endVis = " + (aeVar != null ? aeVar.f1102b : null) + ", " + i + ", " + view + ", " + i2);
        }
        view.setAlpha(0.0f);
        mo1375a((C0373y.C0377b) new C0373y.C0378c() {

            /* renamed from: a */
            boolean f1138a = false;

            /* renamed from: b */
            float f1139b;

            /* renamed from: a */
            public void mo1391a(C0373y yVar) {
                if (!this.f1138a) {
                    view.setAlpha(1.0f);
                }
            }

            /* renamed from: b */
            public void mo1430b(C0373y yVar) {
                this.f1139b = view.getAlpha();
                view.setAlpha(1.0f);
            }

            /* renamed from: c */
            public void mo1431c(C0373y yVar) {
                view.setAlpha(this.f1139b);
            }
        });
        return m1801a(view, 0.0f, 1.0f, (AnimatorListenerAdapter) null);
    }

    /* renamed from: b */
    public Animator mo1420b(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
        View view;
        final View view2;
        final View view3;
        View view4;
        if ((this.f1137b & 2) != 2) {
            return null;
        }
        final View view5 = aeVar != null ? aeVar.f1102b : null;
        if (aeVar2 != null) {
            view = aeVar2.f1102b;
        } else {
            view = null;
        }
        if (f1136a) {
            Log.d("Fade", "Fade.onDisappear: startView, startVis, endView, endVis = " + view5 + ", " + i + ", " + view + ", " + i2);
        }
        if (view == null || view.getParent() == null) {
            if (view != null) {
                view3 = null;
                view2 = view;
                view5 = view;
            } else {
                if (view5 != null) {
                    if (view5.getParent() == null) {
                        view3 = null;
                        view2 = view5;
                    } else if ((view5.getParent() instanceof View) && view5.getParent().getParent() == null) {
                        int id = ((View) view5.getParent()).getId();
                        if (id == -1 || viewGroup.findViewById(id) == null || !this.f1192q) {
                            view4 = null;
                            view5 = null;
                        } else {
                            view4 = view5;
                        }
                        view3 = null;
                        view2 = view4;
                    }
                }
                view3 = null;
                view2 = null;
                view5 = null;
            }
        } else if (i2 == 4) {
            view3 = view;
            view2 = null;
            view5 = view;
        } else if (view5 == view) {
            view3 = view;
            view2 = null;
            view5 = view;
        } else {
            view3 = null;
            view2 = view5;
        }
        if (view2 != null) {
            int intValue = ((Integer) aeVar.f1101a.get("android:fade:screenX")).intValue();
            int intValue2 = ((Integer) aeVar.f1101a.get("android:fade:screenY")).intValue();
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            ViewCompat.offsetLeftAndRight(view2, (intValue - iArr[0]) - view2.getLeft());
            ViewCompat.offsetTopAndBottom(view2, (intValue2 - iArr[1]) - view2.getTop());
            C0327ag.m1730a(viewGroup).mo1396a(view2);
            final int i3 = i2;
            final ViewGroup viewGroup2 = viewGroup;
            return m1801a(view5, 1.0f, 0.0f, new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    view5.setAlpha(1.0f);
                    if (view3 != null) {
                        view3.setVisibility(i3);
                    }
                    if (view2 != null) {
                        C0327ag.m1730a(viewGroup2).mo1397b(view2);
                    }
                }
            });
        } else if (view3 == null) {
            return null;
        } else {
            view3.setVisibility(0);
            final int i4 = i2;
            final ViewGroup viewGroup3 = viewGroup;
            return m1801a(view5, 1.0f, 0.0f, new AnimatorListenerAdapter() {

                /* renamed from: a */
                boolean f1148a = false;

                /* renamed from: b */
                float f1149b = -1.0f;

                public void onAnimationCancel(Animator animator) {
                    this.f1148a = true;
                    if (this.f1149b >= 0.0f) {
                        view5.setAlpha(this.f1149b);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (!this.f1148a) {
                        view5.setAlpha(1.0f);
                    }
                    if (view3 != null && !this.f1148a) {
                        view3.setVisibility(i4);
                    }
                    if (view2 != null) {
                        C0327ag.m1730a(viewGroup3).mo1396a(view2);
                    }
                }
            });
        }
    }
}
