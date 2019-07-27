package com.example.dell.calendartest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import cn.aigestudio.datepicker.bizs.languages.DPLManager;
import cn.aigestudio.datepicker.views.DatePicker;

public class MainActivity extends AppCompatActivity {


    DatePicker picker ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize date picker
        picker = findViewById(R.id.datePicker);
        Calendar c = Calendar.getInstance();
        Integer year = c.get(Calendar.YEAR);
        Integer month = c.get(Calendar.MONTH);

        Log.d("myLogs", year.toString() + "  " + month.toString());



        picker.setDate(year, month + 1);  // the month index starts from zero
        picker.setOnDateSelectedListener(new DatePicker.OnDateSelectedListener() {
            @Override
            public void onDateSelected(List<String> date) {
                StringBuilder result = new StringBuilder();
                Iterator iterator = date.iterator();
                while (iterator.hasNext()) {
                    result.append(iterator.next());
                    if (iterator.hasNext()) {
                        result.append("\n");
                    }
                }
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
                Log.d("myLogs", result.toString() );





            }
        });




        //DPCManager.getInstance().setDecorTL(tmpTL);





    }
}
