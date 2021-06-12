package android.support.p016v4.text.util;

import android.support.p016v4.util.PatternsCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: android.support.v4.text.util.LinkifyCompat */
public final class LinkifyCompat {
    private static final Comparator<LinkSpec> COMPARATOR = new Comparator<LinkSpec>() {
        public final int compare(LinkSpec linkSpec, LinkSpec linkSpec2) {
            if (linkSpec.start < linkSpec2.start) {
                return -1;
            }
            if (linkSpec.start > linkSpec2.start) {
                return 1;
            }
            if (linkSpec.end < linkSpec2.end) {
                return 1;
            }
            if (linkSpec.end <= linkSpec2.end) {
                return 0;
            }
            return -1;
        }
    };
    private static final String[] EMPTY_STRING = new String[0];

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.text.util.LinkifyCompat$LinkifyMask */
    public @interface LinkifyMask {
    }

    public static final boolean addLinks(Spannable spannable, int i) {
        if (i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 1) != 0) {
            gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, (Linkify.TransformFilter) null);
        }
        if ((i & 2) != 0) {
            gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{"mailto:"}, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
        if ((i & 8) != 0) {
            gatherMapLinks(arrayList, spannable);
        }
        pruneOverlaps(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LinkSpec linkSpec = (LinkSpec) it.next();
            if (linkSpec.frameworkAddedSpan == null) {
                applyLink(linkSpec.url, linkSpec.start, linkSpec.end, spannable);
            }
        }
        return true;
    }

    public static final boolean addLinks(TextView textView, int i) {
        if (i == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (!(text instanceof Spannable)) {
            SpannableString valueOf = SpannableString.valueOf(text);
            if (!addLinks((Spannable) valueOf, i)) {
                return false;
            }
            addLinkMovementMethod(textView);
            textView.setText(valueOf);
            return true;
        } else if (!addLinks((Spannable) text, i)) {
            return false;
        } else {
            addLinkMovementMethod(textView);
            return true;
        }
    }

    public static final void addLinks(TextView textView, Pattern pattern, String str) {
        addLinks(textView, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static final void addLinks(TextView textView, Pattern pattern, String str, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        addLinks(textView, pattern, str, (String[]) null, matchFilter, transformFilter);
    }

    public static final void addLinks(TextView textView, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        SpannableString valueOf = SpannableString.valueOf(textView.getText());
        if (addLinks((Spannable) valueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(valueOf);
            addLinkMovementMethod(textView);
        }
    }

    public static final boolean addLinks(Spannable spannable, Pattern pattern, String str) {
        return addLinks(spannable, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static final boolean addLinks(Spannable spannable, Pattern pattern, String str, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        return addLinks(spannable, pattern, str, (String[]) null, matchFilter, transformFilter);
    }

    public static final boolean addLinks(Spannable spannable, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        boolean z;
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = EMPTY_STRING;
        }
        String[] strArr2 = new String[(strArr.length + 1)];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        for (int i = 0; i < strArr.length; i++) {
            String str2 = strArr[i];
            strArr2[i + 1] = str2 == null ? "" : str2.toLowerCase(Locale.ROOT);
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z2 = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter != null) {
                z = matchFilter.acceptMatch(spannable, start, end);
            } else {
                z = true;
            }
            if (z) {
                applyLink(makeUrl(matcher.group(0), strArr2, matcher, transformFilter), start, end, spannable);
                z2 = true;
            }
        }
        return z2;
    }

    private static void addLinkMovementMethod(TextView textView) {
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private static String makeUrl(String str, String[] strArr, Matcher matcher, Linkify.TransformFilter transformFilter) {
        String str2;
        boolean z = true;
        if (transformFilter != null) {
            str2 = transformFilter.transformUrl(matcher, str);
        } else {
            str2 = str;
        }
        int i = 0;
        while (true) {
            if (i >= strArr.length) {
                z = false;
                break;
            } else if (str2.regionMatches(true, 0, strArr[i], 0, strArr[i].length())) {
                if (!str2.regionMatches(false, 0, strArr[i], 0, strArr[i].length())) {
                    str2 = strArr[i] + str2.substring(strArr[i].length());
                }
            } else {
                i++;
            }
        }
        if (z || strArr.length <= 0) {
            return str2;
        }
        return strArr[0] + str2;
    }

    private static void gatherLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) {
                LinkSpec linkSpec = new LinkSpec();
                linkSpec.url = makeUrl(matcher.group(0), strArr, matcher, transformFilter);
                linkSpec.start = start;
                linkSpec.end = end;
                arrayList.add(linkSpec);
            }
        }
    }

    private static void applyLink(String str, int i, int i2, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i, i2, 33);
    }

    private static final void gatherMapLinks(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int indexOf;
        String obj = spannable.toString();
        int i = 0;
        while (true) {
            try {
                String findAddress = WebView.findAddress(obj);
                if (findAddress != null && (indexOf = obj.indexOf(findAddress)) >= 0) {
                    LinkSpec linkSpec = new LinkSpec();
                    int length = findAddress.length() + indexOf;
                    linkSpec.start = indexOf + i;
                    linkSpec.end = i + length;
                    obj = obj.substring(length);
                    i += length;
                    try {
                        linkSpec.url = "geo:0,0?q=" + URLEncoder.encode(findAddress, "UTF-8");
                        arrayList.add(linkSpec);
                    } catch (UnsupportedEncodingException e) {
                    }
                } else {
                    return;
                }
            } catch (UnsupportedOperationException e2) {
                return;
            }
        }
    }

    private static final void pruneOverlaps(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int i;
        int i2 = 0;
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int i3 = 0; i3 < uRLSpanArr.length; i3++) {
            LinkSpec linkSpec = new LinkSpec();
            linkSpec.frameworkAddedSpan = uRLSpanArr[i3];
            linkSpec.start = spannable.getSpanStart(uRLSpanArr[i3]);
            linkSpec.end = spannable.getSpanEnd(uRLSpanArr[i3]);
            arrayList.add(linkSpec);
        }
        Collections.sort(arrayList, COMPARATOR);
        int size = arrayList.size();
        while (i2 < size - 1) {
            LinkSpec linkSpec2 = arrayList.get(i2);
            LinkSpec linkSpec3 = arrayList.get(i2 + 1);
            if (linkSpec2.start <= linkSpec3.start && linkSpec2.end > linkSpec3.start) {
                if (linkSpec3.end <= linkSpec2.end) {
                    i = i2 + 1;
                } else if (linkSpec2.end - linkSpec2.start > linkSpec3.end - linkSpec3.start) {
                    i = i2 + 1;
                } else if (linkSpec2.end - linkSpec2.start < linkSpec3.end - linkSpec3.start) {
                    i = i2;
                } else {
                    i = -1;
                }
                if (i != -1) {
                    URLSpan uRLSpan = arrayList.get(i).frameworkAddedSpan;
                    if (uRLSpan != null) {
                        spannable.removeSpan(uRLSpan);
                    }
                    arrayList.remove(i);
                    size--;
                }
            }
            i2++;
        }
    }

    private LinkifyCompat() {
    }

    /* renamed from: android.support.v4.text.util.LinkifyCompat$LinkSpec */
    private static class LinkSpec {
        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;

        LinkSpec() {
        }
    }
}
