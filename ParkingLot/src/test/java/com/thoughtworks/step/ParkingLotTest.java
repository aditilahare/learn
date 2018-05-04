package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ParkingLotTest {

    private Event mockEvent = mock(Event.class);

    private class TestCar implements Vehicle {}
    private ParkingLot parkingLot;
    private TestCar car;


    @Before
    public void setUp() {
        parkingLot = new ParkingLot(2, mockEvent);
        car = new TestCar();
        mock(Listener.class);
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
        ParkingLot parkingLot = new ParkingLot(1,new Event());
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
    public void shouldFireEventIfLotIsFull() throws CannotParkException {
        parkingLot.park(new TestCar());
        parkingLot.park(new TestCar());
        verify(mockEvent).full();
    }

    @Test
    public void shouldFireEventIfLotIsFree() throws CannotParkException, CarNotPresentException {
        parkingLot.park(new TestCar());
        Object token = parkingLot.park(new TestCar());
        parkingLot.unpark(token);
        verify(mockEvent).hasSpace();
    }

    @Test
    public void shouldFireEventForFullParkingLot() throws CannotParkException {
        Event event = new Event();
        Assistant mockAssistant = mock(Assistant.class);
        event.addListener(mockAssistant);
        ParkingLot parkingLot = new ParkingLot(1, event);
        parkingLot.park(new TestCar());
        verify(mockAssistant).markAsFull();
    }
}