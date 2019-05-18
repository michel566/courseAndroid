package cursoandroid.whatsappandroid.com.whatsapp.activity.utils;

import android.util.Log;
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.Random;

public class Util {

    public static void formatString(String mask, TextView textView) {
        SimpleMaskFormatter simpleMaskPhone = new SimpleMaskFormatter(mask);
        MaskTextWatcher maskPhone = new MaskTextWatcher(textView, simpleMaskPhone);
        textView.addTextChangedListener(maskPhone);
    }

    public static String tokenGenerate() {
        Random randomico = new Random();
        int numeroRandomico = randomico.nextInt(9999 - 1000) + 1000;
        String token = String.valueOf(numeroRandomico);
       // Log.i("TOKEN", "T:" + token);
        return token;
    }

}
