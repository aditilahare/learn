package com.thoughtworks.step;

public class CarNotPresentException extends Throwable {
    public CarNotPresentException() {
        super("Car isn't parked in parking lot");
    }
}
