package com.roaddogssoftware.cardapp.p029a;

import android.graphics.Color;
import android.os.Bundle;
import android.support.p016v4.app.Fragment;
import android.support.p016v4.app.FragmentManager;
import android.support.p016v4.app.FragmentPagerAdapter;
import android.support.p016v4.content.ContextCompat;
import android.support.p016v4.view.PagerAdapter;
import android.support.p016v4.view.ViewPager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.roaddogssoftware.cardapp.C0792d;
import com.roaddogssoftware.cardapp.C0794f;
import com.roaddogssoftware.cardapp.MainActivity;
import com.roaddogssoftware.cardapp.R;

/* renamed from: com.roaddogssoftware.cardapp.a.e */
/* compiled from: FragmentHome */
public class C0742e extends Fragment {

    /* renamed from: a */
    public static ViewPager f1620a;

    /* renamed from: c */
    public static ImageView f1621c;

    /* renamed from: b */
    public PagerAdapter f1622b;

    /* renamed from: d */
    private View f1623d;

    /* renamed from: e */
    private TextView f1624e;

    /* renamed from: f */
    private TextView f1625f;

    /* renamed from: g */
    private TextView f1626g;

    /* renamed from: h */
    private TextView f1627h;

    /* renamed from: i */
    private TextView f1628i;

    /* renamed from: j */
    private TextView f1629j;

    /* renamed from: k */
    private TextView f1630k;

    /* renamed from: l */
    private TextView f1631l;

    /* renamed from: m */
    private ImageView f1632m;

    /* renamed from: n */
    private ImageView f1633n;

    /* renamed from: o */
    private FrameLayout f1634o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f1635p = -1;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f1636q = false;

    /* renamed from: r */
    private LinearLayout f1637r;

    /* renamed from: s */
    private int f1638s;

