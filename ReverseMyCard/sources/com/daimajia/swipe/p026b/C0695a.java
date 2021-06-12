package com.daimajia.swipe.p026b;

import android.support.p019v7.widget.RecyclerView;
import android.widget.BaseAdapter;
import com.daimajia.swipe.C0693a;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.p027c.C0700a;
import com.daimajia.swipe.p027c.C0701b;
import com.daimajia.swipe.p028d.C0702a;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.daimajia.swipe.b.a */
/* compiled from: SwipeItemMangerImpl */
public abstract class C0695a implements C0701b {

    /* renamed from: a */
    public final int f1368a = -1;

    /* renamed from: b */
    protected int f1369b = -1;

    /* renamed from: c */
    protected Set<Integer> f1370c = new HashSet();

    /* renamed from: d */
    protected Set<SwipeLayout> f1371d = new HashSet();

    /* renamed from: e */
    protected BaseAdapter f1372e;

    /* renamed from: f */
    protected RecyclerView.Adapter f1373f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0702a.C0703a f1374g = C0702a.C0703a.Single;

    public C0695a(RecyclerView.Adapter adapter) {
        if (adapter == null) {
            throw new IllegalArgumentException("Adapter can not be null");
        } else if (!(adapter instanceof C0701b)) {
            throw new IllegalArgumentException("adapter should implement the SwipeAdapterInterface");
        } else {
            this.f1373f = adapter;
        }
    }

    /* renamed from: a */
    public int mo8162a(int i) {
        if (this.f1372e != null) {
            return ((C0700a) this.f1372e).mo8170a(i);
        }
        if (this.f1373f != null) {
            return ((C0700a) this.f1373f).mo8170a(i);
        }
        return -1;
    }

    /* renamed from: a */
    public void mo8164a(SwipeLayout swipeLayout) {
        for (SwipeLayout next : this.f1371d) {
            if (next != swipeLayout) {
                next.mo8128i();
            }
        }
    }

    /* renamed from: a */
    public void mo8163a() {
        if (this.f1374g == C0702a.C0703a.Multiple) {
            this.f1370c.clear();
        } else {
            this.f1369b = -1;
        }
        for (SwipeLayout i : this.f1371d) {
            i.mo8128i();
        }
    }

    /* renamed from: b */
    public void mo8165b(SwipeLayout swipeLayout) {
        this.f1371d.remove(swipeLayout);
    }

    /* renamed from: b */
    public boolean mo8166b(int i) {
        if (this.f1374g == C0702a.C0703a.Multiple) {
            return this.f1370c.contains(Integer.valueOf(i));
        }
        return this.f1369b == i;
    }

    /* renamed from: com.daimajia.swipe.b.a$c */
    /* compiled from: SwipeItemMangerImpl */
    class C0698c {

        /* renamed from: a */
        C0696a f1379a;

        /* renamed from: b */
        C0697b f1380b;

        /* renamed from: c */
        int f1381c;

        C0698c(int i, C0697b bVar, C0696a aVar) {
            this.f1380b = bVar;
            this.f1379a = aVar;
            this.f1381c = i;
        }
    }

    /* renamed from: com.daimajia.swipe.b.a$a */
    /* compiled from: SwipeItemMangerImpl */
    class C0696a implements SwipeLayout.C0686c {

        /* renamed from: b */
        private int f1376b;

        C0696a(int i) {
            this.f1376b = i;
        }

        /* renamed from: a */
        public void mo8167a(int i) {
            this.f1376b = i;
        }

        /* renamed from: a */
        public void mo8151a(SwipeLayout swipeLayout) {
            if (C0695a.this.mo8166b(this.f1376b)) {
                swipeLayout.mo8105a(false, false);
            } else {
                swipeLayout.mo8110b(false, false);
            }
        }
    }

    /* renamed from: com.daimajia.swipe.b.a$b */
    /* compiled from: SwipeItemMangerImpl */
    class C0697b extends C0693a {

        /* renamed from: b */
        private int f1378b;

        C0697b(int i) {
            this.f1378b = i;
        }

        /* renamed from: d */
        public void mo8161d(SwipeLayout swipeLayout) {
            if (C0695a.this.f1374g == C0702a.C0703a.Multiple) {
                C0695a.this.f1370c.remove(Integer.valueOf(this.f1378b));
            } else {
                C0695a.this.f1369b = -1;
            }
        }

        /* renamed from: a */
        public void mo8156a(SwipeLayout swipeLayout) {
            if (C0695a.this.f1374g == C0702a.C0703a.Single) {
                C0695a.this.mo8164a(swipeLayout);
            }
        }

        /* renamed from: b */
        public void mo8159b(SwipeLayout swipeLayout) {
            if (C0695a.this.f1374g == C0702a.C0703a.Multiple) {
                C0695a.this.f1370c.add(Integer.valueOf(this.f1378b));
                return;
            }
            C0695a.this.mo8164a(swipeLayout);
            C0695a.this.f1369b = this.f1378b;
        }

        /* renamed from: a */
        public void mo8168a(int i) {
            this.f1378b = i;
        }
    }
}
