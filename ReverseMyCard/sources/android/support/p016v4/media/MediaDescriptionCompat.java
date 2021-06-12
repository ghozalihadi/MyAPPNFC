package android.support.p016v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p016v4.media.MediaDescriptionCompatApi21;
import android.support.p016v4.media.MediaDescriptionCompatApi23;
import android.text.TextUtils;

/* renamed from: android.support.v4.media.MediaDescriptionCompat */
public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(parcel));
        }

        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    private final CharSequence mDescription;
    private Object mDescriptionObj;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.mMediaId = str;
        this.mTitle = charSequence;
        this.mSubtitle = charSequence2;
        this.mDescription = charSequence3;
        this.mIcon = bitmap;
        this.mIconUri = uri;
        this.mExtras = bundle;
        this.mMediaUri = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.mMediaId = parcel.readString();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSubtitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mIcon = (Bitmap) parcel.readParcelable((ClassLoader) null);
        this.mIconUri = (Uri) parcel.readParcelable((ClassLoader) null);
        this.mExtras = parcel.readBundle();
        this.mMediaUri = (Uri) parcel.readParcelable((ClassLoader) null);
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.mMediaId);
            TextUtils.writeToParcel(this.mTitle, parcel, i);
            TextUtils.writeToParcel(this.mSubtitle, parcel, i);
            TextUtils.writeToParcel(this.mDescription, parcel, i);
            parcel.writeParcelable(this.mIcon, i);
            parcel.writeParcelable(this.mIconUri, i);
            parcel.writeBundle(this.mExtras);
            parcel.writeParcelable(this.mMediaUri, i);
            return;
        }
        MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), parcel, i);
    }

    public String toString() {
        return this.mTitle + ", " + this.mSubtitle + ", " + this.mDescription;
    }

    public Object getMediaDescription() {
        if (this.mDescriptionObj != null || Build.VERSION.SDK_INT < 21) {
            return this.mDescriptionObj;
        }
        Object newInstance = MediaDescriptionCompatApi21.Builder.newInstance();
        MediaDescriptionCompatApi21.Builder.setMediaId(newInstance, this.mMediaId);
        MediaDescriptionCompatApi21.Builder.setTitle(newInstance, this.mTitle);
        MediaDescriptionCompatApi21.Builder.setSubtitle(newInstance, this.mSubtitle);
        MediaDescriptionCompatApi21.Builder.setDescription(newInstance, this.mDescription);
        MediaDescriptionCompatApi21.Builder.setIconBitmap(newInstance, this.mIcon);
        MediaDescriptionCompatApi21.Builder.setIconUri(newInstance, this.mIconUri);
        Bundle bundle = this.mExtras;
        if (Build.VERSION.SDK_INT < 23 && this.mMediaUri != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
            }
            bundle.putParcelable(DESCRIPTION_KEY_MEDIA_URI, this.mMediaUri);
        }
        MediaDescriptionCompatApi21.Builder.setExtras(newInstance, bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            MediaDescriptionCompatApi23.Builder.setMediaUri(newInstance, this.mMediaUri);
        }
        this.mDescriptionObj = MediaDescriptionCompatApi21.Builder.build(newInstance);
        return this.mDescriptionObj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p016v4.media.MediaDescriptionCompat fromMediaDescription(java.lang.Object r6) {
        /*
            r1 = 0
            if (r6 == 0) goto L_0x0009
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r0 >= r2) goto L_0x000a
        L_0x0009:
            return r1
        L_0x000a:
            android.support.v4.media.MediaDescriptionCompat$Builder r4 = new android.support.v4.media.MediaDescriptionCompat$Builder
            r4.<init>()
            java.lang.String r0 = android.support.p016v4.media.MediaDescriptionCompatApi21.getMediaId(r6)
            r4.setMediaId(r0)
            java.lang.CharSequence r0 = android.support.p016v4.media.MediaDescriptionCompatApi21.getTitle(r6)
            r4.setTitle(r0)
            java.lang.CharSequence r0 = android.support.p016v4.media.MediaDescriptionCompatApi21.getSubtitle(r6)
            r4.setSubtitle(r0)
            java.lang.CharSequence r0 = android.support.p016v4.media.MediaDescriptionCompatApi21.getDescription(r6)
            r4.setDescription(r0)
            android.graphics.Bitmap r0 = android.support.p016v4.media.MediaDescriptionCompatApi21.getIconBitmap(r6)
            r4.setIconBitmap(r0)
            android.net.Uri r0 = android.support.p016v4.media.MediaDescriptionCompatApi21.getIconUri(r6)
            r4.setIconUri(r0)
            android.os.Bundle r2 = android.support.p016v4.media.MediaDescriptionCompatApi21.getExtras(r6)
            if (r2 != 0) goto L_0x0061
            r3 = r1
        L_0x0040:
            if (r3 == 0) goto L_0x0075
            java.lang.String r0 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r0 = r2.containsKey(r0)
            if (r0 == 0) goto L_0x006b
            int r0 = r2.size()
            r5 = 2
            if (r0 != r5) goto L_0x006b
            r0 = r1
        L_0x0052:
            r4.setExtras(r0)
            if (r3 == 0) goto L_0x0077
            r4.setMediaUri(r3)
        L_0x005a:
            android.support.v4.media.MediaDescriptionCompat r1 = r4.build()
            r1.mDescriptionObj = r6
            goto L_0x0009
        L_0x0061:
            java.lang.String r0 = "android.support.v4.media.description.MEDIA_URI"
            android.os.Parcelable r0 = r2.getParcelable(r0)
            android.net.Uri r0 = (android.net.Uri) r0
            r3 = r0
            goto L_0x0040
        L_0x006b:
            java.lang.String r0 = "android.support.v4.media.description.MEDIA_URI"
            r2.remove(r0)
            java.lang.String r0 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            r2.remove(r0)
        L_0x0075:
            r0 = r2
            goto L_0x0052
        L_0x0077:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 < r1) goto L_0x005a
            android.net.Uri r0 = android.support.p016v4.media.MediaDescriptionCompatApi23.getMediaUri(r6)
            r4.setMediaUri(r0)
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p016v4.media.MediaDescriptionCompat.fromMediaDescription(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$Builder */
    public static final class Builder {
        private CharSequence mDescription;
        private Bundle mExtras;
        private Bitmap mIcon;
        private Uri mIconUri;
        private String mMediaId;
        private Uri mMediaUri;
        private CharSequence mSubtitle;
        private CharSequence mTitle;

        public Builder setMediaId(String str) {
            this.mMediaId = str;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }

        public Builder setSubtitle(CharSequence charSequence) {
            this.mSubtitle = charSequence;
            return this;
        }

        public Builder setDescription(CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public Builder setIconBitmap(Bitmap bitmap) {
            this.mIcon = bitmap;
            return this;
        }

        public Builder setIconUri(Uri uri) {
            this.mIconUri = uri;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public Builder setMediaUri(Uri uri) {
            this.mMediaUri = uri;
            return this;
        }

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
        }
    }
}