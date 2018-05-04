package com.bootcamp;

import java.util.ArrayList;

public class Attendant {
    private ArrayList<ParkingLot> parkingLots;

    Attendant() {
        this.parkingLots = new ArrayList<>();
    }

    public Object park(Vehicle car) throws CannotParkException {
        ParkingLot maxCapacityLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.compare(maxCapacityLot)&&!parkingLot.isFull()) {
                maxCapacityLot = parkingLot;
            }
        }
        if(maxCapacityLot.isFull()){
            throw new CannotParkException("Can't park, all lots are full");
        }
        return maxCapacityLot.park(car);
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
}
