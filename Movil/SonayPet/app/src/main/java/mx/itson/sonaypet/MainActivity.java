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

public class MainActivity extends AppCompatActivity {
    EditText edtUsuario, edtPassword;
    Button btnLogin, btnRegistrarse;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtUsuario=findViewById(R.id.edtUsuario);
        edtPassword=findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registrarse.class);
                startActivity(intent);
            }
        });

btnLogin.setOnClickListener(new View.OnClickListener() {
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
            if (!response.isEmpty()){
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                    String age = jsonObject.getString("ID_CLIENTE");
                    String mail = jsonObject.getString("CLI_EMAIL");
                    Toast.makeText(MainActivity.this, mail, Toast.LENGTH_SHORT).show();
                    PrincipalActivity.ids = age;
                    PrincipalActivity.mail = mail;

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("usuario",edtUsuario.getText().toString());
                parametros.put("password",edtPassword.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


}
