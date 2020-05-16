package mx.itson.sonaypet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CambiarContrasena extends AppCompatActivity {
EditText edtPassword, edtContrasenaNueva,edtContrasenaNueva1;
Button btnAceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_contrasena);

        edtPassword = findViewById(R.id.edtPassword);
        edtContrasenaNueva = findViewById(R.id.edtContrasenaNueva);
        edtContrasenaNueva1 = findViewById(R.id.edtContrasenaNueva1);
        btnAceptar = findViewById(R.id.btnAceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarUsuario("http://wh485826.ispot.cc/webservices/validar_usuario.php");
            }
        });


    }

    private void validarUsuario(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()) {

                    if (edtContrasenaNueva.getText().toString().equals(edtContrasenaNueva1.getText().toString())){
                        ejecutarServicio("http://wh485826.ispot.cc/webservices/editar_contrasena.php?codigo="+PrincipalActivity.ids);
                    }else {
                        Toast.makeText(CambiarContrasena.this, "Las contsaeñas no coinciden", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(CambiarContrasena.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CambiarContrasena.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("usuario",PrincipalActivity.mail);
                parametros.put("password",edtPassword.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(CambiarContrasena.this, "Se ha cambiado la contraseña", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ConfiguracionCuenta.class);
                startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CambiarContrasena.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("pass",edtContrasenaNueva.getText().toString());

                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
