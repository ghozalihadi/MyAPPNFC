package com.roaddogssoftware.cardapp.p030b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.roaddogssoftware.cardapp.b.c */
/* compiled from: HeadsetStateReceiver */
public class C0786c extends BroadcastReceiver {

    /* renamed from: a */
    C0785b f1758a;

    public C0786c(C0785b bVar) {
        this.f1758a = bVar;
    }

    public void onReceive(Context context, Intent intent) {
        boolean z = true;
        if (intent.getAction().equalsIgnoreCase("android.intent.action.HEADSET_PLUG")) {
            int intExtra = intent.getIntExtra("state", -1);
            C0785b bVar = this.f1758a;
            if (intExtra != 1) {
                z = false;
            }
            bVar.mo8245a(z);
        }
    }
}
