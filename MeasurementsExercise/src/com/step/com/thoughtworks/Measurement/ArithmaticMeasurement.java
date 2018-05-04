package com.thoughtworks.Measurement;

public class ArithmaticMeasurement extends Measurement {


    public ArithmaticMeasurement(Unit unit, float value) {
        super(unit,value);
    }

    public static ArithmaticMeasurement inInches(float value) {
        return new ArithmaticMeasurement(Unit.INCHES, value);
    }

    public static ArithmaticMeasurement inFeet(float value) {
        return new ArithmaticMeasurement(Unit.FEET, value);
    }

    public static ArithmaticMeasurement inCentimeter(float value) {
        return new ArithmaticMeasurement(Unit.CM, value);
    }

    public static ArithmaticMeasurement inMilimeter(float value) {
        return new ArithmaticMeasurement(Unit.MM, value);
    }

    public static ArithmaticMeasurement inGallon(float value) {
        return new ArithmaticMeasurement(Unit.GALLON, value);
    }

    public static ArithmaticMeasurement inLiter(float value) {
        return new ArithmaticMeasurement(Unit.LITER, value);
    }

    public static ArithmaticMeasurement inKg(float value) {
        return new ArithmaticMeasurement(Unit.KG, value);
    }

    public static ArithmaticMeasurement inGrams(float value) {
        return new ArithmaticMeasurement(Unit.GRAMS, value);
    }

    public static ArithmaticMeasurement inTon(float value) {
        return new ArithmaticMeasurement(Unit.TON, value);
    }

    @Override
    protected ArithmaticMeasurement toUnit(Unit unit) throws IncompatibleMeasurementTypeException {
        Measurement measurement = super.toUnit(unit);
        return new ArithmaticMeasurement(measurement.unit,measurement.value);
    }

    public ArithmaticMeasurement add(ArithmaticMeasurement arithmaticMeasurement) throws IncompatibleMeasurementTypeException {
        if (!isOfSameType(arithmaticMeasurement)) throw new IncompatibleMeasurementTypeException("Invalid arithmaticMeasurement type to add");
        float newValue = value + arithmaticMeasurement.unit.toUnit(unit, arithmaticMeasurement.value);
        float result = Math.round(newValue * 100) / 100f;
        return new ArithmaticMeasurement(unit, result);
    }

}
