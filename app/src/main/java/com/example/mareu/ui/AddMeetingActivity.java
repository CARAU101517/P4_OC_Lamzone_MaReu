package com.example.mareu.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.mareu.R;
import com.example.mareu.di.DI;
import com.example.mareu.service.MeetingApiService;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddMeetingActivity extends AppCompatActivity {

    public TextView mAddStartDateAndTime;
    public TextView mAddEndDateAndTime;
    public TextView mAddRoom;
    public TextView mEmails;
    public TextInputLayout mSubject;
    public TextInputEditText mSubjectInput;
    public Button mSaveMeetingBtn;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy" + " - " + "hh:mm", Locale.FRANCE);
    final Calendar calendarBegin = Calendar.getInstance(Locale.FRANCE);



    MeetingApiService meetingApiService;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAddStartDateAndTime = findViewById(R.id.add_start_date_and_time_meeting);
        mAddEndDateAndTime = findViewById(R.id.add_end_date_and_time_meeting);
        mAddRoom = findViewById(R.id.add_meeting_room);
        mEmails = findViewById(R.id.participants);
        mSubject = findViewById(R.id.meeting_subjectLyt);
        mSubjectInput = findViewById(R.id.add_meeting_subject);
        mSaveMeetingBtn = findViewById(R.id.save_meeting);

        meetingApiService = DI.getMeetingApiService();

        mAddStartDateAndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDateTimePickerDialog(mAddStartDateAndTime);
            }
        });

        mAddEndDateAndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endDateTimePickerDialog(mAddEndDateAndTime);
            }
        });

        mAddRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRoomDialog(mAddRoom);
            }
        });
    }

    public static void openAddMeetingActivity(FragmentActivity activity) {
        Intent addMeetingActivityIntent = new Intent(activity, AddMeetingActivity.class);
        ActivityCompat.startActivity(activity, addMeetingActivityIntent, null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void startDateTimePickerDialog(TextView mAddStartDateAndTime) {
        // calender class's instance and get current date , month and year from calender
        int mYear = calendarBegin.get(Calendar.YEAR); // current year
        int mMonth = calendarBegin.get(Calendar.MONTH); // current month
        int mDay = calendarBegin.get(Calendar.DAY_OF_MONTH); // current day
        int mHour = calendarBegin.get(Calendar.HOUR_OF_DAY); // current hour
        int mMinute = calendarBegin.get(Calendar.MINUTE); // current minute
        // date picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker date, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        calendarBegin.set(year, monthOfYear, dayOfMonth);
                        mAddStartDateAndTime.setText(sdf.format(calendarBegin.getTime()));
                    }
                }, mYear, mMonth, mDay);

        // time picker dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        calendarBegin.set(Calendar.HOUR_OF_DAY, i);
                        calendarBegin.set(Calendar.MINUTE, i1);
                        mAddStartDateAndTime.setText(sdf.format(calendarBegin.getTime()));
                    }
                }, mHour, mMinute, true);
        timePickerDialog.show();

        datePickerDialog.show();
    }

    public void endDateTimePickerDialog(TextView mAddEndDateAndTime) {
        // calender class's instance and get start date meeting , month and year from calender
        int mYear = calendarBegin.get(Calendar.YEAR); // start year
        int mMonth = calendarBegin.get(Calendar.MONTH); // star month
        int mDay = calendarBegin.get(Calendar.DAY_OF_MONTH); // start day
        int mHour = calendarBegin.get(Calendar.HOUR_OF_DAY); // start hour
        int mMinute = calendarBegin.get(Calendar.MINUTE); // start minute
        // date picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker date, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        calendarBegin.set(year, monthOfYear, dayOfMonth);
                        mAddEndDateAndTime.setText(sdf.format(calendarBegin.getTime()));
                    }
                }, mYear, mMonth, mDay);

        // time picker dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        calendarBegin.set(Calendar.HOUR_OF_DAY, i);
                        calendarBegin.set(Calendar.MINUTE, i1);
                        mAddEndDateAndTime.setText(sdf.format(calendarBegin.getTime()));
                    }
                }, mHour, mMinute, true);
        timePickerDialog.show();

        datePickerDialog.show();
    }

    public void addRoomDialog(TextView mAddRoom) {
        String[] roomsList = {"Sydney", "New York", "London", "Rio", "Oslo", "Cape Town", "Vancouver", "Singapore", "Paris", "San Francisco"};
        boolean[] isCheckedList = {false, false, false, false, false, false, false, false, false, false};


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sélectionnez votre salle");
        builder.setMultiChoiceItems(roomsList, isCheckedList, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                isCheckedList[which] = isChecked;
                mAddRoom.setText(isCheckedList.toString());
            }

        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        Dialog dialog = builder.create();
        dialog.show();

    }




    }







