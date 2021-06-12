package com.roaddogssoftware.cardapp.p029a;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p016v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.roaddogssoftware.cardapp.C0724a;
import com.roaddogssoftware.cardapp.C0797h;
import com.roaddogssoftware.cardapp.MainActivity;
import com.roaddogssoftware.cardapp.R;
import com.roaddogssoftware.cardapp.p032c.C0790a;
import com.roaddogssoftware.cardapp.p032c.C0791b;
import p000a.p001a.p002a.p003a.C0000a;

/* renamed from: com.roaddogssoftware.cardapp.a.d */
/* compiled from: FragmentCardReadNfc */
public class C0738d extends DialogFragment {

    /* renamed from: a */
    String f1589a = "";

    /* renamed from: b */
    Button f1590b;

    /* renamed from: c */
    Button f1591c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f1592d = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0724a f1593e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f1594f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f1595g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Tag f1596h;

    /* renamed from: i */
    private C0790a f1597i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public IsoDep f1598j;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_card_read_nfc, viewGroup, false);
        getDialog().getWindow().requestFeature(1);
        this.f1594f = (TextView) inflate.findViewById(R.id.status);
        this.f1594f.setText("Waiting for card...");
        this.f1595g = (TextView) inflate.findViewById(R.id.track_data);
        this.f1590b = (Button) inflate.findViewById(R.id.buttonCancel);
        this.f1590b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0738d.this.dismiss();
            }
        });
        this.f1591c = (Button) inflate.findViewById(R.id.buttonSave);
        this.f1591c.setEnabled(false);
        this.f1591c.setBackgroundResource(R.drawable.ic_check_gray_24dp);
        this.f1591c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0725a.f1529f = C0738d.this.f1589a;
                MainActivity mainActivity = (MainActivity) C0738d.this.getActivity();
                MainActivity.f1406T.checkCardData();
                C0738d.this.dismiss();
            }
        });
        this.f1597i = new C0790a(getActivity());
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onResume() {
        super.onResume();
        this.f1597i.mo8326b();
    }

    public void onPause() {
        this.f1597i.mo8325a();
        super.onPause();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2229a() {
        if (this.f1589a.trim().equals("")) {
            this.f1594f.setText(getString(R.string.card_read_mag_bad));
            return;
        }
        if (this.f1589a.length() == 39) {
            if (!this.f1589a.substring(0, 1).equals(";") || !this.f1589a.substring(38, 39).equals("?")) {
                this.f1594f.setText(getString(R.string.card_read_mag_bad));
                this.f1591c.setEnabled(false);
                this.f1591c.setBackgroundResource(R.drawable.ic_check_gray_24dp);
                return;
            }
        } else if (this.f1589a.length() != 39) {
            if (this.f1589a.length() == 38) {
                if (this.f1589a.substring(0, 1).equals(";")) {
                    this.f1589a += "?";
                } else if (this.f1589a.substring(37, 38).equals("?")) {
                    this.f1589a = ";" + this.f1589a;
                }
            } else if (this.f1589a.length() == 37) {
                this.f1589a = ";" + this.f1589a + "?";
            } else {
                this.f1594f.setText(getString(R.string.card_read_mag_bad));
                this.f1591c.setEnabled(false);
                this.f1591c.setBackgroundResource(R.drawable.ic_check_gray_24dp);
                return;
            }
        }
        this.f1593e = new C0724a("", this.f1589a);
        if (this.f1593e.f1501a) {
            this.f1594f.setText(getString(R.string.card_read_mag_ok));
            this.f1595g.setText(this.f1589a);
            this.f1591c.setEnabled(true);
            this.f1591c.setBackgroundResource(R.drawable.ic_check_black_24dp);
            return;
        }
        this.f1594f.setText(getString(R.string.card_read_mag_bad));
        this.f1591c.setEnabled(false);
        this.f1591c.setBackgroundResource(R.drawable.ic_check_gray_24dp);
    }

    /* renamed from: a */
    public void mo8250a(Tag tag) {
        this.f1596h = tag;
        new C0741a().execute(new String[]{""});
    }

    /* renamed from: com.roaddogssoftware.cardapp.a.d$a */
    /* compiled from: FragmentCardReadNfc */
    private class C0741a extends AsyncTask<String, Void, String> {

        /* renamed from: a */
        String f1601a;

        /* renamed from: b */
        String f1602b;

        /* renamed from: c */
        String f1603c;

        /* renamed from: d */
        String f1604d;

        /* renamed from: e */
        String f1605e;

        /* renamed from: f */
        String f1606f;

        /* renamed from: g */
        String f1607g;

        /* renamed from: h */
        String f1608h;

        /* renamed from: i */
        String f1609i;

        /* renamed from: j */
        String f1610j;

        /* renamed from: k */
        String f1611k;

        /* renamed from: l */
        String f1612l;

        /* renamed from: m */
        String f1613m;

        /* renamed from: n */
        String f1614n;

        /* renamed from: o */
        String f1615o;

        /* renamed from: p */
        String f1616p;

        /* renamed from: q */
        byte[] f1617q;

        /* renamed from: s */
        private boolean f1619s;

        private C0741a() {
            this.f1601a = "00 A4 04 00 0E 32 50 41 59 2E 53 59 53 2E 44 44 46 30 31 00";
            this.f1602b = "00 B2 01 0C 00";
            this.f1603c = "";
            this.f1604d = "80 A8 00 00 02 83 00 00";
            this.f1605e = "80 A8 00 00 15 83 13 28 00 00 00 00 00 00 00 10 00 13 B7 9B EE 08 26 16 06 09 00";
            this.f1606f = "80 A8 00 00 15 83 13 28 00 00 00 00 00 00 00 10 00 33 2C A6 6A 08 26 16 06 17 00";
            this.f1607g = "80 A8 00 00 03 83 01 00 00";
            this.f1608h = "00 B2 01 14 00";
            this.f1609i = "";
            this.f1610j = "";
            this.f1611k = "";
            this.f1612l = "";
            this.f1613m = "";
            this.f1614n = "";
            this.f1615o = "";
            this.f1616p = "";
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            IsoDep unused = C0738d.this.f1598j = IsoDep.get(C0738d.this.f1596h);
            if (C0738d.this.f1598j == null) {
                return "";
            }
            this.f1619s = false;
            C0738d.this.f1598j.connect();
            this.f1617q = C0738d.this.mo8251a(this.f1601a);
            this.f1609i = C0791b.m2360a(this.f1617q);
            if (this.f1609i.length() > 101) {
                String unused2 = C0738d.this.f1592d = this.f1609i.substring(81, 101);
            }
            this.f1603c = C0738d.this.m2233b(C0738d.this.f1592d);
            this.f1617q = C0738d.this.mo8251a(this.f1603c);
            this.f1611k = C0791b.m2360a(this.f1617q);
            this.f1617q = C0738d.this.mo8251a(this.f1604d);
            this.f1612l = C0791b.m2360a(this.f1617q);
            if (this.f1612l.length() > 6) {
                this.f1617q = C0738d.this.mo8251a(this.f1608h);
                this.f1616p = C0791b.m2360a(this.f1617q);
                if (this.f1616p.length() > 6) {
                    C0738d.this.f1589a = C0738d.this.m2237c(this.f1617q);
                    C0724a unused3 = C0738d.this.f1593e = new C0724a("readCard", C0738d.this.f1589a);
                    C0000a.m0a(C0738d.this.f1598j);
                    return "";
                }
            }
            try {
                this.f1617q = C0738d.this.mo8251a(this.f1605e);
                this.f1613m = C0791b.m2360a(this.f1617q);
                if (this.f1613m.length() > 6) {
                    C0738d.this.f1589a = C0738d.this.m2240d(this.f1617q);
                    C0724a unused4 = C0738d.this.f1593e = new C0724a("readCard", C0738d.this.f1589a);
                    return "";
                }
                this.f1617q = C0738d.this.mo8251a(this.f1606f);
                this.f1614n = C0791b.m2360a(this.f1617q);
                if (this.f1614n.length() > 6) {
                    C0738d.this.f1589a = C0738d.this.m2240d(this.f1617q);
                    C0724a unused5 = C0738d.this.f1593e = new C0724a("readCard", C0738d.this.f1589a);
                    C0000a.m0a(C0738d.this.f1598j);
                    return "";
                }
                this.f1617q = C0738d.this.mo8251a(this.f1607g);
                this.f1615o = C0791b.m2360a(this.f1617q);
                if (this.f1615o.length() > 6) {
                    this.f1617q = C0738d.this.mo8251a(this.f1602b);
                    this.f1610j = C0791b.m2360a(this.f1617q);
                    if (this.f1610j.length() > 6) {
                        C0738d.this.f1589a = C0738d.this.m2228a(this.f1617q);
                        C0724a unused6 = C0738d.this.f1593e = new C0724a("readCard", C0738d.this.f1589a);
                        C0000a.m0a(C0738d.this.f1598j);
                        return "";
                    }
                }
                this.f1617q = C0738d.this.mo8251a(this.f1604d);
                this.f1612l = C0791b.m2360a(this.f1617q);
                if (this.f1612l.length() > 6) {
                    this.f1617q = C0738d.this.mo8251a(this.f1602b);
                    this.f1610j = C0791b.m2360a(this.f1617q);
                    if (this.f1610j.length() > 6) {
                        C0738d.this.f1589a = C0738d.this.m2234b(this.f1617q);
                        C0724a unused7 = C0738d.this.f1593e = new C0724a("readCard", C0738d.this.f1589a);
                        C0000a.m0a(C0738d.this.f1598j);
                        return "";
                    }
                }
                C0738d.this.f1589a = "";
                C0000a.m0a(C0738d.this.f1598j);
                return "";
            } catch (Exception e) {
                this.f1619s = true;
                C0797h.m2364a(C0738d.this.getString(R.string.card_read_nfc_error) + e.getMessage());
            } finally {
                C0000a.m0a(C0738d.this.f1598j);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(String str) {
            if (C0738d.this.f1598j == null) {
                C0738d.this.f1594f.setText(C0738d.this.getString(R.string.card_read_nfc_unable));
            } else if (!this.f1619s) {
                try {
                    if (C0738d.this.f1589a.length() > 6) {
                        C0738d.this.f1594f.setText(C0738d.this.getString(R.string.card_read_mag_ok));
                        C0738d.this.f1595g.setText(C0738d.this.f1589a);
                        C0738d.this.m2229a();
                        return;
                    }
                    C0738d.this.f1594f.setText(C0738d.this.getString(R.string.card_read_nfc_unable));
                    C0738d.this.f1595g.setText("");
                    C0738d.this.f1591c.setEnabled(false);
                    C0738d.this.f1591c.setBackgroundResource(R.drawable.ic_check_gray_24dp);
                } catch (Exception e) {
                    this.f1619s = true;
                }
            } else {
                C0738d.this.f1594f.setText(C0738d.this.getString(R.string.card_read_nfc_error_unknown));
                C0738d.this.f1595g.setText("");
                C0738d.this.f1591c.setEnabled(false);
                C0738d.this.f1591c.setBackgroundResource(R.drawable.ic_check_gray_24dp);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public byte[] mo8251a(String str) {
        String[] split = str.split("\\s");
        byte[] bArr = new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            bArr[i] = (byte) Integer.parseInt(split[i], 16);
        }
        return this.f1598j.transceive(bArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m2233b(String str) {
        if (str.length() < 20) {
            return "";
        }
        return "00 A4 04 00 07 " + str + " 00";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m2228a(byte[] bArr) {
        if (bArr.length <= 23) {
            return "";
        }
        return (((((((((("" + String.format("%02X", new Object[]{Byte.valueOf(bArr[4])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[5])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[6])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[7])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[8])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[9])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[10])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[11])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[12])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[13])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[14])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[15])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[16])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[17])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[18])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[19])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[20])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[21])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[22])})).toUpperCase().replace("D", "=").replace("F", "");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m2234b(byte[] bArr) {
        if (bArr.length <= 23) {
            return "";
        }
        return (((((((((("" + String.format("%02X", new Object[]{Byte.valueOf(bArr[96])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[97])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[98])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[99])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[100])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[101])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[102])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[103])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[104])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[105])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[106])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[107])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[108])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[109])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[110])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[111])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[112])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[113])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[114])})).toUpperCase().replace("D", "=").replace("F", "");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public String m2237c(byte[] bArr) {
        if (bArr.length <= 23) {
            return "";
        }
        return (((((((((("" + String.format("%02X", new Object[]{Byte.valueOf(bArr[5])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[6])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[7])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[8])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[9])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[10])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[11])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[12])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[13])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[14])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[15])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[16])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[17])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[18])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[19])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[20])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[21])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[22])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[23])})).toUpperCase().replace("D", "=").replace("F", "");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m2240d(byte[] bArr) {
        if (bArr.length <= 33) {
            return "";
        }
        return (((((((((("" + String.format("%02X", new Object[]{Byte.valueOf(bArr[15])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[16])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[17])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[18])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[19])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[20])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[21])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[22])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[23])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[24])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[25])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[26])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[27])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[28])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[29])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[30])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[31])}) + String.format("%02X", new Object[]{Byte.valueOf(bArr[32])})) + String.format("%02X", new Object[]{Byte.valueOf(bArr[33])})).toUpperCase().replace("D", "=").replace("F", "");
    }
}
