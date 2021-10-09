package entities;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private Locomotive locomotive;
    private final List<RailwayCarriage> railwayCarriages = new ArrayList<>();

    public void add(Locomotive locomotive) { // зачем тебе возвращать что-то здесь?
        if (railwayCarriages.isEmpty() && this.locomotive == null) {
            this.locomotive = locomotive;
            return;
        }
        if (railwayCarriages.isEmpty()) {
            return;
        }
        if (this.locomotive == null && railwayCarriages.get(0).getAppointment().compareTo(locomotive.getAppointment()) == 0) {
            this.locomotive = locomotive;
        }
    }

    public void add(RailwayCarriage railwayCarriage) {
        if (railwayCarriages.size() != 0) {
            if (locomotive == null && railwayCarriages.get(0).getClass() == railwayCarriage.getClass()) {
                railwayCarriages.add(railwayCarriage);
                return;
            }
            if (locomotive == null && railwayCarriages.get(0).getClass() != railwayCarriage.getClass()) {
                return;
            }
            if (railwayCarriages.get(0).getClass() == railwayCarriage.getClass() && locomotive.getAppointment().equals(railwayCarriage.getAppointment())) {//equals
                railwayCarriages.add(railwayCarriage);
                return;
            }
            if (railwayCarriages.get(0).getClass() == railwayCarriage.getClass() && !locomotive.getAppointment().equals(railwayCarriage.getAppointment())) {//equals
                return;
            }
            return;
        }
        if (locomotive != null) {
            if (locomotive.getAppointment().equals(railwayCarriage.getAppointment())) { //equals
                railwayCarriages.add(railwayCarriage);
            }
        } else {
            railwayCarriages.add(railwayCarriage);
        }
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("Train: \n");
        if (locomotive != null) {
            strb.append(locomotive);
        }
        if (railwayCarriages.size() != 0) {
            for (RailwayCarriage rwc : railwayCarriages) {
                strb.append(rwc.toString());
            }
        }


        return strb.toString();
    }

    public int countMaxAmountOfCargoOrNumberOfSeats() {
        int counter = 0;
        if (railwayCarriages.size() != 0) {
            if (railwayCarriages.get(0).getClass() == FreightCarriage.class) {
                System.out.println("Counting max amount of cargo in tons");
                for (RailwayCarriage rwc : railwayCarriages) {
                    counter += ((FreightCarriage) rwc).getMaximumAmountOfCargo();
                }
            } else {
                System.out.println("Counting max number of seats");
                for (RailwayCarriage rwc : railwayCarriages) {
                    counter += ((PassengerCarriage) rwc).getNumberOfSeats();
                }
            }

        }
        return counter;
    }

}