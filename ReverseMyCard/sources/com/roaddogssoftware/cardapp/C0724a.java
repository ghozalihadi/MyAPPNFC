package com.roaddogssoftware.cardapp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p020b.p021a.p022a.C0666k;
import p020b.p021a.p023b.p024a.C0672a;
import p020b.p021a.p023b.p024a.C0675d;
import p020b.p021a.p023b.p024a.C0676e;

/* renamed from: com.roaddogssoftware.cardapp.a */
/* compiled from: CardInfo */
public class C0724a {

    /* renamed from: A */
    public String f1493A = "";

    /* renamed from: B */
    public String f1494B = "";

    /* renamed from: C */
    public String f1495C = "";

    /* renamed from: D */
    public String f1496D = "";

    /* renamed from: E */
    public String f1497E = "";

    /* renamed from: F */
    public int f1498F = 0;

    /* renamed from: G */
    public int f1499G = 0;

    /* renamed from: H */
    public String f1500H = "";

    /* renamed from: a */
    public boolean f1501a = false;

    /* renamed from: b */
    public boolean f1502b = false;

    /* renamed from: c */
    public boolean f1503c = false;

    /* renamed from: d */
    public boolean f1504d = false;

    /* renamed from: e */
    public boolean f1505e = false;

    /* renamed from: f */
    public String f1506f = "";

    /* renamed from: g */
    public String f1507g = "";

    /* renamed from: h */
    public String f1508h = "";

    /* renamed from: i */
    public String f1509i = "";

    /* renamed from: j */
    public String f1510j = "";

    /* renamed from: k */
    public String f1511k = "";

    /* renamed from: l */
    public String f1512l = "";

    /* renamed from: m */
    public String f1513m = "";

    /* renamed from: n */
    public String f1514n = "";

    /* renamed from: o */
    public String f1515o = "";

    /* renamed from: p */
    public String f1516p = "";

    /* renamed from: q */
    public String f1517q = "";

    /* renamed from: r */
    public String f1518r = "";

    /* renamed from: s */
    public String f1519s = "";

    /* renamed from: t */
    public String f1520t = "";

    /* renamed from: u */
    public boolean f1521u = false;

    /* renamed from: v */
    public String f1522v = "";

    /* renamed from: w */
    public String f1523w = "";

    /* renamed from: x */
    public String f1524x = "";

    /* renamed from: y */
    public String f1525y = "";

    /* renamed from: z */
    public String f1526z = "";

    public C0724a(String str, String str2) {
        this.f1508h = str;
        this.f1506f = str2;
        this.f1500H = "";
        if (!str2.trim().equals("")) {
            m2189b();
            m2187a();
            m2192c();
        }
    }

