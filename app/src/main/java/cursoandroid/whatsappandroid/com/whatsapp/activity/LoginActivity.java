package cursoandroid.whatsappandroid.com.whatsapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import cursoandroid.whatsappandroid.com.whatsapp.R;
import cursoandroid.whatsappandroid.com.whatsapp.activity.utils.Util;

public class LoginActivity extends AppCompatActivity {

    private EditText nome;
    private EditText ddi;
    private EditText ddd;
    private EditText phone;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phone = findViewById(R.id.ed_login_phone);
        Util.formatString("NNNNN-NNNN", phone);

        ddi = findViewById(R.id.ed_login_ddi);
        Util.formatString("+NN", ddi);

        ddd = findViewById(R.id.ed_login_ddd);
        Util.formatString("NN", ddd);

    }
}
