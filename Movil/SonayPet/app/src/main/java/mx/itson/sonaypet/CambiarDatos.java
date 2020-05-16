package mx.itson.sonaypet;

import androidx.appcompat.app.AppCompatActivity;
import dialogs.DatePickerFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CambiarDatos extends AppCompatActivity {
    EditText edtNombres, edtApellidos, edtFechaDeNac, edtDireccion, edtTelefono, edtEmail;
    Spinner edtGenero;
    Button btnEditar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_datos);

        edtNombres = findViewById(R.id.edtNombres);
        edtApellidos = findViewById(R.id.edtApellidos);
        edtFechaDeNac = findViewById(R.id.edtFechaDeNac);
        edtDireccion = findViewById(R.id.edtDireccion);
        edtTelefono = findViewById(R.id.edtTelefono);
        edtGenero = findViewById(R.id.edtGenero);
        edtEmail = findViewById(R.id.edtEmail);
        btnEditar = findViewById(R.id.btnEditar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Generos, android.R.layout.simple_spinner_item);
        edtGenero.setAdapter(adapter);
        poblardatos("http://wh485826.ispot.cc/webservices/buscar_datospersonales.php?codigo="+PrincipalActivity.ids);


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

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("http://wh485826.ispot.cc/webservices/editar_cliente.php?codigo="+PrincipalActivity.ids);

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

    private void poblardatos(String URL){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i=0;i<response.length();i++){
                    try {
                        jsonObject = response.getJSONObject(i);
                        edtNombres.setText(jsonObject.getString("CLI_NOMBRES"));
                        edtApellidos.setText(jsonObject.getString("CLI_APELLIDOS"));
                        edtFechaDeNac.setText(jsonObject.getString("CLI_FECHANAC"));
                        edtDireccion.setText(jsonObject.getString("CLI_DIRECCION"));
                        edtTelefono.setText(jsonObject.getString("CLI_TELEFONO"));
                        if (jsonObject.getString("CLI_GENERO").equals("M")){
                            edtGenero.setSelection(0);
                        }
                        if (jsonObject.getString("CLI_GENERO").equals("F")){
                            edtGenero.setSelection(1);
                        }
                        edtEmail.setText(jsonObject.getString("CLI_EMAIL"));

                    } catch (JSONException e){
                        Toast.makeText(CambiarDatos.this, "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CambiarDatos.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }

    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(CambiarDatos.this, "¡Se ah editado con exito!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ConfiguracionCuenta.class);
                startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CambiarDatos.this, error.toString(), Toast.LENGTH_SHORT).show();
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


                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
