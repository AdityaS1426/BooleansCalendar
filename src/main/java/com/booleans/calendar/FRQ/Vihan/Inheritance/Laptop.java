package com.booleans.calendar.FRQ.Vihan.Inheritance;

public class Laptop extends Computer {

    int battery_charge;

    public Laptop() {
        super();
        this.battery_charge = 4;
    }

    public Laptop(String name,int battery_charge) {
        super(name);
        this.battery_charge = battery_charge;
    }

    public Laptop(int storage, String name, int ram, OperatingSystem os, int battery_charge) {
        super(storage,name,ram,os);
        this.battery_charge=battery_charge;
    }

    @Override
    public String toString() {
        return "Name: "+name+" Battery: "+battery_charge+" hours";
    }

    public int compareTo(Laptop laptop) {
        if (this.battery_charge < laptop.battery_charge) {
            return -1;
        } else if (this.battery_charge > laptop.battery_charge) {
            return 1;
        } else {
            return 0;
        }
    }



}


