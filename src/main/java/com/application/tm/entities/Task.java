package com.application.tm.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Task {

    private final String description;
    private final LocalDateTime startsAt;
    private final LocalDateTime endAt;
    private final boolean isDone;
    private final String date;

    private Task(Builder builder){
        description = builder.description;
        startsAt = builder.startsAt;
        endAt = builder.endAt;
        isDone = false;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        date = dtf.format(LocalDateTime.now());
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartsAt() {
        return startsAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getDate() {
        return date;
    }

    public static class Builder{
        private String description;
        private LocalDateTime startsAt;
        private LocalDateTime endAt;
        private boolean isDone;

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setStartsAt(LocalDateTime startsAt) {
            this.startsAt = startsAt;
            return this;
        }

        public Builder setEndAt(LocalDateTime endAt) {
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
