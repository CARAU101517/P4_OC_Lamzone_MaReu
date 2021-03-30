package com.example.mareu.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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
import java.util.Locale;

public class AddMeetingActivity extends AppCompatActivity {

    public TextView mAddStartDate;
    public TextView mAddStartTime;
    public TextView mAddEndDate;
    public TextView mAddEndTime;
    public TextView mAddRoom;
    public TextInputLayout mSubject;
    public TextView mEmails ;
    public TextInputEditText mSubjectInput;
    public Button mSaveMeetingBtn;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy", Locale.FRANCE);
    SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm", Locale.FRANCE);

    MeetingApiService meetingApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAddStartDate = findViewById(R.id.add_start_date_meeting);
        mAddStartTime = findViewById(R.id.add_start_time_meeting);
        mAddEndDate = findViewById(R.id.add_end_date_meeting);
        mAddEndTime = findViewById(R.id.add_end_time_meeting);
        mAddRoom = findViewById(R.id.add_meeting_room);
        mEmails = findViewById(R.id.participants);
        mSubject = findViewById(R.id.meeting_subjectLyt);
        mSubjectInput = findViewById(R.id.add_meeting_subject);
        mSaveMeetingBtn = findViewById(R.id.save_meeting);
        meetingApiService = DI.getMeetingApiService();

    }


    public static void openAddMeetingActivity(FragmentActivity activity) {
        Intent addMeetingActivityIntent = new Intent(activity, AddMeetingActivity.class);
        ActivityCompat.startActivity(activity, addMeetingActivityIntent, null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home : {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}