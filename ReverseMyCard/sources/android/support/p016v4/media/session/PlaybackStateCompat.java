package android.support.p016v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.p016v4.media.session.PlaybackStateCompatApi21;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.PlaybackStateCompat */
public final class PlaybackStateCompat implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048;
    public static final long ACTION_PLAY_FROM_URI = 8192;
    public static final long ACTION_PLAY_PAUSE = 512;
    public static final long ACTION_PREPARE = 16384;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536;
    public static final long ACTION_PREPARE_FROM_URI = 131072;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 256;
    public static final long ACTION_SET_RATING = 128;
    public static final long ACTION_SKIP_TO_NEXT = 32;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096;
    public static final long ACTION_STOP = 1;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() {
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    private static final int KEYCODE_MEDIA_PLAY = 126;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    final long mActions;
    final long mActiveItemId;
    final long mBufferedPosition;
    List<CustomAction> mCustomActions;
    final CharSequence mErrorMessage;
    final Bundle mExtras;
    final long mPosition;
    final float mSpeed;
    final int mState;
    private Object mStateObj;
    final long mUpdateTime;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$Actions */
    public @interface Actions {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$MediaKeyAction */
    public @interface MediaKeyAction {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$State */
    public @interface State {
    }

    public static int toKeyCode(long j) {
        if (j == 4) {
            return 126;
        }
        if (j == 2) {
            return 127;
        }
        if (j == 32) {
            return 87;
        }
        if (j == 16) {
            return 88;
        }
        if (j == 1) {
            return 86;
        }
        if (j == 64) {
            return 90;
        }
        if (j == 8) {
            return 89;
        }
        if (j == 512) {
            return 85;
        }
        return 0;
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.mState = i;
        this.mPosition = j;
        this.mBufferedPosition = j2;
        this.mSpeed = f;
        this.mActions = j3;
        this.mErrorMessage = charSequence;
        this.mUpdateTime = j4;
        this.mCustomActions = new ArrayList(list);
        this.mActiveItemId = j5;
        this.mExtras = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.mState = parcel.readInt();
        this.mPosition = parcel.readLong();
        this.mSpeed = parcel.readFloat();
        this.mUpdateTime = parcel.readLong();
        this.mBufferedPosition = parcel.readLong();
        this.mActions = parcel.readLong();
        this.mErrorMessage = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mCustomActions = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.mActiveItemId = parcel.readLong();
        this.mExtras = parcel.readBundle();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=").append(this.mState);
        sb.append(", position=").append(this.mPosition);
        sb.append(", buffered position=").append(this.mBufferedPosition);
        sb.append(", speed=").append(this.mSpeed);
        sb.append(", updated=").append(this.mUpdateTime);
        sb.append(", actions=").append(this.mActions);
        sb.append(", error=").append(this.mErrorMessage);
        sb.append(", custom actions=").append(this.mCustomActions);
        sb.append(", active item id=").append(this.mActiveItemId);
        sb.append("}");
        return sb.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mPosition);
        parcel.writeFloat(this.mSpeed);
        parcel.writeLong(this.mUpdateTime);
        parcel.writeLong(this.mBufferedPosition);
        parcel.writeLong(this.mActions);
        TextUtils.writeToParcel(this.mErrorMessage, parcel, i);
        parcel.writeTypedList(this.mCustomActions);
        parcel.writeLong(this.mActiveItemId);
        parcel.writeBundle(this.mExtras);
    }

    public int getState() {
        return this.mState;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public long getBufferedPosition() {
        return this.mBufferedPosition;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public long getActions() {
        return this.mActions;
    }

    public List<CustomAction> getCustomActions() {
        return this.mCustomActions;
    }

    public CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    public long getLastPositionUpdateTime() {
        return this.mUpdateTime;
    }

    public long getActiveQueueItemId() {
        return this.mActiveItemId;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public static PlaybackStateCompat fromPlaybackState(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> customActions = PlaybackStateCompatApi21.getCustomActions(obj);
        ArrayList arrayList = null;
        if (customActions != null) {
            arrayList = new ArrayList(customActions.size());
            for (Object fromCustomAction : customActions) {
                arrayList.add(CustomAction.fromCustomAction(fromCustomAction));
            }
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(PlaybackStateCompatApi21.getState(obj), PlaybackStateCompatApi21.getPosition(obj), PlaybackStateCompatApi21.getBufferedPosition(obj), PlaybackStateCompatApi21.getPlaybackSpeed(obj), PlaybackStateCompatApi21.getActions(obj), PlaybackStateCompatApi21.getErrorMessage(obj), PlaybackStateCompatApi21.getLastPositionUpdateTime(obj), arrayList, PlaybackStateCompatApi21.getActiveQueueItemId(obj), Build.VERSION.SDK_INT >= 22 ? PlaybackStateCompatApi22.getExtras(obj) : null);
        playbackStateCompat.mStateObj = obj;
        return playbackStateCompat;
    }

    public Object getPlaybackState() {
        if (this.mStateObj != null || Build.VERSION.SDK_INT < 21) {
            return this.mStateObj;
        }
        ArrayList arrayList = null;
        if (this.mCustomActions != null) {
            arrayList = new ArrayList(this.mCustomActions.size());
            for (CustomAction customAction : this.mCustomActions) {
                arrayList.add(customAction.getCustomAction());
            }
        }
        if (Build.VERSION.SDK_INT >= 22) {
            this.mStateObj = PlaybackStateCompatApi22.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, arrayList, this.mActiveItemId, this.mExtras);
        } else {
            this.mStateObj = PlaybackStateCompatApi21.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, arrayList, this.mActiveItemId);
        }
        return this.mStateObj;
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() {
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        };
        private final String mAction;
        private Object mCustomActionObj;
        private final Bundle mExtras;
        private final int mIcon;
        private final CharSequence mName;

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.mAction = str;
            this.mName = charSequence;
            this.mIcon = i;
            this.mExtras = bundle;
        }

        CustomAction(Parcel parcel) {
            this.mAction = parcel.readString();
            this.mName = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.mIcon = parcel.readInt();
            this.mExtras = parcel.readBundle();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mAction);
            TextUtils.writeToParcel(this.mName, parcel, i);
            parcel.writeInt(this.mIcon);
            parcel.writeBundle(this.mExtras);
        }

        public int describeContents() {
            return 0;
        }

        public static CustomAction fromCustomAction(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(PlaybackStateCompatApi21.CustomAction.getAction(obj), PlaybackStateCompatApi21.CustomAction.getName(obj), PlaybackStateCompatApi21.CustomAction.getIcon(obj), PlaybackStateCompatApi21.CustomAction.getExtras(obj));
            customAction.mCustomActionObj = obj;
            return customAction;
        }

        public Object getCustomAction() {
            if (this.mCustomActionObj != null || Build.VERSION.SDK_INT < 21) {
                return this.mCustomActionObj;
            }
            this.mCustomActionObj = PlaybackStateCompatApi21.CustomAction.newInstance(this.mAction, this.mName, this.mIcon, this.mExtras);
            return this.mCustomActionObj;
        }

        public String getAction() {
            return this.mAction;
        }

        public CharSequence getName() {
            return this.mName;
        }

        public int getIcon() {
            return this.mIcon;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public String toString() {
            return "Action:mName='" + this.mName + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
        }

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder */
        public static final class Builder {
            private final String mAction;
            private Bundle mExtras;
            private final int mIcon;
            private final CharSequence mName;

            public Builder(String str, CharSequence charSequence, int i) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
                } else if (TextUtils.isEmpty(charSequence)) {
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
                } else if (i == 0) {
                    throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
                } else {
                    this.mAction = str;
                    this.mName = charSequence;
                    this.mIcon = i;
                }
            }

            public Builder setExtras(Bundle bundle) {
                this.mExtras = bundle;
                return this;
            }

            public CustomAction build() {
                return new CustomAction(this.mAction, this.mName, this.mIcon, this.mExtras);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$Builder */
    public static final class Builder {
        private long mActions;
        private long mActiveItemId = -1;
        private long mBufferedPosition;
        private final List<CustomAction> mCustomActions = new ArrayList();
        private CharSequence mErrorMessage;
        private Bundle mExtras;
        private long mPosition;
        private float mRate;
        private int mState;
        private long mUpdateTime;

        public Builder() {
        }

        public Builder(PlaybackStateCompat playbackStateCompat) {
            this.mState = playbackStateCompat.mState;
            this.mPosition = playbackStateCompat.mPosition;
            this.mRate = playbackStateCompat.mSpeed;
            this.mUpdateTime = playbackStateCompat.mUpdateTime;
            this.mBufferedPosition = playbackStateCompat.mBufferedPosition;
            this.mActions = playbackStateCompat.mActions;
            this.mErrorMessage = playbackStateCompat.mErrorMessage;
            if (playbackStateCompat.mCustomActions != null) {
                this.mCustomActions.addAll(playbackStateCompat.mCustomActions);
            }
            this.mActiveItemId = playbackStateCompat.mActiveItemId;
            this.mExtras = playbackStateCompat.mExtras;
        }

        public Builder setState(int i, long j, float f) {
            return setState(i, j, f, SystemClock.elapsedRealtime());
        }

        public Builder setState(int i, long j, float f, long j2) {
            this.mState = i;
            this.mPosition = j;
            this.mUpdateTime = j2;
            this.mRate = f;
            return this;
        }

        public Builder setBufferedPosition(long j) {
            this.mBufferedPosition = j;
            return this;
        }

        public Builder setActions(long j) {
            this.mActions = j;
            return this;
        }

        public Builder addCustomAction(String str, String str2, int i) {
            return addCustomAction(new CustomAction(str, str2, i, (Bundle) null));
        }

        public Builder addCustomAction(CustomAction customAction) {
            if (customAction == null) {
                throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
            }
            this.mCustomActions.add(customAction);
            return this;
        }

        public Builder setActiveQueueItemId(long j) {
            this.mActiveItemId = j;
            return this;
        }

        public Builder setErrorMessage(CharSequence charSequence) {
            this.mErrorMessage = charSequence;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.mState, this.mPosition, this.mBufferedPosition, this.mRate, this.mActions, this.mErrorMessage, this.mUpdateTime, this.mCustomActions, this.mActiveItemId, this.mExtras);
        }
    }
}
