package android.support.p016v4.print;

import android.content.Context;
import android.print.PrintAttributes;

/* renamed from: android.support.v4.print.PrintHelperApi23 */
class PrintHelperApi23 extends PrintHelperApi20 {
    /* access modifiers changed from: protected */
    public PrintAttributes.Builder copyAttributes(PrintAttributes printAttributes) {
        PrintAttributes.Builder copyAttributes = super.copyAttributes(printAttributes);
        if (printAttributes.getDuplexMode() != 0) {
            copyAttributes.setDuplexMode(printAttributes.getDuplexMode());
        }
        return copyAttributes;
    }

    PrintHelperApi23(Context context) {
        super(context);
        this.mIsMinMarginsHandlingCorrect = false;
    }
}
