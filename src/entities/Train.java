package entities;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private Locomotive locomotive;
    private final List<RailwayCarriage> railwayCarriages = new ArrayList<>();

    public boolean add(Locomotive locomotive) {
        if (railwayCarriages.isEmpty() && this.locomotive == null) {
            this.locomotive = locomotive;
            return true;
        }
        if (railwayCarriages.isEmpty()) {
            return false;
        }
        if (this.locomotive == null && railwayCarriages.get(0).getAppointment().compareTo(locomotive.getAppointment()) == 0) {
            this.locomotive = locomotive;
            return true;
        }
        return false;
    }

    public boolean add(RailwayCarriage railwayCarriage) {
        if (railwayCarriages.size() != 0) {
            if (locomotive == null && railwayCarriages.get(0).getClass() == railwayCarriage.getClass()) {
                railwayCarriages.add(railwayCarriage);
                return true;
            }
            if (locomotive == null && railwayCarriages.get(0).getClass() != railwayCarriage.getClass()) {
                return false;
            }
            if (railwayCarriages.get(0).getClass() == railwayCarriage.getClass() && locomotive.getAppointment().compareTo(railwayCarriage.getAppointment()) == 0) {
                railwayCarriages.add(railwayCarriage);
                return true;
            }
            if (railwayCarriages.get(0).getClass() == railwayCarriage.getClass() && locomotive.getAppointment().compareTo(railwayCarriage.getAppointment()) != 0) {
                return false;
            }
            return false;
        }
        if (locomotive != null) {
            if (locomotive.getAppointment().compareTo(railwayCarriage.getAppointment()) == 0) {
                railwayCarriages.add(railwayCarriage);
                return true;
            } else {
                return false;
            }
        } else {
            railwayCarriages.add(railwayCarriage);
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("Train: \n");
        if (locomotive != null) {
            strb.append(locomotive.toString());
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