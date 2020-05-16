package dialogs;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import androidx.fragment.app.DialogFragment;

public class TimePick extends DialogFragment implements TimePickerDialog.OnTimeSetListener
{
    private TextView time;

    public TimePick(View view)
    {
        time=(EditText)view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        final Calendar c= Calendar.getInstance();
        int hour=c.get(Calendar.HOUR_OF_DAY);
        int minute=c.get(Calendar.MINUTE);
        //Toast.makeText(getActivity(),this,"Date: "+year+"-",+month+"-"+day,Toast.LENGTH_SHORT).show();
        return new TimePickerDialog(getActivity(),this,hour,minute, DateFormat.is24HourFormat(getActivity()));
    }
    public void onTimeSet(TimePicker view, int hourofDay, int minute)
    {
        time.setText(Integer.toString(hourofDay) + ":" + Integer.toString(minute));
    }
}