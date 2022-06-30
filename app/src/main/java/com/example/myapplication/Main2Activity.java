package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button btn1;
    TextView tvnom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn1=(Button)findViewById(R.id.btn1);
        tvnom=(TextView)findViewById(R.id.tvnom);
        Bundle bundle=getIntent().getExtras();
      String nombre=bundle.getString("nom_usu").toString();
      tvnom.setText("Bienvenido: "+nombre);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "1° Semestre", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
