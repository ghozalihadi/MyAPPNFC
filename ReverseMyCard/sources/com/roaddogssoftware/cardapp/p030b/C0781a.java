package com.roaddogssoftware.cardapp.p030b;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import com.roaddogssoftware.cardapp.C0797h;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.roaddogssoftware.cardapp.b.a */
/* compiled from: AudioMonitor */
public class C0781a {

    /* renamed from: a */
    public static String f1729a = "Rhombus AudioMonitor";

    /* renamed from: b */
    private Handler f1730b;

    /* renamed from: c */
    private byte[] f1731c;

    /* renamed from: d */
    private int f1732d = 44100;

    /* renamed from: e */
    private int f1733e = 16;

    /* renamed from: f */
    private int f1734f = 2;

    /* renamed from: g */
    private int f1735g;

    /* renamed from: h */
    private AudioRecord f1736h;

    /* renamed from: i */
    private int f1737i = 500;

    /* renamed from: j */
    private int f1738j = this.f1737i;

    /* renamed from: k */
    private double f1739k = 0.1d;

    /* renamed from: l */
    private double f1740l = 0.5d;

    /* renamed from: m */
    private boolean f1741m = false;

    public C0781a(Handler handler) {
        this.f1730b = handler;
        mo8299a(this.f1732d);
    }

    /* renamed from: a */
    public void mo8299a(int i) {
        if (this.f1741m) {
            throw new IllegalStateException("Cannot set frequency while recording");
        }
        int i2 = this.f1732d;
        this.f1732d = i;
        m2322a(f1729a, "setting frequency to: " + i);
        this.f1735g = AudioRecord.getMinBufferSize(this.f1732d, this.f1733e, this.f1734f) * 2;
        if (this.f1735g < 0) {
            m2322a(f1729a, "could not set sample rate as requested.  Error code is:" + this.f1735g);
            this.f1732d = i2;
            this.f1735g = AudioRecord.getMinBufferSize(this.f1732d, this.f1733e, this.f1734f) * 2;
            Message obtain = Message.obtain();
            obtain.what = C0787d.INVALID_SAMPLE_RATE.ordinal();
            this.f1730b.sendMessage(obtain);
        }
    }

    /* renamed from: a */
    public boolean mo8300a() {
        return this.f1741m;
    }

