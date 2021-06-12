package com.roaddogssoftware.cardapp.p029a;

import android.os.Bundle;
import android.support.p016v4.app.Fragment;
import android.support.p019v7.widget.LinearLayoutManager;
import android.support.p019v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.roaddogssoftware.cardapp.C0772b;
import com.roaddogssoftware.cardapp.MainActivity;
import com.roaddogssoftware.cardapp.R;

/* renamed from: com.roaddogssoftware.cardapp.a.b */
/* compiled from: FragmentCardList */
public class C0732b extends Fragment {

    /* renamed from: a */
    public static RecyclerView f1567a;

    /* renamed from: b */
    public static RecyclerView.Adapter f1568b;

    /* renamed from: c */
    public static RecyclerView.LayoutManager f1569c;

    /* renamed from: d */
    public static boolean f1570d = false;

    /* renamed from: e */
    private static TextView f1571e;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_card_list, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        f1571e = (TextView) getView().findViewById(R.id.textView_no_cards);
        f1567a = (RecyclerView) getView().findViewById(R.id.recycler_view);
        f1569c = new LinearLayoutManager(getContext());
        f1567a.setLayoutManager(f1569c);
        f1568b = new C0772b(getContext());
        f1567a.setAdapter(f1568b);
    }

    public void onResume() {
        super.onResume();
        MainActivity.m2116a("FRAG_CARD_LIST");
        mo8244a();
        if (f1570d) {
            f1570d = false;
            f1567a.scrollToPosition(MainActivity.f1388B.size() - 1);
        }
    }

    public void onDetach() {
        super.onDetach();
    }

    /* renamed from: a */
    public void mo8244a() {
        if (f1568b != null && f1571e != null) {
            m2213b();
            f1568b.notifyDataSetChanged();
        }
    }

    /* renamed from: b */
    private void m2213b() {
        if (MainActivity.f1388B.size() == 0) {
            f1571e.setVisibility(0);
        } else {
            f1571e.setVisibility(8);
        }
    }
}
