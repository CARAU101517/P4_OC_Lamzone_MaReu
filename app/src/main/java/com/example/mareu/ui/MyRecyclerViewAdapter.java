package com.example.mareu.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mareu.R;
import com.example.mareu.model.Employee;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.MeetingRoom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private List<Meeting> mMeeting;
    private List<Meeting> filterList ;
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm", Locale.FRANCE);

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
        String mDate = sdf.format(meeting.getStartDate());
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
            case 7:
                holder.mAvatar.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.VancouverRoom), android.graphics.PorterDuff.Mode.MULTIPLY);
                break;
            case 4 :
                holder.mAvatar.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.RioRoom), android.graphics.PorterDuff.Mode.MULTIPLY);
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
            mSubject = itemView.findViewById(R.id.subject_meeting);
            mDate = itemView.findViewById(R.id.start_date_meeting);
            mLocalisation = itemView.findViewById(R.id.localisation_meeting);
            mParticipant = itemView.findViewById(R.id.participant_meeting);
            mAvatar = itemView.findViewById(R.id.avatar_meeting_room);
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


}
