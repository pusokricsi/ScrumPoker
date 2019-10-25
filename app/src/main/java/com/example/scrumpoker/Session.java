package com.example.scrumpoker;

import java.util.ArrayList;

public class Session {
    private String ownerName;
    private String sessionName;
    private String sessionId;
    private ArrayList<Question> questions;

    public Session() {
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Session{" +
                "ownerName='" + ownerName + '\'' +
                ", sessionName='" + sessionName + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", questions=" + questions +
                '}';
    }
}
