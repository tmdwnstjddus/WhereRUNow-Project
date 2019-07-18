package com.example.admin.whererunow;

import android.graphics.drawable.Drawable;

public class LastAppointment_Item {

    private Drawable icon;
    private String last_appointment_date;
    private String last_appointment_time;
    private String last_appointment_title;

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getLastAppointmentDate() {
        return last_appointment_date;
    }

    public void setLastAppointmentDate(String last_appointment_date) {
        this.last_appointment_date = last_appointment_date;
    }

    public String getLastAppointmentTime() {
        return last_appointment_time;
    }

    public void setLastAppointmentTime(String last_appointment_time) {
        this.last_appointment_time = last_appointment_time;
    }

    public String getLastAppointmentTitle() {
        return last_appointment_title;
    }

    public void setLastAppointmentTitle(String last_appointment_title) {
        this.last_appointment_title = last_appointment_title;
    }
}
