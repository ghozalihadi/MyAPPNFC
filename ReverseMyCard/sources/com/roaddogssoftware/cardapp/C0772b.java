package com.roaddogssoftware.cardapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.p019v7.widget.CardView;
import android.support.p019v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.p025a.C0694a;

/* renamed from: com.roaddogssoftware.cardapp.b */
/* compiled from: CardListSwipeRecyclerViewAdapter */
public class C0772b extends C0694a<C0780a> {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f1694b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f1695c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f1696d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f1697e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f1698f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f1699g = false;

    public C0772b(Context context) {
        this.f1694b = context;
    }

    /* renamed from: a */
    public C0780a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0780a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_item_new_rows, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(final C0780a aVar, final int i) {
        C0724a aVar2 = MainActivity.f1388B.get(i);
        aVar.f1715a.setText(aVar2.f1508h);
        if (!MainActivity.f1423n) {
            aVar.f1716b.setText(aVar2.f1514n);
        } else {
            aVar.f1716b.setText(aVar2.f1511k);
        }
        aVar.f1717c.setText("EXP: " + aVar2.f1520t);
        if (!aVar2.f1521u) {
            aVar.f1717c.setBackgroundColor(Color.parseColor("#00000000"));
        }
        if (aVar2.f1512l.equals("")) {
            aVar.f1718d.setText("");
        } else if (!MainActivity.f1423n) {
            aVar.f1718d.setText("CVV: ***");
        } else {
            aVar.f1718d.setText("CVV: " + MainActivity.f1388B.get(i).f1512l);
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            aVar.f1719e.setImageBitmap(BitmapFactory.decodeResource(this.f1694b.getResources(), aVar2.f1499G, options));
        } catch (Exception e) {
        }
        TypedValue typedValue = new TypedValue();
        this.f1694b.getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true);
        int i2 = typedValue.data;
        if (MainActivity.f1389C.contains(Integer.valueOf(i))) {
            aVar.f1722h.setCardBackgroundColor(i2);
        } else {
            aVar.f1722h.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        if (aVar2.f1505e) {
            aVar.f1720f.setVisibility(0);
        } else {
            aVar.f1720f.setVisibility(4);
        }
        aVar.f1724j.setShowMode(SwipeLayout.C0688e.PullOut);
        aVar.f1724j.mo8101a(SwipeLayout.C0685b.Left, aVar.f1724j.findViewById(R.id.bottom_wrapper_left));
        aVar.f1724j.mo8101a(SwipeLayout.C0685b.Right, aVar.f1724j.findViewById(R.id.bottom_wrapper_right));
        aVar.f1724j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (C0772b.this.f1695c != 0) {
                    return;
                }
                if (C0772b.this.f1699g) {
                    boolean unused = C0772b.this.f1699g = false;
                } else {
                    ((MainActivity) C0772b.this.f1694b).mo8173a(i);
                }
            }
        });
        aVar.f1724j.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (C0772b.this.f1695c == 0) {
                    return ((MainActivity) C0772b.this.f1694b).mo8176b(i);
                }
                return false;
            }
        });
        aVar.f1724j.mo8104a((SwipeLayout.C0692i) new SwipeLayout.C0692i() {
            /* renamed from: a */
            public void mo8158a(SwipeLayout swipeLayout, int i, int i2) {
            }

            /* renamed from: a */
            public void mo8156a(SwipeLayout swipeLayout) {
                boolean unused = C0772b.this.f1696d = true;
                boolean unused2 = C0772b.this.f1697e = false;
                int unused3 = C0772b.this.f1695c = 1;
            }

            /* renamed from: b */
            public void mo8159b(SwipeLayout swipeLayout) {
                boolean unused = C0772b.this.f1698f = true;
                if (!C0772b.this.f1696d) {
                    int unused2 = C0772b.this.f1695c = 2;
                }
            }

            /* renamed from: c */
            public void mo8160c(SwipeLayout swipeLayout) {
                boolean unused = C0772b.this.f1696d = true;
                boolean unused2 = C0772b.this.f1698f = false;
                int unused3 = C0772b.this.f1695c = 3;
            }

            /* renamed from: d */
            public void mo8161d(SwipeLayout swipeLayout) {
                boolean unused = C0772b.this.f1697e = true;
                if (!C0772b.this.f1696d) {
                    int unused2 = C0772b.this.f1695c = 0;
                }
            }

            /* renamed from: a */
            public void mo8157a(SwipeLayout swipeLayout, float f, float f2) {
                if (C0772b.this.f1695c != 0) {
                    boolean unused = C0772b.this.f1696d = false;
                    if (C0772b.this.f1698f) {
                        int unused2 = C0772b.this.f1695c = 2;
                    } else if (C0772b.this.f1697e) {
                        int unused3 = C0772b.this.f1695c = 0;
                        boolean unused4 = C0772b.this.f1699g = true;
                    }
                }
            }
        });
        aVar.f1726l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0772b.this.m2305c(i);
                int unused = C0772b.this.f1695c = 0;
            }
        });
        aVar.f1728n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0772b.this.m2305c(i);
                int unused = C0772b.this.f1695c = 0;
            }
        });
        aVar.f1725k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0772b.this.f1367a.mo8165b(aVar.f1724j);
                C0772b.this.m2300b(i);
                int unused = C0772b.this.f1695c = 0;
            }
        });
        aVar.f1727m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0772b.this.f1367a.mo8165b(aVar.f1724j);
                C0772b.this.m2300b(i);
                int unused = C0772b.this.f1695c = 0;
            }
        });
        this.f1367a.mo8169a(aVar.itemView, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2300b(int i) {
        MainActivity.m2126f(i);
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, MainActivity.f1388B.size());
        this.f1367a.mo8163a();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2305c(int i) {
        MainActivity.m2110a(i, false);
    }

    public int getItemCount() {
        return MainActivity.f1388B.size();
    }

    /* renamed from: a */
    public int mo8170a(int i) {
        return R.id.swipeLayout;
    }

    /* renamed from: com.roaddogssoftware.cardapp.b$a */
    /* compiled from: CardListSwipeRecyclerViewAdapter */
    public static class C0780a extends RecyclerView.ViewHolder {

        /* renamed from: a */
        TextView f1715a;

        /* renamed from: b */
        TextView f1716b;

        /* renamed from: c */
        TextView f1717c;

        /* renamed from: d */
        TextView f1718d;

        /* renamed from: e */
        ImageView f1719e;

        /* renamed from: f */
        ImageView f1720f;

        /* renamed from: g */
        ImageButton f1721g;

        /* renamed from: h */
        CardView f1722h;

        /* renamed from: i */
        LinearLayout f1723i;

        /* renamed from: j */
        SwipeLayout f1724j;

        /* renamed from: k */
        TextView f1725k;

        /* renamed from: l */
        TextView f1726l;

        /* renamed from: m */
        TextView f1727m;

        /* renamed from: n */
        TextView f1728n;

        public C0780a(View view) {
            super(view);
            this.f1715a = (TextView) view.findViewById(R.id.list_item_nickname);
            this.f1716b = (TextView) view.findViewById(R.id.list_item_number);
            this.f1717c = (TextView) view.findViewById(R.id.list_item_exp);
            this.f1718d = (TextView) view.findViewById(R.id.list_item_cvv);
            this.f1719e = (ImageView) view.findViewById(R.id.imageViewCard);
            this.f1720f = (ImageView) view.findViewById(R.id.imageChecked);
            this.f1721g = (ImageButton) view.findViewById(R.id.delete_btn);
            this.f1722h = (CardView) view.findViewById(R.id.cardView);
            this.f1723i = (LinearLayout) view.findViewById(R.id.cardViewFrame);
            this.f1724j = (SwipeLayout) view.findViewById(R.id.swipeLayout);
            this.f1725k = (TextView) view.findViewById(R.id.tvDeleteRight);
            this.f1726l = (TextView) view.findViewById(R.id.tvEditRight);
            this.f1727m = (TextView) view.findViewById(R.id.tvDeleteLeft);
            this.f1728n = (TextView) view.findViewById(R.id.tvEditLeft);
        }
    }
}
