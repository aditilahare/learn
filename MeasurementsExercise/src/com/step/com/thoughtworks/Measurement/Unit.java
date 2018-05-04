package com.thoughtworks.Measurement;

import static com.thoughtworks.Measurement.MeasurementTypes.*;

import java.util.Objects;

public enum Unit {
    INCHES(1.0f, LENGTH), CM(0.4f, LENGTH), FEET(12.0f, LENGTH), MM(0.04f, LENGTH),
    GALLON(3.78f, VOLUME), LITER(1, VOLUME),
    KG(1000, WEIGHT), GRAMS(1, WEIGHT), TON(1000000, WEIGHT),
    CELSIUS(1, -273f, TEMPERATURE), FAHRENHEIT(5f/9f, -459.4f, TEMPERATURE);

    private final float conversionFactor;
    private float offset = 0;
    private final MeasurementTypes type;

    Unit(float conversionFactor, MeasurementTypes unitType) {
        this.conversionFactor = conversionFactor;
        this.type = unitType;
    }

    Unit(float conversionFactor, float offset, MeasurementTypes unitType) {
        this(conversionFactor,unitType);
        this.offset = offset;
    }


    private float toBaseValue(float value) {
        return Math.round(value * conversionFactor * 100) / 100;
    }

    public boolean isSameType(Unit unit) {
        return type == unit.type;
    }

    public int hash(float value) {
        return Objects.hash(type, toBaseValue(value));
    }

    public float toUnit(Unit targetUnit, float ownValue) {
        float result = ((ownValue - this.offset)* conversionFactor)/targetUnit.conversionFactor + targetUnit.offset;
        return  Math.round(result * 100)/100f;
    }
}




