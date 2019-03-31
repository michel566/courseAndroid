package cursoandroid.whatsappandroid.com.whatsapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Random;

import cursoandroid.whatsappandroid.com.whatsapp.R;
import cursoandroid.whatsappandroid.com.whatsapp.helper.Preferencias;
import utils.Util;

public class LoginActivity extends AppCompatActivity {

    private EditText edNome;
    private EditText edDDI;
    private EditText edDDD;
    private EditText edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edNome = findViewById(R.id.ed_login_name);

        edDDI = findViewById(R.id.ed_login_ddi);
        Util.tvMaskFormatter(edDDI, "+NNN");
        edDDD = findViewById(R.id.ed_login_ddd);
        Util.tvMaskFormatter(edDDD, "NN");
        edPhone = findViewById(R.id.ed_login_phone);
        Util.tvMaskFormatter(edPhone, "NNNNN-NNNN");

        Button btCadastrar = findViewById(R.id.bt_login_signUp);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeUsuario = edNome.getText().toString();
                String telefoneCompleto = edDDI.getText().toString() + edDDD.getText().toString() + edPhone.getText().toString();

                String telefoneSemFormatacao = telefoneCompleto.replace("+", "");
                telefoneSemFormatacao = telefoneSemFormatacao.replace("-","");

                //Gerar token
                Random randomico = new Random();
                int numeroRandomico = randomico.nextInt(9999 - 1000) + 1000;
                String token = String.valueOf(numeroRandomico);

                //salvar os dados para validacao
                Preferencias preferencias = new Preferencias(LoginActivity.this);
                preferencias.salvarUsuarioPreferencias(nomeUsuario, telefoneSemFormatacao, token);

                HashMap<String, String> usuario = preferencias.getDadosUsuario();
                Log.i("TELEFONE", "T: " + usuario.get("telefone"));
                Log.i("TOKEN", "T: " + usuario.get("token"));
                Log.i("NOME", "T: " + usuario.get("nome"));

            }
        });

    }

}
