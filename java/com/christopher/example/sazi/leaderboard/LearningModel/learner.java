package com.christopher.example.sazi.leaderboard.LearningModel;

public class learner {
    String name;
    String country;
    String hours;
    String badgeUrl;

    public learner() {
    }



    public learner(String name,String hours,String country,String badgeUrl) {
        this.name = name;
        this.country = country;
        this.hours = hours;
        this.badgeUrl = badgeUrl;
    }

    @Override
    public String toString() {
        return "learner{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", hours='" + hours + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                '}';
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

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
}
