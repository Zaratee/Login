package com.example.usuario.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registrar extends AppCompatActivity {

    EditText campoUsuario, campoContra;
    Button Registrar;
    TextView txtvUsuario, txtvContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        campoUsuario = (EditText) findViewById(R.id.etxt_usuarioRegis);
        campoContra = (EditText) findViewById(R.id.etxt_contraRegis);
        Registrar = (Button) findViewById(R.id.btn_register2);
        txtvUsuario = (TextView) findViewById(R.id.txtV_nombre);
        txtvContra = (TextView)findViewById(R.id.txtV_contra);

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initt();
                guardarPreferencias();
            }
        });
        cargarPreferencias();
    }


    public void initt() {

        Intent init1 = new Intent(Registrar.this, MainActivity.class);
        startActivity(init1);
    }

    public void guardarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String usuario = campoUsuario.getText().toString();
        String contra = campoContra.getText().toString();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("User " , usuario);
            editor.putString("Password ", contra);
            txtvUsuario.setText(usuario);
            txtvContra.setText(contra);
            editor.commit();

    }
    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String user = preferences.getString("User", "No Exite informacion");
        String pass = preferences.getString("Password", "No Exite informacion");
    }
}
