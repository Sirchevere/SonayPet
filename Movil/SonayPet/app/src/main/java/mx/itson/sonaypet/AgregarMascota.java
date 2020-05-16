package mx.itson.sonaypet;

import androidx.appcompat.app.AppCompatActivity;
import dialogs.DatePickerFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgregarMascota extends AppCompatActivity {
    EditText edtNombre, edtColor, edtPelaje, edtFechaDeNac, edtTipo, edtRaza;
    Spinner edtGenero;
    Button btnAgregarMascota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_mascota);

        edtColor=findViewById(R.id.edtColor);
        edtPelaje=findViewById(R.id.edtPelaje);
        edtNombre=findViewById(R.id.edtNombre);
        edtFechaDeNac = findViewById(R.id.edtFechaDeNac);
        edtTipo=findViewById(R.id.edtTipo);
        edtRaza=findViewById(R.id.edtRaza);
        edtGenero=findViewById(R.id.edtGenero);
        btnAgregarMascota = findViewById(R.id.btnAgregarMascota);
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
        btnAgregarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("http://wh485826.ispot.cc/webservices/insertar_mascota.php");

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

    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(AgregarMascota.this, "¡Registro exitoso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AgregarMascota.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("id",PrincipalActivity.ids);
                parametros.put("tipo",edtTipo.getText().toString());
                parametros.put("raza",edtRaza.getText().toString());
                parametros.put("nombre",edtNombre.getText().toString());
                parametros.put("fechanac",edtFechaDeNac.getText().toString());
                parametros.put("genero",edtGenero.getSelectedItem().toString());
                parametros.put("color",edtColor.getText().toString());
                parametros.put("pelaje",edtPelaje.getText().toString());


                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


}
