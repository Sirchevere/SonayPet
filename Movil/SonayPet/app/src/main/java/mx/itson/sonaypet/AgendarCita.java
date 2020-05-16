package mx.itson.sonaypet;

import androidx.appcompat.app.AppCompatActivity;
import dialogs.DatePickerFragment;
import dialogs.TimePick;

import android.app.DatePickerDialog;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AgendarCita extends AppCompatActivity implements Spinner.OnItemSelectedListener{
    EditText edtHora, edtFechaDeNac;
    Spinner edtNombreMascota;
    Button btnGuardar;

    ArrayList<String> nombreMascota;
    JSONArray result;
    TextView idMascota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_cita);

        nombreMascota= new ArrayList<>();
        edtHora = findViewById(R.id.edtHora);
        edtFechaDeNac = findViewById(R.id.edtFechaDeNac);
        edtNombreMascota= findViewById(R.id.edtNombreMascota);
        btnGuardar = findViewById(R.id.btnGuardar);
        edtNombreMascota.setOnItemSelectedListener(this);

        idMascota = (TextView) findViewById(R.id.txtID);

        buscarAnimales("http://wh485826.ispot.cc/webservices/buscar_mascota.php?codigo="+PrincipalActivity.ids);


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

        edtHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(AgendarCita.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        edtHora.setText(String.format("%02d:%02d", hourOfDay, minutes));
                    }
                }, 0, 00, false);
                timePickerDialog.show();

            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("http://wh485826.ispot.cc/webservices/insertar_cita.php");
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

    public void buscarAnimales(String URL){

        StringRequest stringRequest = new StringRequest(URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            //Parsing the fetched Json String to JSON Object
                            j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            result = j.getJSONArray("mascotas");

                            //Calling method getStudents to get the students from the JSON Array
                            getNombres(result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("codigo",PrincipalActivity.ids);
                return parametros;
            }
        };

        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);

    }

    private void getNombres(JSONArray j){
        //Traversing through all the items in the json array
        for(int i=0;i<j.length();i++){
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                nombreMascota.add(json.getString("masc_nombre"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }//Setting adapter to show the items in the spinner
        edtNombreMascota.setAdapter(new ArrayAdapter<String>(AgendarCita.this, android.R.layout.simple_spinner_dropdown_item, nombreMascota));
    }

    private String getId(int position){
        String id="";
        try {
            JSONObject json = result.getJSONObject(position);
            id = json.getString("ID_MASCOTA");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return id;
    }

    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(AgendarCita.this, "¡Se ha agendado la cita!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AgendarCita.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("idcliente",PrincipalActivity.ids);
                parametros.put("mascotaid",idMascota.getText().toString());
                parametros.put("fecha",edtFechaDeNac.getText().toString());
                parametros.put("hora",edtHora.getText().toString());


                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
    //this method will execute when we pic an item from the spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Setting the values to textviews for a selected item
        idMascota.setText(getId(position));
    }

    //When no item is selected this method would execute
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        idMascota.setText("");
    }
}
