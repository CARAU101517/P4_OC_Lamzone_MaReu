package com.example.mareu.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mareu.R;
import com.example.mareu.di.DI;
import com.example.mareu.model.Meeting;
import com.example.mareu.service.MeetingApiService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public void startDateTimePickerDialog(TextView t) {
        // calender class's instance and get current date , month and year from calender
        final Calendar c = Calendar.getInstance(Locale.FRANCE);
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        int mHour = c.get(Calendar.HOUR_OF_DAY); // current hour
        int mMinute = c.get(Calendar.MINUTE); // current minute
        // date picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker date, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, monthOfYear, dayOfMonth);
                        t.setText(sdf.format(calendar.getTime()));
                    }
                }, mYear, mMonth, mDay);

        // time picker dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Calendar timeCalendar = Calendar.getInstance();
                        timeCalendar.set(i, i1);
                        t.setText(sdf.format(timeCalendar.getTime()));
                    }
                }, mHour, mMinute, true);
        timePickerDialog.show();

        datePickerDialog.show();
    }

    public void endDateTimePickerDialog(TextView textView) {
        // calender class's instance and get current date , month and year from calender
        final Calendar c = Calendar.getInstance(Locale.FRANCE);
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        int mHour = c.get(Calendar.HOUR_OF_DAY); // current hour
        int mMinute = c.get(Calendar.MINUTE); // current minute
        // date picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker date, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, monthOfYear, dayOfMonth);
                        textView.setText(sdf.format(calendar.getTime()));
                    }
                }, mYear, mMonth, mDay);

        // time picker dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Calendar timeCalendar = Calendar.getInstance();
                        timeCalendar.set(i, i1);
                        textView.setText(sdf.format(timeCalendar.getTime()));
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







