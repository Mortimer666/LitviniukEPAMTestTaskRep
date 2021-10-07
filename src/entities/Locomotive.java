package entities;

import parser.RollingStockRep;

import java.util.Collections;

public class Locomotive {
    private String id;
    private String name;
    private String type;
    private String appointment;

    private int depot;

    public Locomotive() {
        Collections.shuffle(RollingStockRep.cleaner());
        for (int i = 0; i < RollingStockRep.cleaner().size(); i++) {
            if (RollingStockRep.cleaner().get(i).getType().endsWith("locomotive")) {
                id = RollingStockRep.cleaner().get(i).getId();
                type = RollingStockRep.cleaner().get(i).getType();
                name = RollingStockRep.cleaner().get(i).getName();
                appointment = RollingStockRep.cleaner().get(i).getAppointment();
                depot = RollingStockRep.cleaner().get(i).getDepot();
                RollingStockRep.cleaner().remove(i);
                return;
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("ID: " + id + "\tName: " + name + "\tAppointment: " + appointment + "\tType: " + type + "\n");
        return strb.toString();
    }

    public void setDepot(int depot) {
        this.depot = depot;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDepot() {
        return depot;
    }

    public String getAppointment() {
        return appointment;
    }

}
