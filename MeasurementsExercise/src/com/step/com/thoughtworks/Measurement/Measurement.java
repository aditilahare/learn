package com.thoughtworks.Measurement;

import java.util.Objects;

public class Measurement {
    protected final float value;
    protected final Unit unit;

    protected Measurement(Unit unit, float value) {
        this.unit = unit;
        this.value = value;
    }

    public static Measurement inCelsius(float value) {
        return new Measurement(Unit.CELSIUS, value);
    }

    public static Measurement inFahrenheit(float value) {
        return new Measurement(Unit.FAHRENHEIT, value);
    }

//    private boolean compareBaseValue(Measurement targetMeasurement) {
//        return Float.compare(this.unit.toUnit(targetMeasurement.unit, this.value), targetMeasurement.value) == 0;
//    }

    protected boolean isOfSameType(Measurement measurement) {
        return unit.isSameType(measurement.unit);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Measurement targetMeasurement = (Measurement) other;
        if (!isOfSameType(targetMeasurement)) {
            IncompatibleMeasurementTypeException e = new IncompatibleMeasurementTypeException("Incompatible measurement type for comparison");
            e.printStackTrace();
            return false;
        }
        boolean result = Float.compare(value, targetMeasurement.unit.toUnit(unit, targetMeasurement.value))==0;
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit.hash(value));
    }

    @Override
    public String toString() {
        return "com.thoughtworks.Measurement.Measurement{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }


    protected boolean strictEquals(Measurement measurement) {
        return value == measurement.value && unit == measurement.unit;
    }


    protected Measurement toUnit(Unit unit) throws IncompatibleMeasurementTypeException {
        if(!this.unit.isSameType(unit)) throw new IncompatibleMeasurementTypeException("Cannot convert " + this.unit +" into "+ unit);
        float convertedValue = this.unit.toUnit(unit, value);
        return new Measurement(unit, convertedValue);
    }

}
