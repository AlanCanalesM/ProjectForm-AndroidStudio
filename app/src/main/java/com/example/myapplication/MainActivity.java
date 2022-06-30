package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etusuario, etpass;
    Button btnacceso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etusuario=(EditText)findViewById(R.id.etuser);
        etpass=(EditText)findViewById(R.id.etpwss);
        btnacceso=(Button)findViewById(R.id.btnaccee);


    }

    public void acceso(View view) {
        entrar();
    }

    private void entrar() {
        String usuario="Alan";
        String contrasena="021117";

        if (etusuario.getText().toString().equals(usuario)&&etpass.getText().toString().equals(contrasena)){
            Intent intent= new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra("nom_usu", etusuario.getText().toString());
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Binvenido", Toast.LENGTH_SHORT).show();
        }
        else {

            Toast.makeText(getApplicationContext(), "El usuario o la contraseña son incorrectos", Toast.LENGTH_SHORT).show();
        }

    }
}
