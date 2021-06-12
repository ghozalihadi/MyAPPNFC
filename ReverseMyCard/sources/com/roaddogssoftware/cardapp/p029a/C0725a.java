package com.roaddogssoftware.cardapp.p029a;

import android.app.AlertDialog;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.p016v4.app.ActivityCompat;
import android.support.p016v4.app.Fragment;
import android.support.p016v4.content.ContextCompat;
import android.support.p019v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.roaddogssoftware.cardapp.C0724a;
import com.roaddogssoftware.cardapp.C0797h;
import com.roaddogssoftware.cardapp.MainActivity;
import com.roaddogssoftware.cardapp.R;

/* renamed from: com.roaddogssoftware.cardapp.a.a */
/* compiled from: FragmentAddCard */
public class C0725a extends Fragment implements View.OnClickListener {

    /* renamed from: b */
    public static int f1527b;

    /* renamed from: d */
    public static boolean f1528d = false;

    /* renamed from: f */
    public static String f1529f = "";

    /* renamed from: A */
    private LinearLayout f1530A;

    /* renamed from: B */
    private LinearLayout f1531B;

    /* renamed from: C */
    private LinearLayout f1532C;

    /* renamed from: D */
    private LinearLayout f1533D;

    /* renamed from: E */
    private ClipboardManager f1534E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public AlertDialog f1535F;

    /* renamed from: a */
    public C0738d f1536a;

    /* renamed from: c */
    public boolean f1537c = false;

    /* renamed from: e */
    public C0724a f1538e;

    /* renamed from: g */
    private String f1539g = "";

    /* renamed from: h */
    private String f1540h = "";

    /* renamed from: i */
    private TextView f1541i;

    /* renamed from: j */
    private TextView f1542j;

    /* renamed from: k */
    private TextView f1543k;

    /* renamed from: l */
    private TextView f1544l;

    /* renamed from: m */
    private TextView f1545m;

    /* renamed from: n */
    private TextView f1546n;

    /* renamed from: o */
    private EditText f1547o;

    /* renamed from: p */
    private EditText f1548p;

    /* renamed from: q */
    private EditText f1549q;

    /* renamed from: r */
    private ImageView f1550r;

    /* renamed from: s */
    private Button f1551s;

    /* renamed from: t */
    private Button f1552t;

    /* renamed from: u */
    private Button f1553u;

    /* renamed from: v */
    private Button f1554v;

    /* renamed from: w */
    private Button f1555w;

    /* renamed from: x */
    private Button f1556x;

    /* renamed from: y */
    private FrameLayout f1557y;

    /* renamed from: z */
    private LinearLayout f1558z;

