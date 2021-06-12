package android.support.p016v4.view;

import android.support.p016v4.view.LayoutInflaterCompatHC;
import android.view.LayoutInflater;

/* renamed from: android.support.v4.view.LayoutInflaterCompatLollipop */
class LayoutInflaterCompatLollipop {
    LayoutInflaterCompatLollipop() {
    }

    static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory2(layoutInflaterFactory != null ? new LayoutInflaterCompatHC.FactoryWrapperHC(layoutInflaterFactory) : null);
    }
}
