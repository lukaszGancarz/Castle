package com.clockworkjava.castle.domain;

import java.time.LocalDateTime;

public class Quest {

    private int id;
    private String description;
    private int reward = 100;
    protected int lenghtInSeconds = 5;
    private boolean started = false;
    private boolean completed = false;
    protected LocalDateTime startDate;

    public Quest(int id, String description){
        this.id=id;
        this.description=description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLenght() {
        return lenghtInSeconds;
    }

    public void setLenght(int lenght) {
        this.lenghtInSeconds = lenght;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if(started) {
            this.startDate= LocalDateTime.now();
        }
        this.started = started;
    }

    public boolean isCompleted() {

        if(this.completed)
            return this.completed;
        else {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime questEndDate = this.startDate.plusSeconds(this.lenghtInSeconds);
            boolean isAfter = now.isAfter(questEndDate);
            if (isAfter) {
                this.completed = true;
            }
            return isAfter;
        }
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String toString() {
        return description;
    }

}
