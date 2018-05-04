package com.thoughtworks.Measurement;


//Ensures correctness of com.thoughtworks.Measurement.Measurement as per provided unit

import org.junit.Test;

import static com.thoughtworks.Measurement.Unit.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MeasurementTest {


    @Test
    public void ShouldCompareHundredCelsiusWithTwoTwelveFahrenheit() throws IncompatibleMeasurementTypeException {
        Measurement hundredCelsius = Measurement.inCelsius(100);
        Measurement twoTwelveF = Measurement.inFahrenheit(212);
        assertNotEquals(hundredCelsius.hashCode(),twoTwelveF.hashCode());
    }

    @Test
    public void ShouldCompareUnitsOfTemperature() throws IncompatibleMeasurementTypeException {
        Measurement hundredCelsius = Measurement.inCelsius(100);
        Measurement twoTwelve = Measurement.inFahrenheit(212);
        assertTrue(hundredCelsius.toUnit(FAHRENHEIT).strictEquals(twoTwelve));
    }
}


