package android.support.p019v7.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p016v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.p016v4.app.NotificationCompat;
import android.support.p016v4.app.NotificationCompatBase;
import android.support.p019v7.appcompat.C0555R;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.app.NotificationCompatImplBase */
class NotificationCompatImplBase {
    private static final int MAX_ACTION_BUTTONS = 3;
    static final int MAX_MEDIA_BUTTONS = 5;
    static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;

    NotificationCompatImplBase() {
    }

    public static <T extends NotificationCompatBase.Action> RemoteViews overrideContentViewMedia(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent, boolean z3) {
        RemoteViews generateContentViewMedia = generateContentViewMedia(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, i2, list, iArr, z2, pendingIntent, z3);
        notificationBuilderWithBuilderAccessor.getBuilder().setContent(generateContentViewMedia);
        if (z2) {
            notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
        }
        return generateContentViewMedia;
    }

    private static <T extends NotificationCompatBase.Action> RemoteViews generateContentViewMedia(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent, boolean z3) {
        int min;
        RemoteViews applyStandardTemplate = applyStandardTemplate(context, charSequence, charSequence2, charSequence3, i, 0, bitmap, charSequence4, z, j, i2, 0, z3 ? C0555R.layout.notification_template_media_custom : C0555R.layout.notification_template_media, true);
        int size = list.size();
        if (iArr == null) {
            min = 0;
        } else {
            min = Math.min(iArr.length, 3);
        }
        applyStandardTemplate.removeAllViews(C0555R.C0557id.media_actions);
        if (min > 0) {
            for (int i3 = 0; i3 < min; i3++) {
                if (i3 >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i3), Integer.valueOf(size - 1)}));
                }
                applyStandardTemplate.addView(C0555R.C0557id.media_actions, generateMediaActionButton(context, (NotificationCompatBase.Action) list.get(iArr[i3])));
            }
        }
        if (z2) {
            applyStandardTemplate.setViewVisibility(C0555R.C0557id.end_padder, 8);
            applyStandardTemplate.setViewVisibility(C0555R.C0557id.cancel_action, 0);
            applyStandardTemplate.setOnClickPendingIntent(C0555R.C0557id.cancel_action, pendingIntent);
            applyStandardTemplate.setInt(C0555R.C0557id.cancel_action, "setAlpha", context.getResources().getInteger(C0555R.integer.cancel_button_image_alpha));
        } else {
            applyStandardTemplate.setViewVisibility(C0555R.C0557id.end_padder, 0);
            applyStandardTemplate.setViewVisibility(C0555R.C0557id.cancel_action, 8);
        }
        return applyStandardTemplate;
    }

    public static <T extends NotificationCompatBase.Action> void overrideMediaBigContentView(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, int i3, List<T> list, boolean z2, PendingIntent pendingIntent, boolean z3) {
        notification.bigContentView = generateMediaBigView(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, i2, i3, list, z2, pendingIntent, z3);
        if (z2) {
            notification.flags |= 2;
        }
    }

    public static <T extends NotificationCompatBase.Action> RemoteViews generateMediaBigView(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, int i3, List<T> list, boolean z2, PendingIntent pendingIntent, boolean z3) {
        int min = Math.min(list.size(), 5);
        RemoteViews applyStandardTemplate = applyStandardTemplate(context, charSequence, charSequence2, charSequence3, i, 0, bitmap, charSequence4, z, j, i2, i3, getBigMediaLayoutResource(z3, min), false);
        applyStandardTemplate.removeAllViews(C0555R.C0557id.media_actions);
        if (min > 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= min) {
                    break;
                }
                applyStandardTemplate.addView(C0555R.C0557id.media_actions, generateMediaActionButton(context, (NotificationCompatBase.Action) list.get(i5)));
                i4 = i5 + 1;
            }
        }
        if (z2) {
            applyStandardTemplate.setViewVisibility(C0555R.C0557id.cancel_action, 0);
            applyStandardTemplate.setInt(C0555R.C0557id.cancel_action, "setAlpha", context.getResources().getInteger(C0555R.integer.cancel_button_image_alpha));
            applyStandardTemplate.setOnClickPendingIntent(C0555R.C0557id.cancel_action, pendingIntent);
        } else {
            applyStandardTemplate.setViewVisibility(C0555R.C0557id.cancel_action, 8);
        }
        return applyStandardTemplate;
    }

    private static RemoteViews generateMediaActionButton(Context context, NotificationCompatBase.Action action) {
        boolean z = action.getActionIntent() == null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C0555R.layout.notification_media_action);
        remoteViews.setImageViewResource(C0555R.C0557id.action0, action.getIcon());
        if (!z) {
            remoteViews.setOnClickPendingIntent(C0555R.C0557id.action0, action.getActionIntent());
        }
        if (Build.VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(C0555R.C0557id.action0, action.getTitle());
        }
        return remoteViews;
    }

    private static int getBigMediaLayoutResource(boolean z, int i) {
        return i <= 3 ? z ? C0555R.layout.notification_template_big_media_narrow_custom : C0555R.layout.notification_template_big_media_narrow : z ? C0555R.layout.notification_template_big_media_custom : C0555R.layout.notification_template_big_media;
    }

    public static RemoteViews applyStandardTemplateWithActions(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, int i2, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i3, int i4, int i5, boolean z2, ArrayList<NotificationCompat.Action> arrayList) {
        boolean z3;
        int size;
        int i6;
        RemoteViews applyStandardTemplate = applyStandardTemplate(context, charSequence, charSequence2, charSequence3, i, i2, bitmap, charSequence4, z, j, i3, i4, i5, z2);
        applyStandardTemplate.removeAllViews(C0555R.C0557id.actions);
        if (arrayList == null || (size = arrayList.size()) <= 0) {
            z3 = false;
        } else {
            if (size > 3) {
                i6 = 3;
            } else {
                i6 = size;
            }
            for (int i7 = 0; i7 < i6; i7++) {
                applyStandardTemplate.addView(C0555R.C0557id.actions, generateActionButton(context, arrayList.get(i7)));
            }
            z3 = true;
        }
        int i8 = z3 ? 0 : 8;
        applyStandardTemplate.setViewVisibility(C0555R.C0557id.actions, i8);
        applyStandardTemplate.setViewVisibility(C0555R.C0557id.action_divider, i8);
        return applyStandardTemplate;
    }

    private static RemoteViews generateActionButton(Context context, NotificationCompat.Action action) {
        int actionLayoutResource;
        boolean z = action.actionIntent == null;
        String packageName = context.getPackageName();
        if (z) {
            actionLayoutResource = getActionTombstoneLayoutResource();
        } else {
            actionLayoutResource = getActionLayoutResource();
        }
        RemoteViews remoteViews = new RemoteViews(packageName, actionLayoutResource);
        remoteViews.setImageViewBitmap(C0555R.C0557id.action_image, createColoredBitmap(context, action.getIcon(), context.getResources().getColor(C0555R.color.notification_action_color_filter)));
        remoteViews.setTextViewText(C0555R.C0557id.action_text, action.title);
        if (!z) {
            remoteViews.setOnClickPendingIntent(C0555R.C0557id.action_container, action.actionIntent);
        }
        remoteViews.setContentDescription(C0555R.C0557id.action_container, action.title);
        return remoteViews;
    }

    private static Bitmap createColoredBitmap(Context context, int i, int i2) {
        return createColoredBitmap(context, i, i2, 0);
    }

    private static Bitmap createColoredBitmap(Context context, int i, int i2, int i3) {
        Drawable drawable = context.getResources().getDrawable(i);
        int intrinsicWidth = i3 == 0 ? drawable.getIntrinsicWidth() : i3;
        if (i3 == 0) {
            i3 = drawable.getIntrinsicHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i3, Bitmap.Config.ARGB_8888);
        drawable.setBounds(0, 0, intrinsicWidth, i3);
        if (i2 != 0) {
            drawable.mutate().setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
        }
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private static int getActionLayoutResource() {
        return C0555R.layout.notification_action;
    }

    private static int getActionTombstoneLayoutResource() {
        return C0555R.layout.notification_action_tombstone;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.widget.RemoteViews applyStandardTemplate(android.content.Context r13, java.lang.CharSequence r14, java.lang.CharSequence r15, java.lang.CharSequence r16, int r17, int r18, android.graphics.Bitmap r19, java.lang.CharSequence r20, boolean r21, long r22, int r24, int r25, int r26, boolean r27) {
        /*
            android.content.res.Resources r7 = r13.getResources()
            android.widget.RemoteViews r2 = new android.widget.RemoteViews
            java.lang.String r3 = r13.getPackageName()
            r0 = r26
            r2.<init>(r3, r0)
            r6 = 0
            r5 = 0
            r3 = -1
            r0 = r24
            if (r0 >= r3) goto L_0x010d
            r3 = 1
        L_0x0017:
            int r4 = android.os.Build.VERSION.SDK_INT
            r8 = 16
            if (r4 < r8) goto L_0x0110
            r4 = 1
            r8 = r4
        L_0x001f:
            int r4 = android.os.Build.VERSION.SDK_INT
            r9 = 21
            if (r4 < r9) goto L_0x0114
            r4 = 1
        L_0x0026:
            if (r8 == 0) goto L_0x003e
            if (r4 != 0) goto L_0x003e
            if (r3 == 0) goto L_0x0117
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.notification_background
            java.lang.String r9 = "setBackgroundResource"
            int r10 = android.support.p019v7.appcompat.C0555R.C0556drawable.notification_bg_low
            r2.setInt(r3, r9, r10)
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.icon
            java.lang.String r9 = "setBackgroundResource"
            int r10 = android.support.p019v7.appcompat.C0555R.C0556drawable.notification_template_icon_low_bg
            r2.setInt(r3, r9, r10)
        L_0x003e:
            if (r19 == 0) goto L_0x0142
            if (r8 == 0) goto L_0x012b
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.icon
            r9 = 0
            r2.setViewVisibility(r3, r9)
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.icon
            r0 = r19
            r2.setImageViewBitmap(r3, r0)
        L_0x004f:
            if (r18 == 0) goto L_0x0076
            int r3 = android.support.p019v7.appcompat.C0555R.dimen.notification_right_icon_size
            int r3 = r7.getDimensionPixelSize(r3)
            int r9 = android.support.p019v7.appcompat.C0555R.dimen.notification_small_icon_background_padding
            int r9 = r7.getDimensionPixelSize(r9)
            int r9 = r9 * 2
            int r9 = r3 - r9
            if (r4 == 0) goto L_0x0134
            r0 = r18
            r1 = r25
            android.graphics.Bitmap r3 = createIconWithBackground(r13, r0, r3, r9, r1)
            int r9 = android.support.p019v7.appcompat.C0555R.C0557id.right_icon
            r2.setImageViewBitmap(r9, r3)
        L_0x0070:
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.right_icon
            r9 = 0
            r2.setViewVisibility(r3, r9)
        L_0x0076:
            if (r14 == 0) goto L_0x007d
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.title
            r2.setTextViewText(r3, r14)
        L_0x007d:
            if (r15 == 0) goto L_0x01e2
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.text
            r2.setTextViewText(r3, r15)
            r3 = 1
        L_0x0085:
            if (r4 != 0) goto L_0x017c
            if (r19 == 0) goto L_0x017c
            r9 = 1
        L_0x008a:
            if (r16 == 0) goto L_0x017f
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.info
            r0 = r16
            r2.setTextViewText(r3, r0)
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.info
            r4 = 0
            r2.setViewVisibility(r3, r4)
            r3 = 1
            r9 = 1
            r10 = r3
        L_0x009c:
            if (r20 == 0) goto L_0x01c3
            if (r8 == 0) goto L_0x01c3
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.text
            r0 = r20
            r2.setTextViewText(r3, r0)
            if (r15 == 0) goto L_0x01bc
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.text2
            r2.setTextViewText(r3, r15)
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.text2
            r4 = 0
            r2.setViewVisibility(r3, r4)
            r3 = 1
        L_0x00b5:
            if (r3 == 0) goto L_0x00d1
            if (r8 == 0) goto L_0x00d1
            if (r27 == 0) goto L_0x00c8
            int r3 = android.support.p019v7.appcompat.C0555R.dimen.notification_subtext_size
            int r3 = r7.getDimensionPixelSize(r3)
            float r3 = (float) r3
            int r4 = android.support.p019v7.appcompat.C0555R.C0557id.text
            r5 = 0
            r2.setTextViewTextSize(r4, r5, r3)
        L_0x00c8:
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.line1
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r2.setViewPadding(r3, r4, r5, r6, r7)
        L_0x00d1:
            r4 = 0
            int r3 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x01df
            if (r21 == 0) goto L_0x01c6
            if (r8 == 0) goto L_0x01c6
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.chronometer
            r4 = 0
            r2.setViewVisibility(r3, r4)
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.chronometer
            java.lang.String r4 = "setBase"
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r8 = java.lang.System.currentTimeMillis()
            long r6 = r6 - r8
            long r6 = r6 + r22
            r2.setLong(r3, r4, r6)
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.chronometer
            java.lang.String r4 = "setStarted"
            r5 = 1
            r2.setBoolean(r3, r4, r5)
        L_0x00fb:
            r3 = 1
        L_0x00fc:
            int r4 = android.support.p019v7.appcompat.C0555R.C0557id.right_side
            if (r3 == 0) goto L_0x01d7
            r3 = 0
        L_0x0101:
            r2.setViewVisibility(r4, r3)
            int r4 = android.support.p019v7.appcompat.C0555R.C0557id.line3
            if (r10 == 0) goto L_0x01db
            r3 = 0
        L_0x0109:
            r2.setViewVisibility(r4, r3)
            return r2
        L_0x010d:
            r3 = 0
            goto L_0x0017
        L_0x0110:
            r4 = 0
            r8 = r4
            goto L_0x001f
        L_0x0114:
            r4 = 0
            goto L_0x0026
        L_0x0117:
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.notification_background
            java.lang.String r9 = "setBackgroundResource"
            int r10 = android.support.p019v7.appcompat.C0555R.C0556drawable.notification_bg
            r2.setInt(r3, r9, r10)
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.icon
            java.lang.String r9 = "setBackgroundResource"
            int r10 = android.support.p019v7.appcompat.C0555R.C0556drawable.notification_template_icon_bg
            r2.setInt(r3, r9, r10)
            goto L_0x003e
        L_0x012b:
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.icon
            r9 = 8
            r2.setViewVisibility(r3, r9)
            goto L_0x004f
        L_0x0134:
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.right_icon
            r9 = -1
            r0 = r18
            android.graphics.Bitmap r9 = createColoredBitmap(r13, r0, r9)
            r2.setImageViewBitmap(r3, r9)
            goto L_0x0070
        L_0x0142:
            if (r18 == 0) goto L_0x0076
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.icon
            r9 = 0
            r2.setViewVisibility(r3, r9)
            if (r4 == 0) goto L_0x016e
            int r3 = android.support.p019v7.appcompat.C0555R.dimen.notification_large_icon_width
            int r3 = r7.getDimensionPixelSize(r3)
            int r9 = android.support.p019v7.appcompat.C0555R.dimen.notification_big_circle_margin
            int r9 = r7.getDimensionPixelSize(r9)
            int r3 = r3 - r9
            int r9 = android.support.p019v7.appcompat.C0555R.dimen.notification_small_icon_size_as_large
            int r9 = r7.getDimensionPixelSize(r9)
            r0 = r18
            r1 = r25
            android.graphics.Bitmap r3 = createIconWithBackground(r13, r0, r3, r9, r1)
            int r9 = android.support.p019v7.appcompat.C0555R.C0557id.icon
            r2.setImageViewBitmap(r9, r3)
            goto L_0x0076
        L_0x016e:
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.icon
            r9 = -1
            r0 = r18
            android.graphics.Bitmap r9 = createColoredBitmap(r13, r0, r9)
            r2.setImageViewBitmap(r3, r9)
            goto L_0x0076
        L_0x017c:
            r9 = 0
            goto L_0x008a
        L_0x017f:
            if (r17 <= 0) goto L_0x01b2
            int r3 = android.support.p019v7.appcompat.C0555R.integer.status_bar_notification_info_maxnum
            int r3 = r7.getInteger(r3)
            r0 = r17
            if (r0 <= r3) goto L_0x01a1
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.info
            int r4 = android.support.p019v7.appcompat.C0555R.string.status_bar_notification_info_overflow
            java.lang.String r4 = r7.getString(r4)
            r2.setTextViewText(r3, r4)
        L_0x0196:
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.info
            r4 = 0
            r2.setViewVisibility(r3, r4)
            r3 = 1
            r9 = 1
            r10 = r3
            goto L_0x009c
        L_0x01a1:
            java.text.NumberFormat r3 = java.text.NumberFormat.getIntegerInstance()
            int r4 = android.support.p019v7.appcompat.C0555R.C0557id.info
            r0 = r17
            long r10 = (long) r0
            java.lang.String r3 = r3.format(r10)
            r2.setTextViewText(r4, r3)
            goto L_0x0196
        L_0x01b2:
            int r4 = android.support.p019v7.appcompat.C0555R.C0557id.info
            r6 = 8
            r2.setViewVisibility(r4, r6)
            r10 = r3
            goto L_0x009c
        L_0x01bc:
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.text2
            r4 = 8
            r2.setViewVisibility(r3, r4)
        L_0x01c3:
            r3 = r5
            goto L_0x00b5
        L_0x01c6:
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.time
            r4 = 0
            r2.setViewVisibility(r3, r4)
            int r3 = android.support.p019v7.appcompat.C0555R.C0557id.time
            java.lang.String r4 = "setTime"
            r0 = r22
            r2.setLong(r3, r4, r0)
            goto L_0x00fb
        L_0x01d7:
            r3 = 8
            goto L_0x0101
        L_0x01db:
            r3 = 8
            goto L_0x0109
        L_0x01df:
            r3 = r9
            goto L_0x00fc
        L_0x01e2:
            r3 = r6
            goto L_0x0085
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p019v7.app.NotificationCompatImplBase.applyStandardTemplate(android.content.Context, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, int, int, android.graphics.Bitmap, java.lang.CharSequence, boolean, long, int, int, int, boolean):android.widget.RemoteViews");
    }

    public static Bitmap createIconWithBackground(Context context, int i, int i2, int i3, int i4) {
        int i5 = C0555R.C0556drawable.notification_icon_background;
        if (i4 == 0) {
            i4 = 0;
        }
        Bitmap createColoredBitmap = createColoredBitmap(context, i5, i4, i2);
        Canvas canvas = new Canvas(createColoredBitmap);
        Drawable mutate = context.getResources().getDrawable(i).mutate();
        mutate.setFilterBitmap(true);
        int i6 = (i2 - i3) / 2;
        mutate.setBounds(i6, i6, i3 + i6, i3 + i6);
        mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        mutate.draw(canvas);
        return createColoredBitmap;
    }

    public static void buildIntoRemoteViews(Context context, RemoteViews remoteViews, RemoteViews remoteViews2) {
        hideNormalContent(remoteViews);
        remoteViews.removeAllViews(C0555R.C0557id.notification_main_column);
        remoteViews.addView(C0555R.C0557id.notification_main_column, remoteViews2.clone());
        remoteViews.setViewVisibility(C0555R.C0557id.notification_main_column, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            remoteViews.setViewPadding(C0555R.C0557id.notification_main_column_container, 0, calculateTopPadding(context), 0, 0);
        }
    }

    private static void hideNormalContent(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(C0555R.C0557id.title, 8);
        remoteViews.setViewVisibility(C0555R.C0557id.text2, 8);
        remoteViews.setViewVisibility(C0555R.C0557id.text, 8);
    }

    public static int calculateTopPadding(Context context) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C0555R.dimen.notification_top_pad);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(C0555R.dimen.notification_top_pad_large_text);
        float constrain = (constrain(context.getResources().getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
        return Math.round((((float) dimensionPixelSize) * (1.0f - constrain)) + (((float) dimensionPixelSize2) * constrain));
    }

    public static float constrain(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }
}
