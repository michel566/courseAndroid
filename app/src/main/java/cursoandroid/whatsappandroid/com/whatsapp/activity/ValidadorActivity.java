package cursoandroid.whatsappandroid.com.whatsapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import cursoandroid.whatsappandroid.com.whatsapp.R;
import cursoandroid.whatsappandroid.com.whatsapp.activity.utils.Util;

public class ValidadorActivity extends AppCompatActivity {

    private EditText codValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validador);

        codValidator = findViewById(R.id.ed_validator_number);

        Util.formatString("NNNNNN", codValidator);

    }

}
