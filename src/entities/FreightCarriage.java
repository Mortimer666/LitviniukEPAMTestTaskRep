package entities;

import parser.RollingStockRep;

public class FreightCarriage extends RailwayCarriage {
    private String type;
    private int maximumAmountOfCargo;

    public FreightCarriage() {
        for (int i = 0; i < RollingStockRep.cleaner().size(); i++) {
            if (RollingStockRep.cleaner().get(i).getId().compareTo(super.getId()) == 0) {
                type = RollingStockRep.cleaner().get(i).getType();
                maximumAmountOfCargo = RollingStockRep.cleaner().get(i).getMaximumAmountOfCargo();
                RollingStockRep.cleaner().remove(i);
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("ID: " + getId() + "\tAppointment: " + getAppointment() + "\tType: " + type + "\tMaximum amount of cargo: " + maximumAmountOfCargo + " tons" + "\n");
        return strb.toString();
    }

    public String getType() {
        return type;
    }

    public int getMaximumAmountOfCargo() {
        return maximumAmountOfCargo;
    }
}
