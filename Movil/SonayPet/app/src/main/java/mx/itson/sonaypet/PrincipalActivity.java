package mx.itson.sonaypet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {
    public static String mail;
    Button btnAgendar, btnAgregarMascota, btnConfiguracion;
    public static String ids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnAgendar=findViewById(R.id.btnAgendar);
        btnAgregarMascota=findViewById(R.id.btnAgregarMascota);
        btnConfiguracion=findViewById(R.id.btnConfiguracion);

        btnAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AgendarCita.class);
                startActivity(intent);
            }
        });
        btnAgregarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AgregarMascota.class);
                startActivity(intent);
            }
        });

        btnAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AgendarCita.class);
                startActivity(intent);
            }
        });
        btnConfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConfiguracionCuenta.class);
                startActivity(intent);
            }
        });

    }
}
