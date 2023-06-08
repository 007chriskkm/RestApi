package com.christopher.example.sazi.leaderboard.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.christopher.example.sazi.leaderboard.LearningModel.skill_student;
import com.christopher.example.sazi.leaderboard.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.ViewHolder> {
    List<skill_student> elites;
    Context mcontext;

    public void SetSkills(List<skill_student> elites){
        this.elites = elites;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mcontext= parent.getContext();
        View v = LayoutInflater.from(mcontext).inflate(R.layout.fragment2_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final skill_student user_elite = elites.get(position);

        holder.name.setText(user_elite.getName());
        holder.country.setText(user_elite.getCountry());
        holder.score.setText(user_elite.getScore());

        Picasso.with(mcontext).load(user_elite.getBadgeUrl()).into(holder.badgeUrl);


    }

    @Override
    public int getItemCount() {
        return elites.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView country;
        TextView score;
        ImageView badgeUrl;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name2);
            country = itemView.findViewById(R.id.tv_country2);
            score = itemView.findViewById(R.id.tv_score);
            badgeUrl = itemView.findViewById(R.id.badgeImg);

        }
    }
}
