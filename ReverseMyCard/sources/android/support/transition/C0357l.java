package android.support.transition;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.transition.l */
/* compiled from: ScenePort */
final class C0357l {

    /* renamed from: a */
    Runnable f1157a;

    /* renamed from: b */
    private ViewGroup f1158b;

    /* renamed from: a */
    static void m1811a(View view, C0357l lVar) {
        view.setTag(R.id.transition_current_scene, lVar);
    }

    /* renamed from: a */
    static C0357l m1810a(View view) {
        return (C0357l) view.getTag(R.id.transition_current_scene);
    }

    /* renamed from: a */
    public void mo1439a() {
        if (m1810a(this.f1158b) == this && this.f1157a != null) {
            this.f1157a.run();
        }
    }
}
