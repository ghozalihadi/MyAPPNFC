package android.support.p016v4.p018os;

import android.os.CancellationSignal;

/* renamed from: android.support.v4.os.CancellationSignalCompatJellybean */
class CancellationSignalCompatJellybean {
    CancellationSignalCompatJellybean() {
    }

    public static Object create() {
        return new CancellationSignal();
    }

    public static void cancel(Object obj) {
        ((CancellationSignal) obj).cancel();
    }
}
