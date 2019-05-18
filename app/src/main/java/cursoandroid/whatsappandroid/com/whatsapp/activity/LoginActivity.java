package cursoandroid.whatsappandroid.com.whatsapp.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cursoandroid.whatsappandroid.com.whatsapp.R;
import cursoandroid.whatsappandroid.com.whatsapp.activity.utils.Util;
import cursoandroid.whatsappandroid.com.whatsapp.helper.Permissao;
import cursoandroid.whatsappandroid.com.whatsapp.helper.Preferencias;

public class LoginActivity extends AppCompatActivity {

    private EditText nome;
    private EditText ddi;
    private EditText ddd;
    private EditText phone;
    private Button submit;
    private String[] permissoesNecessarias = new String[]{
            Manifest.permission.SEND_SMS,
            Manifest.permission.INTERNET
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Permissao.validaPermissoes(1,this, permissoesNecessarias);

        nome = findViewById(R.id.ed_login_name);

        phone = findViewById(R.id.ed_login_phone);
        Util.formatString("NNNNN-NNNN", phone);

        ddi = findViewById(R.id.ed_login_ddi);
        Util.formatString("+NN", ddi);

        ddd = findViewById(R.id.ed_login_ddd);
        Util.formatString("NN", ddd);

        submit = findViewById(R.id.bt_login_signUp);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeUsuario = nome.getText().toString();
                String telefoneCompleto =
                        ddi.getText().toString() +
                                ddd.getText().toString() +
                                phone.getText().toString();

                String telefoneSemFormatacao = telefoneCompleto.replace("+", "");
                telefoneSemFormatacao = telefoneSemFormatacao.replace("-", "");

                //Salvar os dados para validação
                String token = Util.tokenGenerate();
                Preferencias preferencias = new Preferencias(LoginActivity.this);
                preferencias.salvarUsuarioPreferencias(nomeUsuario, telefoneSemFormatacao, token);

                //Envio do SMS (+5521995579636)

                String mensagemEnvio = "WhatApp Código de Confirmação: " + token;

                //Somente para teste com emulador, descomente essa linha abaixo:
                telefoneSemFormatacao = "5554";
                boolean enviadoSMS = enviaSMS("+" + telefoneSemFormatacao, token);

                /*
                HashMap<String, String> usuario = preferencias.getDadosUsuario();
                Log.i("TOKEN", "T:" + usuario.get("token"));
                Log.i("NOME", "T:" + usuario.get("nome"));
                Log.i("TELEFONE", "T:" + usuario.get("telefone"));
                */
            }
        });

    }

    //Envio do SMS
    private boolean enviaSMS(String telefone, String mensagem) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(telefone, null, mensagem, null, null);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        for(int resultado : grantResults){
            if(resultado == PackageManager.PERMISSION_DENIED){
                alertaValidacaoPermissao();
            }
        }
    }

    private void alertaValidacaoPermissao() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões negadas");
        builder.setMessage("Para utulizar esse app, é necessário aceitar as permissões");

        builder.setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
