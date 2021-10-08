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
    private static final List<RollingStockRep> rollingStockRepList = RollingStockDOMParser.parseXML(); // подсвечивает идея

    // Названия методов - всегда глаголы
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

    @Override // Идея подсказывает же
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("ID: ").append(id).append("\t");
        strb.append("Type: ").append(type).append("\t");
        strb.append("Appointment: ").append(appointment).append("\t");
        if (name != null) {
            strb.append("Name: ").append(name).append("\t");
        }
        if (maximumAmountOfCargo != 0) {
            strb.append("Maximum amount of cargo: ").append(maximumAmountOfCargo).append("\t");
        }
        if (numberOfSeats != 0) {
            strb.append("Number of seats: ").append(numberOfSeats).append("\t");
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
