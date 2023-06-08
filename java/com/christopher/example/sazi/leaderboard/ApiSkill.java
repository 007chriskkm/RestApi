package com.christopher.example.sazi.leaderboard;

import com.christopher.example.sazi.leaderboard.LearningModel.skill_student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface ApiSkill {

    String Base_URL = "https://gadsapi.herokuapp.com/";

    @GET("/api/skilliq")
    Call<List<skill_student>> getSkills();
}
