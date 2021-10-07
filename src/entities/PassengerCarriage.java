package entities;

import parser.RollingStockRep;

public class PassengerCarriage extends RailwayCarriage {
    private String type;
    private int numberOfSeats;

    public PassengerCarriage() {
        for (int i = 0; i < RollingStockRep.cleaner().size(); i++) {
            if (RollingStockRep.cleaner().get(i).getId().compareTo(super.getId()) == 0) {
                type = RollingStockRep.cleaner().get(i).getType();
                numberOfSeats = RollingStockRep.cleaner().get(i).getNumberOfSeats();
                RollingStockRep.cleaner().remove(i);
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("ID: " + getId() + "\tAppointment: " + getAppointment() + "\tType: " + type + "Number of seats: " + numberOfSeats + "\n");
        return strb.toString();
    }

    public String getType() {
        return type;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}
