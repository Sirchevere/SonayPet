package mx.itson.sonaypet;

import androidx.appcompat.app.AppCompatActivity;
import dialogs.DatePickerFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registrarse extends AppCompatActivity {
    EditText edtNombres, edtApellidos, edtFechaDeNac, edtDireccion, edtTelefono, edtEmail, edtPass;
    Spinner edtGenero;
    Button btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        edtNombres = findViewById(R.id.edtNombres);
        edtApellidos = findViewById(R.id.edtApellidos);
        edtFechaDeNac = findViewById(R.id.edtFechaDeNac);
        edtDireccion = findViewById(R.id.edtDireccion);
        edtTelefono = findViewById(R.id.edtTelefono);
        edtGenero = findViewById(R.id.edtGenero);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Generos, android.R.layout.simple_spinner_item);
        edtGenero.setAdapter(adapter);


        edtFechaDeNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.edtFechaDeNac:
                        showDatePickerDialog();
                        break;
                }


            }
        });


        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean failFlag = false;

                failFlag = validacion(failFlag,edtNombres);
                failFlag = validacion(failFlag,edtApellidos);
                failFlag = validacion(failFlag,edtFechaDeNac);
                failFlag = validacion(failFlag,edtDireccion);
                failFlag = validacion(failFlag,edtTelefono);
                failFlag = validacion(failFlag,edtEmail);
                failFlag = validacion(failFlag,edtPass);


                failFlag = isValidEmail(failFlag,edtEmail);

                if (failFlag==false){
                    ejecutarServicio("http://wh485826.ispot.cc/webservices/insertar_usuario.php");
                }

            }
        });
    }
    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = year + "-" + (month+1) + "-" + day;
                edtFechaDeNac.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    public  boolean isValidEmail(Boolean fail, EditText Boton) {
        CharSequence target = Boton.getText().toString();
        if (!Patterns.EMAIL_ADDRESS.matcher(target).matches()){
            Boton.setError("Correo invalido");
            fail = true;
        }
        return fail;

    }

    public Boolean validacion(Boolean fail, EditText Boton){
        String boton = Boton.getText().toString();
        if (TextUtils.isEmpty(boton)){
            Boton.setError("El campo no debe estar vacio");
            fail = true;
        }
        return fail;
    }

    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Registrarse.this, "¡Registro exitoso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Registrarse.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("nombres",edtNombres.getText().toString());
                parametros.put("apellidos",edtApellidos.getText().toString());
                parametros.put("fechanac",edtFechaDeNac.getText().toString());
                parametros.put("direccion",edtDireccion.getText().toString());
                parametros.put("telefono",edtTelefono.getText().toString());
                parametros.put("genero",edtGenero.getSelectedItem().toString());
                parametros.put("email",edtEmail.getText().toString());
                parametros.put("pass",edtPass.getText().toString());


                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
