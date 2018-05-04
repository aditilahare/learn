package com.thoughtworks.Measurement;

import org.junit.Test;

import static com.thoughtworks.Measurement.Unit.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class UnitTest {

    @Test
    public void shouldConvertTemperatureUnits() {
        assertThat(CELSIUS.toUnit(FAHRENHEIT, 100),is(212f));
        assertThat(FAHRENHEIT.toUnit(CELSIUS, 212),is(100f));
    }
}

