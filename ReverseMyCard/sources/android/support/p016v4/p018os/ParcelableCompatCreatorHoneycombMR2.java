package android.support.p016v4.p018os;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.os.ParcelableCompatCreatorHoneycombMR2 */
/* compiled from: ParcelableCompatHoneycombMR2 */
class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
    private final ParcelableCompatCreatorCallbacks<T> mCallbacks;

    public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        this.mCallbacks = parcelableCompatCreatorCallbacks;
    }

    public T createFromParcel(Parcel parcel) {
        return this.mCallbacks.createFromParcel(parcel, (ClassLoader) null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.mCallbacks.createFromParcel(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.mCallbacks.newArray(i);
    }
}
