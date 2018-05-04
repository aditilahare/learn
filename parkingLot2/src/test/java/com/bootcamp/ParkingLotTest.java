package com.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class ParkingLotTest {

    private class TestCar implements Vehicle {}
    private ParkingLot parkingLot;
    private TestCar car;


    @Before
    public void setUp() {
        parkingLot = new ParkingLot(2);
        car = new TestCar();
    }

    @Test
    public void shouldParkTheGivenCar() throws CannotParkException {
        Object parkingToken = parkingLot.park(car);
        assertNotNull(parkingToken);
    }

    @Test
    public void shouldUnparkTheAlreadyParkedCar() throws CarNotPresentException, CannotParkException {
        Object parkingToken = parkingLot.park(car);
        assertThat(parkingLot.unpark(parkingToken),is(car));
    }

    @Test(expected = CarNotPresentException.class)
    public void shouldNotUnparkTheCarWithoutParkingIt() throws CarNotPresentException {
        parkingLot.unpark(car);
    }

    @Test (expected = CannotParkException.class)
    public void shouldNotParkSameCarTwice() throws CannotParkException {
        parkingLot.park(car);
        parkingLot.park(car);
    }

    @Test
    public void shouldAssertTrueIfLotIsFull() throws CannotParkException {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(car);
        assertTrue(parkingLot.isFull());
    }

    @Test (expected = CannotParkException.class)
    public void shouldNotAllowToParkWhenCapacityExceeds() throws CannotParkException {
        parkingLot.park(new TestCar());
        parkingLot.park(new TestCar());
        parkingLot.park(new TestCar());
    }

    @Test
    public void shouldGiveTrueIfAnotherLotsCapacityIsLesser() {
        assertTrue(parkingLot.compare(new ParkingLot(1)));
    }


    @Test
    public void shouldGiveFalseIfAnotherLotsCapacityIsGreater() {
        assertFalse(parkingLot.compare(new ParkingLot(3)));
    }
}
