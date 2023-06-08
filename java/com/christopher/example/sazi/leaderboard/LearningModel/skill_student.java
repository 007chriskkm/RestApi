package com.christopher.example.sazi.leaderboard.LearningModel;

import retrofit2.http.Url;

public class skill_student {

    public skill_student() {
    }

    @Override
    public String toString() {
        return "skill_student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", country='" + country + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                '}';
    }

    String name;
    String score;
    String country;
    String badgeUrl;

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }





    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }



    public skill_student(String name, String score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }
}
