package com.roaddogssoftware.cardapp.SlidingTab;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.p016v4.content.ContextCompat;
import android.support.p016v4.view.PagerAdapter;
import android.support.p016v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.roaddogssoftware.cardapp.MainActivity;
import com.roaddogssoftware.cardapp.R;

public class SlidingTabLayout extends HorizontalScrollView {

    /* renamed from: a */
    private int f1471a;

    /* renamed from: b */
    private int f1472b;

    /* renamed from: c */
    private int f1473c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ViewPager f1474d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ViewPager.OnPageChangeListener f1475e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final SlidingTabStrip f1476f;

    /* renamed from: com.roaddogssoftware.cardapp.SlidingTab.SlidingTabLayout$c */
    public interface C0721c {
        /* renamed from: a */
        int mo8222a(int i);

        /* renamed from: b */
        int mo8223b(int i);
    }

    public SlidingTabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f1471a = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.f1476f = new SlidingTabStrip(context);
        addView(this.f1476f, -1, -2);
    }

    public void setCustomTabColorizer(C0721c cVar) {
        this.f1476f.setCustomTabColorizer(cVar);
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.f1476f.setSelectedIndicatorColors(iArr);
    }

    public void setDividerColors(int... iArr) {
        this.f1476f.setDividerColors(iArr);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f1475e = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.f1476f.removeAllViews();
        this.f1474d = viewPager;
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new C0719a());
            m2172a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public TextView mo8214a(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(2, 12.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        if (Build.VERSION.SDK_INT >= 11) {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(16843534, typedValue, true);
            textView.setBackgroundResource(typedValue.resourceId);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            textView.setAllCaps(true);
        }
        int i = (int) (16.0f * getResources().getDisplayMetrics().density);
        textView.setPadding(i, i, i, i);
        return textView;
    }

    /* renamed from: a */
    private void m2172a() {
        TextView textView;
        View view;
        PagerAdapter adapter = this.f1474d.getAdapter();
        C0720b bVar = new C0720b();
        for (int i = 0; i < adapter.getCount(); i++) {
            if (this.f1472b != 0) {
                view = LayoutInflater.from(getContext()).inflate(this.f1472b, this.f1476f, false);
                textView = (TextView) view.findViewById(this.f1473c);
            } else {
                textView = null;
                view = null;
            }
            if (view == null) {
                view = mo8214a(getContext());
            }
            if (textView == null && TextView.class.isInstance(view)) {
                textView = (TextView) view;
            }
            textView.setText(adapter.getPageTitle(i));
            textView.setTextSize(13.0f);
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.secondary_text));
            view.setOnClickListener(bVar);
            view.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            this.f1476f.addView(view);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1474d != null) {
            m2173a(this.f1474d.getCurrentItem(), 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2173a(int i, int i2) {
        View childAt;
        int childCount = this.f1476f.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount && (childAt = this.f1476f.getChildAt(i)) != null) {
            int left = childAt.getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.f1471a;
            }
            scrollTo(left, 0);
        }
    }

    /* renamed from: com.roaddogssoftware.cardapp.SlidingTab.SlidingTabLayout$a */
    private class C0719a implements ViewPager.OnPageChangeListener {

        /* renamed from: b */
        private int f1478b;

        private C0719a() {
        }

        public void onPageScrolled(int i, float f, int i2) {
            int childCount = SlidingTabLayout.this.f1476f.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.f1476f.mo8224a(i, f);
                View childAt = SlidingTabLayout.this.f1476f.getChildAt(i);
                SlidingTabLayout.this.m2173a(i, childAt != null ? (int) (((float) childAt.getWidth()) * f) : 0);
                if (SlidingTabLayout.this.f1475e != null) {
                    SlidingTabLayout.this.f1475e.onPageScrolled(i, f, i2);
                }
            }
        }

        public void onPageScrollStateChanged(int i) {
            this.f1478b = i;
            if (SlidingTabLayout.this.f1475e != null) {
                SlidingTabLayout.this.f1475e.onPageScrollStateChanged(i);
            }
        }

        public void onPageSelected(int i) {
            if (this.f1478b == 0) {
                SlidingTabLayout.this.f1476f.mo8224a(i, 0.0f);
                SlidingTabLayout.this.m2173a(i, 0);
            }
            if (SlidingTabLayout.this.f1475e != null) {
                SlidingTabLayout.this.f1475e.onPageSelected(i);
            }
        }
    }

    /* renamed from: com.roaddogssoftware.cardapp.SlidingTab.SlidingTabLayout$b */
    private class C0720b implements View.OnClickListener {
        private C0720b() {
        }

        public void onClick(View view) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= SlidingTabLayout.this.f1476f.getChildCount()) {
                    return;
                }
                if (view == SlidingTabLayout.this.f1476f.getChildAt(i2)) {
                    if (i2 == 0) {
                        ((MainActivity) MainActivity.f1414e).mo8172a();
                    } else if (i2 == 1) {
                        ((MainActivity) MainActivity.f1414e).mo8175b();
                    }
                    SlidingTabLayout.this.f1474d.setCurrentItem(i2);
                    return;
                }
                i = i2 + 1;
            }
        }
    }
}
