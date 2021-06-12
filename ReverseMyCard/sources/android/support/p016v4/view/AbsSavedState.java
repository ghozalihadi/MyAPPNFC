package android.support.p016v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p016v4.p018os.ParcelableCompat;
import android.support.p016v4.p018os.ParcelableCompatCreatorCallbacks;

/* renamed from: android.support.v4.view.AbsSavedState */
public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<AbsSavedState>() {
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.EMPTY_STATE;
            }
            throw new IllegalStateException("superState must be null");
        }

        public AbsSavedState[] newArray(int i) {
            return new AbsSavedState[i];
        }
    });
    public static final AbsSavedState EMPTY_STATE = new AbsSavedState() {
    };
    private final Parcelable mSuperState;

    private AbsSavedState() {
        this.mSuperState = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
    }

    protected AbsSavedState(Parcel parcel) {
        this(parcel, (ClassLoader) null);
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.mSuperState = readParcelable == null ? EMPTY_STATE : readParcelable;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }
}
