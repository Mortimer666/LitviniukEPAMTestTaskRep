package entities;

import parser.RollingStockRep;

public class FreightCarriage extends RailwayCarriage {
    private String type;
    private int maximumAmountOfCargo;

    public FreightCarriage() {
        for (int i = 0; i < RollingStockRep.cleaner().size(); i++) {
            if (RollingStockRep.cleaner().get(i).getId().equals(super.getId())) { // че за compareTo, equals есть
                type = RollingStockRep.cleaner().get(i).getType();
                maximumAmountOfCargo = RollingStockRep.cleaner().get(i).getMaximumAmountOfCargo();
                RollingStockRep.cleaner().remove(i);
                return;
            }
        }
    }

    // Идея подсвечивает же
    @Override
    public String toString() {
        return "ID: " + getId() + "\tAppointment: " + getAppointment() + "\tType: " + type + "\tMaximum amount of cargo: " + maximumAmountOfCargo + " tons" + "\n";
    }

    public String getType() {
        return type;
    }

    public int getMaximumAmountOfCargo() {
        return maximumAmountOfCargo;
    }
}
