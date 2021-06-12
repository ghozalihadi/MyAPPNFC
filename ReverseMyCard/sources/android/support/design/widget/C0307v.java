package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.design.widget.v */
/* compiled from: ViewGroupUtils */
class C0307v {

    /* renamed from: a */
    private static final C0308a f1080a;

    /* renamed from: android.support.design.widget.v$a */
    /* compiled from: ViewGroupUtils */
    private interface C0308a {
        /* renamed from: a */
        void mo1359a(ViewGroup viewGroup, View view, Rect rect);
    }

    /* renamed from: android.support.design.widget.v$b */
    /* compiled from: ViewGroupUtils */
    private static class C0309b implements C0308a {
        C0309b() {
        }

        /* renamed from: a */
        public void mo1359a(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(view.getScrollX(), view.getScrollY());
        }
    }

    /* renamed from: android.support.design.widget.v$c */
    /* compiled from: ViewGroupUtils */
    private static class C0310c implements C0308a {
        C0310c() {
        }

        /* renamed from: a */
        public void mo1359a(ViewGroup viewGroup, View view, Rect rect) {
            C0311w.m1681a(viewGroup, view, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f1080a = new C0310c();
        } else {
            f1080a = new C0309b();
        }
    }

    /* renamed from: a */
    static void m1676a(ViewGroup viewGroup, View view, Rect rect) {
        f1080a.mo1359a(viewGroup, view, rect);
    }

    /* renamed from: b */
    static void m1677b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m1676a(viewGroup, view, rect);
    }
}
