package com.application.tm;

import java.util.Date;

public class Task {

    private String description;
    private Date startsAt;
    private Date endAt;
    private boolean isDone;

    private Task(Builder builder){
        description = builder.description;
        startsAt = builder.startsAt;
        endAt = builder.endAt;
        isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartsAt() {
        return startsAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public boolean isDone() {
        return isDone;
    }

    public static class Builder{
        private String description;
        private Date startsAt;
        private Date endAt;
        private boolean isDone;

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setStartsAt(Date startsAt) {
            this.startsAt = startsAt;
            return this;
        }

        public Builder setEndAt(Date endAt) {
            this.endAt = endAt;
            return this;
        }

        public Builder setDone(boolean done) {
            isDone = done;
            return this;
        }

        public Task build(){
            return new Task(this);
        }
    }
}
