package com.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AttendantTest {

    private class TestCar implements Vehicle {}
    private TestCar car;
    private Attendant attendant;
    private ParkingLot parkingLot;

    @Before
    public void setUp() {
        attendant = new Attendant();
        car = new TestCar();
        parkingLot = new ParkingLot(2);

    }

    @Test
    public void shouldParkTheGivenCar() throws CannotParkException {
        attendant.add(parkingLot);
        Object token = attendant.park(car);
        assertNotNull(token);
    }

    @Test
    public void shouldAddVehicleEvenIfFirstLotGetsFull() throws CannotParkException {
        attendant.add(parkingLot);
        attendant.add(new ParkingLot(2));
        attendant.park(new TestCar());
        attendant.park(new TestCar());
        Object carToken = attendant.park(new TestCar());
        assertNotNull(carToken);
    }

    @Test
    public void shouldAddParkingLotWithGivenCapacity() {
        assertTrue(attendant.add(parkingLot));
    }

    @Test (expected = CannotParkException.class)
    public void shouldThrowExceptionIfAllLotsGetFull() throws CannotParkException {
        attendant.add(parkingLot);
        attendant.add(new ParkingLot(1));
        attendant.park(new TestCar());
        attendant.park(new TestCar());
        attendant.park(new TestCar());
        attendant.park(new TestCar());
    }

    @Test
    public void shouldUnparkTheGivenCar() throws CannotParkException, CarNotPresentException {
        attendant.add(new ParkingLot(2));
        Object parkingToken = attendant.park(car);
        assertThat(attendant.unPark(parkingToken),is(car));
    }

    @Test
    public void shouldParkTheCarInTheFirstAvailableLot() throws CannotParkException, CarNotPresentException {
        attendant.add(parkingLot);
        ParkingLot parkingLot1 = new ParkingLot(1);
        attendant.add(parkingLot1);
        Object token = attendant.park(car);
        assertEquals(parkingLot.unpark(token),car);
    }

    @Test(expected = CarNotPresentException.class)
    public void shouldNotParkTheCarOtherThanFirstAvailableLot() throws CannotParkException, CarNotPresentException {
        attendant.add(parkingLot);
        ParkingLot parkingLot1 = new ParkingLot(1);
        attendant.add(parkingLot1);
        Object token = attendant.park(car);
        parkingLot1.unpark(token);
    }

    @Test
    public void shouldParkTheCarToTheHighestCapacityLot() throws CannotParkException {
        attendant.add(new ParkingLot(1));
        ParkingLot maxCapacityParkingLot = new ParkingLot(3);
        attendant.add(maxCapacityParkingLot);
        attendant.add(new ParkingLot(2));
        Object token = attendant.park(new TestCar());
        assertTrue(maxCapacityParkingLot.hasCar(token));
    }

    @Test
    public void name() throws CannotParkException {
        attendant.add(new ParkingLot(2));
        attendant.add(new ParkingLot(1));
        attendant.park(new TestCar());
        attendant.park(new TestCar());
        attendant.park(new TestCar());

    }
}
