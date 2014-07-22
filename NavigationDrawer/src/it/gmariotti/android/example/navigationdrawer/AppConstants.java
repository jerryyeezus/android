package it.gmariotti.android.example.navigationdrawer;

/**
 * Created by jeyee on 7/22/14.
 */

import android.content.Context;
import android.graphics.Typeface;

public class AppConstants {

    public static final String FRAGMENT_TRANSACTION_ROOT = "com.cisco.cox.pve.hub.HubFragment";

    /**
     * The slope of the skew used throughout the app.
     */
    public static final float SLOPE = 3.83f;

    /**
     * The amount of SKEW in the X direction.
     */
    public static final float SKEWX = -1 / SLOPE;

    private static Typeface AvenirNextLtPro_Demi;
    private static Typeface AvenirNextLTPro_Regular;
    private static Typeface AvenirNextLtPro_UltLt;
    private static Typeface cc_casual;
    private static Typeface cc_cursive;
    private static Typeface cc_sans_mono;
    private static Typeface cc_sans_prop;
    private static Typeface cc_serif_mono;
    private static Typeface cc_serif_prop;
    private static Typeface cc_small_caps;

    public static Typeface AvenirNextLtPro_Demi(Context context) {
        if (AvenirNextLtPro_Demi != null) {
            return AvenirNextLtPro_Demi;
        } else {
            AvenirNextLtPro_Demi = Typeface.createFromAsset(
                    context.getAssets(), "fonts/AvenirNextLTPro-Demi-20.ttf");
            return AvenirNextLtPro_Demi;
        }
    }

    public static Typeface AvenirNextLTPro_Regular(Context context) {
        if (AvenirNextLTPro_Regular != null) {
            return AvenirNextLTPro_Regular;
        } else {
            AvenirNextLTPro_Regular = Typeface.createFromAsset(
                    context.getAssets(), "fonts/AvenirNextLTPro-Regular.ttf");
            return AvenirNextLTPro_Regular;
        }
    }

    public static Typeface AvenirNextLTPro_UltLt(Context context) {
        if (AvenirNextLTPro_Regular != null) {
            return AvenirNextLtPro_UltLt;
        } else {
            AvenirNextLtPro_UltLt = Typeface.createFromAsset(
                    context.getAssets(), "fonts/AvenirNextLTPro-UltLt.ttf");
            return AvenirNextLtPro_UltLt;
        }
    }

    public static Typeface CC_Casual(Context context) {
        if (cc_casual != null) {
            return cc_casual;
        } else {
            cc_casual = Typeface.createFromAsset(
                    context.getAssets(), "fonts/cc_casual.ttf");
            return cc_casual;
        }
    }

    public static Typeface CC_Cursive(Context context) {
        if (cc_cursive != null) {
            return cc_cursive;
        } else {
            cc_cursive = Typeface.createFromAsset(
                    context.getAssets(), "fonts/cc_cursive.ttf");
            return cc_cursive;
        }
    }

    public static Typeface CC_Sans_Mono(Context context) {
        if (cc_sans_mono != null) {
            return cc_sans_mono;
        } else {
            cc_sans_mono = Typeface.createFromAsset(
                    context.getAssets(), "fonts/cc_sans_mono.ttf");
            return cc_sans_mono;
        }
    }

    public static Typeface CC_Sans_Prop(Context context) {
        if (cc_sans_prop != null) {
            return cc_sans_prop;
        } else {
            cc_sans_prop = Typeface.createFromAsset(
                    context.getAssets(), "fonts/cc_sans_prop.ttf");
            return cc_sans_prop;
        }
    }

    public static Typeface CC_Serif_Mono(Context context) {
        if (cc_serif_mono != null) {
            return cc_serif_mono;
        } else {
            cc_serif_mono = Typeface.createFromAsset(
                    context.getAssets(), "fonts/cc_serif_mono.ttf");
            return cc_serif_mono;
        }
    }

    public static Typeface CC_Serif_Prop(Context context) {
        if (cc_serif_prop != null) {
            return cc_serif_prop;
        } else {
            cc_serif_prop = Typeface.createFromAsset(
                    context.getAssets(), "fonts/cc_serif_prop.ttf");
            return cc_serif_prop;
        }
    }

    public static Typeface CC_Small_Caps(Context context) {
        if (cc_small_caps != null) {
            return cc_small_caps;
        } else {
            cc_small_caps = Typeface.createFromAsset(
                    context.getAssets(), "fonts/cc_small_caps.ttf");
            return cc_small_caps;
        }
    }
}
