import entities.*;
import parser.RollingStockRep;

public class Main {
    public static void main(String[] args) {
        long timeon = System.currentTimeMillis();
        for (RollingStockRep a : RollingStockRep.cleaner()) {
            System.out.println(a);
        }
        System.out.println();
        Locomotive locomotive = new Locomotive();
        Locomotive locomotive1 = new Locomotive();

        RailwayCarriage railwayCarriage = new FreightCarriage();
        RailwayCarriage railwayCarriage1 = new FreightCarriage();
        RailwayCarriage railwayCarriage2 = new FreightCarriage();
        RailwayCarriage railwayCarriage3 = new FreightCarriage();
        RailwayCarriage railwayCarriage4 = new PassengerCarriage();
        RailwayCarriage railwayCarriage5 = new PassengerCarriage();
        RailwayCarriage railwayCarriage6 = new PassengerCarriage();
        RailwayCarriage railwayCarriage7 = new PassengerCarriage();
        System.out.println(locomotive);
        System.out.println(locomotive1);
        System.out.println(railwayCarriage);
        System.out.println(railwayCarriage1);
        System.out.println(railwayCarriage2);
        System.out.println(railwayCarriage3);
        System.out.println(railwayCarriage4);
        System.out.println(railwayCarriage5);
        System.out.println(railwayCarriage6);
        System.out.println(railwayCarriage7);

        Train train = new Train();
        train.add(locomotive1);
        train.add(railwayCarriage);
        train.add(railwayCarriage1);
        train.add(railwayCarriage2);
        train.add(railwayCarriage3);
        train.add(railwayCarriage4);
        train.add(railwayCarriage5);
        train.add(railwayCarriage6);
        train.add(railwayCarriage7);

        Train train1 = new Train();
        train1.add(locomotive);
        train1.add(railwayCarriage);
        train1.add(railwayCarriage1);
        train1.add(railwayCarriage2);
        train1.add(railwayCarriage3);
        train1.add(railwayCarriage4);
        train1.add(railwayCarriage5);
        train1.add(railwayCarriage6);
        train1.add(railwayCarriage7);
        System.out.println(train);
        System.out.println(train1);
        System.out.println(train.countMaxAmountOfCargoOrNumberOfSeats());
        System.out.println(train1.countMaxAmountOfCargoOrNumberOfSeats());
        long timeoff = System.currentTimeMillis();
        long delay = timeoff - timeon;
        System.out.println(delay);

    }
}