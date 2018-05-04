package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AttendantTest {

    private class TestCar implements Vehicle {}
    private TestCar car;
    private Attendant attendant;
    private ParkingLot parkingLot;

    @Before
    public void setUp() {
        attendant = new Attendant();
        car = new TestCar();
        parkingLot = new ParkingLot(2,new Event());

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
        attendant.add(new ParkingLot(2,new Event()));
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
        attendant.add(new ParkingLot(2,new Event()));
        attendant.park(new TestCar());
        attendant.park(new TestCar());
        attendant.park(new TestCar());
        attendant.park(new TestCar());
        attendant.park(new TestCar());
    }

    @Test
    public void shouldUnparkTheGivenCar() throws CannotParkException, CarNotPresentException {
        attendant.add(new ParkingLot(2,new Event()));
        Object parkingToken = attendant.park(car);
        assertThat(attendant.unPark(parkingToken),is(car));
    }
}
