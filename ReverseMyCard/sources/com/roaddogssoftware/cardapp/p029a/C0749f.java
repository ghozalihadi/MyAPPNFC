package com.roaddogssoftware.cardapp.p029a;

import android.os.Bundle;
import android.support.p016v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.roaddogssoftware.cardapp.C0795g;
import com.roaddogssoftware.cardapp.MainActivity;
import com.roaddogssoftware.cardapp.R;

/* renamed from: com.roaddogssoftware.cardapp.a.f */
/* compiled from: FragmentSelectPicture */
public class C0749f extends Fragment {

    /* renamed from: a */
    View f1646a;

    /* renamed from: b */
    private GridView f1647b;

    /* renamed from: c */
    private C0795g f1648c;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1646a = layoutInflater.inflate(R.layout.fragment_select_picture, viewGroup, false);
        this.f1647b = (GridView) this.f1646a.findViewById(R.id.listViewSelectPicture);
        this.f1648c = new C0795g(getActivity());
        this.f1647b.setAdapter(this.f1648c);
        return this.f1646a;
    }

    public void onResume() {
        super.onResume();
        MainActivity.m2116a("FRAG_SELECT_PICTURE");
    }
}
