package com.daimajia.swipe.p026b;

import android.support.p019v7.widget.RecyclerView;
import android.view.View;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.p026b.C0695a;

/* renamed from: com.daimajia.swipe.b.b */
/* compiled from: SwipeItemRecyclerMangerImpl */
public class C0699b extends C0695a {

    /* renamed from: g */
    protected RecyclerView.Adapter f1383g;

    public C0699b(RecyclerView.Adapter adapter) {
        super(adapter);
        this.f1383g = adapter;
    }

    /* renamed from: a */
    public void mo8169a(View view, int i) {
        int a = mo8162a(i);
        C0695a.C0696a aVar = new C0695a.C0696a(i);
        SwipeLayout swipeLayout = (SwipeLayout) view.findViewById(a);
        if (swipeLayout == null) {
            throw new IllegalStateException("can not find SwipeLayout in target view");
        } else if (swipeLayout.getTag(a) == null) {
            C0695a.C0697b bVar = new C0695a.C0697b(i);
            swipeLayout.mo8104a((SwipeLayout.C0692i) bVar);
            swipeLayout.mo8103a((SwipeLayout.C0686c) aVar);
            swipeLayout.setTag(a, new C0695a.C0698c(i, bVar, aVar));
            this.f1371d.add(swipeLayout);
        } else {
            C0695a.C0698c cVar = (C0695a.C0698c) swipeLayout.getTag(a);
            cVar.f1380b.mo8168a(i);
            cVar.f1379a.mo8167a(i);
            cVar.f1381c = i;
        }
    }
}
