package entities;

import parser.RollingStockRep;

import java.util.Collections;

public abstract class RailwayCarriage {
    private String id;
    private int depot;
    private String appointment;

    public RailwayCarriage() {
        // Че блять это такое
        Collections.shuffle(RollingStockRep.cleaner());
        if (this.getClass() == FreightCarriage.class) {
            for (int i = 0; i < RollingStockRep.cleaner().size(); i++) {
                if (RollingStockRep.cleaner().get(i).getType().endsWith("carriage") && RollingStockRep.cleaner().get(i).getAppointment().endsWith("freight")) {
                    id = RollingStockRep.cleaner().get(i).getId();
                    appointment = RollingStockRep.cleaner().get(i).getAppointment();
                    depot = RollingStockRep.cleaner().get(i).getDepot();
                    return;
                }
            }
        } else {
            for (int i = 0; i < RollingStockRep.cleaner().size(); i++) {
                if (RollingStockRep.cleaner().get(i).getType().endsWith("carriage") && RollingStockRep.getRollingStockRepList().get(i).getAppointment().endsWith("passenger")) {
                    id = RollingStockRep.cleaner().get(i).getId();
                    appointment = RollingStockRep.cleaner().get(i).getAppointment();
                    depot = RollingStockRep.cleaner().get(i).getDepot();
                    return;
                }
            }
        }

    }

    // В конструкторе минимум логики. Если ты хочешь из репозитория что-то там крутить вертеть - в репозитории это и делай,
    // а потом вызывай нормальный конструктор
    public RailwayCarriage(String id, int depot, String appointment) {
        this.id = id;
        this.depot = depot;
        this.appointment = appointment;
    }

    public void setDepot(int depot) {
        this.depot = depot;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getDepot() {
        return depot;
    }

    public String getAppointment() {
        return appointment;
    }
}
