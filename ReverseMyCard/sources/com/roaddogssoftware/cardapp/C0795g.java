package com.roaddogssoftware.cardapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/* renamed from: com.roaddogssoftware.cardapp.g */
/* compiled from: SelectPictureListViewAdapter */
public class C0795g extends BaseAdapter {

    /* renamed from: a */
    private Context f1793a;

    /* renamed from: b */
    private LayoutInflater f1794b = ((LayoutInflater) this.f1793a.getSystemService("layout_inflater"));

    public C0795g(Context context) {
        this.f1793a = context;
    }

    public int getCount() {
        try {
            return MainActivity.f1399M.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    /* renamed from: com.roaddogssoftware.cardapp.g$a */
    /* compiled from: SelectPictureListViewAdapter */
    static class C0796a {

        /* renamed from: a */
        ImageView f1795a;

        /* renamed from: b */
        ImageView f1796b;

        C0796a() {
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0796a aVar;
        if (view == null) {
            view = this.f1794b.inflate(R.layout.listview_item_new_small, (ViewGroup) null);
            C0796a aVar2 = new C0796a();
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (C0796a) view.getTag();
        }
        aVar.f1795a = (ImageView) view.findViewById(R.id.imageViewCard);
        aVar.f1796b = (ImageView) view.findViewById(R.id.imageEmpty);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        aVar.f1795a.setImageBitmap(BitmapFactory.decodeResource(view.getResources(), MainActivity.f1399M.get(i).intValue(), options));
        if (MainActivity.f1400N.get(i).toLowerCase().contains("empty")) {
            aVar.f1796b.setVisibility(0);
        } else {
            aVar.f1796b.setVisibility(4);
        }
        return view;
    }
}
