package com.aditya.task;

import java.util.Date;
import java.util.Objects;

public class Task {
    public static final int  DEFAULT_PRIORITY=1;
    private String title;
    private boolean completed;
    private final Date date;
    private int priority;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return completed == task.completed &&
                priority == task.priority &&
                Objects.equals(title, task.title) &&
                Objects.equals(date, task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, completed, date, priority);
    }

    private Task(String title, int priority) {
        this.title = title;
        this.priority = priority;
        this.completed = false;
        this.date = new Date();
    }

    private Task(Builder builder) {
        title = builder.title;
        completed = builder.completed;
        date = builder.date;
        priority = builder.priority;
    }

    public static Task createTask(String title, int priority) {
        return new Task(title, priority);
    }

    public static Task taskWithDefaultPriority(String title)
    {
        return new Task(title,DEFAULT_PRIORITY);
    }

    public boolean moreImportant(Task other)
    {
        if(this.priority> other.priority)
        {
            return true;
        }

        return false;
    }

/*
    ALTERNATE IMPLEMENTATION !!

    public static boolean moreImportant(Task task1, Task task2)
    {
        if contd
        return true;
    }*/


    public int getPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }

    public void done() {
        this.completed=true;
    }

    public void undone() {
        this.completed = false;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", completed=" + completed +
                ", date=" + date +
                ", priority=" + priority +
                '}';
    }

    public static final class Builder {
        private String title;
        private boolean completed;
        private Date date;
        private int priority;

        public Builder() {
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withCompleted(boolean val) {
            completed = val;
            return this;
        }

        public Builder withDate(Date val) {
            date = val;
            return this;
        }

        public Builder withPriority(int val) {
            priority = val;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
}
