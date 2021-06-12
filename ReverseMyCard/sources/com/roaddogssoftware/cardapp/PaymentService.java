package com.roaddogssoftware.cardapp;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.nfc.cardemulation.HostApduService;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.p016v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.roaddogssoftware.cardapp.R;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentService extends HostApduService implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a */
    public static final byte[] f1451a = {111, 0};

    /* renamed from: b */
    private static Dialog f1452b;

    /* renamed from: c */
    private static boolean f1453c = false;

    /* renamed from: d */
    private static String f1454d;

    /* renamed from: e */
    private static String f1455e;

    /* renamed from: f */
    private static String f1456f;

    /* renamed from: g */
    private static String f1457g = "";

    /* renamed from: h */
    private static int f1458h;

    /* renamed from: i */
    private static byte[] f1459i = new byte[0];

    /* renamed from: j */
    private static byte[] f1460j = new byte[0];

    /* renamed from: k */
    private static byte[] f1461k = new byte[0];

    /* renamed from: l */
    private static byte[] f1462l = new byte[0];

    /* renamed from: m */
    private static byte[] f1463m = new byte[0];

    /* renamed from: n */
    private static byte[] f1464n = new byte[0];

    /* renamed from: o */
    private static byte[] f1465o = new byte[0];

    /* renamed from: p */
    private static byte[] f1466p = new byte[0];

    /* renamed from: q */
    private static byte[] f1467q = new byte[0];

    /* renamed from: r */
    private static byte[] f1468r = new byte[0];

    /* renamed from: s */
    private static final Pattern f1469s = Pattern.compile(".*;(\\d{12,19}=\\d{1,128})\\?.*");

    public void onCreate() {
        super.onCreate();
        try {
            C0797h.m2364a("MY CARD 1.12: Starting...");
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            f1454d = defaultSharedPreferences.getString("SWIPE_NAME", "NAME");
            f1455e = defaultSharedPreferences.getString("SWIPE_DATA", "%B4046460664629718^000NETSPEND^161012100000181000000?;4046460664629718=16101210000018100000?");
            f1456f = defaultSharedPreferences.getString("DRAW_NAME", "first_run");
            f1457g = defaultSharedPreferences.getString("CARD_HOLDER", "CARD HOLDER");
            m2170d();
            m2168b(f1455e);
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
            C0797h.m2364a("Loaded card: " + f1454d + " - BIN:" + C0797h.m2375k(f1455e));
        } catch (Exception e) {
            C0797h.m2364a("ERROR onCreate: " + e.getMessage());
        }
    }

    public void onDeactivated(int i) {
        try {
            C0797h.m2364a(": Closing (" + String.valueOf(i) + ")");
            m2167b();
            new C0788c(this).mo8319a(f1454d, new SimpleDateFormat("MMM dd, yyyy").format(Calendar.getInstance().getTime()));
            new CountDownTimer(3000, 1000) {
                public void onTick(long j) {
                }

                public void onFinish() {
                    PaymentService.this.m2169c();
                }
            }.start();
        } catch (Exception e) {
            C0797h.m2364a("ERROR onDeactivated: " + e.getMessage());
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("SWIPE_DATA".equals(str)) {
            f1454d = sharedPreferences.getString("SWIPE_NAME", "NAME");
            f1455e = sharedPreferences.getString("SWIPE_DATA", "%B4046460664629718^000NETSPEND^161012100000181000000?;4046460664629718=16101210000018100000?");
            f1456f = sharedPreferences.getString("DRAW_NAME", "first_run");
            f1457g = sharedPreferences.getString("CARD_HOLDER", "CARD HOLDER");
            C0797h.m2364a("onSharedPreferenceChanged: key=" + str + " Setting card: " + f1454d);
            m2168b(f1455e);
        }
    }

    /* renamed from: a */
    private void m2163a() {
        try {
            if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(this, "android.permission.SYSTEM_ALERT_WINDOW") != 0) {
                m2165a("Processing...");
            } else if (!f1453c) {
                C0724a aVar = new C0724a(f1454d, f1455e);
                f1452b = new Dialog(this);
                f1452b.getWindow().setType(2003);
                f1452b.setCancelable(true);
                f1452b.getWindow().requestFeature(1);
                f1452b.setContentView(R.layout.payment_dialog);
                f1452b.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                ((TextView) f1452b.findViewById(R.id.cardName)).setText(f1454d);
                String l = C0797h.m2376l(f1456f);
                Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/OCRAStd.otf");
                ((TextView) f1452b.findViewById(R.id.textNameOnCard)).setText(f1457g);
                ((TextView) f1452b.findViewById(R.id.textNameOnCard)).setTypeface(createFromAsset);
                ((TextView) f1452b.findViewById(R.id.textNameOnCard)).setTextColor(Color.parseColor(l));
                ((TextView) f1452b.findViewById(R.id.textNameOnCard)).setText(aVar.f1514n);
                ((TextView) f1452b.findViewById(R.id.textCardNumber)).setTypeface(createFromAsset);
                ((TextView) f1452b.findViewById(R.id.textCardNumber)).setTextColor(Color.parseColor(l));
                ((TextView) f1452b.findViewById(R.id.textCardExp)).setText(aVar.f1520t);
                ((TextView) f1452b.findViewById(R.id.textCardExp)).setTypeface(createFromAsset);
                ((TextView) f1452b.findViewById(R.id.textCardExp)).setTextColor(Color.parseColor(l));
                ((ImageView) f1452b.findViewById(R.id.imageViewCard)).setImageResource(f1458h);
                f1452b.findViewById(R.id.progressBar).setVisibility(0);
                f1452b.findViewById(R.id.imageCheck).setVisibility(8);
                f1452b.show();
                f1453c = true;
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = f1452b.getWindow();
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = -1;
                layoutParams.gravity = 48;
                window.setAttributes(layoutParams);
            }
        } catch (Exception e) {
            C0797h.m2364a("showPaymentScreen", e.getMessage());
        }
    }

    /* renamed from: b */
    private void m2167b() {
        try {
            if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(this, "android.permission.SYSTEM_ALERT_WINDOW") == 0) {
                if (!f1453c) {
                    m2163a();
                }
                f1452b.findViewById(R.id.progressBar).setVisibility(8);
                f1452b.findViewById(R.id.imageCheck).setVisibility(0);
                return;
            }
            m2165a("Done");
        } catch (Exception e) {
            C0797h.m2364a("showPaymentDone", e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2169c() {
        try {
            if (f1452b != null) {
                f1452b.hide();
                f1453c = false;
            }
        } catch (Exception e) {
            C0797h.m2364a("hidePaymentScreen", e.getMessage());
        }
    }

    /* renamed from: d */
    private void m2170d() {
        if (f1456f.toLowerCase().contains("empty")) {
            f1458h = R.drawable.card_empty;
            return;
        }
        Field[] declaredFields = R.drawable.class.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            if (field.toString().toLowerCase().contains(f1456f.toLowerCase())) {
                try {
                    f1458h = field.getInt(R.drawable.class);
                    return;
                } catch (Exception e) {
                    f1458h = R.drawable.card_empty;
                    return;
                }
            } else {
                i++;
            }
        }
        f1458h = R.drawable.card_empty;
    }

    /* renamed from: a */
    private void m2165a(String str) {
        Toast makeText = Toast.makeText(this, str, 1);
        makeText.setGravity(17, 0, 0);
        makeText.getView().setBackgroundResource(R.drawable.round_rect);
        makeText.show();
    }

    /* renamed from: a */
    private boolean m2166a(byte[] bArr) {
        return bArr.length > 4 && bArr[0] == f1463m[0] && bArr[1] == f1463m[1] && bArr[2] == f1463m[2] && bArr[3] == f1463m[3];
    }

    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        byte[] bArr2;
        String str;
        String a;
        try {
            m2163a();
            if (Arrays.equals(f1459i, bArr)) {
                bArr2 = f1460j;
                str = "Received PPSE select: ";
            } else if (Arrays.equals(f1461k, bArr)) {
                bArr2 = f1462l;
                str = "Received Visa-MSD select: ";
            } else if (m2166a(bArr)) {
                bArr2 = f1464n;
                str = "Received GPO (get processing options): ";
            } else if (Arrays.equals(f1465o, bArr)) {
                bArr2 = f1468r;
                str = "Received READ REC: ";
            } else if (Arrays.equals(f1466p, bArr)) {
                bArr2 = f1467q;
                str = "Received READ REC 8E: ";
            } else {
                bArr2 = f1451a;
                str = "Received Unhandled APDU: ";
            }
            if (str.equals("Received READ REC: ")) {
                a = C0797h.m2374j(C0797h.m2363a(bArr2));
            } else {
                a = C0797h.m2363a(bArr2);
            }
            C0797h.m2364a(str + ": " + C0797h.m2363a(bArr), "Response: " + a);
            return bArr2;
        } catch (Exception e) {
            C0797h.m2364a("ERROR processCommandApdu: " + C0797h.m2363a(bArr), e.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    private static void m2168b(String str) {
        try {
            Matcher matcher = f1469s.matcher(str);
            if (matcher.matches()) {
                String replace = matcher.group(1).replace('=', 'D');
                if (replace.length() % 2 != 0) {
                    replace = replace + "F";
                }
                int length = replace.length() / 2;
                f1468r = new byte[(length + 6)];
                ByteBuffer wrap = ByteBuffer.wrap(f1468r);
                wrap.put((byte) 112);
                wrap.put((byte) (length + 2));
                wrap.put((byte) 87);
                wrap.put((byte) length);
                wrap.put(C0797h.m2365a(replace));
                wrap.put((byte) -112);
                wrap.put((byte) 0);
                f1459i = C0793e.f1781b;
                f1463m = C0793e.f1785f;
                f1465o = C0793e.f1787h;
                f1466p = C0793e.f1788i;
                f1467q = C0793e.f1789j;
                f1464n = C0793e.f1786g;
                f1460j = C0793e.f1782c;
                f1461k = C0793e.f1783d;
                f1462l = C0793e.f1784e;
                return;
            }
            C0797h.m2364a("PaymentService processed bad swipe data");
        } catch (Exception e) {
            C0797h.m2364a("ERROR configureReadRecResponse: " + e.getMessage());
        }
    }
}
