package parser;

import java.util.List;

public class RollingStockRep {
    private String id;
    private String name;
    private String type;
    private String appointment;
    private int depot;
    private int maximumAmountOfCargo;
    private int numberOfSeats;
    private static List<RollingStockRep> rollingStockRepList = RollingStockDOMParser.parseXML();

    public static List<RollingStockRep> cleaner() {
        for (int i = 0; i < rollingStockRepList.size(); i++) {
            if (rollingStockRepList.get(i).getId() == null) {
                rollingStockRepList.remove(i);
            }
        }
        for (int i = 0; i < rollingStockRepList.size(); i++) {
            if (rollingStockRepList.get(i).getId() == null) {
                rollingStockRepList.remove(i);
            }
        }
        return rollingStockRepList;
    }

    public static List<RollingStockRep> getRollingStockRepList() {
        return rollingStockRepList;
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("ID: " + id + "\t");
        strb.append("Type: " + type + "\t");
        strb.append("Appointment: " + appointment + "\t");
        if (name != null) {
            strb.append("Name: " + name + "\t");
        }
        if (maximumAmountOfCargo != 0) {
            strb.append("Maximum amount of cargo: " + maximumAmountOfCargo + "\t");
        }
        if (numberOfSeats != 0) {
            strb.append("Number of seats: " + numberOfSeats + "\t");
        }
        return strb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public int getDepot() {
        return depot;
    }

    public void setDepot(int depot) {
        this.depot = depot;
    }

    public int getMaximumAmountOfCargo() {
        return maximumAmountOfCargo;
    }

    public void setMaximumAmountOfCargo(int maximumAmountOfCargo) {
        this.maximumAmountOfCargo = maximumAmountOfCargo;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
