package com.thoughtworks.step;

import java.util.ArrayList;

public class Attendant implements Listener {
    private ArrayList<ParkingLot> parkingLots;

    Attendant() {
        this.parkingLots = new ArrayList<>();
    }

    public Object park(Vehicle car) throws CannotParkException {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return parkingLot.park(car);
            }
        }
        throw new CannotParkException("Can't park, all lots are full");
    }


    public boolean add(ParkingLot parkingLot) {
        return parkingLots.add(parkingLot);
    }

    public Vehicle unPark(Object token) throws CarNotPresentException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasCar(token)) return parkingLot.unpark(token);
        }
        throw new CarNotPresentException();
    }

    @Override
    public void markAsFull() {
        System.out.println("Full!");
    }

    @Override
    public void markAsNotFull() {
        System.out.println("Not Full!");
    }

}
