package com.example.sensor;

public class RecyclerItem {

    private String nameSensor;
    private String descSensor;
    private String cordSensor;
    private String statusSensor;

    public RecyclerItem(String nameSensor, String descSensor, String cordSensor, String statusSensor) {
        this.nameSensor = nameSensor;
        this.descSensor = descSensor;
        this.cordSensor = cordSensor;
        this.statusSensor = statusSensor;
    }

    public String getNameSensor() {
        return nameSensor;
    }

    public void setNameSensor(String nameSensor) {
        this.nameSensor = nameSensor;
    }

    public String getDescSensor() {
        return descSensor;
    }

    public void setDescSensor(String descSensor) {
        this.descSensor = descSensor;
    }

    public String getCordSensor() {
        return cordSensor;
    }

    public void setCordSensor(String cordSensor) {
        this.cordSensor = cordSensor;
    }

    public String getStatusSensor() {
        return statusSensor;
    }

    public void setStatusSensor(String statusSensor) {
        this.statusSensor = statusSensor;
    }
}
