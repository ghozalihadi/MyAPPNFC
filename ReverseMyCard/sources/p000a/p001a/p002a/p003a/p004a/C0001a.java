package p000a.p001a.p002a.p003a.p004a;

import java.io.Serializable;
import java.io.Writer;

/* renamed from: a.a.a.a.a.a */
/* compiled from: StringBuilderWriter */
public class C0001a extends Writer implements Serializable {

    /* renamed from: a */
    private final StringBuilder f2a;

    public C0001a() {
        this.f2a = new StringBuilder();
    }

    public C0001a(int i) {
        this.f2a = new StringBuilder(i);
    }

    public Writer append(char c) {
        this.f2a.append(c);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        this.f2a.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i, int i2) {
        this.f2a.append(charSequence, i, i2);
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(String str) {
        if (str != null) {
            this.f2a.append(str);
        }
    }

    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.f2a.append(cArr, i, i2);
        }
    }

    public String toString() {
        return this.f2a.toString();
    }
}
