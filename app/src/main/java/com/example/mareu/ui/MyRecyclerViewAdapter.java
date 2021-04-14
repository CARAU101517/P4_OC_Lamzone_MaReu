package com.example.mareu.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.R;
import com.example.mareu.model.Employee;
import com.example.mareu.model.Meeting;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private List<Meeting> mMeeting;
    private List<Meeting> filterList;
    SimpleDateFormat dateAndTimeFormat = new SimpleDateFormat("dd/MM/yy"+" - "+"HH:mm", Locale.FRANCE);


    public MyRecyclerViewAdapter(List<Meeting> items) {
        mMeeting = items;
        filterList = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_item_meeting, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Meeting meeting = filterList.get(position);
        setRoomColor(holder, meeting.getLocalisation().getId());
        holder.mSubject.setText(meeting.getSubject());
        holder.mParticipant.setText(addText(meeting.getParticipants()));
        holder.mLocalisation.setText(meeting.getLocalisation().getRoomName());
        String mDate = dateAndTimeFormat.format(meeting.getStartDate());
        holder.mDate.setText(mDate);
        holder.mDeleteMeeting.setOnClickListener(v -> {
            listener.OnItemClicked(filterList.get(position));
        });

    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    private String addText(ArrayList<Employee> participants) {
        StringBuilder text = new StringBuilder();
        text.append(participants.get(0).getEmail());
        for (int i=1; i<participants.size(); i++) {
            text.append(", "+participants.get(i).getEmail());
        }
        return text.toString();
    }

    private void setRoomColor(@NonNull MyViewHolder holder, int position) {
        switch (position) {
            case 1:
                holder.mAvatar.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.SydneyRoom), android.graphics.PorterDuff.Mode.MULTIPLY);
                break;
            case 2 :
                holder.mAvatar.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.NewYorkRoom), android.graphics.PorterDuff.Mode.MULTIPLY);
                break;
            case 3 :
                holder.mAvatar.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.LondonRoom), android.graphics.PorterDuff.Mode.MULTIPLY);
                break;
            case 4 :
                holder.mAvatar.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.RioRoom), android.graphics.PorterDuff.Mode.MULTIPLY);
                break;
            case 5 :
                holder.mAvatar.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.OsloRoom), android.graphics.PorterDuff.Mode.MULTIPLY);
                break;
            case 6 :
                holder.mAvatar.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.CapeTownRoom), android.graphics.PorterDuff.Mode.MULTIPLY);
                break;
            case 7:
                holder.mAvatar.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.VancouverRoom), android.graphics.PorterDuff.Mode.MULTIPLY);
            case 8 :
                holder.mAvatar.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.SingaporeRoom), android.graphics.PorterDuff.Mode.MULTIPLY);
                break;
            case 9 :
                holder.mAvatar.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.ParisRoom), android.graphics.PorterDuff.Mode.MULTIPLY);
                break;
            case 10:
                holder.mAvatar.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.SanFranciscoRoom), android.graphics.PorterDuff.Mode.MULTIPLY);
                break;
        }
    }

        public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mSubject, mDate, mLocalisation, mParticipant;
        ImageView mAvatar;
        ImageButton mDeleteMeeting;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mAvatar = itemView.findViewById(R.id.avatar_meeting_room);
            mSubject = itemView.findViewById(R.id.subject_meeting);
            mDate = itemView.findViewById(R.id.start_date_meeting);
            mLocalisation = itemView.findViewById(R.id.localisation_meeting);
            mParticipant = itemView.findViewById(R.id.participant_meeting);
            mDeleteMeeting = itemView.findViewById(R.id.item_list_delete_button);
        }
    }

    private ItemClickListener listener;

    public void setListener(ItemClickListener itemClickListener) {
        this.listener = itemClickListener;
    }

    public interface ItemClickListener {
        void OnItemClicked(Meeting meeting);
    }

    public void filterRoom(ArrayList<String> rooms ) {
        if (rooms == null || rooms.isEmpty()){
            filterList = mMeeting;
        }else {
            ArrayList<Meeting> resultList = new ArrayList<>();
            for (String room : rooms) {
                for (Meeting meeting : mMeeting) {
                    if (room.equalsIgnoreCase(meeting.getLocalisation().getRoomName())) {
                        resultList.add(meeting);
                    }
                }
                filterList = resultList;
            }
        }
        notifyDataSetChanged();
    }

    public void filterDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
        if (date == null) {
            filterList = mMeeting;
        } else {
            ArrayList<Meeting> resultListDate = new ArrayList<>();
            for (Meeting meeting : mMeeting) {
                if (sdf.format(date).equalsIgnoreCase(sdf.format(meeting.getStartDate()))) {
                    resultListDate.add(meeting);
                }
                filterList = resultListDate;
            }
        }
        notifyDataSetChanged();
    }


}
