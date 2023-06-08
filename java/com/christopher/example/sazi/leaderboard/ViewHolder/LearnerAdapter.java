package com.christopher.example.sazi.leaderboard.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.christopher.example.sazi.leaderboard.LearningModel.learner;
import com.christopher.example.sazi.leaderboard.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LearnerAdapter extends RecyclerView.Adapter<LearnerAdapter.ViewHolder> {
    List<learner> learners;
    private Context mcontext;

    public void SetLearners(List<learner> learners){
        this.learners = learners;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mcontext = parent.getContext();
        View view = LayoutInflater.from(mcontext).inflate(R.layout.fragment1_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final learner students = learners.get(position);

        holder.name.setText(students.getName());
        holder.country.setText(students.getCountry());
        holder.hours.setText(students.getHours());


        Picasso.with(mcontext).load(students.getBadgeUrl()).into(holder.badgeUrl);

    }

    @Override
    public int getItemCount() {
        return learners.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView hours;
        public TextView country;
        public ImageView badgeUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            hours = itemView.findViewById(R.id.tv_hours);
            country = itemView.findViewById(R.id.tv_country);
            badgeUrl = itemView.findViewById(R.id.badgeUrl);

        }
    }
}
