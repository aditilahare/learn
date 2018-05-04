package com.thoughtworks.step;

import java.util.HashMap;

public class ParkingLot {
    private final int capacity;
    private HashMap<Object, Vehicle> vehicles;
    private final Event event;

    ParkingLot(int capacity, Event event) {
        this.capacity = capacity;
        this.event = event;
        this.vehicles = new HashMap<>();
    }

    public Object park(Vehicle car) throws CannotParkException {
        if (isPresent(car)) throw new CannotParkException("Car is already parked");
        if (isFull()) {
            throw new CannotParkException("Can't park, lot is full");
        }
        Object token = new Object();
        this.vehicles.put(token, car);
        if (isFull()) {
            event.full();
        }
        return token;
    }

    public Vehicle unpark(Object token) throws CarNotPresentException {
        if (!hasCar(token)) throw new CarNotPresentException();
        Vehicle unParkedVehicle = this.vehicles.get(token);
        if (isFull()) {
            this.vehicles.remove(token);
            event.hasSpace();
        }
        this.vehicles.remove(token);
        return unParkedVehicle;
    }

    private boolean isPresent(Vehicle car) {
        return vehicles.containsValue(car);
    }

    public boolean isFull() {
        return this.vehicles.size() == capacity;
    }

    public boolean hasCar(Object token) {
        return this.vehicles.containsKey(token);
    }
}
