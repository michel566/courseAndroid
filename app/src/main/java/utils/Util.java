package utils;

import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class Util {

    public static void tvMaskFormatter(TextView textView, String mask) {
        SimpleMaskFormatter simpleMaskPhone = new SimpleMaskFormatter(mask);
        MaskTextWatcher maskPhone = new MaskTextWatcher(textView, simpleMaskPhone);
        textView.addTextChangedListener(maskPhone);
    }
}
