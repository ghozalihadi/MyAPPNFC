package p000a.p001a.p002a.p003a;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import p000a.p001a.p002a.p003a.p004a.C0001a;

/* renamed from: a.a.a.a.a */
/* compiled from: IOUtils */
public class C0000a {

    /* renamed from: a */
    public static final char f0a = File.separatorChar;

    /* renamed from: b */
    public static final String f1b;

    static {
        C0001a aVar = new C0001a(4);
        PrintWriter printWriter = new PrintWriter(aVar);
        printWriter.println();
        f1b = aVar.toString();
        printWriter.close();
    }

    /* renamed from: a */
    public static void m0a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