    /* renamed from: a */
    public static C0725a m2194a(int i, boolean z) {
        C0725a aVar = new C0725a();
        f1527b = i;
        f1528d = z;
        if (i == -1 && MainActivity.f1397K.size() > 0 && MainActivity.f1398L.size() > 0) {
            MainActivity.f1395I = MainActivity.f1397K.get(0).intValue();
            MainActivity.f1396J = MainActivity.f1398L.get(0);
        }
        return aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (f1527b != -1) {
            this.f1537c = true;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_add_card, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f1541i = (TextView) getView().findViewById(R.id.textCardName);
        this.f1542j = (TextView) getView().findViewById(R.id.textCardNumber);
        this.f1543k = (TextView) getView().findViewById(R.id.textCardExp);
        this.f1550r = (ImageView) getView().findViewById(R.id.imageViewCard);
        this.f1544l = (TextView) getView().findViewById(R.id.card_brand);
        this.f1547o = (EditText) getView().findViewById(R.id.swipe_name);
        this.f1548p = (EditText) getView().findViewById(R.id.swipe_cvv);
        this.f1549q = (EditText) getView().findViewById(R.id.edit_name_on_card);
        this.f1545m = (TextView) getView().findViewById(R.id.textViewTrackDataStatus);
        this.f1551s = (Button) getView().findViewById(R.id.button_add_pic);
        this.f1557y = (FrameLayout) getView().findViewById(R.id.layout_cover);
        this.f1530A = (LinearLayout) getView().findViewById(R.id.button_clear_layout);
        this.f1552t = (Button) getView().findViewById(R.id.button_clear_button);
        this.f1558z = (LinearLayout) getView().findViewById(R.id.button_edit_layout);
        this.f1553u = (Button) getView().findViewById(R.id.button_edit_button);
        this.f1531B = (LinearLayout) getView().findViewById(R.id.button_paste_layout);
        this.f1554v = (Button) getView().findViewById(R.id.button_paste_button);
        this.f1546n = (TextView) getView().findViewById(R.id.button_paste_text);
        this.f1532C = (LinearLayout) getView().findViewById(R.id.button_mag_card_layout);
        this.f1555w = (Button) getView().findViewById(R.id.button_mag_button);
        this.f1533D = (LinearLayout) getView().findViewById(R.id.button_scan_layout);
        this.f1556x = (Button) getView().findViewById(R.id.button_scan_button);
        this.f1541i.setOnClickListener(this);
        this.f1542j.setOnClickListener(this);
        this.f1543k.setOnClickListener(this);
        this.f1550r.setOnClickListener(this);
        this.f1551s.setOnClickListener(this);
        this.f1557y.setOnClickListener(this);
        this.f1530A.setOnClickListener(this);
        this.f1552t.setOnClickListener(this);
        this.f1558z.setOnClickListener(this);
        this.f1553u.setOnClickListener(this);
        this.f1531B.setOnClickListener(this);
        this.f1554v.setOnClickListener(this);
        this.f1532C.setOnClickListener(this);
        this.f1555w.setOnClickListener(this);
        this.f1533D.setOnClickListener(this);
        this.f1556x.setOnClickListener(this);
        this.f1541i.setText("");
        this.f1542j.setText("");
        this.f1543k.setText("");
        this.f1534E = (ClipboardManager) getActivity().getSystemService("clipboard");
        this.f1545m.setText(R.string.warning_track_data_empty);
        this.f1545m.setBackgroundResource(R.color.warning_yellow);
        this.f1536a = new C0738d();
        if (!this.f1537c || MainActivity.f1388B.size() <= f1527b) {
            this.f1537c = false;
            this.f1538e = null;
            checkCardData();
        } else {
            this.f1538e = MainActivity.f1388B.get(f1527b);
            f1529f = this.f1538e.f1507g;
            if (MainActivity.f1423n) {
                this.f1542j.setText(this.f1538e.f1511k);
                this.f1548p.setText(this.f1538e.f1512l);
            } else {
                this.f1542j.setText(this.f1538e.f1514n);
                this.f1548p.setText("***");
            }
            this.f1547o.setText(this.f1538e.f1508h);
            this.f1541i.setText(this.f1538e.f1509i);
            this.f1549q.setText(this.f1538e.f1509i);
            this.f1544l.setText(this.f1538e.f1515o + " / " + this.f1538e.f1519s);
            if (m2198b(this.f1538e.f1507g)) {
                this.f1545m.setText(R.string.warning_track_data_in_use);
                this.f1545m.setBackgroundResource(R.color.warning_yellow);
            } else {
                this.f1545m.setText(R.string.warning_track_data_ok);
                this.f1545m.setBackgroundResource(R.color.warning_green);
            }
        }
        mo8236d();
        this.f1549q.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (!z && C0725a.this.f1538e != null) {
                    C0725a.this.m2207l();
                }
            }
        });
        try {
            getActivity().getWindow().setSoftInputMode(2);
        } catch (Exception e) {
        }
    }

    public void onResume() {
        super.onResume();
        MainActivity.m2116a("FRAG_ADD_CARD");
        m2202g();
    }

    public void onPause() {
        super.onPause();
        m2206k();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageViewCard:
            case R.id.layout_cover:
            case R.id.button_add_pic:
            case R.id.textCardName:
            case R.id.textCardExp:
            case R.id.textCardNumber:
                ((MainActivity) MainActivity.f1414e).mo8180e();
                return;
            case R.id.button_clear_layout:
            case R.id.button_clear_button:
                m2200e();
                return;
            case R.id.button_edit_layout:
            case R.id.button_edit_button:
                m2201f();
                return;
            case R.id.button_paste_layout:
            case R.id.button_paste_button:
                m2203h();
                return;
            case R.id.button_mag_card_layout:
            case R.id.button_mag_button:
                mo8233b();
                return;
            case R.id.button_scan_layout:
            case R.id.button_scan_button:
                mo8231a();
                return;
            default:
                return;
        }
    }

    /* renamed from: e */
    private void m2200e() {
        f1529f = "";
        checkCardData();
    }

    /* renamed from: f */
    private void m2201f() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle((int) R.string.dialog_edit_title);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        final EditText editText = new EditText(getContext());
        if (MainActivity.f1423n || !this.f1537c) {
            editText.setText(f1529f);
        } else {
            editText.setText(getString(R.string.edit_data_hidden));
            editText.setEnabled(false);
        }
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView((View) linearLayout);
        editText.setInputType(1);
        editText.setImeOptions(6);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i & 255) != 6) {
                    return true;
                }
                if (MainActivity.f1423n || !C0725a.this.f1537c) {
                    C0725a.f1529f = editText.getText().toString().trim();
                    C0725a.this.checkCardData();
                } else {
                    C0725a.this.f1535F.cancel();
                }
                C0725a.this.f1535F.cancel();
                ((InputMethodManager) C0725a.this.getActivity().getSystemService("input_method")).toggleSoftInput(2, 0);
                return true;
            }
        });
        builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (MainActivity.f1423n || !C0725a.this.f1537c) {
                    C0725a.f1529f = editText.getText().toString().trim();
                    C0725a.this.checkCardData();
                } else {
                    C0725a.this.f1535F.cancel();
                }
                ((InputMethodManager) C0725a.this.getActivity().getSystemService("input_method")).toggleSoftInput(2, 0);
            }
        });
        builder.setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                ((InputMethodManager) C0725a.this.getActivity().getSystemService("input_method")).toggleSoftInput(2, 0);
            }
        });
        this.f1535F = builder.create();
        this.f1535F.getWindow().setSoftInputMode(5);
        this.f1535F.show();
    }

    /* renamed from: g */
    private void m2202g() {
        if (!this.f1534E.hasPrimaryClip() || (!this.f1534E.getPrimaryClipDescription().hasMimeType("text/plain") && !this.f1534E.getPrimaryClipDescription().hasMimeType("text/html"))) {
            this.f1531B.setEnabled(false);
            this.f1554v.setBackgroundResource(R.drawable.ic_content_paste_gray_24dp);
            this.f1546n.setTextColor(Color.parseColor("#FFAAAAAA"));
            return;
        }
        this.f1531B.setEnabled(true);
        this.f1554v.setBackgroundResource(R.drawable.ic_content_paste_black_24dp);
        this.f1546n.setTextColor(Color.parseColor("#FF000000"));
    }

    /* renamed from: h */
    private void m2203h() {
        if (!this.f1534E.hasPrimaryClip()) {
            return;
        }
        if (this.f1534E.getPrimaryClipDescription().hasMimeType("text/plain") || this.f1534E.getPrimaryClipDescription().hasMimeType("text/html")) {
            f1529f = this.f1534E.getPrimaryClip().getItemAt(0).getText().toString();
            if (f1529f != null) {
                checkCardData();
            }
        }
    }

    /* renamed from: a */
    public void mo8231a() {
        this.f1536a.show(getFragmentManager(), "Sample Fragment");
    }

    /* renamed from: b */
    public void mo8233b() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.RECORD_AUDIO") != 0) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.RECORD_AUDIO"}, 1);
        }
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.RECORD_AUDIO") != 0) {
            android.app.AlertDialog create = new AlertDialog.Builder(getActivity()).create();
            create.setTitle(getString(R.string.dialog_alert_title));
            create.setMessage(getString(R.string.dialog_alert_text));
            create.setButton(-3, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            create.show();
            return;
        }
        new C0733c().show(getFragmentManager(), "Sample Fragment");
    }

    public void addThisCard() {
        m2206k();
        this.f1539g = this.f1547o.getText().toString().trim();
        this.f1540h = f1529f;
        if (this.f1539g.trim().equals("") || !m2196a(this.f1539g)) {
            if (this.f1540h.trim().equals("")) {
                this.f1545m.setText(R.string.warning_track_data_empty);
                this.f1545m.setBackgroundResource(R.color.warning_yellow);
            }
            if (this.f1539g.trim().equals("") || this.f1540h.trim().equals("")) {
                m2199c("Must fill Name and Data");
                return;
            }
            this.f1538e = new C0724a(this.f1539g, this.f1540h);
            this.f1538e.f1512l = this.f1548p.getText().toString().trim();
            m2208m();
            if (this.f1538e.f1501a) {
                if (this.f1549q.getText().toString().trim().equals("")) {
                    this.f1549q.setText(this.f1538e.f1509i);
                } else {
                    this.f1538e.f1509i = this.f1549q.getText().toString().trim();
                }
                this.f1541i.setText(this.f1538e.f1509i);
                if (MainActivity.f1423n) {
                    this.f1542j.setText(this.f1538e.f1511k);
                } else {
                    this.f1542j.setText(this.f1538e.f1514n);
                }
                this.f1544l.setText(this.f1538e.f1515o + " / " + this.f1538e.f1519s);
                m2207l();
                if (m2198b(this.f1538e.f1507g)) {
                    this.f1545m.setText(R.string.warning_track_data_in_use);
                    this.f1545m.setBackgroundResource(R.color.warning_yellow);
                    new AlertDialog.Builder(getContext()).setIcon(R.drawable.ic_alert).setTitle("Data is in use. Add anyway?").setNegativeButton("No", (DialogInterface.OnClickListener) null).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            C0725a.this.f1538e.f1498F = MainActivity.f1395I;
                            C0725a.this.f1538e.f1500H = MainActivity.f1396J;
                            C0725a.this.f1538e.f1499G = C0797h.m2367c(C0725a.this.f1538e.f1500H);
                            if (!C0725a.this.f1537c) {
                                MainActivity.m2114a(C0725a.this.f1538e);
                                MainActivity.f1428s = true;
                            } else {
                                int i2 = MainActivity.f1435z;
                                MainActivity.m2123e(C0725a.f1527b);
                                MainActivity.m2115a(C0725a.this.f1538e, C0725a.f1527b);
                                MainActivity.m2121c(i2);
                            }
                            C0725a.this.mo8234c();
                            C0725a.this.getActivity().onBackPressed();
                        }
                    }).show();
                } else {
                    this.f1545m.setText(R.string.warning_track_data_ok);
                    this.f1545m.setBackgroundResource(R.color.warning_green);
                    this.f1538e.f1498F = MainActivity.f1395I;
                    this.f1538e.f1500H = MainActivity.f1396J;
                    this.f1538e.f1499G = C0797h.m2367c(this.f1538e.f1500H);
                    if (!this.f1537c) {
                        MainActivity.m2114a(this.f1538e);
                        MainActivity.f1428s = true;
                    } else {
                        int i = MainActivity.f1435z;
                        MainActivity.m2123e(f1527b);
                        MainActivity.m2115a(this.f1538e, f1527b);
                        MainActivity.m2121c(i);
                    }
                    mo8234c();
                    getActivity().onBackPressed();
                }
                if (!this.f1538e.f1503c && !this.f1538e.f1502b) {
                    this.f1545m.setText(R.string.warning_possible_invalid_card);
                    this.f1545m.setBackgroundResource(R.color.warning_yellow);
                    return;
                }
                return;
            }
            this.f1545m.setText(R.string.warning_invalid_card);
            this.f1545m.setBackgroundResource(R.color.warning_red);
            return;
        }
        m2199c("Name is already used");
    }

    /* renamed from: a */
    private boolean m2196a(String str) {
        if (f1527b == -1) {
            for (int i = 0; i < MainActivity.f1388B.size(); i++) {
                if (MainActivity.f1388B.get(i).f1508h.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        for (int i2 = 0; i2 < MainActivity.f1388B.size(); i2++) {
            if (i2 != f1527b && MainActivity.f1388B.get(i2).f1508h.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private boolean m2198b(String str) {
        if (f1527b == -1) {
            for (int i = 0; i < MainActivity.f1388B.size(); i++) {
                if (MainActivity.f1388B.get(i).f1507g.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        for (int i2 = 0; i2 < MainActivity.f1388B.size(); i2++) {
            if (i2 != f1527b && MainActivity.f1388B.get(i2).f1507g.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void checkCardData() {
        this.f1539g = this.f1547o.getText().toString();
        this.f1540h = f1529f;
        if (this.f1540h.trim().equals("")) {
            this.f1545m.setText(R.string.warning_track_data_empty);
            this.f1545m.setBackgroundResource(R.color.warning_yellow);
            return;
        }
        this.f1538e = new C0724a(this.f1539g, this.f1540h);
        if (this.f1538e.f1501a) {
            if (this.f1549q.getText().toString().trim().equals("")) {
                this.f1549q.setText(this.f1538e.f1509i);
            } else {
                this.f1538e.f1509i = this.f1549q.getText().toString().trim();
            }
            this.f1541i.setText(this.f1538e.f1509i);
            this.f1545m.setText(R.string.warning_track_data_ok);
            this.f1545m.setBackgroundResource(R.color.warning_green);
            if (MainActivity.f1423n) {
                this.f1542j.setText(this.f1538e.f1511k);
            } else {
                this.f1542j.setText(this.f1538e.f1514n);
            }
            this.f1544l.setText(this.f1538e.f1515o + " / " + this.f1538e.f1519s);
            if (m2198b(this.f1538e.f1507g)) {
                this.f1545m.setText(R.string.warning_track_data_in_use);
                this.f1545m.setBackgroundResource(R.color.warning_yellow);
            }
            m2208m();
            m2207l();
            if (!this.f1538e.f1503c && !this.f1538e.f1502b) {
                this.f1545m.setText(R.string.warning_possible_invalid_card);
                this.f1545m.setBackgroundResource(R.color.warning_yellow);
                return;
            }
            return;
        }
        this.f1545m.setText(R.string.warning_invalid_card);
        this.f1545m.setBackgroundResource(R.color.warning_red);
        this.f1541i.setText("");
        this.f1542j.setText("");
        this.f1543k.setText("");
        m2205j();
    }

    /* renamed from: c */
    public void mo8234c() {
        f1529f = "";
        m2204i();
        m2205j();
        if (MainActivity.f1397K.size() > 0 && MainActivity.f1398L.size() > 0) {
            MainActivity.f1395I = MainActivity.f1397K.get(0).intValue();
            MainActivity.f1396J = MainActivity.f1398L.get(0);
        }
    }

    /* renamed from: i */
    private void m2204i() {
        try {
            this.f1547o.setText("");
            this.f1548p.setText("");
        } catch (Exception e) {
        }
    }

    /* renamed from: j */
    private void m2205j() {
        try {
            this.f1541i.setText("");
            this.f1543k.setText("");
            this.f1542j.setText("");
            this.f1544l.setText("");
            this.f1549q.setText("");
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    private void m2199c(String str) {
        Snackbar.m1257a(getView(), str, 0).mo1019a();
    }

    /* renamed from: k */
    private void m2206k() {
        try {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getView().getWindowToken(), 0);
        } catch (Exception e) {
        }
    }

    /* renamed from: d */
    public void mo8236d() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        this.f1550r.setImageBitmap(BitmapFactory.decodeResource(getResources(), MainActivity.f1395I, options));
        m2207l();
        if (this.f1550r == null || MainActivity.f1396J.toLowerCase().contains("empty")) {
            this.f1550r.setBackgroundResource(R.drawable.round_rect_border);
        } else {
            this.f1550r.setBackgroundResource(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m2207l() {
        if (this.f1538e != null) {
            String l = C0797h.m2376l(MainActivity.f1396J);
            Typeface createFromAsset = Typeface.createFromAsset(getActivity().getAssets(), "fonts/OCRAStd.otf");
            this.f1541i.setTypeface(createFromAsset);
            this.f1541i.setTextColor(Color.parseColor(l));
            this.f1541i.setText(this.f1549q.getText().toString().trim());
            this.f1542j.setTypeface(createFromAsset);
            this.f1542j.setTextColor(Color.parseColor(l));
            this.f1543k.setTypeface(createFromAsset);
            this.f1543k.setTextColor(Color.parseColor(l));
            this.f1543k.setText(this.f1538e.f1520t);
            if (!MainActivity.f1423n) {
                this.f1542j.setText(this.f1538e.f1514n);
            } else {
                this.f1542j.setText(this.f1538e.f1511k);
            }
        }
    }

    /* renamed from: m */
    private void m2208m() {
        CharSequence charSequence;
        if (MainActivity.f1396J.toLowerCase().contains("empty") && this.f1538e != null) {
            if (this.f1538e.f1515o.toLowerCase().contains("visa")) {
                charSequence = "visa";
            } else if (this.f1538e.f1515o.toLowerCase().contains("master")) {
                charSequence = "master";
            } else if (this.f1538e.f1515o.toLowerCase().contains("american")) {
                charSequence = "amex";
            } else if (this.f1538e.f1515o.toLowerCase().contains("discover")) {
                charSequence = "discover";
            } else {
                charSequence = "blank";
            }
            int i = 0;
            while (true) {
                if (i >= MainActivity.f1398L.size()) {
                    break;
                }
                String lowerCase = MainActivity.f1398L.get(i).toLowerCase();
                if (lowerCase.contains(charSequence) && lowerCase.contains("blue")) {
                    MainActivity.f1396J = MainActivity.f1398L.get(i);
                    MainActivity.f1395I = MainActivity.f1397K.get(i).intValue();
                    break;
                }
                i++;
            }
            this.f1550r.setImageResource(MainActivity.f1395I);
            if (!MainActivity.f1396J.toLowerCase().contains("empty")) {
                this.f1550r.setBackgroundResource(0);
            } else {
                this.f1550r.setBackgroundResource(R.drawable.round_rect_border);
            }
        }
    }
}
