package a5dots.com.aboutme;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * Created by alexscrobot on 30.01.18.
 */

public class CharHolder {

    private @DrawableRes int img;
    private @StringRes int title;

    public CharHolder(@DrawableRes int img, @StringRes int title) {
        this.img = img;
        this.title = title;
    }
}