    /* renamed from: b */
    public AudioRecord mo8301b() {
        for (short s : new short[]{2, 3}) {
            for (short s2 : new short[]{16, 12}) {
                for (int i : new int[]{44100, 22050, 11025, 8000}) {
                    try {
                        int minBufferSize = AudioRecord.getMinBufferSize(i, s2, s);
                        m2322a("findAudioRecord", ": Attempting rate " + i + "Hz, bits: " + s + ", channel: " + s2);
                        if (minBufferSize != -2) {
                            AudioRecord audioRecord = new AudioRecord(0, i, s2, s, minBufferSize);
                            if (audioRecord.getState() == 1) {
                                return audioRecord;
                            }
                        } else {
                            continue;
                        }
                    } catch (Exception e) {
                        m2322a("findAudioRecord: " + i + " Exception, keep trying", e.getMessage());
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public void mo8302c() {
        m2322a(f1729a, "bufferSize: " + this.f1735g);
        try {
            this.f1736h = mo8301b();
            if (this.f1736h == null) {
                Message.obtain().what = C0787d.RECORDING_ERROR.ordinal();
                mo8303d();
                return;
            }
            this.f1736h.startRecording();
            this.f1741m = true;
        } catch (Exception e) {
            m2322a("Exception 1", e.getMessage());
        }
    }

    /* renamed from: d */
    public void mo8303d() {
        m2322a(f1729a, "stop recording");
        try {
            if (this.f1736h != null) {
                this.f1736h.stop();
                this.f1736h.release();
                this.f1736h = null;
            }
            this.f1741m = false;
        } catch (Exception e) {
            m2322a("Exception 2", e.getMessage());
        }
    }

    /* renamed from: e */
    public void mo8304e() {
        boolean z;
        int i;
        try {
            Message obtain = Message.obtain();
            obtain.what = C0787d.NO_DATA_PRESENT.ordinal();
            this.f1730b.sendMessage(obtain);
            short[] sArr = new short[this.f1735g];
            mo8302c();
            int i2 = 0;
            boolean z2 = true;
            while (z2 && this.f1741m) {
                int read = this.f1736h.read(sArr, 0, this.f1735g);
                int i3 = 0;
                int i4 = 0;
                while (i3 < read) {
                    if (Math.abs(sArr[i3]) < this.f1737i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z2 || z) {
                        i = 0;
                    } else {
                        i = i4 + 1;
                        if (i > 5) {
                            Message obtain2 = Message.obtain();
                            obtain2.what = C0787d.DATA_PRESENT.ordinal();
                            this.f1730b.sendMessage(obtain2);
                            z2 = false;
                        }
                    }
                    i3++;
                    i4 = i;
                }
                i2 = read;
            }
            if (!z2) {
                m2323a(sArr, i2);
            }
        } catch (Exception e) {
            m2322a("Exception 3", e.getMessage());
        }
    }

    /* renamed from: a */
    private void m2323a(short[] sArr, int i) {
        int i2;
        m2322a(f1729a, "recording data");
        Message.obtain();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(byteArrayOutputStream));
        short[] sArr2 = new short[this.f1735g];
        int i3 = this.f1732d;
        int i4 = 0;
        int i5 = this.f1732d * 10;
        int i6 = 0;
        boolean z = false;
        int i7 = 0;
        while (i7 < i) {
            try {
                dataOutputStream.writeShort(sArr[i7]);
                i7++;
            } catch (Exception e) {
                m2322a("Exception 4", "Recording Failed: " + e);
                mo8303d();
                Message obtain = Message.obtain();
                obtain.what = C0787d.RECORDING_ERROR.ordinal();
                this.f1730b.sendMessage(obtain);
                return;
            }
        }
        int i8 = 0;
        while (!z && this.f1741m && i6 < i5) {
            int read = this.f1736h.read(sArr2, 0, this.f1735g);
            int i9 = i6;
            int i10 = 0;
            boolean z2 = z;
            int i11 = i4;
            int i12 = i8;
            boolean z3 = z2;
            while (i10 < read) {
                boolean z4 = Math.abs(sArr2[i10]) < this.f1737i;
                dataOutputStream.writeShort(sArr2[i10]);
                if (z4) {
                    i2 = 0;
                    i11++;
                    if (i11 > i3) {
                        z3 = true;
                        Message obtain2 = Message.obtain();
                        obtain2.what = C0787d.NO_DATA_PRESENT.ordinal();
                        this.f1730b.sendMessage(obtain2);
                    }
                } else {
                    i2 = i12 + 1;
                    if (i2 > 5) {
                        i11 = 0;
                    }
                }
                i10++;
                i9++;
                i12 = i2;
            }
            i6 = i9;
            boolean z5 = z3;
            i8 = i12;
            i4 = i11;
            z = z5;
        }
        dataOutputStream.close();
        if (!this.f1741m) {
            m2322a(f1729a, "not recording after loop in recorddata, assuming aborted");
            Message obtain3 = Message.obtain();
            obtain3.what = C0787d.NO_DATA_PRESENT.ordinal();
            this.f1730b.sendMessage(obtain3);
            return;
        }
        this.f1731c = byteArrayOutputStream.toByteArray();
        Message obtain4 = Message.obtain();
        obtain4.what = C0787d.DATA.ordinal();
        obtain4.obj = m2321a(this.f1731c);
        this.f1730b.sendMessage(obtain4);
    }

    /* renamed from: a */
    private List<Integer> m2321a(byte[] bArr) {
        try {
            ArrayList arrayList = new ArrayList(bArr.length / 2);
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(bArr)));
            while (dataInputStream.available() > 0) {
                arrayList.add(Integer.valueOf(dataInputStream.readShort()));
            }
            return arrayList;
        } catch (Exception e) {
            m2322a("Exception 5", e.getMessage());
            return new ArrayList(bArr.length / 2);
        }
    }

    /* renamed from: a */
    private void m2322a(String str, String str2) {
        C0797h.m2364a(str, str2);
    }
}
