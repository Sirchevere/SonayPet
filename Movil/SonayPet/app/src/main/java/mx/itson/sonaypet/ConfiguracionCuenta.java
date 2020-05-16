package mx.itson.sonaypet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfiguracionCuenta extends AppCompatActivity {
Button btnDatosPersonales,btnContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_cuenta);

        btnDatosPersonales = findViewById(R.id.btnDatosPersonales);
        btnContrasena = findViewById(R.id.btnContrasena);

        btnDatosPersonales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CambiarDatos.class);
                startActivity(intent);
            }
        });

        btnContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CambiarContrasena.class);
                startActivity(intent);
            }
        });
    }
}
