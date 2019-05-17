package cursoandroid.whatsappandroid.com.whatsapp.activity.utils;

import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class Util {

    public static void formatString(String mask, TextView textView){
        SimpleMaskFormatter simpleMaskPhone = new SimpleMaskFormatter(mask);
        MaskTextWatcher maskPhone = new MaskTextWatcher(textView, simpleMaskPhone);
        textView.addTextChangedListener(maskPhone);
    }

}
