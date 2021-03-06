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
import android.provider.ContactsContract;
import android.telephony.mbms.MbmsErrors;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.example.mareu.R;
import com.example.mareu.di.DI;
import com.example.mareu.model.Employee;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.MeetingRoom;
import com.example.mareu.service.DummyMeetingGenerator;
import com.example.mareu.service.MeetingApiService;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;

import javax.xml.transform.Templates;

public class AddMeetingActivity extends AppCompatActivity {

    public TextView mAddStartDateAndTime;
    public TextView mAddEndDateAndTime;
    public TextView mAddRoom;
    public Spinner mSpinnerRoom;
    public MultiAutoCompleteTextView mEmails;
    public TextInputLayout mSubject;
    public TextInputEditText mSubjectInput;
    public Button mSaveMeetingBtn;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy" + " - " + "HH:mm", Locale.FRANCE);
    final Calendar calendarBegin = Calendar.getInstance(Locale.FRANCE);
    final Calendar calendarEnd = Calendar.getInstance(Locale.FRANCE);

    MeetingApiService meetingApiService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAddStartDateAndTime = findViewById(R.id.add_start_date_and_time_meeting);
        mAddEndDateAndTime = findViewById(R.id.add_end_date_and_time_meeting);
        mAddRoom = findViewById(R.id.add_meeting_room);
        mSpinnerRoom = findViewById(R.id.spinner_meeting_room);
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

        addRoomSpinner();

        addParticipants();

        mSubject.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                mSaveMeetingBtn.setEnabled(s.length() > 0);
            }
        });

        mSaveMeetingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { saveNewMeeting(); }
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
                        calendarEnd.set(year, monthOfYear, dayOfMonth);
                        mAddEndDateAndTime.setText(sdf.format(calendarEnd.getTime()));
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


    public void addRoomSpinner() {
        List<MeetingRoom> rooms = new ArrayList<>();
        rooms.addAll(DummyMeetingGenerator.generateMeetingRooms());
        ArrayAdapter<MeetingRoom> adapter = new ArrayAdapter<MeetingRoom>(this, android.R.layout.simple_spinner_item, rooms);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerRoom.setAdapter(adapter);
        mSpinnerRoom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                adapterView.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void addParticipants(){
        List<Employee> employees = new ArrayList<>();
        employees.addAll(DummyMeetingGenerator.generateEmployees());
        ArrayAdapter<Employee> adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, employees);
        mEmails.setAdapter(adapter);
        mEmails.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    public void saveNewMeeting(){
        int roomPosition = mSpinnerRoom.getSelectedItemPosition();
        String[] emailsArray = mEmails.getText().toString().split(",");
        Meeting meeting = new Meeting(32,
                mSubject.getEditText().getText().toString(),
                getRoom(roomPosition),
                calendarBegin.getTime(),
                calendarEnd.getTime(),
                getParticipantsList(emailsArray)
        );
        meetingApiService.createMeeting(meeting);
        finish();
    }

    public MeetingRoom getRoom(int position) {
        MeetingRoom meetingRoom = DummyMeetingGenerator.generateMeetingRooms().get(position);
        return meetingRoom;
    }

    public ArrayList<Employee> getParticipantsList(String[] emails) {
        ArrayList<Employee> employeesList = new ArrayList<>(DummyMeetingGenerator.generateEmployees());
        ArrayList<Employee> participants = new ArrayList<>();
        for (String email : emails){
            for (int index=0; index<employeesList.size(); index++) {
                if(employeesList.get(index).getEmail().equalsIgnoreCase(email.trim())){
                    participants.add(employeesList.get(index));
                }
            }
        }
        return participants;
    }


}












