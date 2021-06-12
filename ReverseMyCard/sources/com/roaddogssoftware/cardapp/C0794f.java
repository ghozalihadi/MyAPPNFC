package com.roaddogssoftware.cardapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p016v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: com.roaddogssoftware.cardapp.f */
/* compiled from: ScreenSlidePageFragment */
public class C0794f extends Fragment {

    /* renamed from: a */
    ImageView f1791a;

    /* renamed from: b */
    private int f1792b = -1;

    /* renamed from: a */
    public static C0794f m2362a(int i) {
        C0794f fVar = new C0794f();
        Bundle bundle = new Bundle();
        bundle.putInt("listPosition", i);
        fVar.setArguments(bundle);
        return fVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1792b = getArguments().getInt("listPosition", 0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_screen_slide_page, viewGroup, false);
        if (this.f1792b >= 0 && this.f1792b < MainActivity.f1388B.size()) {
            TextView textView = (TextView) viewGroup2.findViewById(R.id.textCardName);
            TextView textView2 = (TextView) viewGroup2.findViewById(R.id.textCardNumber);
            TextView textView3 = (TextView) viewGroup2.findViewById(R.id.textCardExp);
            String l = C0797h.m2376l(MainActivity.f1388B.get(this.f1792b).f1500H);
            Typeface createFromAsset = Typeface.createFromAsset(getActivity().getAssets(), "fonts/OCRAStd.otf");
            textView.setTypeface(createFromAsset);
            textView.setTextColor(Color.parseColor(l));
            textView.setText(MainActivity.f1388B.get(this.f1792b).f1509i);
            textView2.setTypeface(createFromAsset);
            textView2.setTextColor(Color.parseColor(l));
            textView3.setTypeface(createFromAsset);
            textView3.setTextColor(Color.parseColor(l));
            textView3.setText(MainActivity.f1388B.get(this.f1792b).f1520t);
            if (!MainActivity.f1423n) {
                textView2.setText(MainActivity.f1388B.get(this.f1792b).f1514n);
            } else {
                textView2.setText(MainActivity.f1388B.get(this.f1792b).f1511k);
            }
            if (!(this.f1791a == null || this.f1791a.getDrawable() == null)) {
                ((BitmapDrawable) this.f1791a.getDrawable()).getBitmap().recycle();
            }
            this.f1791a = (ImageView) viewGroup2.findViewById(R.id.imageViewCard);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            this.f1791a.setImageBitmap(BitmapFactory.decodeResource(viewGroup2.getResources(), MainActivity.f1388B.get(this.f1792b).f1498F, options));
        }
        return viewGroup2;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.f1791a != null) {
            this.f1791a.setImageDrawable((Drawable) null);
        }
    }
}
