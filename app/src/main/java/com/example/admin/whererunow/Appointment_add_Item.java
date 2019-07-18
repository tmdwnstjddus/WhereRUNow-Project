package com.example.admin.whererunow;

import android.graphics.drawable.Drawable;

public class Appointment_add_Item {

    private Drawable icon;
    private String appointment_date;
    private String appointment_time;
    private String appointment_title;

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getAppointmentDate() {
        return appointment_date;
    }

    public void setAppointmentDate(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointmentTime() {
        return appointment_time;
    }

    public void setAppointmentTime(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getAppointmentTitle() {
        return appointment_title;
    }

    public void setAppointmentTitle(String appointment_title) {
        this.appointment_title = appointment_title;
    }
}
