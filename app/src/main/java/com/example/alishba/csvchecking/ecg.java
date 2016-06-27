package com.example.alishba.csvchecking;

import java.util.ArrayList;

public class ecg {
    static public ArrayList<ecg> ecgArrayList = null;

    private float voltage;
    private float time;

    public ecg(float time , float voltage) {
        super();
        this.voltage=voltage;
        this.time=time;
    }

    public float getTime() {
        return time;

    }

    public void setTime(float time) {
        this.time = time;
    }

    public float getVoltage() {
        return voltage;
    }

    public void setVoltage(float voltage) {
        this.voltage = voltage;
    }
}
