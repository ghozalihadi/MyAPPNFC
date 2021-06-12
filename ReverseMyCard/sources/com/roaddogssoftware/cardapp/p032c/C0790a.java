package com.roaddogssoftware.cardapp.p032c;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;

/* renamed from: com.roaddogssoftware.cardapp.c.a */
/* compiled from: NFCUtils */
public class C0790a {

    /* renamed from: d */
    private static final IntentFilter[] f1775d = {new IntentFilter("android.nfc.action.TECH_DISCOVERED")};

    /* renamed from: e */
    private static final String[][] f1776e = {new String[]{IsoDep.class.getName()}};

    /* renamed from: a */
    private final NfcAdapter f1777a = NfcAdapter.getDefaultAdapter(this.f1779c);

    /* renamed from: b */
    private final PendingIntent f1778b = PendingIntent.getActivity(this.f1779c, 0, new Intent(this.f1779c, this.f1779c.getClass()).addFlags(536870912), 0);

    /* renamed from: c */
    private final Activity f1779c;

    public C0790a(Activity activity) {
        this.f1779c = activity;
    }

    /* renamed from: a */
    public void mo8325a() {
        if (this.f1777a != null) {
            this.f1777a.disableForegroundDispatch(this.f1779c);
        }
    }

    /* renamed from: b */
    public void mo8326b() {
        if (this.f1777a != null) {
            this.f1777a.enableForegroundDispatch(this.f1779c, this.f1778b, f1775d, f1776e);
        }
    }
}
