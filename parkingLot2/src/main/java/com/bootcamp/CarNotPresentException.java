package com.bootcamp;

public class CarNotPresentException extends Throwable {
    public CarNotPresentException() {
        super("Car isn't parked in this parking lot");
    }
}
