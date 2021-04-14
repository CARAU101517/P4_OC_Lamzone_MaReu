package com.example.mareu.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.R;
import com.example.mareu.di.DI;
import com.example.mareu.model.Meeting;
import com.example.mareu.service.MeetingApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MeetingListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FloatingActionButton mAddMeetingFab;
    MeetingApiService meetingApiService;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_list);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.toolbar_dark));

        mAddMeetingFab = findViewById(R.id.add_meeting);
        mRecyclerView = findViewById(R.id.recycler_view);
        meetingApiService = DI.getMeetingApiService();

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(meetingApiService.getMeeting());
        mRecyclerView.setAdapter(myRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myRecyclerViewAdapter.setListener(new MyRecyclerViewAdapter.ItemClickListener() {
            @Override
            public void OnItemClicked(Meeting meeting) {
                meetingApiService.deleteMeeting(meeting);
                mRecyclerView.getAdapter().notifyDataSetChanged();
                Snackbar.make(mRecyclerView, "Reunion supprimée : " + meeting.getSubject(), Snackbar.LENGTH_LONG).show();
            }
        });


        mAddMeetingFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddMeetingActivity.openAddMeetingActivity(MeetingListActivity.this);
                mRecyclerView.getAdapter().notifyDataSetChanged();
                Snackbar.make(v, "Réunion ajoutée :" + meetingApiService.getMeeting().size(), Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.filter_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.localisation_filter) {
            filterRoomDialog();
            Toast.makeText(getApplicationContext(), "Choisir la Salle", Toast.LENGTH_SHORT).show();

        }
        if (id == R.id.date_filter) {
            filterDateDialog();
            Toast.makeText(getApplicationContext(), "Choisir la Date", Toast.LENGTH_LONG).show();
        }

        if (id == R.id.all_filter) {
            ((MyRecyclerViewAdapter) mRecyclerView.getAdapter()).filterDate(null);
            Toast.makeText(getApplicationContext(), "Afficher Tout", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    //FILTER ROOM
    public void filterRoomDialog() {
        String[] roomsList = {"Sydney", "New York", "London", "Rio", "Oslo", "Cape Town", "Vancouver", "Singapore", "Paris", "San Francisco"};
        boolean[] isCheckedList = {false, false, false, false, false, false, false, false, false, false};


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sélectionnez votre salle");
        builder.setMultiChoiceItems(roomsList, isCheckedList, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                isCheckedList[which] = isChecked;
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                ArrayList<String> rooms = new ArrayList<>();
                for (int i = 0; i < roomsList.length; i++) {
                    if (isCheckedList[i]) {
                        rooms.add(roomsList[i]);
                    }
                }
                ((MyRecyclerViewAdapter) mRecyclerView.getAdapter()).filterRoom(rooms);
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }

    //FILTER DATE
    public void filterDateDialog() {

        // calender class's instance and get current date , month and year from calender
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker date, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, monthOfYear, dayOfMonth);
                        ((MyRecyclerViewAdapter) mRecyclerView.getAdapter()).filterDate(calendar.getTime());
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

}