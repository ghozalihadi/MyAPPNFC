package com.roaddogssoftware.cardapp.p029a;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.roaddogssoftware.cardapp.p030b.C0781a;
import com.roaddogssoftware.cardapp.p030b.C0785b;
import com.roaddogssoftware.cardapp.p030b.C0786c;
import com.roaddogssoftware.cardapp.p030b.C0787d;
import com.roaddogssoftware.cardapp.p030b.p031a.C0782a;
import com.roaddogssoftware.cardapp.p030b.p031a.C0784c;
import java.util.List;

/* renamed from: com.roaddogssoftware.cardapp.a.c */
/* compiled from: FragmentCardReadMag */
public class C0733c extends DialogFragment implements C0785b {

    /* renamed from: a */
    String f1572a = "";

    /* renamed from: b */
    Button f1573b;

    /* renamed from: c */
    Button f1574c;

    /* renamed from: d */
    private C0724a f1575d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f1576e;

    /* renamed from: f */
    private TextView f1577f;

    /* renamed from: g */
    private C0786c f1578g;

    /* renamed from: h */
    private IntentFilter f1579h;

    /* renamed from: i */
    private Thread f1580i;

    /* renamed from: j */
    private Runnable f1581j;

    /* renamed from: k */
    private Handler f1582k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C0781a f1583l;

    /* renamed from: m */
    private C0782a f1584m;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_card_read_mag, viewGroup, false);
        getDialog().getWindow().requestFeature(1);
        this.f1576e = (TextView) inflate.findViewById(R.id.status);
        this.f1576e.setText(getString(R.string.card_read_waiting));
        this.f1577f = (TextView) inflate.findViewById(R.id.track_data);
        this.f1573b = (Button) inflate.findViewById(R.id.buttonCancel);
        this.f1573b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0733c.this.dismiss();
            }
        });
        this.f1574c = (Button) inflate.findViewById(R.id.buttonSave);
        this.f1574c.setEnabled(false);
        this.f1574c.setBackgroundResource(R.drawable.ic_check_gray_24dp);
        this.f1574c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0725a.f1529f = C0733c.this.f1572a;
                MainActivity mainActivity = (MainActivity) C0733c.this.getActivity();
                MainActivity.f1406T.checkCardData();
                C0733c.this.dismiss();
            }
        });
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f1578g = new C0786c(this);
        this.f1579h = new IntentFilter();
        this.f1579h.addAction("android.intent.action.HEADSET_PLUG");
        this.f1580i = new Thread();
        this.f1581j = new Runnable() {
            public void run() {
                C0733c.this.f1583l.mo8304e();
            }
        };
        this.f1582k = new Handler(new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (message.what == C0787d.NO_DATA_PRESENT.ordinal()) {
                    return true;
                }
                if (message.what == C0787d.DATA_PRESENT.ordinal()) {
                    return true;
                }
                if (message.what == C0787d.RECORDING_ERROR.ordinal()) {
                    C0733c.this.f1576e.setText(C0733c.this.getString(R.string.card_read_mag_error));
                    return true;
                } else if (message.what == C0787d.INVALID_SAMPLE_RATE.ordinal()) {
                    return true;
                } else {
                    if (message.what != C0787d.DATA.ordinal()) {
                        return false;
                    }
                    C0733c.this.m2218a((List<Integer>) (List) message.obj);
                    return true;
                }
            }
        });
        this.f1583l = new C0781a(this.f1582k);
        this.f1584m = new C0782a();
    }

    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(this.f1578g, this.f1579h);
    }

    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(this.f1578g);
        m2221c();
    }

    /* renamed from: a */
    private void m2216a() {
        this.f1577f.setText(this.f1572a);
        if (this.f1572a.trim().equals("")) {
            this.f1576e.setText(getString(R.string.card_read_mag_no_data));
            return;
        }
        if (this.f1572a.length() == 39) {
            if (!this.f1572a.substring(0, 1).equals(";") || !this.f1572a.substring(38, 39).equals("?")) {
                this.f1576e.setText(getString(R.string.card_read_mag_bad));
                this.f1574c.setEnabled(false);
                this.f1574c.setBackgroundResource(R.drawable.ic_check_gray_24dp);
                return;
            }
        } else if (this.f1572a.length() != 39) {
            if (this.f1572a.length() == 38) {
                if (this.f1572a.substring(0, 1).equals(";")) {
                    this.f1572a += "?";
                } else if (this.f1572a.substring(37, 38).equals("?")) {
                    this.f1572a = ";" + this.f1572a;
                }
            } else if (this.f1572a.length() == 37) {
                this.f1572a = ";" + this.f1572a + "?";
            } else {
                this.f1576e.setText(getString(R.string.card_read_mag_bad));
                this.f1574c.setEnabled(false);
                this.f1574c.setBackgroundResource(R.drawable.ic_check_gray_24dp);
                return;
            }
        }
        this.f1575d = new C0724a("", this.f1572a);
        if (this.f1575d.f1501a) {
            this.f1576e.setText(getString(R.string.card_read_mag_ok));
            this.f1574c.setEnabled(true);
            this.f1574c.setBackgroundResource(R.drawable.ic_check_black_24dp);
            return;
        }
        this.f1576e.setText(getString(R.string.card_read_mag_bad));
        this.f1574c.setEnabled(false);
        this.f1574c.setBackgroundResource(R.drawable.ic_check_gray_24dp);
    }

    /* renamed from: b */
    private void m2220b() {
        try {
            this.f1580i.join();
        } catch (InterruptedException e) {
            C0797h.m2364a("mag reader - mAudioMonitorThread.join1: " + e.getMessage());
        }
        try {
            this.f1580i = new Thread(this.f1581j);
            this.f1580i.start();
        } catch (Exception e2) {
            C0797h.m2364a("mag reader - startAudioMonitor: " + e2.getMessage());
        }
    }

    /* renamed from: c */
    private void m2221c() {
        if (this.f1583l.mo8300a()) {
            this.f1583l.mo8303d();
        }
        try {
            this.f1580i.join();
        } catch (InterruptedException e) {
            C0797h.m2364a("mag reader - mAudioMonitorThread.join2: " + e.getMessage());
        }
    }

    /* renamed from: a */
    public void mo8245a(boolean z) {
        if (z) {
            m2220b();
        } else {
            m2221c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2218a(List<Integer> list) {
        try {
            m2221c();
            C0784c a = this.f1584m.mo8306a(list);
            if (a.mo8315b()) {
                this.f1576e.setText(getString(R.string.card_read_mag_bad));
                this.f1577f.setText("");
                this.f1574c.setEnabled(false);
                this.f1574c.setBackgroundResource(R.drawable.ic_check_gray_24dp);
            } else {
                this.f1572a = a.f1754a;
                m2216a();
            }
            m2220b();
        } catch (Exception e) {
            C0797h.m2364a("mag reader - onNewTrackData: " + e.getMessage());
        }
    }
}