    public C0724a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f1508h = str;
        this.f1506f = str2;
        if (!str2.trim().equals("")) {
            this.f1500H = str3;
            this.f1498F = C0797h.m2366b(this.f1500H);
            if (this.f1498F == 0) {
                this.f1500H = "card_empty";
                this.f1498F = C0797h.m2366b(this.f1500H);
            }
            this.f1499G = C0797h.m2367c(this.f1500H);
            this.f1512l = str4;
            this.f1522v = str6;
            this.f1523w = str7;
            m2189b();
            m2187a();
            m2192c();
            if (str5 != null && !str5.trim().equals("")) {
                this.f1509i = str5;
            }
        }
    }

    /* renamed from: a */
    private void m2187a() {
        if (this.f1503c || this.f1502b || this.f1504d) {
            this.f1501a = true;
        }
        this.f1511k = C0797h.m2371g(this.f1510j);
        this.f1513m = C0797h.m2372h(this.f1510j);
        this.f1514n = C0797h.m2373i(this.f1510j);
    }

    /* renamed from: b */
    private void m2189b() {
        if (!m2188a(this.f1506f)) {
            String str = ";" + this.f1506f;
            if (m2188a(str)) {
                this.f1506f = str;
                return;
            }
            String str2 = this.f1506f + "?";
            if (m2188a(str2)) {
                this.f1506f = str2;
                return;
            }
            String str3 = ";" + this.f1506f + "?";
            if (m2188a(str3)) {
                this.f1506f = str3;
            } else if (!m2190b(this.f1506f)) {
                String str4 = ";" + this.f1506f;
                if (m2190b(str4)) {
                    this.f1506f = str4;
                    return;
                }
                String str5 = this.f1506f + "?";
                if (m2190b(str5)) {
                    this.f1506f = str5;
                    return;
                }
                String str6 = ";" + this.f1506f + "?";
                if (m2190b(str6)) {
                    this.f1506f = str6;
                } else if (!m2193d(this.f1506f)) {
                    String str7 = ";" + this.f1506f;
                    if (m2193d(str7)) {
                        this.f1506f = str7;
                        return;
                    }
                    String str8 = this.f1506f + "?";
                    if (m2193d(str8)) {
                        this.f1506f = str8;
                        return;
                    }
                    String str9 = ";" + this.f1506f + "?";
                    if (m2193d(str9)) {
                        this.f1506f = str9;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m2188a(String str) {
        C0672a a = C0672a.m1985a(str);
        C0675d a2 = a.mo8079a();
        C0676e b = a.mo8080b();
        this.f1507g = b.toString();
        this.f1503c = b.mo8087b().mo8035i();
        if (this.f1503c) {
            C0666k c = b.mo8088c();
            this.f1509i = a2.mo8095l() ? a2.mo8094j().mo8056a() : "";
            if (this.f1509i.trim().equals("")) {
                this.f1509i = m2191c(str);
            }
            this.f1510j = b.mo8087b().mo8024a();
            this.f1515o = b.mo8087b().mo8026c().name();
            this.f1519s = b.mo8086a().toString();
            this.f1520t = C0797h.m2368d(this.f1519s);
            this.f1497E = b.mo8083e() ? b.mo8084f() : "[none]";
            this.f1524x = c.mo8064a();
            this.f1525y = Integer.toString(c.mo8065b().mo8073b());
            this.f1526z = c.mo8065b().mo8072a();
            this.f1493A = Integer.toString(c.mo8066c().mo8073b());
            this.f1494B = c.mo8066c().mo8075a();
            this.f1495C = Integer.toString(c.mo8067d().mo8073b());
            this.f1496D = c.mo8067d().mo8077a();
        }
        return this.f1503c;
    }

    /* renamed from: b */
    private boolean m2190b(String str) {
        Matcher matcher = Pattern.compile("^\\s*(?:%B(\\d+)\\^([^^]+)\\^\\d+)?\\?;(\\d+)=(\\d\\d)(\\d\\d)\\d+\\?\\s*$").matcher(str);
        this.f1502b = matcher.matches();
        if (this.f1502b) {
            this.f1509i = matcher.group(2);
            this.f1510j = matcher.group(3);
            this.f1519s = matcher.group(5) + "/" + matcher.group(4);
            this.f1520t = C0797h.m2368d(this.f1519s);
        }
        return this.f1502b;
    }

    /* renamed from: c */
    private String m2191c(String str) {
        Matcher matcher = Pattern.compile("^\\s*(?:%B(\\d+)\\^([^^]+)\\^\\d+)?\\?;(\\d+)=(\\d\\d)(\\d\\d)\\d+\\?\\s*$").matcher(str);
        this.f1502b = matcher.matches();
        if (this.f1502b) {
            return matcher.group(2);
        }
        return "";
    }

    /* renamed from: d */
    private boolean m2193d(String str) {
        Matcher matcher = Pattern.compile(".*;(\\d{12,19}=\\d{1,128})\\?.*").matcher(str);
        this.f1504d = matcher.matches();
        if (this.f1504d) {
            try {
                this.f1507g = matcher.group(1);
                this.f1519s = C0797h.m2369e(str);
                this.f1520t = C0797h.m2368d(this.f1519s);
                this.f1510j = C0797h.m2370f(str);
                this.f1509i = m2191c(str);
                this.f1515o = MainActivity.f1414e.getResources().getString(R.string.card_brand_unknown);
            } catch (Exception e) {
            }
        }
        return this.f1504d;
    }

    /* renamed from: c */
    private void m2192c() {
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(1) - 2000;
        int i2 = instance.get(2) + 1;
        if (this.f1522v.trim().equals("")) {
            this.f1522v = new SimpleDateFormat("MMM dd, yyyy").format(date);
        }
        if (this.f1519s.trim().equals("")) {
            this.f1521u = false;
            return;
        }
        try {
            int parseInt = Integer.parseInt(this.f1519s.substring(2, 4));
            int parseInt2 = Integer.parseInt(this.f1519s.substring(5, 7));
            if (i > parseInt) {
                this.f1521u = true;
            } else if (i < parseInt) {
                this.f1521u = false;
            } else if (i2 > parseInt2) {
                this.f1521u = true;
            } else {
                this.f1521u = false;
            }
        } catch (Exception e) {
            this.f1521u = false;
        }
    }
}