    /* renamed from: t */
    private ImageView[] f1639t;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f1623d = getView();
        this.f1624e = (TextView) this.f1623d.findViewById(R.id.current_cardname);
        this.f1625f = (TextView) this.f1623d.findViewById(R.id.name_on_card);
        this.f1626g = (TextView) this.f1623d.findViewById(R.id.card_number);
        this.f1627h = (TextView) this.f1623d.findViewById(R.id.card_expiration);
        this.f1628i = (TextView) this.f1623d.findViewById(R.id.card_cvv);
        this.f1629j = (TextView) this.f1623d.findViewById(R.id.card_brand);
        this.f1630k = (TextView) this.f1623d.findViewById(R.id.card_added);
        this.f1631l = (TextView) this.f1623d.findViewById(R.id.card_Last_used);
        this.f1632m = (ImageView) this.f1623d.findViewById(R.id.left_nav);
        this.f1633n = (ImageView) this.f1623d.findViewById(R.id.right_nav);
        this.f1637r = (LinearLayout) this.f1623d.findViewById(R.id.viewPagerCountDots);
        f1620a = (ViewPager) this.f1623d.findViewById(R.id.pager);
        f1620a.setPageTransformer(true, new C0792d());
        this.f1634o = (FrameLayout) this.f1623d.findViewById(R.id.buttonContext);
        registerForContextMenu(this.f1634o);
        this.f1634o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0742e.this.getActivity().openContextMenu(view);
            }
        });
        f1621c = (ImageView) this.f1623d.findViewById(R.id.button_edit);
        f1621c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MainActivity.f1435z > -1 && MainActivity.f1388B.size() > 0) {
                    MainActivity mainActivity = (MainActivity) MainActivity.f1414e;
                    MainActivity.m2110a(MainActivity.f1435z, true);
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.height = MainActivity.f1393G;
        f1620a.setLayoutParams(layoutParams);
        mo8258a();
        this.f1632m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0742e.this.m2254f();
            }
        });
        this.f1633n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0742e.this.m2255g();
            }
        });
    }

    public void onResume() {
        super.onResume();
        MainActivity.m2116a("FRAG_HOME");
        mo8259b();
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        getActivity().getMenuInflater().inflate(R.menu.home_context_menu, contextMenu);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.context_edit:
                if (MainActivity.f1435z > -1 && MainActivity.f1388B.size() > 0) {
                    MainActivity mainActivity = (MainActivity) MainActivity.f1414e;
                    MainActivity.m2110a(MainActivity.f1435z, true);
                }
                return true;
            case R.id.context_delete:
                if (MainActivity.f1435z > -1 && MainActivity.f1388B.size() > 0) {
                    ((MainActivity) MainActivity.f1414e).mo8179d(MainActivity.f1435z);
                }
                return true;
            default:
                return super.onContextItemSelected(menuItem);
        }
    }

    /* renamed from: a */
    public void mo8258a() {
        this.f1622b = new C0748a(getChildFragmentManager());
        f1620a.setAdapter(this.f1622b);
        f1620a.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (C0742e.this.f1636q) {
                    MainActivity.m2121c(i);
                    C0742e.this.mo8259b();
                }
            }

            public void onPageScrollStateChanged(int i) {
                if (C0742e.this.f1635p == 1 && i == 2) {
                    boolean unused = C0742e.this.f1636q = true;
                } else if (C0742e.this.f1635p == 2 && i == 0) {
                    boolean unused2 = C0742e.this.f1636q = false;
                }
                int unused3 = C0742e.this.f1635p = i;
            }
        });
        m2253e();
    }

    /* renamed from: com.roaddogssoftware.cardapp.a.e$a */
    /* compiled from: FragmentHome */
    private class C0748a extends FragmentPagerAdapter {
        public C0748a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            return C0794f.m2362a(i);
        }

        public int getCount() {
            return MainActivity.f1388B.size();
        }

        public CharSequence getPageTitle(int i) {
            return MainActivity.f1388B.get(i).f1508h;
        }
    }

    /* renamed from: e */
    private void m2253e() {
        this.f1638s = this.f1622b.getCount();
        this.f1639t = new ImageView[this.f1638s];
        for (int i = 0; i < this.f1638s; i++) {
            this.f1639t[i] = new ImageView(getContext());
            this.f1639t[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.nonselecteditem_dot));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(4, 0, 4, 0);
            this.f1637r.addView(this.f1639t[i], layoutParams);
        }
        if (this.f1639t.length > 0) {
            this.f1639t[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.selecteditem_dot));
        }
    }

    /* renamed from: b */
    public void mo8259b() {
        try {
            if (MainActivity.f1388B.size() > 0) {
                if (MainActivity.f1387A.f1501a) {
                    this.f1624e.setText(MainActivity.f1387A.f1508h);
                    this.f1625f.setText(MainActivity.f1387A.f1509i);
                    this.f1627h.setText(MainActivity.f1387A.f1519s);
                    this.f1630k.setText(MainActivity.f1387A.f1522v);
                    this.f1631l.setText(MainActivity.f1387A.f1523w);
                    if (!MainActivity.f1387A.f1521u) {
                        this.f1627h.setBackgroundColor(Color.parseColor("#00000000"));
                    }
                    this.f1629j.setText(MainActivity.f1387A.f1515o);
                    if (!MainActivity.f1423n) {
                        this.f1626g.setText(MainActivity.f1387A.f1514n);
                        this.f1628i.setText("***");
                    } else {
                        this.f1626g.setText(MainActivity.f1387A.f1511k);
                        this.f1628i.setText(MainActivity.f1387A.f1512l);
                    }
                } else {
                    this.f1625f.setText(R.string.warning_invalid_card);
                    this.f1626g.setText("");
                    this.f1627h.setText("");
                }
                f1620a.setCurrentItem(MainActivity.f1435z);
                for (int i = 0; i < this.f1638s; i++) {
                    this.f1639t[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.nonselecteditem_dot));
                }
                this.f1639t[MainActivity.f1435z].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.selecteditem_dot));
                return;
            }
            this.f1624e.setText(R.string.list_empty);
            this.f1625f.setText("");
            this.f1626g.setText("");
            this.f1627h.setText("");
            this.f1628i.setText("");
            this.f1630k.setText("");
            this.f1631l.setText("");
            this.f1629j.setText("");
            this.f1627h.setBackgroundColor(Color.parseColor("#00000000"));
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m2254f() {
        if (MainActivity.f1435z > 0) {
            f1620a.setCurrentItem(MainActivity.f1435z - 1, true);
            MainActivity.m2121c(MainActivity.f1435z - 1);
            mo8259b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m2255g() {
        if (MainActivity.f1435z < MainActivity.f1388B.size() - 1) {
            f1620a.setCurrentItem(MainActivity.f1435z + 1, true);
            MainActivity.m2121c(MainActivity.f1435z + 1);
            mo8259b();
        }
    }

    /* renamed from: c */
    public void mo8260c() {
        if (this.f1634o != null) {
            this.f1634o.setVisibility(4);
        }
    }

    /* renamed from: d */
    public void mo8261d() {
        if (this.f1634o != null) {
            this.f1634o.setVisibility(0);
        }
    }
}
