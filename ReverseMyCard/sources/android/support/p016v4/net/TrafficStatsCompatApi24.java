package android.support.p016v4.net;

import android.net.TrafficStats;
import java.net.DatagramSocket;

/* renamed from: android.support.v4.net.TrafficStatsCompatApi24 */
public class TrafficStatsCompatApi24 {
    public static void tagDatagramSocket(DatagramSocket datagramSocket) {
        TrafficStats.tagDatagramSocket(datagramSocket);
    }

    public static void untagDatagramSocket(DatagramSocket datagramSocket) {
        TrafficStats.untagDatagramSocket(datagramSocket);
    }
}
