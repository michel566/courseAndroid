package cursoandroid.whatsappandroid.com.whatsapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import cursoandroid.whatsappandroid.com.whatsapp.R;
import cursoandroid.whatsappandroid.com.whatsapp.activity.utils.Util;
import cursoandroid.whatsappandroid.com.whatsapp.helper.Preferencias;

public class ValidadorActivity extends AppCompatActivity {

    private EditText codValidator;
    private Button validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validador);

        codValidator = findViewById(R.id.ed_validator_number);
        validar = findViewById(R.id.bt_validate);

        Util.formatString("NNNN", codValidator);
        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recuperar dados das preferências do usuário
                Preferencias preferencias = new Preferencias(ValidadorActivity.this);
                HashMap<String, String> usuario = preferencias.getDadosUsuario();

                String tokenGerado = usuario.get("token");
                String tokenDigitado = codValidator.getText().toString();

                if(tokenDigitado.equals(tokenGerado)){
                    Toast.makeText(ValidadorActivity.this, "Token VALIDADO", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(ValidadorActivity.this, "Token NÃO VALIDADO", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
